package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b gWu;
    private a gWv;
    private int mSkinType = 3;
    private a.InterfaceC0343a gWw = new a.InterfaceC0343a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0343a
        public void aYo() {
            if (AgreeMeActivity.this.gWu != null) {
                AgreeMeActivity.this.gWu.aIQ();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0343a
        public void box() {
            if (AgreeMeActivity.this.gWu != null) {
                AgreeMeActivity.this.gWu.box();
            }
        }
    };
    private b.a gWx = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void V(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.gWv != null) {
                AgreeMeActivity.this.gWv.c(AgreeMeActivity.this.gWu.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gWv.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.gWv.getRootView());
                if (AgreeMeActivity.this.gWv.dpi != null) {
                    AgreeMeActivity.this.gWv.dpi.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void wC(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.anD().jv(0);
            if (AgreeMeActivity.this.gWv != null) {
                AgreeMeActivity.this.gWv.mQ(false);
                if (v.aa(AgreeMeActivity.this.gWv.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gWv.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.gWv.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.gWv.dpi != null) {
                        AgreeMeActivity.this.gWv.dpi.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gWv.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s gWs = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.bIk() != null) {
                    an P = new an(aVar.bIk()).P("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gWJ) {
                        P.P("obj_type", 2);
                    } else {
                        P.P("obj_type", 1);
                    }
                    TiebaStatic.log(P);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.agree_me_activity, (ViewGroup) null);
        setContentView(inflate);
        this.gWv = new a(getPageContext(), inflate);
        this.gWv.a(this.gWw);
        this.gWv.d(this.gWs);
        this.gWu = new b(getPageContext(), this.gWx);
        showLoadingView(this.gWv.getRootView());
        this.gWv.mQ(false);
        this.gWu.buP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gWv != null) {
            this.gWv.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gWv != null) {
                this.gWv.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gWu != null) {
            this.gWu.aIQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kc() && this.gWu != null && this.gWv != null) {
            hideNetRefreshView(this.gWv.getRootView());
            showLoadingView(this.gWv.getRootView(), true);
            this.gWu.buP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.imMessageCenter.mention.base.a aVar) {
        if (aVar != null) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.getThread_id(), aVar.getPost_id(), 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(aVar.getPost_id());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
        }
    }
}
