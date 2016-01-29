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
import com.baidu.tbadk.core.l;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.recommendfrs.control.a.n;
import com.baidu.tieba.recommendfrs.control.a.q;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.t;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private ScrollFragmentTabHost dDV;
    private com.baidu.tieba.recommendfrs.control.a.j dDW;
    private CustomMessageTask dDX;
    private CustomMessageListener dDY = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener dDZ = new c(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private Boolean dEa = null;
    private com.baidu.tieba.recommendfrs.b dEb = new d(this);
    private com.baidu.tieba.recommendfrs.c dEc = new e(this);
    private com.baidu.tbadk.f.f dig;
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
        n.aFn().dED = isPrimary();
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.dDV != null) {
                if (this.dDV.aFL()) {
                    this.dDV.aEV();
                    a(getView(), false, getResources().getDimensionPixelSize(t.e.ds360));
                } else {
                    this.dDV.setItemForeGround(this.dDV.getCurrentItem());
                }
            }
            q.nw(0);
            return;
        }
        VoiceManager aV = com.baidu.tieba.tbadkCore.voice.b.aV(getActivity());
        if (aV != null) {
            aV.stopPlay();
        }
        aFl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        agU();
        this.dDV = (ScrollFragmentTabHost) getView().findViewById(t.g.recommend_frs_tab_host);
        this.dDV.setPageUniqueId(getUniqueId());
        this.dDV.a(this.dEb, this.dEc);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        com.baidu.tieba.recommendfrs.a.aER().setCreateTime(System.currentTimeMillis() - com.baidu.tieba.recommendfrs.a.aER().nq(1));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.recommendfrs.a.aER().e(System.currentTimeMillis(), 1);
        registerListener(this.dDY);
        registerListener(this.dDZ);
        aia();
        aFk();
    }

    private void aFk() {
        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a(getPageContext());
        aVar.setUniqueId(getUniqueId());
        aVar.a(new f(this));
        aVar.EJ();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dDV.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
        n.aFn().onDestory();
    }

    private void aia() {
        this.dDX = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new g(this));
        this.dDX.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.dDX);
    }

    private void agU() {
        n.aFn().n(getUniqueId());
        this.dDW = new com.baidu.tieba.recommendfrs.control.a.j(getPageContext(), getUniqueId());
        this.dDW.a(new h(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(List<TagInfo> list) {
        if (x.o(list) > 0 && this.dDV != null) {
            this.dDV.bT(list);
            if (n.aFn().dEC != 0) {
                q.nv(n.aFn().dEC);
            }
            this.dDV.setCurrentTab(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.dig == null) {
            if (i < 0) {
                this.dig = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.dig = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.dig.uv();
        }
        this.dig.c(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aK(View view) {
        if (this.dig != null) {
            this.dig.H(view);
            this.dig = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new i(this));
        }
        this.refreshView.eP(getResources().getDimensionPixelSize(t.e.ds160));
        this.refreshView.fN(str);
        this.refreshView.c(view, z);
        this.refreshView.Eu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avv() {
        if (this.refreshView != null) {
            this.refreshView.H(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.dDV != null) {
            this.dDV.onChangeSkinType(i);
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
        aFl();
    }

    private void aFl() {
        this.dDV.aFl();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        boolean z = false;
        if (this.dEa == null) {
            this.dEa = Boolean.valueOf(l.rn().rt());
        } else {
            z = this.dEa.booleanValue() ^ l.rn().rt();
            this.dEa = Boolean.valueOf(l.rn().rt());
        }
        if (z) {
            this.dDV.aFH();
        }
    }
}
