package com.baidu.tieba.personCenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.personCenter.f.g;
import com.baidu.tieba.personCenter.mode.PersonCenterMode;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private BaseFragmentActivity aXt;
    private PersonCenterMode eAp;
    private g eAq;
    private com.baidu.tieba.personCenter.b.a eAr;
    private CustomMessageListener eAs = new b(this, CmdConfigCustom.CMD_PROFILE_CACHE_NEED_CHANGED);
    private boolean mIsLogin;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.aXt = getBaseFragmentActivity();
        this.mIsLogin = TbadkCoreApplication.isLogin();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eAp = new PersonCenterMode(this.aXt);
        registerListener(this.eAs);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.eAq = new g(this.aXt.getPageContext());
        return this.eAq.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.eAq.initUI();
        this.eAq.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eAr = new com.baidu.tieba.personCenter.b.a(this.aXt.getPageContext(), this.eAp, this.eAq);
        this.eAq.setOnViewResponseListener(this.eAr.aQq());
        this.eAq.a(this.eAr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        com.baidu.tieba.g.a.baJ().kC(isPrimary());
        if (isPrimary() && this.mIsLogin) {
            com.baidu.tieba.g.a.baJ().baQ();
            if (i.gX()) {
                this.eAq.KD();
                if (!this.eAr.hasData()) {
                    this.eAq.g(true, getResources().getDimensionPixelSize(w.f.ds480));
                }
                this.eAp.FC();
            } else if (!this.eAr.hasData()) {
                this.eAq.H(TbadkCoreApplication.m9getInst().getString(w.l.neterror), true);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eAq != null) {
            this.eAq.onChangeSkinType(i);
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
