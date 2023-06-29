package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.App;
/* loaded from: classes6.dex */
public class m4a extends n4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo g1;
    public boolean h1;
    public String i1;
    public String j1;
    public String k1;
    public long l1;
    public int m1;
    public boolean n1;
    public int o1;
    public int p1;

    public m4a() {
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
        this.h1 = false;
    }

    public String A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.g1;
            if (advertAppInfo == null) {
                return "";
            }
            return advertAppInfo.a;
        }
        return (String) invokeV.objValue;
    }

    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.h1) {
                return "PB_BANNER";
            }
            if (this.n1) {
                return "VIDEO_PB";
            }
            return "PB";
        }
        return (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            AdvertAppInfo advertAppInfo = this.g1;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.h;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.g1;
            if (advertAppInfo != null && advertAppInfo.i() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.g1;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdvertAppInfo advertAppInfo = this.g1;
            if (advertAppInfo == null) {
                return 0;
            }
            return vg.e(advertAppInfo.f, 0);
        }
        return invokeV.intValue;
    }

    public String z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AdvertAppInfo advertAppInfo = this.g1;
            if (advertAppInfo == null) {
                return "";
            }
            return advertAppInfo.g;
        }
        return (String) invokeV.objValue;
    }

    public void E1(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.g1 = advertAppInfo;
            advertAppInfo.l(app);
            this.g1.j = B1();
        }
    }

    @Override // com.baidu.tieba.n4a, com.baidu.tieba.xn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!r05.c().g() && (advertAppInfo = this.g1) != null && (iLegoAdvert = advertAppInfo.h) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.x;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && this.h1) {
                return AdvertAppInfo.x;
            }
            AdvertAppInfo advertAppInfo2 = this.g1;
            if (advertAppInfo2 != null && advertAppInfo2.h != null) {
                int i = advertAppInfo2.c;
                if (i != 1001 && i != -1001) {
                    if (C1() != null) {
                        return AdvertAppInfo.z;
                    }
                    return null;
                }
                return AdvertAppInfo.x;
            }
            return AdvertAppInfo.x;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
