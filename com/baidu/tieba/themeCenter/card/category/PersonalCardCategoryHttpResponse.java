package com.baidu.tieba.themeCenter.card.category;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.cu8;
import com.baidu.tieba.ut8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetCardByCategory.DataRes;
import tbclient.GetCardByCategory.GetCardByCategoryResIdl;
import tbclient.GetCardByCategory.ThemeCardInMain;
/* loaded from: classes6.dex */
public class PersonalCardCategoryHttpResponse extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List mCardCategoryList;
    public cu8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardCategoryHttpResponse(int i) {
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
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetCardByCategoryResIdl getCardByCategoryResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (getCardByCategoryResIdl = (GetCardByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardByCategoryResIdl.class)) == null) {
            return;
        }
        Error error = getCardByCategoryResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getCardByCategoryResIdl.error.usermsg);
        }
        DataRes dataRes = getCardByCategoryResIdl.data;
        if (dataRes == null) {
            return;
        }
        if (dataRes.has_more.intValue() == 1) {
            this.hasMore = true;
        } else {
            this.hasMore = false;
        }
        if (getCardByCategoryResIdl.data.recommend != null) {
            cu8 cu8Var = new cu8();
            this.mRecommand = cu8Var;
            cu8Var.d(getCardByCategoryResIdl.data.recommend);
        }
        List<ThemeCardInMain> list = getCardByCategoryResIdl.data.cards;
        if (list != null && list.size() > 0) {
            this.mCardCategoryList = new ArrayList();
            for (ThemeCardInMain themeCardInMain : list) {
                if (themeCardInMain != null) {
                    ut8 ut8Var = new ut8();
                    ut8Var.c(themeCardInMain);
                    this.mCardCategoryList.add(ut8Var);
                }
            }
        }
    }

    public List getCardCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mCardCategoryList;
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

    public boolean isHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }
}
