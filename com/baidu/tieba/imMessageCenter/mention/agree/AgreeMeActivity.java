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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes22.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b kKb;
    private a kKc;
    private int mSkinType = 3;
    private a.InterfaceC0791a kKd = new a.InterfaceC0791a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0791a
        public void cqB() {
            if (AgreeMeActivity.this.kKb != null) {
                AgreeMeActivity.this.kKb.bRN();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0791a
        public void cFn() {
            if (AgreeMeActivity.this.kKb != null) {
                AgreeMeActivity.this.kKb.cFn();
            }
        }
    };
    private b.a kKe = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void az(ArrayList<q> arrayList) {
            if (AgreeMeActivity.this.kKc != null) {
                AgreeMeActivity.this.kKc.c(AgreeMeActivity.this.kKb.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.kKc.bSx());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.kKc.getRootView());
                if (AgreeMeActivity.this.kKc.gtA != null) {
                    AgreeMeActivity.this.kKc.gtA.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void onFailed(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.byI().rH(0);
            if (AgreeMeActivity.this.kKc != null) {
                AgreeMeActivity.this.kKc.td(false);
                if (y.isEmpty(AgreeMeActivity.this.kKc.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.kKc.bSx());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.kKc.getRootView(), AgreeMeActivity.this.getResources().getString(R.string.refresh_view_title_text), null, AgreeMeActivity.this.getResources().getString(R.string.refresh_view_button_text), true, AgreeMeActivity.this.getNetRefreshListener());
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.kKc.gtA != null) {
                        AgreeMeActivity.this.kKc.gtA.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.kKc.bSx());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private ab kJX = new ab() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.ab
        public void a(View view, q qVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (qVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) qVar;
                if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kKo) {
                    AgreeMeActivity.this.a(aVar);
                } else {
                    AgreeMeActivity.this.e(aVar);
                }
                if (aVar.dbR() != null) {
                    ar al = new ar(aVar.dbR()).al("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.kKp) {
                        al.al("obj_type", 2);
                    } else {
                        al.al("obj_type", 1);
                    }
                    TiebaStatic.log(al);
                }
                if (aVar != null) {
                    ar arVar = new ar("c13784");
                    arVar.w("uid", TbadkApplication.getCurrentAccountId());
                    arVar.dY("tid", aVar.getThread_id());
                    arVar.dY("fname", aVar.getFname());
                    arVar.al("obj_type", 2);
                    TiebaStatic.log(arVar);
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
        this.kKc = new a(getPageContext(), inflate);
        this.kKc.a(this.kKd);
        this.kKc.e(this.kJX);
        this.kKb = new b(getPageContext(), this.kKe);
        showLoadingView(this.kKc.bSx());
        this.kKc.td(false);
        this.kKb.cNv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.kKc != null) {
            this.kKc.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.kKc != null) {
                this.kKc.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.kKb != null) {
            this.kKb.bRN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.kKb != null && this.kKc != null) {
            hideNetRefreshView(this.kKc.getRootView());
            showLoadingView(this.kKc.bSx(), true);
            this.kKb.cNv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            if (az.a(aVar.getBaijiahaoData())) {
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
            if (TextUtils.isEmpty(aVar.dbQ()) || "0".equals(aVar.dbQ())) {
                SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, post_id, "mention", false, userName, false, post_id, 0);
                createSubPbActivityConfig.setKeyPageStartFrom(13);
                createSubPbActivityConfig.setBjhData(aVar.getBaijiahaoData());
                createSubPbActivityConfig.setHighLightPostId(post_id);
                createSubPbActivityConfig.setKeyOriUgcTopPid("0");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig));
                return;
            }
            SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(thread_id, aVar.dbQ(), "mention", false, userName, false, aVar.dbQ(), 0);
            createSubPbActivityConfig2.setKeyPageStartFrom(13);
            createSubPbActivityConfig2.setBjhData(aVar.getBaijiahaoData());
            createSubPbActivityConfig2.setHighLightPostId(post_id);
            createSubPbActivityConfig2.setKeyOriUgcTopPid(post_id);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, createSubPbActivityConfig2));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return "a079";
    }
}
