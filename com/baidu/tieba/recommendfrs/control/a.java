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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.recommendfrs.control.a.m;
import com.baidu.tieba.recommendfrs.control.a.q;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private com.baidu.tbadk.f.f cFK;
    private ScrollFragmentTabHost dVM;
    private m dVN;
    private CustomMessageTask dVO;
    private boolean dVP = false;
    private CustomMessageListener dVQ = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener dVR = new c(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private Boolean dVS = null;
    private com.baidu.tieba.recommendfrs.b dVT = new d(this);
    private com.baidu.tieba.recommendfrs.c dVU = new e(this);
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
        TbadkCoreApplication.m411getInst().setEnterRecommendFrs(true);
        q.aMe().dWA = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.dVM != null) {
                if (this.dVM.aoi()) {
                    this.dVM.aLK();
                    a(getView(), false, getResources().getDimensionPixelSize(t.e.ds360));
                } else {
                    this.dVM.setItemForeGround(this.dVM.getCurrentItem());
                }
            }
            com.baidu.tieba.recommendfrs.control.a.t.oA(0);
            return;
        }
        VoiceManager aP = com.baidu.tieba.tbadkCore.voice.b.aP(getActivity());
        if (aP != null) {
            aP.stopPlay();
        }
        ib(true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ako();
        this.dVM = (ScrollFragmentTabHost) getView().findViewById(t.g.recommend_frs_tab_host);
        this.dVM.setPageUniqueId(getUniqueId());
        this.dVM.a(this.dVT, this.dVU);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        com.baidu.tieba.recommendfrs.a.aLJ().setCreateTime(System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aLJ().ot(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dVP = true;
        com.baidu.tieba.recommendfrs.a.aLJ().q(System.currentTimeMillis(), 1);
        registerListener(this.dVQ);
        registerListener(this.dVR);
        alu();
        aMc();
    }

    private void aMc() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new f(this));
        aVar.Fw();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dVM.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        q.aMe().onDestory();
    }

    private void alu() {
        this.dVO = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new g(this));
        this.dVO.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.dVO);
    }

    private void ako() {
        q.aMe().o(getUniqueId());
        this.dVN = new m(getPageContext(), getUniqueId());
        this.dVN.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(List<TagInfo> list) {
        if (y.p(list) > 0 && this.dVM != null && !this.dVM.cl(list)) {
            this.dVM.bw(list);
            if (q.aMe().dWz != 0) {
                com.baidu.tieba.recommendfrs.control.a.t.oz(q.aMe().dWz);
            }
            this.dVM.setCurrentTab(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.cFK == null) {
            if (i < 0) {
                this.cFK = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cFK = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cFK.uA();
        }
        this.cFK.c(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aD(View view) {
        if (this.cFK != null) {
            this.cFK.K(view);
            this.cFK = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new i(this));
        }
        this.refreshView.eV(getResources().getDimensionPixelSize(t.e.ds160));
        this.refreshView.fU(str);
        this.refreshView.c(view, z);
        this.refreshView.Fh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XY() {
        if (this.refreshView != null) {
            this.refreshView.K(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dVM != null) {
            this.dVM.onChangeSkinType(i);
        }
        if (this.refreshView != null) {
            this.refreshView.uA();
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
        ib(isPrimary() && !this.dVP);
        this.dVP = false;
    }

    private void ib(boolean z) {
        this.dVM.ib(z);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.dVS == null) {
            this.dVS = Boolean.valueOf(com.baidu.tbadk.core.l.qE().qK());
        } else {
            z = this.dVS.booleanValue() ^ com.baidu.tbadk.core.l.qE().qK();
            this.dVS = Boolean.valueOf(com.baidu.tbadk.core.l.qE().qK());
        }
        if (z) {
            this.dVM.aMx();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public com.baidu.tbadk.pageStayDuration.b getPageStayFilter() {
        return new j(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        if (this.dVM == null || this.dVP) {
            return null;
        }
        return this.dVM.getCurrentPageKey();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.pageStayDuration.a
    public List<String> getNextPageSourceKeyList() {
        if (this.dVM != null) {
            return this.dVM.getNextPageSourceKeyList();
        }
        return null;
    }
}
