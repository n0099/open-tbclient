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
/* loaded from: classes6.dex */
public class LandingDislikeDialog extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f28916a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28917b;

    /* renamed from: c  reason: collision with root package name */
    public TTDislikeListView f28918c;

    /* renamed from: d  reason: collision with root package name */
    public b f28919d;

    /* renamed from: e  reason: collision with root package name */
    public View f28920e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28921f;

    /* renamed from: g  reason: collision with root package name */
    public l f28922g;

    /* renamed from: h  reason: collision with root package name */
    public a f28923h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28924i;
    public String j;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(int i2, FilterWord filterWord);

        void a(View view);

        void b(View view);
    }

    /* loaded from: classes6.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f28930b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f28931c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f28932d;

        /* loaded from: classes6.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28933a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f28934b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f28931c = list;
            this.f28932d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f28931c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f28931c.get(i2);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public View getView(int i2, View view, ViewGroup viewGroup) {
            View view2;
            a aVar;
            if (view == null) {
                aVar = new a();
                LayoutInflater layoutInflater = this.f28932d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f28933a = (TextView) view2.findViewById(ad.e(this.f28932d.getContext(), "tt_item_tv"));
                aVar.f28934b = (FlowLayout) view2.findViewById(ad.e(this.f28932d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f28931c.get(i2);
            aVar.f28933a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i2 != this.f28931c.size() - 1) {
                    aVar.f28933a.setBackgroundResource(ad.d(this.f28932d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f28933a.setBackgroundResource(ad.d(this.f28932d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f28930b && i2 == 0) {
                aVar.f28933a.setBackgroundResource(ad.d(this.f28932d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f28934b.removeAllViews();
                for (int i3 = 0; i3 < filterWord.getOptions().size(); i3++) {
                    LayoutInflater layoutInflater2 = this.f28932d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f28934b, false);
                    textView.setText(filterWord.getOptions().get(i3).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i3), i3));
                    aVar.f28934b.addView(textView);
                }
                aVar.f28934b.setVisibility(0);
            } else {
                aVar.f28934b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f28937b;

        /* renamed from: c  reason: collision with root package name */
        public int f28938c;

        public c(FilterWord filterWord, int i2) {
            this.f28937b = filterWord;
            this.f28938c = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LandingDislikeDialog.this.f28923h.a(this.f28938c, this.f28937b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28937b);
            com.bytedance.sdk.openadsdk.c.d.a(LandingDislikeDialog.this.f28922g, arrayList);
            LandingDislikeDialog.this.a(true);
        }
    }

    public LandingDislikeDialog(@NonNull Context context, @NonNull l lVar, String str) {
        this(context);
        this.f28922g = lVar;
        this.j = str;
        b();
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f28918c;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.f28923h = aVar;
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
        this.f28916a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = al.c(getContext(), 345.0f);
        this.f28916a.setLayoutParams(layoutParams);
        this.f28916a.setClickable(true);
        c();
        b();
    }

    private void b() {
        if (this.f28922g == null) {
            return;
        }
        b bVar = new b(LayoutInflater.from(getContext()), this.f28922g.ar());
        this.f28919d = bVar;
        this.f28918c.setAdapter((ListAdapter) bVar);
        this.f28918c.setMaterialMeta(this.f28922g);
        if (this.f28922g.as() != null) {
            this.f28920e.setVisibility(0);
            this.f28921f.setText(this.f28922g.as().getName());
            this.f28920e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(LandingDislikeDialog.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", LandingDislikeDialog.this.f28922g.as().getName());
                    intent.putExtra("url", LandingDislikeDialog.this.f28922g.as().getUrl());
                    intent.putExtra("tag", LandingDislikeDialog.this.j);
                    intent.putExtra("meta", LandingDislikeDialog.this.f28922g.aL().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(LandingDislikeDialog.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(LandingDislikeDialog.this.getContext(), LandingDislikeDialog.this.f28922g, LandingDislikeDialog.this.j, "ad_explation_click");
                }
            });
        }
    }

    private void c() {
        this.f28920e = this.f28916a.findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f28921f = (TextView) this.f28916a.findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) this.f28916a.findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f28917b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandingDislikeDialog.this.f28923h != null) {
                    LandingDislikeDialog.this.a(false);
                    LandingDislikeDialog.this.f28923h.a();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.f28916a.findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f28918c = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (LandingDislikeDialog.this.f28923h != null) {
                    try {
                        LandingDislikeDialog.this.f28923h.a(i2, LandingDislikeDialog.this.f28922g.ar().get(i2));
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

    public LandingDislikeDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28924i = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.f28916a.getParent() == null) {
            addView(this.f28916a);
        }
        if (this.f28920e.isShown()) {
            com.bytedance.sdk.openadsdk.c.d.b(getContext(), this.f28922g, this.j, "ad_explation_show");
        }
        d();
        setVisibility(0);
        this.f28924i = true;
        a aVar = this.f28923h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.f28924i = false;
        a aVar = this.f28923h;
        if (aVar == null || !z) {
            return;
        }
        aVar.b(this);
    }
}
