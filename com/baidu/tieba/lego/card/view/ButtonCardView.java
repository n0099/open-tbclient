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
import com.baidu.tieba.recapp.r;
/* loaded from: classes9.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    private RelativeLayout lcn;
    private TbImageView lco;
    private Button lcp;
    private int lcq;
    private int lcr;
    private final int lcs;

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.lcq = -1;
        this.lcr = -1;
        this.lcs = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View dbO() {
        this.lcn = (RelativeLayout) LayoutInflater.from(this.eUY.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
        this.lcp = (Button) this.lcn.findViewById(R.id.bt_phone);
        this.lco = (TbImageView) this.lcn.findViewById(R.id.tb_phone_background);
        return this.lcn;
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
            float cardWidth = (float) ((this.lcs * 1.0d) / buttonCard.getCardWidth());
            ViewGroup.LayoutParams layoutParams = this.lcn.getLayoutParams();
            layoutParams.width = this.lcs;
            layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
            this.lcn.setLayoutParams(layoutParams);
            int bgColor = buttonCard.getBgColor();
            this.lco.setDefaultBgResource(R.color.transparent);
            if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
                this.lco.startLoad(buttonCard.getPicUrl(), 17, false);
            } else if (!com.baidu.tieba.lego.card.c.b.DT(bgColor)) {
                this.lco.setBackgroundColor(bgColor);
            } else {
                this.lco.setDefaultBgResource(R.color.transparent);
            }
            int dimension = layoutParams.height - ((int) (cardWidth * TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40)));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.lcp.getLayoutParams();
            layoutParams2.height = dimension;
            layoutParams2.addRule(13);
            this.lcp.setText(buttonCard.getText());
            this.lcp.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            int textColor = buttonCard.getTextColor();
            if (!com.baidu.tieba.lego.card.c.b.DT(textColor)) {
                this.lcp.setTextColor(textColor);
            }
            this.lcp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ButtonCardView.this.setDialog(buttonCard);
                    r.dDm().dDi().ei(buttonCard.getsExtras(), ButtonCardView.this.mFrom);
                }
            });
            this.lcq = buttonCard.getStyle();
            int buttonColor = buttonCard.getButtonColor();
            switch (this.lcq) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    if (!com.baidu.tieba.lego.card.c.b.DT(buttonColor)) {
                        gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
                    }
                    gradientDrawable.setColor(0);
                    this.lcp.setBackgroundDrawable(gradientDrawable);
                    break;
                case 2:
                    if (!com.baidu.tieba.lego.card.c.b.DT(buttonColor)) {
                        this.lcp.setBackgroundColor(buttonColor);
                        break;
                    } else {
                        this.lcp.setBackgroundColor(0);
                        break;
                    }
                default:
                    this.lcp.setBackgroundColor(0);
                    break;
            }
            if (!LegoListFragment.laS.contains(buttonCard.toString())) {
                LegoListFragment.laS.add(buttonCard.toString());
                r.dDm().dDi().eh(buttonCard.getShowExtra(), this.mFrom);
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
                r.dDm().dDi().at(ButtonCardView.this.mFrom, "yes", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                r.dDm().dDi().at(ButtonCardView.this.mFrom, "no", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(this.eUY).bqx();
    }

    public void setBackgroundAlpha(float f) {
        if (this.lco != null) {
            this.lco.setAlpha(f);
        }
    }

    public void reset() {
        if (this.lco != null) {
            this.lco.setVisibility(0);
            this.lco.setAlpha(1);
        }
    }
}
