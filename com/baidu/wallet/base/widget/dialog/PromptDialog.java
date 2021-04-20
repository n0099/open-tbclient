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
    public View.OnClickListener f23705a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f23706b;

    public PromptDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23705a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptDialog.this.dismiss();
            }
        };
        this.f23706b = new ContentDialogModel();
        a();
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.f23706b;
        contentDialogModel.defaultListener = this.f23705a;
        setAdapter(new ContentDialogAdapter(contentDialogModel));
    }

    public void cancelNegativeBtnTextBold() {
        this.f23706b.negativeBtnTextBold = false;
    }

    public void cancelPositiveBtnTextBold() {
        this.f23706b.positiveBtnTextBold = false;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideButtons() {
        this.f23706b.hideButtons = true;
    }

    public void hideMessage() {
        this.f23706b.hideMessage = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideNegativeButton() {
        this.f23706b.hideNegativeBtn = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hidePositiveButton() {
        this.f23706b.hidePositiveBtn = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitle() {
        this.f23706b.hideTitle = true;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void hideTitleLine() {
    }

    public void setDialogBackgroundColor(int i) {
        this.f23706b.dialogBackgound = i;
    }

    public void setMessage(int i) {
        this.f23706b.messageId = i;
    }

    public void setMessageBackgroundColor(int i) {
        this.f23706b.backgroundColor = i;
    }

    public void setMessageColor(int i) {
        this.f23706b.messageColor = i;
    }

    public void setMessageTextSize(int i) {
        this.f23706b.messageSize = i;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(View.OnClickListener onClickListener) {
        this.f23706b.negativeBtnClickListener = onClickListener;
    }

    public void setNegativeBtnTextColor(int i) {
        this.f23706b.negativeBtnTextColor = i;
    }

    public void setNegativeBtnTextSize(int i) {
        this.f23706b.negativeBtnTextSize = i;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(View.OnClickListener onClickListener) {
        this.f23706b.positiveBtnClickListener = onClickListener;
    }

    public void setPositiveBtnTextColor(int i) {
        this.f23706b.positiveBtnTextColor = i;
    }

    public void setPositiveBtnTextSize(int i) {
        this.f23706b.positiveBtnTextSize = i;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(int i) {
        this.f23706b.titleId = i;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    @Deprecated
    public void setTitleTextBackgroud(int i) {
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void showCloseBtn(boolean z) {
    }

    public void setMessage(CharSequence charSequence) {
        this.f23706b.message = charSequence;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(int i, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23706b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnTextId = i;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(int i, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23706b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnTextId = i;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setTitleText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getContext().getString(ResUtils.string(getContext(), "ebpay_tip"));
        }
        this.f23706b.title = str;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23706b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = str;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23706b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnText = spannableString;
    }

    public PromptDialog(Context context, int i) {
        super(context, i);
        this.f23705a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptDialog.this.dismiss();
            }
        };
        this.f23706b = new ContentDialogModel();
        a();
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23706b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = spannableString;
    }

    @Override // com.baidu.wallet.base.widget.dialog.BaseDialogInterface
    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23706b;
        contentDialogModel.positiveBtnText = str;
        contentDialogModel.positiveBtnClickListener = onClickListener;
    }
}
