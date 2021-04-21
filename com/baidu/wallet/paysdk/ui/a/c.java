package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.dialog.PromptImageDialog;
import com.baidu.wallet.base.widget.textfilter.NumberEditTextPasteFilter;
import com.baidu.wallet.paysdk.contract.a;
/* loaded from: classes5.dex */
public class c extends com.baidu.wallet.paysdk.ui.a implements a.b {

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardEditText.CheckFunc f26012h;

    public c(Context context) {
        this.f25997a = context;
        this.f26012h = new SafeKeyBoardEditText.CheckFunc() { // from class: com.baidu.wallet.paysdk.ui.a.c.1
            @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
            public boolean check(String str) {
                if (TextUtils.isEmpty(str)) {
                    return false;
                }
                return str.trim().length() == 3 || str.trim().length() == 4;
            }
        };
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public View a() {
        a(this.f25997a, 0);
        return this.f25998b;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void a(String str) {
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public SafeKeyBoardEditText b() {
        return this.f26001e;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void c() {
        a((CharSequence) ResUtils.getString(this.f25997a, "ebpay_bank_cvv2_errortip"));
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public CharSequence d() {
        return ResUtils.getString(this.f25997a, "wallet_cashdesk_card_info_cvv2_title");
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void e() {
        PromptImageDialog promptImageDialog = new PromptImageDialog(this.f25997a);
        promptImageDialog.setCanceledOnTouchOutside(false);
        promptImageDialog.setMessageTemp(ResUtils.string(this.f25997a, "wallet_cashdesk_card_info_cvv2_hint_msg"));
        promptImageDialog.setMessage(ResUtils.string(this.f25997a, "wallet_cashdesk_card_info_cvv2_hint_msg_2"));
        Context context = this.f25997a;
        promptImageDialog.setTitleMessage(context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_cvv2_hint_title")));
        promptImageDialog.setButtonText(ResUtils.string(this.f25997a, "ebpay_know"));
        promptImageDialog.setImage(ResUtils.drawable(this.f25997a, "wallet_base_help_cvv"));
        promptImageDialog.show();
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public SafeKeyBoardEditText.CheckFunc f() {
        return this.f26012h;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        safeKeyBoardEditText.setHint(ResUtils.string(this.f25997a, "wallet_cashdesk_card_info_cvv2_input_hint"));
        safeKeyBoardEditText.setUseSafeKeyBoard(true);
        safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
        safeKeyBoardEditText.addEditTextPasteFilter(new NumberEditTextPasteFilter());
    }
}
