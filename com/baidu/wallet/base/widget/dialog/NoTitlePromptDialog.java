package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
import com.baidu.wallet.base.widget.dialog.view.NoTitleContentDialogAdapter;
/* loaded from: classes10.dex */
public class NoTitlePromptDialog extends WalletDialog {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f57753a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f57754b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NoTitlePromptDialog(Context context) {
        this(context, ResUtils.style(context, "EbpayPromptDialog"));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ContentDialogModel contentDialogModel = this.f57754b;
            contentDialogModel.defaultListener = this.f57753a;
            setAdapter(new NoTitleContentDialogAdapter(contentDialogModel));
        }
    }

    public void hideButtons() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57754b.hideButtons = true;
        }
    }

    public void hideNegativeButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f57754b.hideNegativeBtn = true;
        }
    }

    public void hidePositiveButton() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f57754b.hidePositiveBtn = true;
        }
    }

    public void setDialogBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f57754b.dialogBackgound = i2;
        }
    }

    public void setMessage(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.f57754b.messageId = i2;
        }
    }

    public void setMessageBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            this.f57754b.backgroundColor = i2;
        }
    }

    public void setMessageTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.f57754b.messageSize = i2;
        }
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.f57754b.negativeBtnClickListener = onClickListener;
        }
    }

    public void setNegativeBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f57754b.negativeBtnTextColor = i2;
        }
    }

    public void setNegativeBtnTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f57754b.negativeBtnTextSize = i2;
        }
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            this.f57754b.positiveBtnClickListener = onClickListener;
        }
    }

    public void setPositiveBtnTextColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f57754b.positiveBtnTextColor = i2;
        }
    }

    public void setPositiveBtnTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            this.f57754b.positiveBtnTextSize = i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NoTitlePromptDialog(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f57753a = new View.OnClickListener(this) { // from class: com.baidu.wallet.base.widget.dialog.NoTitlePromptDialog.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ NoTitlePromptDialog f57755a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f57755a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                    this.f57755a.dismiss();
                }
            }
        };
        this.f57754b = new ContentDialogModel();
        a();
    }

    public void setMessage(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
            this.f57754b.message = charSequence;
        }
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f57754b;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnTextId = i2;
        }
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048590, this, i2, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f57754b;
            contentDialogModel.positiveBtnClickListener = onClickListener;
            contentDialogModel.positiveBtnTextId = i2;
        }
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, str, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f57754b;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnText = str;
        }
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, spannableString, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f57754b;
            contentDialogModel.positiveBtnClickListener = onClickListener;
            contentDialogModel.positiveBtnText = spannableString;
        }
    }

    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, spannableString, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f57754b;
            contentDialogModel.negativeBtnClickListener = onClickListener;
            contentDialogModel.negativeBtnText = spannableString;
        }
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, str, onClickListener) == null) {
            ContentDialogModel contentDialogModel = this.f57754b;
            contentDialogModel.positiveBtnText = str;
            contentDialogModel.positiveBtnClickListener = onClickListener;
        }
    }
}
