package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.contract.a;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.dialog.PromptDialog;
import com.dxmpay.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
/* loaded from: classes10.dex */
public class a extends com.baidu.wallet.paysdk.ui.a implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardEditText.CheckFunc f60373h;

    public a(Context context) {
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
        this.f60363a = context;
        this.f60373h = new SafeKeyBoardEditText.CheckFunc(this) { // from class: com.baidu.wallet.paysdk.ui.a.a.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f60374a;

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
                this.f60374a = this;
            }

            @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
            public boolean check(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? !TextUtils.isEmpty(str) && str.trim().replace(" ", "").length() >= 9 : invokeL.booleanValue;
            }
        };
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a(this.f60363a, 0);
            return this.f60364b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f60367e : (SafeKeyBoardEditText) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a((CharSequence) ResUtils.getString(this.f60363a, "wallet_cashdesk_card_info_error_msg"));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public CharSequence d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ResUtils.getString(this.f60363a, "wallet_cashdesk_card_info_title") : (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PromptDialog promptDialog = new PromptDialog(this.f60363a);
            Context context = this.f60363a;
            promptDialog.setMessage(context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_hint_msg")));
            Context context2 = this.f60363a;
            promptDialog.setTitleText(context2.getString(ResUtils.string(context2, "wallet_cashdesk_card_info_hint_title")));
            promptDialog.hideNegativeButton();
            promptDialog.setPositiveBtn(ResUtils.string(this.f60363a, "dxm_ebpay_know"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.paysdk.ui.a.a.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ PromptDialog f60375a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ a f60376b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, promptDialog};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60376b = this;
                    this.f60375a = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.f60375a.dismiss();
                    }
                }
            });
            promptDialog.show();
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public SafeKeyBoardEditText.CheckFunc f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60373h : (SafeKeyBoardEditText.CheckFunc) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, safeKeyBoardEditText) == null) {
            safeKeyBoardEditText.setHint(ResUtils.string(this.f60363a, "wallet_cashdesk_card_info_input_hint"));
            safeKeyBoardEditText.setUseSafeKeyBoard(true);
            safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
            ((DivisionEditText) safeKeyBoardEditText).setViewType(25);
            safeKeyBoardEditText.addEditTextPasteFilter(new IDCardEditTextPasteFilter());
        }
    }
}
