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
import com.baidu.tieba.al;
import com.baidu.tieba.am;
import com.baidu.tieba.model.bj;
import com.baidu.tieba.pb.NewPbActivity;
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
    private bj g = null;
    private int h = 1;
    private r k = null;
    private s l = null;
    private am m = null;
    private String o = null;
    private com.baidu.tieba.view.q p = null;

    /* renamed from: a  reason: collision with root package name */
    AlertDialog f1844a = null;
    private q q = null;
    private Handler r = new Handler();
    private Runnable s = new k(this);

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

    public void a(am amVar) {
        this.m = amVar;
    }

    public void a() {
        this.f.a();
    }

    public void b() {
        this.h = 1;
        this.n = 3;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.u uVar) {
        if (uVar != null) {
            if (uVar.j()) {
                if (this.i == 2) {
                    al.a(this.c, "new_at_me_visit_post");
                } else if (this.i == 1) {
                    al.a(this.c, "new_my_reply_visit_post");
                }
                b(uVar);
                return;
            }
            if (this.i == 2) {
                al.a(this.c, "new_at_me_visit_pb");
            } else if (this.i == 1) {
                al.a(this.c, "new_my_reply_visit_pb");
            }
            NewPbActivity.a(this.c, uVar.g(), uVar.h(), "mention");
        }
    }

    public void c() {
        this.q = new q(this);
        this.h = 1;
        this.f = new f(this.c, null);
        this.f.a(this.i);
        this.f.b(TiebaApplication.g().al());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new m(this));
        this.e.setOnScrollListener(new n(this));
    }

    public void d() {
        boolean z;
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
        if (!z && this.g != null) {
            a(this.g, true);
            return;
        }
        if (this.n != 4) {
            this.h = 1;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.h.f1201a);
        stringBuffer.append(this.o);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("uid", TiebaApplication.A()));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.h)));
        if (this.n == 4 && this.g != null && (b = this.g.b()) != null && b.size() > 0) {
            com.baidu.tieba.data.u uVar = b.get(b.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", uVar.g(), uVar.h())));
        }
        g();
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.k = new r(this, stringBuffer.toString(), arrayList, this.f);
        this.k.setPriority(3);
        this.k.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bj bjVar, boolean z) {
        if (bjVar != null && bjVar.b() != null) {
            if (this.n == 4 && this.g != null) {
                ArrayList<com.baidu.tieba.data.u> b = this.g.b();
                b.addAll(bjVar.b());
                bjVar.a(b);
                this.g = null;
                this.g = bjVar;
            } else {
                this.g = bjVar;
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
                        this.r.postDelayed(new o(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.m.b(0);
                    } else {
                        this.m.b(8);
                    }
                    if (this.b.n()) {
                        if (this.b instanceof AtMeFragment) {
                            ((AtMeFragment) this.b).c(TiebaApplication.g().ap());
                        } else if (this.b instanceof ReplyMeFragment) {
                            ((ReplyMeFragment) this.b).c(TiebaApplication.g().ap());
                        }
                    }
                }
            }
            MentionActivity mentionActivity = (MentionActivity) this.b.m();
            if (mentionActivity != null) {
                if (this.n == 3 || this.n == 2) {
                    if (z) {
                        mentionActivity.a(this.i, false);
                        return;
                    } else {
                        mentionActivity.a(this.i, true);
                        return;
                    }
                }
                mentionActivity.a(this.i, false);
            }
        }
    }

    public void e() {
        if (this.f != null && this.f.d() != TiebaApplication.g().al()) {
            this.f.b(TiebaApplication.g().al());
            this.f.notifyDataSetChanged();
        }
    }

    public void f() {
        h();
        g();
    }

    private void g() {
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

    private void h() {
        this.r.removeCallbacks(this.s);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append(com.baidu.tieba.data.h.f1201a);
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
        g();
        this.l = new s(this, stringBuffer.toString(), arrayList, i, str3);
        this.l.setPriority(3);
        this.l.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.data.u uVar) {
        NewPbActivity.b(this.c, uVar.g(), uVar.h(), "mention");
    }
}
