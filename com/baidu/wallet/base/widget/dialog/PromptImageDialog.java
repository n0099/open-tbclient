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
    public ImageDialogModel f24022a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f24023b;

    public PromptImageDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f24022a = new ImageDialogModel();
        this.f24023b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        ImageDialogModel imageDialogModel = this.f24022a;
        imageDialogModel.defaultClickListener = this.f24023b;
        setAdapter(new ImageDialogAdapter(imageDialogModel));
    }

    public void setButtonText(String str) {
        this.f24022a.buttonText = str;
    }

    public void setImage(int i) {
        this.f24022a.imageId = i;
    }

    public void setMessage(int i) {
        this.f24022a.messageId = i;
    }

    public void setMessageTemp(String str) {
        this.f24022a.messageTemp = str;
    }

    public void setTitleMessage(int i) {
        this.f24022a.titleTextId = i;
    }

    public void setButtonText(int i) {
        this.f24022a.buttonTextId = i;
    }

    public void setImage(Drawable drawable) {
        this.f24022a.imageDrawable = drawable;
    }

    public void setMessage(String str) {
        this.f24022a.message = str;
    }

    public void setMessageTemp(int i) {
        this.f24022a.messageTempId = i;
    }

    public void setTitleMessage(String str) {
        this.f24022a.titleText = str;
    }

    public PromptImageDialog(Context context, int i) {
        super(context, i);
        this.f24022a = new ImageDialogModel();
        this.f24023b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptImageDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptImageDialog.this.dismiss();
            }
        };
        a();
    }
}
