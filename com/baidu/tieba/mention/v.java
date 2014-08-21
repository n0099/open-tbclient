package com.baidu.tieba.mention;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.bc;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v {
    private com.baidu.tbadk.core.d b;
    private Activity c;
    private int i;
    private BdUniqueId j;
    private int m;
    private com.baidu.tieba.b.a o;
    private ViewGroup d = null;
    private BdListView e = null;
    private k f = null;
    private com.baidu.tieba.model.al g = null;
    private int h = 1;
    private ab k = null;
    private com.baidu.tbadk.core.view.p l = null;
    private String n = null;
    AlertDialog a = null;
    private final Handler p = new Handler();
    private com.baidu.adp.framework.listener.a q = new w(this, CmdConfigHttp.REPLYME_HTTP_CMD, 303007);

    public v(com.baidu.tbadk.core.d dVar, int i, aa aaVar) {
        this.b = null;
        this.c = null;
        this.i = -1;
        this.j = null;
        this.o = null;
        this.b = dVar;
        this.c = this.b.getActivity();
        this.i = i;
        this.j = BdUniqueId.gen();
        this.q.a(this.j);
        MessageManager.getInstance().registerListener(this.q);
        this.o = new com.baidu.tieba.b.a("replymeStat");
    }

    public void a() {
        b();
        this.g.cancelLoadData();
        if (this.o != null) {
            this.o.b();
            this.o = null;
        }
    }

    public void b() {
        MessageManager.getInstance().unRegisterListener(this.j);
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(BdListView bdListView) {
        this.e = bdListView;
    }

    public void a(ViewGroup viewGroup) {
        this.d = viewGroup;
    }

    public void a(String str) {
        this.n = str;
    }

    public void a(com.baidu.tbadk.core.view.p pVar) {
        this.l = pVar;
    }

    public void c() {
        this.f.a();
    }

    public void d() {
        this.h = 1;
        this.m = 3;
        g();
    }

    public void a(com.baidu.tieba.model.al alVar) {
        a(alVar, true);
    }

    public int e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FeedData feedData) {
        if (feedData != null) {
            if (feedData.getIsFloor()) {
                if (this.i == 2) {
                    com.baidu.tbadk.core.f.a(this.c, "new_at_me_visit_post");
                } else if (this.i == 1) {
                    com.baidu.tbadk.core.f.a(this.c, "new_my_reply_visit_post");
                    if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                        com.baidu.tbadk.core.f.a(this.c, "zan_mlist");
                    }
                }
                b(feedData);
                return;
            }
            if (this.i == 2) {
                com.baidu.tbadk.core.f.a(this.c, "new_at_me_visit_pb");
            } else if (this.i == 1) {
                com.baidu.tbadk.core.f.a(this.c, "new_my_reply_visit_pb");
                if (FeedData.TYPE_ZAN.equals(feedData.getPraiseItemType())) {
                    com.baidu.tbadk.core.f.a(this.c, "zan_mlist");
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bc(this.c).a(feedData.getThread_id(), feedData.getPost_id(), "mention")));
        }
    }

    public void f() {
        this.h = 1;
        this.f = new k(this.c, null);
        this.f.a(this.i);
        if (this.b instanceof al) {
            this.f.a((al) this.b);
        }
        this.f.b(TbadkApplication.m252getInst().getFontSize());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new x(this));
        this.e.setOnSrollToBottomListener(new y(this));
    }

    public void g() {
        boolean z = false;
        switch (this.m) {
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
        }
        if (!z && this.g != null) {
            a(this.g, true);
            return;
        }
        if (this.m != 4) {
            this.h = 1;
        }
        k();
        a(true);
        com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
        l();
        alVar.a(this.m, this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.g != null && this.g.c().f() == 1) {
            this.h++;
            this.m = 4;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.al alVar, boolean z) {
        a(false);
        if (alVar != null && alVar.b() != null) {
            if (this.m == 4 && this.g != null) {
                ArrayList<FeedData> b = this.g.b();
                b.addAll(alVar.b());
                alVar.a(b);
                this.g = null;
                this.g = alVar;
            } else {
                this.g = alVar;
            }
            if (this.g != null) {
                if (this.g.c().f() == 1) {
                    this.f.a(true);
                } else {
                    this.f.a(false);
                }
                ArrayList<FeedData> b2 = this.g.b();
                if (b2 != null) {
                    int firstVisiblePosition = this.e.getFirstVisiblePosition();
                    this.f.a(b2, z);
                    this.f.notifyDataSetChanged();
                    if (this.m == 2 || this.m == 3) {
                        this.e.setSelectionFromTop(0, 0);
                    } else if (this.m == 4 && Build.VERSION.SDK_INT < 11) {
                        this.p.postDelayed(new z(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.l.b(0);
                    } else {
                        this.l.b(8);
                    }
                    if (this.b.isAdded()) {
                        if (this.b instanceof a) {
                            ((a) this.b).c(TbadkApplication.m252getInst().getSkinType());
                        } else if (this.b instanceof al) {
                            ((al) this.b).c(TbadkApplication.m252getInst().getSkinType());
                        }
                    }
                }
            }
            p pVar = (p) this.b.getParentFragment();
            if (pVar != null) {
                if (this.m == 3 || this.m == 2) {
                    if (z) {
                        pVar.a(this.i, false);
                        return;
                    } else {
                        pVar.a(this.i, true);
                        return;
                    }
                }
                pVar.a(this.i, false);
            }
        }
    }

    public void h() {
        if (this.f != null && this.f.d() != TbadkApplication.m252getInst().getFontSize()) {
            this.f.b(TbadkApplication.m252getInst().getFontSize());
            this.f.notifyDataSetChanged();
        }
    }

    private void k() {
        a(false);
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        if (this.g != null) {
            this.g.cancelLoadData();
        }
        this.f.b(false);
        this.f.c(false);
        this.f.notifyDataSetChanged();
    }

    private void a(boolean z) {
        if (z) {
            switch (this.m) {
                case 1:
                case 2:
                case 3:
                    if (this.e != null) {
                        this.e.e();
                        return;
                    }
                    return;
                case 4:
                    this.f.c(true);
                    this.f.notifyDataSetChanged();
                    return;
                default:
                    return;
            }
        }
        switch (this.m) {
            case 1:
            case 2:
            case 3:
                if (this.e != null) {
                    this.e.d();
                    return;
                }
                return;
            case 4:
                this.f.c(false);
                this.f.notifyDataSetChanged();
                return;
            default:
                return;
        }
    }

    private void l() {
        if (this.b != null) {
            this.b.a(new CustomMessage(2001229));
        }
    }

    private void b(FeedData feedData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bc(this.c).b(feedData.getThread_id(), feedData.getPost_id(), "mention")));
    }

    public void i() {
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }
}
