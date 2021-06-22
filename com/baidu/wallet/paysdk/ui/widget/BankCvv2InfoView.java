package com.baidu.wallet.paysdk.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
@SuppressLint({"NewApi"})
/* loaded from: classes5.dex */
public class BankCvv2InfoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f26202a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f26203b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f26204c;

    /* renamed from: d  reason: collision with root package name */
    public BankCardErrorMsgView f26205d;

    /* renamed from: e  reason: collision with root package name */
    public BankCardErrorMsgView f26206e;
    public SafeKeyBoardEditText mCvv2;
    public View mCvvArea;
    public ImageView mCvvTip;
    public SafeKeyBoardEditText mDate;
    public View mDateArea;

    public BankCvv2InfoView(Context context) {
        super(context);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(ResUtils.layout(getContext(), "wallet_cashdesk_bind_creditinfo_view"), this);
        this.mCvvArea = findViewById(ResUtils.id(getContext(), "cvv2_area"));
        this.mDateArea = findViewById(ResUtils.id(getContext(), "valid_date_area"));
        this.f26202a = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_valid_data_tip"));
        this.mDate = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "valid_data"));
        String string = ResUtils.getString(getContext(), "wallet_base_string_bindcard_item_line_tag");
        this.mDate.setTag(this.mDateArea.findViewWithTag(string));
        this.f26203b = (TextView) findViewById(ResUtils.id(getContext(), "ebpay_cvv2_tip"));
        this.mCvv2 = (SafeKeyBoardEditText) findViewById(ResUtils.id(getContext(), "ebpay_cvv2_id"));
        this.mCvv2.setTag(this.mCvvArea.findViewWithTag(string));
        this.f26204c = (ImageView) findViewById(ResUtils.id(getContext(), "date_tip_img"));
        this.mCvvTip = (ImageView) findViewById(ResUtils.id(getContext(), "cvv_tip_img"));
        this.f26205d = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_credit_error_date"));
        this.f26206e = (BankCardErrorMsgView) findViewById(ResUtils.id(getContext(), "wallet_bindcard_credit_error_cvv2"));
        this.mDate.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
        this.mCvv2.setMyHintTextSize("ebpay_bind_card_edittext_hint_txt_size");
    }

    public void clearEditMsg() {
        this.mCvv2.setText("");
        this.mDate.setText("");
    }

    public SafeKeyBoardEditText getCvv2InputView() {
        return this.mCvv2;
    }

    public ImageView getCvv2Tip() {
        return this.mCvvTip;
    }

    public SafeKeyBoardEditText getDateInputView() {
        return this.mDate;
    }

    public ImageView getDateTip() {
        return this.f26204c;
    }

    public void hideArea(boolean z, boolean z2) {
        this.mDateArea.setVisibility(z2 ? 8 : 0);
        this.mCvvArea.setVisibility(z ? 8 : 0);
    }

    public void hideErrorLayout() {
        BankCardErrorMsgView bankCardErrorMsgView = this.f26206e;
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout("", "");
            a.a(this.mCvv2, false, false);
        }
        BankCardErrorMsgView bankCardErrorMsgView2 = this.f26205d;
        if (bankCardErrorMsgView2 != null) {
            bankCardErrorMsgView2.showErrorLayout("", "");
            a.a(this.mDate, false, false);
        }
    }

    public void hideErrorLayoutWithTag(View view, boolean z) {
        BankCardErrorMsgView bankCardErrorMsgView;
        if (view == this.mCvv2) {
            bankCardErrorMsgView = this.f26206e;
        } else {
            bankCardErrorMsgView = view == this.mDate ? this.f26205d : null;
        }
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout("", "");
            a.a(view, false, z);
        }
    }

    public void setCNN2RedColor(boolean z) {
        TextView textView = this.f26203b;
        if (textView != null) {
            if (z) {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text6Color"));
            } else {
                textView.setTextColor(ResUtils.getColor(getContext(), "wallet_base_font_text2Color"));
            }
        }
    }

    public void setTipClick(View.OnClickListener onClickListener) {
        this.f26204c.setOnClickListener(onClickListener);
        this.mCvvTip.setOnClickListener(onClickListener);
    }

    public void setValidDateRedColor(boolean z) {
        TextView textView = this.f26202a;
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
        if (view == this.mCvv2) {
            bankCardErrorMsgView = this.f26206e;
        } else {
            bankCardErrorMsgView = view == this.mDate ? this.f26205d : null;
        }
        if (bankCardErrorMsgView != null) {
            bankCardErrorMsgView.showErrorLayout(str, str2);
            bankCardErrorMsgView.setTag(view);
            a.a(view, true, false);
        }
    }

    public BankCvv2InfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BankCvv2InfoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
