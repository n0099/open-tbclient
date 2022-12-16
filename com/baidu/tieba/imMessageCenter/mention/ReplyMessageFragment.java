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
import com.baidu.tbadk.core.atomData.VideoRecommentPlayActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.fj7;
import com.baidu.tieba.ho;
import com.baidu.tieba.io;
import com.baidu.tieba.jj7;
import com.baidu.tieba.mj7;
import com.baidu.tieba.oj7;
import com.baidu.tieba.sj7;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wi7;
import com.baidu.tieba.xg;
import com.baidu.tieba.xi7;
import com.baidu.tieba.xn;
import com.baidu.tieba.yi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMeModelController a;
    public fj7 b;
    public ViewGroup c;
    public int d;
    public boolean e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public ho j;
    public io k;

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class g implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* loaded from: classes4.dex */
        public class a implements xi7.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ g b;

            public a(g gVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = i;
            }

            @Override // com.baidu.tieba.xi7.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b.L(this.a);
                    this.b.a.a.H(this.a);
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyMessageFragment;
        }

        @Override // com.baidu.tieba.io
        public boolean a(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            InterceptResult invokeCommon;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (!(xnVar instanceof jj7)) {
                    return false;
                }
                jj7 jj7Var = (jj7) xnVar;
                wi7 wi7Var = new wi7();
                wi7Var.a = 1;
                wi7Var.b = xg.g(jj7Var.z(), 0L);
                wi7Var.c = xg.g(jj7Var.q(), 0L);
                if (jj7Var.getBaijiahaoData() != null) {
                    str = jj7Var.getBaijiahaoData().oriUgcNid;
                } else {
                    str = "";
                }
                wi7Var.d = str;
                xi7 xi7Var = new xi7(this.a.getPageContext());
                xi7Var.h(wi7Var);
                xi7Var.i(new a(this, i));
                xi7Var.j();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ReplyMessageFragment replyMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.a.a != null) {
                    ReplyMessageFragment replyMessageFragment = this.a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.c, true);
                    this.a.a.I();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ReplyMessageFragment replyMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == this.a.getPageContext().getUniqueId().getId()) {
                if (this.a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.a.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || this.a.e) {
                        if (this.a.b != null) {
                            this.a.b.e0(true);
                            return;
                        }
                        return;
                    }
                    this.a.e = true;
                    this.a.b.e0(true);
                    ReplyMessageFragment replyMessageFragment = this.a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.c);
                    this.a.a.I();
                    return;
                }
                this.a.S1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ReplyMessageFragment replyMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && this.a.b != null) {
                this.a.b.X((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ReplyMessageFragment replyMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyMessageFragment;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        public e(ReplyMessageFragment replyMessageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyMessageFragment;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(xnVar instanceof jj7)) {
                return;
            }
            jj7 jj7Var = (jj7) xnVar;
            if (jj7Var.C()) {
                jj7Var.J(false);
                if (this.a.b != null) {
                    this.a.b.T();
                }
            }
            if (jj7Var.isBjh()) {
                if (jj7Var.G()) {
                    this.a.J1(jj7Var);
                } else {
                    this.a.I1(jj7Var);
                }
            } else if (jj7Var.G()) {
                this.a.K1(jj7Var);
            } else if (jj7Var.getThreadType() == 40) {
                this.a.O1(jj7Var, true);
            } else {
                this.a.M1(jj7Var);
            }
            sj7.a(jj7Var, 11);
            if (jj7Var != null) {
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", jj7Var.z());
                statisticItem.param("fname", jj7Var.c());
                statisticItem.param("obj_type", 3);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13784");
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes4.dex */
    public class f implements CustomMessageTask.CustomRunnable<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        public f(ReplyMessageFragment replyMessageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {replyMessageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = replyMessageFragment;
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Boolean> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (this.a.b != null) {
                    return new CustomResponsedMessage<>(2016322, Boolean.valueOf(this.a.b.V()));
                }
                return new CustomResponsedMessage<>(2016322, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    public ReplyMessageFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 3;
        this.f = new a(this, 2016321);
        this.g = new b(this, 2001628);
        this.h = new c(this, 2001120);
        this.i = new d(this, 2016010);
        this.j = new e(this);
        this.k = new g(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2016322);
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            fj7 fj7Var = this.b;
            if (fj7Var != null) {
                fj7Var.M();
            }
            ReplyMeModelController replyMeModelController = this.a;
            if (replyMeModelController != null) {
                replyMeModelController.onDestroy();
            }
        }
    }

    public void K1(jj7 jj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, jj7Var) == null) {
            L1(jj7Var, null);
        }
    }

    public void M1(jj7 jj7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jj7Var) == null) {
            N1(jj7Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.d != i) {
                this.d = i;
                fj7 fj7Var = this.b;
                if (fj7Var != null) {
                    fj7Var.onChangeSkinType(i);
                }
            }
        }
    }

    public void O1(jj7 jj7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, jj7Var, z) == null) {
            P1(jj7Var, z, null);
        }
    }

    public void R1(boolean z, ArrayList<xn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048587, this, z, arrayList) == null) && this.b != null) {
            hideLoadingView(this.c);
            hideNetRefreshView(this.c);
            this.b.Z(z, arrayList);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.b.U(i, i2, intent);
        }
    }

    @Nullable
    public String G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                return null;
            }
            return arguments.getString("high_light_post_id", null);
        }
        return (String) invokeV.objValue;
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.e0(false);
        }
    }

    public void Q1() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (replyMeModelController = this.a) != null) {
            replyMeModelController.K();
        }
    }

    public void S1() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (replyMeModelController = this.a) != null) {
            replyMeModelController.M();
        }
    }

    public final void T1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            mj7.B.b(G1());
            oj7.C.b(G1());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        fj7 fj7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onNetRefreshButtonClicked();
            if (yi.F() && (fj7Var = this.b) != null) {
                fj7Var.e0(true);
                S1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            fj7 fj7Var = this.b;
            if (fj7Var != null) {
                fj7Var.V();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            fj7 fj7Var = this.b;
            if (fj7Var != null) {
                fj7Var.Y();
            }
        }
    }

    public final void I1(jj7 jj7Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jj7Var) != null) || jj7Var == null) {
            return;
        }
        if (jj7Var.v() == null) {
            userName = "";
        } else {
            userName = jj7Var.v().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(jj7Var.z(), jj7Var.q(), "mention", false, userName, false, jj7Var.q(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(jj7Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(jj7Var.q());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void J1(jj7 jj7Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, jj7Var) != null) || jj7Var == null) {
            return;
        }
        if (jj7Var.v() == null) {
            userName = "";
        } else {
            userName = jj7Var.v().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(jj7Var.z(), jj7Var.r(), "mention", false, userName, false, jj7Var.r(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(jj7Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(jj7Var.q());
        createSubPbActivityConfig.setKeyOriUgcTopPid(jj7Var.q());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void L1(jj7 jj7Var, @Nullable String str) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, jj7Var, str) != null) || jj7Var == null) {
            return;
        }
        if (str == null) {
            str = jj7Var.q();
        }
        if (jj7Var.v() == null) {
            userName = "";
        } else {
            userName = jj7Var.v().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(jj7Var.z(), "", "mention", false, userName, false, str, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void N1(jj7 jj7Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, jj7Var, str) != null) || jj7Var == null) {
            return;
        }
        if (str == null) {
            str = jj7Var.q();
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(jj7Var.z(), str, 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(jj7Var.getBaijiahaoData());
        createNormalCfg.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void P1(jj7 jj7Var, boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{jj7Var, Boolean.valueOf(z), str}) != null) || jj7Var == null) {
            return;
        }
        if (str == null) {
            str = jj7Var.q();
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = jj7Var.z();
        if (z) {
            videoItemData.highLightPostId = str;
        }
        arrayList.add(videoItemData);
        new VideoRecommentPlayActivityConfig(getContext(), arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE, z).start();
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f0915);
                }
            }
            fj7 fj7Var = this.b;
            if (fj7Var != null) {
                fj7Var.f(errorData);
            }
            fj7 fj7Var2 = this.b;
            if (fj7Var2 != null && fj7Var2.O() != null) {
                this.b.O().setVisibility(8);
            }
            showNetRefreshView(this.c, null, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048595, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.f);
            registerListener(this.g);
            T1();
            ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
            this.a = replyMeModelController;
            replyMeModelController.J(bundle);
            this.a.setUniqueId(getUniqueId());
            U1();
            this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d07b1, viewGroup, false);
            fj7 fj7Var = new fj7(this);
            this.b = fj7Var;
            fj7Var.W(this.c);
            this.b.d0(this.j);
            this.b.c0(this.k);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.b.e0(false);
                    showLoadingView(this.c);
                    this.a.I();
                    this.e = true;
                }
            } else {
                this.b.e0(false);
                showLoadingView(this.c);
                this.a.I();
            }
            registerListener(this.h);
            registerListener(this.i);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
