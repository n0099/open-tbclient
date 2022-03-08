package com.baidu.wallet.paysdk.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.paysdk.ui.widget.BankCardErrorMsgView;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f51005b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f51006c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51007d;

    /* renamed from: e  reason: collision with root package name */
    public SafeKeyBoardEditText f51008e;

    /* renamed from: f  reason: collision with root package name */
    public BankCardErrorMsgView f51009f;

    /* renamed from: g  reason: collision with root package name */
    public View f51010g;

    public a() {
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

    public void a(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            if (context != null) {
                this.a = context;
                this.f51005b = (ViewGroup) LayoutInflater.from(context).inflate(ResUtils.layout(this.a, "wallet_cashdesk_bind_card_item"), (ViewGroup) null);
                this.f51007d = (TextView) this.f51005b.findViewById(ResUtils.id(this.a, "wallet_base_bindcard_item_title"));
                CharSequence d2 = d();
                if (!TextUtils.isEmpty(d2)) {
                    this.f51007d.setText(d2);
                }
                SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f51005b.findViewById(ResUtils.id(this.a, "wallet_base_bindcard_item_value"));
                this.f51008e = safeKeyBoardEditText;
                a(safeKeyBoardEditText);
                this.f51008e.setCheckFunc(f());
                View findViewWithTag = this.f51005b.findViewWithTag(ResUtils.getString(this.a, "wallet_base_string_bindcard_item_line_tag"));
                this.f51010g = findViewWithTag;
                this.f51008e.setTag(findViewWithTag);
                this.f51009f = (BankCardErrorMsgView) this.f51005b.findViewById(ResUtils.id(this.a, "wallet_bindcard_item_error"));
                ImageView imageView = (ImageView) this.f51005b.findViewById(ResUtils.id(this.a, "wallet_base_bindcard_item_image"));
                this.f51006c = imageView;
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.a.f51008e.getEditableText().length() == 0) {
                                this.a.e();
                                return;
                            }
                            ((ImageView) view).setImageResource(ResUtils.drawable(this.a.a, "wallet_base_info_btn_selector"));
                            this.a.f51008e.getEditableText().clear();
                            this.a.f51008e.requestFocus();
                        }
                    }
                });
                this.f51008e.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                            String str = TextUtils.isEmpty(editable.toString().trim()) ? "wallet_base_info_btn_selector" : "dxm_wallet_base_delete";
                            a aVar = this.a;
                            aVar.f51006c.setImageResource(ResUtils.drawable(aVar.a, str));
                        }
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i3, i4, i5) == null) {
                        }
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i3, int i4, int i5) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i3, i4, i5) == null) {
                            this.a.a(true);
                        }
                    }
                });
                this.f51008e.setOnMyFocusChangeListener(new SafeKeyBoardEditText.OnMyFocusChangeListener(this) { // from class: com.baidu.wallet.paysdk.ui.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ a a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.a = this;
                    }

                    @Override // com.dxmpay.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
                    public void onMyFocusChange(View view, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) && z) {
                            com.baidu.wallet.paysdk.ui.widget.a.a(this.a.f51008e, false, true);
                        }
                    }
                });
                return;
            }
            throw new NullPointerException("context null");
        }
    }

    public abstract void a(SafeKeyBoardEditText safeKeyBoardEditText);

    public abstract CharSequence d();

    public abstract void e();

    public abstract SafeKeyBoardEditText.CheckFunc f();

    public void a(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, charSequence) == null) {
            this.f51009f.showErrorLayout(null, charSequence);
            com.baidu.wallet.paysdk.ui.widget.a.a(this.f51005b, true, false);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f51009f.showErrorLayout(null, null);
            com.baidu.wallet.paysdk.ui.widget.a.a(this.f51005b, false, z);
        }
    }
}
