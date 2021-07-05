package com.baidu.tieba.themeCenter.card.category;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.s0.n3.g.a.a;
import d.a.s0.n3.h.e;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetCardByCategory.DataRes;
import tbclient.GetCardByCategory.GetCardByCategoryResIdl;
import tbclient.GetCardByCategory.ThemeCardInMain;
/* loaded from: classes5.dex */
public class PersonalCardCategorySocktResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<a> mCardCategoryList;
    public e mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardCategorySocktResponse() {
        super(309331);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    public List<a> getCardCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCardCategoryList : (List) invokeV.objValue;
    }

    public e getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRecommand : (e) invokeV.objValue;
    }

    public boolean isHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.hasMore : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetCardByCategoryResIdl getCardByCategoryResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getCardByCategoryResIdl = (GetCardByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardByCategoryResIdl.class)) == null) {
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
            e eVar = new e();
            this.mRecommand = eVar;
            eVar.d(getCardByCategoryResIdl.data.recommend);
        }
        List<ThemeCardInMain> list = getCardByCategoryResIdl.data.cards;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mCardCategoryList = new ArrayList();
        for (ThemeCardInMain themeCardInMain : list) {
            if (themeCardInMain != null) {
                a aVar = new a();
                aVar.c(themeCardInMain);
                this.mCardCategoryList.add(aVar);
            }
        }
    }
}
