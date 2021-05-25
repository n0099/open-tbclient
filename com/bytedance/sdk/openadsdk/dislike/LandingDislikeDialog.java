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
    public View f28845a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28846b;

    /* renamed from: c  reason: collision with root package name */
    public TTDislikeListView f28847c;

    /* renamed from: d  reason: collision with root package name */
    public b f28848d;

    /* renamed from: e  reason: collision with root package name */
    public View f28849e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28850f;

    /* renamed from: g  reason: collision with root package name */
    public l f28851g;

    /* renamed from: h  reason: collision with root package name */
    public a f28852h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28853i;
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
        public boolean f28859b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f28860c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f28861d;

        /* loaded from: classes6.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28862a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f28863b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f28860c = list;
            this.f28861d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f28860c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f28860c.get(i2);
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
                LayoutInflater layoutInflater = this.f28861d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f28862a = (TextView) view2.findViewById(ad.e(this.f28861d.getContext(), "tt_item_tv"));
                aVar.f28863b = (FlowLayout) view2.findViewById(ad.e(this.f28861d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f28860c.get(i2);
            aVar.f28862a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i2 != this.f28860c.size() - 1) {
                    aVar.f28862a.setBackgroundResource(ad.d(this.f28861d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f28862a.setBackgroundResource(ad.d(this.f28861d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f28859b && i2 == 0) {
                aVar.f28862a.setBackgroundResource(ad.d(this.f28861d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f28863b.removeAllViews();
                for (int i3 = 0; i3 < filterWord.getOptions().size(); i3++) {
                    LayoutInflater layoutInflater2 = this.f28861d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f28863b, false);
                    textView.setText(filterWord.getOptions().get(i3).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i3), i3));
                    aVar.f28863b.addView(textView);
                }
                aVar.f28863b.setVisibility(0);
            } else {
                aVar.f28863b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f28866b;

        /* renamed from: c  reason: collision with root package name */
        public int f28867c;

        public c(FilterWord filterWord, int i2) {
            this.f28866b = filterWord;
            this.f28867c = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LandingDislikeDialog.this.f28852h.a(this.f28867c, this.f28866b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28866b);
            com.bytedance.sdk.openadsdk.c.d.a(LandingDislikeDialog.this.f28851g, arrayList);
            LandingDislikeDialog.this.a(true);
        }
    }

    public LandingDislikeDialog(@NonNull Context context, @NonNull l lVar, String str) {
        this(context);
        this.f28851g = lVar;
        this.j = str;
        b();
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f28847c;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.f28852h = aVar;
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
        this.f28845a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = al.c(getContext(), 345.0f);
        this.f28845a.setLayoutParams(layoutParams);
        this.f28845a.setClickable(true);
        c();
        b();
    }

    private void b() {
        if (this.f28851g == null) {
            return;
        }
        b bVar = new b(LayoutInflater.from(getContext()), this.f28851g.ar());
        this.f28848d = bVar;
        this.f28847c.setAdapter((ListAdapter) bVar);
        this.f28847c.setMaterialMeta(this.f28851g);
        if (this.f28851g.as() != null) {
            this.f28849e.setVisibility(0);
            this.f28850f.setText(this.f28851g.as().getName());
            this.f28849e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(LandingDislikeDialog.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", LandingDislikeDialog.this.f28851g.as().getName());
                    intent.putExtra("url", LandingDislikeDialog.this.f28851g.as().getUrl());
                    intent.putExtra("tag", LandingDislikeDialog.this.j);
                    intent.putExtra("meta", LandingDislikeDialog.this.f28851g.aL().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(LandingDislikeDialog.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(LandingDislikeDialog.this.getContext(), LandingDislikeDialog.this.f28851g, LandingDislikeDialog.this.j, "ad_explation_click");
                }
            });
        }
    }

    private void c() {
        this.f28849e = this.f28845a.findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f28850f = (TextView) this.f28845a.findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) this.f28845a.findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f28846b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (LandingDislikeDialog.this.f28852h != null) {
                    LandingDislikeDialog.this.a(false);
                    LandingDislikeDialog.this.f28852h.a();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.f28845a.findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f28847c = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.LandingDislikeDialog.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (LandingDislikeDialog.this.f28852h != null) {
                    try {
                        LandingDislikeDialog.this.f28852h.a(i2, LandingDislikeDialog.this.f28851g.ar().get(i2));
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
        this.f28853i = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.f28845a.getParent() == null) {
            addView(this.f28845a);
        }
        if (this.f28849e.isShown()) {
            com.bytedance.sdk.openadsdk.c.d.b(getContext(), this.f28851g, this.j, "ad_explation_show");
        }
        d();
        setVisibility(0);
        this.f28853i = true;
        a aVar = this.f28852h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.f28853i = false;
        a aVar = this.f28852h;
        if (aVar == null || !z) {
            return;
        }
        aVar.b(this);
    }
}
