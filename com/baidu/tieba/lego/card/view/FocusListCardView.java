package com.baidu.tieba.lego.card.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.FocusListCard;
import d.a.c.e.p.l;
import d.a.n0.e3.v;
import d.a.n0.k1.e;
import d.a.n0.k1.i;
import d.a.n0.z.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FocusListCardView extends BaseCardView<FocusListCard> {
    public View r;
    public TextView s;
    public View t;
    public View u;
    public View v;
    public LinearLayout w;
    public List<LinearLayout> x;
    public List<View> y;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ FocusListCard f17993e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f17994f;

        public a(FocusListCard focusListCard, int i2) {
            this.f17993e = focusListCard;
            this.f17994f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f17993e.getFocusItemList().get(this.f17994f).f17945f)) {
                return;
            }
            t.b().d(true);
            e e2 = i.e(this.f17993e);
            e2.b("obj_locate", this.f17994f + 1);
            e2.d(TiebaStatic.Params.OBJ_URL, this.f17993e.getFocusItemList().get(this.f17994f).f17945f);
            e2.c("obj_id", this.f17993e.getFocusItemList().get(this.f17994f).f17946g);
            e2.a(this.f17993e);
            v.c(FocusListCardView.this.m, this.f17993e.getFocusItemList().get(this.f17994f).f17945f);
        }
    }

    public FocusListCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public final void I(FocusListCard focusListCard) {
        if (focusListCard == null) {
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0308);
        } else {
            int bgColor = focusListCard.getBgColor();
            int bgColorNight = focusListCard.getBgColorNight();
            A(this.s, bgColor, bgColorNight, R.color.CAM_X0308);
            A(this.t, bgColor, bgColorNight, R.color.CAM_X0308);
            A(this.u, bgColor, bgColorNight, R.color.CAM_X0308);
            A(this.v, bgColor, bgColorNight, R.color.CAM_X0308);
        }
        if (focusListCard == null) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        } else {
            B(this.s, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
        }
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
        List<LinearLayout> list = this.x;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            SkinManager.setBackgroundResource(this.x.get(i2), R.drawable.addresslist_item_bg);
        }
    }

    public final void J(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        K(textView2, aVar);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
    }

    public final void K(TextView textView, FocusListCard.a aVar) {
        if (textView == null || aVar == null) {
            return;
        }
        B(textView, aVar.f17943d, aVar.f17944e, R.color.CAM_X0308);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: L */
    public void w(FocusListCard focusListCard, int i2) {
        d.a.m0.s0.a.a(this.m, getRootView());
        if (focusListCard != null) {
            I(focusListCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: M */
    public void x(FocusListCard focusListCard) {
        if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
            this.s.setText(focusListCard.getCardTitle());
            int size = focusListCard.getFocusItemList().size();
            for (int i2 = 0; i2 < size && i2 < 5; i2++) {
                this.x.get(i2).setVisibility(0);
                if (i2 < size - 1 && i2 < 4) {
                    this.y.get(i2).setVisibility(0);
                    SkinManager.setBackgroundColor(this.y.get(i2), R.color.CAM_X0204);
                } else {
                    this.y.get(i2).setVisibility(8);
                }
                TextView textView = (TextView) o(this.x.get(i2), R.id.focus_title);
                TextView textView2 = (TextView) o(this.x.get(i2), R.id.subtitle);
                TextView textView3 = (TextView) o(this.x.get(i2), R.id.right);
                ImageView imageView = (ImageView) o(this.x.get(i2), R.id.rightIcon);
                J(textView, textView2, textView3, focusListCard.getFocusItemList().get(i2));
                textView.setText(focusListCard.getFocusItemList().get(i2).f17940a);
                textView2.setText(focusListCard.getFocusItemList().get(i2).f17941b);
                textView3.setText(focusListCard.getFocusItemList().get(i2).f17942c);
                if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i2).f17945f)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView3.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
                    this.x.get(i2).setOnClickListener(new a(focusListCard, i2));
                } else {
                    imageView.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams2.setMargins(0, 0, l.g(getContext(), R.dimen.ds16), 0);
                    textView3.setLayoutParams(layoutParams2);
                    this.x.get(i2).setOnClickListener(null);
                }
            }
            for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                this.x.get(size2).setVisibility(8);
            }
        }
        I(focusListCard);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View t() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.card_focus_list, (ViewGroup) null);
        this.r = inflate;
        this.s = (TextView) o(inflate, R.id.left_title);
        this.t = (View) o(this.r, R.id.topView);
        this.u = (View) o(this.r, R.id.bottomView);
        this.v = (View) o(this.r, R.id.rightView);
        this.w = (LinearLayout) o(this.r, R.id.container);
        this.x = new ArrayList();
        this.x.add((LinearLayout) o(this.w, R.id.one));
        this.x.add((LinearLayout) o(this.w, R.id.two));
        this.x.add((LinearLayout) o(this.w, R.id.three));
        this.x.add((LinearLayout) o(this.w, R.id.four));
        this.x.add((LinearLayout) o(this.w, R.id.five));
        this.y = new ArrayList();
        this.y.add((View) o(this.w, R.id.one_line));
        this.y.add((View) o(this.w, R.id.two_line));
        this.y.add((View) o(this.w, R.id.three_line));
        this.y.add((View) o(this.w, R.id.four_line));
        this.y.add((View) o(this.w, R.id.five_line));
        return this.r;
    }
}
