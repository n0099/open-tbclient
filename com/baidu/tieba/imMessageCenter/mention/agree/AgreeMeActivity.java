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
    private b eYK;
    private a eYL;
    private int mSkinType = 3;
    private a.InterfaceC0248a eYM = new a.InterfaceC0248a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0248a
        public void aBy() {
            if (AgreeMeActivity.this.eYK != null) {
                AgreeMeActivity.this.eYK.YV();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0248a
        public void aBz() {
            if (AgreeMeActivity.this.eYK != null) {
                AgreeMeActivity.this.eYK.aBz();
            }
        }
    };
    private b.a eYN = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eYL != null) {
                AgreeMeActivity.this.eYL.c(AgreeMeActivity.this.eYK.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eYL.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eYL.getRootView());
                if (AgreeMeActivity.this.eYL.bNu != null) {
                    AgreeMeActivity.this.eYL.bNu.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void ni(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.GL().eH(0);
            if (AgreeMeActivity.this.eYL != null) {
                AgreeMeActivity.this.eYL.jg(false);
                if (v.I(AgreeMeActivity.this.eYL.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eYL.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eYL.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eYL.bNu != null) {
                        AgreeMeActivity.this.eYL.bNu.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eYL.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eYI = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aUn() != null) {
                    am x = new am(aVar.aUn()).x("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eYZ) {
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
        this.eYL = new a(getPageContext(), inflate);
        this.eYL.a(this.eYM);
        this.eYL.d(this.eYI);
        this.eYK = new b(getPageContext(), this.eYN);
        showLoadingView(this.eYL.getRootView());
        this.eYL.jg(false);
        this.eYK.aIh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eYL != null) {
            this.eYL.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eYL != null) {
                this.eYL.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eYK != null) {
            this.eYK.YV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kV() && this.eYK != null && this.eYL != null) {
            hideNetRefreshView(this.eYL.getRootView());
            showLoadingView(this.eYL.getRootView(), true);
            this.eYK.aIh();
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
