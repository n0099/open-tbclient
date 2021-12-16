package com.baidu.wallet.paysdk.banksign.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.beans.IBeanResponse;
import java.io.Serializable;
/* loaded from: classes13.dex */
public class QueryResponse implements IBeanResponse, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String agreement_trans_id;
    public String dialog_hint;
    public Options[] dialog_options;
    public String dialog_title;
    public String form_data;
    public String form_url;
    public String sign_card_no;
    public int sign_state;
    public String toast_msg;
    public String webview_title;

    /* loaded from: classes13.dex */
    public static class Options implements Serializable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String BIND_CARD = "bind_card";
        public static final String CANCEL = "cancel";
        public static final String CHANGE_PAYTYPE = "change_paytype";
        public static final String JUMP_RESIGN = "jump_resign";
        public static final String PAY = "pay";
        public transient /* synthetic */ FieldHolder $fh;
        public String msg;
        public String type;

        public Options() {
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

        public boolean isOperationAvilable() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (TextUtils.isEmpty(this.type) || TextUtils.isEmpty(this.msg)) ? false : true : invokeV.booleanValue;
        }
    }

    public QueryResponse() {
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

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isGuidanceAvilable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Options[] optionsArr = this.dialog_options;
            if (optionsArr == null || optionsArr.length != 3) {
                return false;
            }
            boolean z = false;
            for (Options options : optionsArr) {
                z = options.isOperationAvilable();
                if (!z) {
                    break;
                }
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    @Override // com.dxmpay.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
        }
    }
}
