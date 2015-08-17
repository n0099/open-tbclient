package com.baidu.tieba.recommendfrs.control;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.c.h;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.i;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private ScrollFragmentTabHost csC;
    private com.baidu.tieba.recommendfrs.control.a.b csD;
    private CustomMessageTask csF;
    private com.baidu.tbadk.c.f csw;
    private h refreshView;
    private List<String> csE = new ArrayList();
    private CustomMessageListener csG = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private com.baidu.tieba.recommendfrs.a csH = new c(this);

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(i.g.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m411getInst().setEnterRecommendFrs(true);
        if (this.csE == null || this.csE.size() <= 0) {
            this.csD.jR("头条");
            a(getView(), false, getResources().getDimensionPixelSize(i.d.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        HQ();
        this.csC = (ScrollFragmentTabHost) getView().findViewById(i.f.recommend_frs_tab_host);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.csG);
        ajq();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
    }

    private void ajq() {
        this.csF = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new d(this));
        this.csF.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.csF);
    }

    private void HQ() {
        this.csD = new com.baidu.tieba.recommendfrs.control.a.b(getPageContext(), getUniqueId());
        this.csD.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.csw == null) {
            if (i < 0) {
                this.csw = new com.baidu.tbadk.c.f(getActivity());
            } else {
                this.csw = new com.baidu.tbadk.c.f(getActivity(), i);
            }
            this.csw.ta();
        }
        this.csw.b(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void af(View view) {
        if (this.csw != null) {
            this.csw.u(view);
            this.csw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new f(this));
        }
        this.refreshView.eg(getResources().getDimensionPixelSize(i.d.ds160));
        this.refreshView.fi(str);
        this.refreshView.b(view, z);
        this.refreshView.Cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajr() {
        if (this.refreshView != null) {
            this.refreshView.u(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.csC != null) {
            this.csC.onChangeSkinType(i);
        }
    }
}
