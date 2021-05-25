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
import d.a.n0.e3.v;
import d.a.n0.k1.i;
import d.a.n0.z.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18005e;

    /* renamed from: f  reason: collision with root package name */
    public int f18006f;

    /* renamed from: g  reason: collision with root package name */
    public int f18007g;

    /* renamed from: h  reason: collision with root package name */
    public int f18008h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f18009i;
    public final ArrayList<ItemViewHolder> j;
    public int k;
    public TbPageContext l;

    /* loaded from: classes4.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f18010a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f18011b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f18012c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18013d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18014e;

        /* renamed from: f  reason: collision with root package name */
        public HeadImageView f18015f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f18016g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18017h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f18018i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public ItemViewHolder(View view) {
            super(view);
            this.f18011b = null;
            this.f18012c = null;
            this.f18013d = null;
            this.f18014e = null;
            this.f18015f = null;
            this.f18016g = null;
            this.f18017h = null;
            this.f18018i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.f18010a = (LinearLayout) view.findViewById(R.id.ll_name);
            this.f18012c = (FrameLayout) view.findViewById(R.id.fl_left);
            this.f18013d = (ImageView) view.findViewById(R.id.leftBack);
            this.f18011b = (ImageView) view.findViewById(R.id.leftIcon);
            this.f18014e = (TextView) view.findViewById(R.id.leftText);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head);
            this.f18015f = headImageView;
            headImageView.setGifIconSupport(false);
            this.f18016g = (TbImageView) view.findViewById(R.id.head_icon);
            this.f18017h = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f18018i = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.j = (TextView) view.findViewById(R.id.subtitle);
            this.k = (TextView) view.findViewById(R.id.leftTopText);
            this.l = (LinearLayout) view.findViewById(R.id.ll_post);
            this.m = (TextView) view.findViewById(R.id.btn_post);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18019e;

        public a(HorRankCard.a aVar) {
            this.f18019e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18019e.j)) {
                return;
            }
            t.b().d(true);
            i.e(this.f18019e.m).d(TiebaStatic.Params.OBJ_URL, this.f18019e.j).a(this.f18019e.m);
            v.c(HorizontalScrollListView.this.l, this.f18019e.j);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18021e;

        public b(HorRankCard.a aVar) {
            this.f18021e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(HorizontalScrollListView.this.getContext())) {
                d.a.n0.k1.m.b a2 = d.a.n0.k1.m.b.a();
                HorRankCard.a aVar = this.f18021e;
                a2.e(aVar, aVar.f17876f, null, null);
            }
        }
    }

    public HorizontalScrollListView(Context context) {
        super(context);
        this.f18005e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
        } else {
            layoutParams.leftMargin = this.f18008h;
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
        if (this.f18005e) {
            itemViewHolder.f18015f.setIsRound(true);
            itemViewHolder.k.setVisibility(8);
            int i3 = aVar.f17871a;
            if (i3 <= 0) {
                itemViewHolder.f18011b.setVisibility(8);
                itemViewHolder.f18012c.setVisibility(8);
            } else if (i3 == 1) {
                itemViewHolder.f18011b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18011b, R.drawable.icon_grade_star_no1);
                itemViewHolder.f18012c.setVisibility(8);
            } else if (i3 == 2) {
                itemViewHolder.f18011b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18011b, R.drawable.icon_grade_star_no2);
                itemViewHolder.f18012c.setVisibility(8);
            } else if (i3 != 3) {
                itemViewHolder.f18012c.setVisibility(0);
                itemViewHolder.f18013d.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.f18011b.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.f18014e, R.color.CAM_X0111);
                TextView textView = itemViewHolder.f18014e;
                textView.setText("" + (i2 + 1));
            } else {
                itemViewHolder.f18011b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18011b, R.drawable.icon_grade_star_no3);
                itemViewHolder.f18012c.setVisibility(8);
            }
        } else {
            itemViewHolder.f18015f.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.k, R.color.CAM_X0111);
            itemViewHolder.f18011b.setVisibility(8);
            itemViewHolder.f18012c.setVisibility(8);
            if (aVar.f17871a <= 0) {
                itemViewHolder.k.setVisibility(8);
            } else {
                itemViewHolder.k.setVisibility(0);
                itemViewHolder.k.setText(String.valueOf(aVar.f17871a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!d.a.n0.k1.o.k.b.a(aVar.l)) {
                        itemViewHolder.k.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.k, d.a.n0.k1.a.f56588a[i2 <= 3 ? i2 : 3]);
                    }
                } else if (!d.a.n0.k1.o.k.b.a(aVar.k)) {
                    itemViewHolder.k.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.k, d.a.n0.k1.a.f56588a[i2 <= 3 ? i2 : 3]);
                }
            }
            itemViewHolder.f18015f.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.f18015f.setOnClickListener(new a(aVar));
        } else {
            itemViewHolder.f18015f.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.f18015f.getLayoutParams();
        layoutParams.width = this.f18006f;
        layoutParams.height = this.f18007g;
        d(layoutParams, i2);
        if (this.f18005e) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.f18015f.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.k.getLayoutParams();
        d(layoutParams2, i2);
        itemViewHolder.k.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.f18010a.getLayoutParams();
        layoutParams3.width = this.f18006f;
        d(layoutParams3, i2);
        itemViewHolder.f18010a.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.f18018i.getLayoutParams();
        layoutParams4.width = this.f18006f;
        d(layoutParams4, i2);
        itemViewHolder.f18018i.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.l.getLayoutParams();
        layoutParams5.width = this.f18006f;
        d(layoutParams5, i2);
        itemViewHolder.l.setLayoutParams(layoutParams5);
        itemViewHolder.f18015f.setTag(aVar.f17872b);
        itemViewHolder.f18015f.V(aVar.f17872b, 10, false);
        if (!TextUtils.isEmpty(aVar.f17873c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.f18016g.getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.ds30);
            int g3 = l.g(getContext(), R.dimen.ds6);
            int g4 = l.g(getContext(), R.dimen.ds18);
            int i4 = ((this.f18006f - g2) + this.f18008h) - g3;
            if (i2 == 0) {
                i4 = (i4 - g4) + g3;
            }
            layoutParams6.setMargins(i4, (this.f18007g - g2) + g3, 0, 0);
            itemViewHolder.f18016g.setLayoutParams(layoutParams6);
            itemViewHolder.f18016g.V(aVar.f17873c, 10, false);
        } else {
            itemViewHolder.f18016g.setVisibility(8);
        }
        if (aVar.f17874d != null) {
            itemViewHolder.f18017h.setVisibility(0);
            if (this.f18005e) {
                if (aVar.f17871a <= 0) {
                    itemViewHolder.f18017h.setMaxWidth(this.f18006f);
                } else {
                    itemViewHolder.f18017h.setMaxWidth((this.f18006f - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                }
            } else {
                itemViewHolder.f18017h.setMaxWidth(this.f18006f);
            }
            itemViewHolder.f18017h.setText(aVar.f17874d);
        } else {
            itemViewHolder.f18017h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f17875e)) {
            try {
                itemViewHolder.j.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f17875e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.j.setText(aVar.f17875e);
            }
            SkinManager.setViewTextColor(itemViewHolder.j, R.color.CAM_X0312);
            itemViewHolder.j.setVisibility(0);
        } else {
            itemViewHolder.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f17876f) && !TextUtils.isEmpty(aVar.f17878h) && !TextUtils.isEmpty(aVar.f17879i)) {
            itemViewHolder.l.setVisibility(0);
            j(itemViewHolder.m, aVar.f17877g, aVar.f17878h, aVar.f17879i);
            itemViewHolder.m.setTag(aVar.f17876f);
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
        SkinManager.setViewTextColor(itemViewHolder.f18017h, R.color.CAM_X0108, 1);
    }

    public final void h(Context context) {
        this.f18008h = (int) context.getResources().getDimension(R.dimen.ds36);
        this.f18006f = (int) context.getResources().getDimension(R.dimen.ds102);
        this.f18007g = (int) context.getResources().getDimension(R.dimen.ds102);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f18009i = linearLayout;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f18009i.setOrientation(0);
        addView(this.f18009i);
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
                    this.f18009i.removeView(viewHolder.a());
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
                    this.f18009i.addView(e2);
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
        this.f18006f = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f18008h * (((int) (0.5d + d3)) - 1))) / d3);
    }

    public void setRatio(double d2) {
        this.f18007g = (int) ((this.f18006f * d2) + 0.5d);
    }

    public void setRound(boolean z) {
        this.f18005e = z;
        if (z) {
            this.f18008h = (int) getResources().getDimension(R.dimen.ds36);
        } else {
            this.f18008h = (int) getResources().getDimension(R.dimen.ds18);
        }
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18005e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18005e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }
}
