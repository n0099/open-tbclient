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
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v {
    private com.baidu.tbadk.core.d b;
    private Activity c;
    private int i;
    private BdUniqueId j;
    private int n;
    private com.baidu.tieba.b.a p;
    private ViewGroup d = null;
    private BdListView e = null;
    private k f = null;
    private com.baidu.tieba.model.al g = null;
    private int h = 1;
    private ad k = null;
    private Handler l = new Handler();
    private com.baidu.tbadk.core.view.o m = null;
    private String o = null;
    AlertDialog a = null;
    private final Handler q = new Handler();
    private com.baidu.adp.framework.listener.a r = new w(this, CmdConfigHttp.REPLYME_HTTP_CMD, 303007);

    public v(com.baidu.tbadk.core.d dVar, int i, ac acVar) {
        this.b = null;
        this.c = null;
        this.i = -1;
        this.j = null;
        this.p = null;
        this.b = dVar;
        this.c = this.b.getActivity();
        this.i = i;
        this.j = BdUniqueId.gen();
        this.r.a(this.j);
        MessageManager.getInstance().registerListener(this.r);
        this.p = new com.baidu.tieba.b.a("replymeStat");
    }

    public void a() {
        b();
        this.g.cancelLoadData();
        if (this.p != null) {
            this.p.b();
            this.p = null;
        }
    }

    public void b() {
        MessageManager.getInstance().unRegisterListener(this.j);
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

    public void a(com.baidu.tbadk.core.view.o oVar) {
        this.m = oVar;
    }

    public void c() {
        this.f.a();
    }

    public void d() {
        this.h = 1;
        this.n = 3;
        f();
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
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bb(this.c).a(feedData.getThread_id(), feedData.getPost_id(), "mention")));
        }
    }

    public void e() {
        this.h = 1;
        this.f = new k(this.c, null);
        this.f.a(this.i);
        if (this.b instanceof an) {
            this.f.a((an) this.b);
        }
        this.f.b(TbadkApplication.m252getInst().getFontSize());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new x(this));
        this.e.setOnSrollToBottomListener(new y(this));
    }

    public void f() {
        boolean z = false;
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
        }
        if (!z && this.g != null) {
            a(this.g, true);
            return;
        }
        if (this.n != 4) {
            this.h = 1;
        }
        j();
        a(true);
        com.baidu.tieba.model.al alVar = new com.baidu.tieba.model.al();
        l();
        alVar.a(this.n, this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.g != null && this.g.c().f() == 1) {
            this.h++;
            this.n = 4;
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.al alVar, boolean z) {
        a(false);
        if (alVar != null && alVar.b() != null) {
            if (this.n == 4 && this.g != null) {
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
                    if (this.n == 2 || this.n == 3) {
                        this.e.setSelectionFromTop(0, 0);
                    } else if (this.n == 4 && Build.VERSION.SDK_INT < 11) {
                        this.q.postDelayed(new z(this, firstVisiblePosition), 10L);
                    }
                    if (b2.size() == 0) {
                        this.m.b(0);
                    } else {
                        this.m.b(8);
                    }
                    if (this.b.isAdded()) {
                        if (this.b instanceof a) {
                            ((a) this.b).c(TbadkApplication.m252getInst().getSkinType());
                        } else if (this.b instanceof an) {
                            ((an) this.b).c(TbadkApplication.m252getInst().getSkinType());
                        }
                    }
                }
            }
            p pVar = (p) this.b.getParentFragment();
            if (pVar != null) {
                if (this.n == 3 || this.n == 2) {
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

    public void g() {
        if (this.f != null && this.f.d() != TbadkApplication.m252getInst().getFontSize()) {
            this.f.b(TbadkApplication.m252getInst().getFontSize());
            this.f.notifyDataSetChanged();
        }
    }

    private void j() {
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
            switch (this.n) {
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
        switch (this.n) {
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

    private com.baidu.adp.lib.cache.t<byte[]> k() {
        return com.baidu.tbadk.core.a.a.a().a("tb_user_profile", TbadkApplication.getCurrentAccountName());
    }

    private void l() {
        k().a("replyme_cache", new aa(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.baidu.tbadk.core.a.a.a().d("tb_user_profile", TbadkApplication.getCurrentAccountName());
    }

    private void b(FeedData feedData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bb(this.c).b(feedData.getThread_id(), feedData.getPost_id(), "mention")));
    }

    public void h() {
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }
}
