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
    private u f1739a;
    private boolean b;
    private t c;
    private boolean d;

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.kn_pk_list_web_fragment, viewGroup, false);
        this.f1739a = new u(inflate);
        this.f1739a.f1759a.setOnLoadUrlListener(new r(this));
        this.f1739a.e.setOnClickListener(new s(this));
        this.b = true;
        return inflate;
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void p() {
        super.p();
        this.d = true;
        a();
    }

    @Override // com.baidu.tieba.BaseFragment
    public void c(int i) {
        super.c(i);
    }

    @Override // com.baidu.tieba.BaseFragment, android.support.v4.app.Fragment
    public void r() {
        try {
            super.r();
            if (this.c != null) {
                this.c.cancel();
                this.c = null;
            }
        } catch (NullPointerException e) {
            com.baidu.adp.lib.h.d.e("KnPkHomeFragment", "onDestroy", e.getMessage());
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
