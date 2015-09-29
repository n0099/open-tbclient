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
    private com.baidu.tbadk.e.f cHR;
    private ScrollFragmentTabHost cHW;
    private com.baidu.tieba.recommendfrs.control.a.b cHX;
    private CustomMessageTask cHZ;
    private h refreshView;
    private List<String> cHY = new ArrayList();
    private CustomMessageListener cIa = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private com.baidu.tieba.recommendfrs.a cIb = new c(this);

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
        if (this.cHY == null || this.cHY.size() <= 0) {
            this.cHX.kU("头条");
            a(getView(), false, getResources().getDimensionPixelSize(i.d.ds360));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Hy();
        this.cHW = (ScrollFragmentTabHost) getView().findViewById(i.f.recommend_frs_tab_host);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.cIa);
        apM();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
    }

    private void apM() {
        this.cHZ = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new d(this));
        this.cHZ.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.cHZ);
    }

    private void Hy() {
        this.cHX = new com.baidu.tieba.recommendfrs.control.a.b(getPageContext(), getUniqueId());
        this.cHX.a(new e(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.cHR == null) {
            if (i < 0) {
                this.cHR = new com.baidu.tbadk.e.f(getActivity());
            } else {
                this.cHR = new com.baidu.tbadk.e.f(getActivity(), i);
            }
            this.cHR.tc();
        }
        this.cHR.b(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(View view) {
        if (this.cHR != null) {
            this.cHR.u(view);
            this.cHR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new h(getPageContext().getPageActivity(), new f(this));
        }
        this.refreshView.ep(getResources().getDimensionPixelSize(i.d.ds160));
        this.refreshView.fv(str);
        this.refreshView.b(view, z);
        this.refreshView.Cw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apN() {
        if (this.refreshView != null) {
            this.refreshView.u(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.cHW != null) {
            this.cHW.onChangeSkinType(i);
        }
    }
}
