package com.baidu.tieba.themeCenter.card.category;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gr8;
import com.repackage.yq8;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.GetCardByCategory.DataRes;
import tbclient.GetCardByCategory.GetCardByCategoryResIdl;
import tbclient.GetCardByCategory.ThemeCardInMain;
/* loaded from: classes4.dex */
public class PersonalCardCategorySocktResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<yq8> mCardCategoryList;
    public gr8 mRecommand;

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
                gr8 gr8Var = new gr8();
                this.mRecommand = gr8Var;
                gr8Var.d(getCardByCategoryResIdl.data.recommend);
            }
            List<ThemeCardInMain> list = getCardByCategoryResIdl.data.cards;
            if (list != null && list.size() > 0) {
                this.mCardCategoryList = new ArrayList();
                for (ThemeCardInMain themeCardInMain : list) {
                    if (themeCardInMain != null) {
                        yq8 yq8Var = new yq8();
                        yq8Var.c(themeCardInMain);
                        this.mCardCategoryList.add(yq8Var);
                    }
                }
            }
            return getCardByCategoryResIdl;
        }
        return invokeIL.objValue;
    }

    public List<yq8> getCardCategoryList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCardCategoryList : (List) invokeV.objValue;
    }

    public gr8 getRecommand() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRecommand : (gr8) invokeV.objValue;
    }

    public boolean isHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.hasMore : invokeV.booleanValue;
    }
}
