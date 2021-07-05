package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
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
import d.a.c.e.p.l;
import d.a.c.k.e.w;
import d.a.c.k.e.x;
import d.a.s0.j1.b.f.b;
import d.a.s0.j1.b.n;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ReplyMeModelController f17880e;

    /* renamed from: f  reason: collision with root package name */
    public n f17881f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f17882g;

    /* renamed from: h  reason: collision with root package name */
    public int f17883h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f17884i;
    public CustomMessageListener j;
    public CustomMessageListener k;
    public final CustomMessageListener l;
    public final CustomMessageListener m;
    public w n;
    public x o;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f17885a;

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
            this.f17885a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.f17885a.f17880e != null) {
                    ReplyMessageFragment replyMessageFragment = this.f17885a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.f17882g, true);
                    this.f17885a.f17880e.y();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f17886a;

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
            this.f17886a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == this.f17886a.getPageContext().getUniqueId().getId()) {
                if (this.f17886a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.f17886a.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || this.f17886a.f17884i) {
                        if (this.f17886a.f17881f != null) {
                            this.f17886a.f17881f.Z(true);
                            return;
                        }
                        return;
                    }
                    this.f17886a.f17884i = true;
                    this.f17886a.f17881f.Z(true);
                    ReplyMessageFragment replyMessageFragment = this.f17886a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.f17882g);
                    this.f17886a.f17880e.y();
                    return;
                }
                this.f17886a.Y0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f17887a;

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
            this.f17887a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && this.f17887a.f17881f != null) {
                this.f17887a.f17881f.R((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f17888a;

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
            this.f17888a = replyMessageFragment;
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

    /* loaded from: classes5.dex */
    public class e implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f17889e;

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
            this.f17889e = replyMessageFragment;
        }

        @Override // d.a.c.k.e.w
        public void b(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof d.a.s0.j1.b.p.a)) {
                d.a.s0.j1.b.p.a aVar = (d.a.s0.j1.b.p.a) nVar;
                if (aVar.B()) {
                    aVar.F(false);
                    if (this.f17889e.f17881f != null) {
                        this.f17889e.f17881f.N();
                    }
                }
                if (aVar.A()) {
                    if (aVar.C()) {
                        this.f17889e.T0(aVar);
                    } else {
                        this.f17889e.S0(aVar);
                    }
                } else if (aVar.C()) {
                    this.f17889e.U0(aVar);
                } else {
                    this.f17889e.V0(aVar);
                }
                if (aVar.t() != null) {
                    StatisticItem param = new StatisticItem(aVar.t()).param("obj_locate", 1);
                    if (aVar.getType() == d.a.s0.j1.b.p.a.B) {
                        param.param("obj_type", 1);
                    } else {
                        param.param("obj_type", 2);
                    }
                    TiebaStatic.log(param);
                }
                if (aVar != null) {
                    StatisticItem statisticItem = new StatisticItem("c13720");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", aVar.y());
                    statisticItem.param("fname", aVar.d());
                    statisticItem.param("obj_type", 3);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f17890e;

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
            this.f17890e = replyMessageFragment;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.f17890e.f17881f != null) {
                    return new CustomResponsedMessage<>(2016322, Boolean.valueOf(this.f17890e.f17881f.P()));
                }
                return new CustomResponsedMessage<>(2016322, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements x {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ReplyMessageFragment f17891a;

        /* loaded from: classes5.dex */
        public class a implements b.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f17892a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ g f17893b;

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
                this.f17893b = gVar;
                this.f17892a = i2;
            }

            @Override // d.a.s0.j1.b.f.b.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.f17893b.f17891a.f17881f.G(this.f17892a);
                    this.f17893b.f17891a.f17880e.x(this.f17892a);
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
            this.f17891a = replyMessageFragment;
        }

        @Override // d.a.c.k.e.x
        public boolean a(View view, d.a.c.k.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
                if (nVar instanceof d.a.s0.j1.b.p.a) {
                    d.a.s0.j1.b.p.a aVar = (d.a.s0.j1.b.p.a) nVar;
                    d.a.s0.j1.b.f.a aVar2 = new d.a.s0.j1.b.f.a();
                    aVar2.f62222a = 1;
                    aVar2.f62223b = d.a.c.e.m.b.f(aVar.y(), 0L);
                    aVar2.f62224c = d.a.c.e.m.b.f(aVar.o(), 0L);
                    aVar2.f62225d = aVar.c() != null ? aVar.c().oriUgcNid : "";
                    d.a.s0.j1.b.f.b bVar = new d.a.s0.j1.b.f.b(this.f17891a.getPageContext());
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
        this.f17883h = 3;
        this.j = new a(this, 2016321);
        this.k = new b(this, 2001628);
        this.l = new c(this, 2001120);
        this.m = new d(this, 2016010);
        this.n = new e(this);
        this.o = new g(this);
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f17881f.Z(false);
        }
    }

    public final void S0(d.a.s0.j1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.y(), aVar.o(), "mention", false, aVar.q() == null ? "" : aVar.q().getUserName(), false, aVar.o(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.c());
        createSubPbActivityConfig.setHighLightPostId(aVar.o());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void T0(d.a.s0.j1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) || aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(aVar.y(), aVar.p(), "mention", false, aVar.q() == null ? "" : aVar.q().getUserName(), false, aVar.p(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(aVar.c());
        createSubPbActivityConfig.setHighLightPostId(aVar.o());
        createSubPbActivityConfig.setKeyOriUgcTopPid(aVar.o());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void U0(d.a.s0.j1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) || aVar == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(aVar.y(), "", "mention", false, aVar.q() == null ? "" : aVar.q().getUserName(), false, aVar.o(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(aVar.o());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void V0(d.a.s0.j1.b.p.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null) {
            return;
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(aVar.y(), aVar.o(), 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(aVar.c());
        createNormalCfg.setHighLightPostId(aVar.o());
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void W0() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (replyMeModelController = this.f17880e) == null) {
            return;
        }
        replyMeModelController.A();
    }

    public void X0(boolean z, ArrayList<d.a.c.k.e.n> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048582, this, z, arrayList) == null) || this.f17881f == null) {
            return;
        }
        hideLoadingView(this.f17882g);
        hideNetRefreshView(this.f17882g);
        this.f17881f.T(z, arrayList);
    }

    public void Y0() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (replyMeModelController = this.f17880e) == null) {
            return;
        }
        replyMeModelController.C();
    }

    public final void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            this.f17881f.O(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            super.onChangeSkinType(i2);
            if (this.f17883h != i2) {
                this.f17883h = i2;
                n nVar = this.f17881f;
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
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048588, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.j);
            registerListener(this.k);
            Z0();
            ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
            this.f17880e = replyMeModelController;
            replyMeModelController.z(bundle);
            this.f17880e.setUniqueId(getUniqueId());
            this.f17882g = (ViewGroup) layoutInflater.inflate(R.layout.reply_me_activity, viewGroup, false);
            n nVar = new n(this);
            this.f17881f = nVar;
            nVar.Q(this.f17882g);
            this.f17881f.Y(this.n);
            this.f17881f.X(this.o);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.f17881f.Z(false);
                    showLoadingView(this.f17882g);
                    this.f17880e.y();
                    this.f17884i = true;
                }
            } else {
                this.f17881f.Z(false);
                showLoadingView(this.f17882g);
                this.f17880e.y();
            }
            registerListener(this.l);
            registerListener(this.m);
            return this.f17882g;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2016322);
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.k);
            MessageManager.getInstance().unRegisterListener(this.l);
            MessageManager.getInstance().unRegisterListener(this.m);
            n nVar = this.f17881f;
            if (nVar != null) {
                nVar.destroy();
            }
            ReplyMeModelController replyMeModelController = this.f17880e;
            if (replyMeModelController != null) {
                replyMeModelController.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        n nVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!l.D() || (nVar = this.f17881f) == null) {
                return;
            }
            nVar.Z(true);
            Y0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            n nVar = this.f17881f;
            if (nVar != null) {
                nVar.P();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPrimary();
            n nVar = this.f17881f;
            if (nVar != null) {
                nVar.S();
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, errorData) == null) {
            hideLoadingView(this.f17882g);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            n nVar = this.f17881f;
            if (nVar != null) {
                nVar.onServerError(errorData);
            }
            n nVar2 = this.f17881f;
            if (nVar2 != null && nVar2.H() != null) {
                this.f17881f.H().setVisibility(8);
            }
            showNetRefreshView(this.f17882g, null, false);
        }
    }
}
