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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b iQp;
    private a iQq;
    private int mSkinType = 3;
    private a.InterfaceC0651a iQr = new a.InterfaceC0651a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0651a
        public void bJP() {
            if (AgreeMeActivity.this.iQp != null) {
                AgreeMeActivity.this.iQp.bqv();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0651a
        public void bXI() {
            if (AgreeMeActivity.this.iQp != null) {
                AgreeMeActivity.this.iQp.bXI();
            }
        }
    };
    private b.a iQs = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void an(ArrayList<o> arrayList) {
            if (AgreeMeActivity.this.iQq != null) {
                AgreeMeActivity.this.iQq.c(AgreeMeActivity.this.iQp.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.iQq.brg());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.iQq.getRootView());
                if (AgreeMeActivity.this.iQq.fej != null) {
                    AgreeMeActivity.this.iQq.fej.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void onFailed(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.aZl().mE(0);
            if (AgreeMeActivity.this.iQq != null) {
                AgreeMeActivity.this.iQq.pO(false);
                if (v.isEmpty(AgreeMeActivity.this.iQq.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.iQq.brg());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.iQq.getRootView(), AgreeMeActivity.this.getResources().getString(R.string.refresh_view_title_text), null, AgreeMeActivity.this.getResources().getString(R.string.refresh_view_button_text), true, AgreeMeActivity.this.getNetRefreshListener());
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.iQq.fej != null) {
                        AgreeMeActivity.this.iQq.fej.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.iQq.brg());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private x iQn = new x() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.x
        public void a(View view, o oVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (oVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) oVar;
                if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.iQC) {
                    AgreeMeActivity.this.a(aVar);
                } else {
                    AgreeMeActivity.this.e(aVar);
                }
                if (aVar.crl() != null) {
                    an ag = new an(aVar.crl()).ag("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.iQD) {
                        ag.ag("obj_type", 2);
                    } else {
                        ag.ag("obj_type", 1);
                    }
                    TiebaStatic.log(ag);
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
        this.iQq = new a(getPageContext(), inflate);
        this.iQq.a(this.iQr);
        this.iQq.e(this.iQn);
        this.iQp = new b(getPageContext(), this.iQs);
        showLoadingView(this.iQq.brg());
        this.iQq.pO(false);
        this.iQp.cem();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iQq != null) {
            this.iQq.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.iQq != null) {
                this.iQq.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.iQp != null) {
            this.iQp.bqv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.iQp != null && this.iQq != null) {
            hideNetRefreshView(this.iQq.getRootView());
            showLoadingView(this.iQq.brg(), true);
            this.iQp.cem();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            if (au.a(aVar.getBaijiahaoData())) {
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
            if (TextUtils.isEmpty(aVar.crk()) || "0".equals(aVar.crk())) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0);
                createSubPbActivityConfig.setKeyPageStartFrom(13);
                createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
                createSubPbActivityConfig.setHighLightPostId(post_id);
                createSubPbActivityConfig.setKeyOriUgcTopPid("0");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, aVar.crk(), "mention", false, userName, false, aVar.crk(), 0);
            createSubPbActivityConfig2.setKeyPageStartFrom(13);
            createSubPbActivityConfig2.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig2.setHighLightPostId(post_id);
            createSubPbActivityConfig2.setKeyOriUgcTopPid(post_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig2));
        }
    }
}
