package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public Context f28862a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28863b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28864c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28865d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28866e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28867f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f28868g;

    /* renamed from: h  reason: collision with root package name */
    public Button f28869h;
    public InterfaceC0315a i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public HashMap<String, String> o;
    public View p;
    public TextView q;
    public boolean r;
    public List<c> s;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0315a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    /* loaded from: classes6.dex */
    public class b extends ArrayAdapter<c> {

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0316a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28874a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f28875b;

            /* renamed from: c  reason: collision with root package name */
            public ImageView f28876c;

            public C0316a() {
            }
        }

        public b(Context context, int i, List<c> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
            C0316a c0316a;
            c item = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(ad.f(a.this.f28862a, "tt_app_detail_listview_item"), viewGroup, false);
                c0316a = new C0316a();
                c0316a.f28874a = (TextView) view.findViewById(ad.e(a.this.f28862a, "tt_item_title_tv"));
                c0316a.f28875b = (TextView) view.findViewById(ad.e(a.this.f28862a, "tt_item_desc_tv"));
                c0316a.f28876c = (ImageView) view.findViewById(ad.e(a.this.f28862a, "tt_item_select_img"));
                view.setTag(c0316a);
            } else {
                c0316a = (C0316a) view.getTag();
            }
            c0316a.f28876c.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.a())) {
                c0316a.f28876c.setVisibility(4);
            }
            c0316a.f28874a.setText(item.a());
            c0316a.f28875b.setText(item.b());
            return view;
        }
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        public String f28879b;

        /* renamed from: c  reason: collision with root package name */
        public String f28880c;

        public c(String str, String str2) {
            this.f28879b = str;
            this.f28880c = str2;
        }

        public String a() {
            return this.f28879b;
        }

        public String b() {
            return this.f28880c;
        }
    }

    public a(Context context, String str) {
        super(context, ad.g(context, "tt_dialog_full"));
        this.j = "补充中，可于应用官网查看";
        this.k = "暂无";
        this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
        this.r = false;
        this.s = new ArrayList();
        this.f28862a = context;
        if (context == null) {
            this.f28862a = p.a();
        }
        this.n = str;
    }

    private void c() {
        if (this.f28863b != null) {
            this.f28863b.setText(String.format(ad.a(this.f28862a, "tt_open_app_detail_developer"), this.j));
        }
        if (this.f28864c != null) {
            this.f28864c.setText(String.format(ad.a(this.f28862a, "tt_open_app_version"), this.k));
        }
        String str = this.m;
        if (str != null) {
            this.f28865d.setText(str);
        }
        if (this.f28867f != null) {
            this.f28867f.setText(String.format(ad.a(this.f28862a, "tt_open_app_name"), this.l));
        }
    }

    public void b() {
        View inflate = getLayoutInflater().inflate(ad.f(this.f28862a, "tt_app_detail_full_dialog_list_head"), (ViewGroup) null);
        this.p = inflate;
        this.f28863b = (TextView) inflate.findViewById(ad.e(this.f28862a, "tt_app_developer_tv"));
        this.f28865d = (TextView) this.p.findViewById(ad.e(this.f28862a, "tt_app_privacy_url_tv"));
        this.q = (TextView) this.p.findViewById(ad.e(this.f28862a, "tt_app_privacy_tv"));
        this.f28867f = (TextView) this.p.findViewById(ad.e(this.f28862a, "tt_app_name_tv"));
        this.f28864c = (TextView) this.p.findViewById(ad.e(this.f28862a, "tt_app_version_tv"));
        this.f28869h = (Button) findViewById(ad.e(this.f28862a, "tt_download_app_btn"));
        this.f28868g = (ListView) findViewById(ad.e(this.f28862a, "tt_privacy_list"));
        this.f28866e = (TextView) findViewById(ad.e(this.f28862a, "tt_app_detail_back_tv"));
        this.f28868g.addHeaderView(this.p);
        if (this.r) {
            this.f28869h.setVisibility(0);
            this.f28869h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.i != null) {
                        a.this.i.a(a.this);
                    }
                }
            });
        } else {
            this.f28869h.setVisibility(8);
        }
        this.f28866e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.b(a.this);
                }
            }
        });
        this.f28865d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.c(a.this);
                }
            }
        });
        List<c> list = this.s;
        if (list == null || list.size() <= 0) {
            return;
        }
        Context context = this.f28862a;
        this.f28868g.setAdapter((ListAdapter) new b(context, ad.f(context, "tt_app_detail_listview_item"), this.s));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        InterfaceC0315a interfaceC0315a = this.i;
        if (interfaceC0315a != null) {
            interfaceC0315a.b(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28862a, "tt_app_detail_full_dialog"));
        a();
        b();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    public a a(InterfaceC0315a interfaceC0315a) {
        this.i = interfaceC0315a;
        return this;
    }

    public void a() {
        if (TextUtils.isEmpty(this.n)) {
            this.k = "暂无";
            this.j = "补充中，可于应用官网查看";
            this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
            a(this.o);
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.d.c b2 = com.bytedance.sdk.openadsdk.core.c.b(new JSONObject(this.n));
            if (b2 != null) {
                String b3 = b2.b();
                this.k = b3;
                if (TextUtils.isEmpty(b3)) {
                    this.k = "暂无";
                }
                String c2 = b2.c();
                this.j = c2;
                if (TextUtils.isEmpty(c2)) {
                    this.j = "补充中，可于应用官网查看";
                }
                String d2 = b2.d();
                this.m = d2;
                if (TextUtils.isEmpty(d2)) {
                    this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                }
                String g2 = b2.g();
                if (!TextUtils.isEmpty(g2)) {
                    this.l = g2;
                }
                HashMap<String, String> a2 = b2.a();
                this.o = a2;
                a(a2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(HashMap<String, String> hashMap) {
        List<c> list = this.s;
        if (list != null && list.size() > 0) {
            this.s.clear();
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : hashMap.keySet()) {
                this.s.add(new c(str, hashMap.get(str)));
            }
            return;
        }
        this.s.add(new c("补充中，可于应用官网查看", ""));
    }

    public a a(String str) {
        this.l = str;
        return this;
    }

    public void a(boolean z) {
        this.r = z;
    }
}
