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
    public Context f28547a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f28548b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f28549c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f28550d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f28551e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28552f;

    /* renamed from: g  reason: collision with root package name */
    public ListView f28553g;

    /* renamed from: h  reason: collision with root package name */
    public Button f28554h;
    public InterfaceC0317a i;
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
    public interface InterfaceC0317a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    /* loaded from: classes5.dex */
    public class b extends ArrayAdapter<c> {

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0318a {

            /* renamed from: a  reason: collision with root package name */
            public TextView f28559a;

            /* renamed from: b  reason: collision with root package name */
            public TextView f28560b;

            /* renamed from: c  reason: collision with root package name */
            public ImageView f28561c;

            public C0318a() {
            }
        }

        public b(Context context, int i, List<c> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
            C0318a c0318a;
            c item = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(ad.f(a.this.f28547a, "tt_app_detail_listview_item"), viewGroup, false);
                c0318a = new C0318a();
                c0318a.f28559a = (TextView) view.findViewById(ad.e(a.this.f28547a, "tt_item_title_tv"));
                c0318a.f28560b = (TextView) view.findViewById(ad.e(a.this.f28547a, "tt_item_desc_tv"));
                c0318a.f28561c = (ImageView) view.findViewById(ad.e(a.this.f28547a, "tt_item_select_img"));
                view.setTag(c0318a);
            } else {
                c0318a = (C0318a) view.getTag();
            }
            c0318a.f28561c.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.a())) {
                c0318a.f28561c.setVisibility(4);
            }
            c0318a.f28559a.setText(item.a());
            c0318a.f28560b.setText(item.b());
            return view;
        }
    }

    /* loaded from: classes5.dex */
    public class c {

        /* renamed from: b  reason: collision with root package name */
        public String f28564b;

        /* renamed from: c  reason: collision with root package name */
        public String f28565c;

        public c(String str, String str2) {
            this.f28564b = str;
            this.f28565c = str2;
        }

        public String a() {
            return this.f28564b;
        }

        public String b() {
            return this.f28565c;
        }
    }

    public a(Context context, String str) {
        super(context, ad.g(context, "tt_dialog_full"));
        this.j = "补充中，可于应用官网查看";
        this.k = "暂无";
        this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
        this.r = false;
        this.s = new ArrayList();
        this.f28547a = context;
        if (context == null) {
            this.f28547a = p.a();
        }
        this.n = str;
    }

    private void c() {
        if (this.f28548b != null) {
            this.f28548b.setText(String.format(ad.a(this.f28547a, "tt_open_app_detail_developer"), this.j));
        }
        if (this.f28549c != null) {
            this.f28549c.setText(String.format(ad.a(this.f28547a, "tt_open_app_version"), this.k));
        }
        String str = this.m;
        if (str != null) {
            this.f28550d.setText(str);
        }
        if (this.f28552f != null) {
            this.f28552f.setText(String.format(ad.a(this.f28547a, "tt_open_app_name"), this.l));
        }
    }

    public void b() {
        View inflate = getLayoutInflater().inflate(ad.f(this.f28547a, "tt_app_detail_full_dialog_list_head"), (ViewGroup) null);
        this.p = inflate;
        this.f28548b = (TextView) inflate.findViewById(ad.e(this.f28547a, "tt_app_developer_tv"));
        this.f28550d = (TextView) this.p.findViewById(ad.e(this.f28547a, "tt_app_privacy_url_tv"));
        this.q = (TextView) this.p.findViewById(ad.e(this.f28547a, "tt_app_privacy_tv"));
        this.f28552f = (TextView) this.p.findViewById(ad.e(this.f28547a, "tt_app_name_tv"));
        this.f28549c = (TextView) this.p.findViewById(ad.e(this.f28547a, "tt_app_version_tv"));
        this.f28554h = (Button) findViewById(ad.e(this.f28547a, "tt_download_app_btn"));
        this.f28553g = (ListView) findViewById(ad.e(this.f28547a, "tt_privacy_list"));
        this.f28551e = (TextView) findViewById(ad.e(this.f28547a, "tt_app_detail_back_tv"));
        this.f28553g.addHeaderView(this.p);
        if (this.r) {
            this.f28554h.setVisibility(0);
            this.f28554h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.i != null) {
                        a.this.i.a(a.this);
                    }
                }
            });
        } else {
            this.f28554h.setVisibility(8);
        }
        this.f28551e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.b(a.this);
                }
            }
        });
        this.f28550d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.3
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
        Context context = this.f28547a;
        this.f28553g.setAdapter((ListAdapter) new b(context, ad.f(context, "tt_app_detail_listview_item"), this.s));
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        InterfaceC0317a interfaceC0317a = this.i;
        if (interfaceC0317a != null) {
            interfaceC0317a.b(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ad.f(this.f28547a, "tt_app_detail_full_dialog"));
        a();
        b();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    public a a(InterfaceC0317a interfaceC0317a) {
        this.i = interfaceC0317a;
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
