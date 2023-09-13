package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.uoa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBgList.DataRes;
import tbclient.GetBgList.GetBgListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes8.dex */
public class BackgroundListHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<DressItemData> mBackgroundList;
    public int mIsDefault;
    public uoa mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundListHttpResponseMessage(int i) {
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
        this.hasMore = true;
        this.mIsDefault = 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            boolean z = false;
            GetBgListResIdl getBgListResIdl = (GetBgListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBgListResIdl.class);
            if (getBgListResIdl == null) {
                return;
            }
            Error error = getBgListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBgListResIdl.error.usermsg);
            }
            DataRes dataRes = getBgListResIdl.data;
            if (dataRes != null) {
                if (dataRes.recommend != null) {
                    uoa uoaVar = new uoa();
                    this.mRecommand = uoaVar;
                    uoaVar.d(getBgListResIdl.data.recommend);
                }
                this.mIsDefault = getBgListResIdl.data.is_default.intValue();
                if (getBgListResIdl.data.bgs != null) {
                    this.mBackgroundList = new ArrayList();
                    for (ThemeBgProp themeBgProp : getBgListResIdl.data.bgs) {
                        if (themeBgProp != null && !StringUtils.isNull(themeBgProp.title)) {
                            this.mBackgroundList.add(new DressItemData(themeBgProp));
                        }
                    }
                }
                if (getBgListResIdl.data.hasmore.intValue() == 1) {
                    z = true;
                }
                this.hasMore = z;
            }
        }
    }

    public List<DressItemData> getBackgroundList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mBackgroundList;
        }
        return (List) invokeV.objValue;
    }

    public boolean getIsDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.mIsDefault == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public uoa getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRecommand;
        }
        return (uoa) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }

    public void setIsDefault(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mIsDefault = z ? 1 : 0;
        }
    }
}
