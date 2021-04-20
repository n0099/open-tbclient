package com.bytedance.sdk.openadsdk.dislike;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class LandingDislikeDialog extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f28777a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28778b;

    /* renamed from: c  reason: collision with root package name */
    public TTDislikeListView f28779c;

    /* renamed from: d  reason: collision with root package name */
    public b f28780d;

    /* renamed from: e  reason: collision with root package name */
    public View f28781e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28782f;

    /* renamed from: g  reason: collision with root package name */
    public l f28783g;

    /* renamed from: h  reason: collision with root package name */
    public a f28784h;
    public boolean i;
    public String j;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);
    }

    /* loaded from: classes5.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f28790b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f28791c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f28792d;

        /* loaded from: classes5.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28793a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f28794b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f28791c = list;
            this.f28792d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f28791c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f28791c.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            if (view == null) {
                aVar = new a();
                LayoutInflater layoutInflater = this.f28792d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f28793a = (TextView) view2.findViewById(ad.e(this.f28792d.getContext(), "tt_item_tv"));
                aVar.f28794b = (FlowLayout) view2.findViewById(ad.e(this.f28792d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f28791c.get(i);
            aVar.f28793a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i != this.f28791c.size() - 1) {
                    aVar.f28793a.setBackgroundResource(ad.d(this.f28792d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f28793a.setBackgroundResource(ad.d(this.f28792d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f28790b && i == 0) {
                aVar.f28793a.setBackgroundResource(ad.d(this.f28792d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f28794b.removeAllViews();
                for (int i2 = 0; i2 < filterWord.getOptions().size(); i2++) {
                    LayoutInflater layoutInflater2 = this.f28792d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f28794b, false);
                    textView.setText(filterWord.getOptions().get(i2).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i2), i2));
                    aVar.f28794b.addView(textView);
                }
                aVar.f28794b.setVisibility(0);
            } else {
                aVar.f28794b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f28797b;

        /* renamed from: c  reason: collision with root package name */
        public int f28798c;

        public c(FilterWord filterWord, int i) {
            this.f28797b = filterWord;
            this.f28798c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LandingDislikeDialog.this.f28784h.a(this.f28798c, this.f28797b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28797b);
            com.bytedance.sdk.openadsdk.c.d.a(LandingDislikeDialog.this.f28783g, arrayList);
            LandingDislikeDialog.this.a(true);
        }
    }

    public LandingDislikeDialog(@NonNull Context context, @NonNull l lVar, String str) {
        this(context);
        this.f28783g = lVar;
        this.j = str;
        b();
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f28779c;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.f28784h = aVar;
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LandingDislikeDialog.this.a(true);
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f28777a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = al.c(getContext(), 345.0f);
        this.f28777a.setLayoutParams(layoutParams);
        this.f28777a.setClickable(true);
        c();
        b();
    }

    private void b() {
        if (this.f28783g == null) {
            return;
        }
        b bVar = new b(LayoutInflater.from(getContext()), this.f28783g.ar());
        this.f28780d = bVar;
        this.f28779c.setAdapter((ListAdapter) bVar);
        this.f28779c.setMaterialMeta(this.f28783g);
        if (this.f28783g.as() != null) {
            this.f28781e.setVisibility(0);
            this.f28782f.setText(this.f28783g.as().getName());
            this.f28781e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(LandingDislikeDialog.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", LandingDislikeDialog.this.f28783g.as().getName());
                    intent.putExtra("url", LandingDislikeDialog.this.f28783g.as().getUrl());
                    intent.putExtra("tag", LandingDislikeDialog.this.j);
                    intent.putExtra("meta", LandingDislikeDialog.this.f28783g.aL().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(LandingDislikeDialog.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(LandingDislikeDialog.this.getContext(), LandingDislikeDialog.this.f28783g, LandingDislikeDialog.this.j, "ad_explation_click");
                }
            });
        }
    }

    private void c() {
        this.f28781e = this.f28777a.findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f28782f = (TextView) this.f28777a.findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) this.f28777a.findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f28778b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandingDislikeDialog.this.f28784h != null) {
                    LandingDislikeDialog.this.a(false);
                    LandingDislikeDialog.this.f28784h.a();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.f28777a.findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f28779c = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (LandingDislikeDialog.this.f28784h != null) {
                    try {
                        LandingDislikeDialog.this.f28784h.a(i, LandingDislikeDialog.this.f28783g.ar().get(i));
                    } catch (Throwable unused) {
                    }
                }
                LandingDislikeDialog.this.a(true);
            }
        });
    }

    public LandingDislikeDialog(@NonNull Context context) {
        this(context, null);
    }

    public LandingDislikeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LandingDislikeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.f28777a.getParent() == null) {
            addView(this.f28777a);
        }
        if (this.f28781e.isShown()) {
            com.bytedance.sdk.openadsdk.c.d.b(getContext(), this.f28783g, this.j, "ad_explation_show");
        }
        d();
        setVisibility(0);
        this.i = true;
        a aVar = this.f28784h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.i = false;
        a aVar = this.f28784h;
        if (aVar == null || !z) {
            return;
        }
        aVar.b(this);
    }
}
