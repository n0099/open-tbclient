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
import com.baidu.tieba.me5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Map;
/* loaded from: classes7.dex */
public class ne5 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static WeakReference<me5> b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me5 a;

        public a(me5 me5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = me5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
                boolean unused = ne5.a = true;
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ me5 a;

        public b(me5 me5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {me5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = me5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.t();
            }
        }
    }

    public static me5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            WeakReference<me5> weakReference = b;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (me5) invokeV.objValue;
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

    public static me5 d(View view2, TbPageContext<?> tbPageContext, Map<String, Object> map, long j, long j2, me5.h hVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{view2, tbPageContext, map, Long.valueOf(j), Long.valueOf(j2), hVar})) == null) {
            TbLog defaultLog = DefaultLog.getInstance();
            defaultLog.i("PUSH_OPEN_FLOAT", "广告是否正在展示：" + TbSingleton.getInstance().isSplashShowing() + "  冷起广告是否正在展示：" + MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW + "  热起广告是否正在展示：" + LogoActivityConfig.IS_HOT_SPLASH_SHOW);
            me5 me5Var = new me5(tbPageContext, map);
            if (hVar != null) {
                me5Var.x(hVar);
            }
            if (view2 != null) {
                me5Var.y(view2);
            }
            if (j <= 0) {
                me5Var.A();
                a = true;
            } else {
                SafeHandler.getInst().postDelayed(new a(me5Var), j);
            }
            if (j2 > 0) {
                SafeHandler.getInst().postDelayed(new b(me5Var), j2);
            }
            b = new WeakReference<>(me5Var);
            return me5Var;
        }
        return (me5) invokeCommon.objValue;
    }

    public static me5 f(View view2, TbPageContext<?> tbPageContext, Map<String, Object> map, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{view2, tbPageContext, map, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (tbPageContext != null && !MainTabActivityConfig.IS_MAIN_TAB_SPLASH_SHOW && !eg5.j()) {
                return d(view2, tbPageContext, map, j, j2, null);
            }
            return null;
        }
        return (me5) invokeCommon.objValue;
    }
}
