package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.module.hottopic.HotTopicStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class oo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ThreadData a;
    @Nullable
    public int b;
    @Nullable
    public final String c;
    @Nullable
    public final String d;
    public boolean e;
    public int f;
    public int g;
    @Nullable
    public b0a h;
    @NonNull
    public HotTopicStat.Locate i;
    @Nullable
    public String j;
    public boolean k;

    public oo5(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = HotTopicStat.Locate.UNDEFINED;
        this.c = str;
        this.d = str2;
        this.e = TextUtils.equals(UrlUtils.getParamValue(str2, "is_video_topic"), "1");
    }

    @NonNull
    public static oo5 h(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            return new oo5(str, str2);
        }
        return (oo5) invokeLL.objValue;
    }

    @NonNull
    public oo5 a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            this.k = z;
            return this;
        }
        return (oo5) invokeZ.objValue;
    }

    @NonNull
    public oo5 b(@NonNull HotTopicStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, locate)) == null) {
            this.i = locate;
            return this;
        }
        return (oo5) invokeL.objValue;
    }

    @NonNull
    public oo5 c(@Nullable b0a b0aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b0aVar)) == null) {
            this.h = b0aVar;
            return this;
        }
        return (oo5) invokeL.objValue;
    }

    @NonNull
    public oo5 d(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            this.f = i;
            return this;
        }
        return (oo5) invokeI.objValue;
    }

    @NonNull
    public oo5 e(@Nullable ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            this.a = threadData;
            return this;
        }
        return (oo5) invokeL.objValue;
    }

    @NonNull
    public oo5 f(@Nullable int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.b = i;
            return this;
        }
        return (oo5) invokeI.objValue;
    }

    @NonNull
    public oo5 g(@ColorRes int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            this.g = i;
            return this;
        }
        return (oo5) invokeI.objValue;
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.e = z;
        }
    }

    @NonNull
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ThreadData threadData = this.a;
            if (threadData == null) {
                return "";
            }
            return String.valueOf(threadData.getFid());
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String str = this.c;
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.j == null) {
                this.j = UrlUtils.appendParam(this.d, "locate", l().toString());
            }
            return this.j;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public HotTopicStat.Locate l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.i;
        }
        return (HotTopicStat.Locate) invokeV.objValue;
    }

    @Nullable
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            b0a b0aVar = this.h;
            if (b0aVar == null) {
                return null;
            }
            return b0aVar.S();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public ThreadData n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return (ThreadData) invokeV.objValue;
    }

    @ColorRes
    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (r()) {
                int i = this.g;
                if (i != 0) {
                    return i;
                }
            } else {
                int i2 = this.f;
                if (i2 != 0) {
                    return i2;
                }
            }
            return R.color.CAM_X0304;
        }
        return invokeV.intValue;
    }

    @Nullable
    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }
}
