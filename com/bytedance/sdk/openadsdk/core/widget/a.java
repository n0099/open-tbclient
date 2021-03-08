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
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends AlertDialog {

    /* renamed from: a  reason: collision with root package name */
    protected Context f4597a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private ListView g;
    private Button h;
    private InterfaceC1026a i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private HashMap<String, String> o;
    private View p;
    private TextView q;
    private boolean r;
    private List<c> s;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1026a {
        void a(Dialog dialog);

        void b(Dialog dialog);

        void c(Dialog dialog);
    }

    public a a(InterfaceC1026a interfaceC1026a) {
        this.i = interfaceC1026a;
        return this;
    }

    public a(Context context, String str) {
        super(context, ac.g(context, "DialogFullscreen"));
        this.j = "补充中，可于应用官网查看";
        this.k = "暂无";
        this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
        this.r = false;
        this.s = new ArrayList();
        this.f4597a = context;
        if (this.f4597a == null) {
            this.f4597a = p.a();
        }
        this.n = str;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ac.f(this.f4597a, "tt_app_detail_full_dialog"));
        a();
        b();
    }

    protected void a() {
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
                this.k = b2.b();
                if (TextUtils.isEmpty(this.k)) {
                    this.k = "暂无";
                }
                this.j = b2.c();
                if (TextUtils.isEmpty(this.j)) {
                    this.j = "补充中，可于应用官网查看";
                }
                this.m = b2.d();
                if (TextUtils.isEmpty(this.m)) {
                    this.m = "http://sf6-ttcdn-tos.pstatp.com/obj/ad-tetris-site/personal-privacy-page.html";
                }
                String g = b2.g();
                if (!TextUtils.isEmpty(g)) {
                    this.l = g;
                }
                this.o = b2.a();
                a(this.o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(HashMap<String, String> hashMap) {
        if (this.s != null && this.s.size() > 0) {
            this.s.clear();
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        if (hashMap == null || hashMap.size() <= 0) {
            this.s.add(new c("补充中，可于应用官网查看", ""));
            return;
        }
        for (String str : hashMap.keySet()) {
            this.s.add(new c(str, hashMap.get(str)));
        }
    }

    protected void b() {
        this.p = getLayoutInflater().inflate(ac.f(this.f4597a, "tt_app_detail_full_dialog_list_head"), (ViewGroup) null);
        this.b = (TextView) this.p.findViewById(ac.e(this.f4597a, "tt_app_developer_tv"));
        this.d = (TextView) this.p.findViewById(ac.e(this.f4597a, "tt_app_privacy_url_tv"));
        this.q = (TextView) this.p.findViewById(ac.e(this.f4597a, "tt_app_privacy_tv"));
        this.f = (TextView) this.p.findViewById(ac.e(this.f4597a, "tt_app_name_tv"));
        this.c = (TextView) this.p.findViewById(ac.e(this.f4597a, "tt_app_version_tv"));
        this.h = (Button) findViewById(ac.e(this.f4597a, "tt_download_app_btn"));
        this.g = (ListView) findViewById(ac.e(this.f4597a, "tt_privacy_list"));
        this.e = (TextView) findViewById(ac.e(this.f4597a, "tt_app_detail_back_tv"));
        this.g.addHeaderView(this.p);
        if (this.r) {
            this.h.setVisibility(0);
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.i != null) {
                        a.this.i.a(a.this);
                    }
                }
            });
        } else {
            this.h.setVisibility(8);
        }
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.b(a.this);
                }
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.i != null) {
                    a.this.i.c(a.this);
                }
            }
        });
        if (this.s != null && this.s.size() > 0) {
            this.g.setAdapter((ListAdapter) new b(this.f4597a, ac.f(this.f4597a, "tt_app_detail_listview_item"), this.s));
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        c();
    }

    public a a(String str) {
        this.l = str;
        return this;
    }

    public void a(boolean z) {
        this.r = z;
    }

    private void c() {
        if (this.b != null) {
            this.b.setText(String.format(ac.a(this.f4597a, "tt_open_app_detail_developer"), this.j));
        }
        if (this.c != null) {
            this.c.setText(String.format(ac.a(this.f4597a, "tt_open_app_version"), this.k));
        }
        if (this.m != null) {
            this.d.setText(this.m);
        }
        if (this.f != null) {
            this.f.setText(String.format(ac.a(this.f4597a, "tt_open_app_name"), this.l));
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.i != null) {
            this.i.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class c {
        private String b;
        private String c;

        public c(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        public String a() {
            return this.b;
        }

        public String b() {
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b extends ArrayAdapter<c> {
        public b(Context context, int i, List<c> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        @NonNull
        public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
            C1027a c1027a;
            c item = getItem(i);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(ac.f(a.this.f4597a, "tt_app_detail_listview_item"), viewGroup, false);
                C1027a c1027a2 = new C1027a();
                c1027a2.f4602a = (TextView) view.findViewById(ac.e(a.this.f4597a, "tt_item_title_tv"));
                c1027a2.b = (TextView) view.findViewById(ac.e(a.this.f4597a, "tt_item_desc_tv"));
                c1027a2.c = (ImageView) view.findViewById(ac.e(a.this.f4597a, "tt_item_select_img"));
                view.setTag(c1027a2);
                c1027a = c1027a2;
            } else {
                c1027a = (C1027a) view.getTag();
            }
            c1027a.c.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(item.a())) {
                c1027a.c.setVisibility(4);
            }
            c1027a.f4602a.setText(item.a());
            c1027a.b.setText(item.b());
            return view;
        }

        /* renamed from: com.bytedance.sdk.openadsdk.core.widget.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C1027a {

            /* renamed from: a  reason: collision with root package name */
            TextView f4602a;
            TextView b;
            ImageView c;

            C1027a() {
            }
        }
    }
}
