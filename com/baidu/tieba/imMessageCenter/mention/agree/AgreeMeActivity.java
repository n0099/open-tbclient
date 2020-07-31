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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes16.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b jqU;
    private a jqV;
    private int mSkinType = 3;
    private a.InterfaceC0676a jqW = new a.InterfaceC0676a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0676a
        public void bQi() {
            if (AgreeMeActivity.this.jqU != null) {
                AgreeMeActivity.this.jqU.bwE();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0676a
        public void cew() {
            if (AgreeMeActivity.this.jqU != null) {
                AgreeMeActivity.this.jqU.cew();
            }
        }
    };
    private b.a jqX = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void ao(ArrayList<q> arrayList) {
            if (AgreeMeActivity.this.jqV != null) {
                AgreeMeActivity.this.jqV.c(AgreeMeActivity.this.jqU.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.jqV.bxo());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.jqV.getRootView());
                if (AgreeMeActivity.this.jqV.fuP != null) {
                    AgreeMeActivity.this.jqV.fuP.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void onFailed(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.bfl().ns(0);
            if (AgreeMeActivity.this.jqV != null) {
                AgreeMeActivity.this.jqV.qB(false);
                if (x.isEmpty(AgreeMeActivity.this.jqV.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.jqV.bxo());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.jqV.getRootView(), AgreeMeActivity.this.getResources().getString(R.string.refresh_view_title_text), null, AgreeMeActivity.this.getResources().getString(R.string.refresh_view_button_text), true, AgreeMeActivity.this.getNetRefreshListener());
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.jqV.fuP != null) {
                        AgreeMeActivity.this.jqV.fuP.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.jqV.bxo());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private z jqQ = new z() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.z
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) qVar;
                if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jrh) {
                    AgreeMeActivity.this.a(aVar);
                } else {
                    AgreeMeActivity.this.e(aVar);
                }
                if (aVar.czj() != null) {
                    ap ah = new ap(aVar.czj()).ah("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.jri) {
                        ah.ah("obj_type", 2);
                    } else {
                        ah.ah("obj_type", 1);
                    }
                    TiebaStatic.log(ah);
                }
                if (aVar != null) {
                    ap apVar = new ap("c13784");
                    apVar.t("uid", TbadkApplication.getCurrentAccountId());
                    apVar.dn("tid", aVar.getThread_id());
                    apVar.dn("fname", aVar.getFname());
                    apVar.ah("obj_type", 2);
                    TiebaStatic.log(apVar);
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
        this.jqV = new a(getPageContext(), inflate);
        this.jqV.a(this.jqW);
        this.jqV.e(this.jqQ);
        this.jqU = new b(getPageContext(), this.jqX);
        showLoadingView(this.jqV.bxo());
        this.jqV.qB(false);
        this.jqU.clr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.jqV != null) {
            this.jqV.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.jqV != null) {
                this.jqV.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.jqU != null) {
            this.jqU.bwE();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.jqU != null && this.jqV != null) {
            hideNetRefreshView(this.jqV.getRootView());
            showLoadingView(this.jqV.bxo(), true);
            this.jqU.clr();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            if (ax.a(aVar.getBaijiahaoData())) {
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
            if (TextUtils.isEmpty(aVar.czi()) || "0".equals(aVar.czi())) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0);
                createSubPbActivityConfig.setKeyPageStartFrom(13);
                createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
                createSubPbActivityConfig.setHighLightPostId(post_id);
                createSubPbActivityConfig.setKeyOriUgcTopPid("0");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, aVar.czi(), "mention", false, userName, false, aVar.czi(), 0);
            createSubPbActivityConfig2.setKeyPageStartFrom(13);
            createSubPbActivityConfig2.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig2.setHighLightPostId(post_id);
            createSubPbActivityConfig2.setKeyOriUgcTopPid(post_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig2));
        }
    }
}
