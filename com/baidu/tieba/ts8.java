package com.baidu.tieba;

import android.app.Activity;
import android.view.View;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.e46;
import com.baidu.tieba.fv4;
import com.baidu.tieba.person.ProfileVirtualImageInfo;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ts8 extends fv4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MainTabActivity c;
    public final eq8 d;
    public h46 e;
    public String f;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts8 a;

        public a(ts8 ts8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                try {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 4) {
                        str = "&skin=dart";
                    } else if (skinType == 1) {
                        str = "&skin=night";
                    } else {
                        str = "";
                    }
                    UrlManager.getInstance().dealOneLink(this.a.c.getPageContext(), new String[]{h46.Q + str + "&from=2"});
                } catch (Exception e) {
                    BdLog.e("openPageByUrl fail:" + e.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements e46.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ts8 a;

        public b(ts8 ts8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ts8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ts8Var;
        }

        @Override // com.baidu.tieba.e46.e
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ts8(MainTabActivity mainTabActivity, eq8 eq8Var) {
        super(mainTabActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mainTabActivity, eq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Activity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = eq8Var;
        this.c = mainTabActivity;
        this.f = this.b.getString(R.string.obfuscated_res_0x7f0f1424);
    }

    @Override // com.baidu.tieba.fv4
    public void b() {
        h46 h46Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (h46Var = this.e) != null) {
            h46Var.h();
        }
    }

    @Override // com.baidu.tieba.fv4
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            h46 h46Var = this.e;
            if (h46Var == null) {
                c();
                return;
            }
            h46Var.z(new b(this));
            this.e.V(this.f, "setVirtualImage", true, false);
        }
    }

    @Override // com.baidu.tieba.fv4
    public void d(fv4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            eq8 eq8Var = this.d;
            if (eq8Var != null && eq8Var.B() != null) {
                FragmentTabWidget fragmentTabWidget = this.d.B().getFragmentTabWidget();
                if (fragmentTabWidget != null && fragmentTabWidget.getChildCount() >= 4) {
                    if (!ProfileVirtualImageInfo.getInstance().isNetDataRespond()) {
                        aVar.a(false);
                        return;
                    }
                    h46 h46Var = new h46(this.c.getPageContext(), fragmentTabWidget.getChildAt(4));
                    this.e = h46Var;
                    h46Var.L(R.drawable.obfuscated_res_0x7f0802f1);
                    this.e.l(2);
                    this.e.o(48);
                    boolean z = true;
                    this.e.M(true);
                    this.e.P(-fj.f(this.b, R.dimen.tbds62));
                    this.e.C(R.color.CAM_X0101);
                    this.e.J(R.dimen.T_X09);
                    this.e.w(1);
                    this.e.n(3000);
                    this.e.A("setVirtualImage");
                    this.e.m(new a(this));
                    if (ProfileVirtualImageInfo.getInstance().getIsSetVirtualImage() == 1) {
                        z = false;
                    }
                    boolean d = this.e.d();
                    if (z && d) {
                        this.e.c(this.f, "setVirtualImage", true, false, aVar);
                        return;
                    } else {
                        aVar.a(false);
                        return;
                    }
                }
                aVar.a(false);
                return;
            }
            aVar.a(false);
        }
    }
}
