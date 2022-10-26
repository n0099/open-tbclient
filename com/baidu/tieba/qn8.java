package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.App;
/* loaded from: classes5.dex */
public class qn8 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo U0;
    public boolean V0;
    public String W0;
    public String X0;
    public String Y0;
    public long Z0;
    public int a1;
    public boolean b1;
    public int c1;
    public int d1;

    public qn8() {
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
        this.V0 = false;
    }

    public AdvertAppInfo getAdvertAppInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.U0;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            AdvertAppInfo advertAppInfo = this.U0;
            if (advertAppInfo == null) {
                return 0;
            }
            return eh.e(advertAppInfo.f, 0);
        }
        return invokeV.intValue;
    }

    public String k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.U0;
            if (advertAppInfo == null) {
                return "";
            }
            return advertAppInfo.g;
        }
        return (String) invokeV.objValue;
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.U0;
            if (advertAppInfo == null) {
                return "";
            }
            return advertAppInfo.a;
        }
        return (String) invokeV.objValue;
    }

    public String m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.V0) {
                return "PB_BANNER";
            }
            if (this.b1) {
                return "VIDEO_PB";
            }
            return "PB";
        }
        return (String) invokeV.objValue;
    }

    public AdvertAppInfo.ILegoAdvert n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            AdvertAppInfo advertAppInfo = this.U0;
            if (advertAppInfo == null) {
                return null;
            }
            return advertAppInfo.h;
        }
        return (AdvertAppInfo.ILegoAdvert) invokeV.objValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            AdvertAppInfo advertAppInfo = this.U0;
            if (advertAppInfo != null && advertAppInfo.n() == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, com.baidu.tieba.eo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo advertAppInfo;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!jq4.c().g() && (advertAppInfo = this.U0) != null && (iLegoAdvert = advertAppInfo.h) != null && !iLegoAdvert.isNoPicAd()) {
                return AdvertAppInfo.x;
            }
            if (UbsABTestHelper.isPbPageBannerFunAdSdkTest() && this.V0) {
                return AdvertAppInfo.x;
            }
            AdvertAppInfo advertAppInfo2 = this.U0;
            if (advertAppInfo2 != null && advertAppInfo2.h != null) {
                int i = advertAppInfo2.c;
                if (i != 1001 && i != -1001) {
                    if (n1() != null) {
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

    public void p1(App app) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, app) == null) {
            AdvertAppInfo advertAppInfo = new AdvertAppInfo();
            this.U0 = advertAppInfo;
            advertAppInfo.s(app);
            this.U0.j = m1();
        }
    }
}
