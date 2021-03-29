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
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.datamodel.UserData;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.textfilter.BlankCharEditTextPasteFilter;
import com.baidu.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
import com.baidu.wallet.base.widget.textfilter.IEditTextPasteFilter;
import com.baidu.wallet.core.utils.StringUtils;
import com.baidu.wallet.paysdk.datamodel.GetCardInfoResponse;
import com.baidu.wallet.paysdk.storage.PayDataCache;
import java.util.List;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class BankUserInfoView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public TextView f26364a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26365b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f26366c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f26367d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f26368e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f26369f;

    /* renamed from: g  reason: collision with root package name */
    public BankCardErrorMsgView f26370g;

    /* renamed from: h  reason: collision with root package name */
    public BankCardErrorMsgView f26371h;
    public BankCardErrorMsgView i;
    public boolean j;
    public boolean k;
    public View mIdArea;
    public SafeKeyBoardEditText mIdCard;
    public View mMobileArea;
    public DivisionEditText mMobilePhone;
    public View mNameArea;
    public SafeKeyBoardEditText mTrueName;

    public BankUserInfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_card_userinfo_view"), this);
        this.mNameArea = findViewById(ResUtils.id(getContext(), "true_name_area"));
        this.mIdArea = findViewById(ResUtils.id(getContext(), "id_card_area"));
        this.mMobileArea = findViewById(ResUtils.id(getContext(), "mobile_phone_area"));
        this.f26364a = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_true_name_tip"));
        SafeKeyBoardEditText safeKeyBoardEditText = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "ebpay_true_name_id"));
        this.mTrueName = safeKeyBoardEditText;
        safeKeyBoardEditText.setUseSafeKeyBoard(false);
        this.mTrueName.setUseKeyX(false);
        String string = ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag");
        this.mTrueName.setTag(this.mNameArea.findViewWithTag(string));
        this.f26365b = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_phone_tip"));
        this.mMobilePhone = (DivisionEditText) findViewById(ResUtils.id(getContext(), "ebpay_mobile_phone_id"));
        this.mMobilePhone.setTag(this.mMobileArea.findViewWithTag(string));
        this.f26366c = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_id_card_tip"));
        this.mIdCard = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "id_card"));
        this.mIdCard.setTag(this.mIdArea.findViewWithTag(string));
        this.f26367d = (ImageView) findViewById(ResUtils.id(getContext(), "name_tip_img"));
        this.f26368e = (ImageView) findViewById(ResUtils.id(getContext(), "id_tip_img"));
        this.mMobilePhone.setUseSafeKeyBoard(true);
        this.mMobilePhone.setViewType(13);
        this.mIdCard.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        this.mIdCard.setUseSafeKeyBoard(false);
        this.mIdCard.setUseKeyX(false);
        this.f26369f = (ImageView) findViewById(ResUtils.id(getContext(), "phone_tip_img"));
        this.f26370g = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_name"));
        this.f26371h = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_idcard"));
        this.i = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_userinfo_error_mobile"));
        this.mIdCard.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
        this.mMobilePhone.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
        this.mTrueName.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
    }

    public void clearEditMsg() {
        this.mTrueName.setText("");
        this.mIdCard.setText("");
        this.mMobilePhone.setText("");
    }

    public void configMaginTop(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        layoutParams.setMargins(0, i, 0, 0);
        setLayoutParams(layoutParams);
    }

    public boolean getIdCardFromNet() {
        return this.k;
    }

    public SafeKeyBoardEditText getIdEditText() {
        return this.mIdCard;
    }

    public ImageView getIdTip() {
        return this.f26368e;
    }

    public DivisionEditText getMobileEditText() {
        return this.mMobilePhone;
    }

    public boolean getMobileFromNet() {
        return this.j;
    }

    public ImageView getMobileTip() {
        return this.f26369f;
    }

    public ImageView getNameTip() {
        return this.f26367d;
    }

    public SafeKeyBoardEditText getTrueNameText() {
        return this.mTrueName;
    }

    public void hideArea(boolean z, boolean z2, boolean z3) {
        this.mIdArea.setVisibility(z2 ? 8 : 0);
        this.mMobileArea.setVisibility(z3 ? 8 : 0);
        this.mNameArea.setVisibility(z ? 8 : 0);
    }

    public void hideErrorLayout() {
        BankCardErrorMsgView bankCardErrorMsgView = this.f26370g;
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout("", "");
            a.a(this.mTrueName, false, false);
        }
        BankCardErrorMsgView bankCardErrorMsgView2 = this.f26371h;
        if (bankCardErrorMsgView2 != null) {
            bankCardErrorMsgView2.showErrorLayout("", "");
            a.a(this.mIdCard, false, false);
        }
        BankCardErrorMsgView bankCardErrorMsgView3 = this.i;
        if (bankCardErrorMsgView3 != null) {
            bankCardErrorMsgView3.showErrorLayout("", "");
            a.a(this.mMobilePhone, false, false);
        }
    }

    public void hideErrorLayoutWithTag(View view, boolean z) {
        BankCardErrorMsgView bankCardErrorMsgView;
        if (view == this.mTrueName) {
            bankCardErrorMsgView = this.f26370g;
        } else if (view == this.mIdCard) {
            bankCardErrorMsgView = this.f26371h;
        } else {
            bankCardErrorMsgView = view == this.mMobilePhone ? this.i : null;
        }
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout("", "");
            a.a(view, false, z);
        }
    }

    public boolean isCheckMobileValidate() {
        UserData.UserModel userInfo;
        return this.mMobilePhone.getVisibility() != 0 || (userInfo = PayDataCache.getInstance().getUserInfo()) == null || TextUtils.isEmpty(userInfo.mobile_number) || !this.mMobilePhone.getRealText().equals(userInfo.mobile_number);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    public void setCertificateCanClick(boolean z) {
        if (!this.mIdCard.isEnabled()) {
            this.f26366c.setBackgroundDrawable(null);
            this.f26366c.setEnabled(false);
        } else if (z) {
            Drawable drawable = ResUtils.getDrawable(getContext(), "right_arrow");
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            this.f26366c.setCompoundDrawables(null, null, drawable, null);
            this.f26366c.setEnabled(true);
        } else {
            this.f26366c.setBackgroundDrawable(null);
            this.f26366c.setEnabled(false);
        }
    }

    public void setIdCardFromNet(boolean z) {
        this.k = z;
    }

    public void setIdInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar) {
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

    public void setIdTipRedColor(boolean z) {
        TextView textView = this.f26366c;
        if (textView != null) {
            if (z) {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            } else {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text2Color"));
            }
        }
    }

    public void setMobileInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar) {
        if (getVisibility() == 0 && this.mMobileArea.getVisibility() == 0 && aVar != null) {
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
        TextView textView = this.f26365b;
        if (textView != null) {
            if (z) {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            } else {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text2Color"));
            }
        }
    }

    public void setMoblieFromNet(boolean z) {
        this.j = z;
    }

    public void setOnCodeTypeClickListener(View.OnClickListener onClickListener) {
        this.f26366c.setOnClickListener(onClickListener);
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        this.f26369f.setOnClickListener(onClickListener);
        this.f26367d.setOnClickListener(onClickListener);
        this.f26368e.setOnClickListener(onClickListener);
    }

    public void setTrueNameRedColor(boolean z) {
        TextView textView = this.f26364a;
        if (textView != null) {
            if (z) {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            } else {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text2Color"));
            }
        }
    }

    public void showErrorLayout(String str, String str2, View view) {
        BankCardErrorMsgView bankCardErrorMsgView;
        if (view == this.mTrueName) {
            bankCardErrorMsgView = this.f26370g;
        } else if (view == this.mIdCard) {
            bankCardErrorMsgView = this.f26371h;
        } else {
            bankCardErrorMsgView = view == this.mMobilePhone ? this.i : null;
        }
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout(str, str2);
            bankCardErrorMsgView.setTag(view);
            a.a(view, true, false);
        }
    }

    public void updateCertificateType(GetCardInfoResponse.CertificateTypeInfo certificateTypeInfo) {
        if (certificateTypeInfo == null) {
            return;
        }
        this.f26366c.setText(certificateTypeInfo.description);
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

    public BankUserInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BankUserInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    public void setIdInputAreaStatus(com.baidu.wallet.paysdk.datamodel.a aVar, boolean z) {
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
