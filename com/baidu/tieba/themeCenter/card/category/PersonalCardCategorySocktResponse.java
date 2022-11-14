package com.baidu.tieba.themeCenter.card.category;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ov8;
import com.baidu.tieba.wv8;
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
public class PersonalCardCategorySocktResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<ov8> mCardCategoryList;
    public wv8 mRecommand;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonalCardCategorySocktResponse() {
        super(309331);
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
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetCardByCategoryResIdl getCardByCategoryResIdl = (GetCardByCategoryResIdl) new Wire(new Class[0]).parseFrom(bArr, GetCardByCategoryResIdl.class);
            if (getCardByCategoryResIdl == null) {
                return null;
            }
            Error error = getCardByCategoryResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getCardByCategoryResIdl.error.usermsg);
            }
            DataRes dataRes = getCardByCategoryResIdl.data;
            if (dataRes == null) {
                return getCardByCategoryResIdl;
            }
            if (dataRes.has_more.intValue() == 1) {
                this.hasMore = true;
            } else {
                this.hasMore = false;
            }
            if (getCardByCategoryResIdl.data.recommend != null) {
                wv8 wv8Var = new wv8();
                this.mRecommand = wv8Var;
                wv8Var.d(getCardByCategoryResIdl.data.recommend);
            }
            List<ThemeCardInMain> list = getCardByCategoryResIdl.data.cards;
            if (list != null && list.size() > 0) {
                this.mCardCategoryList = new ArrayList();
                for (ThemeCardInMain themeCardInMain : list) {
                    if (themeCardInMain != null) {
                        ov8 ov8Var = new ov8();
                        ov8Var.c(themeCardInMain);
                        this.mCardCategoryList.add(ov8Var);
                    }
                }
            }
            return getCardByCategoryResIdl;
        }
        return invokeIL.objValue;
    }

    public List<ov8> getCardCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCardCategoryList;
        }
        return (List) invokeV.objValue;
    }

    public wv8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRecommand;
        }
        return (wv8) invokeV.objValue;
    }

    public boolean isHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }
}
