package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class si6 extends BaseCardInfo implements ej6, qy4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdvertAppInfo a;
    public String b;
    public int c;
    public boolean d;

    @Override // com.baidu.tieba.ej6
    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.ej6
    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.ej6
    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public si6() {
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
        this.b = "";
        this.c = 0;
        this.d = false;
        this.a = null;
        this.position = -1;
    }

    @Override // com.baidu.tieba.qy4
    public AdvertAppInfo H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.a;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    public AdvertAppInfo c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (AdvertAppInfo) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ej6
    public int getPosition() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            AdvertAppInfo advertAppInfo = this.a;
            if (advertAppInfo != null) {
                str = advertAppInfo.f;
            } else {
                str = "-1";
            }
            return gg.e(str, -1);
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.qy4
    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.qy4
    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.position;
        }
        return invokeV.intValue;
    }

    public si6(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {advertAppInfo};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = "";
        this.c = 0;
        this.d = false;
        this.a = advertAppInfo;
        this.position = advertAppInfo.position;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.in
    public BdUniqueId getType() {
        InterceptResult invokeV;
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            AdvertAppInfo advertAppInfo = this.a;
            if (advertAppInfo != null && advertAppInfo.getType() == AdvertAppInfo.w) {
                return AdvertAppInfo.y;
            }
            AdvertAppInfo advertAppInfo2 = this.a;
            if (advertAppInfo2 != null && (iLegoAdvert = advertAppInfo2.h) != null) {
                BdUniqueId bdUniqueId = AdvertAppInfo.z;
                int goodsStyle = iLegoAdvert.getGoodsStyle();
                if (goodsStyle != 2) {
                    if (goodsStyle != 14) {
                        if (goodsStyle != 6) {
                            if (goodsStyle != 7) {
                                if (goodsStyle != 8) {
                                    return bdUniqueId;
                                }
                            }
                        } else {
                            return AdvertAppInfo.B;
                        }
                    }
                    return AdvertAppInfo.C;
                }
                return AdvertAppInfo.A;
            }
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.tieba.qy4
    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.position = i;
            this.a.position = i;
            this.d = true;
        }
    }
}
