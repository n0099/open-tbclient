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
/* loaded from: classes8.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    private RelativeLayout kUk;
    private TbImageView kUl;
    private Button kUm;
    private int kUn;
    private int kUo;
    private final int kUp;

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.kUn = -1;
        this.kUo = -1;
        this.kUp = com.baidu.adp.lib.util.l.getEquipmentWidth(getContext());
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    protected View cZQ() {
        this.kUk = (RelativeLayout) LayoutInflater.from(this.eSJ.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
        this.kUm = (Button) this.kUk.findViewById(R.id.bt_phone);
        this.kUl = (TbImageView) this.kUk.findViewById(R.id.tb_phone_background);
        return this.kUk;
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
            float cardWidth = (float) ((this.kUp * 1.0d) / buttonCard.getCardWidth());
            ViewGroup.LayoutParams layoutParams = this.kUk.getLayoutParams();
            layoutParams.width = this.kUp;
            layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
            this.kUk.setLayoutParams(layoutParams);
            int bgColor = buttonCard.getBgColor();
            this.kUl.setDefaultBgResource(R.color.transparent);
            if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
                this.kUl.startLoad(buttonCard.getPicUrl(), 17, false);
            } else if (!com.baidu.tieba.lego.card.c.b.DB(bgColor)) {
                this.kUl.setBackgroundColor(bgColor);
            } else {
                this.kUl.setDefaultBgResource(R.color.transparent);
            }
            int dimension = layoutParams.height - ((int) (cardWidth * TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40)));
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.kUm.getLayoutParams();
            layoutParams2.height = dimension;
            layoutParams2.addRule(13);
            this.kUm.setText(buttonCard.getText());
            this.kUm.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
            int textColor = buttonCard.getTextColor();
            if (!com.baidu.tieba.lego.card.c.b.DB(textColor)) {
                this.kUm.setTextColor(textColor);
            }
            this.kUm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ButtonCardView.this.setDialog(buttonCard);
                    r.dBe().dBa().ek(buttonCard.getsExtras(), ButtonCardView.this.mFrom);
                }
            });
            this.kUn = buttonCard.getStyle();
            int buttonColor = buttonCard.getButtonColor();
            switch (this.kUn) {
                case 1:
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    if (!com.baidu.tieba.lego.card.c.b.DB(buttonColor)) {
                        gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
                    }
                    gradientDrawable.setColor(0);
                    this.kUm.setBackgroundDrawable(gradientDrawable);
                    break;
                case 2:
                    if (!com.baidu.tieba.lego.card.c.b.DB(buttonColor)) {
                        this.kUm.setBackgroundColor(buttonColor);
                        break;
                    } else {
                        this.kUm.setBackgroundColor(0);
                        break;
                    }
                default:
                    this.kUm.setBackgroundColor(0);
                    break;
            }
            if (!LegoListFragment.kSP.contains(buttonCard.toString())) {
                LegoListFragment.kSP.add(buttonCard.toString());
                r.dBe().dBa().ej(buttonCard.getShowExtra(), this.mFrom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(final ButtonCard buttonCard) {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.eSJ.getPageActivity());
        aVar.Ad("是否拨打电话:" + buttonCard.getPhoneNumber());
        aVar.a(R.string.call, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                be.bsB().b(ButtonCardView.this.eSJ, new String[]{buttonCard.getBtnScheme()});
                r.dBe().dBa().ar(ButtonCardView.this.mFrom, "yes", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.lego.card.view.ButtonCardView.3
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                r.dBe().dBa().ar(ButtonCardView.this.mFrom, "no", buttonCard.getsExtras());
                aVar2.dismiss();
            }
        });
        aVar.b(this.eSJ).bqe();
    }

    public void setBackgroundAlpha(float f) {
        if (this.kUl != null) {
            this.kUl.setAlpha(f);
        }
    }

    public void reset() {
        if (this.kUl != null) {
            this.kUl.setVisibility(0);
            this.kUl.setAlpha(1);
        }
    }
}
