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
/* loaded from: classes2.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b ePJ;
    private a ePK;
    private int mSkinType = 3;
    private a.InterfaceC0188a ePL = new a.InterfaceC0188a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0188a
        public void ayH() {
            if (AgreeMeActivity.this.ePJ != null) {
                AgreeMeActivity.this.ePJ.Vd();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0188a
        public void ayI() {
            if (AgreeMeActivity.this.ePJ != null) {
                AgreeMeActivity.this.ePJ.ayI();
            }
        }
    };
    private b.a ePM = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.ePK != null) {
                AgreeMeActivity.this.ePK.c(AgreeMeActivity.this.ePJ.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.ePK.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.ePK.getRootView());
                if (AgreeMeActivity.this.ePK.bEe != null) {
                    AgreeMeActivity.this.ePK.bEe.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void mF(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.Ey().ek(0);
            if (AgreeMeActivity.this.ePK != null) {
                AgreeMeActivity.this.ePK.iF(false);
                if (v.z(AgreeMeActivity.this.ePK.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.ePK.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.ePK.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.ePK.bEe != null) {
                        AgreeMeActivity.this.ePK.bEe.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.ePK.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n ePH = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aRC() != null) {
                    am w = new am(aVar.aRC()).w("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.ePY) {
                        w.w("obj_type", 2);
                    } else {
                        w.w("obj_type", 1);
                    }
                    TiebaStatic.log(w);
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
        this.ePK = new a(getPageContext(), inflate);
        this.ePK.a(this.ePL);
        this.ePK.d(this.ePH);
        this.ePJ = new b(getPageContext(), this.ePM);
        showLoadingView(this.ePK.getRootView());
        this.ePK.iF(false);
        this.ePJ.aFr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.ePK != null) {
            this.ePK.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.ePK != null) {
                this.ePK.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.ePJ != null) {
            this.ePJ.Vd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kK() && this.ePJ != null && this.ePK != null) {
            hideNetRefreshView(this.ePK.getRootView());
            showLoadingView(this.ePK.getRootView(), true);
            this.ePJ.aFr();
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
