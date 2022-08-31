package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.business.inserting.NadInsertingBaseView;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.nadcore.requester.NadRequester;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.nf0;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class od7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean n = true;
    public static volatile od7 o;
    public static boolean p;
    public static boolean q;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;
    public Activity b;
    public View c;
    public NadInsertingBaseView d;
    public RoundRelativeLayout e;
    public RoundRelativeLayout f;
    public ImageView g;
    public boolean h;
    public boolean i;
    public e j;
    public boolean k;
    public f l;
    public mf0 m;

    /* loaded from: classes5.dex */
    public class a implements mf0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public a(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // com.baidu.tieba.mf0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.mf0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        @Override // com.baidu.tieba.mf0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
                statisticItem.param("obj_type", "a002").param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.mf0
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.g != null) {
                    this.a.g.setVisibility(8);
                }
                this.a.l();
                this.a.d = null;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.TRUE));
                if (this.a.h) {
                    this.a.h = false;
                    return;
                }
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
                statisticItem.param("obj_type", "a002").param("obj_param1", 1).param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.mf0
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_type", "a002");
                TiebaStatic.log(statisticItem);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public b(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) || this.a.l == null) {
                return;
            }
            this.a.l.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        public c(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.a.isShowing()) {
                this.a.a.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ od7 a;

        /* loaded from: classes5.dex */
        public class a implements NadRequester.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            /* renamed from: com.baidu.tieba.od7$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0350a implements nf0.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0350a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // com.baidu.tieba.nf0.d
                public void a(@NonNull NadInsertingBaseView nadInsertingBaseView) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, nadInsertingBaseView) == null) {
                        this.a.a.a.d = nadInsertingBaseView;
                        if (this.a.a.a.j != null) {
                            this.a.a.a.j.a();
                        }
                    }
                }

                @Override // com.baidu.tieba.nf0.d
                public void onFail() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                    }
                }
            }

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            @Override // com.baidu.nadcore.requester.NadRequester.b
            public void a(@NonNull NadRequester.Error error) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, error) == null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 1).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }

            @Override // com.baidu.nadcore.requester.NadRequester.b
            public void b(@NonNull List<AdBaseModel> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    nf0.b(this.a.a.b, this.a.a.e, list, this.a.a.m, new C0350a(this));
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 0).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public d(od7 od7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {od7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = od7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                nf0.a("1638177515997", new a(this));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface f {
        void dismiss();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948028487, "Lcom/baidu/tieba/od7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948028487, "Lcom/baidu/tieba/od7;");
        }
    }

    public od7(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.h = false;
        this.i = false;
        this.k = false;
        this.m = new a(this);
        this.b = activity;
        p();
    }

    public static void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST_SUCCESS_NOT_SHOW);
            statisticItem.param("obj_type", "a002").param("obj_param1", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            if (str.contains(UrlSchemaHelper.SCHEMA_GAME_RECOMMENT_PAGE) || str.contains("com.baidu.tieba://unidispatch/homepage") || str.contains("com.baidu.tieba://unidispatch/activitypage") || "com.baidu.tieba://unidispatch/hometab".equals(str)) {
                q = true;
            }
        }
    }

    public static od7 m(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, activity)) == null) {
            if (o == null) {
                synchronized (od7.class) {
                    if (o == null) {
                        o = new od7(activity);
                    }
                }
            }
            return o;
        }
        return (od7) invokeL.objValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            return !StringUtils.isNull(clipBoardContent) && fj4.j.matcher(clipBoardContent).find();
        }
        return invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            o = null;
            l();
        }
    }

    public boolean C(String str, int i, int i2, long j, e eVar, boolean z) {
        InterceptResult invokeCommon;
        boolean t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), eVar, Boolean.valueOf(z)})) == null) {
            this.i = z;
            this.j = eVar;
            if ("1".equals(str)) {
                t = s();
            } else {
                t = t(i, i2, j);
            }
            if (t) {
                return D(str);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Activity activity = this.b;
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.REQUEST_AD_TIME);
            statisticItem.param("obj_type", "a002").param("obj_param1", str);
            TiebaStatic.log(statisticItem);
            new d(this).execute(new Void[0]);
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.e == null || this.f == null) {
            return;
        }
        if (TbadkSettings.getInst().loadInt("skin_", 0) == 1) {
            this.e.post(new Runnable() { // from class: com.baidu.tieba.nd7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        od7.this.z();
                    }
                }
            });
        } else {
            this.f.setVisibility(8);
        }
    }

    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.l = fVar;
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long m = su4.k().m("key_home_insert_ad_show_time", 0L);
            int l = su4.k().l("key_home_insert_ad_show_num", 0);
            if (StringHelper.isTaday(m)) {
                su4.k().w("key_home_insert_ad_show_num", l + 1);
                return;
            }
            su4.k().x("key_home_insert_ad_show_time", System.currentTimeMillis());
            su4.k().w("key_home_insert_ad_show_num", 1);
        }
    }

    public boolean I(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            if (this.d != null) {
                AlertDialog alertDialog = this.a;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    if (!u(i, i2)) {
                        this.d = null;
                        return false;
                    }
                    RoundRelativeLayout roundRelativeLayout = this.e;
                    if (roundRelativeLayout != null) {
                        roundRelativeLayout.setVisibility(0);
                    }
                    ImageView imageView = this.g;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                    this.d.g();
                    boolean J = J();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.FALSE));
                    G();
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.SHOW_AD_TIME);
                    statisticItem.param("obj_type", "a002").param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                    return J;
                }
                return false;
            }
            this.i = true;
            return false;
        }
        return invokeII.booleanValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            Activity activity = this.b;
            if (activity == null || activity.isFinishing()) {
                return false;
            }
            AlertDialog alertDialog = this.a;
            if (alertDialog != null && alertDialog.isShowing()) {
                this.a.dismiss();
            }
            if (this.a == null) {
                this.a = new AlertDialog.Builder(this.b).create();
            }
            this.a.setCancelable(true);
            this.a.show();
            this.a.setOnDismissListener(new b(this));
            Window window = this.a.getWindow();
            window.getDecorView().setSystemUiVisibility(n());
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            window.setNavigationBarColor(0);
            window.setAttributes(attributes);
            E();
            View view2 = this.c;
            if (view2 != null) {
                this.a.setContentView(view2);
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.d == null) {
            return;
        }
        this.h = true;
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
        statisticItem.param("obj_type", "a002").param("obj_param1", 2).param("obj_source", 1);
        TiebaStatic.log(statisticItem);
        this.d.a();
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            sg.a().post(new c(this));
        }
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 1280;
        }
        return invokeV.intValue;
    }

    public void o(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.k = z;
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.obfuscated_res_0x7f0d003d, (ViewGroup) null);
            this.c = inflate;
            this.e = (RoundRelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f090d71);
            this.f = (RoundRelativeLayout) this.c.findViewById(R.id.obfuscated_res_0x7f090d72);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = (ri.k(this.b) * 837) / 1076;
            layoutParams.height = -2;
            this.e.setLayoutParams(layoutParams);
            this.e.setRoundLayoutRadius(ls4.y(R.string.J_X06));
            this.f.setRoundLayoutRadius(ls4.y(R.string.J_X06));
            ImageView imageView = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f090d70);
            this.g = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.md7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        od7.this.y(view2);
                    }
                }
            });
        }
    }

    public final boolean q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
            return r() && i == i2 && TbadkCoreApplication.getInst().getHomeBarShowType() == 1;
        }
        return invokeII.booleanValue;
    }

    public final boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int h = z8.g().h();
            Activity f2 = z8.g().f(h - 1);
            String localClassName = f2 != null ? f2.getLocalClassName() : "";
            if (StringUtils.isNull(localClassName) || !localClassName.contains("MainTabActivity")) {
                Activity f3 = z8.g().f(h - 2);
                String localClassName2 = f3 != null ? f3.getLocalClassName() : "";
                return !StringUtils.isNull(localClassName) && !StringUtils.isNull(localClassName2) && localClassName.contains("LogoActivity") && localClassName2.contains("MainTabActivity");
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if ((!p || q) && UbsABTestHelper.isRequestInsertAd() && PermissionUtil.isAgreePrivacyPolicy()) {
                if (this.k || !w()) {
                    jy4 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                    return (x() || (homeInsertAdData != null && homeInsertAdData.b() == 0) || v()) ? false : true;
                }
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t(int i, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            AlertDialog alertDialog = this.a;
            if ((alertDialog == null || !alertDialog.isShowing()) && s()) {
                if (p) {
                    if (!q) {
                        return false;
                    }
                } else if (!q(i, i2)) {
                    return false;
                }
                jy4 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                return (((System.currentTimeMillis() - j) / 1000) > ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 1 : (((System.currentTimeMillis() - j) / 1000) == ((long) (homeInsertAdData != null ? homeInsertAdData.c() : 30)) ? 0 : -1)) > 0;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean u(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                A(3);
                return false;
            } else if (TbSingleton.getInstance().getExceptInsertAdDiaShow()) {
                A(1);
                return false;
            } else if (!this.k && w()) {
                A(1);
                return false;
            } else {
                if (p) {
                    if (!q) {
                        A(3);
                        return false;
                    }
                } else if (!q(i, i2)) {
                    A(2);
                    return false;
                }
                if (v()) {
                    A(3);
                    return false;
                }
                return true;
            }
        }
        return invokeII.booleanValue;
    }

    public final boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (StringHelper.isTaday(su4.k().m("key_home_insert_ad_show_time", 0L))) {
                int l = su4.k().l("key_home_insert_ad_show_num", 0);
                jy4 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                if (l >= (homeInsertAdData != null ? homeInsertAdData.a() : 1)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ void y(View view2) {
        k();
    }

    public /* synthetic */ void z() {
        int width = this.e.getWidth();
        int height = this.e.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(0);
        ns4.d(this.f).f(R.color.CAM_X0503);
    }
}
