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
import com.baidu.tieba.wi5;
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
/* loaded from: classes6.dex */
public class tg5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<lk0> a;
    public final Activity b;
    public CountDownTimer c;
    public long d;

    /* loaded from: classes6.dex */
    public class a extends BdAsyncTask<String, Void, Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg5 a;

        /* renamed from: com.baidu.tieba.tg5$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class RunnableC0426a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ lk0 a;
            public final /* synthetic */ a b;

            public RunnableC0426a(a aVar, lk0 lk0Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, lk0Var};
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
                this.a = lk0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if ((this.b.a.b instanceof qp8) && ((qp8) this.b.a.b).d0().r()) {
                        return;
                    }
                    this.b.a.s(this.a);
                }
            }
        }

        public a(tg5 tg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tg5Var;
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
                if ((this.a.b instanceof qp8) && ((qp8) this.a.b).d0().r()) {
                    return null;
                }
                Iterator it = this.a.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    lk0 lk0Var = (lk0) it.next();
                    if (lk0Var != null && lk0Var.p != null && lk0Var.c == AdDownloadStatus.COMPLETED && this.a.n(lk0Var)) {
                        gh.a().post(new RunnableC0426a(this, lk0Var));
                        break;
                    }
                }
                return null;
            }
            return (Void) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Comparator<lk0> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(tg5 tg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg5Var};
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
        public int compare(lk0 lk0Var, lk0 lk0Var2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, lk0Var, lk0Var2)) == null) {
                long j = lk0Var.m;
                long j2 = lk0Var2.m;
                if (j > j2) {
                    return -1;
                }
                return j < j2 ? 1 : 0;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements wi5.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lk0 a;
        public final /* synthetic */ wi5 b;
        public final /* synthetic */ tg5 c;

        public c(tg5 tg5Var, lk0 lk0Var, wi5 wi5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg5Var, lk0Var, wi5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = tg5Var;
            this.a = lk0Var;
            this.b = wi5Var;
        }

        @Override // com.baidu.tieba.wi5.h
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

    /* loaded from: classes6.dex */
    public class d implements wi5.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tg5 a;

        public d(tg5 tg5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tg5Var;
        }

        @Override // com.baidu.tieba.wi5.g
        public void dismiss() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.c == null) {
                return;
            }
            this.a.c.cancel();
            this.a.c = null;
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wi5 a;
        public final /* synthetic */ tg5 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(tg5 tg5Var, long j, long j2, wi5 wi5Var) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tg5Var, Long.valueOf(j), Long.valueOf(j2), wi5Var};
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
            this.b = tg5Var;
            this.a = wi5Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.l();
                this.b.c = null;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            }
        }
    }

    public tg5(Activity activity) {
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

    public final void k(lk0 lk0Var, int i, long j) {
        String str;
        pk0 pk0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{lk0Var, Integer.valueOf(i), Long.valueOf(j)}) == null) {
            String str2 = null;
            if (lk0Var == null || (pk0Var = lk0Var.p) == null) {
                str = null;
            } else {
                str2 = pk0Var.h;
                str = pk0Var.a;
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
            h01.b(v);
        }
    }

    public final void l(lk0 lk0Var) {
        File file;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lk0Var) == null) || lk0Var == null || (file = lk0Var.h) == null) {
            return;
        }
        UtilHelper.installApkFile(this.b, file);
    }

    public final boolean m(lk0 lk0Var) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, lk0Var)) == null) ? (lk0Var == null || (file = lk0Var.h) == null || !file.exists()) ? false : true : invokeL.booleanValue;
    }

    public final boolean n(lk0 lk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lk0Var)) == null) {
            if (lk0Var == null) {
                return false;
            }
            int l = ox4.k().l("key_ad_retarget_tips_day_count", 0);
            if (!TimeHelper.isSameDay(ox4.k().m("key_ad_retarget_tips_time", 0L), System.currentTimeMillis())) {
                ox4.k().w("key_ad_retarget_tips_day_count", 0);
                l = 0;
            }
            if (l >= TbSingleton.getInstance().mAdFloatTipsDayLimitCount) {
                return false;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("key_ad_retarget_tips_app_count_");
            sb.append(lk0Var.d);
            return ox4.k().l(sb.toString(), 0) < TbSingleton.getInstance().mAdFloatTipsAppLimitCount && !UtilHelper.isInstallApk(this.b, lk0Var.d) && m(lk0Var);
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
        HashMap<String, lk0> a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (a2 = ck0.b().a()) == null || a2.size() <= 0) {
            return;
        }
        ArrayList<lk0> arrayList = new ArrayList<>(a2.values());
        this.a = arrayList;
        wz0.m(arrayList, new b(this));
    }

    public final void q(wi5 wi5Var, lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, wi5Var, lk0Var) == null) {
            wi5Var.s(new c(this, lk0Var, wi5Var));
            wi5Var.p(new d(this));
        }
    }

    public final void r(lk0 lk0Var) {
        String str;
        pk0 pk0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lk0Var) == null) {
            String str2 = null;
            if (lk0Var == null || (pk0Var = lk0Var.p) == null) {
                str = null;
            } else {
                str2 = pk0Var.h;
                str = pk0Var.a;
            }
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_AD_RETARGET_TIPS_SHOW);
            statisticItem.param("obj_source", str2);
            TiebaStatic.log(statisticItem);
            ClogBuilder v = new ClogBuilder().y(ClogBuilder.LogType.FREE_SHOW).v(ClogBuilder.Page.AD_START_INSTALL_TIPS.type);
            if (!StringUtils.isNull(str)) {
                v.p(str);
            }
            h01.b(v);
        }
    }

    public final void s(lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lk0Var) == null) {
            wi5 wi5Var = new wi5(this.b);
            wi5Var.t(lk0Var.p.h);
            wi5Var.o(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0cba));
            wi5Var.r(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0521));
            wi5Var.q(lk0Var.p.g);
            if (wi5Var.u()) {
                this.d = System.currentTimeMillis();
                t(wi5Var);
                u(lk0Var);
                q(wi5Var, lk0Var);
                r(lk0Var);
            }
        }
    }

    public final void t(wi5 wi5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, wi5Var) == null) && this.c == null) {
            e eVar = new e(this, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, LivePreStartPlayServiceImpl.PLAYER_TIME_OUT_DURATION, wi5Var);
            this.c = eVar;
            eVar.start();
        }
    }

    public final void u(lk0 lk0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, lk0Var) == null) {
            ox4.k().w("key_ad_retarget_tips_day_count", ox4.k().l("key_ad_retarget_tips_day_count", 0) + 1);
            ox4.k().x("key_ad_retarget_tips_time", System.currentTimeMillis());
            String str = "key_ad_retarget_tips_app_count_" + lk0Var.d;
            ox4.k().w(str, ox4.k().l(str, 0) + 1);
        }
    }
}
