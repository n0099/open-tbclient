package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.util.aq;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class i {
    private com.baidu.tieba.g b;
    private int h;
    private n i;
    private int m;
    private ViewGroup c = null;
    private BdListView d = null;
    private f e = null;
    private ax f = null;
    private int g = 1;
    private p j = null;
    private q k = null;
    private com.baidu.tieba.ab l = null;
    private String n = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1332a = null;
    private o o = null;
    private Handler p = new Handler();
    private Runnable q = new j(this);

    public i(com.baidu.tieba.g gVar, int i, n nVar) {
        this.b = null;
        this.h = 0;
        this.i = null;
        this.b = gVar;
        this.h = i;
        this.i = nVar;
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(BdListView bdListView) {
        this.d = bdListView;
    }

    public void a(ViewGroup viewGroup) {
        this.c = viewGroup;
    }

    public void a(String str) {
        this.n = str;
    }

    public void a(com.baidu.tieba.ab abVar) {
        this.l = abVar;
    }

    public void a() {
        this.e.a();
    }

    public void b() {
        this.g = 1;
        this.m = 3;
        d();
    }

    public void c() {
        this.o = new o(this);
        this.g = 1;
        this.e = new f(this.b, null);
        this.e.b(this.h);
        this.e.c(TiebaApplication.g().ak());
        this.d.setAdapter((ListAdapter) this.e);
        this.d.setOnItemClickListener(new l(this));
        this.d.setOnScrollListener(new m(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.u uVar, int i) {
        CharSequence[] charSequenceArr = {this.b.getString(R.string.view_post), this.b.getString(R.string.reply), this.b.getString(R.string.view_pb)};
        MentionActivity g = g();
        if (g != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(g);
            builder.setTitle(this.b.getString(R.string.operation));
            builder.setItems(charSequenceArr, this.o);
            this.f1332a = builder.create();
            this.f1332a.setCanceledOnTouchOutside(true);
            this.f1332a.show();
            this.e.a(i);
        }
    }

    public void d() {
        boolean z;
        String a2;
        ArrayList b;
        switch (this.m) {
            case 2:
                z = true;
                break;
            case 3:
                if (this.e.b()) {
                    return;
                }
                z = true;
                break;
            case 4:
                if (this.e.c()) {
                    return;
                }
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            if (this.f != null) {
                a(this.f, true);
                return;
            }
            String a3 = this.i.a();
            if (a3 != null && a3.length() > 0) {
                ax axVar = new ax();
                axVar.a(a3);
                if (!axVar.a()) {
                    aq.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                    this.i.b();
                    b();
                    return;
                }
                aq.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a3.length()));
                a(axVar, true);
                return;
            }
            z = true;
        } else if (this.m == 2 && (a2 = this.i.a()) != null && a2.length() > 0) {
            ax axVar2 = new ax();
            axVar2.a(a2);
            if (!axVar2.a()) {
                aq.a("HomeLikeAsyncTask", "doInBackground", "cache data format err");
                this.i.b();
            } else {
                aq.a("HomeLikeAsyncTask", "doInBackground", "cache data.size: " + String.valueOf(a2.length()));
                a(axVar2, true);
            }
        }
        if (z) {
            if (this.m != 4) {
                this.g = 1;
            }
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append(com.baidu.tieba.data.g.f1014a);
            stringBuffer.append(this.n);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("uid", TiebaApplication.E()));
            arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.g)));
            if (this.m == 4 && this.f != null && (b = this.f.b()) != null && b.size() > 0) {
                com.baidu.tieba.data.u uVar = (com.baidu.tieba.data.u) b.get(b.size() - 1);
                arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", uVar.g(), uVar.h())));
            }
            h();
            if (this.j != null) {
                this.j.cancel();
                this.j = null;
            }
            this.j = new p(this, stringBuffer.toString(), arrayList, this.e);
            this.j.setPriority(3);
            this.j.execute(stringBuffer.toString(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ax axVar, boolean z) {
        if (axVar != null && axVar.b() != null) {
            if (this.m == 4 && this.f != null) {
                ArrayList b = this.f.b();
                b.addAll(axVar.b());
                axVar.a(b);
                this.f = null;
                this.f = axVar;
            } else {
                this.f = axVar;
            }
            if (this.f != null) {
                if (this.f.c().f() == 1) {
                    this.e.a(true);
                } else {
                    this.e.a(false);
                }
                ArrayList b2 = this.f.b();
                if (b2 != null) {
                    this.e.a(b2, z);
                    this.e.notifyDataSetChanged();
                    if (this.m == 2 || this.m == 3) {
                        this.d.setSelectionFromTop(0, 0);
                    }
                    if (b2.size() == 0) {
                        this.l.b(0);
                    } else {
                        this.l.b(8);
                    }
                    if (this.b instanceof AtMeActivity) {
                        ((AtMeActivity) this.b).a(TiebaApplication.g().an());
                    } else if (this.b instanceof ReplyMeActivity) {
                        ((ReplyMeActivity) this.b).a(TiebaApplication.g().an());
                    }
                }
            }
            MentionActivity g = g();
            if (g != null) {
                if (this.m == 3 || this.m == 2) {
                    if (z) {
                        g.a(this.h, false);
                        return;
                    } else {
                        g.a(this.h, true);
                        return;
                    }
                }
                g.a(this.h, false);
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
        if (this.e != null && this.e.d() != TiebaApplication.g().ak()) {
            this.e.c(TiebaApplication.g().ak());
            this.e.notifyDataSetChanged();
        }
    }

    public void f() {
        i();
        h();
    }

    private void h() {
        if (this.j != null) {
            this.j.cancel();
            this.j = null;
        }
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.e.b(false);
        this.e.c(false);
        this.e.notifyDataSetChanged();
    }

    private void i() {
        this.p.removeCallbacks(this.q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.g.f1014a);
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
        this.k = new q(this, stringBuffer.toString(), arrayList, i, str3);
        this.k.setPriority(3);
        this.k.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.u uVar) {
        NewPbActivity.b(this.b, uVar.g(), uVar.h(), "mention");
    }
}
