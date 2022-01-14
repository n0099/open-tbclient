package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
@SuppressLint({"NewApi"})
/* loaded from: classes13.dex */
public class BankCvv2InfoView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f52407b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f52408c;

    /* renamed from: d  reason: collision with root package name */
    public BankCardErrorMsgView f52409d;

    /* renamed from: e  reason: collision with root package name */
    public BankCardErrorMsgView f52410e;
    public SafeKeyBoardEditText mCvv2;
    public View mCvvArea;
    public ImageView mCvvTip;
    public SafeKeyBoardEditText mDate;
    public View mDateArea;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCvv2InfoView(Context context) {
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
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_creditinfo_view"), this);
            this.mCvvArea = findViewById(ResUtils.id(getContext(), "cvv2_area"));
            this.mDateArea = findViewById(ResUtils.id(getContext(), "valid_date_area"));
            this.a = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_valid_data_tip"));
            this.mDate = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "valid_data"));
            String string = ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag");
            this.mDate.setTag(this.mDateArea.findViewWithTag(string));
            this.f52407b = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_cvv2_tip"));
            this.mCvv2 = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "ebpay_cvv2_id"));
            this.mCvv2.setTag(this.mCvvArea.findViewWithTag(string));
            this.f52408c = (ImageView) findViewById(ResUtils.id(getContext(), "date_tip_img"));
            this.mCvvTip = (ImageView) findViewById(ResUtils.id(getContext(), "cvv_tip_img"));
            this.f52409d = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_credit_error_date"));
            this.f52410e = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_credit_error_cvv2"));
            this.mDate.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
            this.mCvv2.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
        }
    }

    public void clearEditMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mCvv2.setText("");
            this.mDate.setText("");
        }
    }

    public SafeKeyBoardEditText getCvv2InputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCvv2 : (SafeKeyBoardEditText) invokeV.objValue;
    }

    public ImageView getCvv2Tip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mCvvTip : (ImageView) invokeV.objValue;
    }

    public SafeKeyBoardEditText getDateInputView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDate : (SafeKeyBoardEditText) invokeV.objValue;
    }

    public ImageView getDateTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f52408c : (ImageView) invokeV.objValue;
    }

    public void hideArea(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.mDateArea.setVisibility(z2 ? 8 : 0);
            this.mCvvArea.setVisibility(z ? 8 : 0);
        }
    }

    public void hideErrorLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BankCardErrorMsgView bankCardErrorMsgView = this.f52410e;
            if (bankCardErrorMsgView != null) {
                bankCardErrorMsgView.showErrorLayout("", "");
                a.a(this.mCvv2, false, false);
            }
            BankCardErrorMsgView bankCardErrorMsgView2 = this.f52409d;
            if (bankCardErrorMsgView2 != null) {
                bankCardErrorMsgView2.showErrorLayout("", "");
                a.a(this.mDate, false, false);
            }
        }
    }

    public void hideErrorLayoutWithTag(View view, boolean z) {
        BankCardErrorMsgView bankCardErrorMsgView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view, z) == null) {
            if (view == this.mCvv2) {
                bankCardErrorMsgView = this.f52410e;
            } else {
                bankCardErrorMsgView = view == this.mDate ? this.f52409d : null;
            }
            if (bankCardErrorMsgView != null) {
                bankCardErrorMsgView.showErrorLayout("", "");
                a.a(view, false, z);
            }
        }
    }

    public void setCNN2RedColor(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (textView = this.f52407b) == null) {
            return;
        }
        if (z) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
        } else {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text2Color"));
        }
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, onClickListener) == null) {
            this.f52408c.setOnClickListener(onClickListener);
            this.mCvvTip.setOnClickListener(onClickListener);
        }
    }

    public void setValidDateRedColor(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || (textView = this.a) == null) {
            return;
        }
        if (z) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
        } else {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text2Color"));
        }
    }

    public void showErrorLayout(String str, String str2, View view) {
        BankCardErrorMsgView bankCardErrorMsgView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, str2, view) == null) {
            if (view == this.mCvv2) {
                bankCardErrorMsgView = this.f52410e;
            } else {
                bankCardErrorMsgView = view == this.mDate ? this.f52409d : null;
            }
            if (bankCardErrorMsgView != null) {
                bankCardErrorMsgView.showErrorLayout(str, str2);
                bankCardErrorMsgView.setTag(view);
                a.a(view, true, false);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCvv2InfoView(Context context, AttributeSet attributeSet) {
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
        a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankCvv2InfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        a();
    }
}
