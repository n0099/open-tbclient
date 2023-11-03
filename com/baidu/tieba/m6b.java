package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.FrsPage.HeadCardCover;
import tbclient.ThemeColorInfo;
/* loaded from: classes7.dex */
public final class m6b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public l6b a;
    public ThemeColorInfo b;
    public p6b c;

    public m6b() {
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
        this.a = new l6b();
    }

    public final ThemeColorInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (ThemeColorInfo) invokeV.objValue;
    }

    public final l6b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (l6b) invokeV.objValue;
    }

    public final p6b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.c;
        }
        return (p6b) invokeV.objValue;
    }

    public final void d(HeadCardCover headCardCover) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, headCardCover) != null) || headCardCover == null) {
            return;
        }
        l6b l6bVar = new l6b();
        this.a = l6bVar;
        l6bVar.d(headCardCover.freq);
        this.b = headCardCover.card_background;
        p6b p6bVar = new p6b();
        this.c = p6bVar;
        if (p6bVar != null) {
            p6bVar.q(headCardCover.match_info);
        }
    }

    public final void e(tbclient.Personalized.HeadCardCover headCardCover) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, headCardCover) != null) || headCardCover == null) {
            return;
        }
        l6b l6bVar = new l6b();
        this.a = l6bVar;
        l6bVar.e(headCardCover.freq);
        this.b = headCardCover.card_background;
        p6b p6bVar = new p6b();
        this.c = p6bVar;
        if (p6bVar != null) {
            p6bVar.r(headCardCover.match_info);
        }
    }
}
