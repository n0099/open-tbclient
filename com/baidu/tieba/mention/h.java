package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ap;
import com.baidu.tieba.pb.NewPbActivity;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tieba.g b;
    private int h;
    private n j;
    private int o;
    private FrameLayout c = null;
    private ListView d = null;
    private e e = null;
    private ap f = null;
    private int g = 1;
    private int i = 0;
    private p k = null;
    private ProgressBar l = null;
    private q m = null;
    private TextView n = null;
    private String p = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f986a = null;
    private o q = null;
    private Handler r = new Handler();
    private Runnable s = new i(this);

    public h(com.baidu.tieba.g gVar, int i, n nVar) {
        this.b = null;
        this.h = 0;
        this.j = null;
        this.b = gVar;
        this.h = i;
        this.j = nVar;
    }

    public void a(int i) {
        this.i = i;
    }

    public void b(int i) {
        this.o = i;
    }

    public void a(ListView listView) {
        this.d = listView;
    }

    public void a(FrameLayout frameLayout) {
        this.c = frameLayout;
    }

    public void a(ProgressBar progressBar) {
        this.l = progressBar;
    }

    public void a(String str) {
        this.p = str;
    }

    public void a(TextView textView) {
        this.n = textView;
    }

    public void a() {
        this.e.a();
        this.l.setVisibility(8);
    }

    public void b() {
        this.g = 1;
        this.o = 3;
        d();
    }

    public void c() {
        this.g = 1;
        this.e = new e(this.b, null);
        this.e.a(this.h);
        this.e.b(TiebaApplication.f().aq());
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnItemClickListener(new k(this));
        this.q = new o(this);
        this.d.setOnItemLongClickListener(new l(this));
        this.d.setOnScrollListener(new m(this));
        this.l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.q qVar) {
        CharSequence[] charSequenceArr = {this.b.getString(R.string.view_post), this.b.getString(R.string.reply), this.b.getString(R.string.view_pb)};
        MentionActivity g = g();
        if (g != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(g);
            builder.setTitle(this.b.getString(R.string.operation));
            builder.setItems(charSequenceArr, this.q);
            this.f986a = builder.create();
            this.f986a.setCanceledOnTouchOutside(true);
            this.f986a.show();
        }
    }

    public void d() {
        ArrayList b;
        Boolean bool = false;
        switch (this.o) {
            case 2:
                bool = true;
                break;
            case 3:
                bool = true;
                if (this.e.b()) {
                    return;
                }
                break;
            case 4:
                bool = true;
                if (this.e.c()) {
                    return;
                }
                break;
        }
        if (!bool.booleanValue()) {
            if (this.f != null) {
                a(this.f);
                return;
            }
            String a2 = this.j.a();
            if (a2 != null && a2.length() > 0) {
                ap apVar = new ap();
                apVar.a(a2);
                if (!apVar.a()) {
                    com.baidu.tieba.util.z.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                    this.j.b();
                } else {
                    com.baidu.tieba.util.z.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a2.length()));
                    a(apVar);
                    return;
                }
            }
        }
        if (this.o != 4) {
            this.g = 1;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.g.f787a);
        stringBuffer.append(this.p);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("uid", TiebaApplication.E()));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.g)));
        if (this.o == 4 && this.f != null && (b = this.f.b()) != null && b.size() > 0) {
            com.baidu.tieba.data.q qVar = (com.baidu.tieba.data.q) b.get(b.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", qVar.g(), qVar.h())));
        }
        h();
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.k = new p(this, stringBuffer.toString(), arrayList, this.e);
        this.k.setPriority(3);
        this.k.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ap apVar) {
        if (apVar != null && apVar.b() != null) {
            if (this.o == 4 && this.f != null) {
                ArrayList b = this.f.b();
                b.addAll(apVar.b());
                apVar.a(b);
                this.f = null;
                this.f = apVar;
            } else {
                this.f = apVar;
            }
            if (this.f != null) {
                if (this.f.c().f() == 1) {
                    this.e.a(true);
                } else {
                    this.e.a(false);
                }
                ArrayList b2 = this.f.b();
                if (b2 != null) {
                    this.e.a(b2);
                    this.e.notifyDataSetChanged();
                    if (this.o == 2 || this.o == 3) {
                        this.d.setSelectionFromTop(0, 0);
                    }
                    if (b2.size() == 0) {
                        this.n.setVisibility(0);
                        this.n.setText(this.i);
                    } else {
                        this.n.setVisibility(8);
                    }
                }
            }
            MentionActivity g = g();
            if (g != null) {
                if (this.o == 3 || this.o == 2) {
                    g.a(this.h, true);
                } else {
                    g.a(this.h, false);
                }
            }
        }
    }

    private MentionActivity g() {
        if (this.b == null) {
            return null;
        }
        Activity parent = this.b.getParent();
        return (parent == null || !(parent instanceof MentionActivity)) ? null : (MentionActivity) parent;
    }

    public void e() {
        if (this.e != null && this.e.d() != TiebaApplication.f().aq()) {
            this.e.b(TiebaApplication.f().aq());
            this.e.notifyDataSetChanged();
        }
    }

    public void f() {
        i();
        h();
    }

    private void h() {
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.m != null) {
            this.m.cancel();
            this.m = null;
        }
        this.l.setVisibility(8);
        this.e.b(false);
        this.e.c(false);
        this.e.notifyDataSetChanged();
    }

    private void i() {
        this.r.removeCallbacks(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.g.f787a);
        ArrayList arrayList = new ArrayList();
        if (i == 1) {
            stringBuffer.append("c/f/pb/page");
            arrayList.add(new BasicNameValuePair("kz", str));
            arrayList.add(new BasicNameValuePair("pid", str2));
            arrayList.add(new BasicNameValuePair("mark", String.valueOf(1)));
            arrayList.add(new BasicNameValuePair("rn", String.valueOf(1)));
        }
        if (i == 2) {
            stringBuffer.append("c/f/pb/floor");
            arrayList.add(new BasicNameValuePair("kz", str));
            arrayList.add(new BasicNameValuePair("spid", str2));
        }
        arrayList.add(new BasicNameValuePair("st_type", "mention"));
        h();
        this.m = new q(this, stringBuffer.toString(), arrayList, i, str3);
        this.m.setPriority(3);
        this.m.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.data.q qVar) {
        NewPbActivity.b(this.b, qVar.g(), qVar.h(), "mention");
    }
}
