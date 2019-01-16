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
    private b fjh;
    private a fji;
    private int mSkinType = 3;
    private a.InterfaceC0259a fjj = new a.InterfaceC0259a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0259a
        public void aEu() {
            if (AgreeMeActivity.this.fjh != null) {
                AgreeMeActivity.this.fjh.aaA();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0259a
        public void aEv() {
            if (AgreeMeActivity.this.fjh != null) {
                AgreeMeActivity.this.fjh.aEv();
            }
        }
    };
    private b.a fjk = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void O(ArrayList<h> arrayList) {
            if (AgreeMeActivity.this.fji != null) {
                AgreeMeActivity.this.fji.c(AgreeMeActivity.this.fjh.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fji.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.fji.getRootView());
                if (AgreeMeActivity.this.fji.bRZ != null) {
                    AgreeMeActivity.this.fji.bRZ.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void oa(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.If().eW(0);
            if (AgreeMeActivity.this.fji != null) {
                AgreeMeActivity.this.fji.jm(false);
                if (v.I(AgreeMeActivity.this.fji.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fji.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.fji.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.fji.bRZ != null) {
                        AgreeMeActivity.this.fji.bRZ.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.fji.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private n fjf = new n() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.n
        public void a(View view, h hVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (hVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) hVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aXs() != null) {
                    am y = new am(aVar.aXs()).y("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.fjw) {
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
        this.fji = new a(getPageContext(), inflate);
        this.fji.a(this.fjj);
        this.fji.d(this.fjf);
        this.fjh = new b(getPageContext(), this.fjk);
        showLoadingView(this.fji.getRootView());
        this.fji.jm(false);
        this.fjh.aLl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fji != null) {
            this.fji.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.fji != null) {
                this.fji.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.fjh != null) {
            this.fjh.aaA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kV() && this.fjh != null && this.fji != null) {
            hideNetRefreshView(this.fji.getRootView());
            showLoadingView(this.fji.getRootView(), true);
            this.fjh.aLl();
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
