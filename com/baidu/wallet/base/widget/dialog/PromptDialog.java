package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
import com.baidu.wallet.base.widget.dialog.view.ContentDialogAdapter;
/* loaded from: classes5.dex */
public class PromptDialog extends WalletDialog implements BaseDialogInterface {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f23810a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f23811b;

    public PromptDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23810a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptDialog.this.dismiss();
            }
        };
        this.f23811b = new ContentDialogModel();
        a();
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.f23811b;
        contentDialogModel.defaultListener = this.f23810a;
        setAdapter(new ContentDialogAdapter(contentDialogModel));
    }

    public void cancelNegativeBtnTextBold() {
        this.f23811b.negativeBtnTextBold = false;
    }

    public void cancelPositiveBtnTextBold() {
        this.f23811b.positiveBtnTextBold = false;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideButtons() {
        this.f23811b.hideButtons = true;
    }

    public void hideMessage() {
        this.f23811b.hideMessage = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideNegativeButton() {
        this.f23811b.hideNegativeBtn = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hidePositiveButton() {
        this.f23811b.hidePositiveBtn = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitle() {
        this.f23811b.hideTitle = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitleLine() {
    }

    public void setDialogBackgroundColor(int i2) {
        this.f23811b.dialogBackgound = i2;
    }

    public void setMessage(int i2) {
        this.f23811b.messageId = i2;
    }

    public void setMessageBackgroundColor(int i2) {
        this.f23811b.backgroundColor = i2;
    }

    public void setMessageColor(int i2) {
        this.f23811b.messageColor = i2;
    }

    public void setMessageTextSize(int i2) {
        this.f23811b.messageSize = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(View.OnClickListener onClickListener) {
        this.f23811b.negativeBtnClickListener = onClickListener;
    }

    public void setNegativeBtnTextColor(int i2) {
        this.f23811b.negativeBtnTextColor = i2;
    }

    public void setNegativeBtnTextSize(int i2) {
        this.f23811b.negativeBtnTextSize = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(View.OnClickListener onClickListener) {
        this.f23811b.positiveBtnClickListener = onClickListener;
    }

    public void setPositiveBtnTextColor(int i2) {
        this.f23811b.positiveBtnTextColor = i2;
    }

    public void setPositiveBtnTextSize(int i2) {
        this.f23811b.positiveBtnTextSize = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(int i2) {
        this.f23811b.titleId = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    @Deprecated
    public void setTitleTextBackgroud(int i2) {
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void showCloseBtn(boolean z) {
    }

    public void setMessage(CharSequence charSequence) {
        this.f23811b.message = charSequence;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23811b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnTextId = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23811b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnTextId = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(ResUtils.string(getContext(), "ebpay_tip"));
        }
        this.f23811b.title = str;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23811b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = str;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23811b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnText = spannableString;
    }

    public PromptDialog(Context context, int i2) {
        super(context, i2);
        this.f23810a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptDialog.this.dismiss();
            }
        };
        this.f23811b = new ContentDialogModel();
        a();
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23811b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = spannableString;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23811b;
        contentDialogModel.positiveBtnText = str;
        contentDialogModel.positiveBtnClickListener = onClickListener;
    }
}
