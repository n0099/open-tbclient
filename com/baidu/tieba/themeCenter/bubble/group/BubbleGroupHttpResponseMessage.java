package com.baidu.tieba.themeCenter.bubble.group;

import c.a.r0.z3.f.b.b;
import c.a.r0.z3.h.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
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
/* loaded from: classes11.dex */
public class BubbleGroupHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<b> mBubbleGroupList;
    public e mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BubbleGroupHttpResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public List<b> getGroupList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBubbleGroupList : (List) invokeV.objValue;
    }

    public e getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecommand : (e) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetBubbleByCategoryResIdl getBubbleByCategoryResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getBubbleByCategoryResIdl = (GetBubbleByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetBubbleByCategoryResIdl.class)) == null) {
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
                e eVar = new e();
                this.mRecommand = eVar;
                eVar.d(getBubbleByCategoryResIdl.data.recommend);
            }
            if (getBubbleByCategoryResIdl.data.bubbles != null) {
                this.mBubbleGroupList = new ArrayList();
                for (ThemeBubbleInMain themeBubbleInMain : getBubbleByCategoryResIdl.data.bubbles) {
                    if (themeBubbleInMain != null && !StringUtils.isNull(themeBubbleInMain.bubble_category)) {
                        b bVar = new b();
                        bVar.c(themeBubbleInMain);
                        this.mBubbleGroupList.add(bVar);
                    }
                }
            }
        }
    }
}
