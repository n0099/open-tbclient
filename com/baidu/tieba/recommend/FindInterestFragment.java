package com.baidu.tieba.recommend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.BaseFragment;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.bl;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FindInterestFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private com.baidu.tieba.model.o f1625a = null;
    private aq b = null;
    private Handler c = null;
    private Activity d = null;
    private bl e = null;
    private boolean f = false;
    private boolean g = true;
    private String h = null;
    private Runnable i = new ag(this);
    private com.baidu.tieba.view.ao Y = new ah(this);
    private com.baidu.adp.widget.ListView.r Z = new ai(this);
    private com.baidu.adp.widget.ListView.b aa = new aj(this);
    private AdapterView.OnItemClickListener ab = new ak(this);
    private View.OnClickListener ac = new al(this);
    private AbsListView.OnScrollListener ad = new am(this);

    @Override // android.support.v4.app.Fragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.c = new Handler();
        this.d = g();
        D();
        C();
    }

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.b.h();
    }

    @Override // android.support.v4.app.Fragment
    public void c() {
        super.c();
    }

    private void a() {
        String e = com.baidu.tieba.model.aq.e();
        if (e != null && e.length() > 0) {
            this.f1625a.a(e);
        }
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void n() {
        super.n();
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            if (!this.f) {
                this.f = true;
                this.h = E;
                a();
                B();
            } else if (!E.equals(this.h)) {
                this.h = E;
                B();
            } else if (this.g) {
                this.g = false;
                B();
            }
        } else if (this.f) {
            this.f = false;
            B();
        } else if (this.g) {
            this.g = false;
            B();
        }
        this.c.removeCallbacks(this.i);
        this.c.post(this.i);
        if (TiebaApplication.f().t()) {
            StatService.onEvent(this.d, "recommend_explore", "visit", 1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void o() {
        super.o();
        this.b.j();
    }

    @Override // android.support.v4.app.Fragment
    public void p() {
        super.p();
    }

    @Override // android.support.v4.app.Fragment
    public void e(Bundle bundle) {
        super.e(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            this.f = true;
            this.f1625a.c();
        } else {
            this.f = false;
            com.baidu.tieba.data.ae aeVar = new com.baidu.tieba.data.ae();
            ArrayList f = com.baidu.tieba.model.aq.f();
            if (f == null) {
                f = new ArrayList();
            }
            a(f);
            aeVar.a(f);
            this.b.a(aeVar);
        }
        if (this.e == null) {
            this.f1625a.a("get_all_interest", "", 1);
        } else {
            this.f1625a.a(this.e.a(), this.e.b(), 1);
            this.b.a(this.e.b());
        }
        this.b.b();
        StatService.onEvent(this.d, "findinterest_pull", "pulldate");
    }

    private void C() {
        this.f1625a = new com.baidu.tieba.model.o();
        this.f1625a.setLoadDataCallBack(new an(this));
        this.f1625a.a(new ap(this));
        String E = TiebaApplication.E();
        if (E != null && E.length() > 0) {
            this.f = true;
        } else {
            this.f = false;
        }
        com.baidu.tieba.data.ae a2 = this.f1625a.a();
        if (a2 != null) {
            a(a2);
            this.b.a(a2);
        }
        com.baidu.tieba.data.ac b = this.f1625a.b();
        if (b != null) {
            this.b.a(b);
        }
        StatService.onEvent(this.d, "findinterest_pull", "pulldate");
    }

    public void a(ArrayList arrayList) {
        bl blVar = new bl();
        blVar.a("get_all_interest");
        blVar.b("全部兴趣");
        arrayList.add(0, blVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.data.ae aeVar) {
        if (aeVar != null && aeVar.a() != null && aeVar.a().size() > 0) {
            this.e = (bl) aeVar.a().get(0);
        }
    }

    private void D() {
        this.b = new aq(this.d, this.ac);
        this.b.a(this.ab);
        this.b.a(this.ad);
        this.b.a(this.Z);
        this.b.a(this.aa);
        this.b.a(this.Y);
    }

    @Override // com.baidu.tieba.BaseFragment
    public void a(int i) {
        super.a(i);
        this.b.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public void a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 16002:
                    this.e = null;
                    B();
                    return;
                default:
                    return;
            }
        }
    }
}
