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
    private RelativeLayout gHA;
    private TbImageView gHB;
    private Button gHC;
    private int gHD;
    private int gHE;
    private final int gHF;

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gHD = -1;
        this.gHE = -1;
        this.gHF = com.baidu.adp.lib.util.l.aO(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View bAd() {
        this.gHA = (RelativeLayout) LayoutInflater.from(this.mContext.getPageActivity().getApplicationContext()).inflate(d.h.card_button, (ViewGroup) null);
        this.gHC = (Button) this.gHA.findViewById(d.g.bt_phone);
        this.gHB = (TbImageView) this.gHA.findViewById(d.g.tb_phone_background);
        return this.gHA;
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
            float cardWidth = (float) ((this.gHF * 1.0d) / buttonCard.getCardWidth());
            ViewGroup.LayoutParams layoutParams = this.gHA.getLayoutParams();
            layoutParams.width = this.gHF;
            layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
            this.gHA.setLayoutParams(layoutParams);
            int bgColor = buttonCard.getBgColor();
            this.gHB.setDefaultBgResource(d.C0236d.transparent);
            if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
                this.gHB.startLoad(buttonCard.getPicUrl(), 17, false);
            } else if (!com.baidu.tieba.lego.card.d.a.uP(bgColor)) {
                this.gHB.setBackgroundColor(bgColor);
            } else {
                this.gHB.setDefaultBgResource(d.C0236d.transparent);
            }
            int dimension = layoutParams.height - ((int) (cardWidth * TbadkCoreApplication.getInst().getResources().getDimension(d.e.button_card_padding40)));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gHC.getLayoutParams();
            layoutParams2.height = dimension;
            layoutParams2.addRule(13);
            this.gHC.setText(buttonCard.getText());
            this.gHC.setTextSize(0, getResources().getDimensionPixelSize(d.e.fontsize28));
            int textColor = buttonCard.getTextColor();
            if (!com.baidu.tieba.lego.card.d.a.uP(textColor)) {
                this.gHC.setTextColor(textColor);
            }
            this.gHC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ButtonCardView.this.setDialog(buttonCard);
                    r.bWG().bWC().cb(buttonCard.getsExtras(), ButtonCardView.this.mFrom);
                }
            });
            this.gHD = buttonCard.getStyle();
            int buttonColor = buttonCard.getButtonColor();
            switch (this.gHD) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    if (!com.baidu.tieba.lego.card.d.a.uP(buttonColor)) {
                        gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.ds3), buttonColor);
                    }
                    gradientDrawable.setColor(0);
                    this.gHC.setBackgroundDrawable(gradientDrawable);
                    break;
                case 2:
                    if (!com.baidu.tieba.lego.card.d.a.uP(buttonColor)) {
                        this.gHC.setBackgroundColor(buttonColor);
                        break;
                    } else {
                        this.gHC.setBackgroundColor(0);
                        break;
                    }
                default:
                    this.gHC.setBackgroundColor(0);
                    break;
            }
            if (!LegoListFragment.gGd.contains(buttonCard.toString())) {
                LegoListFragment.gGd.add(buttonCard.toString());
                r.bWG().bWC().ca(buttonCard.getShowExtra(), this.mFrom);
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
                r.bWG().bWC().F(ButtonCardView.this.mFrom, "yes", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                r.bWG().bWC().F(ButtonCardView.this.mFrom, "no", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(this.mContext).aaZ();
    }

    public void setBackgroundAlpha(float f) {
        if (this.gHB != null) {
            this.gHB.setAlpha(f);
        }
    }

    public void reset() {
        if (this.gHB != null) {
            this.gHB.setVisibility(0);
            this.gHB.setAlpha(1);
        }
    }
}
