package com.baidu.tieba.themeCenter.background;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ln8;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBgList.DataRes;
import tbclient.GetBgList.GetBgListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes4.dex */
public class BackgroundListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<DressItemData> mBackgroundList;
    public int mIsDefault;
    public ln8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackgroundListSocketResponseMessage() {
        super(309021);
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
        this.hasMore = true;
        this.mIsDefault = 0;
    }

    public List<DressItemData> getBackgroundList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBackgroundList : (List) invokeV.objValue;
    }

    public boolean getIsDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIsDefault == 1 : invokeV.booleanValue;
    }

    public ln8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRecommand : (ln8) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.hasMore : invokeV.booleanValue;
    }

    public void setIsDefault(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mIsDefault = z ? 1 : 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
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
                    ln8 ln8Var = new ln8();
                    this.mRecommand = ln8Var;
                    ln8Var.d(getBgListResIdl.data.recommend);
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
                this.hasMore = getBgListResIdl.data.hasmore.intValue() == 1;
            }
        }
    }
}
