package com.baidu.tieba.themeCenter.bubble.group;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cu8;
import com.baidu.tieba.qt8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetBubbleByCategory.DataRes;
import tbclient.GetBubbleByCategory.GetBubbleByCategoryResIdl;
import tbclient.GetBubbleByCategory.ThemeBubbleInMain;
/* loaded from: classes6.dex */
public class BubbleGroupSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List mBubbleGroupList;
    public cu8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleGroupSocketResponseMessage() {
        super(309030);
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

    public List getGroupList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mBubbleGroupList;
        }
        return (List) invokeV.objValue;
    }

    public cu8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRecommand;
        }
        return (cu8) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetBubbleByCategoryResIdl getBubbleByCategoryResIdl = (GetBubbleByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleByCategoryResIdl.class);
            if (getBubbleByCategoryResIdl == null) {
                return null;
            }
            Error error = getBubbleByCategoryResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getBubbleByCategoryResIdl.error.usermsg);
            }
            DataRes dataRes = getBubbleByCategoryResIdl.data;
            if (dataRes != null) {
                if (dataRes.recommend != null) {
                    cu8 cu8Var = new cu8();
                    this.mRecommand = cu8Var;
                    cu8Var.d(getBubbleByCategoryResIdl.data.recommend);
                }
                if (getBubbleByCategoryResIdl.data.bubbles != null) {
                    this.mBubbleGroupList = new ArrayList();
                    for (ThemeBubbleInMain themeBubbleInMain : getBubbleByCategoryResIdl.data.bubbles) {
                        if (themeBubbleInMain != null && !StringUtils.isNull(themeBubbleInMain.bubble_category)) {
                            qt8 qt8Var = new qt8();
                            qt8Var.c(themeBubbleInMain);
                            this.mBubbleGroupList.add(qt8Var);
                        }
                    }
                }
            }
            return getBubbleByCategoryResIdl;
        }
        return invokeIL.objValue;
    }
}
