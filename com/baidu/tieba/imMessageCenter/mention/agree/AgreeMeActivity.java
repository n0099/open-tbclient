package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b eXr;
    private a eXs;
    private int mSkinType = 3;
    private a.InterfaceC0222a eXt = new a.InterfaceC0222a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0222a
        public void aCa() {
            if (AgreeMeActivity.this.eXr != null) {
                AgreeMeActivity.this.eXr.YK();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0222a
        public void aCb() {
            if (AgreeMeActivity.this.eXr != null) {
                AgreeMeActivity.this.eXr.aCb();
            }
        }
    };
    private b.a eXu = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eXs != null) {
                AgreeMeActivity.this.eXs.c(AgreeMeActivity.this.eXr.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eXs.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eXs.getRootView());
                if (AgreeMeActivity.this.eXs.bMJ != null) {
                    AgreeMeActivity.this.eXs.bMJ.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void nh(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gz().et(0);
            if (AgreeMeActivity.this.eXs != null) {
                AgreeMeActivity.this.eXs.iX(false);
                if (v.J(AgreeMeActivity.this.eXs.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eXs.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eXs.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eXs.bMJ != null) {
                        AgreeMeActivity.this.eXs.bMJ.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eXs.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eXp = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aUQ() != null) {
                    am x = new am(aVar.aUQ()).x("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eXG) {
                        x.x("obj_type", 2);
                    } else {
                        x.x("obj_type", 1);
                    }
                    TiebaStatic.log(x);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(e.h.agree_me_activity, (ViewGroup) null);
        setContentView(inflate);
        this.eXs = new a(getPageContext(), inflate);
        this.eXs.a(this.eXt);
        this.eXs.d(this.eXp);
        this.eXr = new b(getPageContext(), this.eXu);
        showLoadingView(this.eXs.getRootView());
        this.eXs.iX(false);
        this.eXr.aIJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eXs != null) {
            this.eXs.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eXs != null) {
                this.eXs.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eXr != null) {
            this.eXr.YK();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kX() && this.eXr != null && this.eXs != null) {
            hideNetRefreshView(this.eXs.getRootView());
            showLoadingView(this.eXs.getRootView(), true);
            this.eXr.aIJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
