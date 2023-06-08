package com.baidu.tieba;

import android.app.Activity;
import android.os.CountDownTimer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.oy5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class tv5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<zl0> a;
    public final Activity b;
    public CountDownTimer c;
    public long d;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        /* renamed from: com.baidu.tieba.tv5$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC0472a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ zl0 a;
            public final /* synthetic */ a b;

            public RunnableC0472a(a aVar, zl0 zl0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, zl0Var};
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
                this.a = zl0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((this.b.a.b instanceof s0a) && ((s0a) this.b.a.b).s0().s()) {
                        return;
                    }
                    this.b.a.s(this.a);
                }
            }
        }

        public a(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, strArr)) == null) {
                this.a.p();
                if (ListUtils.isEmpty(this.a.a)) {
                    return null;
                }
                TbSingleton.getInstance();
                if (TbSingleton.getExceptInsertAdDiaShow()) {
                    return null;
                }
                if ((this.a.b instanceof s0a) && ((s0a) this.a.b).s0().s()) {
                    return null;
                }
                Iterator it = this.a.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    zl0 zl0Var = (zl0) it.next();
                    if (zl0Var != null && zl0Var.p != null && zl0Var.c == AdDownloadStatus.COMPLETED && this.a.n(zl0Var)) {
                        wg.a().post(new RunnableC0472a(this, zl0Var));
                        break;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Comparator<zl0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(zl0 zl0Var, zl0 zl0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, zl0Var, zl0Var2)) == null) {
                long j = zl0Var.m;
                long j2 = zl0Var2.m;
                if (j > j2) {
                    return -1;
                }
                if (j < j2) {
                    return 1;
                }
                return 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public class c implements oy5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ zl0 a;
        public final /* synthetic */ oy5 b;
        public final /* synthetic */ tv5 c;

        public c(tv5 tv5Var, zl0 zl0Var, oy5 oy5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var, zl0Var, oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tv5Var;
            this.a = zl0Var;
            this.b = oy5Var;
        }

        @Override // com.baidu.tieba.oy5.h
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == 1) {
                    AdAppStateManager.instance().register(this.a);
                    this.c.l(this.a);
                    this.b.l();
                }
                this.c.k(this.a, i, System.currentTimeMillis() - this.c.d);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements oy5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tv5 a;

        public d(tv5 tv5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tv5Var;
        }

        @Override // com.baidu.tieba.oy5.g
        public void dismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.cancel();
                this.a.c = null;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oy5 a;
        public final /* synthetic */ tv5 b;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(tv5 tv5Var, long j, long j2, oy5 oy5Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tv5Var, Long.valueOf(j), Long.valueOf(j2), oy5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = tv5Var;
            this.a = oy5Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
                this.b.c = null;
            }
        }
    }

    public tv5(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0L;
        this.b = activity;
    }

    public final void l(zl0 zl0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zl0Var) == null) && zl0Var != null && (file = zl0Var.h) != null) {
            UtilHelper.installApkFile(this.b, file);
        }
    }

    public final boolean m(zl0 zl0Var) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zl0Var)) == null) {
            if (zl0Var == null || (file = zl0Var.h) == null || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void t(oy5 oy5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, oy5Var) == null) && this.c == null) {
            e eVar = new e(this, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, oy5Var);
            this.c = eVar;
            eVar.start();
        }
    }

    public final void q(oy5 oy5Var, zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, oy5Var, zl0Var) == null) {
            oy5Var.t(new c(this, zl0Var, oy5Var));
            oy5Var.q(new d(this));
        }
    }

    public final void k(zl0 zl0Var, int i, long j) {
        String str;
        dm0 dm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{zl0Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            String str2 = null;
            if (zl0Var != null && (dm0Var = zl0Var.p) != null) {
                str2 = dm0Var.h;
                str = dm0Var.a;
            } else {
                str = null;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AD_RETARGET_TIPS_CLICK);
            statisticItem.param("obj_source", str2).param("obj_type", i);
            TiebaStatic.log(statisticItem);
            ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(ClogBuilder.Page.AD_START_INSTALL_TIPS.type);
            if (i == 1) {
                v.i(ClogBuilder.Area.INSTALL_NOW_BUTTON);
            } else if (i == 2) {
                v.i(ClogBuilder.Area.CLOSE_BTN);
            } else if (i == 3) {
                v.i(ClogBuilder.Area.HOTAREA);
            }
            v.k(String.valueOf(j));
            v.l(String.valueOf(5000L));
            if (!StringUtils.isNull(str)) {
                v.p(str);
            }
            n31.b(v);
        }
    }

    public final boolean n(zl0 zl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, zl0Var)) == null) {
            if (zl0Var == null) {
                return false;
            }
            int n = n95.m().n("key_ad_retarget_tips_day_count", 0);
            if (!TimeHelper.isSameDay(n95.m().o("key_ad_retarget_tips_time", 0L), System.currentTimeMillis())) {
                n95.m().z("key_ad_retarget_tips_day_count", 0);
                n = 0;
            }
            if (n >= TbSingleton.getInstance().mAdFloatTipsDayLimitCount) {
                return false;
            }
            if (n95.m().n("key_ad_retarget_tips_app_count_" + zl0Var.d, 0) >= TbSingleton.getInstance().mAdFloatTipsAppLimitCount || UtilHelper.isInstallApk(this.b, zl0Var.d) || !m(zl0Var)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            new a(this).execute(new String[0]);
        }
    }

    public final void p() {
        HashMap<String, zl0> a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (a2 = ql0.b().a()) != null && a2.size() > 0) {
            ArrayList<zl0> arrayList = new ArrayList<>(a2.values());
            this.a = arrayList;
            x21.m(arrayList, new b(this));
        }
    }

    public final void r(zl0 zl0Var) {
        String str;
        dm0 dm0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zl0Var) == null) {
            String str2 = null;
            if (zl0Var != null && (dm0Var = zl0Var.p) != null) {
                str2 = dm0Var.h;
                str = dm0Var.a;
            } else {
                str = null;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AD_RETARGET_TIPS_SHOW);
            statisticItem.param("obj_source", str2);
            TiebaStatic.log(statisticItem);
            ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(ClogBuilder.Page.AD_START_INSTALL_TIPS.type);
            if (!StringUtils.isNull(str)) {
                v.p(str);
            }
            n31.b(v);
        }
    }

    public final void s(zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, zl0Var) == null) {
            oy5 oy5Var = new oy5(this.b, 48);
            oy5Var.u(zl0Var.p.h);
            oy5Var.p(TbadkCoreApplication.getInst().getString(R.string.not_install_apk_tips));
            oy5Var.s(TbadkCoreApplication.getInst().getString(R.string.downloaded_install));
            oy5Var.r(zl0Var.p.g);
            oy5Var.o(8);
            if (oy5Var.v()) {
                this.d = System.currentTimeMillis();
                t(oy5Var);
                u(zl0Var);
                q(oy5Var, zl0Var);
                r(zl0Var);
            }
        }
    }

    public final void u(zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zl0Var) == null) {
            n95.m().z("key_ad_retarget_tips_day_count", n95.m().n("key_ad_retarget_tips_day_count", 0) + 1);
            n95.m().A("key_ad_retarget_tips_time", System.currentTimeMillis());
            String str = "key_ad_retarget_tips_app_count_" + zl0Var.d;
            n95.m().z(str, n95.m().n(str, 0) + 1);
        }
    }
}
