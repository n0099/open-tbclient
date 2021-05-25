package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.TipDialogModel;
import com.baidu.wallet.base.widget.dialog.view.TipDialogAdapter;
/* loaded from: classes5.dex */
public class PromptTipDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public TipDialogModel f23634a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f23635b;

    public PromptTipDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23634a = new TipDialogModel();
        this.f23635b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptTipDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        TipDialogModel tipDialogModel = this.f23634a;
        tipDialogModel.defaultClickListener = this.f23635b;
        setAdapter(new TipDialogAdapter(tipDialogModel));
    }

    public void setButtonMessage(int i2) {
        this.f23634a.btnTextId = i2;
    }

    public void setDefaultBtnListener(final View.OnClickListener onClickListener) {
        this.f23634a.defaultClickListener = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptTipDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptTipDialog.this.dismiss();
                View.OnClickListener onClickListener2 = onClickListener;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
            }
        };
    }

    public void setMessage(int i2) {
        this.f23634a.messageId = i2;
    }

    public void setTitleMessage(int i2) {
        this.f23634a.titleId = i2;
    }

    public void setButtonMessage(String str) {
        this.f23634a.btnText = str;
    }

    public void setMessage(String str) {
        this.f23634a.message = str;
    }

    public void setTitleMessage(String str) {
        this.f23634a.titleText = str;
    }

    public PromptTipDialog(Context context, int i2) {
        super(context, i2);
        this.f23634a = new TipDialogModel();
        this.f23635b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptTipDialog.this.dismiss();
            }
        };
        a();
    }
}
