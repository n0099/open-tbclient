package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
import com.baidu.wallet.base.widget.dialog.view.NoTitleContentDialogAdapter;
/* loaded from: classes5.dex */
public class NoTitlePromptDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public View.OnClickListener f23702a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f23703b;

    public NoTitlePromptDialog(Context context) {
        this(context, ResUtils.style(context, "EbpayPromptDialog"));
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.f23703b;
        contentDialogModel.defaultListener = this.f23702a;
        setAdapter(new NoTitleContentDialogAdapter(contentDialogModel));
    }

    public void hideButtons() {
        this.f23703b.hideButtons = true;
    }

    public void hideNegativeButton() {
        this.f23703b.hideNegativeBtn = true;
    }

    public void hidePositiveButton() {
        this.f23703b.hidePositiveBtn = true;
    }

    public void setDialogBackgroundColor(int i) {
        this.f23703b.dialogBackgound = i;
    }

    public void setMessage(int i) {
        this.f23703b.messageId = i;
    }

    public void setMessageBackgroundColor(int i) {
        this.f23703b.backgroundColor = i;
    }

    public void setMessageTextSize(int i) {
        this.f23703b.messageSize = i;
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        this.f23703b.negativeBtnClickListener = onClickListener;
    }

    public void setNegativeBtnTextColor(int i) {
        this.f23703b.negativeBtnTextColor = i;
    }

    public void setNegativeBtnTextSize(int i) {
        this.f23703b.negativeBtnTextSize = i;
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        this.f23703b.positiveBtnClickListener = onClickListener;
    }

    public void setPositiveBtnTextColor(int i) {
        this.f23703b.positiveBtnTextColor = i;
    }

    public void setPositiveBtnTextSize(int i) {
        this.f23703b.positiveBtnTextSize = i;
    }

    public NoTitlePromptDialog(Context context, int i) {
        super(context, i);
        this.f23702a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.NoTitlePromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NoTitlePromptDialog.this.dismiss();
            }
        };
        this.f23703b = new ContentDialogModel();
        a();
    }

    public void setMessage(CharSequence charSequence) {
        this.f23703b.message = charSequence;
    }

    public void setNegativeBtn(int i, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23703b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnTextId = i;
    }

    public void setPositiveBtn(int i, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23703b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnTextId = i;
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23703b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = str;
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23703b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnText = spannableString;
    }

    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23703b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = spannableString;
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23703b;
        contentDialogModel.positiveBtnText = str;
        contentDialogModel.positiveBtnClickListener = onClickListener;
    }
}
