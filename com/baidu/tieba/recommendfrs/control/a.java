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
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.n;
import com.baidu.tieba.recommendfrs.control.a.j;
import com.baidu.tieba.recommendfrs.indicator.ScrollFragmentTabHost;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class a extends BaseFragment {
    private com.baidu.tbadk.f.f cWx;
    private ScrollFragmentTabHost doG;
    private j doH;
    private CustomMessageTask doI;
    private CustomMessageListener doJ = new b(this, CmdConfigCustom.CMD_RECOMMEMD_FRS_SWITCH_TAB);
    private CustomMessageListener doK = new c(this, CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK);
    private com.baidu.tieba.recommendfrs.a doL = new d(this);
    private com.baidu.tieba.recommendfrs.b doM = new e(this);
    private com.baidu.tbadk.f.h refreshView;

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(n.h.recommend_frs_control, (ViewGroup) null);
        inflate.setDrawingCacheEnabled(false);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        TbadkCoreApplication.m411getInst().setEnterRecommendFrs(true);
        if (isPrimary()) {
            TiebaStatic.eventStat(getPageContext().getPageActivity(), "c10702", "click");
            if (this.doG != null) {
                if (this.doG.ayE()) {
                    this.doG.axX();
                    a(getView(), false, getResources().getDimensionPixelSize(n.e.ds360));
                    return;
                } else if (this.doG.getCurrentItem() == 0) {
                    this.doG.setItemForeGround(0);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        VoiceManager aT = com.baidu.tieba.tbadkCore.voice.b.aT(getActivity());
        if (aT != null) {
            aT.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Jb();
        this.doG = (ScrollFragmentTabHost) getView().findViewById(n.g.recommend_frs_tab_host);
        this.doG.setPageUniqueId(getUniqueId());
        this.doG.a(this.doL, this.doM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.doJ);
        registerListener(this.doK);
        aeR();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.doG.onDestroy();
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED);
    }

    private void aeR() {
        this.doI = new CustomMessageTask(CmdConfigCustom.CMD_RECOMMEND_FRS_BACK_PRESSED, new f(this));
        this.doI.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.doI);
    }

    private void Jb() {
        this.doH = new j(getPageContext(), getUniqueId());
        this.doH.a(new g(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bE(List<TagInfo> list) {
        if (y.l(list) > 0 && this.doG != null) {
            this.doG.bH(list);
            this.doG.setCurrentTab(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, boolean z, int i) {
        if (this.cWx == null) {
            if (i < 0) {
                this.cWx = new com.baidu.tbadk.f.f(getActivity());
            } else {
                this.cWx = new com.baidu.tbadk.f.f(getActivity(), i);
            }
            this.cWx.tr();
        }
        this.cWx.b(view, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(View view) {
        if (this.cWx != null) {
            this.cWx.u(view);
            this.cWx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetRefreshView(View view, String str, boolean z) {
        if (this.refreshView == null) {
            this.refreshView = new com.baidu.tbadk.f.h(getPageContext().getPageActivity(), new h(this));
        }
        this.refreshView.ev(getResources().getDimensionPixelSize(n.e.ds160));
        this.refreshView.fP(str);
        this.refreshView.b(view, z);
        this.refreshView.Dc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        if (this.refreshView != null) {
            this.refreshView.u(getView());
            this.refreshView = null;
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.doG != null) {
            this.doG.onChangeSkinType(i);
        }
    }
}
