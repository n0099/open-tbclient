package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TimeHelper;
import com.baidu.tieba.ad.AbsDataRecorder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/* loaded from: classes8.dex */
public class y56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile y56 g;
    public transient /* synthetic */ FieldHolder $fh;
    public AbsDataRecorder a;
    public String b;
    public String c;
    public Stack<HashMap<AbsDataRecorder.Scene, AbsDataRecorder>> d;
    public boolean e;
    public Map<String, Integer> f;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-307527854, "Lcom/baidu/tieba/y56$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-307527854, "Lcom/baidu/tieba/y56$a;");
                    return;
                }
            }
            int[] iArr = new int[AbsDataRecorder.Scene.values().length];
            a = iArr;
            try {
                iArr[AbsDataRecorder.Scene.RECOMMEND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbsDataRecorder.Scene.FRS_HOT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbsDataRecorder.Scene.FRS_NEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public y56() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = false;
        if (this.d == null) {
            this.d = new Stack<>();
        }
        this.b = "key_ad_free_guid_display_num_" + TbadkCoreApplication.getCurrentAccount();
        this.c = "key_ad_free_guid_display_time_" + TbadkCoreApplication.getCurrentAccount();
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            a();
            b();
            if (TbadkCoreApplication.isLogin()) {
                this.b = "key_ad_free_guid_display_num_" + TbadkCoreApplication.getCurrentAccount();
                this.c = "key_ad_free_guid_display_time_" + TbadkCoreApplication.getCurrentAccount();
            } else {
                v56.e().a();
            }
            this.a.a();
        }
    }

    public static y56 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (g == null) {
                synchronized (y56.class) {
                    if (g == null) {
                        g = new y56();
                    }
                }
            }
            return g;
        }
        return (y56) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            r95.p().Q(this.b);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            r95.p().Q(this.c);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HashMap<AbsDataRecorder.Scene, AbsDataRecorder> hashMap = new HashMap<>();
            hashMap.put(AbsDataRecorder.Scene.FRS_HOT, null);
            hashMap.put(AbsDataRecorder.Scene.FRS_NEW, null);
            this.d.push(hashMap);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && !this.d.isEmpty()) {
            this.d.pop();
        }
    }

    public final AbsDataRecorder f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new z56();
            }
            return this.a;
        }
        return (AbsDataRecorder) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (TbadkCoreApplication.isLogin() && TbadkCoreApplication.getCurrentMemberType() == 0 && v56.e().i()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            r95.p().F(this.b, r95.p().q(this.b, 0) + 1);
            r95.p().H(this.c, System.currentTimeMillis());
        }
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!TimeHelper.isSameDay(r95.p().r(this.c, 0L), System.currentTimeMillis())) {
                a();
            }
            return r95.p().q(this.b, 0);
        }
        return invokeV.intValue;
    }

    public AbsDataRecorder g(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, scene)) == null) {
            int i = a.a[scene.ordinal()];
            if (i != 1) {
                if (i != 2 && i != 3) {
                    return null;
                }
                return i(scene);
            }
            return f();
        }
        return (AbsDataRecorder) invokeL.objValue;
    }

    public int j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            Map<String, Integer> map = this.f;
            if (map != null && map.get(str) != null) {
                return this.f.get(str).intValue();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public boolean l(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, scene)) == null) {
            if (!r66.i().p(scene) && n() && g(scene) != null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.e = z;
        }
    }

    public final AbsDataRecorder i(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scene)) == null) {
            if (!this.d.isEmpty()) {
                HashMap<AbsDataRecorder.Scene, AbsDataRecorder> peek = this.d.peek();
                if (peek.get(scene) == null) {
                    if (scene == AbsDataRecorder.Scene.FRS_HOT) {
                        peek.put(scene, new w56());
                    } else if (scene == AbsDataRecorder.Scene.FRS_NEW) {
                        peek.put(scene, new x56());
                    }
                }
                return peek.get(scene);
            }
            return null;
        }
        return (AbsDataRecorder) invokeL.objValue;
    }

    public void p(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i) == null) {
            if (this.f == null) {
                this.f = new HashMap();
            }
            if (this.f.get(str) == null) {
                this.f.put(str, Integer.valueOf(i));
            }
        }
    }

    public boolean r(int i, AbsDataRecorder.Scene scene) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048592, this, i, scene)) == null) {
            if (!r66.i().q() && n() && i >= v56.e().f(AbsDataRecorder.Scene.PB) && h() < v56.e().d()) {
                return true;
            }
            return false;
        }
        return invokeIL.booleanValue;
    }

    public boolean s(AbsDataRecorder.Scene scene) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, scene)) == null) {
            AbsDataRecorder g2 = g(scene);
            if (g2 == null || !l(scene) || g2.c() < v56.e().f(scene) || h() >= v56.e().d()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
