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
    public View.OnClickListener f23725a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f23726b;

    public NoTitlePromptDialog(Context context) {
        this(context, ResUtils.style(context, "EbpayPromptDialog"));
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.f23726b;
        contentDialogModel.defaultListener = this.f23725a;
        setAdapter(new NoTitleContentDialogAdapter(contentDialogModel));
    }

    public void hideButtons() {
        this.f23726b.hideButtons = true;
    }

    public void hideNegativeButton() {
        this.f23726b.hideNegativeBtn = true;
    }

    public void hidePositiveButton() {
        this.f23726b.hidePositiveBtn = true;
    }

    public void setDialogBackgroundColor(int i2) {
        this.f23726b.dialogBackgound = i2;
    }

    public void setMessage(int i2) {
        this.f23726b.messageId = i2;
    }

    public void setMessageBackgroundColor(int i2) {
        this.f23726b.backgroundColor = i2;
    }

    public void setMessageTextSize(int i2) {
        this.f23726b.messageSize = i2;
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        this.f23726b.negativeBtnClickListener = onClickListener;
    }

    public void setNegativeBtnTextColor(int i2) {
        this.f23726b.negativeBtnTextColor = i2;
    }

    public void setNegativeBtnTextSize(int i2) {
        this.f23726b.negativeBtnTextSize = i2;
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        this.f23726b.positiveBtnClickListener = onClickListener;
    }

    public void setPositiveBtnTextColor(int i2) {
        this.f23726b.positiveBtnTextColor = i2;
    }

    public void setPositiveBtnTextSize(int i2) {
        this.f23726b.positiveBtnTextSize = i2;
    }

    public NoTitlePromptDialog(Context context, int i2) {
        super(context, i2);
        this.f23725a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.NoTitlePromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NoTitlePromptDialog.this.dismiss();
            }
        };
        this.f23726b = new ContentDialogModel();
        a();
    }

    public void setMessage(CharSequence charSequence) {
        this.f23726b.message = charSequence;
    }

    public void setNegativeBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23726b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnTextId = i2;
    }

    public void setPositiveBtn(int i2, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23726b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnTextId = i2;
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23726b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = str;
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23726b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnText = spannableString;
    }

    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23726b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = spannableString;
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f23726b;
        contentDialogModel.positiveBtnText = str;
        contentDialogModel.positiveBtnClickListener = onClickListener;
    }
}
