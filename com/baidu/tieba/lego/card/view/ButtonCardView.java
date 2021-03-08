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
/* loaded from: classes8.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    private RelativeLayout leF;
    private TbImageView leG;
    private Button leH;
    private int leI;
    private int leJ;
    private final int leK;

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.leI = -1;
        this.leJ = -1;
        this.leK = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dce() {
        this.leF = (RelativeLayout) LayoutInflater.from(this.eWx.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
        this.leH = (Button) this.leF.findViewById(R.id.bt_phone);
        this.leG = (TbImageView) this.leF.findViewById(R.id.tb_phone_background);
        return this.leF;
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
            float cardWidth = (float) ((this.leK * 1.0d) / buttonCard.getCardWidth());
            ViewGroup.LayoutParams layoutParams = this.leF.getLayoutParams();
            layoutParams.width = this.leK;
            layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
            this.leF.setLayoutParams(layoutParams);
            int bgColor = buttonCard.getBgColor();
            this.leG.setDefaultBgResource(R.color.transparent);
            if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
                this.leG.startLoad(buttonCard.getPicUrl(), 17, false);
            } else if (!com.baidu.tieba.lego.card.c.b.DW(bgColor)) {
                this.leG.setBackgroundColor(bgColor);
            } else {
                this.leG.setDefaultBgResource(R.color.transparent);
            }
            int dimension = layoutParams.height - ((int) (cardWidth * TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40)));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.leH.getLayoutParams();
            layoutParams2.height = dimension;
            layoutParams2.addRule(13);
            this.leH.setText(buttonCard.getText());
            this.leH.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            int textColor = buttonCard.getTextColor();
            if (!com.baidu.tieba.lego.card.c.b.DW(textColor)) {
                this.leH.setTextColor(textColor);
            }
            this.leH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ButtonCardView.this.setDialog(buttonCard);
                    s.dDB().dDx().ei(buttonCard.getsExtras(), ButtonCardView.this.mFrom);
                }
            });
            this.leI = buttonCard.getStyle();
            int buttonColor = buttonCard.getButtonColor();
            switch (this.leI) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    if (!com.baidu.tieba.lego.card.c.b.DW(buttonColor)) {
                        gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
                    }
                    gradientDrawable.setColor(0);
                    this.leH.setBackgroundDrawable(gradientDrawable);
                    break;
                case 2:
                    if (!com.baidu.tieba.lego.card.c.b.DW(buttonColor)) {
                        this.leH.setBackgroundColor(buttonColor);
                        break;
                    } else {
                        this.leH.setBackgroundColor(0);
                        break;
                    }
                default:
                    this.leH.setBackgroundColor(0);
                    break;
            }
            if (!LegoListFragment.ldj.contains(buttonCard.toString())) {
                LegoListFragment.ldj.add(buttonCard.toString());
                s.dDB().dDx().eh(buttonCard.getShowExtra(), this.mFrom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(final ButtonCard buttonCard) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eWx.getPageActivity());
        aVar.AB("是否拨打电话:" + buttonCard.getPhoneNumber());
        aVar.a(R.string.call, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                bf.bsY().b(ButtonCardView.this.eWx, new String[]{buttonCard.getBtnScheme()});
                s.dDB().dDx().at(ButtonCardView.this.mFrom, "yes", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                s.dDB().dDx().at(ButtonCardView.this.mFrom, "no", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(this.eWx).bqz();
    }

    public void setBackgroundAlpha(float f) {
        if (this.leG != null) {
            this.leG.setAlpha(f);
        }
    }

    public void reset() {
        if (this.leG != null) {
            this.leG.setVisibility(0);
            this.leG.setAlpha(1);
        }
    }
}
