package com.bytedance.sdk.openadsdk.component.reward.view;

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
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.dislike.FlowLayout;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeListView;
import com.bytedance.sdk.openadsdk.dislike.TTDislikeWebViewActivity;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class RewardDislikeDialogNew extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f27859a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27860b;

    /* renamed from: c  reason: collision with root package name */
    public TTDislikeListView f27861c;

    /* renamed from: d  reason: collision with root package name */
    public b f27862d;

    /* renamed from: e  reason: collision with root package name */
    public View f27863e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27864f;

    /* renamed from: g  reason: collision with root package name */
    public l f27865g;

    /* renamed from: h  reason: collision with root package name */
    public a f27866h;
    public boolean i;
    public String j;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void a(View view);

        void b(View view);
    }

    /* loaded from: classes6.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f27872b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f27873c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f27874d;

        /* loaded from: classes6.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f27875a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f27876b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f27873c = list;
            this.f27874d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f27873c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f27873c.get(i);
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
                LayoutInflater layoutInflater = this.f27874d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f27875a = (TextView) view2.findViewById(ad.e(this.f27874d.getContext(), "tt_item_tv"));
                aVar.f27876b = (FlowLayout) view2.findViewById(ad.e(this.f27874d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f27873c.get(i);
            aVar.f27875a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i != this.f27873c.size() - 1) {
                    aVar.f27875a.setBackgroundResource(ad.d(this.f27874d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f27875a.setBackgroundResource(ad.d(this.f27874d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f27872b && i == 0) {
                aVar.f27875a.setBackgroundResource(ad.d(this.f27874d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f27876b.removeAllViews();
                for (int i2 = 0; i2 < filterWord.getOptions().size(); i2++) {
                    LayoutInflater layoutInflater2 = this.f27874d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f27876b, false);
                    textView.setText(filterWord.getOptions().get(i2).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i2), i2));
                    aVar.f27876b.addView(textView);
                }
                aVar.f27876b.setVisibility(0);
            } else {
                aVar.f27876b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f27879b;

        /* renamed from: c  reason: collision with root package name */
        public int f27880c;

        public c(FilterWord filterWord, int i) {
            this.f27879b = filterWord;
            this.f27880c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RewardDislikeDialogNew.this.f27866h.a(this.f27880c, this.f27879b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f27879b);
            d.a(RewardDislikeDialogNew.this.f27865g, arrayList);
            RewardDislikeDialogNew.this.a(true);
        }
    }

    public RewardDislikeDialogNew(@NonNull Context context, @NonNull l lVar, String str) {
        this(context);
        this.f27865g = lVar;
        this.j = str;
        b();
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f27861c;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.f27866h = aVar;
    }

    private void a(Context context, AttributeSet attributeSet) {
        setClickable(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RewardDislikeDialogNew.this.a(true);
            }
        });
        setBackgroundColor(Color.parseColor("#80000000"));
        this.f27859a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = al.c(getContext(), 345.0f);
        this.f27859a.setLayoutParams(layoutParams);
        this.f27859a.setClickable(true);
        c();
        b();
    }

    private void b() {
        View view;
        if (this.f27865g == null) {
            return;
        }
        b bVar = new b(LayoutInflater.from(getContext()), this.f27865g.ar());
        this.f27862d = bVar;
        this.f27861c.setAdapter((ListAdapter) bVar);
        this.f27861c.setMaterialMeta(this.f27865g);
        if (this.f27865g.as() == null || (view = this.f27863e) == null || this.f27864f == null) {
            return;
        }
        view.setVisibility(0);
        this.f27864f.setText(this.f27865g.as().getName());
        this.f27863e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(RewardDislikeDialogNew.this.getContext(), TTDislikeWebViewActivity.class));
                intent.putExtra("title", RewardDislikeDialogNew.this.f27865g.as().getName());
                intent.putExtra("url", RewardDislikeDialogNew.this.f27865g.as().getUrl());
                intent.putExtra("tag", RewardDislikeDialogNew.this.j);
                intent.putExtra("meta", RewardDislikeDialogNew.this.f27865g.aL().toString());
                com.bytedance.sdk.openadsdk.utils.b.a(RewardDislikeDialogNew.this.getContext(), intent, null);
                d.b(RewardDislikeDialogNew.this.getContext(), RewardDislikeDialogNew.this.f27865g, RewardDislikeDialogNew.this.j, "ad_explation_click");
            }
        });
    }

    private void c() {
        this.f27863e = this.f27859a.findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f27864f = (TextView) this.f27859a.findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) this.f27859a.findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f27860b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardDislikeDialogNew.this.f27866h != null) {
                    RewardDislikeDialogNew.this.a(false);
                    RewardDislikeDialogNew.this.f27866h.a();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.f27859a.findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f27861c = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (RewardDislikeDialogNew.this.f27866h != null) {
                    try {
                        RewardDislikeDialogNew.this.f27866h.a(i, RewardDislikeDialogNew.this.f27865g.ar().get(i));
                    } catch (Throwable unused) {
                    }
                }
                RewardDislikeDialogNew.this.a(true);
            }
        });
    }

    public RewardDislikeDialogNew(@NonNull Context context) {
        this(context, null);
    }

    public RewardDislikeDialogNew(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardDislikeDialogNew(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.f27859a.getParent() == null) {
            addView(this.f27859a);
        }
        d();
        setVisibility(0);
        this.i = true;
        if (this.f27863e.isShown()) {
            d.b(getContext(), this.f27865g, this.j, "ad_explation_show");
        }
        a aVar = this.f27866h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.i = false;
        a aVar = this.f27866h;
        if (aVar == null || !z) {
            return;
        }
        aVar.b(this);
    }

    public void a(String str) {
        this.f27865g.c(str);
        this.f27861c.setMaterialMeta(this.f27865g);
    }
}
