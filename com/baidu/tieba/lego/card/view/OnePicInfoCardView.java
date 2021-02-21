package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.LineCountNotifyTextView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.BaseLegoCardInfo;
import com.baidu.tieba.lego.card.model.OnePicInfoCard;
/* loaded from: classes9.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    private TbImageView gFL;
    private TextView iCA;
    private LinearLayout lai;
    private ViewGroup lem;
    private LineCountNotifyTextView leo;
    private TextView lep;
    private LinearLayout leq;
    private TbImageView ler;
    private TextView les;
    private TbImageView let;
    private TextView leu;
    private int lev;
    private int lew;

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lev = 0;
        this.lew = -1;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.lem = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
        this.gFL = (TbImageView) z(this.lem, R.id.img);
        this.leo = (LineCountNotifyTextView) z(this.lem, R.id.one_title);
        this.lep = (TextView) z(this.lem, R.id.discription);
        View view = (View) z(this.lem, R.id.hot_thread_comment);
        this.iCA = (TextView) z(view, R.id.hot_thread_line_tag);
        this.leq = (LinearLayout) z(view, R.id.ll_left);
        this.ler = (TbImageView) z(view, R.id.iconLeft);
        this.les = (TextView) z(view, R.id.textLeft);
        this.lai = (LinearLayout) z(view, R.id.ll_right);
        this.let = (TbImageView) z(view, R.id.iconRight);
        this.leu = (TextView) z(view, R.id.textRight);
        return this.lem;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(OnePicInfoCard onePicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eUY, getRootView());
        ap.setBackgroundResource(this.lem, R.drawable.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        ap.setViewTextColor(this.iCA, R.color.CAM_X0111);
        ap.setViewTextColor(this.les, R.color.CAM_X0110);
        ap.setViewTextColor(this.leu, R.color.CAM_X0110);
        if (this.lev != 0 && this.leo != null) {
            ap.setViewTextColor(this.leo, this.lev, 1);
        }
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        if (this.iCA != null) {
            if (onePicInfoCard != null && !com.baidu.tieba.lego.card.c.b.DT(onePicInfoCard.gettBgColor()) && !com.baidu.tieba.lego.card.c.b.DT(onePicInfoCard.gettBgColorN())) {
                this.iCA.setBackgroundColor(isNightMode() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
            } else {
                ap.setBackgroundResource(this.iCA, R.drawable.label_bg_tie_n);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final OnePicInfoCard onePicInfoCard) {
        String str = null;
        if (!TextUtils.isEmpty(onePicInfoCard.getPic())) {
            str = onePicInfoCard.getPic();
        }
        this.gFL.startLoad(str, 10, false);
        if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
            this.leo.setText(onePicInfoCard.getCardTitle());
            this.leo.setGetLineCountCallback(new LineCountNotifyTextView.a() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.1
                @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
                public void bGb() {
                    int lineCount = OnePicInfoCardView.this.leo.getLineCount();
                    if (OnePicInfoCardView.this.lew != lineCount) {
                        if (lineCount == 1) {
                            OnePicInfoCardView.this.lep.setMaxLines(2);
                        } else {
                            OnePicInfoCardView.this.lep.setMaxLines(1);
                        }
                    }
                    OnePicInfoCardView.this.lew = lineCount;
                    OnePicInfoCardView.this.lep.setText(onePicInfoCard.getDesc());
                }
            });
        }
        if (StringUtils.isNull(onePicInfoCard.getTag())) {
            this.iCA.setVisibility(8);
        } else {
            this.iCA.setVisibility(0);
            setTagBg(onePicInfoCard);
            this.iCA.setText(onePicInfoCard.getTag());
        }
        if (onePicInfoCard.getIconList() != null) {
            this.leq.setVisibility(8);
            this.lai.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.leq.setVisibility(0);
                a(this.les, this.ler, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.lai.setVisibility(0);
                a(this.leu, this.let, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.leq.setVisibility(8);
            this.lai.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.TM(String.valueOf(onePicInfoCard.getItemId()))) {
            this.lev = R.color.CAM_X0108;
        } else {
            this.lev = R.color.CAM_X0105;
        }
        ap.setViewTextColor(this.leo, this.lev, 1);
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnePicInfoCardView.this.c((OnePicInfoCardView) onePicInfoCard);
            }
        });
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.lcb : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(com.baidu.tieba.lego.card.f.oA(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        try {
            textView.setText(au.numberUniformFormat(Long.parseLong(bVar.content)));
        } catch (NumberFormatException e) {
            textView.setText(bVar.content);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: b */
    public void e(OnePicInfoCard onePicInfoCard) {
        com.baidu.tieba.lego.i.a((BaseLegoCardInfo) onePicInfoCard).fF(TiebaInitialize.Params.OBJ_URL, onePicInfoCard.getScheme()).bA("obj_locate", getStatPosition()).a(onePicInfoCard);
        super.e(onePicInfoCard);
    }
}
