package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.c.j.e.w;
import d.a.c.j.e.x;
import d.a.n0.g1.b.f.b;
import d.a.n0.g1.b.n;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {

    /* renamed from: e  reason: collision with root package name */
    public ReplyMeModelController f17596e;

    /* renamed from: f  reason: collision with root package name */
    public n f17597f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f17598g;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17600i;

    /* renamed from: h  reason: collision with root package name */
    public int f17599h = 3;
    public CustomMessageListener j = new a(2016321);
    public CustomMessageListener k = new b(2001628);
    public final CustomMessageListener l = new c(2001120);
    public final CustomMessageListener m = new d(2016010);
    public w n = new e();
    public x o = new g();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.f17596e != null) {
                    ReplyMessageFragment replyMessageFragment = ReplyMessageFragment.this;
                    replyMessageFragment.showLoadingView(replyMessageFragment.f17598g, true);
                    ReplyMessageFragment.this.f17596e.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof BdUniqueId) || (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) == null || bdUniqueId.getId() != ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                return;
            }
            if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.f17600i) {
                    if (ReplyMessageFragment.this.f17597f != null) {
                        ReplyMessageFragment.this.f17597f.Z(true);
                        return;
                    }
                    return;
                }
                ReplyMessageFragment.this.f17600i = true;
                ReplyMessageFragment.this.f17597f.Z(true);
                ReplyMessageFragment replyMessageFragment = ReplyMessageFragment.this;
                replyMessageFragment.showLoadingView(replyMessageFragment.f17598g);
                ReplyMessageFragment.this.f17596e.u();
                return;
            }
            ReplyMessageFragment.this.V0();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.f17597f != null) {
                ReplyMessageFragment.this.f17597f.R((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            customResponsedMessage.getCmd();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements w {
        public e() {
        }

        @Override // d.a.c.j.e.w
        public void b(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if (nVar instanceof d.a.n0.g1.b.p.a) {
                d.a.n0.g1.b.p.a aVar = (d.a.n0.g1.b.p.a) nVar;
                if (aVar.D()) {
                    aVar.H(false);
                    if (ReplyMessageFragment.this.f17597f != null) {
                        ReplyMessageFragment.this.f17597f.N();
                    }
                }
                if (aVar.C()) {
                    if (aVar.E()) {
                        ReplyMessageFragment.this.Q0(aVar);
                    } else {
                        ReplyMessageFragment.this.P0(aVar);
                    }
                } else if (aVar.E()) {
                    ReplyMessageFragment.this.R0(aVar);
                } else {
                    ReplyMessageFragment.this.S0(aVar);
                }
                if (aVar.w() != null) {
                    StatisticItem param = new StatisticItem(aVar.w()).param("obj_locate", 1);
                    if (aVar.getType() == d.a.n0.g1.b.p.a.B) {
                        param.param("obj_type", 1);
                    } else {
                        param.param("obj_type", 2);
                    }
                    TiebaStatic.log(param);
                }
                if (aVar != null) {
                    StatisticItem statisticItem = new StatisticItem("c13720");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", aVar.z());
                    statisticItem.param("fname", aVar.l());
                    statisticItem.param("obj_type", 3);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CustomMessageTask.CustomRunnable<Boolean> {
        public f() {
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            if (ReplyMessageFragment.this.f17597f != null) {
                return new CustomResponsedMessage<>(2016322, Boolean.valueOf(ReplyMessageFragment.this.f17597f.P()));
            }
            return new CustomResponsedMessage<>(2016322, Boolean.FALSE);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements x {

        /* loaded from: classes4.dex */
        public class a implements b.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f17608a;

            public a(int i2) {
                this.f17608a = i2;
            }

            @Override // d.a.n0.g1.b.f.b.c
            public void a() {
                ReplyMessageFragment.this.f17597f.G(this.f17608a);
                ReplyMessageFragment.this.f17596e.t(this.f17608a);
            }
        }

        public g() {
        }

        @Override // d.a.c.j.e.x
        public boolean a(View view, d.a.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            if (nVar instanceof d.a.n0.g1.b.p.a) {
                d.a.n0.g1.b.p.a aVar = (d.a.n0.g1.b.p.a) nVar;
                d.a.n0.g1.b.f.a aVar2 = new d.a.n0.g1.b.f.a();
                aVar2.f55040a = 1;
                aVar2.f55041b = d.a.c.e.m.b.f(aVar.z(), 0L);
                aVar2.f55042c = d.a.c.e.m.b.f(aVar.t(), 0L);
                aVar2.f55043d = aVar.h() != null ? aVar.h().oriUgcNid : "";
                d.a.n0.g1.b.f.b bVar = new d.a.n0.g1.b.f.b(ReplyMessageFragment.this.getPageContext());
                bVar.g(aVar2);
                bVar.h(new a(i2));
                bVar.i();
                return true;
            }
            return false;
        }
    }

    public void O0() {
        this.f17597f.Z(false);
    }

    public final void P0(d.a.n0.g1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.z(), aVar.t(), "mention", false, aVar.v() == null ? "" : aVar.v().getUserName(), false, aVar.t(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.h());
        createSubPbActivityConfig.setHighLightPostId(aVar.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void Q0(d.a.n0.g1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.z(), aVar.u(), "mention", false, aVar.v() == null ? "" : aVar.v().getUserName(), false, aVar.u(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.h());
        createSubPbActivityConfig.setHighLightPostId(aVar.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid(aVar.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void R0(d.a.n0.g1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.z(), aVar.t(), "mention", false, aVar.v() == null ? "" : aVar.v().getUserName(), false, aVar.t(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(aVar.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void S0(d.a.n0.g1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(aVar.z(), aVar.t(), 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(aVar.h());
        createNormalCfg.setHighLightPostId(aVar.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void T0() {
        ReplyMeModelController replyMeModelController = this.f17596e;
        if (replyMeModelController != null) {
            replyMeModelController.w();
        }
    }

    public void U0(boolean z, ArrayList<d.a.c.j.e.n> arrayList) {
        if (this.f17597f != null) {
            hideLoadingView(this.f17598g);
            hideNetRefreshView(this.f17598g);
            this.f17597f.T(z, arrayList);
        }
    }

    public void V0() {
        ReplyMeModelController replyMeModelController = this.f17596e;
        if (replyMeModelController != null) {
            replyMeModelController.y();
        }
    }

    public final void W0() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f17597f.O(i2, i3, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        if (this.f17599h != i2) {
            this.f17599h = i2;
            n nVar = this.f17597f;
            if (nVar != null) {
                nVar.onChangeSkinType(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.j);
        registerListener(this.k);
        W0();
        ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
        this.f17596e = replyMeModelController;
        replyMeModelController.v(bundle);
        this.f17596e.setUniqueId(getUniqueId());
        this.f17598g = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        n nVar = new n(this);
        this.f17597f = nVar;
        nVar.Q(this.f17598g);
        this.f17597f.Y(this.n);
        this.f17597f.X(this.o);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.f17597f.Z(false);
                showLoadingView(this.f17598g);
                this.f17596e.u();
                this.f17600i = true;
            }
        } else {
            this.f17597f.Z(false);
            showLoadingView(this.f17598g);
            this.f17596e.u();
        }
        registerListener(this.l);
        registerListener(this.m);
        return this.f17598g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(2016322);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterListener(this.m);
        n nVar = this.f17597f;
        if (nVar != null) {
            nVar.destroy();
        }
        ReplyMeModelController replyMeModelController = this.f17596e;
        if (replyMeModelController != null) {
            replyMeModelController.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        n nVar;
        super.onNetRefreshButtonClicked();
        if (!l.D() || (nVar = this.f17597f) == null) {
            return;
        }
        nVar.Z(true);
        V0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        n nVar = this.f17597f;
        if (nVar != null) {
            nVar.P();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        n nVar = this.f17597f;
        if (nVar != null) {
            nVar.S();
        }
    }

    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.f17598g);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        n nVar = this.f17597f;
        if (nVar != null) {
            nVar.onServerError(errorData);
        }
        n nVar2 = this.f17597f;
        if (nVar2 != null && nVar2.H() != null) {
            this.f17597f.H().setVisibility(8);
        }
        showNetRefreshView(this.f17598g, null, false);
    }
}
