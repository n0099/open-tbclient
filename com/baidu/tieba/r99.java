package com.baidu.tieba;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.data.IconPopData;
import com.baidu.tieba.stamp.view.NewStyleStampDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class r99 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DialogInterface.OnDismissListener a;
    public c b;

    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void b();

        void c();
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a05 a;
        public final /* synthetic */ r99 b;

        public a(r99 r99Var, a05 a05Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r99Var, a05Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = r99Var;
            this.a = a05Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.b.b != null) {
                    this.b.b.a();
                }
                this.a.a();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a05 a;
        public final /* synthetic */ q99 b;
        public final /* synthetic */ Activity c;
        public final /* synthetic */ r99 d;

        public b(r99 r99Var, a05 a05Var, q99 q99Var, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {r99Var, a05Var, q99Var, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = r99Var;
            this.a = a05Var;
            this.b = q99Var;
            this.c = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a();
                t99 t99Var = new t99();
                q99 q99Var = this.b;
                if (q99Var != null) {
                    t99Var.g(q99Var.a());
                    t99Var.h(this.b.b());
                }
                new s99(this.c, t99Var).a();
                this.d.j();
                if (this.d.b != null) {
                    this.d.b.c();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076599, "Lcom/baidu/tieba/r99;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076599, "Lcom/baidu/tieba/r99;");
                return;
            }
        }
        BdUniqueId.gen();
    }

    public r99() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        new NewStyleStampDialogView(TbadkCoreApplication.getInst().getContext());
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 2).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public static void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_STAMP_SHARE_DIALOG).param("obj_type", 1).param("obj_source", 1).param("obj_locate", 1));
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK).param("obj_locate", 31));
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            this.b = cVar;
        }
    }

    public void f(DialogInterface.OnDismissListener onDismissListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onDismissListener) == null) {
            this.a = onDismissListener;
        }
    }

    public /* synthetic */ void c(a05 a05Var, TbPageContext tbPageContext, View view2) {
        a05Var.a();
        if (tbPageContext != null) {
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{"https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&user_id=" + TbadkCoreApplication.getCurrentAccount()});
            h();
            c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
        }
    }

    public a05 d(IconPopData iconPopData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iconPopData)) == null) {
            if (iconPopData != null && iconPopData.getPic160() != null && iconPopData.getTitle() != null) {
                q99 q99Var = new q99();
                String pic160 = iconPopData.getPic160();
                q99Var.d(iconPopData.getTitle());
                q99Var.c(pic160);
                PollingModel.J0(iconPopData, true);
                return g(q99Var);
            }
            return null;
        }
        return (a05) invokeL.objValue;
    }

    public final a05 g(q99 q99Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, q99Var)) == null) {
            Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
            final TbPageContext tbPageContext = null;
            if (currentActivity == null) {
                return null;
            }
            if (currentActivity instanceof TbPageContextSupport) {
                tbPageContext = ((TbPageContextSupport) currentActivity).getPageContext();
            }
            NewStyleStampDialogView newStyleStampDialogView = new NewStyleStampDialogView(currentActivity);
            newStyleStampDialogView.setStampData(q99Var);
            final a05 a05Var = new a05(currentActivity);
            a05Var.c(newStyleStampDialogView);
            a05Var.d(this.a);
            a05Var.e();
            i();
            newStyleStampDialogView.getImgStampDialogCancelView().setOnClickListener(new a(this, a05Var));
            newStyleStampDialogView.getStampDialogLookView().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.p99
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        r99.this.c(a05Var, tbPageContext, view2);
                    }
                }
            });
            newStyleStampDialogView.getStampDialogShareView().setOnClickListener(new b(this, a05Var, q99Var, currentActivity));
            return a05Var;
        }
        return (a05) invokeL.objValue;
    }
}
