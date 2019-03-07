package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
/* loaded from: classes2.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    private TbImageView dfm;
    private TextView eqw;
    private LinearLayout gFd;
    private ViewGroup gJo;
    private LineCountNotifyTextView gJp;
    private TextView gJq;
    private LinearLayout gJr;
    private TbImageView gJs;
    private TextView gJt;
    private TbImageView gJu;
    private TextView gJv;
    private int gJw;
    private int gJx;

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gJw = 0;
        this.gJx = -1;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gJo = (ViewGroup) LayoutInflater.from(getContext()).inflate(d.h.card_one_pic_info, (ViewGroup) null);
        this.dfm = (TbImageView) A(this.gJo, d.g.img);
        this.gJp = (LineCountNotifyTextView) A(this.gJo, d.g.one_title);
        this.gJq = (TextView) A(this.gJo, d.g.discription);
        View view = (View) A(this.gJo, d.g.hot_thread_comment);
        this.eqw = (TextView) A(view, d.g.hot_thread_line_tag);
        this.gJr = (LinearLayout) A(view, d.g.ll_left);
        this.gJs = (TbImageView) A(view, d.g.iconLeft);
        this.gJt = (TextView) A(view, d.g.textLeft);
        this.gFd = (LinearLayout) A(view, d.g.ll_right);
        this.gJu = (TbImageView) A(view, d.g.iconRight);
        this.gJv = (TextView) A(view, d.g.textRight);
        return this.gJo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(OnePicInfoCard onePicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.gJo, d.f.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        al.j(this.eqw, d.C0236d.cp_cont_g);
        al.j(this.gJt, d.C0236d.cp_cont_e);
        al.j(this.gJv, d.C0236d.cp_cont_e);
        if (this.gJw != 0 && this.gJp != null) {
            al.d(this.gJp, this.gJw, 1);
        }
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        if (this.eqw != null) {
            if (onePicInfoCard != null && !com.baidu.tieba.lego.card.d.a.uP(onePicInfoCard.gettBgColor()) && !com.baidu.tieba.lego.card.d.a.uP(onePicInfoCard.gettBgColorN())) {
                this.eqw.setBackgroundColor(isNightMode() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
            } else {
                al.k(this.eqw, d.f.label_bg_tie_n);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final OnePicInfoCard onePicInfoCard) {
        String str = null;
        if (!TextUtils.isEmpty(onePicInfoCard.getPic())) {
            str = onePicInfoCard.getPic();
        }
        this.dfm.startLoad(str, 10, false);
        if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
            this.gJp.setText(onePicInfoCard.getCardTitle());
            this.gJp.setGetLineCountCallback(new LineCountNotifyTextView.a() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.1
                @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
                public void aqW() {
                    int lineCount = OnePicInfoCardView.this.gJp.getLineCount();
                    if (OnePicInfoCardView.this.gJx != lineCount) {
                        if (lineCount == 1) {
                            OnePicInfoCardView.this.gJq.setMaxLines(2);
                        } else {
                            OnePicInfoCardView.this.gJq.setMaxLines(1);
                        }
                    }
                    OnePicInfoCardView.this.gJx = lineCount;
                    OnePicInfoCardView.this.gJq.setText(onePicInfoCard.getDesc());
                }
            });
        }
        if (StringUtils.isNull(onePicInfoCard.getTag())) {
            this.eqw.setVisibility(8);
        } else {
            this.eqw.setVisibility(0);
            setTagBg(onePicInfoCard);
            this.eqw.setText(onePicInfoCard.getTag());
        }
        if (onePicInfoCard.getIconList() != null) {
            this.gJr.setVisibility(8);
            this.gFd.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.gJr.setVisibility(0);
                a(this.gJt, this.gJs, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.gFd.setVisibility(0);
                a(this.gJv, this.gJu, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.gJr.setVisibility(8);
            this.gFd.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.CO(String.valueOf(onePicInfoCard.getItemId()))) {
            this.gJw = d.C0236d.cp_cont_c;
        } else {
            this.gJw = d.C0236d.cp_cont_b;
        }
        al.d(this.gJp, this.gJw, 1);
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnePicInfoCardView.this.d(onePicInfoCard);
            }
        });
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.gHb : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(com.baidu.tieba.lego.card.f.hu(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        try {
            textView.setText(ap.as(Long.parseLong(bVar.content)));
        } catch (NumberFormatException e) {
            textView.setText(bVar.content);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void f(OnePicInfoCard onePicInfoCard) {
        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) onePicInfoCard).di("obj_url", onePicInfoCard.getScheme()).bb("obj_locate", getStatPosition()).a(onePicInfoCard);
        super.f(onePicInfoCard);
    }
}
