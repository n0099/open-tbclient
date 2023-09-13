package com.baidu.tieba.immessagecenter.mention;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
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
import com.baidu.tieba.cn;
import com.baidu.tieba.it8;
import com.baidu.tieba.kt8;
import com.baidu.tieba.lt8;
import com.baidu.tieba.mn;
import com.baidu.tieba.mu8;
import com.baidu.tieba.nn;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.xt8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class AtMessageFragment extends BaseFragment implements NoNetworkView.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AtMeModelController a;
    public it8 b;
    public ViewGroup c;
    public lt8 d;
    public int e;
    public boolean f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public final CustomMessageListener i;
    public final CustomMessageListener j;
    public mn k;
    public nn l;

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class f implements nn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        /* loaded from: classes6.dex */
        public class a implements lt8.c {
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

            @Override // com.baidu.tieba.lt8.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b.c0(this.a);
                    this.b.a.a.N(this.a);
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

        @Override // com.baidu.tieba.nn
        public boolean a(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            InterceptResult invokeCommon;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)})) == null) {
                if (!(cnVar instanceof xt8)) {
                    return false;
                }
                xt8 xt8Var = (xt8) cnVar;
                kt8 kt8Var = new kt8();
                kt8Var.a = 2;
                kt8Var.b = JavaTypesHelper.toLong(xt8Var.v(), 0L);
                kt8Var.c = JavaTypesHelper.toLong(xt8Var.o(), 0L);
                if (xt8Var.getBaijiahaoData() != null) {
                    str = xt8Var.getBaijiahaoData().oriUgcNid;
                } else {
                    str = "";
                }
                kt8Var.d = str;
                AtMessageFragment atMessageFragment = this.a;
                atMessageFragment.d = new lt8(atMessageFragment.getPageContext());
                this.a.d.h(kt8Var);
                this.a.d.i(new a(this, i));
                this.a.d.j();
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                    this.a.a.O();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
                            this.a.b.q0(true);
                            return;
                        }
                        return;
                    }
                    this.a.f = true;
                    this.a.b.q0(true);
                    AtMessageFragment atMessageFragment = this.a;
                    atMessageFragment.showLoadingView(atMessageFragment.c);
                    this.a.a.O();
                    return;
                }
                this.a.s2();
            }
        }
    }

    /* loaded from: classes6.dex */
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
                this.a.b.l0((NewsNotifyMessage) customResponsedMessage);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public class e implements mn {
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

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(cnVar instanceof xt8)) {
                return;
            }
            xt8 xt8Var = (xt8) cnVar;
            if (xt8Var.y()) {
                xt8Var.E(false);
                if (this.a.b != null) {
                    this.a.b.i0();
                }
            }
            if (!TextUtils.isEmpty(xt8Var.getTargetScheme())) {
                UrlManager.getInstance().dealOneLink(xt8Var.getTargetScheme());
            } else if (xt8Var.isBjh()) {
                if (xt8Var.B()) {
                    this.a.j2(xt8Var);
                } else {
                    this.a.i2(xt8Var);
                }
            } else if (xt8Var.B()) {
                this.a.k2(xt8Var);
            } else if (xt8Var.getThreadType() == 40) {
                this.a.o2(xt8Var, true);
            } else {
                this.a.m2(xt8Var);
            }
            mu8.a(xt8Var, 11);
            if (xt8Var != null) {
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", xt8Var.v());
                statisticItem.param("fname", xt8Var.d());
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
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            super.onDestroy();
            MessageManager.getInstance().unRegisterTask(2016322);
            MessageManager.getInstance().unRegisterListener(this.g);
            MessageManager.getInstance().unRegisterListener(this.h);
            MessageManager.getInstance().unRegisterListener(this.i);
            MessageManager.getInstance().unRegisterListener(this.j);
            it8 it8Var = this.b;
            if (it8Var != null) {
                it8Var.destroy();
            }
            AtMeModelController atMeModelController = this.a;
            if (atMeModelController != null) {
                atMeModelController.onDestroy();
            }
            lt8 lt8Var = this.d;
            if (lt8Var != null) {
                lt8Var.d();
                this.d = null;
            }
        }
    }

    public void k2(xt8 xt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xt8Var) == null) {
            l2(xt8Var, null);
        }
    }

    public void m2(xt8 xt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, xt8Var) == null) {
            n2(xt8Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.e != i) {
                this.e = i;
                it8 it8Var = this.b;
                if (it8Var != null) {
                    it8Var.onChangeSkinType(i);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            lt8 lt8Var = this.d;
            if (lt8Var != null) {
                lt8Var.f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048586, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.b.j0(i, i2, intent);
        }
    }

    public void o2(xt8 xt8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, xt8Var, z) == null) {
            p2(xt8Var, z, null);
        }
    }

    public void r2(boolean z, ArrayList<cn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048596, this, z, arrayList) == null) && this.b != null) {
            hideLoadingView(this.c);
            hideNetRefreshView(this.c);
            this.b.n0(z, arrayList);
        }
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f0a50);
                }
            }
            it8 it8Var = this.b;
            if (it8Var != null) {
                it8Var.f(errorData);
            }
            it8 it8Var2 = this.b;
            if (it8Var2 != null && it8Var2.d0() != null) {
                this.b.d0().setVisibility(8);
            }
            showNetRefreshView(this.c, null, false);
        }
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.b.q0(false);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        it8 it8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onNetRefreshButtonClicked();
            if (BdUtilHelper.isNetOk() && (it8Var = this.b) != null) {
                it8Var.q0(true);
                s2();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onPrimary();
            it8 it8Var = this.b;
            if (it8Var != null) {
                it8Var.m0();
            }
        }
    }

    public void q2() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (atMeModelController = this.a) != null) {
            atMeModelController.Q();
        }
    }

    public void s2() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (atMeModelController = this.a) != null) {
            atMeModelController.S();
        }
    }

    public final void i2(xt8 xt8Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, xt8Var) != null) || xt8Var == null) {
            return;
        }
        if (xt8Var.s() == null) {
            userName = "";
        } else {
            userName = xt8Var.s().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(xt8Var.v(), xt8Var.o(), "mention", false, userName, false, xt8Var.o(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(xt8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(xt8Var.o());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void j2(xt8 xt8Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, xt8Var) != null) || xt8Var == null) {
            return;
        }
        if (xt8Var.s() == null) {
            userName = "";
        } else {
            userName = xt8Var.s().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(xt8Var.v(), xt8Var.p(), "mention", false, userName, false, xt8Var.p(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(xt8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(xt8Var.o());
        createSubPbActivityConfig.setKeyOriUgcTopPid(xt8Var.o());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void l2(xt8 xt8Var, @Nullable String str) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, xt8Var, str) != null) || xt8Var == null) {
            return;
        }
        if (str == null) {
            str = xt8Var.o();
        }
        if (xt8Var.s() == null) {
            userName = "";
        } else {
            userName = xt8Var.s().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getPageContext().getContext()).createSubPbActivityConfig(xt8Var.v(), "", "mention", false, userName, false, str, 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void n2(xt8 xt8Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, xt8Var, str) != null) || xt8Var == null) {
            return;
        }
        if (str == null) {
            str = xt8Var.o();
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(xt8Var.v(), str, 1, "mention");
        createNormalCfg.setStartFrom(13);
        createNormalCfg.setBjhData(xt8Var.getBaijiahaoData());
        createNormalCfg.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, layoutInflater, viewGroup, bundle)) == null) {
            registerListener(this.g);
            registerListener(this.h);
            AtMeModelController atMeModelController = new AtMeModelController(this);
            this.a = atMeModelController;
            atMeModelController.P(bundle);
            this.a.setUniqueId(getUniqueId());
            this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0132, viewGroup, false);
            it8 it8Var = new it8(this);
            this.b = it8Var;
            it8Var.k0(this.c);
            this.b.p0(this.k);
            this.b.o0(this.l);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.b.q0(false);
                    showLoadingView(this.c);
                    this.a.O();
                    this.f = true;
                }
            } else {
                this.b.q0(false);
                showLoadingView(this.c);
                this.a.O();
            }
            registerListener(this.i);
            registerListener(this.j);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }

    public void p2(xt8 xt8Var, boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048594, this, new Object[]{xt8Var, Boolean.valueOf(z), str}) != null) || xt8Var == null) {
            return;
        }
        if (str == null) {
            str = xt8Var.o();
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        videoItemData.thread_id = xt8Var.v();
        if (z) {
            videoItemData.highLightPostId = str;
        }
        arrayList.add(videoItemData);
        new VideoRecommentPlayActivityConfig(getContext(), arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_AT_PAGE, z).start();
    }
}
