package com.baidu.wallet.personal.storage;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.beans.BeanManager;
import com.baidu.wallet.core.beans.ResponsePrecallback;
import com.baidu.wallet.paysdk.datamodel.CardListResponse;
import com.baidu.wallet.personal.ui.BankCardListActivity;
/* loaded from: classes6.dex */
public class CardListResponseHandler extends ResponsePrecallback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CardListResponseHandler() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.wallet.core.beans.ResponsePrecallback
    public void handleResponse(int i2, Object obj, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048576, this, i2, obj, str) == null) {
            CardListCache.getInstance().updateCardList(i2, (CardListResponse) obj);
        }
    }

    @Override // com.baidu.wallet.core.beans.ResponsePrecallback
    public void removeRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BeanManager.getInstance().removeAllBeans(BankCardListActivity.BEAN_TAG);
        }
    }
}
