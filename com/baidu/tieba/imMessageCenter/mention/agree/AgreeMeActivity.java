package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b jFU;
    private a jFV;
    private int mSkinType = 3;
    private a.InterfaceC0728a jFW = new a.InterfaceC0728a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0728a
        public void cat() {
            if (AgreeMeActivity.this.jFU != null) {
                AgreeMeActivity.this.jFU.bFD();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0728a
        public void cpa() {
            if (AgreeMeActivity.this.jFU != null) {
                AgreeMeActivity.this.jFU.cpa();
            }
        }
    };
    private b.a jFX = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void au(ArrayList<q> arrayList) {
            if (AgreeMeActivity.this.jFV != null) {
                AgreeMeActivity.this.jFV.c(AgreeMeActivity.this.jFU.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.jFV.bGn());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.jFV.getRootView());
                if (AgreeMeActivity.this.jFV.fGi != null) {
                    AgreeMeActivity.this.jFV.fGi.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void onFailed(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.bnV().pC(0);
            if (AgreeMeActivity.this.jFV != null) {
                AgreeMeActivity.this.jFV.rh(false);
                if (y.isEmpty(AgreeMeActivity.this.jFV.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.jFV.bGn());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.jFV.getRootView(), AgreeMeActivity.this.getResources().getString(R.string.refresh_view_title_text), null, AgreeMeActivity.this.getResources().getString(R.string.refresh_view_button_text), true, AgreeMeActivity.this.getNetRefreshListener());
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.jFV.fGi != null) {
                        AgreeMeActivity.this.jFV.fGi.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.jFV.bGn());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private ab jFQ = new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) qVar;
                if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jGh) {
                    AgreeMeActivity.this.a(aVar);
                } else {
                    AgreeMeActivity.this.e(aVar);
                }
                if (aVar.cKa() != null) {
                    aq ai = new aq(aVar.cKa()).ai("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jGi) {
                        ai.ai("obj_type", 2);
                    } else {
                        ai.ai("obj_type", 1);
                    }
                    TiebaStatic.log(ai);
                }
                if (aVar != null) {
                    aq aqVar = new aq("c13784");
                    aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                    aqVar.dD("tid", aVar.getThread_id());
                    aqVar.dD("fname", aVar.getFname());
                    aqVar.ai("obj_type", 2);
                    TiebaStatic.log(aqVar);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.agree_me_activity, (ViewGroup) null);
        setContentView(inflate);
        this.jFV = new a(getPageContext(), inflate);
        this.jFV.a(this.jFW);
        this.jFV.e(this.jFQ);
        this.jFU = new b(getPageContext(), this.jFX);
        showLoadingView(this.jFV.bGn());
        this.jFV.rh(false);
        this.jFU.cwa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jFV != null) {
            this.jFV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.jFV != null) {
                this.jFV.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jFU != null) {
            this.jFU.bFD();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.jFU != null && this.jFV != null) {
            hideNetRefreshView(this.jFV.getRootView());
            showLoadingView(this.jFV.bGn(), true);
            this.jFU.cwa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            if (ay.a(aVar.getBaijiahaoData())) {
                PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.getThread_id(), (String) null, 1, "mention");
                createNormalCfg.setStartFrom(12);
                createNormalCfg.setHighLightPostId(aVar.getPost_id());
                createNormalCfg.setBjhData(aVar.getBaijiahaoData());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
                return;
            }
            PbActivityConfig createNormalCfg2 = new PbActivityConfig(this).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg2.setStartFrom(12);
            createNormalCfg2.setHighLightPostId(aVar.getPost_id());
            createNormalCfg2.setBjhData(aVar.getBaijiahaoData());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            String thread_id = aVar.getThread_id();
            String post_id = aVar.getPost_id();
            String userName = aVar.getReplyer() == null ? "" : aVar.getReplyer().getUserName();
            if (TextUtils.isEmpty(aVar.cJZ()) || "0".equals(aVar.cJZ())) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0);
                createSubPbActivityConfig.setKeyPageStartFrom(13);
                createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
                createSubPbActivityConfig.setHighLightPostId(post_id);
                createSubPbActivityConfig.setKeyOriUgcTopPid("0");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, aVar.cJZ(), "mention", false, userName, false, aVar.cJZ(), 0);
            createSubPbActivityConfig2.setKeyPageStartFrom(13);
            createSubPbActivityConfig2.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig2.setHighLightPostId(post_id);
            createSubPbActivityConfig2.setKeyOriUgcTopPid(post_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig2));
        }
    }
}
