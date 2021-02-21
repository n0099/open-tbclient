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
import com.baidu.tieba.recapp.s;
/* loaded from: classes9.dex */
public class LPBigImgCardView extends BaseCardView<LPBigImgCard> {
    private RelativeLayout ikz;
    private final int lcH;
    private TbImageView leh;
    private TbImageView lei;
    private TextView lej;
    private int picHeight;

    public LPBigImgCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lcH = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.ikz = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.card_bigimg, (ViewGroup) null);
        this.leh = (TbImageView) z(this.ikz, R.id.tb_img_background);
        this.lei = (TbImageView) z(this.ikz, R.id.tb_img_button);
        this.lej = (TextView) z(this.ikz, R.id.tv_button);
        return this.ikz;
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
            this.picHeight = (int) ((lPBigImgCard.getPicHeight() / lPBigImgCard.getPicWidth()) * this.lcH);
            A(this.leh, this.picHeight);
            if (!TextUtils.isEmpty(lPBigImgCard.getPicUrl())) {
                this.leh.a(lPBigImgCard.getPicUrl(), 17, this.lcH, this.picHeight, false);
            } else {
                e(this.leh, lPBigImgCard.getBgColor(), lPBigImgCard.getBgColorNight(), R.color.CAM_X0201);
            }
            int i3 = this.picHeight;
            if (!TextUtils.isEmpty(lPBigImgCard.getBtnImgUrl()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight = lPBigImgCard.getBtnHeight();
                q(this.lei, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                this.lei.startLoad(lPBigImgCard.getBtnImgUrl(), 17, false);
                int btnPosRatio = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight * 0.5d));
                if (btnPosRatio < 0) {
                    i2 = 0;
                } else {
                    i2 = btnPosRatio > i3 - btnHeight ? i3 - btnHeight : btnPosRatio;
                }
                ((RelativeLayout.LayoutParams) this.lei.getLayoutParams()).topMargin = i2;
                this.lei.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsV().b(LPBigImgCardView.this.eUY, new String[]{lPBigImgCard.getBtnLink()});
                        s.dDt().dDp().ei(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.lei.setVisibility(0);
                this.lej.setVisibility(8);
            } else if (!TextUtils.isEmpty(lPBigImgCard.getBtnText()) && lPBigImgCard.getBtnWidth() > 0 && lPBigImgCard.getBtnHeight() > 0) {
                int btnHeight2 = lPBigImgCard.getBtnHeight();
                this.lej.setText(lPBigImgCard.getBtnText());
                q(this.lej, lPBigImgCard.getBtnWidth(), lPBigImgCard.getBtnHeight());
                a(this.lej, lPBigImgCard.getBtnColor(), lPBigImgCard.getBtnColorNight(), R.color.black_alpha100);
                int btnPosRatio2 = (int) ((i3 * lPBigImgCard.getBtnPosRatio()) - (btnHeight2 * 0.5d));
                if (btnPosRatio2 < 0) {
                    i = 0;
                } else {
                    i = btnPosRatio2 > i3 - btnHeight2 ? i3 - btnHeight2 : btnPosRatio2;
                }
                ((RelativeLayout.LayoutParams) this.lej.getLayoutParams()).topMargin = i;
                this.lej.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.LPBigImgCardView.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        bf.bsV().b(LPBigImgCardView.this.eUY, new String[]{lPBigImgCard.getBtnLink()});
                        s.dDt().dDp().ei(lPBigImgCard.getsExtras(), LPBigImgCardView.this.mFrom);
                    }
                });
                this.lej.setVisibility(0);
                this.lei.setVisibility(8);
            } else {
                this.lej.setVisibility(8);
                this.lei.setVisibility(8);
            }
            if (!lPBigImgCard.mHasShown) {
                s.dDt().dDp().eh(lPBigImgCard.getShowExtra(), this.mFrom);
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
        layoutParams.width = this.lcH;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    private int Ee(int i) {
        return com.baidu.adp.lib.util.l.dip2px(this.eUY.getPageActivity(), (int) (i / 2.0d));
    }
}
