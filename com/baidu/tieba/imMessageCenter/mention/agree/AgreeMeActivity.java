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
    private b fir;
    private a fis;
    private int mSkinType = 3;
    private a.InterfaceC0259a fit = new a.InterfaceC0259a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0259a
        public void aDX() {
            if (AgreeMeActivity.this.fir != null) {
                AgreeMeActivity.this.fir.aad();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0259a
        public void aDY() {
            if (AgreeMeActivity.this.fir != null) {
                AgreeMeActivity.this.fir.aDY();
            }
        }
    };
    private b.a fiu = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.fis != null) {
                AgreeMeActivity.this.fis.c(AgreeMeActivity.this.fir.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fis.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.fis.getRootView());
                if (AgreeMeActivity.this.fis.bRo != null) {
                    AgreeMeActivity.this.fis.bRo.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void nK(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.HQ().eW(0);
            if (AgreeMeActivity.this.fis != null) {
                AgreeMeActivity.this.fis.jm(false);
                if (v.I(AgreeMeActivity.this.fis.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fis.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.fis.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.fis.bRo != null) {
                        AgreeMeActivity.this.fis.bRo.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fis.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n fip = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aWS() != null) {
                    am x = new am(aVar.aWS()).x("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.fiH) {
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
        this.fis = new a(getPageContext(), inflate);
        this.fis.a(this.fit);
        this.fis.d(this.fip);
        this.fir = new b(getPageContext(), this.fiu);
        showLoadingView(this.fis.getRootView());
        this.fis.jm(false);
        this.fir.aKN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fis != null) {
            this.fis.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fis != null) {
                this.fis.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fir != null) {
            this.fir.aad();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kV() && this.fir != null && this.fis != null) {
            hideNetRefreshView(this.fis.getRootView());
            showLoadingView(this.fis.getRootView(), true);
            this.fir.aKN();
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
