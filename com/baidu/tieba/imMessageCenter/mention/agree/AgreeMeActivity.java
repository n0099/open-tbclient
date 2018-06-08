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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b eAO;
    private a eAP;
    private int mSkinType = 3;
    private a.InterfaceC0185a eAQ = new a.InterfaceC0185a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0185a
        public void aNH() {
            if (AgreeMeActivity.this.eAO != null) {
                AgreeMeActivity.this.eAO.SJ();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0185a
        public void aNG() {
            if (AgreeMeActivity.this.eAO != null) {
                AgreeMeActivity.this.eAO.aNG();
            }
        }
    };
    private b.a eAR = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void I(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eAP != null) {
                AgreeMeActivity.this.eAP.c(AgreeMeActivity.this.eAO.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eAP.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eAP.getRootView());
                if (AgreeMeActivity.this.eAP.bwm != null) {
                    AgreeMeActivity.this.eAP.bwm.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void mg(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.CX().dV(0);
            if (AgreeMeActivity.this.eAP != null) {
                AgreeMeActivity.this.eAP.hU(false);
                if (w.z(AgreeMeActivity.this.eAP.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eAP.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eAP.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eAP.bwm != null) {
                        AgreeMeActivity.this.eAP.bwm.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eAP.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eAM = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aNM() != null) {
                    am r = new am(aVar.aNM()).r("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eBd) {
                        r.r("obj_type", 2);
                    } else {
                        r.r("obj_type", 1);
                    }
                    TiebaStatic.log(r);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(d.i.agree_me_activity, (ViewGroup) null);
        setContentView(inflate);
        this.eAP = new a(getPageContext(), inflate);
        this.eAP.a(this.eAQ);
        this.eAP.d(this.eAM);
        this.eAO = new b(getPageContext(), this.eAR);
        showLoadingView(this.eAP.getRootView());
        this.eAP.hU(false);
        this.eAO.aBT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eAP != null) {
            this.eAP.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eAP != null) {
                this.eAP.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eAO != null) {
            this.eAO.SJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jD() && this.eAO != null && this.eAP != null) {
            hideNetRefreshView(this.eAP.getRootView());
            showLoadingView(this.eAP.getRootView(), true);
            this.eAO.aBT();
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
