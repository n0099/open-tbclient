package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
import com.baidu.wallet.paysdk.contract.a;
/* loaded from: classes5.dex */
public class a extends com.baidu.wallet.paysdk.ui.a implements a.b {

    /* renamed from: h  reason: collision with root package name */
    public SafeKeyBoardEditText.CheckFunc f26314h;

    public a(Context context) {
        this.f26304a = context;
        this.f26314h = new SafeKeyBoardEditText.CheckFunc() { // from class: com.baidu.wallet.paysdk.ui.a.a.1
            @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
            public boolean check(String str) {
                return !TextUtils.isEmpty(str) && str.trim().replace(" ", "").length() >= 9;
            }
        };
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public View a() {
        a(this.f26304a, 0);
        return this.f26305b;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void a(String str) {
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public SafeKeyBoardEditText b() {
        return this.f26308e;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void c() {
        a((CharSequence) ResUtils.getString(this.f26304a, "wallet_cashdesk_card_info_error_msg"));
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public CharSequence d() {
        return ResUtils.getString(this.f26304a, "wallet_cashdesk_card_info_title");
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void e() {
        final PromptDialog promptDialog = new PromptDialog(this.f26304a);
        Context context = this.f26304a;
        promptDialog.setMessage(context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_hint_msg")));
        Context context2 = this.f26304a;
        promptDialog.setTitleText(context2.getString(ResUtils.string(context2, "wallet_cashdesk_card_info_hint_title")));
        promptDialog.hideNegativeButton();
        promptDialog.setPositiveBtn(ResUtils.string(this.f26304a, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.a.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public SafeKeyBoardEditText.CheckFunc f() {
        return this.f26314h;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        safeKeyBoardEditText.setHint(ResUtils.string(this.f26304a, "wallet_cashdesk_card_info_input_hint"));
        safeKeyBoardEditText.setUseSafeKeyBoard(true);
        safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
        ((DivisionEditText) safeKeyBoardEditText).setViewType(25);
        safeKeyBoardEditText.addEditTextPasteFilter(new IDCardEditTextPasteFilter());
    }
}
