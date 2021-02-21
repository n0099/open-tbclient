package com.baidu.tieba.lego.card.view;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.tieba.lego.card.model.ButtonCard;
import com.baidu.tieba.recapp.s;
/* loaded from: classes9.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    private RelativeLayout lcC;
    private TbImageView lcD;
    private Button lcE;
    private int lcF;
    private int lcG;
    private final int lcH;

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lcF = -1;
        this.lcG = -1;
        this.lcH = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbV() {
        this.lcC = (RelativeLayout) LayoutInflater.from(this.eUY.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
        this.lcE = (Button) this.lcC.findViewById(R.id.bt_phone);
        this.lcD = (TbImageView) this.lcC.findViewById(R.id.tb_phone_background);
        return this.lcC;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(ButtonCard buttonCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void d(final ButtonCard buttonCard) {
        if (buttonCard != null) {
            reset();
            float cardWidth = (float) ((this.lcH * 1.0d) / buttonCard.getCardWidth());
            ViewGroup.LayoutParams layoutParams = this.lcC.getLayoutParams();
            layoutParams.width = this.lcH;
            layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
            this.lcC.setLayoutParams(layoutParams);
            int bgColor = buttonCard.getBgColor();
            this.lcD.setDefaultBgResource(R.color.transparent);
            if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
                this.lcD.startLoad(buttonCard.getPicUrl(), 17, false);
            } else if (!com.baidu.tieba.lego.card.c.b.DT(bgColor)) {
                this.lcD.setBackgroundColor(bgColor);
            } else {
                this.lcD.setDefaultBgResource(R.color.transparent);
            }
            int dimension = layoutParams.height - ((int) (cardWidth * TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40)));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lcE.getLayoutParams();
            layoutParams2.height = dimension;
            layoutParams2.addRule(13);
            this.lcE.setText(buttonCard.getText());
            this.lcE.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            int textColor = buttonCard.getTextColor();
            if (!com.baidu.tieba.lego.card.c.b.DT(textColor)) {
                this.lcE.setTextColor(textColor);
            }
            this.lcE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ButtonCardView.this.setDialog(buttonCard);
                    s.dDt().dDp().ei(buttonCard.getsExtras(), ButtonCardView.this.mFrom);
                }
            });
            this.lcF = buttonCard.getStyle();
            int buttonColor = buttonCard.getButtonColor();
            switch (this.lcF) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    if (!com.baidu.tieba.lego.card.c.b.DT(buttonColor)) {
                        gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
                    }
                    gradientDrawable.setColor(0);
                    this.lcE.setBackgroundDrawable(gradientDrawable);
                    break;
                case 2:
                    if (!com.baidu.tieba.lego.card.c.b.DT(buttonColor)) {
                        this.lcE.setBackgroundColor(buttonColor);
                        break;
                    } else {
                        this.lcE.setBackgroundColor(0);
                        break;
                    }
                default:
                    this.lcE.setBackgroundColor(0);
                    break;
            }
            if (!LegoListFragment.lbg.contains(buttonCard.toString())) {
                LegoListFragment.lbg.add(buttonCard.toString());
                s.dDt().dDp().eh(buttonCard.getShowExtra(), this.mFrom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(final ButtonCard buttonCard) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eUY.getPageActivity());
        aVar.Au("是否拨打电话:" + buttonCard.getPhoneNumber());
        aVar.a(R.string.call, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                bf.bsV().b(ButtonCardView.this.eUY, new String[]{buttonCard.getBtnScheme()});
                s.dDt().dDp().at(ButtonCardView.this.mFrom, "yes", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                s.dDt().dDp().at(ButtonCardView.this.mFrom, "no", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(this.eUY).bqx();
    }

    public void setBackgroundAlpha(float f) {
        if (this.lcD != null) {
            this.lcD.setAlpha(f);
        }
    }

    public void reset() {
        if (this.lcD != null) {
            this.lcD.setVisibility(0);
            this.lcD.setAlpha(1);
        }
    }
}
