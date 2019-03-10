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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.imMessageCenter.mention.agree.a;
import com.baidu.tieba.imMessageCenter.mention.agree.b;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.e {
    private b gzg;
    private a gzh;
    private int mSkinType = 3;
    private a.InterfaceC0264a gzi = new a.InterfaceC0264a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0264a
        public void bfe() {
            if (AgreeMeActivity.this.gzg != null) {
                AgreeMeActivity.this.gzg.aBd();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0264a
        public void bff() {
            if (AgreeMeActivity.this.gzg != null) {
                AgreeMeActivity.this.gzg.bff();
            }
        }
    };
    private b.a gzj = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void R(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.gzh != null) {
                AgreeMeActivity.this.gzh.c(AgreeMeActivity.this.gzg.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gzh.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.gzh.getRootView());
                if (AgreeMeActivity.this.gzh.dcE != null) {
                    AgreeMeActivity.this.gzh.dcE.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void uH(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iC(0);
            if (AgreeMeActivity.this.gzh != null) {
                AgreeMeActivity.this.gzh.lM(false);
                if (v.T(AgreeMeActivity.this.gzh.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gzh.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.gzh.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.h(TbadkCoreApplication.getInst(), d.e.tbds530));
                    if (AgreeMeActivity.this.gzh.dcE != null) {
                        AgreeMeActivity.this.gzh.dcE.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gzh.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s gze = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.bxV() != null) {
                    am T = new am(aVar.bxV()).T("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gzv) {
                        T.T("obj_type", 2);
                    } else {
                        T.T("obj_type", 1);
                    }
                    TiebaStatic.log(T);
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
        this.gzh = new a(getPageContext(), inflate);
        this.gzh.a(this.gzi);
        this.gzh.d(this.gze);
        this.gzg = new b(getPageContext(), this.gzj);
        showLoadingView(this.gzh.getRootView());
        this.gzh.lM(false);
        this.gzg.bls();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gzh != null) {
            this.gzh.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gzh != null) {
                this.gzh.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gzg != null) {
            this.gzg.aBd();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (j.kY() && this.gzg != null && this.gzh != null) {
            hideNetRefreshView(this.gzh.getRootView());
            showLoadingView(this.gzh.getRootView(), true);
            this.gzg.bls();
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
