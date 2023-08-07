package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.TiebaPlusInfo;
/* loaded from: classes8.dex */
public class v06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public TiebaPlusInfo b;
    public TiePlusStat.ThreadType c;
    public String d;
    public String e;
    public TiePlusStat.StatType f;
    public TiePlusStat.LandingType g;
    public TiePlusStat.CardBtnType h;
    public TiePlusStat.RichTextType i;
    public ThreadData j;
    public int k;

    @NonNull
    public v06 a(@Nullable qba qbaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, qbaVar)) == null) ? this : (v06) invokeL.objValue;
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-398032912, "Lcom/baidu/tieba/v06$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-398032912, "Lcom/baidu/tieba/v06$a;");
                    return;
                }
            }
            int[] iArr = new int[TiePlusStat.Locate.values().length];
            a = iArr;
            try {
                iArr[TiePlusStat.Locate.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TiePlusStat.Locate.FRS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TiePlusStat.Locate.PB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[TiePlusStat.Locate.PB_COMMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public v06() {
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
        this.h = null;
        this.i = TiePlusStat.RichTextType.LINK;
        this.k = -1;
    }

    public TiePlusStat.CardBtnType d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.h;
        }
        return (TiePlusStat.CardBtnType) invokeV.objValue;
    }

    @NonNull
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return String.valueOf(this.j.getDispatchedForumId());
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            cw5.d(!TextUtils.isEmpty(this.e));
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.LandingType g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (TiePlusStat.LandingType) invokeV.objValue;
    }

    public TiePlusStat.RichTextType h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (TiePlusStat.RichTextType) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.StatType j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            cw5.b(this.f);
            return this.f;
        }
        return (TiePlusStat.StatType) invokeV.objValue;
    }

    @NonNull
    public ThreadData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (ThreadData) invokeV.objValue;
    }

    @NonNull
    public TiePlusStat.ThreadType l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.c;
        }
        return (TiePlusStat.ThreadType) invokeV.objValue;
    }

    @NonNull
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public TiebaPlusInfo n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (TiebaPlusInfo) invokeV.objValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @NonNull
    public static v06 c(int i, @NonNull TiebaPlusInfo tiebaPlusInfo, @NonNull ThreadData threadData) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65537, null, i, tiebaPlusInfo, threadData)) == null) {
            int intValue = tiebaPlusInfo.jump_type.intValue();
            v06 v06Var = new v06();
            v06Var.a = TiePlusStat.a(tiebaPlusInfo, null);
            v06Var.g = TiePlusStat.LandingType.create(intValue);
            v06Var.i = TiePlusStat.RichTextType.create(i);
            v06Var.h = TiePlusStat.CardBtnType.create(i, intValue);
            v06Var.b = tiebaPlusInfo;
            v06Var.c = TiePlusStat.ThreadType.create(threadData);
            v06Var.d = threadData.getTid();
            v06Var.e = String.valueOf(threadData.getFid());
            v06Var.j = threadData;
            return v06Var;
        }
        return (v06) invokeILL.objValue;
    }

    public v06 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            this.k = i;
            return this;
        }
        return (v06) invokeI.objValue;
    }

    public int i(@NonNull TiePlusStat.Locate locate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, locate)) == null) {
            int i = a.a[locate.ordinal()];
            if (i != 1 && i != 2) {
                if (i != 3 && i != 4) {
                    return -1;
                }
                return this.k;
            }
            return k().statFloor;
        }
        return invokeL.intValue;
    }

    public void p(TiePlusStat.RichTextType richTextType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, richTextType) == null) {
            this.i = richTextType;
        }
    }

    public void q(@NonNull TiePlusStat.StatType statType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, statType) == null) {
            this.f = statType;
        }
    }

    public void r(TiebaPlusInfo tiebaPlusInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tiebaPlusInfo) == null) {
            this.b = tiebaPlusInfo;
        }
    }
}
