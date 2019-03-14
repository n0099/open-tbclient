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
    private b gzf;
    private a gzg;
    private int mSkinType = 3;
    private a.InterfaceC0327a gzh = new a.InterfaceC0327a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0327a
        public void bfd() {
            if (AgreeMeActivity.this.gzf != null) {
                AgreeMeActivity.this.gzf.aBc();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0327a
        public void bfe() {
            if (AgreeMeActivity.this.gzf != null) {
                AgreeMeActivity.this.gzf.bfe();
            }
        }
    };
    private b.a gzi = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void R(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.gzg != null) {
                AgreeMeActivity.this.gzg.c(AgreeMeActivity.this.gzf.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gzg.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.gzg.getRootView());
                if (AgreeMeActivity.this.gzg.dcA != null) {
                    AgreeMeActivity.this.gzg.dcA.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void uF(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.ahA().iC(0);
            if (AgreeMeActivity.this.gzg != null) {
                AgreeMeActivity.this.gzg.lM(false);
                if (v.T(AgreeMeActivity.this.gzg.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gzg.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.gzg.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.h(TbadkCoreApplication.getInst(), d.e.tbds530));
                    if (AgreeMeActivity.this.gzg.dcA != null) {
                        AgreeMeActivity.this.gzg.dcA.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gzg.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s gzd = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.bxU() != null) {
                    am T = new am(aVar.bxU()).T("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gzu) {
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
        this.gzg = new a(getPageContext(), inflate);
        this.gzg.a(this.gzh);
        this.gzg.d(this.gzd);
        this.gzf = new b(getPageContext(), this.gzi);
        showLoadingView(this.gzg.getRootView());
        this.gzg.lM(false);
        this.gzf.blr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gzg != null) {
            this.gzg.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gzg != null) {
                this.gzg.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gzf != null) {
            this.gzf.aBc();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kY() && this.gzf != null && this.gzg != null) {
            hideNetRefreshView(this.gzg.getRootView());
            showLoadingView(this.gzg.getRootView(), true);
            this.gzf.blr();
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
