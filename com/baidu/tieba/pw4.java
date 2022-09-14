package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.liveremind.LiveRemindConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
/* loaded from: classes5.dex */
public class pw4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pw4 g;
    public static int h;
    public static int i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-504297409, "Lcom/baidu/tieba/pw4$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-504297409, "Lcom/baidu/tieba/pw4$a;");
                    return;
                }
            }
            int[] iArr = new int[LiveRemindConfig.Scene.values().length];
            a = iArr;
            try {
                iArr[LiveRemindConfig.Scene.LIVE_BUBBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[LiveRemindConfig.Scene.LIVE_FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948076444, "Lcom/baidu/tieba/pw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948076444, "Lcom/baidu/tieba/pw4;");
                return;
            }
        }
        new Date();
        new Date();
    }

    public pw4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h();
    }

    public static pw4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (g == null) {
                synchronized (pw4.class) {
                    if (g == null) {
                        g = new pw4();
                    }
                }
            }
            return g;
        }
        return (pw4) invokeV.objValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? bx4.k().l(c(LiveRemindConfig.Scene.LIVE_BUBBLE), 0) : invokeV.intValue;
    }

    public final String c(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                return this.a;
            }
            if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                return this.d;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String d(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                return this.c;
            }
            if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                return this.f;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String e(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                return this.b;
            }
            if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                return this.e;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void f(LiveRemindConfig.Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, scene) == null) {
            int i2 = a.a[scene.ordinal()];
            if (i2 == 1) {
                bx4.k().x(d(scene), System.currentTimeMillis());
                i++;
                g(LiveRemindConfig.Scene.LIVE_BUBBLE);
            } else if (i2 != 2) {
            } else {
                bx4.k().x(d(scene), System.currentTimeMillis());
                h++;
                g(LiveRemindConfig.Scene.LIVE_FLOAT);
            }
        }
    }

    public final void g(LiveRemindConfig.Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, scene) == null) {
            bx4.k().w(c(scene), bx4.k().l(c(scene), 0) + 1);
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a = "key_live_bubble_remind_show_count" + TbadkCoreApplication.getCurrentAccount();
            this.b = "key_live_bubble_remind_show_time" + TbadkCoreApplication.getCurrentAccount();
            this.c = "key_live_bubble_last_show_time" + TbadkCoreApplication.getCurrentAccount();
            this.d = "key_live_top_float_remind_show_count" + TbadkCoreApplication.getCurrentAccount();
            this.e = "key_live_top_float_remind_show_time" + TbadkCoreApplication.getCurrentAccount();
            this.f = "key_live_top_float_last_show_time" + TbadkCoreApplication.getCurrentAccount();
        }
    }

    public final boolean i(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, scene)) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                i2 = i;
            } else {
                i2 = scene == LiveRemindConfig.Scene.LIVE_FLOAT ? h : 0;
            }
            return bx4.k().l(c(scene), 0) < LiveRemindConfig.c().b() && i2 < LiveRemindConfig.c().a();
        }
        return invokeL.booleanValue;
    }

    public boolean j(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scene)) == null) {
            if (!StringHelper.isTaday(bx4.k().m(e(scene), 0L))) {
                bx4.k().x(e(scene), System.currentTimeMillis());
                m(scene);
            }
            return i(scene) && k(scene);
        }
        return invokeL.booleanValue;
    }

    public final boolean k(LiveRemindConfig.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, scene)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long m = bx4.k().m(d(scene), currentTimeMillis);
            return currentTimeMillis == m || (currentTimeMillis - m) / 1000 >= LiveRemindConfig.c().d();
        }
        return invokeL.booleanValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            i = 0;
            h = 0;
            if (TbadkCoreApplication.isLogin()) {
                h();
            }
        }
    }

    public void m(LiveRemindConfig.Scene scene) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, scene) == null) {
            if (scene == LiveRemindConfig.Scene.LIVE_BUBBLE) {
                i = 0;
            } else if (scene == LiveRemindConfig.Scene.LIVE_FLOAT) {
                h = 0;
            }
            bx4.k().w(c(scene), 0);
        }
    }

    public void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            bx4.k().w(c(LiveRemindConfig.Scene.LIVE_BUBBLE), i2);
        }
    }
}
