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
import com.baidu.tieba.fma;
import com.baidu.tieba.j9a;
import com.baidu.tieba.personCenter.model.PersonCenterModel;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class l8a implements j9a.g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PersonCenterModel a;
    public j9a b;
    public PersonCenterModel.d c;
    public CustomMessageListener d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;

    /* loaded from: classes7.dex */
    public class a implements PersonCenterModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a a;

        /* renamed from: com.baidu.tieba.l8a$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0385a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ p8a a;
            public final /* synthetic */ String b;
            public final /* synthetic */ a c;

            public RunnableC0385a(a aVar, p8a p8aVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, p8aVar, str};
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
                this.a = p8aVar;
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

        public a(l8a l8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = l8aVar;
        }

        @Override // com.baidu.tieba.personCenter.model.PersonCenterModel.d
        public void a(t8a t8aVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, t8aVar) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.a.b != null) {
                    this.a.b.r();
                    this.a.b.B(t8aVar);
                }
                if (t8aVar != null && t8aVar.A() != null) {
                    UserPrivateHelper.init(t8aVar.A().getPersonPrivate());
                }
                y7a.d().i(System.currentTimeMillis() - currentTimeMillis);
                long e = y7a.d().e();
                if (e > 0) {
                    y7a.d().k(System.currentTimeMillis() - e);
                    y7a.d().j(0L);
                }
                p8a v = this.a.a.S().v();
                UserData A = this.a.a.S().A();
                if (v != null && A != null) {
                    String str = "key_record_bubble_info_id_" + A.getUserId();
                    int i = SharedPrefHelper.getInstance().getInt(str, -1);
                    if (v.a() > 0 && v.a() != i) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        SafeHandler.getInst().postDelayed(new RunnableC0385a(this, v, str), 501L);
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

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(l8a l8aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l8aVar, Integer.valueOf(i)};
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
            this.a = l8aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            fma fmaVar;
            SparseArray<fma.a> sparseArray;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof fma) && (sparseArray = (fmaVar = (fma) customResponsedMessage.getData()).a) != null && sparseArray.size() > 0) {
                fma.a aVar = fmaVar.a.get(2);
                fma.a aVar2 = fmaVar.a.get(3);
                fma.a aVar3 = fmaVar.a.get(9);
                fma.a aVar4 = fmaVar.a.get(10);
                if (this.a.a.S() != null) {
                    if (aVar2 != null) {
                        this.a.a.S().g(aVar2.a);
                    }
                    if (aVar != null) {
                        this.a.a.S().e(aVar.a);
                    }
                    if (aVar3 != null) {
                        this.a.a.S().d(aVar3.a);
                    }
                    if (aVar4 != null) {
                        this.a.a.S().f(aVar4.a);
                    }
                }
                fma.a aVar5 = fmaVar.a.get(5);
                if (aVar5 != null && this.a.b != null) {
                    this.a.b.I(5, aVar5.a);
                }
                if (this.a.b != null) {
                    this.a.b.u();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(l8a l8aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l8aVar, Integer.valueOf(i)};
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
            this.a = l8aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            UserPendantData userPendantData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserPendantData) && (userPendantData = (UserPendantData) customResponsedMessage.getData()) != null) {
                if (this.a.a.S() != null) {
                    this.a.a.S().G(userPendantData);
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

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l8a l8aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l8aVar, Integer.valueOf(i)};
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

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ l8a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(l8a l8aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {l8aVar, Integer.valueOf(i)};
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
            this.a = l8aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            int y;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2921744 && this.a.a != null && this.a.a.S() != null && (y = this.a.a.S().y()) != -1) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921739, Integer.valueOf(y)));
            }
        }
    }

    public l8a(View view2, TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
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
        j9a j9aVar = new j9a(view2, tbPageContext, bdUniqueId);
        this.b = j9aVar;
        j9aVar.D(this);
        PersonCenterModel personCenterModel = new PersonCenterModel(tbPageContext, bdUniqueId);
        this.a = personCenterModel;
        personCenterModel.Y(this.c);
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

    @Override // com.baidu.tieba.j9a.g
    public void a(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.a.loadData();
        }
    }

    public void e(int i) {
        j9a j9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && (j9aVar = this.b) != null) {
            j9aVar.v(i);
        }
    }

    public void i(String str) {
        t8a S;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, str) == null) && (S = this.a.S()) != null && S.A() != null) {
            S.A().setName_show(str);
            j9a j9aVar = this.b;
            if (j9aVar != null) {
                j9aVar.u();
            }
        }
    }

    public void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.a.Z(z);
            j9a j9aVar = this.b;
            if (j9aVar != null) {
                j9aVar.y(z);
            }
        }
    }

    public void d() {
        j9a j9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (j9aVar = this.b) != null) {
            j9aVar.s();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            j9a j9aVar = this.b;
            if (j9aVar != null) {
                j9aVar.w();
                this.b = null;
            }
            PersonCenterModel personCenterModel = this.a;
            if (personCenterModel != null) {
                personCenterModel.Y(null);
                this.c = null;
            }
        }
    }

    public void g() {
        j9a j9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (j9aVar = this.b) != null) {
            j9aVar.x();
        }
    }

    public void h() {
        j9a j9aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (j9aVar = this.b) != null) {
            j9aVar.z();
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            y7a.d().j(System.currentTimeMillis());
            this.a.loadData();
        }
    }
}
