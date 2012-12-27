package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.pb.SubPbActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class h {
    private com.baidu.tieba.e b;
    private int h;
    private n j;
    private int o;
    private FrameLayout c = null;
    private ListView d = null;
    private e e = null;
    private com.baidu.tieba.b.i f = null;
    private int g = 1;
    private int i = 0;
    private p k = null;
    private ProgressBar l = null;
    private q m = null;
    private TextView n = null;
    private String p = null;
    AlertDialog a = null;
    private o q = null;
    private Handler r = new Handler();
    private Runnable s = new i(this);

    public h(com.baidu.tieba.e eVar, int i, n nVar) {
        this.b = null;
        this.h = 0;
        this.j = null;
        this.b = eVar;
        this.h = i;
        this.j = nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.o oVar) {
        CharSequence[] charSequenceArr = {this.b.getString(R.string.view_post), this.b.getString(R.string.reply), this.b.getString(R.string.view_pb)};
        MentionActivity g = g();
        if (g == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(g);
        builder.setTitle(this.b.getString(R.string.operation));
        builder.setItems(charSequenceArr, this.q);
        this.a = builder.create();
        this.a.setCanceledOnTouchOutside(true);
        this.a.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.b.i iVar) {
        if (iVar == null || iVar.b() == null) {
            return;
        }
        if (this.o != 4 || this.f == null) {
            this.f = iVar;
        } else {
            ArrayList b = this.f.b();
            b.addAll(iVar.b());
            iVar.a(b);
            this.f = null;
            this.f = iVar;
        }
        if (this.f != null) {
            if (this.f.c().c() == 1) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
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
        this.m.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.a.o oVar) {
        String g = oVar.g();
        String h = oVar.h();
        Intent intent = new Intent(this.b, SubPbActivity.class);
        intent.putExtra("themeId", g);
        intent.putExtra("postId", h);
        intent.putExtra("st_type", "mention");
        intent.putExtra("isFromMention", true);
        this.b.startActivity(intent);
    }

    private MentionActivity g() {
        if (this.b == null) {
            return null;
        }
        Activity parent = this.b.getParent();
        return (parent == null || !(parent instanceof MentionActivity)) ? null : (MentionActivity) parent;
    }

    private void h() {
        if (this.k != null) {
            this.k.a();
            this.k = null;
        }
        if (this.m != null) {
            this.m.a();
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

    public void a() {
        this.e.a();
        this.l.setVisibility(8);
    }

    public void a(int i) {
        this.i = i;
    }

    public void a(FrameLayout frameLayout) {
        this.c = frameLayout;
    }

    public void a(ListView listView) {
        this.d = listView;
    }

    public void a(ProgressBar progressBar) {
        this.l = progressBar;
    }

    public void a(TextView textView) {
        this.n = textView;
    }

    public void a(String str) {
        this.p = str;
    }

    public void b() {
        this.g = 1;
        this.o = 3;
        d();
    }

    public void b(int i) {
        this.o = i;
    }

    public void c() {
        this.g = 1;
        this.e = new e(this.b, null);
        this.e.a(this.h);
        this.e.b(TiebaApplication.a().aa());
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnItemClickListener(new k(this));
        this.q = new o(this);
        this.d.setOnItemLongClickListener(new l(this));
        this.d.setOnScrollListener(new m(this));
        this.l.setVisibility(8);
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
            String a = this.j.a();
            if (a != null && a.length() > 0) {
                com.baidu.tieba.b.i iVar = new com.baidu.tieba.b.i();
                iVar.a(a);
                if (iVar.a()) {
                    ae.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a.length()));
                    a(iVar);
                    return;
                }
                ae.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                this.j.b();
            }
        }
        if (this.o != 4) {
            this.g = 1;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        stringBuffer.append(this.p);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("uid", TiebaApplication.u()));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.g)));
        if (this.o == 4 && this.f != null && (b = this.f.b()) != null && b.size() > 0) {
            com.baidu.tieba.a.o oVar = (com.baidu.tieba.a.o) b.get(b.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", oVar.g(), oVar.h())));
        }
        h();
        if (this.k != null) {
            this.k.a();
            this.k = null;
        }
        this.k = new p(this, stringBuffer.toString(), arrayList, this.e);
        this.k.execute(stringBuffer.toString(), arrayList);
    }

    public void e() {
        if (this.e == null || this.e.d() == TiebaApplication.a().aa()) {
            return;
        }
        this.e.b(TiebaApplication.a().aa());
        this.e.notifyDataSetChanged();
    }

    public void f() {
        i();
        h();
    }
}
