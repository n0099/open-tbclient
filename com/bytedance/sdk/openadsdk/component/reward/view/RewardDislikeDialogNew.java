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
    public View f27663a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f27664b;

    /* renamed from: c  reason: collision with root package name */
    public TTDislikeListView f27665c;

    /* renamed from: d  reason: collision with root package name */
    public b f27666d;

    /* renamed from: e  reason: collision with root package name */
    public View f27667e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f27668f;

    /* renamed from: g  reason: collision with root package name */
    public l f27669g;

    /* renamed from: h  reason: collision with root package name */
    public a f27670h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27671i;
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
        public boolean f27677b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f27678c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f27679d;

        /* loaded from: classes6.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f27680a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f27681b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f27678c = list;
            this.f27679d = layoutInflater;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f27678c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f27678c.get(i2);
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
                LayoutInflater layoutInflater = this.f27679d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f27680a = (TextView) view2.findViewById(ad.e(this.f27679d.getContext(), "tt_item_tv"));
                aVar.f27681b = (FlowLayout) view2.findViewById(ad.e(this.f27679d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f27678c.get(i2);
            aVar.f27680a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i2 != this.f27678c.size() - 1) {
                    aVar.f27680a.setBackgroundResource(ad.d(this.f27679d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f27680a.setBackgroundResource(ad.d(this.f27679d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f27677b && i2 == 0) {
                aVar.f27680a.setBackgroundResource(ad.d(this.f27679d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f27681b.removeAllViews();
                for (int i3 = 0; i3 < filterWord.getOptions().size(); i3++) {
                    LayoutInflater layoutInflater2 = this.f27679d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f27681b, false);
                    textView.setText(filterWord.getOptions().get(i3).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i3), i3));
                    aVar.f27681b.addView(textView);
                }
                aVar.f27681b.setVisibility(0);
            } else {
                aVar.f27681b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f27684b;

        /* renamed from: c  reason: collision with root package name */
        public int f27685c;

        public c(FilterWord filterWord, int i2) {
            this.f27684b = filterWord;
            this.f27685c = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RewardDislikeDialogNew.this.f27670h.a(this.f27685c, this.f27684b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f27684b);
            d.a(RewardDislikeDialogNew.this.f27669g, arrayList);
            RewardDislikeDialogNew.this.a(true);
        }
    }

    public RewardDislikeDialogNew(@NonNull Context context, @NonNull l lVar, String str) {
        this(context);
        this.f27669g = lVar;
        this.j = str;
        b();
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f27665c;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void setCallback(a aVar) {
        this.f27670h = aVar;
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
        this.f27663a = LayoutInflater.from(context).inflate(ad.f(context, "tt_dislike_dialog_layout2"), (ViewGroup) this, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 17;
        layoutParams.width = al.c(getContext(), 345.0f);
        this.f27663a.setLayoutParams(layoutParams);
        this.f27663a.setClickable(true);
        c();
        b();
    }

    private void b() {
        View view;
        if (this.f27669g == null) {
            return;
        }
        b bVar = new b(LayoutInflater.from(getContext()), this.f27669g.ar());
        this.f27666d = bVar;
        this.f27665c.setAdapter((ListAdapter) bVar);
        this.f27665c.setMaterialMeta(this.f27669g);
        if (this.f27669g.as() == null || (view = this.f27667e) == null || this.f27668f == null) {
            return;
        }
        view.setVisibility(0);
        this.f27668f.setText(this.f27669g.as().getName());
        this.f27667e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(RewardDislikeDialogNew.this.getContext(), TTDislikeWebViewActivity.class));
                intent.putExtra("title", RewardDislikeDialogNew.this.f27669g.as().getName());
                intent.putExtra("url", RewardDislikeDialogNew.this.f27669g.as().getUrl());
                intent.putExtra("tag", RewardDislikeDialogNew.this.j);
                intent.putExtra("meta", RewardDislikeDialogNew.this.f27669g.aL().toString());
                com.bytedance.sdk.openadsdk.utils.b.a(RewardDislikeDialogNew.this.getContext(), intent, null);
                d.b(RewardDislikeDialogNew.this.getContext(), RewardDislikeDialogNew.this.f27669g, RewardDislikeDialogNew.this.j, "ad_explation_click");
            }
        });
    }

    private void c() {
        this.f27667e = this.f27663a.findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f27668f = (TextView) this.f27663a.findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) this.f27663a.findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f27664b = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardDislikeDialogNew.this.f27670h != null) {
                    RewardDislikeDialogNew.this.a(false);
                    RewardDislikeDialogNew.this.f27670h.a();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) this.f27663a.findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f27665c = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.RewardDislikeDialogNew.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (RewardDislikeDialogNew.this.f27670h != null) {
                    try {
                        RewardDislikeDialogNew.this.f27670h.a(i2, RewardDislikeDialogNew.this.f27669g.ar().get(i2));
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

    public RewardDislikeDialogNew(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f27671i = false;
        a(context, attributeSet);
    }

    public void a() {
        if (this.f27663a.getParent() == null) {
            addView(this.f27663a);
        }
        d();
        setVisibility(0);
        this.f27671i = true;
        if (this.f27667e.isShown()) {
            d.b(getContext(), this.f27669g, this.j, "ad_explation_show");
        }
        a aVar = this.f27670h;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(boolean z) {
        setVisibility(8);
        this.f27671i = false;
        a aVar = this.f27670h;
        if (aVar == null || !z) {
            return;
        }
        aVar.b(this);
    }

    public void a(String str) {
        this.f27669g.c(str);
        this.f27665c.setMaterialMeta(this.f27669g);
    }
}
