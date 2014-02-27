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
import com.baidu.tieba.ai;
import com.baidu.tieba.aj;
import com.baidu.tieba.model.ay;
import com.baidu.tieba.pb.NewPbActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public final class l {
    private Fragment b;
    private Activity c;
    private int i;
    private s j;
    private int n;
    private ViewGroup d = null;
    private BdListView e = null;
    private h f = null;
    private ay g = null;
    private int h = 1;
    private t k = null;
    private u l = null;
    private aj m = null;
    private String o = null;
    AlertDialog a = null;
    private Handler p = new Handler();
    private Runnable q = new m(this);

    public l(Fragment fragment, int i, s sVar) {
        this.b = null;
        this.c = null;
        this.i = 0;
        this.j = null;
        this.b = fragment;
        this.c = this.b.getActivity();
        this.i = i;
        this.j = sVar;
    }

    public final void a(int i) {
        this.n = i;
    }

    public final void a(BdListView bdListView) {
        this.e = bdListView;
    }

    public final void a(ViewGroup viewGroup) {
        this.d = viewGroup;
    }

    public final void a(String str) {
        this.o = str;
    }

    public final void a(aj ajVar) {
        this.m = ajVar;
    }

    public final void a() {
        this.f.a();
    }

    public final void b() {
        this.h = 1;
        this.n = 3;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(l lVar, com.baidu.tieba.data.t tVar) {
        if (tVar != null) {
            if (!tVar.j()) {
                if (lVar.i == 2) {
                    ai.a(lVar.c, "new_at_me_visit_pb");
                } else if (lVar.i == 1) {
                    ai.a(lVar.c, "new_my_reply_visit_pb");
                }
                NewPbActivity.a(lVar.c, tVar.g(), tVar.h(), "mention");
                return;
            }
            if (lVar.i == 2) {
                ai.a(lVar.c, "new_at_me_visit_post");
            } else if (lVar.i == 1) {
                ai.a(lVar.c, "new_my_reply_visit_post");
            }
            NewPbActivity.b(lVar.c, tVar.g(), tVar.h(), "mention");
        }
    }

    public final void c() {
        this.h = 1;
        this.f = new h(this.c, null);
        this.f.a(this.i);
        this.f.b(TiebaApplication.g().aa());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new o(this));
        this.e.setOnScrollListener(new p(this));
        this.e.setOnSrollToBottomListener(new q(this));
    }

    public final void d() {
        boolean z;
        ArrayList<com.baidu.tieba.data.t> b;
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
        stringBuffer.append(com.baidu.tieba.data.i.a);
        stringBuffer.append(this.o);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, TiebaApplication.v()));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.h)));
        if (this.n == 4 && this.g != null && (b = this.g.b()) != null && b.size() > 0) {
            com.baidu.tieba.data.t tVar = b.get(b.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", tVar.g(), tVar.h())));
        }
        h();
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.k = new t(this, stringBuffer.toString(), arrayList, this.f);
        this.k.setPriority(3);
        this.k.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(l lVar) {
        if (lVar.g == null || lVar.g.c().f() != 1) {
            return;
        }
        lVar.h++;
        lVar.n = 4;
        lVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ay ayVar, boolean z) {
        if (ayVar != null && ayVar.b() != null) {
            if (this.n == 4 && this.g != null) {
                ArrayList<com.baidu.tieba.data.t> b = this.g.b();
                b.addAll(ayVar.b());
                ayVar.a(b);
                this.g = null;
            }
            this.g = ayVar;
            if (this.g != null) {
                if (this.g.c().f() == 1) {
                    this.f.a(true);
                } else {
                    this.f.a(false);
                }
                ArrayList<com.baidu.tieba.data.t> b2 = this.g.b();
                if (b2 != null) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    this.f.a(b2, z);
                    this.f.notifyDataSetChanged();
                    if (this.n == 2 || this.n == 3) {
                        this.e.setSelectionFromTop(0, 0);
                    } else if (this.n == 4 && Build.VERSION.SDK_INT < 11) {
                        this.p.postDelayed(new r(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.m.b(0);
                    } else {
                        this.m.b(8);
                    }
                    if (this.b.isAdded()) {
                        if (this.b instanceof a) {
                            ((a) this.b).c(TiebaApplication.g().ae());
                        } else if (this.b instanceof af) {
                            ((af) this.b).c(TiebaApplication.g().ae());
                        }
                    }
                }
            }
            c cVar = (c) this.b.getParentFragment();
            if (cVar != null) {
                if ((this.n == 3 || this.n == 2) && !z) {
                    cVar.a(this.i, true);
                } else {
                    cVar.a(this.i, false);
                }
            }
        }
    }

    public final void e() {
        if (this.f != null && this.f.d() != TiebaApplication.g().aa()) {
            this.f.b(TiebaApplication.g().aa());
            this.f.notifyDataSetChanged();
        }
    }

    public final void f() {
        this.p.removeCallbacks(this.q);
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

    public final void g() {
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }
}
