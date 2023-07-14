package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class yga extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final aga b;

    /* loaded from: classes8.dex */
    public class a implements aaa<w9a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yga a;

        /* renamed from: com.baidu.tieba.yga$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0546a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ w9a a;
            public final /* synthetic */ a b;

            public RunnableC0546a(a aVar, w9a w9aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, w9aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = w9aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                w9a w9aVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (w9aVar = this.a) != null) {
                    this.b.a.f(w9aVar);
                }
            }
        }

        public a(yga ygaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ygaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ygaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.aaa
        /* renamed from: b */
        public void a(w9a w9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w9aVar) == null) {
                this.a.a.runOnUiThread(new RunnableC0546a(this, w9aVar));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q55 a;

        public b(yga ygaVar, q55 q55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ygaVar, q55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = q55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q55 a;
        public final /* synthetic */ yga b;

        public c(yga ygaVar, q55 q55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ygaVar, q55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ygaVar;
            this.a = q55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
                this.b.g();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ q55 a;
        public final /* synthetic */ w9a b;
        public final /* synthetic */ yga c;

        public d(yga ygaVar, q55 q55Var, w9a w9aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ygaVar, q55Var, w9aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ygaVar;
            this.a = q55Var;
            this.b = w9aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                z9a z9aVar = new z9a();
                w9a w9aVar = this.b;
                if (w9aVar != null) {
                    z9aVar.g(w9aVar.a());
                    z9aVar.h(this.b.b());
                }
                new y9a(this.c.a, z9aVar).a();
                this.c.i();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yga(MainTabActivity mainTabActivity, pfa pfaVar) {
        super(2001384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, pfaVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = mainTabActivity;
        this.b = mainTabActivity.e;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.E == null) {
                mainTabActivity.E = new daa(mainTabActivity.getPageContext(), new a(this));
            }
            this.a.E.b();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }

    public final void f(w9a w9aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, w9aVar) == null) && !this.a.F && TbadkCoreApplication.isLogin() && this.a.z.intValue() == 8) {
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(this.a);
            newStyleStampDialogView.setStampData(w9aVar);
            q55 q55Var = new q55(this.a);
            q55Var.c(newStyleStampDialogView);
            q55Var.e();
            h();
            this.a.F = true;
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new b(this, q55Var));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new c(this, q55Var));
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new d(this, q55Var, w9aVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        aga agaVar;
        aga agaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = this.a.z.intValue();
            this.a.z = (Integer) customResponsedMessage.getData();
            if (this.a.z.intValue() == 1) {
                aga agaVar3 = this.b;
                if (agaVar3 != null && agaVar3.a() != null) {
                    this.b.a().a();
                }
            } else if (intValue == 1 && (agaVar = this.b) != null && agaVar.a() != null) {
                this.b.a().f();
            }
            if (this.a.z.intValue() == 21 && (agaVar2 = this.b) != null && agaVar2.a() != null) {
                this.b.a().c();
            }
            if (this.a.z.intValue() == 8) {
                oy5.c().k(true);
                aga agaVar4 = this.b;
                if (agaVar4 != null && agaVar4.a() != null) {
                    this.b.a().b();
                }
                if (!this.a.F) {
                    e();
                }
                if (TbadkCoreApplication.isLogin() && !iy5.b()) {
                    MainTabActivity mainTabActivity = this.a;
                    if (mainTabActivity.K && mainTabActivity.J) {
                        new iy5().c(this.a.getPageContext().getPageActivity());
                        return;
                    }
                    return;
                }
                return;
            }
            oy5.c().k(false);
            daa daaVar = this.a.E;
            if (daaVar != null) {
                daaVar.a();
                this.a.E = null;
            }
        }
    }
}
