package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jq8;
import com.repackage.xp8;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBubbleByCategory.DataRes;
import tbclient.GetBubbleByCategory.GetBubbleByCategoryResIdl;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
/* loaded from: classes4.dex */
public class BubbleGroupHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<xp8> mBubbleGroupList;
    public jq8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleGroupHttpResponseMessage(int i) {
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

    public List<xp8> getGroupList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBubbleGroupList : (List) invokeV.objValue;
    }

    public jq8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecommand : (jq8) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetBubbleByCategoryResIdl getBubbleByCategoryResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getBubbleByCategoryResIdl = (GetBubbleByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleByCategoryResIdl.class)) == null) {
            return;
        }
        Error error = getBubbleByCategoryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getBubbleByCategoryResIdl.error.usermsg);
        }
        DataRes dataRes = getBubbleByCategoryResIdl.data;
        if (dataRes != null) {
            if (dataRes.recommend != null) {
                jq8 jq8Var = new jq8();
                this.mRecommand = jq8Var;
                jq8Var.d(getBubbleByCategoryResIdl.data.recommend);
            }
            if (getBubbleByCategoryResIdl.data.bubbles != null) {
                this.mBubbleGroupList = new ArrayList();
                for (ThemeBubbleInMain themeBubbleInMain : getBubbleByCategoryResIdl.data.bubbles) {
                    if (themeBubbleInMain != null && !StringUtils.isNull(themeBubbleInMain.bubble_category)) {
                        xp8 xp8Var = new xp8();
                        xp8Var.c(themeBubbleInMain);
                        this.mBubbleGroupList.add(xp8Var);
                    }
                }
            }
        }
    }
}
