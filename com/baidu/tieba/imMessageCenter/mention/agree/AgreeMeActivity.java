package com.baidu.tieba.imMessageCenter.mention.agree;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import d.b.b.e.p.j;
import d.b.b.e.p.l;
import d.b.b.j.e.n;
import d.b.b.j.e.w;
import d.b.i0.e1.b.o.a;
import d.b.i0.e1.b.o.b;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class AgreeMeActivity extends BaseActivity implements BdListView.p {
    public d.b.i0.e1.b.o.a mMainView;
    public d.b.i0.e1.b.o.b mModel;
    public int mSkinType = 3;
    public a.e mViewCallback = new a();
    public b.c mModelCallback = new b();
    public w mItemClickListener = new c();

    /* loaded from: classes3.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // d.b.i0.e1.b.o.a.e
        public void a() {
            if (AgreeMeActivity.this.mModel != null) {
                AgreeMeActivity.this.mModel.g();
            }
        }

        @Override // d.b.i0.e1.b.o.a.e
        public void b() {
            if (AgreeMeActivity.this.mModel != null) {
                AgreeMeActivity.this.mModel.j();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements b.c {
        public b() {
        }

        @Override // d.b.i0.e1.b.o.b.c
        public void d(ArrayList<n> arrayList) {
            if (AgreeMeActivity.this.mMainView != null) {
                AgreeMeActivity.this.mMainView.k(AgreeMeActivity.this.mModel.f54475f, arrayList);
                AgreeMeActivity agreeMeActivity = AgreeMeActivity.this;
                agreeMeActivity.hideLoadingView(agreeMeActivity.mMainView.d());
                AgreeMeActivity agreeMeActivity2 = AgreeMeActivity.this;
                agreeMeActivity2.hideNetRefreshView(agreeMeActivity2.mMainView.f());
                if (AgreeMeActivity.this.mMainView.f54464f != null) {
                    AgreeMeActivity.this.mMainView.f54464f.setVisibility(0);
                }
            }
        }

        @Override // d.b.i0.e1.b.o.b.c
        public void onFailed(String str) {
            d.b.h0.s.d.b.g0().Y(0);
            if (AgreeMeActivity.this.mMainView == null) {
                return;
            }
            AgreeMeActivity.this.mMainView.l(false);
            if (ListUtils.isEmpty(AgreeMeActivity.this.mMainView.e())) {
                AgreeMeActivity agreeMeActivity = AgreeMeActivity.this;
                agreeMeActivity.hideLoadingView(agreeMeActivity.mMainView.d());
                AgreeMeActivity agreeMeActivity2 = AgreeMeActivity.this;
                agreeMeActivity2.showNetRefreshView(agreeMeActivity2.mMainView.f(), AgreeMeActivity.this.getResources().getString(R.string.refresh_view_title_text), null, AgreeMeActivity.this.getResources().getString(R.string.refresh_view_button_text), true, AgreeMeActivity.this.getNetRefreshListener());
                AgreeMeActivity.this.setNetRefreshViewEmotionMarginTop(l.g(TbadkCoreApplication.getInst(), R.dimen.tbds530));
                if (AgreeMeActivity.this.mMainView.f54464f != null) {
                    AgreeMeActivity.this.mMainView.f54464f.setVisibility(8);
                    return;
                }
                return;
            }
            AgreeMeActivity agreeMeActivity3 = AgreeMeActivity.this;
            agreeMeActivity3.hideLoadingView(agreeMeActivity3.mMainView.d());
            AgreeMeActivity.this.showToast(str);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public c() {
        }

        @Override // d.b.b.j.e.w
        public void f(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (nVar instanceof d.b.i0.e1.b.p.a) {
                d.b.i0.e1.b.p.a aVar = (d.b.i0.e1.b.p.a) nVar;
                if (aVar.getType() == d.b.i0.e1.b.p.a.x) {
                    AgreeMeActivity.this.jumpPb(aVar);
                } else {
                    AgreeMeActivity.this.jumpToSubPb(aVar);
                }
                if (aVar.w() != null) {
                    StatisticItem param = new StatisticItem(aVar.w()).param("obj_locate", 1);
                    if (aVar.getType() == d.b.i0.e1.b.p.a.y) {
                        param.param("obj_type", 2);
                    } else {
                        param.param("obj_type", 1);
                    }
                    TiebaStatic.log(param);
                }
                if (aVar != null) {
                    StatisticItem statisticItem = new StatisticItem("c13784");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", aVar.z());
                    statisticItem.param("fname", aVar.j());
                    statisticItem.param("obj_type", 2);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpPb(d.b.i0.e1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        if (ThreadCardUtils.isUgcThreadType(aVar.g())) {
            PbActivityConfig createNormalCfg = new PbActivityConfig(this).createNormalCfg(aVar.z(), (String) null, 1, "mention");
            createNormalCfg.setStartFrom(12);
            createNormalCfg.setHighLightPostId(aVar.t());
            createNormalCfg.setBjhData(aVar.g());
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
            return;
        }
        PbActivityConfig createNormalCfg2 = new PbActivityConfig(this).createNormalCfg(aVar.z(), aVar.t(), 1, "mention");
        createNormalCfg2.setStartFrom(12);
        createNormalCfg2.setHighLightPostId(aVar.t());
        createNormalCfg2.setBjhData(aVar.g());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToSubPb(d.b.i0.e1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        String z = aVar.z();
        String t = aVar.t();
        String userName = aVar.v() == null ? "" : aVar.v().getUserName();
        if (!TextUtils.isEmpty(aVar.u()) && !"0".equals(aVar.u())) {
            SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(z, aVar.u(), "mention", false, userName, false, aVar.u(), 0);
            createSubPbActivityConfig.setKeyPageStartFrom(13);
            createSubPbActivityConfig.setBjhData(aVar.g());
            createSubPbActivityConfig.setHighLightPostId(t);
            createSubPbActivityConfig.setKeyOriUgcTopPid(t);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig2 = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(z, t, "mention", false, userName, false, t, 0);
        createSubPbActivityConfig2.setKeyPageStartFrom(13);
        createSubPbActivityConfig2.setBjhData(aVar.g());
        createSubPbActivityConfig2.setHighLightPostId(t);
        createSubPbActivityConfig2.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig2));
    }

    @Override // com.baidu.tbadk.BaseActivity, d.b.h0.k0.a
    public String getCurrentPageKey() {
        return "a079";
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            d.b.i0.e1.b.o.a aVar = this.mMainView;
            if (aVar != null) {
                aVar.c(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.agree_me_activity, (ViewGroup) null);
        setContentView(inflate);
        d.b.i0.e1.b.o.a aVar = new d.b.i0.e1.b.o.a(getPageContext(), inflate);
        this.mMainView = aVar;
        aVar.j(this.mViewCallback);
        this.mMainView.i(this.mItemClickListener);
        this.mModel = new d.b.i0.e1.b.o.b(getPageContext(), this.mModelCallback);
        showLoadingView(this.mMainView.d());
        this.mMainView.l(false);
        this.mModel.d();
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.b.i0.e1.b.o.a aVar = this.mMainView;
        if (aVar != null) {
            aVar.h();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        d.b.i0.e1.b.o.a aVar;
        if (!j.z() || this.mModel == null || (aVar = this.mMainView) == null) {
            return;
        }
        hideNetRefreshView(aVar.f());
        showLoadingView(this.mMainView.d(), true);
        this.mModel.d();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        d.b.i0.e1.b.o.b bVar = this.mModel;
        if (bVar != null) {
            bVar.g();
        }
    }
}
