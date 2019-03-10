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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.tieba.lego.card.model.ButtonCard;
import com.baidu.tieba.recapp.r;
/* loaded from: classes2.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    private RelativeLayout gHB;
    private TbImageView gHC;
    private Button gHD;
    private int gHE;
    private int gHF;
    private final int gHG;

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHE = -1;
        this.gHF = -1;
        this.gHG = com.baidu.adp.lib.util.l.aO(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAe() {
        this.gHB = (RelativeLayout) LayoutInflater.from(this.mContext.getPageActivity().getApplicationContext()).inflate(d.h.card_button, (ViewGroup) null);
        this.gHD = (Button) this.gHB.findViewById(d.g.bt_phone);
        this.gHC = (TbImageView) this.gHB.findViewById(d.g.tb_phone_background);
        return this.gHB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public void a(ButtonCard buttonCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: a */
    public void e(final ButtonCard buttonCard) {
        if (buttonCard != null) {
            reset();
            float cardWidth = (float) ((this.gHG * 1.0d) / buttonCard.getCardWidth());
            ViewGroup.LayoutParams layoutParams = this.gHB.getLayoutParams();
            layoutParams.width = this.gHG;
            layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
            this.gHB.setLayoutParams(layoutParams);
            int bgColor = buttonCard.getBgColor();
            this.gHC.setDefaultBgResource(d.C0236d.transparent);
            if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
                this.gHC.startLoad(buttonCard.getPicUrl(), 17, false);
            } else if (!com.baidu.tieba.lego.card.d.a.uP(bgColor)) {
                this.gHC.setBackgroundColor(bgColor);
            } else {
                this.gHC.setDefaultBgResource(d.C0236d.transparent);
            }
            int dimension = layoutParams.height - ((int) (cardWidth * TbadkCoreApplication.getInst().getResources().getDimension(d.e.button_card_padding40)));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gHD.getLayoutParams();
            layoutParams2.height = dimension;
            layoutParams2.addRule(13);
            this.gHD.setText(buttonCard.getText());
            this.gHD.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
            int textColor = buttonCard.getTextColor();
            if (!com.baidu.tieba.lego.card.d.a.uP(textColor)) {
                this.gHD.setTextColor(textColor);
            }
            this.gHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ButtonCardView.this.setDialog(buttonCard);
                    r.bWH().bWD().cb(buttonCard.getsExtras(), ButtonCardView.this.mFrom);
                }
            });
            this.gHE = buttonCard.getStyle();
            int buttonColor = buttonCard.getButtonColor();
            switch (this.gHE) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    if (!com.baidu.tieba.lego.card.d.a.uP(buttonColor)) {
                        gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds3), buttonColor);
                    }
                    gradientDrawable.setColor(0);
                    this.gHD.setBackgroundDrawable(gradientDrawable);
                    break;
                case 2:
                    if (!com.baidu.tieba.lego.card.d.a.uP(buttonColor)) {
                        this.gHD.setBackgroundColor(buttonColor);
                        break;
                    } else {
                        this.gHD.setBackgroundColor(0);
                        break;
                    }
                default:
                    this.gHD.setBackgroundColor(0);
                    break;
            }
            if (!LegoListFragment.gGe.contains(buttonCard.toString())) {
                LegoListFragment.gGe.add(buttonCard.toString());
                r.bWH().bWD().ca(buttonCard.getShowExtra(), this.mFrom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(final ButtonCard buttonCard) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
        aVar.ly("是否拨打电话:" + buttonCard.getPhoneNumber());
        aVar.a(d.j.call, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                ba.adD().c(ButtonCardView.this.mContext, new String[]{buttonCard.getBtnScheme()});
                r.bWH().bWD().F(ButtonCardView.this.mFrom, "yes", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                r.bWH().bWD().F(ButtonCardView.this.mFrom, "no", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(this.mContext).aaZ();
    }

    public void setBackgroundAlpha(float f) {
        if (this.gHC != null) {
            this.gHC.setAlpha(f);
        }
    }

    public void reset() {
        if (this.gHC != null) {
            this.gHC.setVisibility(0);
            this.gHC.setAlpha(1);
        }
    }
}
