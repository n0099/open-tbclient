package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import tbclient.QuizInfo;
import tbclient.QuizOption;
/* loaded from: classes7.dex */
public final class obb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;
    public String b;
    public String c;
    public Long d;
    public Long e;
    public Long f;
    public Long g;
    public Long h;
    public Long i;
    public ArrayList<pbb> j;

    public obb() {
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
        this.j = new ArrayList<>();
    }

    public final Long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (Long) invokeV.objValue;
    }

    public final Long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (Long) invokeV.objValue;
    }

    public final Long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (Long) invokeV.objValue;
    }

    public final ArrayList<pbb> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.j;
        }
        return (ArrayList) invokeV.objValue;
    }

    public final Long e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.i;
        }
        return (Long) invokeV.objValue;
    }

    public final Long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g;
        }
        return (Long) invokeV.objValue;
    }

    public final String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final Long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.d;
        }
        return (Long) invokeV.objValue;
    }

    public final String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public final Long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.e;
        }
        return (Long) invokeV.objValue;
    }

    public final void k(QuizInfo quizInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, quizInfo) != null) || quizInfo == null) {
            return;
        }
        this.a = quizInfo.bonus_type;
        this.b = quizInfo.title;
        this.c = quizInfo.total_count_icon;
        String str = quizInfo.total_count_text;
        this.d = quizInfo.total_count;
        this.e = quizInfo.total_user_count;
        this.f = quizInfo.min_pour_count;
        this.g = quizInfo.quiz_id;
        this.h = quizInfo.browse_user_option;
        this.i = quizInfo.product;
        this.j.clear();
        if (!ListUtils.isEmpty(quizInfo.options)) {
            for (QuizOption quizOption : quizInfo.options) {
                Intrinsics.checkNotNullExpressionValue(quizOption, "quizInfo.options");
                pbb pbbVar = new pbb();
                pbbVar.h(quizOption);
                this.j.add(pbbVar);
            }
        }
        Long l = quizInfo.type;
    }

    public final void l(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, l) == null) {
            this.h = l;
        }
    }

    public final void m(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, l) == null) {
            this.d = l;
        }
    }

    public final void n(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, l) == null) {
            this.e = l;
        }
    }
}
