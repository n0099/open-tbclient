package com.baidu.tieba.imMessageCenter.mention;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
import com.baidu.tieba.ag7;
import com.baidu.tieba.go;
import com.baidu.tieba.ho;
import com.baidu.tieba.jg7;
import com.baidu.tieba.lf7;
import com.baidu.tieba.nf7;
import com.baidu.tieba.of7;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wg;
import com.baidu.tieba.wn;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class AtMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMeModelController a;
    public lf7 b;
    public ViewGroup c;
    public of7 d;
    public int e;
    public boolean f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public final CustomMessageListener i;
    public final CustomMessageListener j;
    public go k;
    public ho l;

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        /* loaded from: classes4.dex */
        public class a implements of7.c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ f b;

            public a(f fVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = i;
            }

            @Override // com.baidu.tieba.of7.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b.P(this.a);
                    this.b.a.a.A(this.a);
                }
            }
        }

        public f(AtMessageFragment atMessageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atMessageFragment;
        }

        @Override // com.baidu.tieba.ho
        public boolean a(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            InterceptResult invokeCommon;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (!(wnVar instanceof ag7)) {
                    return false;
                }
                ag7 ag7Var = (ag7) wnVar;
                nf7 nf7Var = new nf7();
                nf7Var.a = 2;
                nf7Var.b = wg.g(ag7Var.D(), 0L);
                nf7Var.c = wg.g(ag7Var.t(), 0L);
                if (ag7Var.getBaijiahaoData() != null) {
                    str = ag7Var.getBaijiahaoData().oriUgcNid;
                } else {
                    str = "";
                }
                nf7Var.d = str;
                AtMessageFragment atMessageFragment = this.a;
                atMessageFragment.d = new of7(atMessageFragment.getPageContext());
                this.a.d.h(nf7Var);
                this.a.d.i(new a(this, i));
                this.a.d.j();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AtMessageFragment atMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageFragment, Integer.valueOf(i)};
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
            this.a = atMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016321 && (customResponsedMessage.getData() instanceof Intent)) {
                Intent intent = (Intent) customResponsedMessage.getData();
                if (this.a.a != null) {
                    AtMessageFragment atMessageFragment = this.a;
                    atMessageFragment.showLoadingView(atMessageFragment.c, true);
                    this.a.a.B();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(AtMessageFragment atMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageFragment, Integer.valueOf(i)};
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
            this.a = atMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            BdUniqueId bdUniqueId;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof BdUniqueId) && (bdUniqueId = (BdUniqueId) customResponsedMessage.getData()) != null && bdUniqueId.getId() == this.a.getPageContext().getUniqueId().getId()) {
                if (this.a.isVisible() && TbadkCoreApplication.getInst().getCurrentActivity() == this.a.getActivity()) {
                    if (!TbadkCoreApplication.getInst().checkInterrupt() || this.a.f) {
                        if (this.a.b != null) {
                            this.a.b.g0(true);
                            return;
                        }
                        return;
                    }
                    this.a.f = true;
                    this.a.b.g0(true);
                    AtMessageFragment atMessageFragment = this.a;
                    atMessageFragment.showLoadingView(atMessageFragment.c);
                    this.a.a.B();
                    return;
                }
                this.a.N1();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AtMessageFragment atMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageFragment, Integer.valueOf(i)};
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
            this.a = atMessageFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && this.a.b != null) {
                this.a.b.Z((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AtMessageFragment atMessageFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageFragment, Integer.valueOf(i)};
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
            this.a = atMessageFragment;
        }
    }

    /* loaded from: classes4.dex */
    public class e implements go {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        public e(AtMessageFragment atMessageFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atMessageFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atMessageFragment;
        }

        @Override // com.baidu.tieba.go
        public void b(View view2, wn wnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, wnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(wnVar instanceof ag7)) {
                return;
            }
            ag7 ag7Var = (ag7) wnVar;
            if (ag7Var.E()) {
                ag7Var.J(false);
                if (this.a.b != null) {
                    this.a.b.W();
                }
            }
            if (ag7Var.isBjh()) {
                if (ag7Var.G()) {
                    this.a.E1(ag7Var);
                } else {
                    this.a.D1(ag7Var);
                }
            } else if (ag7Var.G()) {
                this.a.F1(ag7Var);
            } else if (ag7Var.getThreadType() == 40) {
                this.a.J1(ag7Var, true);
            } else {
                this.a.H1(ag7Var);
            }
            jg7.a(ag7Var, 11);
            if (ag7Var != null) {
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", ag7Var.D());
                statisticItem.param("fname", ag7Var.c());
                statisticItem.param("obj_type", 3);
                TiebaStatic.log(statisticItem);
            }
            StatisticItem statisticItem2 = new StatisticItem("c13784");
            statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(statisticItem2);
        }
    }

    public AtMessageFragment() {
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
        this.e = 3;
        this.g = new a(this, 2016321);
        this.h = new b(this, 2001628);
        this.i = new c(this, 2001120);
        this.j = new d(this, 2016010);
        this.k = new e(this);
        this.l = new f(this);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2016322);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.j);
            lf7 lf7Var = this.b;
            if (lf7Var != null) {
                lf7Var.Q();
            }
            AtMeModelController atMeModelController = this.a;
            if (atMeModelController != null) {
                atMeModelController.onDestroy();
            }
            of7 of7Var = this.d;
            if (of7Var != null) {
                of7Var.d();
                this.d = null;
            }
        }
    }

    public void F1(ag7 ag7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ag7Var) == null) {
            G1(ag7Var, null);
        }
    }

    public void H1(ag7 ag7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ag7Var) == null) {
            I1(ag7Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.e != i) {
                this.e = i;
                lf7 lf7Var = this.b;
                if (lf7Var != null) {
                    lf7Var.onChangeSkinType(i);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            of7 of7Var = this.d;
            if (of7Var != null) {
                of7Var.f();
            }
        }
    }

    public void J1(ag7 ag7Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, ag7Var, z) == null) {
            K1(ag7Var, z, null);
        }
    }

    public void M1(boolean z, ArrayList<wn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z, arrayList) == null) && this.b != null) {
            hideLoadingView(this.c);
            hideNetRefreshView(this.c);
            this.b.b0(z, arrayList);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.b.X(i, i2, intent);
        }
    }

    public void C1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.g0(false);
        }
    }

    public void L1() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (atMeModelController = this.a) != null) {
            atMeModelController.D();
        }
    }

    public void N1() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (atMeModelController = this.a) != null) {
            atMeModelController.F();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        lf7 lf7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onNetRefreshButtonClicked();
            if (xi.F() && (lf7Var = this.b) != null) {
                lf7Var.g0(true);
                N1();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            super.onPrimary();
            lf7 lf7Var = this.b;
            if (lf7Var != null) {
                lf7Var.a0();
            }
        }
    }

    public final void D1(ag7 ag7Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ag7Var) != null) || ag7Var == null) {
            return;
        }
        if (ag7Var.A() == null) {
            userName = "";
        } else {
            userName = ag7Var.A().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(ag7Var.D(), ag7Var.t(), "mention", false, userName, false, ag7Var.t(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(ag7Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(ag7Var.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void E1(ag7 ag7Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ag7Var) != null) || ag7Var == null) {
            return;
        }
        if (ag7Var.A() == null) {
            userName = "";
        } else {
            userName = ag7Var.A().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(ag7Var.D(), ag7Var.w(), "mention", false, userName, false, ag7Var.w(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(ag7Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(ag7Var.t());
        createSubPbActivityConfig.setKeyOriUgcTopPid(ag7Var.t());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void G1(ag7 ag7Var, @Nullable String str) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, ag7Var, str) != null) || ag7Var == null) {
            return;
        }
        if (str == null) {
            str = ag7Var.t();
        }
        if (ag7Var.A() == null) {
            userName = "";
        } else {
            userName = ag7Var.A().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(ag7Var.D(), "", "mention", false, userName, false, str, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void I1(ag7 ag7Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, ag7Var, str) != null) || ag7Var == null) {
            return;
        }
        if (str == null) {
            str = ag7Var.t();
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(ag7Var.D(), str, 1, "mention");
        createNormalCfg.setStartFrom(13);
        createNormalCfg.setBjhData(ag7Var.getBaijiahaoData());
        createNormalCfg.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void K1(ag7 ag7Var, boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{ag7Var, Boolean.valueOf(z), str}) != null) || ag7Var == null) {
            return;
        }
        if (str == null) {
            str = ag7Var.t();
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = ag7Var.D();
        if (z) {
            videoItemData.highLightPostId = str;
        }
        arrayList.add(videoItemData);
        VideoRecommentPlayActivityConfig videoRecommentPlayActivityConfig = new VideoRecommentPlayActivityConfig(getContext(), arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_AT_PAGE, z);
        videoRecommentPlayActivityConfig.setParamIsVertail(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoRecommentPlayActivityConfig));
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.im_error_default);
                }
            }
            lf7 lf7Var = this.b;
            if (lf7Var != null) {
                lf7Var.f(errorData);
            }
            lf7 lf7Var2 = this.b;
            if (lf7Var2 != null && lf7Var2.R() != null) {
                this.b.R().setVisibility(8);
            }
            showNetRefreshView(this.c, null, false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048593, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.g);
            registerListener(this.h);
            AtMeModelController atMeModelController = new AtMeModelController(this);
            this.a = atMeModelController;
            atMeModelController.C(bundle);
            this.a.setUniqueId(getUniqueId());
            this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0126, viewGroup, false);
            lf7 lf7Var = new lf7(this);
            this.b = lf7Var;
            lf7Var.Y(this.c);
            this.b.f0(this.k);
            this.b.e0(this.l);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.b.g0(false);
                    showLoadingView(this.c);
                    this.a.B();
                    this.f = true;
                }
            } else {
                this.b.g0(false);
                showLoadingView(this.c);
                this.a.B();
            }
            registerListener(this.i);
            registerListener(this.j);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
