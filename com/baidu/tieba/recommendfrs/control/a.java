package com.baidu.tieba.recommendfrs.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private com.baidu.tbadk.f.f cFC;
    private ScrollFragmentTabHost dYN;
    private com.baidu.tieba.recommendfrs.control.a.m dYO;
    private CustomMessageTask dYP;
    private boolean dYQ = false;
    private CustomMessageListener dYR = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener dYS = new c(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private Boolean dYT = null;
    private com.baidu.tieba.recommendfrs.b dYU = new d(this);
    private com.baidu.tieba.recommendfrs.c dYV = new e(this);
    private com.baidu.tbadk.f.h refreshView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(t.h.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m11getInst().setEnterRecommendFrs(true);
        com.baidu.tieba.recommendfrs.control.a.q.aMp().dZK = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.dYN != null) {
                if (this.dYN.aol()) {
                    this.dYN.aLO();
                    n(false, getResources().getDimensionPixelSize(t.e.ds520));
                } else {
                    this.dYN.setItemForeGround(this.dYN.getCurrentItem());
                }
            }
            com.baidu.tieba.recommendfrs.control.a.t.os(0);
            return;
        }
        VoiceManager aV = com.baidu.tieba.tbadkCore.voice.b.aV(getActivity());
        if (aV != null) {
            aV.stopPlay();
        }
        iL(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        if (this.dYN != null) {
            this.dYN.switchNaviBarStatus(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        aku();
        this.dYN = (ScrollFragmentTabHost) getView().findViewById(t.g.recommend_frs_tab_host);
        this.dYN.setPageUniqueId(getUniqueId());
        this.dYN.a(this.dYU, this.dYV);
        this.dYN.switchNaviBarStatus(this.mIsLogin);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        com.baidu.tieba.recommendfrs.a.aLN().setCreateTime(System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aLN().oj(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dYQ = true;
        com.baidu.tieba.recommendfrs.a.aLN().r(System.currentTimeMillis(), 1);
        registerListener(this.dYR);
        registerListener(this.dYS);
        alC();
        aMi();
    }

    private void aMi() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new f(this));
        aVar.Do();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dYN.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        com.baidu.tieba.recommendfrs.control.a.q.aMp().onDestory();
    }

    private void alC() {
        this.dYP = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new g(this));
        this.dYP.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.dYP);
    }

    private void aku() {
        com.baidu.tieba.recommendfrs.control.a.q.aMp().o(getUniqueId());
        this.dYO = new com.baidu.tieba.recommendfrs.control.a.m(getPageContext(), getUniqueId());
        this.dYO.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(List<TagInfo> list) {
        if (com.baidu.tbadk.core.util.y.r(list) > 0 && this.dYN != null && !this.dYN.cn(list)) {
            this.dYN.bw(list);
            if (com.baidu.tieba.recommendfrs.control.a.q.aMp().dZJ != 0) {
                com.baidu.tieba.recommendfrs.control.a.t.or(com.baidu.tieba.recommendfrs.control.a.q.aMp().dZJ);
            }
            this.dYN.setCurrentTab(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(boolean z, int i) {
        if (this.cFC == null) {
            if (i < 0) {
                this.cFC = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cFC = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cFC.sf();
        }
        if (this.dYN != null && this.dYN.getContentContainer() != null) {
            this.cFC.c(this.dYN.getContentContainer(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aMj() {
        if (this.cFC != null && this.dYN != null && this.dYN.getContentContainer() != null) {
            this.cFC.L(this.dYN.getContentContainer());
            this.cFC = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new i(this));
        }
        this.refreshView.eB(getResources().getDimensionPixelSize(t.e.ds280));
        this.refreshView.fR(str);
        if (this.dYN != null && this.dYN.getContentContainer() != null) {
            this.refreshView.c(this.dYN.getContentContainer(), z);
        }
        this.refreshView.CZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pe() {
        if (this.refreshView != null && this.dYN != null && this.dYN.getContentContainer() != null) {
            this.refreshView.L(this.dYN.getContentContainer());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dYN != null) {
            this.dYN.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.sf();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, stringExtra));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        iL(isPrimary() && !this.dYQ);
        this.dYQ = false;
        if (this.dYN != null) {
            this.dYN.onPause();
        }
    }

    private void iL(boolean z) {
        this.dYN.iL(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.dYT == null) {
            this.dYT = Boolean.valueOf(com.baidu.tbadk.core.l.ob().oh());
        } else {
            z = this.dYT.booleanValue() ^ com.baidu.tbadk.core.l.ob().oh();
            this.dYT = Boolean.valueOf(com.baidu.tbadk.core.l.ob().oh());
        }
        if (z) {
            this.dYN.aMI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new j(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dYN == null || this.dYQ) {
            return null;
        }
        return this.dYN.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.dYN != null) {
            return this.dYN.getNextPageSourceKeyList();
        }
        return null;
    }
}
