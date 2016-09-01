package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.personCenter.f.b;
import com.baidu.tieba.personCenter.g.g;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private BaseFragmentActivity aTi;
    private b eDc;
    private g eDd;
    private com.baidu.tieba.personCenter.b.a eDe;
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aTi = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eDc = new b(this.aTi);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eDd = new g(this.aTi.getPageContext());
        return this.eDd.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.eDd.initUI();
        this.eDd.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eDe = new com.baidu.tieba.personCenter.b.a(this.aTi.getPageContext(), this.eDc, this.eDd);
        this.eDd.setOnViewResponseListener(this.eDe.aSp());
        this.eDd.a(this.eDe);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.g.a.bbB().kc(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.g.a.bbB().bbI();
            if (i.fZ()) {
                this.eDd.La();
                if (!this.eDe.hasData()) {
                    this.eDd.i(true, getResources().getDimensionPixelSize(t.e.ds480));
                }
                this.eDc.Fa();
            } else if (!this.eDe.hasData()) {
                this.eDd.F(TbadkCoreApplication.m9getInst().getString(t.j.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eDd != null) {
            this.eDd.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
    }
}
