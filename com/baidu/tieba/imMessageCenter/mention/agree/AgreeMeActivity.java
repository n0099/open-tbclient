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
    private b eTw;
    private a eTx;
    private int mSkinType = 3;
    private a.InterfaceC0186a eTy = new a.InterfaceC0186a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aNK() {
            if (AgreeMeActivity.this.eTw != null) {
                AgreeMeActivity.this.eTw.WN();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0186a
        public void aNJ() {
            if (AgreeMeActivity.this.eTw != null) {
                AgreeMeActivity.this.eTw.aNJ();
            }
        }
    };
    private b.a eTz = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void J(ArrayList<i> arrayList) {
            if (AgreeMeActivity.this.eTx != null) {
                AgreeMeActivity.this.eTx.c(AgreeMeActivity.this.eTw.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eTx.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.eTx.getRootView());
                if (AgreeMeActivity.this.eTx.cdP != null) {
                    AgreeMeActivity.this.eTx.cdP.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void lu(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.a.GI().gU(0);
            if (AgreeMeActivity.this.eTx != null) {
                AgreeMeActivity.this.eTx.ik(false);
                if (v.E(AgreeMeActivity.this.eTx.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eTx.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.eTx.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionDefMarginTop();
                    if (AgreeMeActivity.this.eTx.cdP != null) {
                        AgreeMeActivity.this.eTx.cdP.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.eTx.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private o eTu = new o() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.o
        public void a(View view, i iVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (iVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) iVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.aNP() != null) {
                    ak s = new ak(aVar.aNP()).s("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.eTL) {
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
        this.eTx = new a(getPageContext(), inflate);
        this.eTx.a(this.eTy);
        this.eTx.d(this.eTu);
        this.eTw = new b(getPageContext(), this.eTz);
        showLoadingView(this.eTx.getRootView());
        this.eTx.ik(false);
        this.eTw.aCe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.eTx != null) {
            this.eTx.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.eTx != null) {
                this.eTx.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.eTw != null) {
            this.eTw.WN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.oJ() && this.eTw != null && this.eTx != null) {
            hideNetRefreshView(this.eTx.getRootView());
            showLoadingView(this.eTx.getRootView(), true);
            this.eTw.aCe();
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
