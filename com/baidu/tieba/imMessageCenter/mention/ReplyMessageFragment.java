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
import d.b.c.e.p.l;
import d.b.c.j.e.w;
import d.b.c.j.e.x;
import d.b.j0.f1.b.f.b;
import d.b.j0.f1.b.n;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {

    /* renamed from: e  reason: collision with root package name */
    public ReplyMeModelController f18027e;

    /* renamed from: f  reason: collision with root package name */
    public n f18028f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f18029g;
    public boolean i;

    /* renamed from: h  reason: collision with root package name */
    public int f18030h = 3;
    public CustomMessageListener j = new a(2016321);
    public CustomMessageListener k = new b(2001628);
    public final CustomMessageListener l = new c(2001120);
    public final CustomMessageListener m = new d(2016010);
    public w n = new e();
    public x o = new g();

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (ReplyMessageFragment.this.f18027e != null) {
                    ReplyMessageFragment replyMessageFragment = ReplyMessageFragment.this;
                    replyMessageFragment.showLoadingView(replyMessageFragment.f18029g, true);
                    ReplyMessageFragment.this.f18027e.u();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof BdUniqueId) || (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) == null || bdUniqueId.getId() != ReplyMessageFragment.this.getPageContext().getUniqueId().getId()) {
                return;
            }
            if (ReplyMessageFragment.this.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == ReplyMessageFragment.this.getActivity()) {
                if (!TbadkCoreApplication.getInst().checkInterrupt() || ReplyMessageFragment.this.i) {
                    if (ReplyMessageFragment.this.f18028f != null) {
                        ReplyMessageFragment.this.f18028f.b0(true);
                        return;
                    }
                    return;
                }
                ReplyMessageFragment.this.i = true;
                ReplyMessageFragment.this.f18028f.b0(true);
                ReplyMessageFragment replyMessageFragment = ReplyMessageFragment.this;
                replyMessageFragment.showLoadingView(replyMessageFragment.f18029g);
                ReplyMessageFragment.this.f18027e.u();
                return;
            }
            ReplyMessageFragment.this.W0();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ReplyMessageFragment.this.f18028f != null) {
                ReplyMessageFragment.this.f18028f.T((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i) {
            super(i);
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

        @Override // d.b.c.j.e.w
        public void f(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (nVar instanceof d.b.j0.f1.b.p.a) {
                d.b.j0.f1.b.p.a aVar = (d.b.j0.f1.b.p.a) nVar;
                if (aVar.D()) {
                    aVar.H(false);
                    if (ReplyMessageFragment.this.f18028f != null) {
                        ReplyMessageFragment.this.f18028f.P();
                    }
                }
                if (aVar.C()) {
                    if (aVar.E()) {
                        ReplyMessageFragment.this.R0(aVar);
                    } else {
                        ReplyMessageFragment.this.Q0(aVar);
                    }
                } else if (aVar.E()) {
                    ReplyMessageFragment.this.S0(aVar);
                } else {
                    ReplyMessageFragment.this.T0(aVar);
                }
                if (aVar.w() != null) {
                    StatisticItem param = new StatisticItem(aVar.w()).param("obj_locate", 1);
                    if (aVar.getType() == d.b.j0.f1.b.p.a.B) {
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
                    statisticItem.param("fname", aVar.j());
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
            if (ReplyMessageFragment.this.f18028f != null) {
                return new CustomResponsedMessage<>(2016322, Boolean.valueOf(ReplyMessageFragment.this.f18028f.R()));
            }
            return new CustomResponsedMessage<>(2016322, Boolean.FALSE);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements x {

        /* loaded from: classes4.dex */
        public class a implements b.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f18038a;

            public a(int i) {
                this.f18038a = i;
            }

            @Override // d.b.j0.f1.b.f.b.c
            public void a() {
                ReplyMessageFragment.this.f18028f.I(this.f18038a);
                ReplyMessageFragment.this.f18027e.t(this.f18038a);
            }
        }

        public g() {
        }

        @Override // d.b.c.j.e.x
        public boolean a(View view, d.b.c.j.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            if (nVar instanceof d.b.j0.f1.b.p.a) {
                d.b.j0.f1.b.p.a aVar = (d.b.j0.f1.b.p.a) nVar;
                d.b.j0.f1.b.f.a aVar2 = new d.b.j0.f1.b.f.a();
                aVar2.f56264a = 1;
                aVar2.f56265b = d.b.c.e.m.b.f(aVar.z(), 0L);
                aVar2.f56266c = d.b.c.e.m.b.f(aVar.t(), 0L);
                aVar2.f56267d = aVar.g() != null ? aVar.g().oriUgcNid : "";
                d.b.j0.f1.b.f.b bVar = new d.b.j0.f1.b.f.b(ReplyMessageFragment.this.getPageContext());
                bVar.g(aVar2);
                bVar.h(new a(i));
                bVar.i();
                return true;
            }
            return false;
        }
    }

    public void P0() {
        this.f18028f.b0(false);
    }

    public final void Q0(d.b.j0.f1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.z(), aVar.t(), "mention", false, aVar.v() == null ? "" : aVar.v().getUserName(), false, aVar.t(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.g());
        createSubPbActivityConfig.setHighLightPostId(aVar.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void R0(d.b.j0.f1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.z(), aVar.u(), "mention", false, aVar.v() == null ? "" : aVar.v().getUserName(), false, aVar.u(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.g());
        createSubPbActivityConfig.setHighLightPostId(aVar.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid(aVar.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void S0(d.b.j0.f1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.z(), aVar.t(), "mention", false, aVar.v() == null ? "" : aVar.v().getUserName(), false, aVar.t(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(aVar.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void T0(d.b.j0.f1.b.p.a aVar) {
        if (aVar == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(aVar.z(), aVar.t(), 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(aVar.g());
        createNormalCfg.setHighLightPostId(aVar.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void U0() {
        ReplyMeModelController replyMeModelController = this.f18027e;
        if (replyMeModelController != null) {
            replyMeModelController.w();
        }
    }

    public void V0(boolean z, ArrayList<d.b.c.j.e.n> arrayList) {
        if (this.f18028f != null) {
            hideLoadingView(this.f18029g);
            hideNetRefreshView(this.f18029g);
            this.f18028f.V(z, arrayList);
        }
    }

    public void W0() {
        ReplyMeModelController replyMeModelController = this.f18027e;
        if (replyMeModelController != null) {
            replyMeModelController.y();
        }
    }

    public final void X0() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f18028f.Q(i, i2, intent);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.f18030h != i) {
            this.f18030h = i;
            n nVar = this.f18028f;
            if (nVar != null) {
                nVar.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        registerListener(this.j);
        registerListener(this.k);
        X0();
        ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
        this.f18027e = replyMeModelController;
        replyMeModelController.v(bundle);
        this.f18027e.setUniqueId(getUniqueId());
        this.f18029g = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
        n nVar = new n(this);
        this.f18028f = nVar;
        nVar.S(this.f18029g);
        this.f18028f.Y(this.n);
        this.f18028f.X(this.o);
        if (TbadkCoreApplication.getInst().checkInterrupt()) {
            if (getActivity() instanceof MessageCenterActivity) {
                this.f18028f.b0(false);
                showLoadingView(this.f18029g);
                this.f18027e.u();
                this.i = true;
            }
        } else {
            this.f18028f.b0(false);
            showLoadingView(this.f18029g);
            this.f18027e.u();
        }
        registerListener(this.l);
        registerListener(this.m);
        return this.f18029g;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MessageManager.getInstance().unRegisterTask(2016322);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.k);
        MessageManager.getInstance().unRegisterListener(this.l);
        MessageManager.getInstance().unRegisterListener(this.m);
        n nVar = this.f18028f;
        if (nVar != null) {
            nVar.destroy();
        }
        ReplyMeModelController replyMeModelController = this.f18027e;
        if (replyMeModelController != null) {
            replyMeModelController.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        n nVar;
        super.onNetRefreshButtonClicked();
        if (!l.C() || (nVar = this.f18028f) == null) {
            return;
        }
        nVar.b0(true);
        W0();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        n nVar = this.f18028f;
        if (nVar != null) {
            nVar.R();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        n nVar = this.f18028f;
        if (nVar != null) {
            nVar.U();
        }
    }

    public void onServerError(ErrorData errorData) {
        hideLoadingView(this.f18029g);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        n nVar = this.f18028f;
        if (nVar != null) {
            nVar.onServerError(errorData);
        }
        n nVar2 = this.f18028f;
        if (nVar2 != null && nVar2.J() != null) {
            this.f18028f.J().setVisibility(8);
        }
        showNetRefreshView(this.f18029g, null, false);
    }
}
