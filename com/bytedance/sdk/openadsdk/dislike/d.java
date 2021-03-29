package com.bytedance.sdk.openadsdk.dislike;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class d extends TTDislikeDialogAbstract {

    /* renamed from: a  reason: collision with root package name */
    public TextView f29155a;

    /* renamed from: b  reason: collision with root package name */
    public TTDislikeListView f29156b;

    /* renamed from: c  reason: collision with root package name */
    public b f29157c;

    /* renamed from: d  reason: collision with root package name */
    public View f29158d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29159e;

    /* renamed from: f  reason: collision with root package name */
    public l f29160f;

    /* renamed from: g  reason: collision with root package name */
    public a f29161g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29162h;
    public String i;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void a(boolean z);

        void b();
    }

    /* loaded from: classes6.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f29169b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f29170c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f29171d;

        /* loaded from: classes6.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f29172a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f29173b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f29170c = list;
            this.f29171d = layoutInflater;
        }

        public void a(List<FilterWord> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.f29170c.clear();
            this.f29170c.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f29170c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f29170c.get(i);
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
                LayoutInflater layoutInflater = this.f29171d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f29172a = (TextView) view2.findViewById(ad.e(this.f29171d.getContext(), "tt_item_tv"));
                aVar.f29173b = (FlowLayout) view2.findViewById(ad.e(this.f29171d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f29170c.get(i);
            aVar.f29172a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i != this.f29170c.size() - 1) {
                    aVar.f29172a.setBackgroundResource(ad.d(this.f29171d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f29172a.setBackgroundResource(ad.d(this.f29171d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f29169b && i == 0) {
                aVar.f29172a.setBackgroundResource(ad.d(this.f29171d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f29173b.removeAllViews();
                for (int i2 = 0; i2 < filterWord.getOptions().size(); i2++) {
                    LayoutInflater layoutInflater2 = this.f29171d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f29173b, false);
                    textView.setText(filterWord.getOptions().get(i2).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i2), i2));
                    aVar.f29173b.addView(textView);
                }
                aVar.f29173b.setVisibility(0);
            } else {
                aVar.f29173b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f29176b;

        /* renamed from: c  reason: collision with root package name */
        public int f29177c;

        public c(FilterWord filterWord, int i) {
            this.f29176b = filterWord;
            this.f29177c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f29161g.a(this.f29177c, this.f29176b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f29176b);
            com.bytedance.sdk.openadsdk.c.d.a(d.this.f29160f, arrayList);
            d.this.dismiss();
        }
    }

    public d(Context context, l lVar, String str) {
        super(context, ad.g(context, "tt_dislikeDialog_new"));
        this.f29162h = false;
        this.f29160f = lVar;
        this.i = str;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int getLayoutId() {
        return ad.f(getContext(), "tt_dislike_dialog_layout2");
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(al.c(getContext(), 345.0f), -2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getPersonalizationPromptIds() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract
    public int[] getTTDislikeListViewIds() {
        return new int[]{ad.e(getContext(), "tt_filer_words_lv")};
    }

    @Override // com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setMaterialMeta(this.f29160f);
        a();
        c();
        b();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        d();
    }

    private void b() {
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                if (d.this.f29161g != null) {
                    d.this.f29162h = false;
                    d.this.f29161g.a();
                }
                if (d.this.f29158d.isShown()) {
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f29160f, d.this.i, "ad_explation_show");
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.f29161g != null) {
                    d.this.f29161g.a(d.this.f29162h);
                }
            }
        });
        if (this.f29160f.as() != null) {
            this.f29158d.setVisibility(0);
            this.f29159e.setText(this.f29160f.as().getName());
            this.f29158d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(d.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", d.this.f29160f.as().getName());
                    intent.putExtra("url", d.this.f29160f.as().getUrl());
                    intent.putExtra("tag", d.this.i);
                    intent.putExtra("meta", d.this.f29160f.aL().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(d.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f29160f, d.this.i, "ad_explation_click");
                }
            });
        }
        b bVar = new b(getLayoutInflater(), this.f29160f.ar());
        this.f29157c = bVar;
        this.f29156b.setAdapter((ListAdapter) bVar);
    }

    private void c() {
        this.f29158d = findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f29159e = (TextView) findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f29155a = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.f29161g != null) {
                    d.this.f29162h = true;
                    d.this.dismiss();
                    d.this.f29161g.b();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f29156b = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.f29161g != null) {
                    try {
                        d.this.f29161g.a(i, d.this.f29160f.ar().get(i));
                    } catch (Throwable unused) {
                    }
                }
                d.this.dismiss();
            }
        });
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f29156b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void a(l lVar) {
        b bVar = this.f29157c;
        if (bVar == null || lVar == null) {
            return;
        }
        this.f29160f = lVar;
        bVar.a(lVar.ar());
        setMaterialMeta(this.f29160f);
    }

    public void a(String str) {
        if (str != null) {
            this.f29160f.c(str);
            a(this.f29160f);
        }
    }

    public void a(a aVar) {
        this.f29161g = aVar;
    }

    private void a() {
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setDimAmount(0.34f);
            window.setAttributes(attributes);
        }
    }
}
