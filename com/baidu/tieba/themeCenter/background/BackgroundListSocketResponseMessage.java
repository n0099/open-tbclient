package com.baidu.tieba.themeCenter.background;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.zja;
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
public class BackgroundListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<DressItemData> mBackgroundList;
    public int mIsDefault;
    public zja mRecommand;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            boolean z = false;
            GetBgListResIdl getBgListResIdl = (GetBgListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBgListResIdl.class);
            if (getBgListResIdl == null) {
                return null;
            }
            Error error = getBgListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBgListResIdl.error.usermsg);
            }
            DataRes dataRes = getBgListResIdl.data;
            if (dataRes != null) {
                if (dataRes.recommend != null) {
                    zja zjaVar = new zja();
                    this.mRecommand = zjaVar;
                    zjaVar.d(getBgListResIdl.data.recommend);
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
            return getBgListResIdl;
        }
        return invokeIL.objValue;
    }

    public List<DressItemData> getBackgroundList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBackgroundList;
        }
        return (List) invokeV.objValue;
    }

    public boolean getIsDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mIsDefault == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public zja getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRecommand;
        }
        return (zja) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }

    public void setIsDefault(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mIsDefault = z ? 1 : 0;
        }
    }
}
