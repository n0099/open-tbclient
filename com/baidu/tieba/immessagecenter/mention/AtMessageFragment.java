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
import com.baidu.tieba.io;
import com.baidu.tieba.jo;
import com.baidu.tieba.mq8;
import com.baidu.tieba.oq8;
import com.baidu.tieba.pq8;
import com.baidu.tieba.qr8;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.tieba.wg;
import com.baidu.tieba.yi;
import com.baidu.tieba.yn;
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
    public mq8 b;
    public ViewGroup c;
    public pq8 d;
    public int e;
    public boolean f;
    public CustomMessageListener g;
    public CustomMessageListener h;
    public final CustomMessageListener i;
    public final CustomMessageListener j;
    public io k;
    public jo l;

    @Override // com.baidu.tbadk.core.view.NoNetworkView.b
    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class f implements jo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AtMessageFragment a;

        /* loaded from: classes6.dex */
        public class a implements pq8.c {
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

            @Override // com.baidu.tieba.pq8.c
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.b.d0(this.a);
                    this.b.a.a.W(this.a);
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
                oq8Var.a = 2;
                oq8Var.b = wg.g(br8Var.x(), 0L);
                oq8Var.c = wg.g(br8Var.n(), 0L);
                if (br8Var.getBaijiahaoData() != null) {
                    str = br8Var.getBaijiahaoData().oriUgcNid;
                } else {
                    str = "";
                }
                oq8Var.d = str;
                AtMessageFragment atMessageFragment = this.a;
                atMessageFragment.d = new pq8(atMessageFragment.getPageContext());
                this.a.d.h(oq8Var);
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
                    this.a.a.X();
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
                            this.a.b.u0(true);
                            return;
                        }
                        return;
                    }
                    this.a.f = true;
                    this.a.b.u0(true);
                    AtMessageFragment atMessageFragment = this.a;
                    atMessageFragment.showLoadingView(atMessageFragment.c);
                    this.a.a.X();
                    return;
                }
                this.a.d2();
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
                this.a.b.o0((NewsNotifyMessage) customResponsedMessage);
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
    public class e implements io {
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
                    this.a.b.k0();
                }
            }
            if (!TextUtils.isEmpty(br8Var.getTargetScheme())) {
                UrlManager.getInstance().dealOneLink(br8Var.getTargetScheme());
            } else if (br8Var.isBjh()) {
                if (br8Var.B()) {
                    this.a.U1(br8Var);
                } else {
                    this.a.T1(br8Var);
                }
            } else if (br8Var.B()) {
                this.a.V1(br8Var);
            } else if (br8Var.getThreadType() == 40) {
                this.a.Z1(br8Var, true);
            } else {
                this.a.X1(br8Var);
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
            mq8 mq8Var = this.b;
            if (mq8Var != null) {
                mq8Var.e0();
            }
            AtMeModelController atMeModelController = this.a;
            if (atMeModelController != null) {
                atMeModelController.onDestroy();
            }
            pq8 pq8Var = this.d;
            if (pq8Var != null) {
                pq8Var.d();
                this.d = null;
            }
        }
    }

    public void V1(br8 br8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, br8Var) == null) {
            W1(br8Var, null);
        }
    }

    public void X1(br8 br8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, br8Var) == null) {
            Y1(br8Var, null);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            super.onChangeSkinType(i);
            if (this.e != i) {
                this.e = i;
                mq8 mq8Var = this.b;
                if (mq8Var != null) {
                    mq8Var.onChangeSkinType(i);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, configuration) == null) {
            super.onConfigurationChanged(configuration);
            pq8 pq8Var = this.d;
            if (pq8Var != null) {
                pq8Var.f();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048590, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.b.m0(i, i2, intent);
        }
    }

    public void Z1(br8 br8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, br8Var, z) == null) {
            a2(br8Var, z, null);
        }
    }

    public void c2(boolean z, ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048586, this, z, arrayList) == null) && this.b != null) {
            hideLoadingView(this.c);
            hideNetRefreshView(this.c);
            this.b.q0(z, arrayList);
        }
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.u0(false);
        }
    }

    public void b2() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (atMeModelController = this.a) != null) {
            atMeModelController.Z();
        }
    }

    public void d2() {
        AtMeModelController atMeModelController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && (atMeModelController = this.a) != null) {
            atMeModelController.b0();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        mq8 mq8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.onNetRefreshButtonClicked();
            if (yi.G() && (mq8Var = this.b) != null) {
                mq8Var.u0(true);
                d2();
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
            mq8 mq8Var = this.b;
            if (mq8Var != null) {
                mq8Var.p0();
            }
        }
    }

    public final void T1(br8 br8Var) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, br8Var) != null) || br8Var == null) {
            return;
        }
        if (br8Var.r() == null) {
            userName = "";
        } else {
            userName = br8Var.r().getUserName();
        }
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(br8Var.x(), br8Var.n(), "mention", false, userName, false, br8Var.n(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(br8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(br8Var.n());
        createSubPbActivityConfig.setKeyOriUgcTopPid("0");
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public final void U1(br8 br8Var) {
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
        SubPbActivityConfig createSubPbActivityConfig = new SubPbActivityConfig(getActivity()).createSubPbActivityConfig(br8Var.x(), br8Var.o(), "mention", false, userName, false, br8Var.o(), 0);
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setBjhData(br8Var.getBaijiahaoData());
        createSubPbActivityConfig.setHighLightPostId(br8Var.n());
        createSubPbActivityConfig.setKeyOriUgcTopPid(br8Var.n());
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void W1(br8 br8Var, @Nullable String str) {
        String userName;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048580, this, br8Var, str) != null) || br8Var == null) {
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
        createSubPbActivityConfig.setKeyPageStartFrom(13);
        createSubPbActivityConfig.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, createSubPbActivityConfig));
    }

    public void Y1(br8 br8Var, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, br8Var, str) != null) || br8Var == null) {
            return;
        }
        if (str == null) {
            str = br8Var.n();
        }
        PbActivityConfig createNormalCfg = new PbActivityConfig(getPageContext().getContext()).createNormalCfg(br8Var.x(), str, 1, "mention");
        createNormalCfg.setStartFrom(13);
        createNormalCfg.setBjhData(br8Var.getBaijiahaoData());
        createNormalCfg.setHighLightPostId(str);
        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
    }

    public void a2(br8 br8Var, boolean z, @Nullable String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{br8Var, Boolean.valueOf(z), str}) != null) || br8Var == null) {
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
        new VideoRecommentPlayActivityConfig(getContext(), arrayList, (String) null, VideoRecommentPlayActivityConfig.FROM_AT_PAGE, z).start();
    }

    public void f(ErrorData errorData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, errorData) == null) {
            hideLoadingView(this.c);
            if (errorData != null) {
                if (!StringUtils.isNull(errorData.error_msg)) {
                    showToast(errorData.error_msg);
                } else {
                    showToast(R.string.obfuscated_res_0x7f0f0a41);
                }
            }
            mq8 mq8Var = this.b;
            if (mq8Var != null) {
                mq8Var.f(errorData);
            }
            mq8 mq8Var2 = this.b;
            if (mq8Var2 != null && mq8Var2.f0() != null) {
                this.b.f0().setVisibility(8);
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
            atMeModelController.Y(bundle);
            this.a.setUniqueId(getUniqueId());
            this.c = (ViewGroup) layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d012b, viewGroup, false);
            mq8 mq8Var = new mq8(this);
            this.b = mq8Var;
            mq8Var.n0(this.c);
            this.b.s0(this.k);
            this.b.r0(this.l);
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                if (getActivity() instanceof MessageCenterActivity) {
                    this.b.u0(false);
                    showLoadingView(this.c);
                    this.a.X();
                    this.f = true;
                }
            } else {
                this.b.u0(false);
                showLoadingView(this.c);
                this.a.X();
            }
            registerListener(this.i);
            registerListener(this.j);
            return this.c;
        }
        return (View) invokeLLL.objValue;
    }
}
