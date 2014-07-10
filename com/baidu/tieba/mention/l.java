package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.aw;
import com.baidu.tieba.model.ak;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class l {
    private Fragment b;
    private Activity c;
    private int i;
    private q j;
    private int n;
    private ViewGroup d = null;
    private BdListView e = null;
    private c f = null;
    private ak g = null;
    private int h = 1;
    private r k = null;
    private s l = null;
    private com.baidu.tbadk.core.view.k m = null;
    private String o = null;
    AlertDialog a = null;
    private final Handler p = new Handler();

    public l(Fragment fragment, int i, q qVar) {
        this.b = null;
        this.c = null;
        this.i = -1;
        this.j = null;
        this.b = fragment;
        this.c = this.b.getActivity();
        this.i = i;
        this.j = qVar;
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

    public void a(com.baidu.tbadk.core.view.k kVar) {
        this.m = kVar;
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
    public void a(com.baidu.tieba.data.p pVar) {
        if (pVar != null) {
            if (pVar.m()) {
                if (this.i == 2) {
                    com.baidu.tbadk.core.f.a(this.c, "new_at_me_visit_post");
                } else if (this.i == 1) {
                    com.baidu.tbadk.core.f.a(this.c, "new_my_reply_visit_post");
                    if ("zan".equals(pVar.a())) {
                        com.baidu.tbadk.core.f.a(this.c, "zan_mlist");
                    }
                }
                b(pVar);
                return;
            }
            if (this.i == 2) {
                com.baidu.tbadk.core.f.a(this.c, "new_at_me_visit_pb");
            } else if (this.i == 1) {
                com.baidu.tbadk.core.f.a(this.c, "new_my_reply_visit_pb");
                if ("zan".equals(pVar.a())) {
                    com.baidu.tbadk.core.f.a(this.c, "zan_mlist");
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new aw(this.c).a(pVar.j(), pVar.k(), "mention")));
        }
    }

    public void c() {
        this.h = 1;
        this.f = new c(this.c, null);
        this.f.a(this.i);
        this.f.b(TbadkApplication.m252getInst().getFontSize());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new m(this));
        this.e.setOnScrollListener(new n(this));
        this.e.setOnSrollToBottomListener(new o(this));
    }

    public void d() {
        boolean z;
        ArrayList<com.baidu.tieba.data.p> b;
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
        stringBuffer.append(TbConfig.SERVER_ADDRESS);
        stringBuffer.append(this.o);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount()));
        arrayList.add(new BasicNameValuePair("pn", String.valueOf(this.h)));
        if (this.n == 4 && this.g != null && (b = this.g.b()) != null && b.size() > 0) {
            com.baidu.tieba.data.p pVar = b.get(b.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", pVar.j(), pVar.k())));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.g != null && this.g.c().e() == 1) {
            this.h++;
            this.n = 4;
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ak akVar, boolean z) {
        if (akVar != null && akVar.b() != null) {
            if (this.n == 4 && this.g != null) {
                ArrayList<com.baidu.tieba.data.p> b = this.g.b();
                b.addAll(akVar.b());
                akVar.a(b);
                this.g = null;
                this.g = akVar;
            } else {
                this.g = akVar;
            }
            if (this.g != null) {
                if (this.g.c().e() == 1) {
                    this.f.a(true);
                } else {
                    this.f.a(false);
                }
                ArrayList<com.baidu.tieba.data.p> b2 = this.g.b();
                if (b2 != null) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    this.f.a(b2, z);
                    this.f.notifyDataSetChanged();
                    if (this.n == 2 || this.n == 3) {
                        this.e.setSelectionFromTop(0, 0);
                    } else if (this.n == 4 && Build.VERSION.SDK_INT < 11) {
                        this.p.postDelayed(new p(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.m.b(0);
                    } else {
                        this.m.b(8);
                    }
                    if (this.b.isAdded()) {
                        if (this.b instanceof a) {
                            ((a) this.b).c(TbadkApplication.m252getInst().getSkinType());
                        } else if (this.b instanceof ac) {
                            ((ac) this.b).c(TbadkApplication.m252getInst().getSkinType());
                        }
                    }
                }
            }
            f fVar = (f) this.b.getParentFragment();
            if (fVar != null) {
                if (this.n == 3 || this.n == 2) {
                    if (z) {
                        fVar.a(this.i, false);
                        return;
                    } else {
                        fVar.a(this.i, true);
                        return;
                    }
                }
                fVar.a(this.i, false);
            }
        }
    }

    public void e() {
        if (this.f != null && this.f.d() != TbadkApplication.m252getInst().getFontSize()) {
            this.f.b(TbadkApplication.m252getInst().getFontSize());
            this.f.notifyDataSetChanged();
        }
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

    private void b(com.baidu.tieba.data.p pVar) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new aw(this.c).b(pVar.j(), pVar.k(), "mention")));
    }

    public void f() {
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }
}
