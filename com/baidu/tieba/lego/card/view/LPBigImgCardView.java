package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.LPBigImgCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes9.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    private RelativeLayout ikl;
    private final int lcs;
    private TbImageView ldT;
    private TbImageView ldU;
    private TextView ldV;
    private int picHeight;

    public LPBigImgCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lcs = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.ikl = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_bigimg, (ViewGroup) null);
        this.ldT = (TbImageView) z(this.ikl, R.id.tb_img_background);
        this.ldU = (TbImageView) z(this.ikl, R.id.tb_img_button);
        this.ldV = (TextView) z(this.ikl, R.id.tv_button);
        return this.ikl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(LPBigImgCard lPBigImgCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final LPBigImgCard lPBigImgCard) {
        int i;
        int i2;
        if (lPBigImgCard.getPicWidth() > 0 && lPBigImgCard.getPicHeight() > 0) {
            this.picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.lcs);
            A(this.ldT, this.picHeight);
            if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
                this.ldT.a(lPBigImgCard.getPicUrl(), 17, this.lcs, this.picHeight, false);
            } else {
                e(this.ldT, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
            }
            int i3 = this.picHeight;
            if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight = lPBigImgCard.getBtnHeight();
                q(this.ldU, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                this.ldU.startLoad(lPBigImgCard.getBtnImgUrl(), 17, false);
                int btnPosRatio = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
                if (btnPosRatio < 0) {
                    i2 = 0;
                } else {
                    i2 = btnPosRatio > i3 - btnHeight ? i3 - btnHeight : btnPosRatio;
                }
                ((RelativeLayout.LayoutParams) this.ldU.getLayoutParams()).topMargin = i2;
                this.ldU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsV().b(LPBigImgCardView.this.eUY, new String[]{lPBigImgCard.getBtnLink()});
                        r.dDm().dDi().ei(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.ldU.setVisibility(0);
                this.ldV.setVisibility(8);
            } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight2 = lPBigImgCard.getBtnHeight();
                this.ldV.setText(lPBigImgCard.getBtnText());
                q(this.ldV, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                a(this.ldV, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
                int btnPosRatio2 = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
                if (btnPosRatio2 < 0) {
                    i = 0;
                } else {
                    i = btnPosRatio2 > i3 - btnHeight2 ? i3 - btnHeight2 : btnPosRatio2;
                }
                ((RelativeLayout.LayoutParams) this.ldV.getLayoutParams()).topMargin = i;
                this.ldV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsV().b(LPBigImgCardView.this.eUY, new String[]{lPBigImgCard.getBtnLink()});
                        r.dDm().dDi().ei(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.ldV.setVisibility(0);
                this.ldU.setVisibility(8);
            } else {
                this.ldV.setVisibility(8);
                this.ldU.setVisibility(8);
            }
            if (!lPBigImgCard.mHasShown) {
                r.dDm().dDi().eh(lPBigImgCard.getShowExtra(), this.mFrom);
                lPBigImgCard.mHasShown = true;
            }
        }
    }

    private void q(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = Ee(i2);
        layoutParams.width = Ee(i);
        view.setLayoutParams(layoutParams);
    }

    private void A(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = this.lcs;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    private int Ee(int i) {
        return com.baidu.adp.lib.util.l.dip2px(this.eUY.getPageActivity(), (int) (i / 2.0d));
    }
}
