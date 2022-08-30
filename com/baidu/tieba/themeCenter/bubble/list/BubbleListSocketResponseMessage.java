package com.baidu.tieba.themeCenter.bubble.list;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pr8;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBubbleList.DataRes;
import tbclient.GetBubbleList.GetBubbleListResIdl;
import tbclient.ThemeBgProp;
/* loaded from: classes6.dex */
public class BubbleListSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public boolean isDefault;
    public List<DressItemData> mDressItemList;
    public pr8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleListSocketResponseMessage() {
        super(309031);
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
        this.isDefault = false;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetBubbleListResIdl getBubbleListResIdl = (GetBubbleListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleListResIdl.class);
            if (getBubbleListResIdl == null) {
                return null;
            }
            Error error = getBubbleListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBubbleListResIdl.error.usermsg);
            }
            DataRes dataRes = getBubbleListResIdl.data;
            if (dataRes != null) {
                if (dataRes.recommend != null) {
                    pr8 pr8Var = new pr8();
                    this.mRecommand = pr8Var;
                    pr8Var.d(getBubbleListResIdl.data.recommend);
                }
                if (getBubbleListResIdl.data.bubbles != null) {
                    this.mDressItemList = new ArrayList();
                    for (ThemeBgProp themeBgProp : getBubbleListResIdl.data.bubbles) {
                        if (themeBgProp != null && !StringUtils.isNull(themeBgProp.title)) {
                            this.mDressItemList.add(new DressItemData(themeBgProp));
                        }
                    }
                }
                this.hasMore = getBubbleListResIdl.data.hasmore.intValue() == 1;
                this.isDefault = getBubbleListResIdl.data.is_default.intValue() == 1;
            }
            return getBubbleListResIdl;
        }
        return invokeIL.objValue;
    }

    public List<DressItemData> getBubbleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDressItemList : (List) invokeV.objValue;
    }

    public pr8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRecommand : (pr8) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.hasMore : invokeV.booleanValue;
    }

    public boolean isDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.isDefault : invokeV.booleanValue;
    }
}
