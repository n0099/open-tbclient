package com.baidu.tieba;

import android.util.SparseArray;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.f39;
import com.baidu.tieba.jt8;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ls8 implements jt8.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCenterModel a;
    public jt8 b;
    public PersonCenterModel.d c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes5.dex */
    public class a implements PersonCenterModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ls8 a;

        /* renamed from: com.baidu.tieba.ls8$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0326a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ps8 a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0326a(a aVar, ps8 ps8Var, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, ps8Var, str};
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
                this.a = ps8Var;
                this.b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    String b = this.a.b();
                    if (!StringUtils.isNull(b) && this.c.a.b != null && !this.c.a.b.J()) {
                        m35.m().z(this.b, this.a.a());
                        this.c.a.b.F(b);
                    } else if (this.c.a.b != null) {
                        this.c.a.b.G(this.a.a());
                    }
                }
            }
        }

        public a(ls8 ls8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ls8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ls8Var;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void a(ts8 ts8Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ts8Var) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.b != null) {
                    this.a.b.r();
                    this.a.b.B(ts8Var);
                }
                if (ts8Var != null && ts8Var.A() != null) {
                    xv4.b(ts8Var.A().getPersonPrivate());
                }
                yr8.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e = yr8.d().e();
                if (e > 0) {
                    yr8.d().k(System.currentTimeMillis() - e);
                    yr8.d().j(0L);
                }
                ps8 v = this.a.a.V().v();
                UserData A = this.a.a.V().A();
                if (v != null && A != null) {
                    String str = "key_record_bubble_info_id_" + A.getUserId();
                    int n = m35.m().n(str, -1);
                    if (v.a() > 0 && v.a() != n) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        jg.a().postDelayed(new RunnableC0326a(this, v, str), 501L);
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

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ls8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ls8 ls8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ls8Var, Integer.valueOf(i)};
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
            this.a = ls8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            f39 f39Var;
            SparseArray<f39.a> sparseArray;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f39) && (sparseArray = (f39Var = (f39) customResponsedMessage.getData()).a) != null && sparseArray.size() > 0) {
                f39.a aVar = f39Var.a.get(2);
                f39.a aVar2 = f39Var.a.get(3);
                f39.a aVar3 = f39Var.a.get(9);
                f39.a aVar4 = f39Var.a.get(10);
                if (this.a.a.V() != null) {
                    if (aVar2 != null) {
                        this.a.a.V().g(aVar2.a);
                    }
                    if (aVar != null) {
                        this.a.a.V().e(aVar.a);
                    }
                    if (aVar3 != null) {
                        this.a.a.V().d(aVar3.a);
                    }
                    if (aVar4 != null) {
                        this.a.a.V().f(aVar4.a);
                    }
                }
                f39.a aVar5 = f39Var.a.get(5);
                if (aVar5 != null && this.a.b != null) {
                    this.a.b.I(5, aVar5.a);
                }
                if (this.a.b != null) {
                    this.a.b.u();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ls8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ls8 ls8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ls8Var, Integer.valueOf(i)};
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
            this.a = ls8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData) && (userPendantData = (UserPendantData) customResponsedMessage.getData()) != null) {
                if (this.a.a.V() != null) {
                    this.a.a.V().G(userPendantData);
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

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ls8 ls8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ls8Var, Integer.valueOf(i)};
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

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ls8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ls8 ls8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ls8Var, Integer.valueOf(i)};
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
            this.a = ls8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int y;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921744 && this.a.a != null && this.a.a.V() != null && (y = this.a.a.V().y()) != -1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921739, Integer.valueOf(y)));
            }
        }
    }

    public ls8(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        jt8 jt8Var = new jt8(view2, tbPageContext, bdUniqueId);
        this.b = jt8Var;
        jt8Var.D(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.a = personCenterModel;
        personCenterModel.b0(this.c);
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

    @Override // com.baidu.tieba.jt8.g
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a.loadData();
        }
    }

    public void e(int i) {
        jt8 jt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (jt8Var = this.b) != null) {
            jt8Var.v(i);
        }
    }

    public void i(String str) {
        ts8 V;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (V = this.a.V()) != null && V.A() != null) {
            V.A().setName_show(str);
            jt8 jt8Var = this.b;
            if (jt8Var != null) {
                jt8Var.u();
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a.c0(z);
            jt8 jt8Var = this.b;
            if (jt8Var != null) {
                jt8Var.y(z);
            }
        }
    }

    public void d() {
        jt8 jt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (jt8Var = this.b) != null) {
            jt8Var.s();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            jt8 jt8Var = this.b;
            if (jt8Var != null) {
                jt8Var.w();
                this.b = null;
            }
            PersonCenterModel personCenterModel = this.a;
            if (personCenterModel != null) {
                personCenterModel.b0(null);
                this.c = null;
            }
        }
    }

    public void g() {
        jt8 jt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (jt8Var = this.b) != null) {
            jt8Var.x();
        }
    }

    public void h() {
        jt8 jt8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (jt8Var = this.b) != null) {
            jt8Var.z();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            yr8.d().j(System.currentTimeMillis());
            this.a.loadData();
        }
    }
}
