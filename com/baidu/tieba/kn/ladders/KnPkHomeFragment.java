package com.baidu.tieba.kn.ladders;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.BaseFragment;
import com.baidu.zeus.Headers;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class KnPkHomeFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    private u f1210a;
    private boolean b;
    private t c;
    private boolean d;

    @Override // android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.kn_pk_list_web_fragment, viewGroup, false);
        this.f1210a = new u(inflate);
        this.f1210a.f1230a.setOnLoadUrlListener(new r(this));
        this.f1210a.e.setOnClickListener(new s(this));
        this.b = true;
        return inflate;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void n() {
        super.n();
        this.d = true;
        a();
    }

    @Override // com.baidu.tieba.BaseFragment
    public void a(int i) {
        super.a(i);
    }

    @Override // android.support.v4.app.Fragment
    public void p() {
        try {
            super.p();
            if (this.c != null) {
                this.c.cancel();
                this.c = null;
            }
        } catch (NullPointerException e) {
            com.baidu.adp.lib.e.d.e("KnPkHomeFragment", "onDestroy", e.getMessage());
        }
    }

    public void a() {
        if (this.b && this.d) {
            Log.d("KnPkHomeFragment", Headers.REFRESH);
            this.c = new t(this, null);
            this.c.execute(new Void[0]);
            this.b = false;
        }
    }

    public void a(boolean z) {
        this.b = z;
    }
}
