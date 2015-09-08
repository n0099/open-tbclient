package com.baidu.tieba.recommendfrs.control;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.e.h;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private com.baidu.tbadk.e.f cAP;
    private ScrollFragmentTabHost cAU;
    private com.baidu.tieba.recommendfrs.control.a.b cAV;
    private CustomMessageTask cAX;
    private h refreshView;
    private List<String> cAW = new ArrayList();
    private CustomMessageListener cAY = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private com.baidu.tieba.recommendfrs.a cAZ = new c(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(i.g.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary()) {
            TiebaStatic.log("kantie_entry");
        }
        TbadkCoreApplication.m411getInst().setEnterRecommendFrs(true);
        if (this.cAW == null || this.cAW.size() <= 0) {
            this.cAV.kw("头条");
            a(getView(), false, getResources().getDimensionPixelSize(i.d.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        HE();
        this.cAU = (ScrollFragmentTabHost) getView().findViewById(i.f.recommend_frs_tab_host);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cAY);
        anu();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
    }

    private void anu() {
        this.cAX = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new d(this));
        this.cAX.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cAX);
    }

    private void HE() {
        this.cAV = new com.baidu.tieba.recommendfrs.control.a.b(getPageContext(), getUniqueId());
        this.cAV.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.cAP == null) {
            if (i < 0) {
                this.cAP = new com.baidu.tbadk.e.f(getActivity());
            } else {
                this.cAP = new com.baidu.tbadk.e.f(getActivity(), i);
            }
            this.cAP.tf();
        }
        this.cAP.b(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(View view) {
        if (this.cAP != null) {
            this.cAP.u(view);
            this.cAP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new f(this));
        }
        this.refreshView.eo(getResources().getDimensionPixelSize(i.d.ds160));
        this.refreshView.fq(str);
        this.refreshView.b(view, z);
        this.refreshView.CK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anv() {
        if (this.refreshView != null) {
            this.refreshView.u(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cAU != null) {
            this.cAU.onChangeSkinType(i);
        }
    }
}
