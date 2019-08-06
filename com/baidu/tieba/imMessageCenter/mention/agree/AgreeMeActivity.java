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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b gXm;
    private a gXn;
    private int mSkinType = 3;
    private a.InterfaceC0349a gXo = new a.InterfaceC0349a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0349a
        public void aYq() {
            if (AgreeMeActivity.this.gXm != null) {
                AgreeMeActivity.this.gXm.aIS();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0349a
        public void boK() {
            if (AgreeMeActivity.this.gXm != null) {
                AgreeMeActivity.this.gXm.boK();
            }
        }
    };
    private b.a gXp = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void V(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.gXn != null) {
                AgreeMeActivity.this.gXn.c(AgreeMeActivity.this.gXm.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gXn.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.gXn.getRootView());
                if (AgreeMeActivity.this.gXn.dpp != null) {
                    AgreeMeActivity.this.gXn.dpp.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void wD(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.anF().jw(0);
            if (AgreeMeActivity.this.gXn != null) {
                AgreeMeActivity.this.gXn.mQ(false);
                if (v.aa(AgreeMeActivity.this.gXn.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gXn.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.gXn.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.gXn.dpp != null) {
                        AgreeMeActivity.this.gXn.dpp.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gXn.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s gXk = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.bIy() != null) {
                    an P = new an(aVar.bIy()).P("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gXB) {
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
        this.gXn = new a(getPageContext(), inflate);
        this.gXn.a(this.gXo);
        this.gXn.d(this.gXk);
        this.gXm = new b(getPageContext(), this.gXp);
        showLoadingView(this.gXn.getRootView());
        this.gXn.mQ(false);
        this.gXm.bvc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gXn != null) {
            this.gXn.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gXn != null) {
                this.gXn.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gXm != null) {
            this.gXm.aIS();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kc() && this.gXm != null && this.gXn != null) {
            hideNetRefreshView(this.gXn.getRootView());
            showLoadingView(this.gXn.getRootView(), true);
            this.gXm.bvc();
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
