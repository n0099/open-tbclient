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
    public TextView f29095a;

    /* renamed from: b  reason: collision with root package name */
    public TTDislikeListView f29096b;

    /* renamed from: c  reason: collision with root package name */
    public b f29097c;

    /* renamed from: d  reason: collision with root package name */
    public View f29098d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29099e;

    /* renamed from: f  reason: collision with root package name */
    public l f29100f;

    /* renamed from: g  reason: collision with root package name */
    public a f29101g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29102h;

    /* renamed from: i  reason: collision with root package name */
    public String f29103i;

    /* loaded from: classes6.dex */
    public interface a {
        void a();

        void a(int i2, FilterWord filterWord);

        void a(boolean z);

        void b();
    }

    /* loaded from: classes6.dex */
    public class b extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        public boolean f29110b = true;

        /* renamed from: c  reason: collision with root package name */
        public final List<FilterWord> f29111c;

        /* renamed from: d  reason: collision with root package name */
        public final LayoutInflater f29112d;

        /* loaded from: classes6.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f29113a;

            /* renamed from: b  reason: collision with root package name */
            public FlowLayout f29114b;

            public a() {
            }
        }

        public b(LayoutInflater layoutInflater, List<FilterWord> list) {
            this.f29111c = list;
            this.f29112d = layoutInflater;
        }

        public void a(List<FilterWord> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            this.f29111c.clear();
            this.f29111c.addAll(list);
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<FilterWord> list = this.f29111c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i2) {
            return this.f29111c.get(i2);
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
                LayoutInflater layoutInflater = this.f29112d;
                view2 = layoutInflater.inflate(ad.f(layoutInflater.getContext(), "tt_dialog_listview_item"), viewGroup, false);
                aVar.f29113a = (TextView) view2.findViewById(ad.e(this.f29112d.getContext(), "tt_item_tv"));
                aVar.f29114b = (FlowLayout) view2.findViewById(ad.e(this.f29112d.getContext(), "tt_item_tv_son"));
                view2.setTag(aVar);
            } else {
                view2 = view;
                aVar = (a) view.getTag();
            }
            FilterWord filterWord = this.f29111c.get(i2);
            aVar.f29113a.setText(filterWord.getName());
            if (!filterWord.hasSecondOptions()) {
                if (i2 != this.f29111c.size() - 1) {
                    aVar.f29113a.setBackgroundResource(ad.d(this.f29112d.getContext(), "tt_dislike_middle_seletor"));
                } else {
                    aVar.f29113a.setBackgroundResource(ad.d(this.f29112d.getContext(), "tt_dislike_bottom_seletor"));
                }
            }
            if (this.f29110b && i2 == 0) {
                aVar.f29113a.setBackgroundResource(ad.d(this.f29112d.getContext(), "tt_dislike_top_seletor"));
            }
            if (filterWord.hasSecondOptions()) {
                aVar.f29114b.removeAllViews();
                for (int i3 = 0; i3 < filterWord.getOptions().size(); i3++) {
                    LayoutInflater layoutInflater2 = this.f29112d;
                    TextView textView = (TextView) layoutInflater2.inflate(ad.f(layoutInflater2.getContext(), "tt_dislike_flowlayout_tv"), (ViewGroup) aVar.f29114b, false);
                    textView.setText(filterWord.getOptions().get(i3).getName());
                    textView.setOnClickListener(new c(filterWord.getOptions().get(i3), i3));
                    aVar.f29114b.addView(textView);
                }
                aVar.f29114b.setVisibility(0);
            } else {
                aVar.f29114b.setVisibility(8);
            }
            return view2;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public FilterWord f29117b;

        /* renamed from: c  reason: collision with root package name */
        public int f29118c;

        public c(FilterWord filterWord, int i2) {
            this.f29117b = filterWord;
            this.f29118c = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f29101g.a(this.f29118c, this.f29117b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f29117b);
            com.bytedance.sdk.openadsdk.c.d.a(d.this.f29100f, arrayList);
            d.this.dismiss();
        }
    }

    public d(Context context, l lVar, String str) {
        super(context, ad.g(context, "tt_dislikeDialog_new"));
        this.f29102h = false;
        this.f29100f = lVar;
        this.f29103i = str;
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
        setMaterialMeta(this.f29100f);
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
                if (d.this.f29101g != null) {
                    d.this.f29102h = false;
                    d.this.f29101g.a();
                }
                if (d.this.f29098d.isShown()) {
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f29100f, d.this.f29103i, "ad_explation_show");
                }
            }
        });
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (d.this.f29101g != null) {
                    d.this.f29101g.a(d.this.f29102h);
                }
            }
        });
        if (this.f29100f.as() != null) {
            this.f29098d.setVisibility(0);
            this.f29099e.setText(this.f29100f.as().getName());
            this.f29098d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setComponent(new ComponentName(d.this.getContext(), TTDislikeWebViewActivity.class));
                    intent.putExtra("title", d.this.f29100f.as().getName());
                    intent.putExtra("url", d.this.f29100f.as().getUrl());
                    intent.putExtra("tag", d.this.f29103i);
                    intent.putExtra("meta", d.this.f29100f.aL().toString());
                    com.bytedance.sdk.openadsdk.utils.b.a(d.this.getContext(), intent, null);
                    com.bytedance.sdk.openadsdk.c.d.b(d.this.getContext(), d.this.f29100f, d.this.f29103i, "ad_explation_click");
                }
            });
        }
        b bVar = new b(getLayoutInflater(), this.f29100f.ar());
        this.f29097c = bVar;
        this.f29096b.setAdapter((ListAdapter) bVar);
    }

    private void c() {
        this.f29098d = findViewById(ad.e(getContext(), "tt_personalization_layout"));
        this.f29099e = (TextView) findViewById(ad.e(getContext(), "tt_personalization_name"));
        TextView textView = (TextView) findViewById(ad.e(getContext(), "tt_edit_suggestion"));
        this.f29095a = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (d.this.f29101g != null) {
                    d.this.f29102h = true;
                    d.this.dismiss();
                    d.this.f29101g.b();
                }
            }
        });
        TTDislikeListView tTDislikeListView = (TTDislikeListView) findViewById(ad.e(getContext(), "tt_filer_words_lv"));
        this.f29096b = tTDislikeListView;
        tTDislikeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bytedance.sdk.openadsdk.dislike.d.5
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                if (d.this.f29101g != null) {
                    try {
                        d.this.f29101g.a(i2, d.this.f29100f.ar().get(i2));
                    } catch (Throwable unused) {
                    }
                }
                d.this.dismiss();
            }
        });
    }

    private void d() {
        TTDislikeListView tTDislikeListView = this.f29096b;
        if (tTDislikeListView != null) {
            tTDislikeListView.setVisibility(0);
        }
    }

    public void a(l lVar) {
        b bVar = this.f29097c;
        if (bVar == null || lVar == null) {
            return;
        }
        this.f29100f = lVar;
        bVar.a(lVar.ar());
        setMaterialMeta(this.f29100f);
    }

    public void a(String str) {
        if (str != null) {
            this.f29100f.c(str);
            a(this.f29100f);
        }
    }

    public void a(a aVar) {
        this.f29101g = aVar;
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
