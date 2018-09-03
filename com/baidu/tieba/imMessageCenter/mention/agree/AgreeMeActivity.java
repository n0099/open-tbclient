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
import com.baidu.tieba.f;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b eIt;
    private a eIu;
    private int mSkinType = 3;
    private a.InterfaceC0186a eIv = new a.InterfaceC0186a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aPk() {
            if (AgreeMeActivity.this.eIt != null) {
                AgreeMeActivity.this.eIt.Tq();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aPj() {
            if (AgreeMeActivity.this.eIt != null) {
                AgreeMeActivity.this.eIt.aPj();
            }
        }
    };
    private b.a eIw = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eIu != null) {
                AgreeMeActivity.this.eIu.c(AgreeMeActivity.this.eIt.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eIu.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eIu.getRootView());
                if (AgreeMeActivity.this.eIu.byp != null) {
                    AgreeMeActivity.this.eIu.byp.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void md(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dY(0);
            if (AgreeMeActivity.this.eIu != null) {
                AgreeMeActivity.this.eIu.ih(false);
                if (w.z(AgreeMeActivity.this.eIu.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eIu.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eIu.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eIu.byp != null) {
                        AgreeMeActivity.this.eIu.byp.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eIu.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eIr = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aPp() != null) {
                    an r = new an(aVar.aPp()).r("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eII) {
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
        View inflate = getLayoutInflater().inflate(f.h.agree_me_activity, (ViewGroup) null);
        setContentView(inflate);
        this.eIu = new a(getPageContext(), inflate);
        this.eIu.a(this.eIv);
        this.eIu.d(this.eIr);
        this.eIt = new b(getPageContext(), this.eIw);
        showLoadingView(this.eIu.getRootView());
        this.eIu.ih(false);
        this.eIt.aDe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eIu != null) {
            this.eIu.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eIu != null) {
                this.eIu.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eIt != null) {
            this.eIt.Tq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jE() && this.eIt != null && this.eIu != null) {
            hideNetRefreshView(this.eIu.getRootView());
            showLoadingView(this.eIu.getRootView(), true);
            this.eIt.aDe();
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
