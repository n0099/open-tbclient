package com.baidu.tieba.themeCenter.dressCenter;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ct8;
import com.baidu.tieba.dt8;
import com.baidu.tieba.zs8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetThemeList.DataRes;
import tbclient.GetThemeList.GetThemeListResIdl;
import tbclient.GetThemeList.ThemeCarousel;
import tbclient.GetThemeList.ThemeList;
/* loaded from: classes6.dex */
public class DressupCenterSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public dt8 mRecommand;
    public List<zs8> mThemeCarouselList;
    public List<ct8> mThemeList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupCenterSocketResponseMessage() {
        super(309001);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetThemeListResIdl getThemeListResIdl = (GetThemeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetThemeListResIdl.class);
            if (getThemeListResIdl == null) {
                return null;
            }
            Error error = getThemeListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getThemeListResIdl.error.usermsg);
            }
            DataRes dataRes = getThemeListResIdl.data;
            if (dataRes != null) {
                if (dataRes.carousel != null) {
                    this.mThemeCarouselList = new ArrayList();
                    for (ThemeCarousel themeCarousel : getThemeListResIdl.data.carousel) {
                        if (themeCarousel != null && (!StringUtils.isNull(themeCarousel.pic_url) || !StringUtils.isNull(themeCarousel.active_url))) {
                            zs8 zs8Var = new zs8();
                            zs8Var.a(themeCarousel);
                            this.mThemeCarouselList.add(zs8Var);
                        }
                    }
                }
                if (getThemeListResIdl.data.theme_list != null) {
                    this.mThemeList = new ArrayList();
                    for (ThemeList themeList : getThemeListResIdl.data.theme_list) {
                        if (themeList != null && !StringUtils.isNull(themeList.name)) {
                            ct8 ct8Var = new ct8();
                            ct8Var.d(themeList);
                            this.mThemeList.add(ct8Var);
                        }
                    }
                }
                if (getThemeListResIdl.data.recommend != null) {
                    dt8 dt8Var = new dt8();
                    this.mRecommand = dt8Var;
                    dt8Var.d(getThemeListResIdl.data.recommend);
                }
            }
            return getThemeListResIdl;
        }
        return invokeIL.objValue;
    }

    public dt8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mRecommand : (dt8) invokeV.objValue;
    }

    public List<zs8> getThemeCarouselList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mThemeCarouselList : (List) invokeV.objValue;
    }

    public List<ct8> getThemeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mThemeList : (List) invokeV.objValue;
    }

    public void setRecommand(dt8 dt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, dt8Var) == null) {
            this.mRecommand = dt8Var;
        }
    }

    public void setThemeCarouselList(List<zs8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.mThemeCarouselList = list;
        }
    }

    public void setThemeList(List<ct8> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.mThemeList = list;
        }
    }
}
