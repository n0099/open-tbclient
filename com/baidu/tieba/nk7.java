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
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.ih0;
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
public class nk7 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean m = true;
    public static volatile nk7 n;
    public static boolean o;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;
    public AlertDialog a;
    public Activity b;
    public View c;
    public NadInsertingBaseView d;
    public RoundRelativeLayout e;
    public RoundRelativeLayout f;
    public ImageView g;
    public boolean h;
    public e i;
    public boolean j;
    public f k;
    public hh0 l;

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes5.dex */
    public interface f {
        void dismiss();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948005423, "Lcom/baidu/tieba/nk7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948005423, "Lcom/baidu/tieba/nk7;");
        }
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 1280;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class d extends BdAsyncTask<Void, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk7 a;

        /* loaded from: classes5.dex */
        public class a implements NadRequester.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            /* renamed from: com.baidu.tieba.nk7$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes5.dex */
            public class C0376a implements ih0.d {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public C0376a(a aVar) {
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

                @Override // com.baidu.tieba.ih0.d
                public void a(@NonNull NadInsertingBaseView nadInsertingBaseView) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null && interceptable.invokeL(1048576, this, nadInsertingBaseView) != null) {
                        return;
                    }
                    this.a.a.a.d = nadInsertingBaseView;
                    if (this.a.a.a.i != null) {
                        this.a.a.a.i.b();
                    }
                }

                @Override // com.baidu.tieba.ih0.d
                public void onFail() {
                    Interceptable interceptable = $ic;
                    if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.a.a.i != null) {
                        this.a.a.a.i.a();
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
                    if (this.a.a.i != null) {
                        this.a.a.i.a();
                    }
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 1).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }

            @Override // com.baidu.nadcore.requester.NadRequester.b
            public void b(@NonNull List<AdBaseModel> list) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                    ih0.b(this.a.a.b, this.a.a.e, list, this.a.a.l, new C0376a(this));
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST);
                    statisticItem.param("obj_type", "a002").param("obj_locate", 0).param("obj_source", 1);
                    TiebaStatic.log(statisticItem);
                }
            }
        }

        public d(nk7 nk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nk7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, voidArr)) == null) {
                ih0.a("1638177515997", new a(this));
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements hh0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk7 a;

        @Override // com.baidu.tieba.hh0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        @Override // com.baidu.tieba.hh0
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(nk7 nk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nk7Var;
        }

        @Override // com.baidu.tieba.hh0
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK);
                statisticItem.param("obj_type", "a002").param("obj_source", 1);
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.hh0
        public void onShow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW);
                statisticItem.param("obj_type", "a002");
                TiebaStatic.log(statisticItem);
            }
        }

        @Override // com.baidu.tieba.hh0
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                if (this.a.g != null) {
                    this.a.g.setVisibility(8);
                }
                this.a.m();
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
    }

    /* loaded from: classes5.dex */
    public class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk7 a;

        public b(nk7 nk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nk7Var;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) && this.a.k != null) {
                this.a.k.dismiss();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nk7 a;

        public c(nk7 nk7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nk7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nk7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a != null && this.a.a.isShowing()) {
                this.a.a.dismiss();
            }
        }
    }

    public nk7(Activity activity) {
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
        this.j = false;
        this.l = new a(this);
        this.b = activity;
        p();
    }

    public static void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            if (str.contains(UrlSchemaHelper.SCHEMA_GAME_RECOMMENT_PAGE) || str.contains("com.baidu.tieba://unidispatch/homepage") || str.contains("com.baidu.tieba://unidispatch/activitypage") || UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_ANYTAB.equals(str) || str.contains("homepage/activitypage") || str.contains("homepage/homeTab")) {
                p = true;
            }
        }
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

    public static void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST_SUCCESS_NOT_SHOW);
            statisticItem.param("obj_type", "a002").param("obj_param1", i);
            TiebaStatic.log(statisticItem);
        }
    }

    public static nk7 n(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, activity)) == null) {
            if (n == null) {
                synchronized (nk7.class) {
                    if (n == null) {
                        n = new nk7(activity);
                    }
                }
            }
            return n;
        }
        return (nk7) invokeL.objValue;
    }

    public void F(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public /* synthetic */ void y(View view2) {
        l();
    }

    public boolean k(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            if (this.d == null) {
                return false;
            }
            AlertDialog alertDialog = this.a;
            if (alertDialog != null && alertDialog.isShowing()) {
                return false;
            }
            if (!u(i, i2)) {
                this.d = null;
                return false;
            }
            return true;
        }
        return invokeII.booleanValue;
    }

    public final boolean q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048589, this, i, i2)) == null) {
            int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
            if (r() && i == i2 && homeBarShowType == 1) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            String clipBoardContent = UtilHelper.getClipBoardContent();
            if (StringUtils.isNull(clipBoardContent) || !lm4.j.matcher(clipBoardContent).find()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            n = null;
            m();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            ah.a().post(new c(this));
        }
    }

    public final boolean x() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (TbadkCoreApplication.getCurrentAccountInfo() != null && TbadkCoreApplication.getCurrentAccountInfo().getMemberCloseAdVipClose() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public /* synthetic */ void z() {
        int width = this.e.getWidth();
        int height = this.e.getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(0);
        rw4.d(this.f).f(R.color.CAM_X0503);
    }

    public boolean C(String str, int i, int i2, long j, e eVar, boolean z) {
        InterceptResult invokeCommon;
        boolean t;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), eVar, Boolean.valueOf(z)})) == null) {
            this.i = eVar;
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

    public final void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.e != null && this.f != null) {
            if (TbadkSettings.getInst().loadInt("skin_", 0) == 1) {
                this.e.post(new Runnable() { // from class: com.baidu.tieba.lk7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            nk7.this.z();
                        }
                    }
                });
            } else {
                this.f.setVisibility(8);
            }
        }
    }

    public void l() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.d != null) {
            this.h = true;
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CLOSE_AD_TIME);
            statisticItem.param("obj_type", "a002").param("obj_param1", 2).param("obj_source", 1);
            TiebaStatic.log(statisticItem);
            this.d.a();
        }
    }

    public final boolean v() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (StringHelper.isTaday(ry4.l().n("key_home_insert_ad_show_time", 0L))) {
                int m2 = ry4.l().m("key_home_insert_ad_show_num", 0);
                i25 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
                if (homeInsertAdData != null) {
                    i = homeInsertAdData.a();
                } else {
                    i = 1;
                }
                if (m2 >= i) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            long n2 = ry4.l().n("key_home_insert_ad_show_time", 0L);
            int m2 = ry4.l().m("key_home_insert_ad_show_num", 0);
            if (StringHelper.isTaday(n2)) {
                ry4.l().x("key_home_insert_ad_show_num", m2 + 1);
                return;
            }
            ry4.l().y("key_home_insert_ad_show_time", System.currentTimeMillis());
            ry4.l().x("key_home_insert_ad_show_num", 1);
        }
    }

    public final boolean s() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if ((o && !p) || !UbsABTestHelper.isRequestInsertAd() || !PermissionUtil.isAgreePrivacyPolicy()) {
                return false;
            }
            if (!this.j && w()) {
                return false;
            }
            i25 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
            if (homeInsertAdData != null && homeInsertAdData.b() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (x() || z || v()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean I(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            if (this.d == null) {
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
            J();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921667, Boolean.FALSE));
            G();
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.SHOW_AD_TIME);
            statisticItem.param("obj_type", "a002").param("obj_source", 1);
            TiebaStatic.log(statisticItem);
            return true;
        }
        return invokeII.booleanValue;
    }

    public boolean u(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
            if (MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW) {
                A(3);
                return false;
            }
            TbSingleton.getInstance();
            if (TbSingleton.getExceptInsertAdDiaShow()) {
                A(1);
                return false;
            } else if (!this.j && w()) {
                A(1);
                return false;
            } else {
                if (o) {
                    if (!p) {
                        A(3);
                        return false;
                    }
                } else if (!q(i, i2)) {
                    A(2);
                    return false;
                }
                if (!v()) {
                    return true;
                }
                A(3);
                return false;
            }
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
                AlertDialog create = new AlertDialog.Builder(this.b).create();
                this.a = create;
                GreyUtil.grey(create);
            }
            this.a.setCancelable(true);
            this.a.show();
            this.a.setOnDismissListener(new b(this));
            Window window = this.a.getWindow();
            window.getDecorView().setSystemUiVisibility(o());
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

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            View inflate = LayoutInflater.from(this.b).inflate(R.layout.activity_inserting_view, (ViewGroup) null);
            this.c = inflate;
            this.e = (RoundRelativeLayout) inflate.findViewById(R.id.home_insert_container);
            this.f = (RoundRelativeLayout) this.c.findViewById(R.id.home_insert_container_cover);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.width = (yi.l(this.b) * 837) / 1076;
            layoutParams.height = -2;
            this.e.setLayoutParams(layoutParams);
            this.e.setRoundLayoutRadius(pw4.z(R.string.J_X06));
            this.f.setRoundLayoutRadius(pw4.z(R.string.J_X06));
            ImageView imageView = (ImageView) this.c.findViewById(R.id.home_insert_close_icon);
            this.g = imageView;
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.mk7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        nk7.this.y(view2);
                    }
                }
            });
        }
    }

    public final boolean r() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int h = n9.g().h();
            Activity f2 = n9.g().f(h - 1);
            String str2 = "";
            if (f2 == null) {
                str = "";
            } else {
                str = f2.getLocalClassName();
            }
            if (!StringUtils.isNull(str) && str.contains("MainTabActivity")) {
                return true;
            }
            Activity f3 = n9.g().f(h - 2);
            if (f3 != null) {
                str2 = f3.getLocalClassName();
            }
            if (!StringUtils.isNull(str) && !StringUtils.isNull(str2) && str.contains("LogoActivity") && str2.contains("MainTabActivity")) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean t(int i, int i2, long j) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            AlertDialog alertDialog = this.a;
            if ((alertDialog != null && alertDialog.isShowing()) || !s()) {
                return false;
            }
            if (o) {
                if (!p) {
                    return false;
                }
            } else if (!q(i, i2)) {
                return false;
            }
            i25 homeInsertAdData = TbSingleton.getInstance().getHomeInsertAdData();
            int i3 = 30;
            if (homeInsertAdData != null) {
                i3 = homeInsertAdData.c();
            }
            if ((System.currentTimeMillis() - j) / 1000 > i3) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }
}
