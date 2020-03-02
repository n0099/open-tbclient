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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
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
    private b hPW;
    private a hPX;
    private int mSkinType = 3;
    private a.InterfaceC0542a hPY = new a.InterfaceC0542a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0542a
        public void btI() {
            if (AgreeMeActivity.this.hPW != null) {
                AgreeMeActivity.this.hPW.bcf();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0542a
        public void bGz() {
            if (AgreeMeActivity.this.hPW != null) {
                AgreeMeActivity.this.hPW.bGz();
            }
        }
    };
    private b.a hPZ = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void al(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.hPX != null) {
                AgreeMeActivity.this.hPX.c(AgreeMeActivity.this.hPW.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.hPX.bcO());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.hPX.getRootView());
                if (AgreeMeActivity.this.hPX.ent != null) {
                    AgreeMeActivity.this.hPX.ent.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void onFailed(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.aKE().lN(0);
            if (AgreeMeActivity.this.hPX != null) {
                AgreeMeActivity.this.hPX.oi(false);
                if (v.isEmpty(AgreeMeActivity.this.hPX.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.hPX.bcO());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.hPX.getRootView(), AgreeMeActivity.this.getResources().getString(R.string.refresh_view_title_text), null, AgreeMeActivity.this.getResources().getString(R.string.refresh_view_button_text), true, AgreeMeActivity.this.getNetRefreshListener());
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.hPX.ent != null) {
                        AgreeMeActivity.this.hPX.ent.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.hPX.bcO());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s hPU = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hQj) {
                    AgreeMeActivity.this.a(aVar);
                } else {
                    AgreeMeActivity.this.e(aVar);
                }
                if (aVar.bZT() != null) {
                    an X = new an(aVar.bZT()).X("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.hQk) {
                        X.X("obj_type", 2);
                    } else {
                        X.X("obj_type", 1);
                    }
                    TiebaStatic.log(X);
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
        this.hPX = new a(getPageContext(), inflate);
        this.hPX.a(this.hPY);
        this.hPX.e(this.hPU);
        this.hPW = new b(getPageContext(), this.hPZ);
        showLoadingView(this.hPX.bcO());
        this.hPX.oi(false);
        this.hPW.bMZ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hPX != null) {
            this.hPX.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.hPX != null) {
                this.hPX.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.hPW != null) {
            this.hPW.bcf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.hPW != null && this.hPX != null) {
            hideNetRefreshView(this.hPX.getRootView());
            showLoadingView(this.hPX.bcO(), true);
            this.hPW.bMZ();
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
            if (TextUtils.isEmpty(aVar.bZS()) || "0".equals(aVar.bZS())) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0);
                createSubPbActivityConfig.setKeyPageStartFrom(13);
                createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
                createSubPbActivityConfig.setHighLightPostId(post_id);
                createSubPbActivityConfig.setKeyOriUgcTopPid("0");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, aVar.bZS(), "mention", false, userName, false, aVar.bZS(), 0);
            createSubPbActivityConfig2.setKeyPageStartFrom(13);
            createSubPbActivityConfig2.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig2.setHighLightPostId(post_id);
            createSubPbActivityConfig2.setKeyOriUgcTopPid(post_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig2));
        }
    }
}
