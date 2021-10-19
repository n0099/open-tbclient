package com.bytedance.sdk.openadsdk.core.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.HorizontalTranslateLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.core.h;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66685a;

    /* renamed from: b  reason: collision with root package name */
    public String f66686b;

    /* renamed from: c  reason: collision with root package name */
    public d f66687c;

    /* renamed from: d  reason: collision with root package name */
    public c f66688d;

    /* renamed from: e  reason: collision with root package name */
    public String f66689e;

    public e(@NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66688d = cVar;
        this.f66685a = cVar.a();
        this.f66686b = cVar.b();
        this.f66689e = cVar.c();
        if (h.d().A() == 1) {
            this.f66687c = cVar.e();
        } else {
            this.f66687c = cVar.d();
        }
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (int) this.f66687c.c() : invokeV.intValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (int) this.f66687c.f() : invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) this.f66687c.d() : invokeV.intValue;
    }

    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (int) this.f66687c.e() : invokeV.intValue;
    }

    public float e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f66687c.g() : invokeV.floatValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f66685a == 0 ? this.f66686b : "" : (String) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? a(this.f66687c.j()) : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String i2 = this.f66687c.i();
            if ("left".equals(i2)) {
                return 2;
            }
            if ("center".equals(i2)) {
                return 4;
            }
            return HorizontalTranslateLayout.RIGHT.equals(i2) ? 3 : 2;
        }
        return invokeV.intValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f66685a == 2 ? this.f66686b : "" : (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f66685a == 1 ? this.f66686b : "" : (String) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f66689e : (String) invokeV.objValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f66687c.h() : invokeV.intValue;
    }

    public float m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f66687c.a() : invokeV.floatValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? a(this.f66687c.l()) : invokeV.intValue;
    }

    public float o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f66687c.b() : invokeV.floatValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f66687c.o() : invokeV.booleanValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            String m = this.f66687c.m();
            if (!TextUtils.isEmpty(m) && !m.equals("none")) {
                if (m.equals("normal")) {
                    return 1;
                }
                if (m.equals("creative")) {
                    return 2;
                }
                if (m.equals("video")) {
                    return 4;
                }
                if ("slide".equals(this.f66687c.n())) {
                    return 2;
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? a(this.f66687c.k()) : invokeV.intValue;
    }

    private int a(String str) {
        InterceptResult invokeL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -16777216;
            }
            if (str.equals(OpenFlutter.EXTRA_TRANSPARANT)) {
                return 0;
            }
            if (str.charAt(0) == '#' && str.length() == 7) {
                return Color.parseColor(str);
            }
            if (str.charAt(0) == '#' && str.length() == 9) {
                return Color.parseColor(str);
            }
            if (str.startsWith("rgba") && (split = str.substring(str.indexOf("(") + 1, str.indexOf(SmallTailInfo.EMOTION_SUFFIX)).split(",")) != null && split.length == 4) {
                return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2])) | 0;
            }
            return -16777216;
        }
        return invokeL.intValue;
    }

    public boolean a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            c cVar = this.f66688d;
            if (cVar == null) {
                return false;
            }
            if (i2 == 1) {
                this.f66687c = cVar.e();
            } else {
                this.f66687c = cVar.d();
            }
            return this.f66687c != null;
        }
        return invokeI.booleanValue;
    }
}
