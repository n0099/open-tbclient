package com.baidu.wallet.paysdk.datamodel;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.datamodel.UserData;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class CardAddResponse extends DirectPayContentResponse {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int bind_card_num;
    public ConfirmWindow confirm_window;
    public CustomerSvcCfg intelligent_service;
    public int request_type;

    /* loaded from: classes6.dex */
    public static class ConfirmWindow implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String btn_name;
        public String content;
        public String title;

        public ConfirmWindow() {
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
    }

    /* loaded from: classes6.dex */
    public static class CustomerSvcCfg implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String customer_service_copy;
        public String customer_service_icon;
        public String customer_service_url;

        public CustomerSvcCfg() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.customer_service_url = "";
            this.customer_service_copy = "";
            this.customer_service_icon = "";
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static CardAddResponse f25914a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-501120431, "Lcom/baidu/wallet/paysdk/datamodel/CardAddResponse$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-501120431, "Lcom/baidu/wallet/paysdk/datamodel/CardAddResponse$a;");
                    return;
                }
            }
            f25914a = new CardAddResponse();
        }
    }

    public CardAddResponse() {
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

    public static CardAddResponse getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? a.f25914a : (CardAddResponse) invokeV.objValue;
    }

    public static void updateContent(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, obj) == null) && (obj instanceof CardAddResponse)) {
            CardAddResponse unused = a.f25914a = (CardAddResponse) obj;
        }
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.baidu.apollon.beans.IBeanResponse
    public boolean checkResponseValidity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (super.checkResponseValidity()) {
                return !TextUtils.isEmpty(this.intelligent_service.customer_service_icon);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse
    public boolean hasBindCards() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bind_card_num > 0 : invokeV.booleanValue;
    }

    @Override // com.baidu.wallet.paysdk.datamodel.DirectPayContentResponse, com.baidu.apollon.beans.IBeanResponse
    public void storeResponse(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            UserData.UserModel userModel = this.user;
            if (userModel != null) {
                userModel.decrypt();
            }
            super.storeResponse(context);
        }
    }
}
