package com.baidu.tieba;

import android.app.Activity;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.immessagecenter.msgtab.adapt.ChatTabFragmentAdapt;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class tl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ChatTabFragmentAdapt a;

    /* loaded from: classes8.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tl8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(tl8 tl8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl8Var, Integer.valueOf(i)};
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
            this.a = tl8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int[] iArr;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof int[]) && (iArr = (int[]) customResponsedMessage.getData()) != null && iArr.length == 2) {
                int i = iArr[0];
                int i2 = iArr[1];
                TbPageContext<BaseFragmentActivity> pageContext = this.a.a.getPageContext();
                if (pageContext == null || pageContext.getUniqueId() == null || pageContext.getUniqueId().getId() != i) {
                    return;
                }
                this.a.d(i2);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements vz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.vz4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(tl8 tl8Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl8Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.vz4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).Z(1, true, null);
                }
                if (this.c) {
                    dg5.m(this.d);
                } else {
                    yf5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements vz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.vz4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c(tl8 tl8Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl8Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.vz4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).Z(2, true, null);
                }
                if (this.c) {
                    dg5.m(this.d);
                } else {
                    yf5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements vz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.vz4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(tl8 tl8Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl8Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.vz4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).Z(20, true, null);
                }
                if (this.c) {
                    dg5.m(this.d);
                } else {
                    yf5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements vz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.vz4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public e(tl8 tl8Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl8Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.vz4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).Z(3, true, null);
                }
                if (this.c) {
                    dg5.m(this.d);
                } else {
                    yf5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements vz4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.vz4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public f(tl8 tl8Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tl8Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = tbPageContext;
            this.c = z2;
            this.d = activity;
        }

        @Override // com.baidu.tieba.vz4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).Z(10, true, null);
                }
                if (this.c) {
                    dg5.m(this.d);
                } else {
                    yf5.e(this.b);
                }
            }
        }
    }

    public tl8(ChatTabFragmentAdapt chatTabFragmentAdapt) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatTabFragmentAdapt};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BaseFragment H1 = chatTabFragmentAdapt.H1();
        if (H1 instanceof ChatTabFragmentAdapt) {
            this.a = (ChatTabFragmentAdapt) H1;
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
            return;
        }
        this.a.registerListener(new a(this, 2921700));
    }

    public final void d(int i) {
        ChatTabFragmentAdapt chatTabFragmentAdapt;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (chatTabFragmentAdapt = this.a) == null) {
            return;
        }
        FragmentActivity fragmentActivity = chatTabFragmentAdapt.getFragmentActivity();
        TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
        if (fragmentActivity != null && pageContext != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(fragmentActivity).areNotificationsEnabled();
            if (i == 3) {
                boolean A = se5.d().A();
                if (areNotificationsEnabled && A) {
                    return;
                }
                b bVar = new b(this, A, pageContext, areNotificationsEnabled, fragmentActivity);
                if (yl8.e()) {
                    dg5.k(pageContext, 3, bVar);
                    uq9.e().h("reply_message_bar");
                }
            }
            if (i == 6) {
                boolean v = se5.d().v();
                if (areNotificationsEnabled && v) {
                    return;
                }
                c cVar = new c(this, v, pageContext, areNotificationsEnabled, fragmentActivity);
                if (yl8.b()) {
                    dg5.k(pageContext, 6, cVar);
                    uq9.e().h("at_message_bar");
                }
            }
            if (i == 7) {
                boolean D = se5.d().D();
                if (areNotificationsEnabled && D) {
                    return;
                }
                d dVar = new d(this, D, pageContext, areNotificationsEnabled, fragmentActivity);
                if (yl8.a()) {
                    dg5.k(pageContext, 7, dVar);
                    uq9.e().h("agree_message_bar");
                }
            }
            if (i == 8) {
                boolean y = se5.d().y();
                if (areNotificationsEnabled && y) {
                    return;
                }
                e eVar = new e(this, y, pageContext, areNotificationsEnabled, fragmentActivity);
                if (yl8.c()) {
                    dg5.k(pageContext, 8, eVar);
                    uq9.e().h("fan_message_bar");
                }
            }
            if (i == 2) {
                boolean r = se5.d().r();
                if (areNotificationsEnabled && r) {
                    return;
                }
                f fVar = new f(this, r, pageContext, areNotificationsEnabled, fragmentActivity);
                if (yl8.d()) {
                    dg5.k(pageContext, 2, fVar);
                    uq9.e().h("im");
                }
            }
        }
    }
}
