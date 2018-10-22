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
    private b eXs;
    private a eXt;
    private int mSkinType = 3;
    private a.InterfaceC0222a eXu = new a.InterfaceC0222a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0222a
        public void aCb() {
            if (AgreeMeActivity.this.eXs != null) {
                AgreeMeActivity.this.eXs.YL();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0222a
        public void aCc() {
            if (AgreeMeActivity.this.eXs != null) {
                AgreeMeActivity.this.eXs.aCc();
            }
        }
    };
    private b.a eXv = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eXt != null) {
                AgreeMeActivity.this.eXt.c(AgreeMeActivity.this.eXs.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eXt.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eXt.getRootView());
                if (AgreeMeActivity.this.eXt.bMJ != null) {
                    AgreeMeActivity.this.eXt.bMJ.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void nh(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.Gz().et(0);
            if (AgreeMeActivity.this.eXt != null) {
                AgreeMeActivity.this.eXt.iX(false);
                if (v.J(AgreeMeActivity.this.eXt.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eXt.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eXt.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eXt.bMJ != null) {
                        AgreeMeActivity.this.eXt.bMJ.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eXt.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eXq = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aUQ() != null) {
                    am x = new am(aVar.aUQ()).x("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eXH) {
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
        this.eXt = new a(getPageContext(), inflate);
        this.eXt.a(this.eXu);
        this.eXt.d(this.eXq);
        this.eXs = new b(getPageContext(), this.eXv);
        showLoadingView(this.eXt.getRootView());
        this.eXt.iX(false);
        this.eXs.aIJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eXt != null) {
            this.eXt.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eXt != null) {
                this.eXt.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eXs != null) {
            this.eXs.YL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kX() && this.eXs != null && this.eXt != null) {
            hideNetRefreshView(this.eXt.getRootView());
            showLoadingView(this.eXt.getRootView(), true);
            this.eXs.aIJ();
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
