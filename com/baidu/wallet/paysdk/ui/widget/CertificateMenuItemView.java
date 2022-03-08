package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes6.dex */
public class CertificateMenuItemView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public GetCardInfoResponse.CertificateTypeInfo f51058b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CertificateMenuItemView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_base_menu_cert_item_view"), this);
            this.a = (TextView) findViewById(ResUtils.id(getContext(), "certi_text"));
        }
    }

    public GetCardInfoResponse.CertificateTypeInfo getCertificateTypeInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f51058b : (GetCardInfoResponse.CertificateTypeInfo) invokeV.objValue;
    }

    public void updateItem(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, certificateTypeInfo) == null) || certificateTypeInfo == null) {
            return;
        }
        this.f51058b = certificateTypeInfo;
        this.a.setTextColor(ResUtils.getColor(getContext(), certificateTypeInfo.isDisplay() ? "dxm_wallet_base_mainColor" : "dxm_wallet_base_font_text2Color"));
        this.a.setText(certificateTypeInfo.description);
    }
}
