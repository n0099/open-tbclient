package com.baidu.wallet.home.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.banner.BannerBaseItemInfo;
import com.baidu.wallet.home.storage.a;
/* loaded from: classes10.dex */
public abstract class WalletBannerItem extends BannerBaseItemInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public WalletBannerItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public abstract String getCornerAddr();

    public long getNum(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j)) == null) {
            if (TextUtils.isEmpty(str)) {
                return j;
            }
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return j;
            }
        }
        return invokeLJ.longValue;
    }

    public abstract String getTimeStamp();

    public abstract String getTimeStampIconType();

    public abstract String getValue1();

    public abstract String getValue2();

    public boolean hasCornor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? !TextUtils.isEmpty(getCornerAddr()) : invokeV.booleanValue;
    }

    public boolean isShoudShowPoint(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, context)) == null) {
            if (("1".equals(getTimeStampIconType()) || "2".equals(getTimeStampIconType()) || "3".equals(getTimeStampIconType())) && !TextUtils.isEmpty(getType())) {
                return (getType().equals("1") || getType().equals("2") || getType().equals("3") || getType().equals("4")) && !TextUtils.isEmpty(getLinkAddr()) && getNum(getTimeStamp(), 0L) > getNum(a.a(context, getLinkAddr()), 0L);
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
