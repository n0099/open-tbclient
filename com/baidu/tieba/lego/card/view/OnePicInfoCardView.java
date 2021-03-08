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
/* loaded from: classes8.dex */
public class OnePicInfoCardView extends BaseCardView<OnePicInfoCard> {
    private TbImageView gHu;
    private TextView iEj;
    private LinearLayout lcl;
    private ViewGroup lgp;
    private LineCountNotifyTextView lgq;
    private TextView lgr;
    private LinearLayout lgs;
    private TbImageView lgt;
    private TextView lgu;
    private TbImageView lgv;
    private TextView lgw;
    private int lgx;
    private int lgy;

    public OnePicInfoCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lgx = 0;
        this.lgy = -1;
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.lgp = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.card_one_pic_info, (ViewGroup) null);
        this.gHu = (TbImageView) z(this.lgp, R.id.img);
        this.lgq = (LineCountNotifyTextView) z(this.lgp, R.id.one_title);
        this.lgr = (TextView) z(this.lgp, R.id.discription);
        View view = (View) z(this.lgp, R.id.hot_thread_comment);
        this.iEj = (TextView) z(view, R.id.hot_thread_line_tag);
        this.lgs = (LinearLayout) z(view, R.id.ll_left);
        this.lgt = (TbImageView) z(view, R.id.iconLeft);
        this.lgu = (TextView) z(view, R.id.textLeft);
        this.lcl = (LinearLayout) z(view, R.id.ll_right);
        this.lgv = (TbImageView) z(view, R.id.iconRight);
        this.lgw = (TextView) z(view, R.id.textRight);
        return this.lgp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(OnePicInfoCard onePicInfoCard, int i) {
        com.baidu.tbadk.r.a.a(this.eWx, getRootView());
        ap.setBackgroundResource(this.lgp, R.drawable.addresslist_item_bg);
        setTagBg(onePicInfoCard);
        ap.setViewTextColor(this.iEj, R.color.CAM_X0111);
        ap.setViewTextColor(this.lgu, R.color.CAM_X0110);
        ap.setViewTextColor(this.lgw, R.color.CAM_X0110);
        if (this.lgx != 0 && this.lgq != null) {
            ap.setViewTextColor(this.lgq, this.lgx, 1);
        }
    }

    private void setTagBg(OnePicInfoCard onePicInfoCard) {
        if (this.iEj != null) {
            if (onePicInfoCard != null && !com.baidu.tieba.lego.card.c.b.DW(onePicInfoCard.gettBgColor()) && !com.baidu.tieba.lego.card.c.b.DW(onePicInfoCard.gettBgColorN())) {
                this.iEj.setBackgroundColor(isNightMode() ? onePicInfoCard.gettBgColorN() : onePicInfoCard.gettBgColor());
            } else {
                ap.setBackgroundResource(this.iEj, R.drawable.label_bg_tie_n);
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
        this.gHu.startLoad(str, 10, false);
        if (!StringUtils.isNull(onePicInfoCard.getCardTitle())) {
            this.lgq.setText(onePicInfoCard.getCardTitle());
            this.lgq.setGetLineCountCallback(new LineCountNotifyTextView.a() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.1
                @Override // com.baidu.tbadk.widget.LineCountNotifyTextView.a
                public void bGf() {
                    int lineCount = OnePicInfoCardView.this.lgq.getLineCount();
                    if (OnePicInfoCardView.this.lgy != lineCount) {
                        if (lineCount == 1) {
                            OnePicInfoCardView.this.lgr.setMaxLines(2);
                        } else {
                            OnePicInfoCardView.this.lgr.setMaxLines(1);
                        }
                    }
                    OnePicInfoCardView.this.lgy = lineCount;
                    OnePicInfoCardView.this.lgr.setText(onePicInfoCard.getDesc());
                }
            });
        }
        if (StringUtils.isNull(onePicInfoCard.getTag())) {
            this.iEj.setVisibility(8);
        } else {
            this.iEj.setVisibility(0);
            setTagBg(onePicInfoCard);
            this.iEj.setText(onePicInfoCard.getTag());
        }
        if (onePicInfoCard.getIconList() != null) {
            this.lgs.setVisibility(8);
            this.lcl.setVisibility(8);
            if (onePicInfoCard.getIconList().size() > 0) {
                this.lgs.setVisibility(0);
                a(this.lgu, this.lgt, onePicInfoCard.getIconList().get(0));
            }
            if (onePicInfoCard.getIconList().size() > 1) {
                this.lcl.setVisibility(0);
                a(this.lgw, this.lgv, onePicInfoCard.getIconList().get(1));
            }
        } else {
            this.lgs.setVisibility(8);
            this.lcl.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
        if (readThreadHistory != null && readThreadHistory.TT(String.valueOf(onePicInfoCard.getItemId()))) {
            this.lgx = R.color.CAM_X0108;
        } else {
            this.lgx = R.color.CAM_X0105;
        }
        ap.setViewTextColor(this.lgq, this.lgx, 1);
        setCardOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.OnePicInfoCardView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OnePicInfoCardView.this.c((OnePicInfoCardView) onePicInfoCard);
            }
        });
    }

    private void a(TextView textView, TbImageView tbImageView, com.baidu.tieba.lego.card.model.b bVar) {
        String str = isNightMode() ? bVar.lee : bVar.url;
        if (!TextUtils.isEmpty(str)) {
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            tbImageView.setVisibility(0);
            tbImageView.startLoad(str, 10, false);
        } else {
            tbImageView.setVisibility(8);
            textView.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(com.baidu.tieba.lego.card.f.oB(bVar.type)), (Drawable) null, (Drawable) null, (Drawable) null);
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
