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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.tieba.lego.card.model.ButtonCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes9.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    private RelativeLayout kYP;
    private TbImageView kYQ;
    private Button kYR;
    private int kYS;
    private int kYT;
    private final int kYU;

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kYS = -1;
        this.kYT = -1;
        this.kYU = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View ddI() {
        this.kYP = (RelativeLayout) LayoutInflater.from(this.eXu.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
        this.kYR = (Button) this.kYP.findViewById(R.id.bt_phone);
        this.kYQ = (TbImageView) this.kYP.findViewById(R.id.tb_phone_background);
        return this.kYP;
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
            float cardWidth = (float) ((this.kYU * 1.0d) / buttonCard.getCardWidth());
            ViewGroup.LayoutParams layoutParams = this.kYP.getLayoutParams();
            layoutParams.width = this.kYU;
            layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
            this.kYP.setLayoutParams(layoutParams);
            int bgColor = buttonCard.getBgColor();
            this.kYQ.setDefaultBgResource(R.color.transparent);
            if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
                this.kYQ.startLoad(buttonCard.getPicUrl(), 17, false);
            } else if (!com.baidu.tieba.lego.card.c.b.Fh(bgColor)) {
                this.kYQ.setBackgroundColor(bgColor);
            } else {
                this.kYQ.setDefaultBgResource(R.color.transparent);
            }
            int dimension = layoutParams.height - ((int) (cardWidth * TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40)));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kYR.getLayoutParams();
            layoutParams2.height = dimension;
            layoutParams2.addRule(13);
            this.kYR.setText(buttonCard.getText());
            this.kYR.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            int textColor = buttonCard.getTextColor();
            if (!com.baidu.tieba.lego.card.c.b.Fh(textColor)) {
                this.kYR.setTextColor(textColor);
            }
            this.kYR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ButtonCardView.this.setDialog(buttonCard);
                    r.dEW().dES().el(buttonCard.getsExtras(), ButtonCardView.this.mFrom);
                }
            });
            this.kYS = buttonCard.getStyle();
            int buttonColor = buttonCard.getButtonColor();
            switch (this.kYS) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    if (!com.baidu.tieba.lego.card.c.b.Fh(buttonColor)) {
                        gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
                    }
                    gradientDrawable.setColor(0);
                    this.kYR.setBackgroundDrawable(gradientDrawable);
                    break;
                case 2:
                    if (!com.baidu.tieba.lego.card.c.b.Fh(buttonColor)) {
                        this.kYR.setBackgroundColor(buttonColor);
                        break;
                    } else {
                        this.kYR.setBackgroundColor(0);
                        break;
                    }
                default:
                    this.kYR.setBackgroundColor(0);
                    break;
            }
            if (!LegoListFragment.kXu.contains(buttonCard.toString())) {
                LegoListFragment.kXu.add(buttonCard.toString());
                r.dEW().dES().ek(buttonCard.getShowExtra(), this.mFrom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(final ButtonCard buttonCard) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eXu.getPageActivity());
        aVar.Bo("是否拨打电话:" + buttonCard.getPhoneNumber());
        aVar.a(R.string.call, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                be.bwv().b(ButtonCardView.this.eXu, new String[]{buttonCard.getBtnScheme()});
                r.dEW().dES().as(ButtonCardView.this.mFrom, "yes", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                r.dEW().dES().as(ButtonCardView.this.mFrom, "no", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(this.eXu).btY();
    }

    public void setBackgroundAlpha(float f) {
        if (this.kYQ != null) {
            this.kYQ.setAlpha(f);
        }
    }

    public void reset() {
        if (this.kYQ != null) {
            this.kYQ.setVisibility(0);
            this.kYQ.setAlpha(1);
        }
    }
}
