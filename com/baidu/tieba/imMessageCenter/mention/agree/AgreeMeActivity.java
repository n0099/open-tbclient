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
    private b gZg;
    private a gZh;
    private int mSkinType = 3;
    private a.InterfaceC0360a gZi = new a.InterfaceC0360a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.1
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0360a
        public void aYU() {
            if (AgreeMeActivity.this.gZg != null) {
                AgreeMeActivity.this.gZg.aJw();
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.a.InterfaceC0360a
        public void bpv() {
            if (AgreeMeActivity.this.gZg != null) {
                AgreeMeActivity.this.gZg.bpv();
            }
        }
    };
    private b.a gZj = new b.a() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.2
        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void V(ArrayList<m> arrayList) {
            if (AgreeMeActivity.this.gZh != null) {
                AgreeMeActivity.this.gZh.c(AgreeMeActivity.this.gZg.hasMore, arrayList);
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gZh.getRootView());
                AgreeMeActivity.this.hideNetRefreshView(AgreeMeActivity.this.gZh.getRootView());
                if (AgreeMeActivity.this.gZh.dra != null) {
                    AgreeMeActivity.this.gZh.dra.setVisibility(0);
                }
            }
        }

        @Override // com.baidu.tieba.imMessageCenter.mention.agree.b.a
        public void xc(String str) {
            com.baidu.tbadk.coreExtra.messageCenter.b.anR().jz(0);
            if (AgreeMeActivity.this.gZh != null) {
                AgreeMeActivity.this.gZh.mT(false);
                if (v.aa(AgreeMeActivity.this.gZh.getDatas())) {
                    AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gZh.getRootView());
                    AgreeMeActivity.this.showNetRefreshView(AgreeMeActivity.this.gZh.getRootView(), str, true);
                    AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                    if (AgreeMeActivity.this.gZh.dra != null) {
                        AgreeMeActivity.this.gZh.dra.setVisibility(8);
                        return;
                    }
                    return;
                }
                AgreeMeActivity.this.hideLoadingView(AgreeMeActivity.this.gZh.getRootView());
                AgreeMeActivity.this.showToast(str);
            }
        }
    };
    private s gZe = new s() { // from class: com.baidu.tieba.imMessageCenter.mention.agree.AgreeMeActivity.3
        @Override // com.baidu.adp.widget.ListView.s
        public void a(View view, m mVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (mVar instanceof com.baidu.tieba.imMessageCenter.mention.base.a) {
                com.baidu.tieba.imMessageCenter.mention.base.a aVar = (com.baidu.tieba.imMessageCenter.mention.base.a) mVar;
                AgreeMeActivity.this.a(aVar);
                if (aVar.bJm() != null) {
                    an P = new an(aVar.bJm()).P("obj_locate", 1);
                    if (aVar.getType() == com.baidu.tieba.imMessageCenter.mention.base.a.gZv) {
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
        this.gZh = new a(getPageContext(), inflate);
        this.gZh.a(this.gZi);
        this.gZh.d(this.gZe);
        this.gZg = new b(getPageContext(), this.gZj);
        showLoadingView(this.gZh.getRootView());
        this.gZh.mT(false);
        this.gZg.bvQ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gZh != null) {
            this.gZh.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            if (this.gZh != null) {
                this.gZh.changeSkinType(i);
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.gZg != null) {
            this.gZg.aJw();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kc() && this.gZg != null && this.gZh != null) {
            hideNetRefreshView(this.gZh.getRootView());
            showLoadingView(this.gZh.getRootView(), true);
            this.gZg.bvQ();
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
