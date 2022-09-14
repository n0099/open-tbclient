package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class tz3 implements k04 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public tz3() {
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

    @Override // com.baidu.tieba.k04
    public String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? uz1.v(String.format("%s/api/user/addiction/gamevalid", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? uz1.v(String.format("%s/api/minigame/get_game_tencent_ads", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? uz1.v(String.format("%s/api/msgame/reservation/query", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? uz1.v(String.format("%s/api/report/download", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? uz1.v(String.format("%s/api/msgame/adblock", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? uz1.v(String.format("%s/ma/game/rest/check_is_user_advised_to_rest", u())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? uz1.v(String.format("%s/api/exchange/transfer_report", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? uz1.v(String.format("%s/api/user/addiction/polling", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? uz1.v(String.format("%s/api/user/addiction/realname", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? uz1.v(String.format("%s/api/user/rechargecheck", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? uz1.v(String.format("%s/ma/game/od/get_friend_cloud_storage", u())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? uz1.v(String.format("%s/user/gamehistory/upload", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? uz1.v(String.format("%s/ma/game/od/remove_user_cloud_storage", sz1.c())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? uz1.v(String.format("%s/api/msgame/reservation/auto_download/finish", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? uz1.v(String.format("%s/ma/game/od/set_user_cloud_storage", u())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? uz1.v(String.format("%s/api/exchange/list", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? uz1.v(String.format("%s/api/user/addiction/behavior_report", sz1.a())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? uz1.v(String.format("%s/ma/game/od/get_user_info", u())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? uz1.v(String.format("%s/ma/game/od/get_user_cloud_storage", u())) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.k04
    public String t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? uz1.v(String.format("%s/api/minigame/get_return_guide_config", sz1.a())) : (String) invokeV.objValue;
    }

    public final String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? uz1.a : (String) invokeV.objValue;
    }
}
