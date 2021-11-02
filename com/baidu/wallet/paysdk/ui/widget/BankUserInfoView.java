package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
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
import com.baidu.wallet.base.iddetect.UrlOcrConfig;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import com.dxmpay.apollon.utils.ResUtils;
import com.dxmpay.wallet.base.datamodel.UserData;
import com.dxmpay.wallet.base.widget.DivisionEditText;
import com.dxmpay.wallet.base.widget.SafeKeyBoardEditText;
import com.dxmpay.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
import com.dxmpay.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.dxmpay.wallet.core.utils.StringUtils;
import java.util.List;
@SuppressLint({"NewApi"})
/* loaded from: classes10.dex */
public class BankUserInfoView extends LinearLayout implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TextView f60425a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60426b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f60427c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f60428d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f60429e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60430f;

    /* renamed from: g  reason: collision with root package name */
    public BankCardErrorMsgView f60431g;

    /* renamed from: h  reason: collision with root package name */
    public BankCardErrorMsgView f60432h;

    /* renamed from: i  reason: collision with root package name */
    public BankCardErrorMsgView f60433i;
    public boolean j;
    public boolean k;
    public View mIdArea;
    public SafeKeyBoardEditText mIdCard;
    public View mMobileArea;
    public DivisionEditText mMobilePhone;
    public View mNameArea;
    public SafeKeyBoardEditText mTrueName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankUserInfoView(Context context) {
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
            LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_userinfo_view"), this);
            this.mNameArea = findViewById(ResUtils.id(getContext(), "true_name_area"));
            this.mIdArea = findViewById(ResUtils.id(getContext(), "id_card_area"));
            this.mMobileArea = findViewById(ResUtils.id(getContext(), "mobile_phone_area"));
            this.f60425a = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_true_name_tip"));
            SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "ebpay_true_name_id"));
            this.mTrueName = safeKeyBoardEditText;
            safeKeyBoardEditText.setUseSafeKeyBoard(false);
            this.mTrueName.setUseKeyX(false);
            String string = ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag");
            this.mTrueName.setTag(this.mNameArea.findViewWithTag(string));
            this.f60426b = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_phone_tip"));
            this.mMobilePhone = (DivisionEditText) findViewById(ResUtils.id(getContext(), "ebpay_mobile_phone_id"));
            this.mMobilePhone.setTag(this.mMobileArea.findViewWithTag(string));
            this.f60427c = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_id_card_tip"));
            this.mIdCard = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), UrlOcrConfig.IdCardKey.IDCARD_NO));
            this.mIdCard.setTag(this.mIdArea.findViewWithTag(string));
            this.f60428d = (ImageView) findViewById(ResUtils.id(getContext(), "name_tip_img"));
            this.f60429e = (ImageView) findViewById(ResUtils.id(getContext(), "id_tip_img"));
            this.mMobilePhone.setUseSafeKeyBoard(true);
            this.mMobilePhone.setViewType(13);
            this.mIdCard.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
            this.mIdCard.setUseSafeKeyBoard(false);
            this.mIdCard.setUseKeyX(false);
            this.f60430f = (ImageView) findViewById(ResUtils.id(getContext(), "phone_tip_img"));
            this.f60431g = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_name"));
            this.f60432h = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_idcard"));
            this.f60433i = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_mobile"));
            this.mIdCard.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
            this.mMobilePhone.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
            this.mTrueName.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
        }
    }

    public void clearEditMsg() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTrueName.setText("");
            this.mIdCard.setText("");
            this.mMobilePhone.setText("");
        }
    }

    public void configMaginTop(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.setMargins(0, i2, 0, 0);
            setLayoutParams(layoutParams);
        }
    }

    public boolean getIdCardFromNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public SafeKeyBoardEditText getIdEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIdCard : (SafeKeyBoardEditText) invokeV.objValue;
    }

    public ImageView getIdTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60429e : (ImageView) invokeV.objValue;
    }

    public DivisionEditText getMobileEditText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mMobilePhone : (DivisionEditText) invokeV.objValue;
    }

    public boolean getMobileFromNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public ImageView getMobileTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f60430f : (ImageView) invokeV.objValue;
    }

    public ImageView getNameTip() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f60428d : (ImageView) invokeV.objValue;
    }

    public SafeKeyBoardEditText getTrueNameText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTrueName : (SafeKeyBoardEditText) invokeV.objValue;
    }

    public void hideArea(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            this.mIdArea.setVisibility(z2 ? 8 : 0);
            this.mMobileArea.setVisibility(z3 ? 8 : 0);
            this.mNameArea.setVisibility(z ? 8 : 0);
        }
    }

    public void hideErrorLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            BankCardErrorMsgView bankCardErrorMsgView = this.f60431g;
            if (bankCardErrorMsgView != null) {
                bankCardErrorMsgView.showErrorLayout("", "");
                a.a(this.mTrueName, false, false);
            }
            BankCardErrorMsgView bankCardErrorMsgView2 = this.f60432h;
            if (bankCardErrorMsgView2 != null) {
                bankCardErrorMsgView2.showErrorLayout("", "");
                a.a(this.mIdCard, false, false);
            }
            BankCardErrorMsgView bankCardErrorMsgView3 = this.f60433i;
            if (bankCardErrorMsgView3 != null) {
                bankCardErrorMsgView3.showErrorLayout("", "");
                a.a(this.mMobilePhone, false, false);
            }
        }
    }

    public void hideErrorLayoutWithTag(View view, boolean z) {
        BankCardErrorMsgView bankCardErrorMsgView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, view, z) == null) {
            if (view == this.mTrueName) {
                bankCardErrorMsgView = this.f60431g;
            } else if (view == this.mIdCard) {
                bankCardErrorMsgView = this.f60432h;
            } else {
                bankCardErrorMsgView = view == this.mMobilePhone ? this.f60433i : null;
            }
            if (bankCardErrorMsgView != null) {
                bankCardErrorMsgView.showErrorLayout("", "");
                a.a(view, false, z);
            }
        }
    }

    public boolean isCheckMobileValidate() {
        InterceptResult invokeV;
        UserData.UserModel userInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mMobilePhone.getVisibility() != 0 || (userInfo = PayDataCache.getInstance().getUserInfo()) == null || TextUtils.isEmpty(userInfo.mobile_number) || !this.mMobilePhone.getRealText().equals(userInfo.mobile_number) : invokeV.booleanValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view) == null) {
        }
    }

    public void setCertificateCanClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            if (!this.mIdCard.isEnabled()) {
                this.f60427c.setBackgroundDrawable(null);
                this.f60427c.setEnabled(false);
            } else if (z) {
                Drawable drawable = ResUtils.getDrawable(getContext(), "dxm_right_arrow");
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                this.f60427c.setCompoundDrawables(null, null, drawable, null);
                this.f60427c.setEnabled(true);
            } else {
                this.f60427c.setBackgroundDrawable(null);
                this.f60427c.setEnabled(false);
            }
        }
    }

    public void setIdCardFromNet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.k = z;
        }
    }

    public void setIdInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, aVar) == null) {
            if (getVisibility() == 0 && this.mIdArea.getVisibility() == 0 && aVar != null) {
                if ("2".equals(aVar.b())) {
                    this.k = false;
                    this.mIdCard.setEnabled(false);
                    this.mIdCard.setText(aVar.a());
                    this.k = true;
                    return;
                } else if ("3".equals(aVar.b())) {
                    this.k = false;
                    this.mIdCard.setEnabled(true);
                    this.mIdCard.setText(aVar.a());
                    if (TextUtils.isEmpty(aVar.a())) {
                        return;
                    }
                    this.k = true;
                    return;
                } else {
                    this.mIdCard.setEnabled(true);
                    this.mIdCard.setText("");
                    return;
                }
            }
            this.mIdCard.setEnabled(true);
        }
    }

    public void setIdTipRedColor(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || (textView = this.f60427c) == null) {
            return;
        }
        if (z) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
        } else {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text2Color"));
        }
    }

    public void setMobileInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, aVar) == null) && getVisibility() == 0 && this.mMobileArea.getVisibility() == 0 && aVar != null) {
            if ("2".equals(aVar.b())) {
                this.j = false;
                this.mMobilePhone.setEnabled(false);
                this.mMobilePhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                this.mMobilePhone.setText(StringUtils.maskingPhoneNumber(aVar.a()));
                this.j = true;
            }
            if ("3".equals(aVar.b())) {
                this.j = false;
                this.mMobilePhone.setEnabled(true);
                this.mMobilePhone.setFilters(new InputFilter[]{new InputFilter.LengthFilter(13)});
                this.mMobilePhone.setText(StringUtils.maskingPhoneNumber(aVar.a()));
                if (TextUtils.isEmpty(aVar.a())) {
                    return;
                }
                this.j = true;
            }
        }
    }

    public void setMobileRedColor(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048597, this, z) == null) || (textView = this.f60426b) == null) {
            return;
        }
        if (z) {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text6Color"));
        } else {
            textView.setTextColor(ResUtils.getColor(getContext(), "dxm_wallet_base_font_text2Color"));
        }
    }

    public void setMoblieFromNet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            this.j = z;
        }
    }

    public void setOnCodeTypeClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, onClickListener) == null) {
            this.f60427c.setOnClickListener(onClickListener);
        }
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, onClickListener) == null) {
            this.f60430f.setOnClickListener(onClickListener);
            this.f60428d.setOnClickListener(onClickListener);
            this.f60429e.setOnClickListener(onClickListener);
        }
    }

    public void setTrueNameRedColor(boolean z) {
        TextView textView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048601, this, z) == null) || (textView = this.f60425a) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(1048602, this, str, str2, view) == null) {
            if (view == this.mTrueName) {
                bankCardErrorMsgView = this.f60431g;
            } else if (view == this.mIdCard) {
                bankCardErrorMsgView = this.f60432h;
            } else {
                bankCardErrorMsgView = view == this.mMobilePhone ? this.f60433i : null;
            }
            if (bankCardErrorMsgView != null) {
                bankCardErrorMsgView.showErrorLayout(str, str2);
                bankCardErrorMsgView.setTag(view);
                a.a(view, true, false);
            }
        }
    }

    public void updateCertificateType(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, certificateTypeInfo) == null) || certificateTypeInfo == null) {
            return;
        }
        this.f60427c.setText(certificateTypeInfo.description);
        if ("1".equals(certificateTypeInfo.type)) {
            List<IEditTextPasteFilter> editTextPasteFilters = this.mIdCard.getEditTextPasteFilters();
            if (editTextPasteFilters != null) {
                editTextPasteFilters.clear();
                editTextPasteFilters.add(new IDCardEditTextPasteFilter());
            }
            this.mIdCard.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
            this.mIdCard.setUseSafeKeyBoard(true);
            this.mIdCard.setUseKeyX(true);
            return;
        }
        List<IEditTextPasteFilter> editTextPasteFilters2 = this.mIdCard.getEditTextPasteFilters();
        if (editTextPasteFilters2 != null) {
            editTextPasteFilters2.clear();
            editTextPasteFilters2.add(new BlankCharEditTextPasteFilter());
        }
        this.mIdCard.setFilters(new InputFilter[]{new InputFilter.LengthFilter(40)});
        this.mIdCard.setUseSafeKeyBoard(false);
        this.mIdCard.setUseKeyX(false);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankUserInfoView(Context context, AttributeSet attributeSet) {
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
    public BankUserInfoView(Context context, AttributeSet attributeSet, int i2) {
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

    public void setIdInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048594, this, aVar, z) == null) {
            if (getVisibility() == 0 && this.mIdArea.getVisibility() == 0 && aVar != null) {
                if ("2".equals(aVar.b())) {
                    this.mIdCard.setEnabled(false);
                    return;
                } else if ("3".equals(aVar.b())) {
                    this.mIdCard.setEnabled(true);
                    return;
                } else {
                    this.mIdCard.setEnabled(true);
                    return;
                }
            }
            this.mIdCard.setEnabled(true);
        }
    }
}
