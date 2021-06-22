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
    public ImageDialogModel f23813a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f23814b;

    public PromptImageDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23813a = new ImageDialogModel();
        this.f23814b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        ImageDialogModel imageDialogModel = this.f23813a;
        imageDialogModel.defaultClickListener = this.f23814b;
        setAdapter(new ImageDialogAdapter(imageDialogModel));
    }

    public void setButtonText(String str) {
        this.f23813a.buttonText = str;
    }

    public void setImage(int i2) {
        this.f23813a.imageId = i2;
    }

    public void setMessage(int i2) {
        this.f23813a.messageId = i2;
    }

    public void setMessageTemp(String str) {
        this.f23813a.messageTemp = str;
    }

    public void setTitleMessage(int i2) {
        this.f23813a.titleTextId = i2;
    }

    public void setButtonText(int i2) {
        this.f23813a.buttonTextId = i2;
    }

    public void setImage(Drawable drawable) {
        this.f23813a.imageDrawable = drawable;
    }

    public void setMessage(String str) {
        this.f23813a.message = str;
    }

    public void setMessageTemp(int i2) {
        this.f23813a.messageTempId = i2;
    }

    public void setTitleMessage(String str) {
        this.f23813a.titleText = str;
    }

    public PromptImageDialog(Context context, int i2) {
        super(context, i2);
        this.f23813a = new ImageDialogModel();
        this.f23814b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }
}
