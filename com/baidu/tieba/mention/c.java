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
import com.baidu.tbadk.core.atomData.bb;
import com.baidu.tieba.data.FeedData;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class c {
    private Fragment b;
    private Activity c;
    private int i;
    private h j;
    private int n;
    private ViewGroup d = null;
    private BdListView e = null;
    private k f = null;
    private com.baidu.tieba.model.al g = null;
    private int h = 1;
    private i k = null;
    private j l = null;
    private com.baidu.tbadk.core.view.o m = null;
    private String o = null;
    AlertDialog a = null;
    private final Handler p = new Handler();

    public c(Fragment fragment, int i, h hVar) {
        this.b = null;
        this.c = null;
        this.i = -1;
        this.j = null;
        this.b = fragment;
        this.c = this.b.getActivity();
        this.i = i;
        this.j = hVar;
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

    public void a() {
        this.f.a();
    }

    public void b() {
        this.h = 1;
        this.n = 3;
        d();
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

    public void c() {
        this.h = 1;
        this.f = new k(this.c, null);
        this.f.a(this.i);
        this.f.b(TbadkApplication.m252getInst().getFontSize());
        this.e.setAdapter((ListAdapter) this.f);
        this.e.setOnItemClickListener(new d(this));
        this.e.setOnScrollListener(new e(this));
        this.e.setOnSrollToBottomListener(new f(this));
    }

    public void d() {
        boolean z;
        ArrayList<FeedData> b;
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
            FeedData feedData = b.get(b.size() - 1);
            arrayList.add(new BasicNameValuePair("ids", String.format("%s,%s", feedData.getThread_id(), feedData.getPost_id())));
        }
        h();
        if (this.k != null) {
            this.k.cancel();
            this.k = null;
        }
        this.k = new i(this, stringBuffer.toString(), arrayList, this.f);
        this.k.setPriority(3);
        this.k.execute(stringBuffer.toString(), arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.g != null && this.g.c().f() == 1) {
            this.h++;
            this.n = 4;
            d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.model.al alVar, boolean z) {
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
                        this.p.postDelayed(new g(this, firstVisiblePosition), 10L);
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

    private void b(FeedData feedData) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new bb(this.c).b(feedData.getThread_id(), feedData.getPost_id(), "mention")));
    }

    public void f() {
        if (this.f != null) {
            this.f.notifyDataSetChanged();
        }
    }
}
