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
    public View f29030a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f29031b;

    /* renamed from: c  reason: collision with root package name */
    public TTDislikeListView f29032c;

    /* renamed from: d  reason: collision with root package name */
    public b f29033d;

    /* renamed from: e  reason: collision with root package name */
    public View f29034e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29035f;

    /* renamed from: g  reason: collision with root package name */
    public l f29036g;

    /* renamed from: h  reason: collision with root package name */
    public a f29037h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29038i;
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
        public boolean f29044b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f29045c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f29046d;

        /* loaded from: classes6.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f29047a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f29048b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f29045c = list;
            this.f29046d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f29045c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f29045c.get(i2);
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
                LayoutInflater layoutInflater = this.f29046d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f29047a = (TextView) view2.findViewById(ad.e(this.f29046d.getContext(), "tt_item_tv"));
                aVar.f29048b = (FlowLayout) view2.findViewById(ad.e(this.f29046d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f29045c.get(i2);
            aVar.f29047a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i2 != this.f29045c.size() - 1) {
                    aVar.f29047a.setBackgroundResource(ad.d(this.f29046d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f29047a.setBackgroundResource(ad.d(this.f29046d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f29044b && i2 == 0) {
                aVar.f29047a.setBackgroundResource(ad.d(this.f29046d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f29048b.removeAllViews();
                for (int i3 = 0; i3 < filterWord.getOptions().size(); i3++) {
                    LayoutInflater layoutInflater2 = this.f29046d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f29048b, false);
                    textView.setText(filterWord.getOptions().get(i3).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i3), i3));
                    aVar.f29048b.addView(textView);
                }
                aVar.f29048b.setVisibility(0);
            } else {
                aVar.f29048b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f29051b;

        /* renamed from: c  reason: collision with root package name */
        public int f29052c;

        public c(FilterWord filterWord, int i2) {
            this.f29051b = filterWord;
            this.f29052c = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LandingDislikeDialog.this.f29037h.a(this.f29052c, this.f29051b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f29051b);
            com.bytedance.sdk.openadsdk.c.d.a(LandingDislikeDialog.this.f29036g, arrayList);
            LandingDislikeDialog.this.a(true);
        }
    }

    public LandingDislikeDialog(@NonNull Context context, @NonNull l lVar, String str) {
        this(context);
        this.f29036g = lVar;
        this.j = str;
        b();
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f29032c;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.f29037h = aVar;
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
        this.f29030a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = al.c(getContext(), 345.0f);
        this.f29030a.setLayoutParams(layoutParams);
        this.f29030a.setClickable(true);
        c();
        b();
    }

    private void b() {
        if (this.f29036g == null) {
            return;
        }
        b bVar = new b(LayoutInflater.from(getContext()), this.f29036g.ar());
        this.f29033d = bVar;
        this.f29032c.setAdapter((ListAdapter) bVar);
        this.f29032c.setMaterialMeta(this.f29036g);
        if (this.f29036g.as() != null) {
            this.f29034e.setVisibility(0);
            this.f29035f.setText(this.f29036g.as().getName());
            this.f29034e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(LandingDislikeDialog.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", LandingDislikeDialog.this.f29036g.as().getName());
                    intent.putExtra("url", LandingDislikeDialog.this.f29036g.as().getUrl());
                    intent.putExtra("tag", LandingDislikeDialog.this.j);
                    intent.putExtra("meta", LandingDislikeDialog.this.f29036g.aL().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(LandingDislikeDialog.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(LandingDislikeDialog.this.getContext(), LandingDislikeDialog.this.f29036g, LandingDislikeDialog.this.j, "ad_explation_click");
                }
            });
        }
    }

    private void c() {
        this.f29034e = this.f29030a.findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f29035f = (TextView) this.f29030a.findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) this.f29030a.findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f29031b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandingDislikeDialog.this.f29037h != null) {
                    LandingDislikeDialog.this.a(false);
                    LandingDislikeDialog.this.f29037h.a();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.f29030a.findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f29032c = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (LandingDislikeDialog.this.f29037h != null) {
                    try {
                        LandingDislikeDialog.this.f29037h.a(i2, LandingDislikeDialog.this.f29036g.ar().get(i2));
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
        this.f29038i = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.f29030a.getParent() == null) {
            addView(this.f29030a);
        }
        if (this.f29034e.isShown()) {
            com.bytedance.sdk.openadsdk.c.d.b(getContext(), this.f29036g, this.j, "ad_explation_show");
        }
        d();
        setVisibility(0);
        this.f29038i = true;
        a aVar = this.f29037h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.f29038i = false;
        a aVar = this.f29037h;
        if (aVar == null || !z) {
            return;
        }
        aVar.b(this);
    }
}
