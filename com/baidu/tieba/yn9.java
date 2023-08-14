package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.account.helper.UserPrivateHelper;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.k1a;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wo9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yn9 implements wo9.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCenterModel a;
    public wo9 b;
    public PersonCenterModel.d c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes8.dex */
    public class a implements PersonCenterModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yn9 a;

        /* renamed from: com.baidu.tieba.yn9$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0549a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ co9 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0549a(a aVar, co9 co9Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, co9Var, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = co9Var;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String b = this.a.b();
                    if (!StringUtils.isNull(b) && this.c.a.b != null && !this.c.a.b.J()) {
                        SharedPrefHelper.getInstance().putInt(this.b, this.a.a());
                        this.c.a.b.F(b);
                    } else if (this.c.a.b != null) {
                        this.c.a.b.G(this.a.a());
                    }
                }
            }
        }

        public a(yn9 yn9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = yn9Var;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void a(go9 go9Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, go9Var) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.b != null) {
                    this.a.b.r();
                    this.a.b.B(go9Var);
                }
                if (go9Var != null && go9Var.A() != null) {
                    UserPrivateHelper.init(go9Var.A().getPersonPrivate());
                }
                ln9.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e = ln9.d().e();
                if (e > 0) {
                    ln9.d().k(System.currentTimeMillis() - e);
                    ln9.d().j(0L);
                }
                co9 v = this.a.a.R().v();
                UserData A = this.a.a.R().A();
                if (v != null && A != null) {
                    String str = "key_record_bubble_info_id_" + A.getUserId();
                    int i = SharedPrefHelper.getInstance().getInt(str, -1);
                    if (v.a() > 0 && v.a() != i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        SafeHandler.getInst().postDelayed(new RunnableC0549a(this, v, str), 501L);
                    }
                }
            }
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void onFail(int i, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) && i == -1 && !this.a.a.mIsDataLoaded && this.a.b != null) {
                this.a.b.H();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
            this.a = yn9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            k1a k1aVar;
            SparseArray<k1a.a> sparseArray;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof k1a) && (sparseArray = (k1aVar = (k1a) customResponsedMessage.getData()).a) != null && sparseArray.size() > 0) {
                k1a.a aVar = k1aVar.a.get(2);
                k1a.a aVar2 = k1aVar.a.get(3);
                k1a.a aVar3 = k1aVar.a.get(9);
                k1a.a aVar4 = k1aVar.a.get(10);
                if (this.a.a.R() != null) {
                    if (aVar2 != null) {
                        this.a.a.R().g(aVar2.a);
                    }
                    if (aVar != null) {
                        this.a.a.R().e(aVar.a);
                    }
                    if (aVar3 != null) {
                        this.a.a.R().d(aVar3.a);
                    }
                    if (aVar4 != null) {
                        this.a.a.R().f(aVar4.a);
                    }
                }
                k1a.a aVar5 = k1aVar.a.get(5);
                if (aVar5 != null && this.a.b != null) {
                    this.a.b.I(5, aVar5.a);
                }
                if (this.a.b != null) {
                    this.a.b.u();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
            this.a = yn9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData) && (userPendantData = (UserPendantData) customResponsedMessage.getData()) != null) {
                if (this.a.a.R() != null) {
                    this.a.a.R().G(userPendantData);
                    if (this.a.b != null) {
                        this.a.b.u();
                        return;
                    }
                    return;
                }
                this.a.j();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            PersonRedTipManager.getInstance().setIsPrimary(false);
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yn9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(yn9 yn9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yn9Var, Integer.valueOf(i)};
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
            this.a = yn9Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int y;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921744 && this.a.a != null && this.a.a.R() != null && (y = this.a.a.R().y()) != -1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921739, Integer.valueOf(y)));
            }
        }
    }

    public yn9(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view2, tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.d = new b(this, 2001435);
        this.e = new c(this, 2016485);
        this.f = new d(this, 2005016);
        this.g = new e(this, 2921744);
        wo9 wo9Var = new wo9(view2, tbPageContext, bdUniqueId);
        this.b = wo9Var;
        wo9Var.D(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.a = personCenterModel;
        personCenterModel.X(this.c);
        PersonRedTipManager.getInstance();
        this.d.setTag(bdUniqueId);
        this.f.setTag(bdUniqueId);
        this.g.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.d);
        MessageManager.getInstance().registerListener(this.f);
        MessageManager.getInstance().registerListener(this.g);
        this.e.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.e);
    }

    @Override // com.baidu.tieba.wo9.g
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a.loadData();
        }
    }

    public void e(int i) {
        wo9 wo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (wo9Var = this.b) != null) {
            wo9Var.v(i);
        }
    }

    public void i(String str) {
        go9 R;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (R = this.a.R()) != null && R.A() != null) {
            R.A().setName_show(str);
            wo9 wo9Var = this.b;
            if (wo9Var != null) {
                wo9Var.u();
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a.Y(z);
            wo9 wo9Var = this.b;
            if (wo9Var != null) {
                wo9Var.y(z);
            }
        }
    }

    public void d() {
        wo9 wo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (wo9Var = this.b) != null) {
            wo9Var.s();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            wo9 wo9Var = this.b;
            if (wo9Var != null) {
                wo9Var.w();
                this.b = null;
            }
            PersonCenterModel personCenterModel = this.a;
            if (personCenterModel != null) {
                personCenterModel.X(null);
                this.c = null;
            }
        }
    }

    public void g() {
        wo9 wo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (wo9Var = this.b) != null) {
            wo9Var.x();
        }
    }

    public void h() {
        wo9 wo9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (wo9Var = this.b) != null) {
            wo9Var.z();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            ln9.d().j(System.currentTimeMillis());
            this.a.loadData();
        }
    }
}
