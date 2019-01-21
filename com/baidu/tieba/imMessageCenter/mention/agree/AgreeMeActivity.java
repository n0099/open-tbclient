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
    private b fji;
    private a fjj;
    private int mSkinType = 3;
    private a.InterfaceC0259a fjk = new a.InterfaceC0259a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0259a
        public void aEu() {
            if (AgreeMeActivity.this.fji != null) {
                AgreeMeActivity.this.fji.aaA();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0259a
        public void aEv() {
            if (AgreeMeActivity.this.fji != null) {
                AgreeMeActivity.this.fji.aEv();
            }
        }
    };
    private b.a fjl = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.fjj != null) {
                AgreeMeActivity.this.fjj.c(AgreeMeActivity.this.fji.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fjj.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.fjj.getRootView());
                if (AgreeMeActivity.this.fjj.bSa != null) {
                    AgreeMeActivity.this.fjj.bSa.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void oa(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.If().eW(0);
            if (AgreeMeActivity.this.fjj != null) {
                AgreeMeActivity.this.fjj.jm(false);
                if (v.I(AgreeMeActivity.this.fjj.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fjj.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.fjj.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.fjj.bSa != null) {
                        AgreeMeActivity.this.fjj.bSa.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fjj.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n fjg = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aXs() != null) {
                    am y = new am(aVar.aXs()).y("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.fjx) {
                        y.y("obj_type", 2);
                    } else {
                        y.y("obj_type", 1);
                    }
                    TiebaStatic.log(y);
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
        this.fjj = new a(getPageContext(), inflate);
        this.fjj.a(this.fjk);
        this.fjj.d(this.fjg);
        this.fji = new b(getPageContext(), this.fjl);
        showLoadingView(this.fjj.getRootView());
        this.fjj.jm(false);
        this.fji.aLl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fjj != null) {
            this.fjj.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fjj != null) {
                this.fjj.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fji != null) {
            this.fji.aaA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kV() && this.fji != null && this.fjj != null) {
            hideNetRefreshView(this.fjj.getRootView());
            showLoadingView(this.fjj.getRootView(), true);
            this.fji.aLl();
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
