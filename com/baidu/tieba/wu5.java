package com.baidu.tieba;

import android.app.Activity;
import android.os.CountDownTimer;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.nadcore.download.consts.AdDownloadStatus;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.searchbox.live.interfaces.defaultimpl.service.LivePreStartPlayServiceImpl;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.nx5;
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
/* loaded from: classes8.dex */
public class wu5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<el0> a;
    public final Activity b;
    public CountDownTimer c;
    public long d;

    /* loaded from: classes8.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu5 a;

        /* renamed from: com.baidu.tieba.wu5$a$a  reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0529a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ el0 a;
            public final /* synthetic */ a b;

            public RunnableC0529a(a aVar, el0 el0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, el0Var};
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
                this.a = el0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((this.b.a.b instanceof aea) && ((aea) this.b.a.b).q0().hasDialog()) {
                        return;
                    }
                    this.b.a.s(this.a);
                }
            }
        }

        public a(wu5 wu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wu5Var;
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
                if ((this.a.b instanceof aea) && ((aea) this.a.b).q0().hasDialog()) {
                    return null;
                }
                Iterator it = this.a.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    el0 el0Var = (el0) it.next();
                    if (el0Var != null && el0Var.p != null && el0Var.c == AdDownloadStatus.COMPLETED && this.a.n(el0Var)) {
                        SafeHandler.getInst().post(new RunnableC0529a(this, el0Var));
                        break;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Comparator<el0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(wu5 wu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu5Var};
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
        public int compare(el0 el0Var, el0 el0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, el0Var, el0Var2)) == null) {
                long j = el0Var.m;
                long j2 = el0Var2.m;
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

    /* loaded from: classes8.dex */
    public class c implements nx5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ el0 a;
        public final /* synthetic */ nx5 b;
        public final /* synthetic */ wu5 c;

        public c(wu5 wu5Var, el0 el0Var, nx5 nx5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu5Var, el0Var, nx5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = wu5Var;
            this.a = el0Var;
            this.b = nx5Var;
        }

        @Override // com.baidu.tieba.nx5.h
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

    /* loaded from: classes8.dex */
    public class d implements nx5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wu5 a;

        public d(wu5 wu5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wu5Var;
        }

        @Override // com.baidu.tieba.nx5.g
        public void dismiss() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.c != null) {
                this.a.c.cancel();
                this.a.c = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nx5 a;
        public final /* synthetic */ wu5 b;

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(wu5 wu5Var, long j, long j2, nx5 nx5Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wu5Var, Long.valueOf(j), Long.valueOf(j2), nx5Var};
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
            this.b = wu5Var;
            this.a = nx5Var;
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

    public wu5(Activity activity) {
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

    public final void l(el0 el0Var) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, el0Var) == null) && el0Var != null && (file = el0Var.h) != null) {
            UtilHelper.installApkFile(this.b, file);
        }
    }

    public final boolean m(el0 el0Var) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, el0Var)) == null) {
            if (el0Var == null || (file = el0Var.h) == null || !file.exists()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void t(nx5 nx5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, nx5Var) == null) && this.c == null) {
            e eVar = new e(this, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, nx5Var);
            this.c = eVar;
            eVar.start();
        }
    }

    public final void q(nx5 nx5Var, el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, nx5Var, el0Var) == null) {
            nx5Var.t(new c(this, el0Var, nx5Var));
            nx5Var.q(new d(this));
        }
    }

    public final void k(el0 el0Var, int i, long j) {
        String str;
        il0 il0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{el0Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            String str2 = null;
            if (el0Var != null && (il0Var = el0Var.p) != null) {
                str2 = il0Var.h;
                str = il0Var.a;
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
            q31.e(v);
        }
    }

    public final boolean n(el0 el0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, el0Var)) == null) {
            if (el0Var == null) {
                return false;
            }
            int i = SharedPrefHelper.getInstance().getInt("key_ad_retarget_tips_day_count", 0);
            if (!TimeHelper.isSameDay(SharedPrefHelper.getInstance().getLong("key_ad_retarget_tips_time", 0L), System.currentTimeMillis())) {
                SharedPrefHelper.getInstance().putInt("key_ad_retarget_tips_day_count", 0);
                i = 0;
            }
            if (i >= TbSingleton.getInstance().mAdFloatTipsDayLimitCount) {
                return false;
            }
            if (SharedPrefHelper.getInstance().getInt("key_ad_retarget_tips_app_count_" + el0Var.d, 0) >= TbSingleton.getInstance().mAdFloatTipsAppLimitCount || UtilHelper.isInstallApk(this.b, el0Var.d) || !m(el0Var)) {
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
        HashMap<String, el0> a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (a2 = vk0.b().a()) != null && a2.size() > 0) {
            ArrayList<el0> arrayList = new ArrayList<>(a2.values());
            this.a = arrayList;
            a31.m(arrayList, new b(this));
        }
    }

    public final void r(el0 el0Var) {
        String str;
        il0 il0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, el0Var) == null) {
            String str2 = null;
            if (el0Var != null && (il0Var = el0Var.p) != null) {
                str2 = il0Var.h;
                str = il0Var.a;
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
            q31.e(v);
        }
    }

    public final void s(el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, el0Var) == null) {
            nx5 nx5Var = new nx5(this.b, 48);
            nx5Var.u(el0Var.p.h);
            nx5Var.p(TbadkCoreApplication.getInst().getString(R.string.not_install_apk_tips));
            nx5Var.s(TbadkCoreApplication.getInst().getString(R.string.downloaded_install));
            nx5Var.r(el0Var.p.g);
            nx5Var.o(8);
            if (nx5Var.v()) {
                this.d = System.currentTimeMillis();
                t(nx5Var);
                u(el0Var);
                q(nx5Var, el0Var);
                r(el0Var);
            }
        }
    }

    public final void u(el0 el0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, el0Var) == null) {
            SharedPrefHelper.getInstance().putInt("key_ad_retarget_tips_day_count", SharedPrefHelper.getInstance().getInt("key_ad_retarget_tips_day_count", 0) + 1);
            SharedPrefHelper.getInstance().putLong("key_ad_retarget_tips_time", System.currentTimeMillis());
            String str = "key_ad_retarget_tips_app_count_" + el0Var.d;
            SharedPrefHelper.getInstance().putInt(str, SharedPrefHelper.getInstance().getInt(str, 0) + 1);
        }
    }
}
