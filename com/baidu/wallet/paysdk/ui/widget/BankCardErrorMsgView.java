package com.baidu.wallet.paysdk.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
/* loaded from: classes10.dex */
public class BankCardErrorMsgView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f60402a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60403b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardErrorMsgView(Context context) {
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
        a(context);
    }

    private void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(ResUtils.layout(context, "wallet_cashdesk_bindcard_errormsg_view"), this);
            this.f60402a = (TextView) inflate.findViewById(ResUtils.id(context, "wallet_bindcard_errormsg_tip_name"));
            this.f60403b = (TextView) inflate.findViewById(ResUtils.id(context, "wallet_bindcard_errormsg_tip_value"));
        }
    }

    public void showErrorLayout(CharSequence charSequence, CharSequence charSequence2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, charSequence, charSequence2) == null) {
            TextView textView = this.f60402a;
            TextUtils.isEmpty(charSequence);
            textView.setVisibility(8);
            this.f60402a.setText(charSequence);
            this.f60403b.setVisibility(TextUtils.isEmpty(charSequence2) ? 4 : 0);
            this.f60403b.setText(charSequence2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCardErrorMsgView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        a(context);
    }
}
