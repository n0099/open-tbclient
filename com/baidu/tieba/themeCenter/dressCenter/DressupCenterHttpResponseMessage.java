package com.baidu.tieba.themeCenter.dressCenter;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.ni9;
import com.baidu.tieba.qi9;
import com.baidu.tieba.ri9;
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
public class DressupCenterHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ri9 mRecommand;
    public List<ni9> mThemeCarouselList;
    public List<qi9> mThemeList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DressupCenterHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetThemeListResIdl getThemeListResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getThemeListResIdl = (GetThemeListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetThemeListResIdl.class)) == null) {
            return;
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
                        ni9 ni9Var = new ni9();
                        ni9Var.a(themeCarousel);
                        this.mThemeCarouselList.add(ni9Var);
                    }
                }
            }
            if (getThemeListResIdl.data.theme_list != null) {
                this.mThemeList = new ArrayList();
                for (ThemeList themeList : getThemeListResIdl.data.theme_list) {
                    if (themeList != null && !StringUtils.isNull(themeList.name)) {
                        qi9 qi9Var = new qi9();
                        qi9Var.d(themeList);
                        this.mThemeList.add(qi9Var);
                    }
                }
            }
            if (getThemeListResIdl.data.recommend != null) {
                ri9 ri9Var = new ri9();
                this.mRecommand = ri9Var;
                ri9Var.d(getThemeListResIdl.data.recommend);
            }
        }
    }

    public ri9 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRecommand;
        }
        return (ri9) invokeV.objValue;
    }

    public List<ni9> getThemeCarouselList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mThemeCarouselList;
        }
        return (List) invokeV.objValue;
    }

    public List<qi9> getThemeList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mThemeList;
        }
        return (List) invokeV.objValue;
    }

    public void setRecommand(ri9 ri9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ri9Var) == null) {
            this.mRecommand = ri9Var;
        }
    }

    public void setThemeCarouselList(List<ni9> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.mThemeCarouselList = list;
        }
    }

    public void setThemeList(List<qi9> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.mThemeList = list;
        }
    }
}
