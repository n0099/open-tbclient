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
import com.repackage.ba7;
import com.repackage.ca7;
import com.repackage.ka7;
import com.repackage.ng;
import com.repackage.nn;
import com.repackage.oa7;
import com.repackage.pi;
import com.repackage.ra7;
import com.repackage.ta7;
import com.repackage.xa7;
import com.repackage.xn;
import com.repackage.yn;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ReplyMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ReplyMeModelController a;
    public ka7 b;
    public ViewGroup c;
    public int d;
    public boolean e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public final CustomMessageListener h;
    public final CustomMessageListener i;
    public xn j;
    public yn k;

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
                    this.a.a.C();
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
                            this.a.b.d0(true);
                            return;
                        }
                        return;
                    }
                    this.a.e = true;
                    this.a.b.d0(true);
                    ReplyMessageFragment replyMessageFragment = this.a;
                    replyMessageFragment.showLoadingView(replyMessageFragment.c);
                    this.a.a.C();
                    return;
                }
                this.a.O1();
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
                this.a.b.V((NewsNotifyMessage) customResponsedMessage);
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
    public class e implements xn {
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

        @Override // com.repackage.xn
        public void b(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nnVar instanceof oa7)) {
                oa7 oa7Var = (oa7) nnVar;
                if (oa7Var.F()) {
                    oa7Var.J(false);
                    if (this.a.b != null) {
                        this.a.b.R();
                    }
                }
                if (oa7Var.isBjh()) {
                    if (oa7Var.G()) {
                        this.a.F1(oa7Var);
                    } else {
                        this.a.E1(oa7Var);
                    }
                } else if (oa7Var.G()) {
                    this.a.G1(oa7Var);
                } else if (oa7Var.getThreadType() == 40) {
                    this.a.K1(oa7Var, true);
                } else {
                    this.a.I1(oa7Var);
                }
                xa7.a(oa7Var, 11);
                if (oa7Var != null) {
                    StatisticItem statisticItem = new StatisticItem("c13720");
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("tid", oa7Var.E());
                    statisticItem.param("fname", oa7Var.c());
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
                    return new CustomResponsedMessage<>(2016322, Boolean.valueOf(this.a.b.T()));
                }
                return new CustomResponsedMessage<>(2016322, Boolean.FALSE);
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class g implements yn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ReplyMessageFragment a;

        /* loaded from: classes3.dex */
        public class a implements ca7.c {
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

            @Override // com.repackage.ca7.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b.I(this.a);
                    this.b.a.a.B(this.a);
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

        @Override // com.repackage.yn
        public boolean a(View view2, nn nnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, nnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (nnVar instanceof oa7) {
                    oa7 oa7Var = (oa7) nnVar;
                    ba7 ba7Var = new ba7();
                    ba7Var.a = 1;
                    ba7Var.b = ng.g(oa7Var.E(), 0L);
                    ba7Var.c = ng.g(oa7Var.t(), 0L);
                    ba7Var.d = oa7Var.getBaijiahaoData() != null ? oa7Var.getBaijiahaoData().oriUgcNid : "";
                    ca7 ca7Var = new ca7(this.a.getPageContext());
                    ca7Var.g(ba7Var);
                    ca7Var.h(new a(this, i));
                    ca7Var.i();
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
    public String C1() {
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

    public void D1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.d0(false);
        }
    }

    public final void E1(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, oa7Var) == null) || oa7Var == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(oa7Var.E(), oa7Var.t(), "mention", false, oa7Var.A() == null ? "" : oa7Var.A().getUserName(), false, oa7Var.t(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(oa7Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(oa7Var.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void F1(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, oa7Var) == null) || oa7Var == null) {
            return;
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(oa7Var.E(), oa7Var.u(), "mention", false, oa7Var.A() == null ? "" : oa7Var.A().getUserName(), false, oa7Var.u(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setBjhData(oa7Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(oa7Var.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid(oa7Var.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void G1(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oa7Var) == null) {
            H1(oa7Var, null);
        }
    }

    public void H1(oa7 oa7Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, oa7Var, str) == null) || oa7Var == null) {
            return;
        }
        if (str == null) {
            str = oa7Var.t();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(oa7Var.E(), "", "mention", false, oa7Var.A() == null ? "" : oa7Var.A().getUserName(), false, str, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(12);
        createSubPbActivityConfig.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void I1(oa7 oa7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, oa7Var) == null) {
            J1(oa7Var, null);
        }
    }

    public void J1(oa7 oa7Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048583, this, oa7Var, str) == null) || oa7Var == null) {
            return;
        }
        if (str == null) {
            str = oa7Var.t();
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(oa7Var.E(), str, 1, "mention");
        createNormalCfg.setStartFrom(12);
        createNormalCfg.setBjhData(oa7Var.getBaijiahaoData());
        createNormalCfg.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void K1(oa7 oa7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, oa7Var, z) == null) {
            L1(oa7Var, z, null);
        }
    }

    public void L1(oa7 oa7Var, boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{oa7Var, Boolean.valueOf(z), str}) == null) || oa7Var == null) {
            return;
        }
        if (str == null) {
            str = oa7Var.t();
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = oa7Var.E();
        if (z) {
            videoItemData.highLightPostId = str;
        }
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(getContext(), arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_REPLY_PAGE, z);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public void M1() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (replyMeModelController = this.a) == null) {
            return;
        }
        replyMeModelController.E();
    }

    public void N1(boolean z, ArrayList<nn> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(1048587, this, z, arrayList) == null) || this.b == null) {
            return;
        }
        hideLoadingView(this.c);
        hideNetRefreshView(this.c);
        this.b.X(z, arrayList);
    }

    public void O1() {
        ReplyMeModelController replyMeModelController;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (replyMeModelController = this.a) == null) {
            return;
        }
        replyMeModelController.G();
    }

    public final void P1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2016322, new f(this));
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            ra7.B.b(C1());
            ta7.C.b(C1());
        }
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f08bb);
                }
            }
            ka7 ka7Var = this.b;
            if (ka7Var != null) {
                ka7Var.f(errorData);
            }
            ka7 ka7Var2 = this.b;
            if (ka7Var2 != null && ka7Var2.M() != null) {
                this.b.M().setVisibility(8);
            }
            showNetRefreshView(this.c, null, false);
        }
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048593, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.b.S(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.d != i) {
                this.d = i;
                ka7 ka7Var = this.b;
                if (ka7Var != null) {
                    ka7Var.onChangeSkinType(i);
                }
            }
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
            P1();
            ReplyMeModelController replyMeModelController = new ReplyMeModelController(this);
            this.a = replyMeModelController;
            replyMeModelController.D(bundle);
            this.a.setUniqueId(getUniqueId());
            Q1();
            this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0737, viewGroup, false);
            ka7 ka7Var = new ka7(this);
            this.b = ka7Var;
            ka7Var.U(this.c);
            this.b.b0(this.j);
            this.b.a0(this.k);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.b.d0(false);
                    showLoadingView(this.c);
                    this.a.C();
                    this.e = true;
                }
            } else {
                this.b.d0(false);
                showLoadingView(this.c);
                this.a.C();
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
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2016322);
            MessageManager.getInstance().unRegisterListener(this.f);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            ka7 ka7Var = this.b;
            if (ka7Var != null) {
                ka7Var.J();
            }
            ReplyMeModelController replyMeModelController = this.a;
            if (replyMeModelController != null) {
                replyMeModelController.onDestroy();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        ka7 ka7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onNetRefreshButtonClicked();
            if (!pi.D() || (ka7Var = this.b) == null) {
                return;
            }
            ka7Var.d0(true);
            O1();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            super.onPause();
            ka7 ka7Var = this.b;
            if (ka7Var != null) {
                ka7Var.T();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            super.onPrimary();
            ka7 ka7Var = this.b;
            if (ka7Var != null) {
                ka7Var.W();
            }
        }
    }
}
