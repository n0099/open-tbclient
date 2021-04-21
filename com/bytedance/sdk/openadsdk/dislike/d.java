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
/* loaded from: classes5.dex */
public class d extends TTDislikeDialogAbstract {

    /* renamed from: a  reason: collision with root package name */
    public TextView f28848a;

    /* renamed from: b  reason: collision with root package name */
    public TTDislikeListView f28849b;

    /* renamed from: c  reason: collision with root package name */
    public b f28850c;

    /* renamed from: d  reason: collision with root package name */
    public View f28851d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28852e;

    /* renamed from: f  reason: collision with root package name */
    public l f28853f;

    /* renamed from: g  reason: collision with root package name */
    public a f28854g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28855h;
    public String i;

    /* loaded from: classes5.dex */
    public interface a {
        void a();

        void a(int i, FilterWord filterWord);

        void a(boolean z);

        void b();
    }

    /* loaded from: classes5.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f28862b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f28863c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f28864d;

        /* loaded from: classes5.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28865a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f28866b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f28863c = list;
            this.f28864d = layoutInflater;
        }

        public void a(List<FilterWord> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.f28863c.clear();
            this.f28863c.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f28863c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.f28863c.get(i);
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
                LayoutInflater layoutInflater = this.f28864d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f28865a = (TextView) view2.findViewById(ad.e(this.f28864d.getContext(), "tt_item_tv"));
                aVar.f28866b = (FlowLayout) view2.findViewById(ad.e(this.f28864d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f28863c.get(i);
            aVar.f28865a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i != this.f28863c.size() - 1) {
                    aVar.f28865a.setBackgroundResource(ad.d(this.f28864d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f28865a.setBackgroundResource(ad.d(this.f28864d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f28862b && i == 0) {
                aVar.f28865a.setBackgroundResource(ad.d(this.f28864d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f28866b.removeAllViews();
                for (int i2 = 0; i2 < filterWord.getOptions().size(); i2++) {
                    LayoutInflater layoutInflater2 = this.f28864d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f28866b, false);
                    textView.setText(filterWord.getOptions().get(i2).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i2), i2));
                    aVar.f28866b.addView(textView);
                }
                aVar.f28866b.setVisibility(0);
            } else {
                aVar.f28866b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f28869b;

        /* renamed from: c  reason: collision with root package name */
        public int f28870c;

        public c(FilterWord filterWord, int i) {
            this.f28869b = filterWord;
            this.f28870c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f28854g.a(this.f28870c, this.f28869b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f28869b);
            com.bytedance.sdk.openadsdk.c.d.a(d.this.f28853f, arrayList);
            d.this.dismiss();
        }
    }

    public d(Context context, l lVar, String str) {
        super(context, ad.g(context, "tt_dislikeDialog_new"));
        this.f28855h = false;
        this.f28853f = lVar;
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
        setMaterialMeta(this.f28853f);
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
                if (d.this.f28854g != null) {
                    d.this.f28855h = false;
                    d.this.f28854g.a();
                }
                if (d.this.f28851d.isShown()) {
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f28853f, d.this.i, "ad_explation_show");
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.f28854g != null) {
                    d.this.f28854g.a(d.this.f28855h);
                }
            }
        });
        if (this.f28853f.as() != null) {
            this.f28851d.setVisibility(0);
            this.f28852e.setText(this.f28853f.as().getName());
            this.f28851d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(d.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", d.this.f28853f.as().getName());
                    intent.putExtra("url", d.this.f28853f.as().getUrl());
                    intent.putExtra("tag", d.this.i);
                    intent.putExtra("meta", d.this.f28853f.aL().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(d.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f28853f, d.this.i, "ad_explation_click");
                }
            });
        }
        b bVar = new b(getLayoutInflater(), this.f28853f.ar());
        this.f28850c = bVar;
        this.f28849b.setAdapter((ListAdapter) bVar);
    }

    private void c() {
        this.f28851d = findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f28852e = (TextView) findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f28848a = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.f28854g != null) {
                    d.this.f28855h = true;
                    d.this.dismiss();
                    d.this.f28854g.b();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f28849b = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (d.this.f28854g != null) {
                    try {
                        d.this.f28854g.a(i, d.this.f28853f.ar().get(i));
                    } catch (Throwable unused) {
                    }
                }
                d.this.dismiss();
            }
        });
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f28849b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void a(l lVar) {
        b bVar = this.f28850c;
        if (bVar == null || lVar == null) {
            return;
        }
        this.f28853f = lVar;
        bVar.a(lVar.ar());
        setMaterialMeta(this.f28853f);
    }

    public void a(String str) {
        if (str != null) {
            this.f28853f.c(str);
            a(this.f28853f);
        }
    }

    public void a(a aVar) {
        this.f28854g = aVar;
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
