package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.e.l.e.w;
import b.a.e.l.e.x;
import b.a.r0.m1.b.f.b;
import b.a.r0.m1.b.n;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ReplyMeModelController f50826e;

    /* renamed from: f  reason: collision with root package name */
    public n f50827f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f50828g;

    /* renamed from: h  reason: collision with root package name */
    public int f50829h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f50830i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public final CustomMessageListener l;
    public final CustomMessageListener m;
    public w n;
    public x o;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f50831a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReplyMessageFragment replyMessageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50831a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.f50831a.f50826e != null) {
                    ReplyMessageFragment replyMessageFragment = this.f50831a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.f50828g, true);
                    this.f50831a.f50826e.y();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f50832a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ReplyMessageFragment replyMessageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50832a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == this.f50832a.getPageContext().getUniqueId().getId()) {
                if (this.f50832a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.f50832a.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || this.f50832a.f50830i) {
                        if (this.f50832a.f50827f != null) {
                            this.f50832a.f50827f.Y(true);
                            return;
                        }
                        return;
                    }
                    this.f50832a.f50830i = true;
                    this.f50832a.f50827f.Y(true);
                    ReplyMessageFragment replyMessageFragment = this.f50832a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.f50828g);
                    this.f50832a.f50826e.y();
                    return;
                }
                this.f50832a.pullRefresh();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f50833a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ReplyMessageFragment replyMessageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50833a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && this.f50833a.f50827f != null) {
                this.f50833a.f50827f.S((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ReplyMessageFragment replyMessageFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            customResponsedMessage.getCmd();
        }
    }

    /* loaded from: classes9.dex */
    public class e implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f50834e;

        public e(ReplyMessageFragment replyMessageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50834e = replyMessageFragment;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.m1.b.p.a)) {
                b.a.r0.m1.b.p.a aVar = (b.a.r0.m1.b.p.a) nVar;
                if (aVar.D()) {
                    aVar.H(false);
                    if (this.f50834e.f50827f != null) {
                        this.f50834e.f50827f.O();
                    }
                }
                if (aVar.C()) {
                    if (aVar.E()) {
                        this.f50834e.m(aVar);
                    } else {
                        this.f50834e.l(aVar);
                    }
                } else if (aVar.E()) {
                    this.f50834e.n(aVar);
                } else {
                    this.f50834e.o(aVar);
                }
                if (aVar.x() != null) {
                    StatisticItem param = new StatisticItem(aVar.x()).param("obj_locate", 1);
                    if (aVar.getType() == b.a.r0.m1.b.p.a.B) {
                        param.param("obj_type", 1);
                    } else {
                        param.param("obj_type", 2);
                    }
                    TiebaStatic.log(param);
                }
                if (aVar != null) {
                    StatisticItem statisticItem = new StatisticItem("c13720");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", aVar.A());
                    statisticItem.param("fname", aVar.i());
                    statisticItem.param("obj_type", 3);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f50835e;

        public f(ReplyMessageFragment replyMessageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50835e = replyMessageFragment;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f50835e.f50827f != null) {
                    return new CustomResponsedMessage<>(2016322, Boolean.valueOf(this.f50835e.f50827f.Q()));
                }
                return new CustomResponsedMessage<>(2016322, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public class g implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f50836a;

        /* loaded from: classes9.dex */
        public class a implements b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f50837a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f50838b;

            public a(g gVar, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50838b = gVar;
                this.f50837a = i2;
            }

            @Override // b.a.r0.m1.b.f.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f50838b.f50836a.f50827f.B(this.f50837a);
                    this.f50838b.f50836a.f50826e.x(this.f50837a);
                }
            }
        }

        public g(ReplyMessageFragment replyMessageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50836a = replyMessageFragment;
        }

        @Override // b.a.e.l.e.x
        public boolean a(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (nVar instanceof b.a.r0.m1.b.p.a) {
                    b.a.r0.m1.b.p.a aVar = (b.a.r0.m1.b.p.a) nVar;
                    b.a.r0.m1.b.f.a aVar2 = new b.a.r0.m1.b.f.a();
                    aVar2.f21037a = 1;
                    aVar2.f21038b = b.a.e.e.m.b.g(aVar.A(), 0L);
                    aVar2.f21039c = b.a.e.e.m.b.g(aVar.q(), 0L);
                    aVar2.f21040d = aVar.g() != null ? aVar.g().oriUgcNid : "";
                    b.a.r0.m1.b.f.b bVar = new b.a.r0.m1.b.f.b(this.f50836a.getPageContext());
                    bVar.g(aVar2);
                    bVar.h(new a(this, i2));
                    bVar.i();
                    return true;
                }
                return false;
            }
            return invokeCommon.booleanValue;
        }
    }

    public ReplyMessageFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50829h = 3;
        this.j = new a(this, 2016321);
        this.k = new b(this, 2001628);
        this.l = new c(this, 2001120);
        this.m = new d(this, 2016010);
        this.n = new e(this);
        this.o = new g(this);
    }

    public void interruptRefreshing() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f50827f.Y(false);
        }
    }

    public final void l(b.a.r0.m1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.A(), aVar.q(), "mention", false, aVar.w() == null ? "" : aVar.w().getUserName(), false, aVar.q(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.g());
        createSubPbActivityConfig.setHighLightPostId(aVar.q());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void loadmore() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (replyMeModelController = this.f50826e) == null) {
            return;
        }
        replyMeModelController.A();
    }

    public final void m(b.a.r0.m1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.A(), aVar.t(), "mention", false, aVar.w() == null ? "" : aVar.w().getUserName(), false, aVar.t(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.g());
        createSubPbActivityConfig.setHighLightPostId(aVar.q());
        createSubPbActivityConfig.setKeyOriUgcTopPid(aVar.q());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void n(b.a.r0.m1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.A(), "", "mention", false, aVar.w() == null ? "" : aVar.w().getUserName(), false, aVar.q(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(aVar.q());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void o(b.a.r0.m1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) || aVar == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(aVar.A(), aVar.q(), 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(aVar.g());
        createNormalCfg.setHighLightPostId(aVar.q());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.f50827f.P(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.f50829h != i2) {
                this.f50829h = i2;
                n nVar = this.f50827f;
                if (nVar != null) {
                    nVar.onChangeSkinType(i2);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.j);
            registerListener(this.k);
            p();
            ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
            this.f50826e = replyMeModelController;
            replyMeModelController.z(bundle);
            this.f50826e.setUniqueId(getUniqueId());
            this.f50828g = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
            n nVar = new n(this);
            this.f50827f = nVar;
            nVar.R(this.f50828g);
            this.f50827f.X(this.n);
            this.f50827f.W(this.o);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.f50827f.Y(false);
                    showLoadingView(this.f50828g);
                    this.f50826e.y();
                    this.f50830i = true;
                }
            } else {
                this.f50827f.Y(false);
                showLoadingView(this.f50828g);
                this.f50826e.y();
            }
            registerListener(this.l);
            registerListener(this.m);
            return this.f50828g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2016322);
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.m);
            n nVar = this.f50827f;
            if (nVar != null) {
                nVar.destroy();
            }
            ReplyMeModelController replyMeModelController = this.f50826e;
            if (replyMeModelController != null) {
                replyMeModelController.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!l.D() || (nVar = this.f50827f) == null) {
                return;
            }
            nVar.Y(true);
            pullRefresh();
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void onNetworkChange(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPause();
            n nVar = this.f50827f;
            if (nVar != null) {
                nVar.Q();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onPrimary();
            n nVar = this.f50827f;
            if (nVar != null) {
                nVar.T();
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, errorData) == null) {
            hideLoadingView(this.f50828g);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            n nVar = this.f50827f;
            if (nVar != null) {
                nVar.onServerError(errorData);
            }
            n nVar2 = this.f50827f;
            if (nVar2 != null && nVar2.D() != null) {
                this.f50827f.D().setVisibility(8);
            }
            showNetRefreshView(this.f50828g, null, false);
        }
    }

    public void onViewDataChange(boolean z, ArrayList<b.a.e.l.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048591, this, z, arrayList) == null) || this.f50827f == null) {
            return;
        }
        hideLoadingView(this.f50828g);
        hideNetRefreshView(this.f50828g);
        this.f50827f.U(z, arrayList);
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void pullRefresh() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (replyMeModelController = this.f50826e) == null) {
            return;
        }
        replyMeModelController.C();
    }
}
