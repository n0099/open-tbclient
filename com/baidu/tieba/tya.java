package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.FrsPage.HeadCardCover;
import tbclient.FrsPage.HeaderCard;
import tbclient.ThemeColorInfo;
import tbclient.ThreadInfo;
/* loaded from: classes8.dex */
public final class tya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public List<ThreadInfo> b;
    public ThemeColorInfo c;
    public sya d;

    public tya() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public final ThemeColorInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final sya c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d;
        }
        return (sya) invokeV.objValue;
    }

    public final List<ThreadInfo> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final void e(HeaderCard headerCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, headerCard) != null) || headerCard == null) {
            return;
        }
        this.a = headerCard.card_title;
        this.b = headerCard.thread_list;
        this.c = headerCard.card_background;
        HeadCardCover headCardCover = headerCard.cover;
        if (headCardCover != null) {
            sya syaVar = new sya();
            this.d = syaVar;
            if (syaVar != null) {
                syaVar.d(headCardCover);
            }
        }
    }

    public final void f(tbclient.Personalized.HeaderCard headerCard) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, headerCard) != null) || headerCard == null) {
            return;
        }
        this.a = headerCard.card_title;
        this.b = headerCard.thread_list;
        this.c = headerCard.card_background;
        tbclient.Personalized.HeadCardCover headCardCover = headerCard.cover;
        if (headCardCover != null) {
            sya syaVar = new sya();
            this.d = syaVar;
            if (syaVar != null) {
                syaVar.e(headCardCover);
            }
        }
    }
}
