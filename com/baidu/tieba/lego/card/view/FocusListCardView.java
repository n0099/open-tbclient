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
import d.b.c.e.p.l;
import d.b.j0.d3.v;
import d.b.j0.j1.e;
import d.b.j0.j1.i;
import d.b.j0.x.t;
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
        public final /* synthetic */ FocusListCard f18332e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f18333f;

        public a(FocusListCard focusListCard, int i) {
            this.f18332e = focusListCard;
            this.f18333f = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18332e.getFocusItemList().get(this.f18333f).f18288f)) {
                return;
            }
            t.b().d(true);
            e e2 = i.e(this.f18332e);
            e2.c("obj_locate", this.f18333f + 1);
            e2.a(TiebaStatic.Params.OBJ_URL, this.f18332e.getFocusItemList().get(this.f18333f).f18288f);
            e2.d("obj_id", this.f18332e.getFocusItemList().get(this.f18333f).f18289g);
            e2.b(this.f18332e);
            v.c(FocusListCardView.this.m, this.f18332e.getFocusItemList().get(this.f18333f).f18288f);
        }
    }

    public FocusListCardView(TbPageContext tbPageContext) {
        super(tbPageContext);
    }

    public final void K(FocusListCard focusListCard) {
        if (focusListCard == null) {
            SkinManager.setBackgroundColor(this.s, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0308);
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0308);
        } else {
            int bgColor = focusListCard.getBgColor();
            int bgColorNight = focusListCard.getBgColorNight();
            E(this.s, bgColor, bgColorNight, R.color.CAM_X0308);
            E(this.t, bgColor, bgColorNight, R.color.CAM_X0308);
            E(this.u, bgColor, bgColorNight, R.color.CAM_X0308);
            E(this.v, bgColor, bgColorNight, R.color.CAM_X0308);
        }
        if (focusListCard == null) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0101);
        } else {
            F(this.s, focusListCard.getTitleColor(), focusListCard.getTitleColorNight(), R.color.CAM_X0101);
        }
        SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
        List<LinearLayout> list = this.x;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.x.size(); i++) {
            SkinManager.setBackgroundResource(this.x.get(i), R.drawable.addresslist_item_bg);
        }
    }

    public final void L(TextView textView, TextView textView2, TextView textView3, FocusListCard.a aVar) {
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105);
        M(textView2, aVar);
        SkinManager.setViewTextColor(textView3, R.color.CAM_X0109);
    }

    public final void M(TextView textView, FocusListCard.a aVar) {
        if (textView == null || aVar == null) {
            return;
        }
        F(textView, aVar.f18286d, aVar.f18287e, R.color.CAM_X0308);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: O */
    public void y(FocusListCard focusListCard, int i) {
        d.b.i0.s0.a.a(this.m, getRootView());
        if (focusListCard != null) {
            K(focusListCard);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    /* renamed from: P */
    public void z(FocusListCard focusListCard) {
        if (focusListCard.getFocusItemList() != null && focusListCard.getFocusItemList().size() > 0) {
            this.s.setText(focusListCard.getCardTitle());
            int size = focusListCard.getFocusItemList().size();
            for (int i = 0; i < size && i < 5; i++) {
                this.x.get(i).setVisibility(0);
                if (i < size - 1 && i < 4) {
                    this.y.get(i).setVisibility(0);
                    SkinManager.setBackgroundColor(this.y.get(i), R.color.CAM_X0204);
                } else {
                    this.y.get(i).setVisibility(8);
                }
                TextView textView = (TextView) o(this.x.get(i), R.id.focus_title);
                TextView textView2 = (TextView) o(this.x.get(i), R.id.subtitle);
                TextView textView3 = (TextView) o(this.x.get(i), R.id.right);
                ImageView imageView = (ImageView) o(this.x.get(i), R.id.rightIcon);
                L(textView, textView2, textView3, focusListCard.getFocusItemList().get(i));
                textView.setText(focusListCard.getFocusItemList().get(i).f18283a);
                textView2.setText(focusListCard.getFocusItemList().get(i).f18284b);
                textView3.setText(focusListCard.getFocusItemList().get(i).f18285c);
                if (!TextUtils.isEmpty(focusListCard.getFocusItemList().get(i).f18288f)) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams.setMargins(0, 0, 0, 0);
                    textView3.setLayoutParams(layoutParams);
                    imageView.setVisibility(0);
                    SkinManager.setImageResource(imageView, R.drawable.icon_arrow_tab);
                    this.x.get(i).setOnClickListener(new a(focusListCard, i));
                } else {
                    imageView.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView3.getLayoutParams();
                    layoutParams2.setMargins(0, 0, l.g(getContext(), R.dimen.ds16), 0);
                    textView3.setLayoutParams(layoutParams2);
                    this.x.get(i).setOnClickListener(null);
                }
            }
            for (int size2 = focusListCard.getFocusItemList().size(); size2 < 5; size2++) {
                this.x.get(size2).setVisibility(8);
            }
        }
        K(focusListCard);
    }

    @Override // com.baidu.tieba.lego.card.view.BaseLegoCardView
    public View v() {
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
