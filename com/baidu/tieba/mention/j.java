package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.ah;
import com.baidu.tieba.model.bi;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class j {
    private Fragment b;
    private Activity c;
    private int i;
    private p j;
    private int n;
    private ViewGroup d = null;
    private BdListView e = null;
    private f f = null;
    private bi g = null;
    private int h = 1;
    private r k = null;
    private s l = null;
    private ah m = null;
    private String o = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1865a = null;
    private q p = null;
    private Handler q = new Handler();
    private Runnable r = new k(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int e(j jVar) {
        int i = jVar.h;
        jVar.h = i + 1;
        return i;
    }

    public j(Fragment fragment, int i, p pVar) {
        this.b = null;
        this.c = null;
        this.i = 0;
        this.j = null;
        this.b = fragment;
        this.c = this.b.i();
        this.i = i;
        this.j = pVar;
    }

    public void a(int i) {
        this.n = i;
    }

    public void a(BdListView bdListView) {
        this.e = bdListView;
    }

    public void a(ViewGroup viewGroup) {
        this.d = viewGroup;
    }

    public void a(String str) {
        this.o = str;
    }

    public void a(ah ahVar) {
        this.m = ahVar;
    }

    public void a() {
        this.f.a();
    }

    public void b() {
        this.h = 1;
        this.n = 3;
        d();
    }

    public void c() {
        this.p = new q(this);
        this.h = 1;
        this.f = new f(this.c, null);
        this.f.b(this.i);
        this.f.c(TiebaApplication.g().ao());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new m(this));
        this.e.setOnScrollListener(new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.v vVar, int i) {
        CharSequence[] charSequenceArr = {this.b.a(R.string.view_post), this.b.a(R.string.reply), this.b.a(R.string.view_pb)};
        MentionActivity g = g();
        if (g != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(g);
            builder.setTitle(this.b.a(R.string.operation));
            builder.setItems(charSequenceArr, this.p);
            this.f1865a = builder.create();
            this.f1865a.setCanceledOnTouchOutside(true);
            this.f1865a.show();
            this.f.a(i);
        }
    }

    public void d() {
        boolean z;
        String a2;
        ArrayList<com.baidu.tieba.data.v> b;
        switch (this.n) {
            case 2:
                z = true;
                break;
            case 3:
                if (this.f.b()) {
                    return;
                }
                z = true;
                break;
            case 4:
                if (this.f.c()) {
                    return;
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            if (this.g != null) {
                a(this.g, true);
                return;
            }
            String a3 = this.j.a();
            if (a3 != null && a3.length() > 0) {
                bi biVar = new bi();
                biVar.a(a3);
                if (!biVar.a()) {
                    be.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                    this.j.b();
                    b();
                    return;
                }
                be.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a3.length()));
                a(biVar, true);
                return;
            }
            z = true;
        } else if (this.n == 2 && (a2 = this.j.a()) != null && a2.length() > 0) {
            bi biVar2 = new bi();
            biVar2.a(a2);
            if (!biVar2.a()) {
                be.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                this.j.b();
            } else {
                be.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a2.length()));
                a(biVar2, true);
            }
        }
        if (z) {
            if (this.n != 4) {
                this.h = 1;
            }
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.h.f1165a);
            stringBuffer.append(this.o);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("uid", TiebaApplication.C()));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.h)));
            if (this.n == 4 && this.g != null && (b = this.g.b()) != null && b.size() > 0) {
                com.baidu.tieba.data.v vVar = b.get(b.size() - 1);
                arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", vVar.g(), vVar.h())));
            }
            h();
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
            }
            this.k = new r(this, stringBuffer.toString(), arrayList, this.f);
            this.k.setPriority(3);
            this.k.execute(stringBuffer.toString(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bi biVar, boolean z) {
        if (biVar != null && biVar.b() != null) {
            if (this.n == 4 && this.g != null) {
                ArrayList<com.baidu.tieba.data.v> b = this.g.b();
                b.addAll(biVar.b());
                biVar.a(b);
                this.g = null;
                this.g = biVar;
            } else {
                this.g = biVar;
            }
            if (this.g != null) {
                if (this.g.c().f() == 1) {
                    this.f.a(true);
                } else {
                    this.f.a(false);
                }
                ArrayList<com.baidu.tieba.data.v> b2 = this.g.b();
                if (b2 != null) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    this.f.a(b2, z);
                    this.f.notifyDataSetChanged();
                    if (this.n == 2 || this.n == 3) {
                        this.e.setSelectionFromTop(0, 0);
                    } else if (this.n == 4 && Build.VERSION.SDK_INT < 11) {
                        this.q.postDelayed(new o(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.m.b(0);
                    } else {
                        this.m.b(8);
                    }
                    if (this.b.l()) {
                        if (this.b instanceof AtMeFragment) {
                            ((AtMeFragment) this.b).c(TiebaApplication.g().as());
                        } else if (this.b instanceof ReplyMeFragment) {
                            ((ReplyMeFragment) this.b).c(TiebaApplication.g().as());
                        }
                    }
                }
            }
            MentionActivity g = g();
            if (g != null) {
                if (this.n == 3 || this.n == 2) {
                    if (z) {
                        g.a(this.i, false);
                        return;
                    } else {
                        g.a(this.i, true);
                        return;
                    }
                }
                g.a(this.i, false);
            }
        }
    }

    private MentionActivity g() {
        if (this.b == null) {
            return null;
        }
        android.support.v4.app.n i = this.b.i();
        return (i == null || !(i instanceof MentionActivity)) ? null : (MentionActivity) i;
    }

    public void e() {
        if (this.f != null && this.f.d() != TiebaApplication.g().ao()) {
            this.f.c(TiebaApplication.g().ao());
            this.f.notifyDataSetChanged();
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
        if (this.l != null) {
            this.l.cancel();
            this.l = null;
        }
        this.f.b(false);
        this.f.c(false);
        this.f.notifyDataSetChanged();
    }

    private void i() {
        this.q.removeCallbacks(this.r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.h.f1165a);
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
        this.l = new s(this, stringBuffer.toString(), arrayList, i, str3);
        this.l.setPriority(3);
        this.l.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.v vVar) {
        NewPbActivity.b(this.c, vVar.g(), vVar.h(), "mention");
    }
}
