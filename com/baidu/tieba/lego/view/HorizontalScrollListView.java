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
import d.a.c.e.p.l;
import d.a.o0.e3.v;
import d.a.o0.k1.i;
import d.a.o0.z.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18163e;

    /* renamed from: f  reason: collision with root package name */
    public int f18164f;

    /* renamed from: g  reason: collision with root package name */
    public int f18165g;

    /* renamed from: h  reason: collision with root package name */
    public int f18166h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f18167i;
    public final ArrayList<ItemViewHolder> j;
    public int k;
    public TbPageContext l;

    /* loaded from: classes4.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f18168a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f18169b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f18170c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18171d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18172e;

        /* renamed from: f  reason: collision with root package name */
        public HeadImageView f18173f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f18174g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18175h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f18176i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public ItemViewHolder(View view) {
            super(view);
            this.f18169b = null;
            this.f18170c = null;
            this.f18171d = null;
            this.f18172e = null;
            this.f18173f = null;
            this.f18174g = null;
            this.f18175h = null;
            this.f18176i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.f18168a = (LinearLayout) view.findViewById(R.id.ll_name);
            this.f18170c = (FrameLayout) view.findViewById(R.id.fl_left);
            this.f18171d = (ImageView) view.findViewById(R.id.leftBack);
            this.f18169b = (ImageView) view.findViewById(R.id.leftIcon);
            this.f18172e = (TextView) view.findViewById(R.id.leftText);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head);
            this.f18173f = headImageView;
            headImageView.setGifIconSupport(false);
            this.f18174g = (TbImageView) view.findViewById(R.id.head_icon);
            this.f18175h = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f18176i = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.j = (TextView) view.findViewById(R.id.subtitle);
            this.k = (TextView) view.findViewById(R.id.leftTopText);
            this.l = (LinearLayout) view.findViewById(R.id.ll_post);
            this.m = (TextView) view.findViewById(R.id.btn_post);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18177e;

        public a(HorRankCard.a aVar) {
            this.f18177e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18177e.j)) {
                return;
            }
            t.b().d(true);
            i.e(this.f18177e.m).d(TiebaStatic.Params.OBJ_URL, this.f18177e.j).a(this.f18177e.m);
            v.c(HorizontalScrollListView.this.l, this.f18177e.j);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18179e;

        public b(HorRankCard.a aVar) {
            this.f18179e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(HorizontalScrollListView.this.getContext())) {
                d.a.o0.k1.m.b a2 = d.a.o0.k1.m.b.a();
                HorRankCard.a aVar = this.f18179e;
                a2.e(aVar, aVar.f18034f, null, null);
            }
        }
    }

    public HorizontalScrollListView(Context context) {
        super(context);
        this.f18163e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
        } else {
            layoutParams.leftMargin = this.f18166h;
        }
    }

    public final View e() {
        return View.inflate(this.l.getPageActivity(), R.layout.card_horizontal_rank_list_item, null);
    }

    public final void f(View view, HorRankCard.a aVar, int i2, boolean z) {
        if (aVar == null || view == null || view.getTag() == null) {
            return;
        }
        if (z) {
            view.setPadding(0, 0, l.g(getContext(), R.dimen.ds24), l.g(getContext(), R.dimen.ds24));
        } else {
            view.setPadding(0, 0, 0, l.g(getContext(), R.dimen.ds24));
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) view.getTag();
        if (this.f18163e) {
            itemViewHolder.f18173f.setIsRound(true);
            itemViewHolder.k.setVisibility(8);
            int i3 = aVar.f18029a;
            if (i3 <= 0) {
                itemViewHolder.f18169b.setVisibility(8);
                itemViewHolder.f18170c.setVisibility(8);
            } else if (i3 == 1) {
                itemViewHolder.f18169b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18169b, R.drawable.icon_grade_star_no1);
                itemViewHolder.f18170c.setVisibility(8);
            } else if (i3 == 2) {
                itemViewHolder.f18169b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18169b, R.drawable.icon_grade_star_no2);
                itemViewHolder.f18170c.setVisibility(8);
            } else if (i3 != 3) {
                itemViewHolder.f18170c.setVisibility(0);
                itemViewHolder.f18171d.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.f18169b.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.f18172e, R.color.CAM_X0111);
                TextView textView = itemViewHolder.f18172e;
                textView.setText("" + (i2 + 1));
            } else {
                itemViewHolder.f18169b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18169b, R.drawable.icon_grade_star_no3);
                itemViewHolder.f18170c.setVisibility(8);
            }
        } else {
            itemViewHolder.f18173f.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.k, R.color.CAM_X0111);
            itemViewHolder.f18169b.setVisibility(8);
            itemViewHolder.f18170c.setVisibility(8);
            if (aVar.f18029a <= 0) {
                itemViewHolder.k.setVisibility(8);
            } else {
                itemViewHolder.k.setVisibility(0);
                itemViewHolder.k.setText(String.valueOf(aVar.f18029a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!d.a.o0.k1.o.k.b.a(aVar.l)) {
                        itemViewHolder.k.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.k, d.a.o0.k1.a.f60402a[i2 <= 3 ? i2 : 3]);
                    }
                } else if (!d.a.o0.k1.o.k.b.a(aVar.k)) {
                    itemViewHolder.k.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.k, d.a.o0.k1.a.f60402a[i2 <= 3 ? i2 : 3]);
                }
            }
            itemViewHolder.f18173f.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.f18173f.setOnClickListener(new a(aVar));
        } else {
            itemViewHolder.f18173f.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.f18173f.getLayoutParams();
        layoutParams.width = this.f18164f;
        layoutParams.height = this.f18165g;
        d(layoutParams, i2);
        if (this.f18163e) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.f18173f.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.k.getLayoutParams();
        d(layoutParams2, i2);
        itemViewHolder.k.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.f18168a.getLayoutParams();
        layoutParams3.width = this.f18164f;
        d(layoutParams3, i2);
        itemViewHolder.f18168a.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.f18176i.getLayoutParams();
        layoutParams4.width = this.f18164f;
        d(layoutParams4, i2);
        itemViewHolder.f18176i.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.l.getLayoutParams();
        layoutParams5.width = this.f18164f;
        d(layoutParams5, i2);
        itemViewHolder.l.setLayoutParams(layoutParams5);
        itemViewHolder.f18173f.setTag(aVar.f18030b);
        itemViewHolder.f18173f.U(aVar.f18030b, 10, false);
        if (!TextUtils.isEmpty(aVar.f18031c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.f18174g.getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.ds30);
            int g3 = l.g(getContext(), R.dimen.ds6);
            int g4 = l.g(getContext(), R.dimen.ds18);
            int i4 = ((this.f18164f - g2) + this.f18166h) - g3;
            if (i2 == 0) {
                i4 = (i4 - g4) + g3;
            }
            layoutParams6.setMargins(i4, (this.f18165g - g2) + g3, 0, 0);
            itemViewHolder.f18174g.setLayoutParams(layoutParams6);
            itemViewHolder.f18174g.U(aVar.f18031c, 10, false);
        } else {
            itemViewHolder.f18174g.setVisibility(8);
        }
        if (aVar.f18032d != null) {
            itemViewHolder.f18175h.setVisibility(0);
            if (this.f18163e) {
                if (aVar.f18029a <= 0) {
                    itemViewHolder.f18175h.setMaxWidth(this.f18164f);
                } else {
                    itemViewHolder.f18175h.setMaxWidth((this.f18164f - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                }
            } else {
                itemViewHolder.f18175h.setMaxWidth(this.f18164f);
            }
            itemViewHolder.f18175h.setText(aVar.f18032d);
        } else {
            itemViewHolder.f18175h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f18033e)) {
            try {
                itemViewHolder.j.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f18033e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.j.setText(aVar.f18033e);
            }
            SkinManager.setViewTextColor(itemViewHolder.j, R.color.CAM_X0312);
            itemViewHolder.j.setVisibility(0);
        } else {
            itemViewHolder.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f18034f) && !TextUtils.isEmpty(aVar.f18036h) && !TextUtils.isEmpty(aVar.f18037i)) {
            itemViewHolder.l.setVisibility(0);
            j(itemViewHolder.m, aVar.f18035g, aVar.f18036h, aVar.f18037i);
            itemViewHolder.m.setTag(aVar.f18034f);
            itemViewHolder.m.setOnClickListener(new b(aVar));
            return;
        }
        itemViewHolder.l.setVisibility(8);
    }

    @SuppressLint({"ResourceAsColor"})
    public final void g(ItemViewHolder itemViewHolder, int i2) {
        if (itemViewHolder == null || itemViewHolder.a() == null) {
            return;
        }
        SkinManager.setViewTextColor(itemViewHolder.f18175h, R.color.CAM_X0108, 1);
    }

    public final void h(Context context) {
        this.f18166h = (int) context.getResources().getDimension(R.dimen.ds36);
        this.f18164f = (int) context.getResources().getDimension(R.dimen.ds102);
        this.f18165g = (int) context.getResources().getDimension(R.dimen.ds102);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f18167i = linearLayout;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f18167i.setOrientation(0);
        addView(this.f18167i);
    }

    public void i(int i2) {
        if (this.k != i2) {
            Iterator<ItemViewHolder> it = this.j.iterator();
            while (it.hasNext()) {
                ItemViewHolder next = it.next();
                if (next != null) {
                    g(next, i2);
                }
            }
            this.k = i2;
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
            for (int i2 = 0; i2 < count - count2; i2++) {
                TypeAdapter.ViewHolder viewHolder = (TypeAdapter.ViewHolder) ListUtils.getItem(this.j, 0);
                if (viewHolder != null) {
                    this.f18167i.removeView(viewHolder.a());
                }
                this.j.remove(viewHolder);
            }
        }
        int i3 = 0;
        while (i3 < count2) {
            HorRankCard.a aVar = (HorRankCard.a) ListUtils.getItem(list, i3);
            ItemViewHolder itemViewHolder = (ItemViewHolder) ListUtils.getItem(this.j, i3);
            if (itemViewHolder != null) {
                f(itemViewHolder.a(), aVar, i3, i3 == count2 + (-1));
            } else {
                View e2 = e();
                if (e2 != null) {
                    ItemViewHolder itemViewHolder2 = new ItemViewHolder(e2);
                    this.j.add(itemViewHolder2);
                    f(itemViewHolder2.a(), aVar, i3, i3 == count2 + (-1));
                    this.f18167i.addView(e2);
                }
            }
            i3++;
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
        this.f18164f = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f18166h * (((int) (0.5d + d3)) - 1))) / d3);
    }

    public void setRatio(double d2) {
        this.f18165g = (int) ((this.f18164f * d2) + 0.5d);
    }

    public void setRound(boolean z) {
        this.f18163e = z;
        if (z) {
            this.f18166h = (int) getResources().getDimension(R.dimen.ds36);
        } else {
            this.f18166h = (int) getResources().getDimension(R.dimen.ds18);
        }
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18163e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18163e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }
}
