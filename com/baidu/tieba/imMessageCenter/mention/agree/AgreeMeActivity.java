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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b eEE;
    private a eEF;
    private int mSkinType = 3;
    private a.InterfaceC0187a eEG = new a.InterfaceC0187a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0187a
        public void aOn() {
            if (AgreeMeActivity.this.eEE != null) {
                AgreeMeActivity.this.eEE.Tf();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0187a
        public void aOm() {
            if (AgreeMeActivity.this.eEE != null) {
                AgreeMeActivity.this.eEE.aOm();
            }
        }
    };
    private b.a eEH = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eEF != null) {
                AgreeMeActivity.this.eEF.c(AgreeMeActivity.this.eEE.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eEF.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eEF.getRootView());
                if (AgreeMeActivity.this.eEF.bxI != null) {
                    AgreeMeActivity.this.eEF.bxI.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void mc(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.Dp().dW(0);
            if (AgreeMeActivity.this.eEF != null) {
                AgreeMeActivity.this.eEF.ie(false);
                if (w.A(AgreeMeActivity.this.eEF.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eEF.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eEF.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eEF.bxI != null) {
                        AgreeMeActivity.this.eEF.bxI.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eEF.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eEC = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aOs() != null) {
                    an r = new an(aVar.aOs()).r("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eET) {
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
        this.eEF = new a(getPageContext(), inflate);
        this.eEF.a(this.eEG);
        this.eEF.d(this.eEC);
        this.eEE = new b(getPageContext(), this.eEH);
        showLoadingView(this.eEF.getRootView());
        this.eEF.ie(false);
        this.eEE.aCz();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eEF != null) {
            this.eEF.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eEF != null) {
                this.eEF.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eEE != null) {
            this.eEE.Tf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jD() && this.eEE != null && this.eEF != null) {
            hideNetRefreshView(this.eEF.getRootView());
            showLoadingView(this.eEF.getRootView(), true);
            this.eEE.aCz();
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
