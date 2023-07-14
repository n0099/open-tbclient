package com.baidu.tieba.immessagecenter.mention;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.R;
import com.baidu.tieba.br8;
import com.baidu.tieba.er8;
import com.baidu.tieba.gr8;
import com.baidu.tieba.io;
import com.baidu.tieba.jo;
import com.baidu.tieba.oq8;
import com.baidu.tieba.pq8;
import com.baidu.tieba.qr8;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wg;
import com.baidu.tieba.xq8;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMeModelController a;
    public xq8 b;
    public ViewGroup c;
    public int d;
    public boolean e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public io j;
    public jo k;

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class g implements jo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* loaded from: classes6.dex */
        public class a implements pq8.c {
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

            @Override // com.baidu.tieba.pq8.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b.Z(this.a);
                    this.b.a.a.W(this.a);
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

        @Override // com.baidu.tieba.jo
        public boolean a(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            InterceptResult invokeCommon;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (!(ynVar instanceof br8)) {
                    return false;
                }
                br8 br8Var = (br8) ynVar;
                oq8 oq8Var = new oq8();
                oq8Var.a = 1;
                oq8Var.b = wg.g(br8Var.x(), 0L);
                oq8Var.c = wg.g(br8Var.n(), 0L);
                if (br8Var.getBaijiahaoData() != null) {
                    str = br8Var.getBaijiahaoData().oriUgcNid;
                } else {
                    str = "";
                }
                oq8Var.d = str;
                pq8 pq8Var = new pq8(this.a.getPageContext());
                pq8Var.h(oq8Var);
                pq8Var.i(new a(this, i));
                pq8Var.j();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.a.X();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                            this.a.b.s0(true);
                            return;
                        }
                        return;
                    }
                    this.a.e = true;
                    this.a.b.s0(true);
                    ReplyMessageFragment replyMessageFragment = this.a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.c);
                    this.a.a.X();
                    return;
                }
                this.a.c2();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.b.m0((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class e implements io {
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

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(ynVar instanceof br8)) {
                return;
            }
            br8 br8Var = (br8) ynVar;
            if (br8Var.z()) {
                br8Var.E(false);
                if (this.a.b != null) {
                    this.a.b.h0();
                }
            }
            if (!TextUtils.isEmpty(br8Var.getTargetScheme())) {
                UrlManager.getInstance().dealOneLink(br8Var.getTargetScheme());
            } else if (br8Var.isBjh()) {
                if (br8Var.B()) {
                    this.a.T1(br8Var);
                } else {
                    this.a.S1(br8Var);
                }
            } else if (br8Var.B()) {
                this.a.U1(br8Var);
            } else if (br8Var.getThreadType() == 40) {
                this.a.Y1(br8Var, true);
            } else {
                this.a.W1(br8Var);
            }
            qr8.a(br8Var, 11);
            if (br8Var != null) {
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", br8Var.x());
                statisticItem.param("fname", br8Var.d());
                statisticItem.param("obj_type", 3);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13784");
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem2);
        }
    }

    /* loaded from: classes6.dex */
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
                    return new CustomResponsedMessage<>(2016322, Boolean.valueOf(this.a.b.j0()));
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
            xq8 xq8Var = this.b;
            if (xq8Var != null) {
                xq8Var.a0();
            }
            ReplyMeModelController replyMeModelController = this.a;
            if (replyMeModelController != null) {
                replyMeModelController.onDestroy();
            }
        }
    }

    public void U1(br8 br8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, br8Var) == null) {
            V1(br8Var, null);
        }
    }

    public void W1(br8 br8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, br8Var) == null) {
            X1(br8Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.d != i) {
                this.d = i;
                xq8 xq8Var = this.b;
                if (xq8Var != null) {
                    xq8Var.onChangeSkinType(i);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.b.i0(i, i2, intent);
        }
    }

    public void Y1(br8 br8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, br8Var, z) == null) {
            Z1(br8Var, z, null);
        }
    }

    public void b2(boolean z, ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048587, this, z, arrayList) == null) && this.b != null) {
            hideLoadingView(this.c);
            hideNetRefreshView(this.c);
            this.b.o0(z, arrayList);
        }
    }

    @Nullable
    public String Q1() {
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

    public void R1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.s0(false);
        }
    }

    public void a2() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (replyMeModelController = this.a) != null) {
            replyMeModelController.Z();
        }
    }

    public void c2() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && (replyMeModelController = this.a) != null) {
            replyMeModelController.b0();
        }
    }

    public final void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void e2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            er8.B.b(Q1());
            gr8.C.b(Q1());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        xq8 xq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onNetRefreshButtonClicked();
            if (yi.G() && (xq8Var = this.b) != null) {
                xq8Var.s0(true);
                c2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            xq8 xq8Var = this.b;
            if (xq8Var != null) {
                xq8Var.j0();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            xq8 xq8Var = this.b;
            if (xq8Var != null) {
                xq8Var.n0();
            }
        }
    }

    public final void S1(br8 br8Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, br8Var) != null) || br8Var == null) {
            return;
        }
        if (br8Var.r() == null) {
            userName = "";
        } else {
            userName = br8Var.r().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(br8Var.x(), br8Var.n(), "mention", false, userName, false, br8Var.n(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(br8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(br8Var.n());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void T1(br8 br8Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, br8Var) != null) || br8Var == null) {
            return;
        }
        if (br8Var.r() == null) {
            userName = "";
        } else {
            userName = br8Var.r().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(br8Var.x(), br8Var.o(), "mention", false, userName, false, br8Var.o(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(br8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(br8Var.n());
        createSubPbActivityConfig.setKeyOriUgcTopPid(br8Var.n());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void V1(br8 br8Var, @Nullable String str) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048581, this, br8Var, str) != null) || br8Var == null) {
            return;
        }
        if (str == null) {
            str = br8Var.n();
        }
        if (br8Var.r() == null) {
            userName = "";
        } else {
            userName = br8Var.r().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(br8Var.x(), "", "mention", false, userName, false, str, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void X1(br8 br8Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048583, this, br8Var, str) != null) || br8Var == null) {
            return;
        }
        if (str == null) {
            str = br8Var.n();
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(br8Var.x(), str, 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(br8Var.getBaijiahaoData());
        createNormalCfg.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void Z1(br8 br8Var, boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{br8Var, Boolean.valueOf(z), str}) != null) || br8Var == null) {
            return;
        }
        if (str == null) {
            str = br8Var.n();
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = br8Var.x();
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
                    showToast(R.string.obfuscated_res_0x7f0f0a41);
                }
            }
            xq8 xq8Var = this.b;
            if (xq8Var != null) {
                xq8Var.f(errorData);
            }
            xq8 xq8Var2 = this.b;
            if (xq8Var2 != null && xq8Var2.c0() != null) {
                this.b.c0().setVisibility(8);
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
            d2();
            ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
            this.a = replyMeModelController;
            replyMeModelController.Y(bundle);
            this.a.setUniqueId(getUniqueId());
            e2();
            this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d085f, viewGroup, false);
            xq8 xq8Var = new xq8(this);
            this.b = xq8Var;
            xq8Var.k0(this.c);
            this.b.r0(this.j);
            this.b.q0(this.k);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.b.s0(false);
                    showLoadingView(this.c);
                    this.a.X();
                    this.e = true;
                }
            } else {
                this.b.s0(false);
                showLoadingView(this.c);
                this.a.X();
            }
            registerListener(this.h);
            registerListener(this.i);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
