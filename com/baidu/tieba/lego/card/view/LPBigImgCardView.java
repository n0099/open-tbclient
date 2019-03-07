package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.card.model.LPBigImgCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes2.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    private final int gHF;
    private RelativeLayout gJi;
    private TbImageView gJj;
    private TbImageView gJk;
    private TextView gJl;
    private int picHeight;

    public LPBigImgCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHF = com.baidu.adp.lib.util.l.aO(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gJi = (RelativeLayout) LayoutInflater.from(getContext()).inflate(d.h.card_bigimg, (ViewGroup) null);
        this.gJj = (TbImageView) A(this.gJi, d.g.tb_img_background);
        this.gJk = (TbImageView) A(this.gJi, d.g.tb_img_button);
        this.gJl = (TextView) A(this.gJi, d.g.tv_button);
        return this.gJi;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(LPBigImgCard lPBigImgCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final LPBigImgCard lPBigImgCard) {
        int i;
        int i2;
        if (lPBigImgCard.getPicWidth() > 0 && lPBigImgCard.getPicHeight() > 0) {
            this.picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.gHF);
            B(this.gJj, this.picHeight);
            if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
                this.gJj.startLoad(lPBigImgCard.getPicUrl(), 17, this.gHF, this.picHeight, false);
            } else {
                e(this.gJj, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), d.C0236d.cp_bg_line_d);
            }
            int i3 = this.picHeight;
            if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight = lPBigImgCard.getBtnHeight();
                i(this.gJk, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                this.gJk.startLoad(lPBigImgCard.getBtnImgUrl(), 17, false);
                int btnPosRatio = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
                if (btnPosRatio < 0) {
                    i2 = 0;
                } else {
                    i2 = btnPosRatio > i3 - btnHeight ? i3 - btnHeight : btnPosRatio;
                }
                ((RelativeLayout.LayoutParams) this.gJk.getLayoutParams()).topMargin = i2;
                this.gJk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adD().c(LPBigImgCardView.this.mContext, new String[]{lPBigImgCard.getBtnLink()});
                        r.bWG().bWC().cb(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.gJk.setVisibility(0);
                this.gJl.setVisibility(8);
            } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight2 = lPBigImgCard.getBtnHeight();
                this.gJl.setText(lPBigImgCard.getBtnText());
                i(this.gJl, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                a(this.gJl, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), d.C0236d.cp_bg_line_k);
                int btnPosRatio2 = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
                if (btnPosRatio2 < 0) {
                    i = 0;
                } else {
                    i = btnPosRatio2 > i3 - btnHeight2 ? i3 - btnHeight2 : btnPosRatio2;
                }
                ((RelativeLayout.LayoutParams) this.gJl.getLayoutParams()).topMargin = i;
                this.gJl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ba.adD().c(LPBigImgCardView.this.mContext, new String[]{lPBigImgCard.getBtnLink()});
                        r.bWG().bWC().cb(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.gJl.setVisibility(0);
                this.gJk.setVisibility(8);
            } else {
                this.gJl.setVisibility(8);
                this.gJk.setVisibility(8);
            }
            if (!lPBigImgCard.mHasShown) {
                r.bWG().bWC().ca(lPBigImgCard.getShowExtra(), this.mFrom);
                lPBigImgCard.mHasShown = true;
            }
        }
    }

    private void i(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = uZ(i2);
        layoutParams.width = uZ(i);
        view.setLayoutParams(layoutParams);
    }

    private void B(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = this.gHF;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    private int uZ(int i) {
        return com.baidu.adp.lib.util.l.dip2px(this.mContext.getPageActivity(), (int) (i / 2.0d));
    }
}
