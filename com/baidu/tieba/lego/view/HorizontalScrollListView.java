package com.baidu.tieba.lego.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.horizonalScrollListView.MyHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.lego.card.model.HorRankCard;
import d.b.c.e.p.l;
import d.b.j0.d3.v;
import d.b.j0.j1.i;
import d.b.j0.x.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18417e;

    /* renamed from: f  reason: collision with root package name */
    public int f18418f;

    /* renamed from: g  reason: collision with root package name */
    public int f18419g;

    /* renamed from: h  reason: collision with root package name */
    public int f18420h;
    public LinearLayout i;
    public final ArrayList<ItemViewHolder> j;
    public int k;
    public TbPageContext l;

    /* loaded from: classes4.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f18421a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f18422b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f18423c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18424d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18425e;

        /* renamed from: f  reason: collision with root package name */
        public HeadImageView f18426f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f18427g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18428h;
        public LinearLayout i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public ItemViewHolder(View view) {
            super(view);
            this.f18422b = null;
            this.f18423c = null;
            this.f18424d = null;
            this.f18425e = null;
            this.f18426f = null;
            this.f18427g = null;
            this.f18428h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.f18421a = (LinearLayout) view.findViewById(R.id.ll_name);
            this.f18423c = (FrameLayout) view.findViewById(R.id.fl_left);
            this.f18424d = (ImageView) view.findViewById(R.id.leftBack);
            this.f18422b = (ImageView) view.findViewById(R.id.leftIcon);
            this.f18425e = (TextView) view.findViewById(R.id.leftText);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head);
            this.f18426f = headImageView;
            headImageView.setGifIconSupport(false);
            this.f18427g = (TbImageView) view.findViewById(R.id.head_icon);
            this.f18428h = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.i = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.j = (TextView) view.findViewById(R.id.subtitle);
            this.k = (TextView) view.findViewById(R.id.leftTopText);
            this.l = (LinearLayout) view.findViewById(R.id.ll_post);
            this.m = (TextView) view.findViewById(R.id.btn_post);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18429e;

        public a(HorRankCard.a aVar) {
            this.f18429e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18429e.j)) {
                return;
            }
            t.b().d(true);
            i.e(this.f18429e.m).a(TiebaStatic.Params.OBJ_URL, this.f18429e.j).b(this.f18429e.m);
            v.c(HorizontalScrollListView.this.l, this.f18429e.j);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18431e;

        public b(HorRankCard.a aVar) {
            this.f18431e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(HorizontalScrollListView.this.getContext())) {
                d.b.j0.j1.m.b a2 = d.b.j0.j1.m.b.a();
                HorRankCard.a aVar = this.f18431e;
                a2.e(aVar, aVar.f18295f, null, null);
            }
        }
    }

    public HorizontalScrollListView(Context context) {
        super(context);
        this.f18417e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i == 0) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
        } else {
            layoutParams.leftMargin = this.f18420h;
        }
    }

    public final View e() {
        return View.inflate(this.l.getPageActivity(), R.layout.card_horizontal_rank_list_item, null);
    }

    public final void f(View view, HorRankCard.a aVar, int i, boolean z) {
        if (aVar == null || view == null || view.getTag() == null) {
            return;
        }
        if (z) {
            view.setPadding(0, 0, l.g(getContext(), R.dimen.ds24), l.g(getContext(), R.dimen.ds24));
        } else {
            view.setPadding(0, 0, 0, l.g(getContext(), R.dimen.ds24));
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (this.f18417e) {
            itemViewHolder.f18426f.setIsRound(true);
            itemViewHolder.k.setVisibility(8);
            int i2 = aVar.f18290a;
            if (i2 <= 0) {
                itemViewHolder.f18422b.setVisibility(8);
                itemViewHolder.f18423c.setVisibility(8);
            } else if (i2 == 1) {
                itemViewHolder.f18422b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18422b, R.drawable.icon_grade_star_no1);
                itemViewHolder.f18423c.setVisibility(8);
            } else if (i2 == 2) {
                itemViewHolder.f18422b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18422b, R.drawable.icon_grade_star_no2);
                itemViewHolder.f18423c.setVisibility(8);
            } else if (i2 != 3) {
                itemViewHolder.f18423c.setVisibility(0);
                itemViewHolder.f18424d.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.f18422b.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.f18425e, R.color.CAM_X0111);
                TextView textView = itemViewHolder.f18425e;
                textView.setText("" + (i + 1));
            } else {
                itemViewHolder.f18422b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18422b, R.drawable.icon_grade_star_no3);
                itemViewHolder.f18423c.setVisibility(8);
            }
        } else {
            itemViewHolder.f18426f.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.k, R.color.CAM_X0111);
            itemViewHolder.f18422b.setVisibility(8);
            itemViewHolder.f18423c.setVisibility(8);
            if (aVar.f18290a <= 0) {
                itemViewHolder.k.setVisibility(8);
            } else {
                itemViewHolder.k.setVisibility(0);
                itemViewHolder.k.setText(String.valueOf(aVar.f18290a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!d.b.j0.j1.o.k.b.a(aVar.l)) {
                        itemViewHolder.k.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.k, d.b.j0.j1.a.f57738a[i <= 3 ? i : 3]);
                    }
                } else if (!d.b.j0.j1.o.k.b.a(aVar.k)) {
                    itemViewHolder.k.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.k, d.b.j0.j1.a.f57738a[i <= 3 ? i : 3]);
                }
            }
            itemViewHolder.f18426f.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.f18426f.setOnClickListener(new a(aVar));
        } else {
            itemViewHolder.f18426f.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.f18426f.getLayoutParams();
        layoutParams.width = this.f18418f;
        layoutParams.height = this.f18419g;
        d(layoutParams, i);
        if (this.f18417e) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.f18426f.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.k.getLayoutParams();
        d(layoutParams2, i);
        itemViewHolder.k.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.f18421a.getLayoutParams();
        layoutParams3.width = this.f18418f;
        d(layoutParams3, i);
        itemViewHolder.f18421a.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.i.getLayoutParams();
        layoutParams4.width = this.f18418f;
        d(layoutParams4, i);
        itemViewHolder.i.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.l.getLayoutParams();
        layoutParams5.width = this.f18418f;
        d(layoutParams5, i);
        itemViewHolder.l.setLayoutParams(layoutParams5);
        itemViewHolder.f18426f.setTag(aVar.f18291b);
        itemViewHolder.f18426f.W(aVar.f18291b, 10, false);
        if (!TextUtils.isEmpty(aVar.f18292c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.f18427g.getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.ds30);
            int g3 = l.g(getContext(), R.dimen.ds6);
            int g4 = l.g(getContext(), R.dimen.ds18);
            int i3 = ((this.f18418f - g2) + this.f18420h) - g3;
            if (i == 0) {
                i3 = (i3 - g4) + g3;
            }
            layoutParams6.setMargins(i3, (this.f18419g - g2) + g3, 0, 0);
            itemViewHolder.f18427g.setLayoutParams(layoutParams6);
            itemViewHolder.f18427g.W(aVar.f18292c, 10, false);
        } else {
            itemViewHolder.f18427g.setVisibility(8);
        }
        if (aVar.f18293d != null) {
            itemViewHolder.f18428h.setVisibility(0);
            if (this.f18417e) {
                if (aVar.f18290a <= 0) {
                    itemViewHolder.f18428h.setMaxWidth(this.f18418f);
                } else {
                    itemViewHolder.f18428h.setMaxWidth((this.f18418f - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                }
            } else {
                itemViewHolder.f18428h.setMaxWidth(this.f18418f);
            }
            itemViewHolder.f18428h.setText(aVar.f18293d);
        } else {
            itemViewHolder.f18428h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f18294e)) {
            try {
                itemViewHolder.j.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f18294e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.j.setText(aVar.f18294e);
            }
            SkinManager.setViewTextColor(itemViewHolder.j, R.color.CAM_X0312);
            itemViewHolder.j.setVisibility(0);
        } else {
            itemViewHolder.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f18295f) && !TextUtils.isEmpty(aVar.f18297h) && !TextUtils.isEmpty(aVar.i)) {
            itemViewHolder.l.setVisibility(0);
            j(itemViewHolder.m, aVar.f18296g, aVar.f18297h, aVar.i);
            itemViewHolder.m.setTag(aVar.f18295f);
            itemViewHolder.m.setOnClickListener(new b(aVar));
            return;
        }
        itemViewHolder.l.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(ItemViewHolder itemViewHolder, int i) {
        if (itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        SkinManager.setViewTextColor(itemViewHolder.f18428h, R.color.CAM_X0108, 1);
    }

    public final void h(Context context) {
        this.f18420h = (int) context.getResources().getDimension(R.dimen.ds36);
        this.f18418f = (int) context.getResources().getDimension(R.dimen.ds102);
        this.f18419g = (int) context.getResources().getDimension(R.dimen.ds102);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.i = linearLayout;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.i.setOrientation(0);
        addView(this.i);
    }

    public void i(int i) {
        if (this.k != i) {
            Iterator<ItemViewHolder> it = this.j.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    g(next, i);
                }
            }
            this.k = i;
        }
    }

    public final void j(TextView textView, boolean z, String str, String str2) {
        if (z) {
            textView.setEnabled(false);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0109, 1);
            textView.setText(str2);
            textView.setBackgroundDrawable(null);
            textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setPadding(0, 0, 0, 0);
            return;
        }
        SkinManager.setViewTextColor(textView, R.color.btn_forum_focus_color, 1);
        textView.setText(str);
        SkinManager.setBackgroundResource(textView, R.drawable.btn_focus_border_bg);
        textView.setCompoundDrawablesWithIntrinsicBounds(SkinManager.getDrawable(R.drawable.btn_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setEnabled(true);
        textView.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds10), 0);
    }

    public void setData(List<HorRankCard.a> list, TbPageContext tbPageContext) {
        if (ListUtils.getCount(list) <= 0 || tbPageContext == null) {
            return;
        }
        this.l = tbPageContext;
        int count = ListUtils.getCount(this.j);
        int count2 = ListUtils.getCount(list);
        if (count > count2) {
            for (int i = 0; i < count - count2; i++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.j, 0);
                if (viewHolder != null) {
                    this.i.removeView(viewHolder.a());
                }
                this.j.remove(viewHolder);
            }
        }
        int i2 = 0;
        while (i2 < count2) {
            HorRankCard.a aVar = (HorRankCard.a) ListUtils.getItem(list, i2);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.j, i2);
            if (itemViewHolder != null) {
                f(itemViewHolder.a(), aVar, i2, i2 == count2 + (-1));
            } else {
                View e2 = e();
                if (e2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(e2);
                    this.j.add(itemViewHolder2);
                    f(itemViewHolder2.a(), aVar, i2, i2 == count2 + (-1));
                    this.i.addView(e2);
                }
            }
            i2++;
        }
        i(this.k);
    }

    public void setDisplayNum(double d2) {
        int dimensionPixelSize;
        double d3 = (int) d2;
        if (Math.abs(d2 - d3) < 0.01d) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24) * 2;
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
            d3 = d2;
        }
        this.f18418f = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f18420h * (((int) (0.5d + d3)) - 1))) / d3);
    }

    public void setRatio(double d2) {
        this.f18419g = (int) ((this.f18418f * d2) + 0.5d);
    }

    public void setRound(boolean z) {
        this.f18417e = z;
        if (z) {
            this.f18420h = (int) getResources().getDimension(R.dimen.ds36);
        } else {
            this.f18420h = (int) getResources().getDimension(R.dimen.ds18);
        }
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18417e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f18417e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }
}
