package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.b1.h0;
import c.a.p0.b1.k0;
import c.a.p0.b1.n;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PersonCenterFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public long f55639e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55640f;
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public boolean f55641g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55642h;

    /* renamed from: i  reason: collision with root package name */
    public c.a.q0.l2.d.b f55643i;

    /* renamed from: j  reason: collision with root package name */
    public long f55644j;
    public String k;
    public String l;
    public boolean m;
    public CustomMessageListener n;
    public CustomMessageListener o;
    public CustomMessageListener p;
    public MessageQueue.IdleHandler q;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterFragment f55645a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(PersonCenterFragment personCenterFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment, Integer.valueOf(i2)};
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
            this.f55645a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage.getCmd() == 2016560) {
                this.f55645a.f(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterFragment f55646a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PersonCenterFragment personCenterFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment, Integer.valueOf(i2)};
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
            this.f55646a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.f55646a.f55640f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                String str = (String) data;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f55646a.k = str;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterFragment f55647a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonCenterFragment personCenterFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment, Integer.valueOf(i2)};
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
            this.f55647a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !this.f55647a.f55640f) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof String) {
                this.f55647a.l = (String) data;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends h0<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterFragment f55648a;

        public d(PersonCenterFragment personCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55648a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // c.a.p0.b1.h0
        public Boolean doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + TbConfig.GET_FEEDBACK_TIP);
                netWork.addPostData("user_id", TbadkCoreApplication.getCurrentAccount());
                String postNetData = netWork.postNetData();
                c.a.q0.l2.e.b bVar = new c.a.q0.l2.e.b();
                bVar.c(postNetData);
                if (bVar.b() == 0 && bVar.a() > 0) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
            return (Boolean) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class e implements n<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterFragment f55649a;

        public e(PersonCenterFragment personCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55649a = personCenterFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, bool) == null) && bool.booleanValue()) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016561, Boolean.TRUE));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements MessageQueue.IdleHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PersonCenterFragment f55650a;

        public f(PersonCenterFragment personCenterFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personCenterFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55650a = personCenterFragment;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f55650a.g();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55640f = true;
        this.f55641g = false;
        this.f55642h = false;
        this.f55644j = 0L;
        this.m = false;
        this.n = new a(this, 2016560);
        this.o = new b(this, 2921033);
        this.p = new c(this, 2921378);
        this.q = new f(this);
    }

    public final void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            if (!z) {
                g();
            } else if (getPageContext() == null || getPageContext().getPageActivity() == null) {
            } else {
                Looper.myQueue().removeIdleHandler(this.q);
                Looper.myQueue().addIdleHandler(this.q);
            }
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            long l = c.a.p0.s.d0.b.j().l("key_feedback_tip", 0L);
            if (!TbadkCoreApplication.isLogin() || System.currentTimeMillis() - l <= StringHelper.MS_TO_HOUR * 4) {
                return;
            }
            k0.b(new d(this), new e(this));
            c.a.p0.s.d0.b.j().w("key_feedback_tip", System.currentTimeMillis());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, c.a.p0.m0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f55642h) {
                return null;
            }
            return "a011";
        }
        return (String) invokeV.objValue;
    }

    public final void h(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            Intent intent = getActivity().getIntent();
            if (intent != null) {
                this.f55639e = intent.getLongExtra("user_id", c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.f55640f = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_USER_SELF, true);
                this.f55641g = intent.getBooleanExtra(PersonPolymericActivityConfig.IS_BIGV, false);
            } else if (bundle != null) {
                this.f55639e = bundle.getLong("user_id", c.a.e.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L));
                this.f55640f = bundle.getBoolean(PersonPolymericActivityConfig.IS_USER_SELF, true);
                this.f55641g = bundle.getBoolean(PersonPolymericActivityConfig.IS_BIGV, false);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            super.onActivityCreated(bundle);
            c.a.q0.l2.a.d().h(System.currentTimeMillis() - c.a.q0.l2.a.d().a());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            super.onAttach(context);
            this.mIsLogin = TbadkCoreApplication.isLogin();
            if (getArguments() != null) {
                this.f55642h = getArguments().getBoolean(PersonPolymericActivityConfig.RESOURCE_TYPE);
            }
            getPageStayDurationItem().k = "1";
            f(true);
            MessageManager.getInstance().registerListener(this.n);
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            c.a.q0.l2.d.b bVar = this.f55643i;
            if (bVar != null) {
                bVar.f(i2);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            c.a.q0.l2.a.d().g(System.currentTimeMillis());
            super.onCreate(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, layoutInflater, viewGroup, bundle)) == null) {
            h(bundle);
            View inflate = layoutInflater.inflate(R.layout.fragment_my_tab_layout, (ViewGroup) null);
            c.a.q0.l2.d.b bVar = new c.a.q0.l2.d.b(inflate, getPageContext(), getUniqueId());
            this.f55643i = bVar;
            bVar.e();
            this.m = false;
            if (!TbadkCoreApplication.getInst().checkInterrupt()) {
                this.f55643i.j();
                this.m = true;
            }
            return inflate;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onDestroy();
            c.a.q0.l2.d.b bVar = this.f55643i;
            if (bVar != null) {
                bVar.g();
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.n);
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
            super.onDetach();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onPause();
            if (this.f55644j > 0) {
                TiebaStatic.log(new StatisticItem("c12263").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf((System.currentTimeMillis() - this.f55644j) / 1000)).param("obj_type", 2));
                this.f55644j = 0L;
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onPrimary();
            this.f55643i.k(isPrimary());
            if (isPrimary()) {
                if (!this.m) {
                    this.m = true;
                    this.f55643i.j();
                }
                if (!StringUtils.isNull(this.k)) {
                    this.f55643i.i(this.k);
                    this.k = null;
                }
                if (!StringUtils.isNull(this.l)) {
                    this.f55643i.h(this.l);
                    this.l = null;
                } else {
                    this.f55643i.j();
                }
                this.f55643i.l();
                c.a.p0.s.d0.b.j().t("key_feedback_tip_tab_show", false);
                if (TbSingleton.getInstance().isShowShoubaiDynamicGuide()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921423));
                }
            } else {
                this.f55643i.d();
            }
            if (isAdded()) {
                c.a.q0.y2.a.v().F();
            }
            c.a.q0.y2.a.v().I(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onResume();
            if (!this.f55640f && this.f55641g) {
                this.f55644j = System.currentTimeMillis();
            } else {
                this.f55644j = -1L;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (bundle != null) {
                bundle.putLong("user_id", this.f55639e);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_USER_SELF, this.f55640f);
                bundle.putBoolean(PersonPolymericActivityConfig.IS_BIGV, this.f55641g);
            }
        }
    }
}
