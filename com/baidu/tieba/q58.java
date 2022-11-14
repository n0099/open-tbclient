package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
import tbclient.Promotion;
/* loaded from: classes5.dex */
public class q58 extends BaseCardInfo {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId n;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public Long f;
    public boolean g;
    public boolean h;
    public String i;
    public String j;
    public long k;
    public boolean l;
    public YyExtData m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948042933, "Lcom/baidu/tieba/q58;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948042933, "Lcom/baidu/tieba/q58;");
                return;
            }
        }
        n = BdUniqueId.gen();
    }

    public q58() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.g = false;
        this.l = false;
    }

    public Long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.f;
        }
        return (Long) invokeV.objValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return n;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public void r(@NonNull AlaLiveInfo alaLiveInfo) {
        long j;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaLiveInfo) == null) {
            this.a = alaLiveInfo.first_headline;
            this.b = alaLiveInfo.second_headline;
            String str = alaLiveInfo.cover_wide;
            this.c = str;
            if (str == null || TextUtils.isEmpty(str)) {
                this.c = alaLiveInfo.cover;
            }
            alaLiveInfo.live_id.longValue();
            YyExtData yyExtData = new YyExtData();
            this.m = yyExtData;
            yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
            AlaUserInfo alaUserInfo = alaLiveInfo.user_info;
            if (alaUserInfo != null) {
                j = alaUserInfo.user_id.longValue();
            } else {
                j = 0;
            }
            this.k = j;
            if (alaLiveInfo.live_from.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.h = z;
            this.i = alaLiveInfo.third_live_type;
            this.j = alaLiveInfo.third_room_id;
            String str2 = alaLiveInfo.router_type;
            this.d = "";
            this.e = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e03);
            this.f = 1L;
            this.g = true;
            this.l = false;
        }
    }

    public void s(Promotion promotion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, promotion) == null) {
            this.a = promotion.title;
            this.b = promotion.sub_title;
            this.c = promotion.image;
            this.d = promotion.link;
            this.e = promotion.link_text;
            this.f = promotion.appear_time;
            this.g = false;
            this.l = false;
        }
    }
}
