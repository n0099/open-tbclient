package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b gXh;
    private a gXi;
    private int mSkinType = 3;
    private a.InterfaceC0449a gXj = new a.InterfaceC0449a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0449a
        public void aYY() {
            if (AgreeMeActivity.this.gXh != null) {
                AgreeMeActivity.this.gXh.aIW();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0449a
        public void bmA() {
            if (AgreeMeActivity.this.gXh != null) {
                AgreeMeActivity.this.gXh.bmA();
            }
        }
    };
    private b.a gXk = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void aa(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.gXi != null) {
                AgreeMeActivity.this.gXi.c(AgreeMeActivity.this.gXh.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gXi.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.gXi.getRootView());
                if (AgreeMeActivity.this.gXi.dyk != null) {
                    AgreeMeActivity.this.gXi.dyk.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void onFailed(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.aqt().jk(0);
            if (AgreeMeActivity.this.gXi != null) {
                AgreeMeActivity.this.gXi.mH(false);
                if (v.isEmpty(AgreeMeActivity.this.gXi.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gXi.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.gXi.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.gXi.dyk != null) {
                        AgreeMeActivity.this.gXi.dyk.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gXi.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s gXf = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.bFW() != null) {
                    an O = new an(aVar.bFW()).O("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gXw) {
                        O.O("obj_type", 2);
                    } else {
                        O.O("obj_type", 1);
                    }
                    TiebaStatic.log(O);
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
        this.gXi = new a(getPageContext(), inflate);
        this.gXi.a(this.gXj);
        this.gXi.e(this.gXf);
        this.gXh = new b(getPageContext(), this.gXk);
        showLoadingView(this.gXi.getRootView());
        this.gXi.mH(false);
        this.gXh.bsV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gXi != null) {
            this.gXi.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gXi != null) {
                this.gXi.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gXh != null) {
            this.gXh.aIW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetWorkAvailable() && this.gXh != null && this.gXi != null) {
            hideNetRefreshView(this.gXi.getRootView());
            showLoadingView(this.gXi.getRootView(), true);
            this.gXh.bsV();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg));
        }
    }
}
