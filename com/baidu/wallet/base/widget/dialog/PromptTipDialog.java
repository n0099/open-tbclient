package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.TipDialogModel;
import com.baidu.wallet.base.widget.dialog.view.TipDialogAdapter;
/* loaded from: classes5.dex */
public class PromptTipDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public TipDialogModel f24029a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f24030b;

    public PromptTipDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f24029a = new TipDialogModel();
        this.f24030b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptTipDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        TipDialogModel tipDialogModel = this.f24029a;
        tipDialogModel.defaultClickListener = this.f24030b;
        setAdapter(new TipDialogAdapter(tipDialogModel));
    }

    public void setButtonMessage(int i) {
        this.f24029a.btnTextId = i;
    }

    public void setDefaultBtnListener(final View.OnClickListener onClickListener) {
        this.f24029a.defaultClickListener = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptTipDialog.2
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

    public void setMessage(int i) {
        this.f24029a.messageId = i;
    }

    public void setTitleMessage(int i) {
        this.f24029a.titleId = i;
    }

    public void setButtonMessage(String str) {
        this.f24029a.btnText = str;
    }

    public void setMessage(String str) {
        this.f24029a.message = str;
    }

    public void setTitleMessage(String str) {
        this.f24029a.titleText = str;
    }

    public PromptTipDialog(Context context, int i) {
        super(context, i);
        this.f24029a = new TipDialogModel();
        this.f24030b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptTipDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptTipDialog.this.dismiss();
            }
        };
        a();
    }
}
