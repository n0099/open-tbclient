package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.App;
/* loaded from: classes8.dex */
public class yfa extends zfa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo f1;
    public boolean g1;
    public String h1;
    public String i1;
    public String j1;
    public long k1;
    public int l1;
    public boolean m1;
    public int n1;
    public int o1;

    public yfa() {
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
        this.g1 = false;
    }

    public String A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f1;
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
            if (this.g1) {
                return "PB_BANNER";
            }
            if (this.m1) {
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
            AdvertAppInfo advertAppInfo = this.f1;
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
            AdvertAppInfo advertAppInfo = this.f1;
            if (advertAppInfo != null && advertAppInfo.h() == 0) {
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
            return this.f1;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f1;
            if (advertAppInfo == null) {
                return 0;
            }
            return JavaTypesHelper.toInt(advertAppInfo.f, 0);
        }
        return invokeV.intValue;
    }

    public String z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            AdvertAppInfo advertAppInfo = this.f1;
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
            this.f1 = advertAppInfo;
            advertAppInfo.l(app);
            this.f1.j = B1();
        }
    }

    @Override // com.baidu.tieba.zfa, com.baidu.tieba.bn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (!h05.c().g() && (advertAppInfo = this.f1) != null && (iLegoAdvert = advertAppInfo.h) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.y;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && this.g1) {
                return AdvertAppInfo.y;
            }
            AdvertAppInfo advertAppInfo2 = this.f1;
            if (advertAppInfo2 != null && advertAppInfo2.h != null) {
                int i = advertAppInfo2.c;
                if (i != 1001 && i != -1001) {
                    if (C1() != null) {
                        return AdvertAppInfo.A;
                    }
                    return null;
                }
                return AdvertAppInfo.y;
            }
            return AdvertAppInfo.y;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
