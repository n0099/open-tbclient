package com.baidu.tieba.themeCenter.dressCenter;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a5a;
import com.baidu.tieba.w4a;
import com.baidu.tieba.z4a;
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
/* loaded from: classes7.dex */
public class DressupCenterSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a5a mRecommand;
    public List<w4a> mThemeCarouselList;
    public List<z4a> mThemeList;

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

    public a5a getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mRecommand;
        }
        return (a5a) invokeV.objValue;
    }

    public List<w4a> getThemeCarouselList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mThemeCarouselList;
        }
        return (List) invokeV.objValue;
    }

    public List<z4a> getThemeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mThemeList;
        }
        return (List) invokeV.objValue;
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
                            w4a w4aVar = new w4a();
                            w4aVar.a(themeCarousel);
                            this.mThemeCarouselList.add(w4aVar);
                        }
                    }
                }
                if (getThemeListResIdl.data.theme_list != null) {
                    this.mThemeList = new ArrayList();
                    for (ThemeList themeList : getThemeListResIdl.data.theme_list) {
                        if (themeList != null && !StringUtils.isNull(themeList.name)) {
                            z4a z4aVar = new z4a();
                            z4aVar.d(themeList);
                            this.mThemeList.add(z4aVar);
                        }
                    }
                }
                if (getThemeListResIdl.data.recommend != null) {
                    a5a a5aVar = new a5a();
                    this.mRecommand = a5aVar;
                    a5aVar.d(getThemeListResIdl.data.recommend);
                }
            }
            return getThemeListResIdl;
        }
        return invokeIL.objValue;
    }

    public void setRecommand(a5a a5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, a5aVar) == null) {
            this.mRecommand = a5aVar;
        }
    }

    public void setThemeCarouselList(List<w4a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.mThemeCarouselList = list;
        }
    }

    public void setThemeList(List<z4a> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.mThemeList = list;
        }
    }
}
