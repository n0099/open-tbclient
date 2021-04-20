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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.tieba.lego.card.model.ButtonCard;
import d.b.c.e.p.l;
import d.b.h0.r.s.a;
import d.b.i0.s2.v;
/* loaded from: classes4.dex */
public class ButtonCardView extends BaseCardView<ButtonCard> {
    public RelativeLayout r;
    public TbImageView s;
    public Button t;
    public int u;
    public final int v;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f18318e;

        public a(ButtonCard buttonCard) {
            this.f18318e = buttonCard;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ButtonCardView.this.setDialog(this.f18318e);
            v.p().k().a(this.f18318e.getsExtras(), ButtonCardView.this.f18314e);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f18320e;

        public b(ButtonCard buttonCard) {
            this.f18320e = buttonCard;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            UrlManager.getInstance().dealOneLink(ButtonCardView.this.m, new String[]{this.f18320e.getBtnScheme()});
            v.p().k().d(ButtonCardView.this.f18314e, "yes", this.f18320e.getsExtras());
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ButtonCard f18322e;

        public c(ButtonCard buttonCard) {
            this.f18322e = buttonCard;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            v.p().k().d(ButtonCardView.this.f18314e, "no", this.f18322e.getsExtras());
            aVar.dismiss();
        }
    }

    public ButtonCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.u = -1;
        this.v = l.k(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDialog(ButtonCard buttonCard) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.m.getPageActivity());
        aVar.setMessage("是否拨打电话:" + buttonCard.getPhoneNumber());
        aVar.setPositiveButton(R.string.call, new b(buttonCard));
        aVar.setNegativeButton(R.string.cancel, new c(buttonCard));
        aVar.create(this.m).show();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void y(ButtonCard buttonCard, int i) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void z(ButtonCard buttonCard) {
        if (buttonCard == null) {
            return;
        }
        O();
        float cardWidth = (float) ((this.v * 1.0d) / buttonCard.getCardWidth());
        ViewGroup.LayoutParams layoutParams = this.r.getLayoutParams();
        layoutParams.width = this.v;
        layoutParams.height = (int) (buttonCard.getCardHeight() * cardWidth);
        this.r.setLayoutParams(layoutParams);
        int bgColor = buttonCard.getBgColor();
        this.s.setDefaultBgResource(R.color.transparent);
        if (!TextUtils.isEmpty(buttonCard.getPicUrl())) {
            this.s.W(buttonCard.getPicUrl(), 17, false);
        } else if (!d.b.i0.j1.o.k.b.a(bgColor)) {
            this.s.setBackgroundColor(bgColor);
        } else {
            this.s.setDefaultBgResource(R.color.transparent);
        }
        int dimension = layoutParams.height - ((int) (TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.button_card_padding40) * cardWidth));
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.t.getLayoutParams();
        layoutParams2.height = dimension;
        layoutParams2.addRule(13);
        this.t.setText(buttonCard.getText());
        this.t.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.fontsize28));
        int textColor = buttonCard.getTextColor();
        if (!d.b.i0.j1.o.k.b.a(textColor)) {
            this.t.setTextColor(textColor);
        }
        this.t.setOnClickListener(new a(buttonCard));
        this.u = buttonCard.getStyle();
        int buttonColor = buttonCard.getButtonColor();
        int i = this.u;
        if (i == 1) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (!d.b.i0.j1.o.k.b.a(buttonColor)) {
                gradientDrawable.setStroke(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds3), buttonColor);
            }
            gradientDrawable.setColor(0);
            this.t.setBackgroundDrawable(gradientDrawable);
        } else if (i != 2) {
            this.t.setBackgroundColor(0);
        } else if (!d.b.i0.j1.o.k.b.a(buttonColor)) {
            this.t.setBackgroundColor(buttonColor);
        } else {
            this.t.setBackgroundColor(0);
        }
        if (LegoListFragment.V.contains(buttonCard.toString())) {
            return;
        }
        LegoListFragment.V.add(buttonCard.toString());
        v.p().k().c(buttonCard.getShowExtra(), this.f18314e);
    }

    public void O() {
        TbImageView tbImageView = this.s;
        if (tbImageView != null) {
            tbImageView.setVisibility(0);
            this.s.setAlpha(1);
        }
    }

    public void setBackgroundAlpha(float f2) {
        TbImageView tbImageView = this.s;
        if (tbImageView != null) {
            tbImageView.setAlpha(f2);
        }
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.m.getPageActivity().getApplicationContext()).inflate(R.layout.card_button, (ViewGroup) null);
        this.r = relativeLayout;
        this.t = (Button) relativeLayout.findViewById(R.id.bt_phone);
        this.s = (TbImageView) this.r.findViewById(R.id.tb_phone_background);
        return this.r;
    }
}
