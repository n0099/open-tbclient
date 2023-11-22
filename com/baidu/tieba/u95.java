package com.baidu.tieba;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.log.DefaultLog;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.atomData.LogoActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.log.TbLog;
import com.baidu.tieba.t95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes8.dex */
public class u95 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<t95> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t95 a;

        public a(t95 t95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t95Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B();
                boolean unused = u95.a = true;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t95 a;

        public b(t95 t95Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t95Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t95Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t();
            }
        }
    }

    public static t95 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            WeakReference<t95> weakReference = b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (t95) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            SharedPrefHelper.getInstance().putLong("key_live_remind_float_view", System.currentTimeMillis());
        }
    }

    public static t95 d(View view2, TbPageContext<?> tbPageContext, Map<String, Object> map, long j, long j2, t95.h hVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view2, tbPageContext, map, Long.valueOf(j), Long.valueOf(j2), hVar})) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("PUSH_OPEN_FLOAT", "广告是否正在展示：" + TbSingleton.getInstance().isSplashShowing() + "  冷起广告是否正在展示：" + MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW + "  热起广告是否正在展示：" + LogoActivityConfig.IS_HOT_SPLASH_SHOW);
            t95 t95Var = new t95(tbPageContext, map);
            if (hVar != null) {
                t95Var.y(hVar);
            }
            if (view2 != null) {
                t95Var.z(view2);
            }
            if (j <= 0) {
                t95Var.B();
                a = true;
            } else {
                SafeHandler.getInst().postDelayed(new a(t95Var), j);
            }
            if (j2 > 0) {
                SafeHandler.getInst().postDelayed(new b(t95Var), j2);
            }
            b = new WeakReference<>(t95Var);
            return t95Var;
        }
        return (t95) invokeCommon.objValue;
    }

    public static t95 f(View view2, TbPageContext<?> tbPageContext, Map<String, Object> map, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{view2, tbPageContext, map, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (tbPageContext != null && !MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !kb5.j()) {
                return d(view2, tbPageContext, map, j, j2, null);
            }
            return null;
        }
        return (t95) invokeCommon.objValue;
    }
}
