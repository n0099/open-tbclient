package com.baidu.tieba;

import android.app.Activity;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.immessagecenter.mention.ChatAggregationFragment;
import com.baidu.tieba.setting.model.MsgRemindModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rw7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ChatAggregationFragment a;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rw7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(rw7 rw7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw7Var, Integer.valueOf(i)};
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
            this.a = rw7Var;
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
                if (pageContext != null && pageContext.getUniqueId() != null && pageContext.getUniqueId().getId() == i) {
                    this.a.d(i2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements lw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.lw4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(rw7 rw7Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw7Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
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

        @Override // com.baidu.tieba.lw4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).S(1, true, null);
                }
                if (this.c) {
                    za5.o(this.d);
                } else {
                    ua5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements lw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.lw4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public c(rw7 rw7Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw7Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
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

        @Override // com.baidu.tieba.lw4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).S(2, true, null);
                }
                if (this.c) {
                    za5.o(this.d);
                } else {
                    ua5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements lw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.lw4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public d(rw7 rw7Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw7Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
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

        @Override // com.baidu.tieba.lw4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).S(20, true, null);
                }
                if (this.c) {
                    za5.o(this.d);
                } else {
                    ua5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements lw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.lw4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public e(rw7 rw7Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw7Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
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

        @Override // com.baidu.tieba.lw4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).S(3, true, null);
                }
                if (this.c) {
                    za5.o(this.d);
                } else {
                    ua5.e(this.b);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements lw4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ TbPageContext b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Activity d;

        @Override // com.baidu.tieba.lw4
        public void onCancelClick() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public f(rw7 rw7Var, boolean z, TbPageContext tbPageContext, boolean z2, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rw7Var, Boolean.valueOf(z), tbPageContext, Boolean.valueOf(z2), activity};
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

        @Override // com.baidu.tieba.lw4
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (!this.a) {
                    new MsgRemindModel(this.b).S(10, true, null);
                }
                if (this.c) {
                    za5.o(this.d);
                } else {
                    ua5.e(this.b);
                }
            }
        }
    }

    public rw7(ChatAggregationFragment chatAggregationFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {chatAggregationFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = chatAggregationFragment;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || this.a == null) {
            return;
        }
        this.a.registerListener(new a(this, 2921700));
    }

    public final void d(int i) {
        ChatAggregationFragment chatAggregationFragment;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) != null) || (chatAggregationFragment = this.a) == null) {
            return;
        }
        FragmentActivity fragmentActivity = chatAggregationFragment.getFragmentActivity();
        TbPageContext<BaseFragmentActivity> pageContext = this.a.getPageContext();
        if (fragmentActivity != null && pageContext != null) {
            boolean areNotificationsEnabled = NotificationManagerCompat.from(fragmentActivity).areNotificationsEnabled();
            if (i == 3) {
                boolean z = y95.d().z();
                if (areNotificationsEnabled && z) {
                    return;
                }
                b bVar = new b(this, z, pageContext, areNotificationsEnabled, fragmentActivity);
                if (ua5.i(TbadkCoreApplication.getInst(), 6)) {
                    za5.m(pageContext, 3, bVar);
                }
            }
            if (i == 6) {
                boolean u = y95.d().u();
                if (areNotificationsEnabled && u) {
                    return;
                }
                c cVar = new c(this, u, pageContext, areNotificationsEnabled, fragmentActivity);
                if (ua5.i(TbadkCoreApplication.getInst(), 3)) {
                    za5.m(pageContext, 6, cVar);
                }
            }
            if (i == 7) {
                boolean C = y95.d().C();
                if (areNotificationsEnabled && C) {
                    return;
                }
                d dVar = new d(this, C, pageContext, areNotificationsEnabled, fragmentActivity);
                if (ua5.i(TbadkCoreApplication.getInst(), 4)) {
                    za5.m(pageContext, 7, dVar);
                }
            }
            if (i == 8) {
                boolean x = y95.d().x();
                if (areNotificationsEnabled && x) {
                    return;
                }
                e eVar = new e(this, x, pageContext, areNotificationsEnabled, fragmentActivity);
                if (ua5.i(TbadkCoreApplication.getInst(), 5)) {
                    za5.m(pageContext, 8, eVar);
                }
            }
            if (i == 2) {
                boolean r = y95.d().r();
                if (areNotificationsEnabled && r) {
                    return;
                }
                f fVar = new f(this, r, pageContext, areNotificationsEnabled, fragmentActivity);
                if (za5.g(TbadkCoreApplication.getInst(), 0)) {
                    za5.m(pageContext, 2, fVar);
                }
            }
        }
    }
}
