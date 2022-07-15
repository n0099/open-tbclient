package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.LazyBaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.de5;
import com.repackage.he5;
import com.repackage.i18;
import com.repackage.jd5;
import com.repackage.l18;
import com.repackage.ng;
import com.repackage.xt4;
import com.repackage.y08;
/* loaded from: classes3.dex */
public class PersonCenterFragment extends LazyBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long g;
    public boolean h;
    @Deprecated
    public boolean i;
    public boolean j;
    public i18 k;
    public long l;
    public String m;
    public String n;
    public boolean o;
    public HttpMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public MessageQueue.IdleHandler t;

    /* loaded from: classes3.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonCenterFragment personCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment, Integer.valueOf(i)};
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
            this.a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage.getCmd() == 1003510 && httpResponsedMessage.getError() == 0) {
                this.a.k.k();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonCenterFragment personCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment, Integer.valueOf(i)};
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
            this.a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016560) {
                this.a.D1(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonCenterFragment personCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment, Integer.valueOf(i)};
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
            this.a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.a.h) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.a.m = str;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonCenterFragment personCenterFragment, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment, Integer.valueOf(i)};
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
            this.a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.a.h) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                this.a.n = (String) data;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends de5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterFragment a;

        public e(PersonCenterFragment personCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.repackage.de5
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                String postNetData = netWork.postNetData();
                l18 l18Var = new l18();
                l18Var.c(postNetData);
                if (l18Var.b() == 0 && l18Var.a() > 0) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f implements jd5<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterFragment a;

        public f(PersonCenterFragment personCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.jd5
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && bool.booleanValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016561, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonCenterFragment a;

        public g(PersonCenterFragment personCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personCenterFragment;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.a.E1();
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public PersonCenterFragment() {
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
        this.h = true;
        this.i = false;
        this.j = false;
        this.l = 0L;
        this.o = false;
        this.p = new a(this, CmdConfigHttp.CMD_WORK_VIDEO_GUIDE_UPDATE);
        this.q = new b(this, 2016560);
        this.r = new c(this, 2921033);
        this.s = new d(this, 2921378);
        this.t = new g(this);
    }

    public final void D1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!z) {
                E1();
            } else if (getPageContext() == null || getPageContext().getPageActivity() == null) {
            } else {
                Looper.myQueue().removeIdleHandler(this.t);
                Looper.myQueue().addIdleHandler(this.t);
            }
        }
    }

    public final void E1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long m = xt4.k().m("key_feedback_tip", 0L);
            if (!TbadkCoreApplication.isLogin() || System.currentTimeMillis() - m <= StringHelper.MS_TO_HOUR * 4) {
                return;
            }
            he5.b(new e(this), new f(this));
            xt4.k().x("key_feedback_tip", System.currentTimeMillis());
        }
    }

    public final void F1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.g = intent.getLongExtra("user_id", ng.g(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.h = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
                this.i = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            } else if (bundle != null) {
                this.g = bundle.getLong("user_id", ng.g(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.h = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
                this.i = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.repackage.v85
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.j) {
                return null;
            }
            return "a011";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            y08.d().h(System.currentTimeMillis() - y08.d().a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            super.onAttach(context);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            if (getArguments() != null) {
                this.j = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
            }
            getPageStayDurationItem().k = "1";
            D1(true);
            MessageManager.getInstance().registerListener(this.p);
            MessageManager.getInstance().registerListener(this.q);
            MessageManager.getInstance().registerListener(this.r);
            MessageManager.getInstance().registerListener(this.s);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            super.onChangeSkinType(i);
            i18 i18Var = this.k;
            if (i18Var != null) {
                i18Var.g(i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            y08.d().g(System.currentTimeMillis());
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            i18 i18Var = this.k;
            if (i18Var != null) {
                i18Var.h();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.q);
            MessageManager.getInstance().unRegisterListener(this.p);
            MessageManager.getInstance().unRegisterListener(this.r);
            MessageManager.getInstance().unRegisterListener(this.s);
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onPause();
            if (this.l > 0) {
                TiebaStatic.log(new StatisticItem("c12263").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf((System.currentTimeMillis() - this.l) / 1000)).param("obj_type", 2));
                this.l = 0L;
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment, com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPrimary();
            this.k.l(isPrimary());
            if (isPrimary()) {
                if (!this.o) {
                    this.o = true;
                    this.k.k();
                }
                if (!StringUtils.isNull(this.m)) {
                    this.k.j(this.m);
                    this.m = null;
                }
                if (!StringUtils.isNull(this.n)) {
                    this.k.i(this.n);
                    this.n = null;
                } else {
                    this.k.k();
                }
                this.k.m();
                xt4.k().u("key_feedback_tip_tab_show", false);
            } else {
                this.k.e();
            }
            if (isAdded()) {
                PersonRedTipManager.getInstance().removeTabTip();
            }
            PersonRedTipManager.getInstance().setIsPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onResume();
            if (!this.h && this.i) {
                this.l = System.currentTimeMillis();
            } else {
                this.l = -1L;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putLong("user_id", this.g);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.h);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.i);
            }
        }
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public int t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R.layout.obfuscated_res_0x7f0d02d7 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.core.LazyBaseFragment
    public void v1(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, view2, bundle) == null) {
            F1(bundle);
            i18 i18Var = new i18(view2, getPageContext(), getUniqueId());
            this.k = i18Var;
            i18Var.f();
            this.o = false;
            if (TbadkCoreApplication.getInst().checkInterrupt()) {
                return;
            }
            this.k.k();
            this.o = true;
        }
    }
}
