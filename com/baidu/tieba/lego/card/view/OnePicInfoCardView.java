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
    private LinearLayout gFe;
    private ViewGroup gJp;
    private LineCountNotifyTextView gJq;
    private TextView gJr;
    private LinearLayout gJs;
    private TbImageView gJt;
    private TextView gJu;
    private TbImageView gJv;
    private TextView gJw;
    private int gJx;
    private int gJy;

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gJx = 0;
        this.gJy = -1;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.gJp = (ViewGroup) LayoutInflater.from(getContext()).inflate(d.h.card_one_pic_info, (ViewGroup) null);
        this.dfm = (TbImageView) A(this.gJp, d.g.img);
        this.gJq = (LineCountNotifyTextView) A(this.gJp, d.g.one_title);
        this.gJr = (TextView) A(this.gJp, d.g.discription);
        View view = (View) A(this.gJp, d.g.hot_thread_comment);
        this.eqw = (TextView) A(view, d.g.hot_thread_line_tag);
        this.gJs = (LinearLayout) A(view, d.g.ll_left);
        this.gJt = (TbImageView) A(view, d.g.iconLeft);
        this.gJu = (TextView) A(view, d.g.textLeft);
        this.gFe = (LinearLayout) A(view, d.g.ll_right);
        this.gJv = (TbImageView) A(view, d.g.iconRight);
        this.gJw = (TextView) A(view, d.g.textRight);
        return this.gJp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(OnePicInfoCard onePicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.mContext, getRootView());
        al.k(this.gJp, d.f.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        al.j(this.eqw, d.C0236d.cp_cont_g);
        al.j(this.gJu, d.C0236d.cp_cont_e);
        al.j(this.gJw, d.C0236d.cp_cont_e);
        if (this.gJx != 0 && this.gJq != null) {
            al.d(this.gJq, this.gJx, 1);
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
            this.gJq.setText(onePicInfoCard.getCardTitle());
            this.gJq.setGetLineCountCallback(new LineCountNotifyTextView.a() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.1
                @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
                public void aqX() {
                    int lineCount = OnePicInfoCardView.this.gJq.getLineCount();
                    if (OnePicInfoCardView.this.gJy != lineCount) {
                        if (lineCount == 1) {
                            OnePicInfoCardView.this.gJr.setMaxLines(2);
                        } else {
                            OnePicInfoCardView.this.gJr.setMaxLines(1);
                        }
                    }
                    OnePicInfoCardView.this.gJy = lineCount;
                    OnePicInfoCardView.this.gJr.setText(onePicInfoCard.getDesc());
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
            this.gJs.setVisibility(8);
            this.gFe.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.gJs.setVisibility(0);
                a(this.gJu, this.gJt, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.gFe.setVisibility(0);
                a(this.gJw, this.gJv, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.gJs.setVisibility(8);
            this.gFe.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.CP(String.valueOf(onePicInfoCard.getItemId()))) {
            this.gJx = d.C0236d.cp_cont_c;
        } else {
            this.gJx = d.C0236d.cp_cont_b;
        }
        al.d(this.gJq, this.gJx, 1);
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnePicInfoCardView.this.d(onePicInfoCard);
            }
        });
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.gHc : bVar.url;
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
