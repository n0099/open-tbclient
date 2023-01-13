package com.baidu.tieba.themeCenter.dressCenter;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.s39;
import com.baidu.tieba.v39;
import com.baidu.tieba.w39;
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
    public w39 mRecommand;
    public List<s39> mThemeCarouselList;
    public List<v39> mThemeList;

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

    public w39 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mRecommand;
        }
        return (w39) invokeV.objValue;
    }

    public List<s39> getThemeCarouselList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mThemeCarouselList;
        }
        return (List) invokeV.objValue;
    }

    public List<v39> getThemeList() {
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
                            s39 s39Var = new s39();
                            s39Var.a(themeCarousel);
                            this.mThemeCarouselList.add(s39Var);
                        }
                    }
                }
                if (getThemeListResIdl.data.theme_list != null) {
                    this.mThemeList = new ArrayList();
                    for (ThemeList themeList : getThemeListResIdl.data.theme_list) {
                        if (themeList != null && !StringUtils.isNull(themeList.name)) {
                            v39 v39Var = new v39();
                            v39Var.d(themeList);
                            this.mThemeList.add(v39Var);
                        }
                    }
                }
                if (getThemeListResIdl.data.recommend != null) {
                    w39 w39Var = new w39();
                    this.mRecommand = w39Var;
                    w39Var.d(getThemeListResIdl.data.recommend);
                }
            }
            return getThemeListResIdl;
        }
        return invokeIL.objValue;
    }

    public void setRecommand(w39 w39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, w39Var) == null) {
            this.mRecommand = w39Var;
        }
    }

    public void setThemeCarouselList(List<s39> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.mThemeCarouselList = list;
        }
    }

    public void setThemeList(List<v39> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.mThemeList = list;
        }
    }
}
