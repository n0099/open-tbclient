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
    public Context f28708a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28709b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28710c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28711d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28712e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28713f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f28714g;

    /* renamed from: h  reason: collision with root package name */
    public Button f28715h;

    /* renamed from: i  reason: collision with root package name */
    public InterfaceC0302a f28716i;
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
    public interface InterfaceC0302a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    /* loaded from: classes6.dex */
    public class b extends ArrayAdapter<c> {

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0303a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28721a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f28722b;

            /* renamed from: c  reason: collision with root package name */
            public ImageView f28723c;

            public C0303a() {
            }
        }

        public b(Context context, int i2, List<c> list) {
            super(context, i2, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i2, @Nullable View view, @NonNull ViewGroup viewGroup) {
            C0303a c0303a;
            c item = getItem(i2);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(ad.f(a.this.f28708a, "tt_app_detail_listview_item"), viewGroup, false);
                c0303a = new C0303a();
                c0303a.f28721a = (TextView) view.findViewById(ad.e(a.this.f28708a, "tt_item_title_tv"));
                c0303a.f28722b = (TextView) view.findViewById(ad.e(a.this.f28708a, "tt_item_desc_tv"));
                c0303a.f28723c = (ImageView) view.findViewById(ad.e(a.this.f28708a, "tt_item_select_img"));
                view.setTag(c0303a);
            } else {
                c0303a = (C0303a) view.getTag();
            }
            c0303a.f28723c.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.a())) {
                c0303a.f28723c.setVisibility(4);
            }
            c0303a.f28721a.setText(item.a());
            c0303a.f28722b.setText(item.b());
            return view;
        }
    }

    /* loaded from: classes6.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        public String f28726b;

        /* renamed from: c  reason: collision with root package name */
        public String f28727c;

        public c(String str, String str2) {
            this.f28726b = str;
            this.f28727c = str2;
        }

        public String a() {
            return this.f28726b;
        }

        public String b() {
            return this.f28727c;
        }
    }

    public a(Context context, String str) {
        super(context, ad.g(context, "tt_dialog_full"));
        this.j = "补充中，可于应用官网查看";
        this.k = "暂无";
        this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
        this.r = false;
        this.s = new ArrayList();
        this.f28708a = context;
        if (context == null) {
            this.f28708a = p.a();
        }
        this.n = str;
    }

    private void c() {
        if (this.f28709b != null) {
            this.f28709b.setText(String.format(ad.a(this.f28708a, "tt_open_app_detail_developer"), this.j));
        }
        if (this.f28710c != null) {
            this.f28710c.setText(String.format(ad.a(this.f28708a, "tt_open_app_version"), this.k));
        }
        String str = this.m;
        if (str != null) {
            this.f28711d.setText(str);
        }
        if (this.f28713f != null) {
            this.f28713f.setText(String.format(ad.a(this.f28708a, "tt_open_app_name"), this.l));
        }
    }

    public void b() {
        View inflate = getLayoutInflater().inflate(ad.f(this.f28708a, "tt_app_detail_full_dialog_list_head"), (ViewGroup) null);
        this.p = inflate;
        this.f28709b = (TextView) inflate.findViewById(ad.e(this.f28708a, "tt_app_developer_tv"));
        this.f28711d = (TextView) this.p.findViewById(ad.e(this.f28708a, "tt_app_privacy_url_tv"));
        this.q = (TextView) this.p.findViewById(ad.e(this.f28708a, "tt_app_privacy_tv"));
        this.f28713f = (TextView) this.p.findViewById(ad.e(this.f28708a, "tt_app_name_tv"));
        this.f28710c = (TextView) this.p.findViewById(ad.e(this.f28708a, "tt_app_version_tv"));
        this.f28715h = (Button) findViewById(ad.e(this.f28708a, "tt_download_app_btn"));
        this.f28714g = (ListView) findViewById(ad.e(this.f28708a, "tt_privacy_list"));
        this.f28712e = (TextView) findViewById(ad.e(this.f28708a, "tt_app_detail_back_tv"));
        this.f28714g.addHeaderView(this.p);
        if (this.r) {
            this.f28715h.setVisibility(0);
            this.f28715h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.f28716i != null) {
                        a.this.f28716i.a(a.this);
                    }
                }
            });
        } else {
            this.f28715h.setVisibility(8);
        }
        this.f28712e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f28716i != null) {
                    a.this.f28716i.b(a.this);
                }
            }
        });
        this.f28711d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.f28716i != null) {
                    a.this.f28716i.c(a.this);
                }
            }
        });
        List<c> list = this.s;
        if (list == null || list.size() <= 0) {
            return;
        }
        Context context = this.f28708a;
        this.f28714g.setAdapter((ListAdapter) new b(context, ad.f(context, "tt_app_detail_listview_item"), this.s));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        InterfaceC0302a interfaceC0302a = this.f28716i;
        if (interfaceC0302a != null) {
            interfaceC0302a.b(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28708a, "tt_app_detail_full_dialog"));
        a();
        b();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    public a a(InterfaceC0302a interfaceC0302a) {
        this.f28716i = interfaceC0302a;
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
