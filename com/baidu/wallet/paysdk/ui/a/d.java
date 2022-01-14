package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
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
/* loaded from: classes13.dex */
public class d extends com.baidu.wallet.paysdk.ui.a implements a.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final Context f52383h;

    /* renamed from: i  reason: collision with root package name */
    public SafeKeyBoardEditText.CheckFunc f52384i;

    public d(Context context) {
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
        this.f52383h = context;
        this.f52384i = new SafeKeyBoardEditText.CheckFunc(this, new com.baidu.wallet.paysdk.a()) { // from class: com.baidu.wallet.paysdk.ui.a.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ com.baidu.wallet.paysdk.a a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d f52385b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this, r7};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f52385b = this;
                this.a = r7;
            }

            @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
            public boolean check(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? this.a.a(str) : invokeL.booleanValue;
            }
        };
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            a(this.f52383h, 0);
            return this.f52374b;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f52377e : (SafeKeyBoardEditText) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a((CharSequence) ResUtils.getString(this.f52383h, "wallet_cashdesk_card_info_id_error_msg"));
        }
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public CharSequence d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ResUtils.getString(this.f52383h, "wallet_cashdesk_card_info_id_title") : (CharSequence) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            PromptDialog promptDialog = new PromptDialog(this.f52383h);
            Context context = this.f52383h;
            promptDialog.setMessage(context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_id_hint_msg")));
            promptDialog.setCanceledOnTouchOutside(false);
            Context context2 = this.f52383h;
            promptDialog.setTitleText(context2.getString(ResUtils.string(context2, "wallet_cashdesk_card_info_id_hint_title")));
            promptDialog.hideNegativeButton();
            promptDialog.setPositiveBtn(ResUtils.string(this.f52383h, "dxm_ebpay_know"), new View.OnClickListener(this, promptDialog) { // from class: com.baidu.wallet.paysdk.ui.a.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ PromptDialog a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f52386b;

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
                    this.f52386b = this;
                    this.a = promptDialog;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                        this.a.dismiss();
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f52384i : (SafeKeyBoardEditText.CheckFunc) invokeV.objValue;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, safeKeyBoardEditText) == null) {
            safeKeyBoardEditText.setHint(ResUtils.string(this.f52383h, "wallet_cashdesk_card_info_id_input_hint"));
            safeKeyBoardEditText.setUseSafeKeyBoard(true);
            safeKeyBoardEditText.setUseKeyX(true);
            safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            ((DivisionEditText) safeKeyBoardEditText).setViewType(20);
            safeKeyBoardEditText.setInputType(1);
            safeKeyBoardEditText.addEditTextPasteFilter(new IDCardEditTextPasteFilter());
        }
    }
}
