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
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.paysdk.ui.widget.BankCardErrorMsgView;
/* loaded from: classes6.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f26692a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f26693b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f26694c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f26695d;

    /* renamed from: e  reason: collision with root package name */
    public SafeKeyBoardEditText f26696e;

    /* renamed from: f  reason: collision with root package name */
    public BankCardErrorMsgView f26697f;

    /* renamed from: g  reason: collision with root package name */
    public View f26698g;

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
                this.f26692a = context;
                this.f26693b = (ViewGroup) LayoutInflater.from(context).inflate(ResUtils.layout(this.f26692a, "wallet_cashdesk_bind_card_item"), (ViewGroup) null);
                this.f26695d = (TextView) this.f26693b.findViewById(ResUtils.id(this.f26692a, "wallet_base_bindcard_item_title"));
                CharSequence d2 = d();
                if (!TextUtils.isEmpty(d2)) {
                    this.f26695d.setText(d2);
                }
                SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) this.f26693b.findViewById(ResUtils.id(this.f26692a, "wallet_base_bindcard_item_value"));
                this.f26696e = safeKeyBoardEditText;
                a(safeKeyBoardEditText);
                this.f26696e.setCheckFunc(f());
                View findViewWithTag = this.f26693b.findViewWithTag(ResUtils.getString(this.f26692a, "wallet_base_string_bindcard_item_line_tag"));
                this.f26698g = findViewWithTag;
                this.f26696e.setTag(findViewWithTag);
                this.f26697f = (BankCardErrorMsgView) this.f26693b.findViewById(ResUtils.id(this.f26692a, "wallet_bindcard_item_error"));
                ImageView imageView = (ImageView) this.f26693b.findViewById(ResUtils.id(this.f26692a, "wallet_base_bindcard_item_image"));
                this.f26694c = imageView;
                imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.paysdk.ui.a.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f26699a;

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
                        this.f26699a = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            if (this.f26699a.f26696e.getEditableText().length() == 0) {
                                this.f26699a.e();
                                return;
                            }
                            ((ImageView) view).setImageResource(ResUtils.drawable(this.f26699a.f26692a, "wallet_base_info_btn_selector"));
                            this.f26699a.f26696e.getEditableText().clear();
                            this.f26699a.f26696e.requestFocus();
                        }
                    }
                });
                this.f26696e.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.paysdk.ui.a.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f26700a;

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
                        this.f26700a = this;
                    }

                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                            String str = TextUtils.isEmpty(editable.toString().trim()) ? "wallet_base_info_btn_selector" : "wallet_base_delete";
                            a aVar = this.f26700a;
                            aVar.f26694c.setImageResource(ResUtils.drawable(aVar.f26692a, str));
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
                            this.f26700a.a(true);
                        }
                    }
                });
                this.f26696e.setOnMyFocusChangeListener(new SafeKeyBoardEditText.OnMyFocusChangeListener(this) { // from class: com.baidu.wallet.paysdk.ui.a.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ a f26701a;

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
                        this.f26701a = this;
                    }

                    @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.OnMyFocusChangeListener
                    public void onMyFocusChange(View view, boolean z) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeLZ(1048576, this, view, z) == null) && z) {
                            com.baidu.wallet.paysdk.ui.widget.a.a(this.f26701a.f26696e, false, true);
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
            this.f26697f.showErrorLayout(null, charSequence);
            com.baidu.wallet.paysdk.ui.widget.a.a(this.f26693b, true, false);
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f26697f.showErrorLayout(null, null);
            com.baidu.wallet.paysdk.ui.widget.a.a(this.f26693b, false, z);
        }
    }
}
