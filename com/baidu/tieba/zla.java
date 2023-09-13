package com.baidu.tieba;

import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.BdDimDialog;
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
/* loaded from: classes9.dex */
public class zla extends CustomMessageListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity a;
    public final yka b;

    /* loaded from: classes9.dex */
    public class a implements uea<rea> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zla a;

        /* renamed from: com.baidu.tieba.zla$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class RunnableC0545a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ rea a;
            public final /* synthetic */ a b;

            public RunnableC0545a(a aVar, rea reaVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, reaVar};
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
                this.a = reaVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                rea reaVar;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (reaVar = this.a) != null) {
                    this.b.a.l(reaVar);
                }
            }
        }

        public a(zla zlaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zlaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zlaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.uea
        /* renamed from: b */
        public void a(rea reaVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reaVar) == null) {
                this.a.a.runOnUiThread(new RunnableC0545a(this, reaVar));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;

        public b(zla zlaVar, BdDimDialog bdDimDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zlaVar, bdDimDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bdDimDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;
        public final /* synthetic */ zla b;

        public c(zla zlaVar, BdDimDialog bdDimDialog) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zlaVar, bdDimDialog};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = zlaVar;
            this.a = bdDimDialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                UrlManager.getInstance().dealOneLink(this.b.a.getPageContext(), new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
                this.b.m();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BdDimDialog a;
        public final /* synthetic */ rea b;
        public final /* synthetic */ zla c;

        public d(zla zlaVar, BdDimDialog bdDimDialog, rea reaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zlaVar, bdDimDialog, reaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = zlaVar;
            this.a = bdDimDialog;
            this.b = reaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                tea teaVar = new tea();
                rea reaVar = this.b;
                if (reaVar != null) {
                    teaVar.g(reaVar.a());
                    teaVar.h(this.b.b());
                }
                new sea(this.c.a, teaVar).a();
                this.c.o();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zla(MainTabActivity mainTabActivity, kka kkaVar) {
        super(2001384);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, kkaVar};
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

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MainTabActivity mainTabActivity = this.a;
            if (mainTabActivity.E == null) {
                mainTabActivity.E = new xea(mainTabActivity.getPageContext(), new a(this));
            }
            this.a.E.b();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 3).param("obj_locate", 3));
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }

    public final void l(rea reaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, reaVar) == null) && !this.a.F && TbadkCoreApplication.isLogin() && this.a.z.intValue() == 8) {
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(this.a);
            newStyleStampDialogView.setStampData(reaVar);
            BdDimDialog bdDimDialog = new BdDimDialog(this.a);
            bdDimDialog.setContentView(newStyleStampDialogView);
            bdDimDialog.show();
            n();
            this.a.F = true;
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new b(this, bdDimDialog));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new c(this, bdDimDialog));
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new d(this, bdDimDialog, reaVar));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        yka ykaVar;
        yka ykaVar2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
            int intValue = this.a.z.intValue();
            this.a.z = (Integer) customResponsedMessage.getData();
            if (this.a.z.intValue() == 1) {
                yka ykaVar3 = this.b;
                if (ykaVar3 != null && ykaVar3.a() != null) {
                    this.b.a().a();
                }
            } else if (intValue == 1 && (ykaVar = this.b) != null && ykaVar.a() != null) {
                this.b.a().f();
            }
            if (this.a.z.intValue() == 21 && (ykaVar2 = this.b) != null && ykaVar2.a() != null) {
                this.b.a().c();
            }
            if (this.a.z.intValue() == 8) {
                px5.d().k(true);
                yka ykaVar4 = this.b;
                if (ykaVar4 != null && ykaVar4.a() != null) {
                    this.b.a().b();
                }
                if (!this.a.F) {
                    k();
                }
                if (TbadkCoreApplication.isLogin() && !kx5.b()) {
                    MainTabActivity mainTabActivity = this.a;
                    if (mainTabActivity.K && mainTabActivity.J) {
                        new kx5().c(this.a.getPageContext().getPageActivity());
                        return;
                    }
                    return;
                }
                return;
            }
            px5.d().k(false);
            xea xeaVar = this.a.E;
            if (xeaVar != null) {
                xeaVar.a();
                this.a.E = null;
            }
        }
    }
}
