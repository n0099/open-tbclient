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
/* loaded from: classes5.dex */
public class a extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    public Context f28555a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28556b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28557c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28558d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28559e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28560f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f28561g;

    /* renamed from: h  reason: collision with root package name */
    public Button f28562h;
    public InterfaceC0319a i;
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
    /* loaded from: classes5.dex */
    public interface InterfaceC0319a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    /* loaded from: classes5.dex */
    public class b extends ArrayAdapter<c> {

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0320a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28567a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f28568b;

            /* renamed from: c  reason: collision with root package name */
            public ImageView f28569c;

            public C0320a() {
            }
        }

        public b(Context context, int i, List<c> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
            C0320a c0320a;
            c item = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(ad.f(a.this.f28555a, "tt_app_detail_listview_item"), viewGroup, false);
                c0320a = new C0320a();
                c0320a.f28567a = (TextView) view.findViewById(ad.e(a.this.f28555a, "tt_item_title_tv"));
                c0320a.f28568b = (TextView) view.findViewById(ad.e(a.this.f28555a, "tt_item_desc_tv"));
                c0320a.f28569c = (ImageView) view.findViewById(ad.e(a.this.f28555a, "tt_item_select_img"));
                view.setTag(c0320a);
            } else {
                c0320a = (C0320a) view.getTag();
            }
            c0320a.f28569c.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.a())) {
                c0320a.f28569c.setVisibility(4);
            }
            c0320a.f28567a.setText(item.a());
            c0320a.f28568b.setText(item.b());
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        public String f28572b;

        /* renamed from: c  reason: collision with root package name */
        public String f28573c;

        public c(String str, String str2) {
            this.f28572b = str;
            this.f28573c = str2;
        }

        public String a() {
            return this.f28572b;
        }

        public String b() {
            return this.f28573c;
        }
    }

    public a(Context context, String str) {
        super(context, ad.g(context, "tt_dialog_full"));
        this.j = "补充中，可于应用官网查看";
        this.k = "暂无";
        this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
        this.r = false;
        this.s = new ArrayList();
        this.f28555a = context;
        if (context == null) {
            this.f28555a = p.a();
        }
        this.n = str;
    }

    private void c() {
        if (this.f28556b != null) {
            this.f28556b.setText(String.format(ad.a(this.f28555a, "tt_open_app_detail_developer"), this.j));
        }
        if (this.f28557c != null) {
            this.f28557c.setText(String.format(ad.a(this.f28555a, "tt_open_app_version"), this.k));
        }
        String str = this.m;
        if (str != null) {
            this.f28558d.setText(str);
        }
        if (this.f28560f != null) {
            this.f28560f.setText(String.format(ad.a(this.f28555a, "tt_open_app_name"), this.l));
        }
    }

    public void b() {
        View inflate = getLayoutInflater().inflate(ad.f(this.f28555a, "tt_app_detail_full_dialog_list_head"), (ViewGroup) null);
        this.p = inflate;
        this.f28556b = (TextView) inflate.findViewById(ad.e(this.f28555a, "tt_app_developer_tv"));
        this.f28558d = (TextView) this.p.findViewById(ad.e(this.f28555a, "tt_app_privacy_url_tv"));
        this.q = (TextView) this.p.findViewById(ad.e(this.f28555a, "tt_app_privacy_tv"));
        this.f28560f = (TextView) this.p.findViewById(ad.e(this.f28555a, "tt_app_name_tv"));
        this.f28557c = (TextView) this.p.findViewById(ad.e(this.f28555a, "tt_app_version_tv"));
        this.f28562h = (Button) findViewById(ad.e(this.f28555a, "tt_download_app_btn"));
        this.f28561g = (ListView) findViewById(ad.e(this.f28555a, "tt_privacy_list"));
        this.f28559e = (TextView) findViewById(ad.e(this.f28555a, "tt_app_detail_back_tv"));
        this.f28561g.addHeaderView(this.p);
        if (this.r) {
            this.f28562h.setVisibility(0);
            this.f28562h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.i != null) {
                        a.this.i.a(a.this);
                    }
                }
            });
        } else {
            this.f28562h.setVisibility(8);
        }
        this.f28559e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.b(a.this);
                }
            }
        });
        this.f28558d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.3
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
        Context context = this.f28555a;
        this.f28561g.setAdapter((ListAdapter) new b(context, ad.f(context, "tt_app_detail_listview_item"), this.s));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        InterfaceC0319a interfaceC0319a = this.i;
        if (interfaceC0319a != null) {
            interfaceC0319a.b(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28555a, "tt_app_detail_full_dialog"));
        a();
        b();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    public a a(InterfaceC0319a interfaceC0319a) {
        this.i = interfaceC0319a;
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
