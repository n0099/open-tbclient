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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b eor;
    private a eos;
    private int mSkinType = 3;
    private a.InterfaceC0169a eot = new a.InterfaceC0169a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0169a
        public void aIN() {
            if (AgreeMeActivity.this.eor != null) {
                AgreeMeActivity.this.eor.Po();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0169a
        public void aIM() {
            if (AgreeMeActivity.this.eor != null) {
                AgreeMeActivity.this.eor.aIM();
            }
        }
    };
    private b.a eou = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void J(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eos != null) {
                AgreeMeActivity.this.eos.c(AgreeMeActivity.this.eor.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eos.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eos.getRootView());
                if (AgreeMeActivity.this.eos.bnR != null) {
                    AgreeMeActivity.this.eos.bnR.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void lx(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.zx().dS(0);
            if (AgreeMeActivity.this.eos != null) {
                AgreeMeActivity.this.eos.hN(false);
                if (v.w(AgreeMeActivity.this.eos.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eos.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eos.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eos.bnR != null) {
                        AgreeMeActivity.this.eos.bnR.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eos.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eop = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view2, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aIS() != null) {
                    al r = new al(aVar.aIS()).r("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eoG) {
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
        this.eos = new a(getPageContext(), inflate);
        this.eos.a(this.eot);
        this.eos.d(this.eop);
        this.eor = new b(getPageContext(), this.eou);
        showLoadingView(this.eos.getRootView());
        this.eos.hN(false);
        this.eor.axc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eos != null) {
            this.eos.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eos != null) {
                this.eos.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eor != null) {
            this.eor.Po();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.gP() && this.eor != null && this.eos != null) {
            hideNetRefreshView(this.eos.getRootView());
            showLoadingView(this.eos.getRootView(), true);
            this.eor.axc();
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
