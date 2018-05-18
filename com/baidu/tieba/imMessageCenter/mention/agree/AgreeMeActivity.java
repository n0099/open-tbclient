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
    private b epx;
    private a epy;
    private int mSkinType = 3;
    private a.InterfaceC0169a epz = new a.InterfaceC0169a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0169a
        public void aIM() {
            if (AgreeMeActivity.this.epx != null) {
                AgreeMeActivity.this.epx.Pl();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0169a
        public void aIL() {
            if (AgreeMeActivity.this.epx != null) {
                AgreeMeActivity.this.epx.aIL();
            }
        }
    };
    private b.a epA = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void J(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.epy != null) {
                AgreeMeActivity.this.epy.c(AgreeMeActivity.this.epx.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.epy.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.epy.getRootView());
                if (AgreeMeActivity.this.epy.bog != null) {
                    AgreeMeActivity.this.epy.bog.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void lA(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.zw().dT(0);
            if (AgreeMeActivity.this.epy != null) {
                AgreeMeActivity.this.epy.hO(false);
                if (v.w(AgreeMeActivity.this.epy.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.epy.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.epy.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.epy.bog != null) {
                        AgreeMeActivity.this.epy.bog.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.epy.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n epv = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view2, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aIR() != null) {
                    al r = new al(aVar.aIR()).r("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.epM) {
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
        this.epy = new a(getPageContext(), inflate);
        this.epy.a(this.epz);
        this.epy.d(this.epv);
        this.epx = new b(getPageContext(), this.epA);
        showLoadingView(this.epy.getRootView());
        this.epy.hO(false);
        this.epx.axb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.epy != null) {
            this.epy.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.epy != null) {
                this.epy.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.epx != null) {
            this.epx.Pl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.gP() && this.epx != null && this.epy != null) {
            hideNetRefreshView(this.epy.getRootView());
            showLoadingView(this.epy.getRootView(), true);
            this.epx.axb();
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
