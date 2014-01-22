package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.as;
import com.baidu.tieba.at;
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
    private q k = null;
    private r l = null;
    private at m = null;
    private String o = null;
    AlertDialog a = null;
    private Handler p = new Handler();
    private Runnable q = new k(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(j jVar) {
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

    public void a(at atVar) {
        this.m = atVar;
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
                    as.a(this.c, "new_at_me_visit_post");
                } else if (this.i == 1) {
                    as.a(this.c, "new_my_reply_visit_post");
                }
                b(uVar);
                return;
            }
            if (this.i == 2) {
                as.a(this.c, "new_at_me_visit_pb");
            } else if (this.i == 1) {
                as.a(this.c, "new_my_reply_visit_pb");
            }
            NewPbActivity.a(this.c, uVar.g(), uVar.h(), "mention");
        }
    }

    public void c() {
        this.h = 1;
        this.f = new f(this.c, null);
        this.f.a(this.i);
        this.f.b(TiebaApplication.h().ai());
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
        stringBuffer.append(com.baidu.tieba.data.h.a);
        stringBuffer.append(this.o);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, TiebaApplication.A()));
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
        this.k = new q(this, stringBuffer.toString(), arrayList, this.f);
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
                        this.p.postDelayed(new o(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.m.b(0);
                    } else {
                        this.m.b(8);
                    }
                    if (this.b.n()) {
                        if (this.b instanceof AtMeFragment) {
                            ((AtMeFragment) this.b).d(TiebaApplication.h().al());
                        } else if (this.b instanceof ReplyMeFragment) {
                            ((ReplyMeFragment) this.b).d(TiebaApplication.h().al());
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
        if (this.f != null && this.f.d() != TiebaApplication.h().ai()) {
            this.f.b(TiebaApplication.h().ai());
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
        this.p.removeCallbacks(this.q);
    }

    private void b(com.baidu.tieba.data.u uVar) {
        NewPbActivity.b(this.c, uVar.g(), uVar.h(), "mention");
    }
}
