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
import com.baidu.tieba.ae;
import com.baidu.tieba.model.az;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i {
    private Fragment b;
    private Activity c;
    private int i;
    private o j;
    private int n;
    private ViewGroup d = null;
    private BdListView e = null;
    private f f = null;
    private az g = null;
    private int h = 1;
    private q k = null;
    private r l = null;
    private ae m = null;
    private String o = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1367a = null;
    private p p = null;
    private Handler q = new Handler();
    private Runnable r = new j(this);

    public i(Fragment fragment, int i, o oVar) {
        this.b = null;
        this.c = null;
        this.i = 0;
        this.j = null;
        this.b = fragment;
        this.c = this.b.h();
        this.i = i;
        this.j = oVar;
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

    public void a(ae aeVar) {
        this.m = aeVar;
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
        this.p = new p(this);
        this.h = 1;
        this.f = new f(this.c, null);
        this.f.b(this.i);
        this.f.c(TiebaApplication.g().am());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new l(this));
        this.e.setOnScrollListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.u uVar, int i) {
        CharSequence[] charSequenceArr = {this.b.a(R.string.view_post), this.b.a(R.string.reply), this.b.a(R.string.view_pb)};
        MentionActivity g = g();
        if (g != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(g);
            builder.setTitle(this.b.a(R.string.operation));
            builder.setItems(charSequenceArr, this.p);
            this.f1367a = builder.create();
            this.f1367a.setCanceledOnTouchOutside(true);
            this.f1367a.show();
            this.f.a(i);
        }
    }

    public void d() {
        boolean z;
        String a2;
        ArrayList<com.baidu.tieba.data.u> b;
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
                az azVar = new az();
                azVar.a(a3);
                if (!azVar.a()) {
                    av.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                    this.j.b();
                    b();
                    return;
                }
                av.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a3.length()));
                a(azVar, true);
                return;
            }
            z = true;
        } else if (this.n == 2 && (a2 = this.j.a()) != null && a2.length() > 0) {
            az azVar2 = new az();
            azVar2.a(a2);
            if (!azVar2.a()) {
                av.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                this.j.b();
            } else {
                av.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a2.length()));
                a(azVar2, true);
            }
        }
        if (z) {
            if (this.n != 4) {
                this.h = 1;
            }
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.g.f1032a);
            stringBuffer.append(this.o);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("uid", TiebaApplication.C()));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.h)));
            if (this.n == 4 && this.g != null && (b = this.g.b()) != null && b.size() > 0) {
                com.baidu.tieba.data.u uVar = b.get(b.size() - 1);
                arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", uVar.g(), uVar.h())));
            }
            h();
            if (this.k != null) {
                this.k.cancel();
                this.k = null;
            }
            this.k = new q(this, stringBuffer.toString(), arrayList, this.f);
            this.k.setPriority(3);
            this.k.execute(stringBuffer.toString(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(az azVar, boolean z) {
        if (azVar != null && azVar.b() != null) {
            if (this.n == 4 && this.g != null) {
                ArrayList<com.baidu.tieba.data.u> b = this.g.b();
                b.addAll(azVar.b());
                azVar.a(b);
                this.g = null;
                this.g = azVar;
            } else {
                this.g = azVar;
            }
            if (this.g != null) {
                if (this.g.c().f() == 1) {
                    this.f.a(true);
                } else {
                    this.f.a(false);
                }
                ArrayList<com.baidu.tieba.data.u> b2 = this.g.b();
                if (b2 != null) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    this.f.a(b2, z);
                    this.f.notifyDataSetChanged();
                    if (this.n == 2 || this.n == 3) {
                        this.e.setSelectionFromTop(0, 0);
                    } else if (this.n == 4 && Build.VERSION.SDK_INT < 11) {
                        this.q.postDelayed(new n(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.m.b(0);
                    } else {
                        this.m.b(8);
                    }
                    if (this.b.k()) {
                        if (this.b instanceof AtMeFragment) {
                            ((AtMeFragment) this.b).b(TiebaApplication.g().ap());
                        } else if (this.b instanceof ReplyMeFragment) {
                            ((ReplyMeFragment) this.b).b(TiebaApplication.g().ap());
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
        android.support.v4.app.n h = this.b.h();
        return (h == null || !(h instanceof MentionActivity)) ? null : (MentionActivity) h;
    }

    public void e() {
        if (this.f != null && this.f.d() != TiebaApplication.g().am()) {
            this.f.c(TiebaApplication.g().am());
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
        stringBuffer.append(com.baidu.tieba.data.g.f1032a);
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
        this.l = new r(this, stringBuffer.toString(), arrayList, i, str3);
        this.l.setPriority(3);
        this.l.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.u uVar) {
        NewPbActivity.b(this.c, uVar.g(), uVar.h(), "mention");
    }
}
