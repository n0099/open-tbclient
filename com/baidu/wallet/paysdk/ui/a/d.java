package com.baidu.wallet.paysdk.ui.a;

import android.content.Context;
import android.text.InputFilter;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.DivisionEditText;
import com.baidu.wallet.base.widget.SafeKeyBoardEditText;
import com.baidu.wallet.base.widget.dialog.PromptDialog;
import com.baidu.wallet.base.widget.textfilter.IDCardEditTextPasteFilter;
import com.baidu.wallet.paysdk.contract.a;
/* loaded from: classes5.dex */
public class d extends com.baidu.wallet.paysdk.ui.a implements a.b {

    /* renamed from: h  reason: collision with root package name */
    public final Context f26052h;

    /* renamed from: i  reason: collision with root package name */
    public SafeKeyBoardEditText.CheckFunc f26053i;

    public d(Context context) {
        this.f26052h = context;
        final com.baidu.wallet.paysdk.a aVar = new com.baidu.wallet.paysdk.a();
        this.f26053i = new SafeKeyBoardEditText.CheckFunc() { // from class: com.baidu.wallet.paysdk.ui.a.d.1
            @Override // com.baidu.wallet.base.widget.SafeKeyBoardEditText.CheckFunc
            public boolean check(String str) {
                return aVar.a(str);
            }
        };
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public View a() {
        a(this.f26052h, 0);
        return this.f26036b;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void a(String str) {
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public SafeKeyBoardEditText b() {
        return this.f26039e;
    }

    @Override // com.baidu.wallet.paysdk.contract.a.b
    public void c() {
        a((CharSequence) ResUtils.getString(this.f26052h, "wallet_cashdesk_card_info_id_error_msg"));
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public CharSequence d() {
        return ResUtils.getString(this.f26052h, "wallet_cashdesk_card_info_id_title");
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void e() {
        final PromptDialog promptDialog = new PromptDialog(this.f26052h);
        Context context = this.f26052h;
        promptDialog.setMessage(context.getString(ResUtils.string(context, "wallet_cashdesk_card_info_id_hint_msg")));
        promptDialog.setCanceledOnTouchOutside(false);
        Context context2 = this.f26052h;
        promptDialog.setTitleText(context2.getString(ResUtils.string(context2, "wallet_cashdesk_card_info_id_hint_title")));
        promptDialog.hideNegativeButton();
        promptDialog.setPositiveBtn(ResUtils.string(this.f26052h, "ebpay_know"), new View.OnClickListener() { // from class: com.baidu.wallet.paysdk.ui.a.d.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                promptDialog.dismiss();
            }
        });
        promptDialog.show();
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public SafeKeyBoardEditText.CheckFunc f() {
        return this.f26053i;
    }

    @Override // com.baidu.wallet.paysdk.ui.a
    public void a(SafeKeyBoardEditText safeKeyBoardEditText) {
        safeKeyBoardEditText.setHint(ResUtils.string(this.f26052h, "wallet_cashdesk_card_info_id_input_hint"));
        safeKeyBoardEditText.setUseSafeKeyBoard(true);
        safeKeyBoardEditText.setUseKeyX(true);
        safeKeyBoardEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
        ((DivisionEditText) safeKeyBoardEditText).setViewType(20);
        safeKeyBoardEditText.setInputType(1);
        safeKeyBoardEditText.addEditTextPasteFilter(new IDCardEditTextPasteFilter());
    }
}
