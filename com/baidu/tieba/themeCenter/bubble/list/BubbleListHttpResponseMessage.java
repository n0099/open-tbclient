package com.baidu.tieba.themeCenter.bubble.list;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.cu8;
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
public class BubbleListHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public boolean isDefault;
    public List mDressItemList;
    public cu8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleListHttpResponseMessage(int i) {
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
        this.isDefault = false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            boolean z2 = false;
            GetBubbleListResIdl getBubbleListResIdl = (GetBubbleListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleListResIdl.class);
            if (getBubbleListResIdl == null) {
                return;
            }
            Error error = getBubbleListResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBubbleListResIdl.error.usermsg);
            }
            DataRes dataRes = getBubbleListResIdl.data;
            if (dataRes != null) {
                if (dataRes.recommend != null) {
                    cu8 cu8Var = new cu8();
                    this.mRecommand = cu8Var;
                    cu8Var.d(getBubbleListResIdl.data.recommend);
                }
                if (getBubbleListResIdl.data.bubbles != null) {
                    this.mDressItemList = new ArrayList();
                    for (ThemeBgProp themeBgProp : getBubbleListResIdl.data.bubbles) {
                        if (themeBgProp != null && !StringUtils.isNull(themeBgProp.title)) {
                            this.mDressItemList.add(new DressItemData(themeBgProp));
                        }
                    }
                }
                if (getBubbleListResIdl.data.hasmore.intValue() == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.hasMore = z;
                if (getBubbleListResIdl.data.is_default.intValue() == 1) {
                    z2 = true;
                }
                this.isDefault = z2;
            }
        }
    }

    public List getBubbleList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDressItemList;
        }
        return (List) invokeV.objValue;
    }

    public cu8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRecommand;
        }
        return (cu8) invokeV.objValue;
    }

    public boolean hasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }

    public boolean isDefault() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.isDefault;
        }
        return invokeV.booleanValue;
    }
}
