package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.LPBigImgCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes8.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    private RelativeLayout ifw;
    private final int kUp;
    private TbImageView kVQ;
    private TbImageView kVR;
    private TextView kVS;
    private int picHeight;

    public LPBigImgCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kUp = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.ifw = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_bigimg, (ViewGroup) null);
        this.kVQ = (TbImageView) z(this.ifw, R.id.tb_img_background);
        this.kVR = (TbImageView) z(this.ifw, R.id.tb_img_button);
        this.kVS = (TextView) z(this.ifw, R.id.tv_button);
        return this.ifw;
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
            this.picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.kUp);
            A(this.kVQ, this.picHeight);
            if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
                this.kVQ.a(lPBigImgCard.getPicUrl(), 17, this.kUp, this.picHeight, false);
            } else {
                e(this.kVQ, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
            }
            int i3 = this.picHeight;
            if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight = lPBigImgCard.getBtnHeight();
                n(this.kVR, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                this.kVR.startLoad(lPBigImgCard.getBtnImgUrl(), 17, false);
                int btnPosRatio = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
                if (btnPosRatio < 0) {
                    i2 = 0;
                } else {
                    i2 = btnPosRatio > i3 - btnHeight ? i3 - btnHeight : btnPosRatio;
                }
                ((RelativeLayout.LayoutParams) this.kVR.getLayoutParams()).topMargin = i2;
                this.kVR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bsB().b(LPBigImgCardView.this.eSJ, new String[]{lPBigImgCard.getBtnLink()});
                        r.dBe().dBa().ek(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.kVR.setVisibility(0);
                this.kVS.setVisibility(8);
            } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight2 = lPBigImgCard.getBtnHeight();
                this.kVS.setText(lPBigImgCard.getBtnText());
                n(this.kVS, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                a(this.kVS, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
                int btnPosRatio2 = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
                if (btnPosRatio2 < 0) {
                    i = 0;
                } else {
                    i = btnPosRatio2 > i3 - btnHeight2 ? i3 - btnHeight2 : btnPosRatio2;
                }
                ((RelativeLayout.LayoutParams) this.kVS.getLayoutParams()).topMargin = i;
                this.kVS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        be.bsB().b(LPBigImgCardView.this.eSJ, new String[]{lPBigImgCard.getBtnLink()});
                        r.dBe().dBa().ek(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.kVS.setVisibility(0);
                this.kVR.setVisibility(8);
            } else {
                this.kVS.setVisibility(8);
                this.kVR.setVisibility(8);
            }
            if (!lPBigImgCard.mHasShown) {
                r.dBe().dBa().ej(lPBigImgCard.getShowExtra(), this.mFrom);
                lPBigImgCard.mHasShown = true;
            }
        }
    }

    private void n(View view, int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = DM(i2);
        layoutParams.width = DM(i);
        view.setLayoutParams(layoutParams);
    }

    private void A(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.width = this.kUp;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    private int DM(int i) {
        return com.baidu.adp.lib.util.l.dip2px(this.eSJ.getPageActivity(), (int) (i / 2.0d));
    }
}
