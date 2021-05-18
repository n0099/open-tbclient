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
import d.a.k0.d3.v;
import d.a.k0.j1.i;
import d.a.k0.x.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class HorizontalScrollListView extends MyHorizontalScrollView {

    /* renamed from: e  reason: collision with root package name */
    public boolean f18095e;

    /* renamed from: f  reason: collision with root package name */
    public int f18096f;

    /* renamed from: g  reason: collision with root package name */
    public int f18097g;

    /* renamed from: h  reason: collision with root package name */
    public int f18098h;

    /* renamed from: i  reason: collision with root package name */
    public LinearLayout f18099i;
    public final ArrayList<ItemViewHolder> j;
    public int k;
    public TbPageContext l;

    /* loaded from: classes4.dex */
    public static class ItemViewHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f18100a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f18101b;

        /* renamed from: c  reason: collision with root package name */
        public FrameLayout f18102c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f18103d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f18104e;

        /* renamed from: f  reason: collision with root package name */
        public HeadImageView f18105f;

        /* renamed from: g  reason: collision with root package name */
        public TbImageView f18106g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f18107h;

        /* renamed from: i  reason: collision with root package name */
        public LinearLayout f18108i;
        public TextView j;
        public TextView k;
        public LinearLayout l;
        public TextView m;

        public ItemViewHolder(View view) {
            super(view);
            this.f18101b = null;
            this.f18102c = null;
            this.f18103d = null;
            this.f18104e = null;
            this.f18105f = null;
            this.f18106g = null;
            this.f18107h = null;
            this.f18108i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.f18100a = (LinearLayout) view.findViewById(R.id.ll_name);
            this.f18102c = (FrameLayout) view.findViewById(R.id.fl_left);
            this.f18103d = (ImageView) view.findViewById(R.id.leftBack);
            this.f18101b = (ImageView) view.findViewById(R.id.leftIcon);
            this.f18104e = (TextView) view.findViewById(R.id.leftText);
            HeadImageView headImageView = (HeadImageView) view.findViewById(R.id.head);
            this.f18105f = headImageView;
            headImageView.setGifIconSupport(false);
            this.f18106g = (TbImageView) view.findViewById(R.id.head_icon);
            this.f18107h = (TextView) view.findViewById(R.id.m_forum_name_textview);
            this.f18108i = (LinearLayout) view.findViewById(R.id.ll_subtitle);
            this.j = (TextView) view.findViewById(R.id.subtitle);
            this.k = (TextView) view.findViewById(R.id.leftTopText);
            this.l = (LinearLayout) view.findViewById(R.id.ll_post);
            this.m = (TextView) view.findViewById(R.id.btn_post);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18109e;

        public a(HorRankCard.a aVar) {
            this.f18109e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f18109e.j)) {
                return;
            }
            t.b().d(true);
            i.e(this.f18109e.m).d(TiebaStatic.Params.OBJ_URL, this.f18109e.j).a(this.f18109e.m);
            v.c(HorizontalScrollListView.this.l, this.f18109e.j);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorRankCard.a f18111e;

        public b(HorRankCard.a aVar) {
            this.f18111e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(HorizontalScrollListView.this.getContext())) {
                d.a.k0.j1.m.b a2 = d.a.k0.j1.m.b.a();
                HorRankCard.a aVar = this.f18111e;
                a2.e(aVar, aVar.f17966f, null, null);
            }
        }
    }

    public HorizontalScrollListView(Context context) {
        super(context);
        this.f18095e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public final void d(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.ds24);
        } else {
            layoutParams.leftMargin = this.f18098h;
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
        if (this.f18095e) {
            itemViewHolder.f18105f.setIsRound(true);
            itemViewHolder.k.setVisibility(8);
            int i3 = aVar.f17961a;
            if (i3 <= 0) {
                itemViewHolder.f18101b.setVisibility(8);
                itemViewHolder.f18102c.setVisibility(8);
            } else if (i3 == 1) {
                itemViewHolder.f18101b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18101b, R.drawable.icon_grade_star_no1);
                itemViewHolder.f18102c.setVisibility(8);
            } else if (i3 == 2) {
                itemViewHolder.f18101b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18101b, R.drawable.icon_grade_star_no2);
                itemViewHolder.f18102c.setVisibility(8);
            } else if (i3 != 3) {
                itemViewHolder.f18102c.setVisibility(0);
                itemViewHolder.f18103d.getDrawable().setColorFilter(SkinManager.getColor(R.color.CAM_X0204), PorterDuff.Mode.SRC);
                itemViewHolder.f18101b.setVisibility(8);
                SkinManager.setViewTextColor(itemViewHolder.f18104e, R.color.CAM_X0111);
                TextView textView = itemViewHolder.f18104e;
                textView.setText("" + (i2 + 1));
            } else {
                itemViewHolder.f18101b.setVisibility(0);
                SkinManager.setImageResource(itemViewHolder.f18101b, R.drawable.icon_grade_star_no3);
                itemViewHolder.f18102c.setVisibility(8);
            }
        } else {
            itemViewHolder.f18105f.setIsRound(false);
            SkinManager.setViewTextColor(itemViewHolder.k, R.color.CAM_X0111);
            itemViewHolder.f18101b.setVisibility(8);
            itemViewHolder.f18102c.setVisibility(8);
            if (aVar.f17961a <= 0) {
                itemViewHolder.k.setVisibility(8);
            } else {
                itemViewHolder.k.setVisibility(0);
                itemViewHolder.k.setText(String.valueOf(aVar.f17961a));
                if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                    if (!d.a.k0.j1.o.k.b.a(aVar.l)) {
                        itemViewHolder.k.setBackgroundColor(aVar.l);
                    } else {
                        SkinManager.setBackgroundColor(itemViewHolder.k, d.a.k0.j1.a.f56408a[i2 <= 3 ? i2 : 3]);
                    }
                } else if (!d.a.k0.j1.o.k.b.a(aVar.k)) {
                    itemViewHolder.k.setBackgroundColor(aVar.k);
                } else {
                    SkinManager.setBackgroundColor(itemViewHolder.k, d.a.k0.j1.a.f56408a[i2 <= 3 ? i2 : 3]);
                }
            }
            itemViewHolder.f18105f.setRadius(0);
        }
        if (!TextUtils.isEmpty(aVar.j)) {
            itemViewHolder.f18105f.setOnClickListener(new a(aVar));
        } else {
            itemViewHolder.f18105f.setOnClickListener(null);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) itemViewHolder.f18105f.getLayoutParams();
        layoutParams.width = this.f18096f;
        layoutParams.height = this.f18097g;
        d(layoutParams, i2);
        if (this.f18095e) {
            layoutParams.topMargin = getResources().getDimensionPixelSize(R.dimen.ds10);
        } else {
            layoutParams.topMargin = 0;
        }
        itemViewHolder.f18105f.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) itemViewHolder.k.getLayoutParams();
        d(layoutParams2, i2);
        itemViewHolder.k.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) itemViewHolder.f18100a.getLayoutParams();
        layoutParams3.width = this.f18096f;
        d(layoutParams3, i2);
        itemViewHolder.f18100a.setLayoutParams(layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) itemViewHolder.f18108i.getLayoutParams();
        layoutParams4.width = this.f18096f;
        d(layoutParams4, i2);
        itemViewHolder.f18108i.setLayoutParams(layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) itemViewHolder.l.getLayoutParams();
        layoutParams5.width = this.f18096f;
        d(layoutParams5, i2);
        itemViewHolder.l.setLayoutParams(layoutParams5);
        itemViewHolder.f18105f.setTag(aVar.f17962b);
        itemViewHolder.f18105f.V(aVar.f17962b, 10, false);
        if (!TextUtils.isEmpty(aVar.f17963c)) {
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) itemViewHolder.f18106g.getLayoutParams();
            int g2 = l.g(getContext(), R.dimen.ds30);
            int g3 = l.g(getContext(), R.dimen.ds6);
            int g4 = l.g(getContext(), R.dimen.ds18);
            int i4 = ((this.f18096f - g2) + this.f18098h) - g3;
            if (i2 == 0) {
                i4 = (i4 - g4) + g3;
            }
            layoutParams6.setMargins(i4, (this.f18097g - g2) + g3, 0, 0);
            itemViewHolder.f18106g.setLayoutParams(layoutParams6);
            itemViewHolder.f18106g.V(aVar.f17963c, 10, false);
        } else {
            itemViewHolder.f18106g.setVisibility(8);
        }
        if (aVar.f17964d != null) {
            itemViewHolder.f18107h.setVisibility(0);
            if (this.f18095e) {
                if (aVar.f17961a <= 0) {
                    itemViewHolder.f18107h.setMaxWidth(this.f18096f);
                } else {
                    itemViewHolder.f18107h.setMaxWidth((this.f18096f - getResources().getDimensionPixelSize(R.dimen.ds22)) - getResources().getDimensionPixelSize(R.dimen.ds4));
                }
            } else {
                itemViewHolder.f18107h.setMaxWidth(this.f18096f);
            }
            itemViewHolder.f18107h.setText(aVar.f17964d);
        } else {
            itemViewHolder.f18107h.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f17965e)) {
            try {
                itemViewHolder.j.setText(StringHelper.numberUniformFormat(Long.parseLong(aVar.f17965e)).toLowerCase());
            } catch (Exception unused) {
                itemViewHolder.j.setText(aVar.f17965e);
            }
            SkinManager.setViewTextColor(itemViewHolder.j, R.color.CAM_X0312);
            itemViewHolder.j.setVisibility(0);
        } else {
            itemViewHolder.j.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.f17966f) && !TextUtils.isEmpty(aVar.f17968h) && !TextUtils.isEmpty(aVar.f17969i)) {
            itemViewHolder.l.setVisibility(0);
            j(itemViewHolder.m, aVar.f17967g, aVar.f17968h, aVar.f17969i);
            itemViewHolder.m.setTag(aVar.f17966f);
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
        SkinManager.setViewTextColor(itemViewHolder.f18107h, R.color.CAM_X0108, 1);
    }

    public final void h(Context context) {
        this.f18098h = (int) context.getResources().getDimension(R.dimen.ds36);
        this.f18096f = (int) context.getResources().getDimension(R.dimen.ds102);
        this.f18097g = (int) context.getResources().getDimension(R.dimen.ds102);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f18099i = linearLayout;
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f18099i.setOrientation(0);
        addView(this.f18099i);
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
                    this.f18099i.removeView(viewHolder.a());
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
                    this.f18099i.addView(e2);
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
        this.f18096f = (int) (((getResources().getDisplayMetrics().widthPixels - dimensionPixelSize) - (this.f18098h * (((int) (0.5d + d3)) - 1))) / d3);
    }

    public void setRatio(double d2) {
        this.f18097g = (int) ((this.f18096f * d2) + 0.5d);
    }

    public void setRound(boolean z) {
        this.f18095e = z;
        if (z) {
            this.f18098h = (int) getResources().getDimension(R.dimen.ds36);
        } else {
            this.f18098h = (int) getResources().getDimension(R.dimen.ds18);
        }
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18095e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }

    public HorizontalScrollListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18095e = false;
        this.j = new ArrayList<>();
        this.k = 3;
        h(context);
    }
}
