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
    public ImageDialogModel f23716a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f23717b;

    public PromptImageDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23716a = new ImageDialogModel();
        this.f23717b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        ImageDialogModel imageDialogModel = this.f23716a;
        imageDialogModel.defaultClickListener = this.f23717b;
        setAdapter(new ImageDialogAdapter(imageDialogModel));
    }

    public void setButtonText(String str) {
        this.f23716a.buttonText = str;
    }

    public void setImage(int i) {
        this.f23716a.imageId = i;
    }

    public void setMessage(int i) {
        this.f23716a.messageId = i;
    }

    public void setMessageTemp(String str) {
        this.f23716a.messageTemp = str;
    }

    public void setTitleMessage(int i) {
        this.f23716a.titleTextId = i;
    }

    public void setButtonText(int i) {
        this.f23716a.buttonTextId = i;
    }

    public void setImage(Drawable drawable) {
        this.f23716a.imageDrawable = drawable;
    }

    public void setMessage(String str) {
        this.f23716a.message = str;
    }

    public void setMessageTemp(int i) {
        this.f23716a.messageTempId = i;
    }

    public void setTitleMessage(String str) {
        this.f23716a.titleText = str;
    }

    public PromptImageDialog(Context context, int i) {
        super(context, i);
        this.f23716a = new ImageDialogModel();
        this.f23717b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }
}
