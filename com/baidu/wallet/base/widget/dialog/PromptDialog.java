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
    public View.OnClickListener f24451a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f24452b;

    public PromptDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f24451a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptDialog.this.dismiss();
            }
        };
        this.f24452b = new ContentDialogModel();
        a();
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.f24452b;
        contentDialogModel.defaultListener = this.f24451a;
        setAdapter(new ContentDialogAdapter(contentDialogModel));
    }

    public void cancelNegativeBtnTextBold() {
        this.f24452b.negativeBtnTextBold = false;
    }

    public void cancelPositiveBtnTextBold() {
        this.f24452b.positiveBtnTextBold = false;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideButtons() {
        this.f24452b.hideButtons = true;
    }

    public void hideMessage() {
        this.f24452b.hideMessage = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideNegativeButton() {
        this.f24452b.hideNegativeBtn = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hidePositiveButton() {
        this.f24452b.hidePositiveBtn = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitle() {
        this.f24452b.hideTitle = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitleLine() {
    }

    public void setDialogBackgroundColor(int i2) {
        this.f24452b.dialogBackgound = i2;
    }

    public void setMessage(int i2) {
        this.f24452b.messageId = i2;
    }

    public void setMessageBackgroundColor(int i2) {
        this.f24452b.backgroundColor = i2;
    }

    public void setMessageColor(int i2) {
        this.f24452b.messageColor = i2;
    }

    public void setMessageTextSize(int i2) {
        this.f24452b.messageSize = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(View.OnClickListener onClickListener) {
        this.f24452b.negativeBtnClickListener = onClickListener;
    }

    public void setNegativeBtnTextColor(int i2) {
        this.f24452b.negativeBtnTextColor = i2;
    }

    public void setNegativeBtnTextSize(int i2) {
        this.f24452b.negativeBtnTextSize = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(View.OnClickListener onClickListener) {
        this.f24452b.positiveBtnClickListener = onClickListener;
    }

    public void setPositiveBtnTextColor(int i2) {
        this.f24452b.positiveBtnTextColor = i2;
    }

    public void setPositiveBtnTextSize(int i2) {
        this.f24452b.positiveBtnTextSize = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(int i2) {
        this.f24452b.titleId = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    @Deprecated
    public void setTitleTextBackgroud(int i2) {
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void showCloseBtn(boolean z) {
    }

    public void setMessage(CharSequence charSequence) {
        this.f24452b.message = charSequence;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24452b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnTextId = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24452b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnTextId = i2;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(ResUtils.string(getContext(), "ebpay_tip"));
        }
        this.f24452b.title = str;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24452b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = str;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24452b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnText = spannableString;
    }

    public PromptDialog(Context context, int i2) {
        super(context, i2);
        this.f24451a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptDialog.this.dismiss();
            }
        };
        this.f24452b = new ContentDialogModel();
        a();
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24452b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = spannableString;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24452b;
        contentDialogModel.positiveBtnText = str;
        contentDialogModel.positiveBtnClickListener = onClickListener;
    }
}
