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
    public View.OnClickListener f24017a;

    /* renamed from: b  reason: collision with root package name */
    public final ContentDialogModel f24018b;

    public NoTitlePromptDialog(Context context) {
        this(context, ResUtils.style(context, "EbpayPromptDialog"));
    }

    private void a() {
        ContentDialogModel contentDialogModel = this.f24018b;
        contentDialogModel.defaultListener = this.f24017a;
        setAdapter(new NoTitleContentDialogAdapter(contentDialogModel));
    }

    public void hideButtons() {
        this.f24018b.hideButtons = true;
    }

    public void hideNegativeButton() {
        this.f24018b.hideNegativeBtn = true;
    }

    public void hidePositiveButton() {
        this.f24018b.hidePositiveBtn = true;
    }

    public void setDialogBackgroundColor(int i) {
        this.f24018b.dialogBackgound = i;
    }

    public void setMessage(int i) {
        this.f24018b.messageId = i;
    }

    public void setMessageBackgroundColor(int i) {
        this.f24018b.backgroundColor = i;
    }

    public void setMessageTextSize(int i) {
        this.f24018b.messageSize = i;
    }

    public void setNegativeBtn(View.OnClickListener onClickListener) {
        this.f24018b.negativeBtnClickListener = onClickListener;
    }

    public void setNegativeBtnTextColor(int i) {
        this.f24018b.negativeBtnTextColor = i;
    }

    public void setNegativeBtnTextSize(int i) {
        this.f24018b.negativeBtnTextSize = i;
    }

    public void setPositiveBtn(View.OnClickListener onClickListener) {
        this.f24018b.positiveBtnClickListener = onClickListener;
    }

    public void setPositiveBtnTextColor(int i) {
        this.f24018b.positiveBtnTextColor = i;
    }

    public void setPositiveBtnTextSize(int i) {
        this.f24018b.positiveBtnTextSize = i;
    }

    public NoTitlePromptDialog(Context context, int i) {
        super(context, i);
        this.f24017a = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.NoTitlePromptDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NoTitlePromptDialog.this.dismiss();
            }
        };
        this.f24018b = new ContentDialogModel();
        a();
    }

    public void setMessage(CharSequence charSequence) {
        this.f24018b.message = charSequence;
    }

    public void setNegativeBtn(int i, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24018b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnTextId = i;
    }

    public void setPositiveBtn(int i, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24018b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnTextId = i;
    }

    public void setNegativeBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24018b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = str;
    }

    public void setPositiveBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24018b;
        contentDialogModel.positiveBtnClickListener = onClickListener;
        contentDialogModel.positiveBtnText = spannableString;
    }

    public void setNegativeBtn(SpannableString spannableString, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24018b;
        contentDialogModel.negativeBtnClickListener = onClickListener;
        contentDialogModel.negativeBtnText = spannableString;
    }

    public void setPositiveBtn(String str, View.OnClickListener onClickListener) {
        ContentDialogModel contentDialogModel = this.f24018b;
        contentDialogModel.positiveBtnText = str;
        contentDialogModel.positiveBtnClickListener = onClickListener;
    }
}
