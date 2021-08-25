package com.baidu.wallet.base.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class SafeKeyBoardPopUpWindowNew extends SafeKeyBoardPopupWindow {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ImageButton f60425a;
    public Button btConfirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SafeKeyBoardPopUpWindowNew(Context context) {
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
        this.btConfirm = (Button) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_confirm"));
        ImageButton imageButton = (ImageButton) this.contentView.findViewById(ResUtils.id(this.mContext, "wallet_base_safekeyboard_hide"));
        this.f60425a = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopUpWindowNew.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ SafeKeyBoardPopUpWindowNew f60426a;

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
                this.f60426a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    EventBus eventBus = EventBus.getInstance();
                    eventBus.getClass();
                    EventBus.getInstance().post(new EventBus.Event(eventBus, "hide_keyboard_listener", null));
                }
            }
        });
    }

    @Override // com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow
    public int getLayoutId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return ResUtils.layout(this.mContext, this.miniMode ? "wallet_base_safekeyboard_popupwindow_new_mini" : "wallet_base_safekeyboard_popupwindow_new");
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow
    public void initKeyNum(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            super.initKeyNum(z);
            SafeKeyBoardEditText safeKeyBoardEditText = this.mySafeEditText;
            if (safeKeyBoardEditText != null) {
                String obj = safeKeyBoardEditText.getEditableText().toString();
                SafeKeyBoardEditText safeKeyBoardEditText2 = this.mySafeEditText;
                if (safeKeyBoardEditText2 != null && safeKeyBoardEditText2.getCheckFunc() != null) {
                    this.btConfirm.setEnabled(this.mySafeEditText.getCheckFunc().check(obj));
                }
            }
            this.mySafeEditText.addTextChangedListener(new TextWatcher(this) { // from class: com.baidu.wallet.base.widget.SafeKeyBoardPopUpWindowNew.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SafeKeyBoardPopUpWindowNew f60427a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f60427a = this;
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, editable) == null) {
                        if (TextUtils.isEmpty(editable)) {
                            this.f60427a.btConfirm.setEnabled(false);
                            return;
                        }
                        String obj2 = editable.toString();
                        SafeKeyBoardEditText safeKeyBoardEditText3 = this.f60427a.mySafeEditText;
                        if (safeKeyBoardEditText3 == null || safeKeyBoardEditText3.getCheckFunc() == null) {
                            return;
                        }
                        this.f60427a.btConfirm.setEnabled(this.f60427a.mySafeEditText.getCheckFunc().check(obj2));
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) || TextUtils.isEmpty(charSequence)) {
                        return;
                    }
                    String charSequence2 = charSequence.toString();
                    SafeKeyBoardEditText safeKeyBoardEditText3 = this.f60427a.mySafeEditText;
                    if (safeKeyBoardEditText3 == null || safeKeyBoardEditText3.getCheckFunc() == null) {
                        return;
                    }
                    this.f60427a.btConfirm.setEnabled(this.f60427a.mySafeEditText.getCheckFunc().check(charSequence2));
                }
            });
            this.btConfirm.setOnClickListener(this.mySafeEditText.getOnConfirmListener());
            this.mButtonX.setBackgroundResource(ResUtils.drawable(this.mContext, "wallet_base_safekeyboard_numkey_selector"));
        }
    }

    @Override // com.baidu.wallet.base.widget.SafeKeyBoardPopupWindow
    public void setSafeEditTet(SafeKeyBoardEditText safeKeyBoardEditText) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, safeKeyBoardEditText) == null) {
            super.setSafeEditTet(safeKeyBoardEditText);
            if (this.mySafeEditText != null) {
                String obj = safeKeyBoardEditText.getEditableText().toString();
                if (safeKeyBoardEditText.getCheckFunc() != null) {
                    this.btConfirm.setEnabled(safeKeyBoardEditText.getCheckFunc().check(obj));
                }
            }
        }
    }
}
