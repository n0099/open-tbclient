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
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h87;
import com.repackage.jg;
import com.repackage.jn;
import com.repackage.l87;
import com.repackage.li;
import com.repackage.o87;
import com.repackage.q87;
import com.repackage.tn;
import com.repackage.u87;
import com.repackage.un;
import com.repackage.y77;
import com.repackage.z77;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMeModelController a;
    public h87 b;
    public ViewGroup c;
    public int d;
    public boolean e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public tn j;
    public un k;

    /* loaded from: classes3.dex */
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
                    this.a.a.A();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                            this.a.b.b0(true);
                            return;
                        }
                        return;
                    }
                    this.a.e = true;
                    this.a.b.b0(true);
                    ReplyMessageFragment replyMessageFragment = this.a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.c);
                    this.a.a.A();
                    return;
                }
                this.a.Z0();
            }
        }
    }

    /* loaded from: classes3.dex */
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
                this.a.b.U((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements tn {
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

        @Override // com.repackage.tn
        public void b(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (jnVar instanceof l87)) {
                l87 l87Var = (l87) jnVar;
                if (l87Var.D()) {
                    l87Var.H(false);
                    if (this.a.b != null) {
                        this.a.b.P();
                    }
                }
                if (l87Var.isBjh()) {
                    if (l87Var.E()) {
                        this.a.Q0(l87Var);
                    } else {
                        this.a.P0(l87Var);
                    }
                } else if (l87Var.E()) {
                    this.a.R0(l87Var);
                } else if (l87Var.getThreadType() == 40) {
                    this.a.V0(l87Var, true);
                } else {
                    this.a.T0(l87Var);
                }
                u87.a(l87Var, 11);
                if (l87Var != null) {
                    StatisticItem statisticItem = new StatisticItem("c13720");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", l87Var.C());
                    statisticItem.param("fname", l87Var.e());
                    statisticItem.param("obj_type", 3);
                    TiebaStatic.log(statisticItem);
                }
                StatisticItem statisticItem2 = new StatisticItem("c13784");
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                    return new CustomResponsedMessage<>(2016322, Boolean.valueOf(this.a.b.R()));
                }
                return new CustomResponsedMessage<>(2016322, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements un {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* loaded from: classes3.dex */
        public class a implements z77.c {
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

            @Override // com.repackage.z77.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b.G(this.a);
                    this.b.a.a.z(this.a);
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

        @Override // com.repackage.un
        public boolean a(View view2, jn jnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, jnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (jnVar instanceof l87) {
                    l87 l87Var = (l87) jnVar;
                    y77 y77Var = new y77();
                    y77Var.a = 1;
                    y77Var.b = jg.g(l87Var.C(), 0L);
                    y77Var.c = jg.g(l87Var.r(), 0L);
                    y77Var.d = l87Var.getBaijiahaoData() != null ? l87Var.getBaijiahaoData().oriUgcNid : "";
                    z77 z77Var = new z77(this.a.getPageContext());
                    z77Var.g(y77Var);
                    z77Var.h(new a(this, i));
                    z77Var.i();
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

    @Nullable
    public String N0() {
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

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.b0(false);
        }
    }

    public final void P0(l87 l87Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l87Var) == null) || l87Var == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(l87Var.C(), l87Var.r(), "mention", false, l87Var.y() == null ? "" : l87Var.y().getUserName(), false, l87Var.r(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(l87Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(l87Var.r());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void Q0(l87 l87Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, l87Var) == null) || l87Var == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(l87Var.C(), l87Var.s(), "mention", false, l87Var.y() == null ? "" : l87Var.y().getUserName(), false, l87Var.s(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(l87Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(l87Var.r());
        createSubPbActivityConfig.setKeyOriUgcTopPid(l87Var.r());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void R0(l87 l87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, l87Var) == null) {
            S0(l87Var, null);
        }
    }

    public void S0(l87 l87Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, l87Var, str) == null) || l87Var == null) {
            return;
        }
        if (str == null) {
            str = l87Var.r();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(l87Var.C(), "", "mention", false, l87Var.y() == null ? "" : l87Var.y().getUserName(), false, str, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void T0(l87 l87Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, l87Var) == null) {
            U0(l87Var, null);
        }
    }

    public void U0(l87 l87Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, l87Var, str) == null) || l87Var == null) {
            return;
        }
        if (str == null) {
            str = l87Var.r();
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(l87Var.C(), str, 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(l87Var.getBaijiahaoData());
        createNormalCfg.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void V0(l87 l87Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, l87Var, z) == null) {
            W0(l87Var, z, null);
        }
    }

    public void W0(l87 l87Var, boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{l87Var, Boolean.valueOf(z), str}) == null) || l87Var == null) {
            return;
        }
        if (str == null) {
            str = l87Var.r();
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = l87Var.C();
        if (z) {
            videoItemData.highLightPostId = str;
        }
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(getContext(), arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE, z);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public void X0() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (replyMeModelController = this.a) == null) {
            return;
        }
        replyMeModelController.C();
    }

    public void Y0(boolean z, ArrayList<jn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048587, this, z, arrayList) == null) || this.b == null) {
            return;
        }
        hideLoadingView(this.c);
        hideNetRefreshView(this.c);
        this.b.W(z, arrayList);
    }

    public void Z0() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (replyMeModelController = this.a) == null) {
            return;
        }
        replyMeModelController.E();
    }

    public final void a1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void b1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            o87.B.b(N0());
            q87.C.b(N0());
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048592, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.b.Q(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.d != i) {
                this.d = i;
                h87 h87Var = this.b;
                if (h87Var != null) {
                    h87Var.onChangeSkinType(i);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.f);
            registerListener(this.g);
            a1();
            ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
            this.a = replyMeModelController;
            replyMeModelController.B(bundle);
            this.a.setUniqueId(getUniqueId());
            b1();
            this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d071b, viewGroup, false);
            h87 h87Var = new h87(this);
            this.b = h87Var;
            h87Var.T(this.c);
            this.b.a0(this.j);
            this.b.Z(this.k);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.b.b0(false);
                    showLoadingView(this.c);
                    this.a.A();
                    this.e = true;
                }
            } else {
                this.b.b0(false);
                showLoadingView(this.c);
                this.a.A();
            }
            registerListener(this.h);
            registerListener(this.i);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2016322);
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            h87 h87Var = this.b;
            if (h87Var != null) {
                h87Var.H();
            }
            ReplyMeModelController replyMeModelController = this.a;
            if (replyMeModelController != null) {
                replyMeModelController.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        h87 h87Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!li.D() || (h87Var = this.b) == null) {
                return;
            }
            h87Var.b0(true);
            Z0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPause();
            h87 h87Var = this.b;
            if (h87Var != null) {
                h87Var.R();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPrimary();
            h87 h87Var = this.b;
            if (h87Var != null) {
                h87Var.V();
            }
        }
    }

    public void onServerError(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f08af);
                }
            }
            h87 h87Var = this.b;
            if (h87Var != null) {
                h87Var.onServerError(errorData);
            }
            h87 h87Var2 = this.b;
            if (h87Var2 != null && h87Var2.K() != null) {
                this.b.K().setVisibility(8);
            }
            showNetRefreshView(this.c, null, false);
        }
    }
}
