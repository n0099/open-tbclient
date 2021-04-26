package com.baidu.wallet.base.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
/* loaded from: classes5.dex */
public class EditTextDialog extends BaseDialog {

    /* renamed from: a  reason: collision with root package name */
    public TextView f24226a;
    public PluginEditText mContentEditText;

    public EditTextDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
    }

    public String getText() {
        return this.mContentEditText.getText().toString();
    }

    @Override // com.baidu.wallet.base.widget.BaseDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, this.mContext.getResources().getDimensionPixelSize(ResUtils.dimen(this.mContext, "ebpay_dimen_20dp")), 0, this.mContext.getResources().getDimensionPixelSize(ResUtils.dimen(this.mContext, "ebpay_dimen_20dp")));
        addContentView(ResUtils.layout(this.mContext, "wallet_base_layout_edit_dialog"), layoutParams);
        PluginEditText pluginEditText = (PluginEditText) findViewById(ResUtils.id(this.mContext, "dialog_msg"));
        this.mContentEditText = pluginEditText;
        pluginEditText.addTextChangedListener(new TextWatcher() { // from class: com.baidu.wallet.base.widget.EditTextDialog.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EditTextDialog editTextDialog = EditTextDialog.this;
                editTextDialog.setTextColor(ResUtils.getColor(editTextDialog.mContext, "wallet_nfc_gray_text"));
                EditTextDialog editTextDialog2 = EditTextDialog.this;
                editTextDialog2.setTipsText(ResUtils.getString(editTextDialog2.mContext, "wallet_nfc_buscard_cardlists_modify_card_tips"));
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        this.f24226a = (TextView) findViewById(ResUtils.id(this.mContext, "dialog_text_msg"));
    }

    public void setHint(int i2) {
        this.mContentEditText.setHint(i2);
    }

    public void setSelection(int i2) {
        this.mContentEditText.setSelection(i2);
    }

    public void setText(String str) {
        this.mContentEditText.setText(str);
    }

    public void setTextColor(int i2) {
        this.f24226a.setTextColor(i2);
    }

    public void setTipsText(String str) {
        this.f24226a.setText(str);
    }

    public EditTextDialog(Context context, int i2) {
        super(context, i2);
    }

    public void setHint(String str) {
        this.mContentEditText.setHint(str);
    }

    public void setTipsText(int i2) {
        this.f24226a.setText(i2);
    }
}
