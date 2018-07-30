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
    private b eIy;
    private a eIz;
    private int mSkinType = 3;
    private a.InterfaceC0186a eIA = new a.InterfaceC0186a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aPn() {
            if (AgreeMeActivity.this.eIy != null) {
                AgreeMeActivity.this.eIy.Tn();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aPm() {
            if (AgreeMeActivity.this.eIy != null) {
                AgreeMeActivity.this.eIy.aPm();
            }
        }
    };
    private b.a eIB = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.eIz != null) {
                AgreeMeActivity.this.eIz.c(AgreeMeActivity.this.eIy.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eIz.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eIz.getRootView());
                if (AgreeMeActivity.this.eIz.byn != null) {
                    AgreeMeActivity.this.eIz.byn.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void mb(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.Dl().dZ(0);
            if (AgreeMeActivity.this.eIz != null) {
                AgreeMeActivity.this.eIz.ih(false);
                if (w.z(AgreeMeActivity.this.eIz.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eIz.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eIz.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eIz.byn != null) {
                        AgreeMeActivity.this.eIz.byn.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eIz.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n eIw = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aPs() != null) {
                    an r = new an(aVar.aPs()).r("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eIN) {
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
        View inflate = getLayoutInflater().inflate(d.h.agree_me_activity, (ViewGroup) null);
        setContentView(inflate);
        this.eIz = new a(getPageContext(), inflate);
        this.eIz.a(this.eIA);
        this.eIz.d(this.eIw);
        this.eIy = new b(getPageContext(), this.eIB);
        showLoadingView(this.eIz.getRootView());
        this.eIz.ih(false);
        this.eIy.aDh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eIz != null) {
            this.eIz.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eIz != null) {
                this.eIz.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eIy != null) {
            this.eIy.Tn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jE() && this.eIy != null && this.eIz != null) {
            hideNetRefreshView(this.eIz.getRootView());
            showLoadingView(this.eIz.getRootView(), true);
            this.eIy.aDh();
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
