package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.dialog.PromptImageDialog;
import com.baidu.wallet.base.widget.textfilter.NumberEditTextPasteFilter;
import com.baidu.wallet.paysdk.contract.a;
/* loaded from: classes5.dex */
public class c extends com.baidu.wallet.paysdk.ui.a implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardEditText.CheckFunc f26975h;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26960a = context;
        this.f26975h = new SafeKeyBoardEditText.CheckFunc(this) { // from class: com.baidu.wallet.paysdk.ui.a.c.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ c f26976a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f26976a = this;
            }

            @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
            public boolean check(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) {
                    if (TextUtils.isEmpty(str)) {
                        return false;
                    }
                    return str.trim().length() == 3 || str.trim().length() == 4;
                }
                return invokeL.booleanValue;
            }
        };
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a(this.f26960a, 0);
            return this.f26961b;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public SafeKeyBoardEditText b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f26964e : (SafeKeyBoardEditText) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a((CharSequence) ResUtils.getString(this.f26960a, "ebpay_bank_cvv2_errortip"));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public CharSequence d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ResUtils.getString(this.f26960a, "wallet_cashdesk_card_info_cvv2_title") : (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PromptImageDialog promptImageDialog = new PromptImageDialog(this.f26960a);
            promptImageDialog.setCanceledOnTouchOutside(false);
            promptImageDialog.setMessageTemp(ResUtils.string(this.f26960a, "wallet_cashdesk_card_info_cvv2_hint_msg"));
            promptImageDialog.setMessage(ResUtils.string(this.f26960a, "wallet_cashdesk_card_info_cvv2_hint_msg_2"));
            Context context = this.f26960a;
            promptImageDialog.setTitleMessage(context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_cvv2_hint_title")));
            promptImageDialog.setButtonText(ResUtils.string(this.f26960a, "ebpay_know"));
            promptImageDialog.setImage(ResUtils.drawable(this.f26960a, "wallet_base_help_cvv"));
            promptImageDialog.show();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public SafeKeyBoardEditText.CheckFunc f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f26975h : (SafeKeyBoardEditText.CheckFunc) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, safeKeyBoardEditText) == null) {
            safeKeyBoardEditText.setHint(ResUtils.string(this.f26960a, "wallet_cashdesk_card_info_cvv2_input_hint"));
            safeKeyBoardEditText.setUseSafeKeyBoard(true);
            safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            safeKeyBoardEditText.addEditTextPasteFilter(new NumberEditTextPasteFilter());
        }
    }
}
