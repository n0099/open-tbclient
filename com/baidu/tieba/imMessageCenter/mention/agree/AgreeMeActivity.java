package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b eTL;
    private a eTM;
    private int mSkinType = 3;
    private a.InterfaceC0186a eTN = new a.InterfaceC0186a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aNL() {
            if (AgreeMeActivity.this.eTL != null) {
                AgreeMeActivity.this.eTL.WO();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aNK() {
            if (AgreeMeActivity.this.eTL != null) {
                AgreeMeActivity.this.eTL.aNK();
            }
        }
    };
    private b.a eTO = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void J(ArrayList<i> arrayList) {
            if (AgreeMeActivity.this.eTM != null) {
                AgreeMeActivity.this.eTM.c(AgreeMeActivity.this.eTL.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eTM.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eTM.getRootView());
                if (AgreeMeActivity.this.eTM.cdS != null) {
                    AgreeMeActivity.this.eTM.cdS.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void lu(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.GJ().gU(0);
            if (AgreeMeActivity.this.eTM != null) {
                AgreeMeActivity.this.eTM.ip(false);
                if (v.E(AgreeMeActivity.this.eTM.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eTM.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eTM.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eTM.cdS != null) {
                        AgreeMeActivity.this.eTM.cdS.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eTM.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private o eTJ = new o() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (iVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) iVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aNQ() != null) {
                    ak s = new ak(aVar.aNQ()).s("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eUa) {
                        s.s("obj_type", 2);
                    } else {
                        s.s("obj_type", 1);
                    }
                    TiebaStatic.log(s);
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
        this.eTM = new a(getPageContext(), inflate);
        this.eTM.a(this.eTN);
        this.eTM.d(this.eTJ);
        this.eTL = new b(getPageContext(), this.eTO);
        showLoadingView(this.eTM.getRootView());
        this.eTM.ip(false);
        this.eTL.aCf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eTM != null) {
            this.eTM.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eTM != null) {
                this.eTM.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eTL != null) {
            this.eTL.WO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.oJ() && this.eTL != null && this.eTM != null) {
            hideNetRefreshView(this.eTM.getRootView());
            showLoadingView(this.eTM.getRootView(), true);
            this.eTL.aCf();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            if (aVar.getThreadType() == 33) {
                TiebaStatic.log("c10384");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PhotoLiveActivityConfig.a(this, aVar.getThread_id()).cP(aVar.getPost_id()).cQ("mention").xD()));
                return;
            }
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
