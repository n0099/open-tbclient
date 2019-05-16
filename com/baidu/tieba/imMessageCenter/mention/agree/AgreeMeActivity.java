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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b gQf;
    private a gQg;
    private int mSkinType = 3;
    private a.InterfaceC0344a gQh = new a.InterfaceC0344a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0344a
        public void aWp() {
            if (AgreeMeActivity.this.gQf != null) {
                AgreeMeActivity.this.gQf.aHq();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0344a
        public void bmt() {
            if (AgreeMeActivity.this.gQf != null) {
                AgreeMeActivity.this.gQf.bmt();
            }
        }
    };
    private b.a gQi = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void V(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.gQg != null) {
                AgreeMeActivity.this.gQg.c(AgreeMeActivity.this.gQf.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gQg.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.gQg.getRootView());
                if (AgreeMeActivity.this.gQg.dnh != null) {
                    AgreeMeActivity.this.gQg.dnh.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void vY(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.amy().jp(0);
            if (AgreeMeActivity.this.gQg != null) {
                AgreeMeActivity.this.gQg.mB(false);
                if (v.aa(AgreeMeActivity.this.gQg.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gQg.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.gQg.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.gQg.dnh != null) {
                        AgreeMeActivity.this.gQg.dnh.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gQg.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s gQd = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.bFz() != null) {
                    am P = new am(aVar.bFz()).P("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gQu) {
                        P.P("obj_type", 2);
                    } else {
                        P.P("obj_type", 1);
                    }
                    TiebaStatic.log(P);
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
        this.gQg = new a(getPageContext(), inflate);
        this.gQg.a(this.gQh);
        this.gQg.d(this.gQd);
        this.gQf = new b(getPageContext(), this.gQi);
        showLoadingView(this.gQg.getRootView());
        this.gQg.mB(false);
        this.gQf.bsJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gQg != null) {
            this.gQg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gQg != null) {
                this.gQg.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gQf != null) {
            this.gQf.aHq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jS() && this.gQf != null && this.gQg != null) {
            hideNetRefreshView(this.gQg.getRootView());
            showLoadingView(this.gQg.getRootView(), true);
            this.gQf.bsJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
