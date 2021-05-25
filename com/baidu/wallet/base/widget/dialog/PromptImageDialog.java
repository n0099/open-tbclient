package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ImageDialogModel;
import com.baidu.wallet.base.widget.dialog.view.ImageDialogAdapter;
/* loaded from: classes5.dex */
public class PromptImageDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public ImageDialogModel f23628a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f23629b;

    public PromptImageDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23628a = new ImageDialogModel();
        this.f23629b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        ImageDialogModel imageDialogModel = this.f23628a;
        imageDialogModel.defaultClickListener = this.f23629b;
        setAdapter(new ImageDialogAdapter(imageDialogModel));
    }

    public void setButtonText(String str) {
        this.f23628a.buttonText = str;
    }

    public void setImage(int i2) {
        this.f23628a.imageId = i2;
    }

    public void setMessage(int i2) {
        this.f23628a.messageId = i2;
    }

    public void setMessageTemp(String str) {
        this.f23628a.messageTemp = str;
    }

    public void setTitleMessage(int i2) {
        this.f23628a.titleTextId = i2;
    }

    public void setButtonText(int i2) {
        this.f23628a.buttonTextId = i2;
    }

    public void setImage(Drawable drawable) {
        this.f23628a.imageDrawable = drawable;
    }

    public void setMessage(String str) {
        this.f23628a.message = str;
    }

    public void setMessageTemp(int i2) {
        this.f23628a.messageTempId = i2;
    }

    public void setTitleMessage(String str) {
        this.f23628a.titleText = str;
    }

    public PromptImageDialog(Context context, int i2) {
        super(context, i2);
        this.f23628a = new ImageDialogModel();
        this.f23629b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }
}
