package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;
import com.baidu.wallet.base.widget.dialog.view.MultiBtnDialogAdapter;
/* loaded from: classes5.dex */
public class PromptMultiBtnDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public MultiBtnDialogModel f23631a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f23632b;

    public PromptMultiBtnDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23631a = new MultiBtnDialogModel();
        this.f23632b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        MultiBtnDialogModel multiBtnDialogModel = this.f23631a;
        multiBtnDialogModel.defaultClickListener = this.f23632b;
        setAdapter(new MultiBtnDialogAdapter(multiBtnDialogModel));
    }

    public void setFirstBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23631a;
        multiBtnDialogModel.firstBtnTextId = i2;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setFirstBtnTextBold() {
        this.f23631a.firstBtnTextBold = true;
    }

    public void setMessage(int i2) {
        this.f23631a.messageId = i2;
    }

    public void setSecondBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23631a;
        multiBtnDialogModel.secondBtnTextId = i2;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setSecondBtnTextBold() {
        this.f23631a.secondBtnTextBold = true;
    }

    public void setThirdBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23631a;
        multiBtnDialogModel.thirdBtnTextId = i2;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public void setThirdBtnTextBold() {
        this.f23631a.thirdBtnTextBold = true;
    }

    public void setTitleMessage(int i2) {
        this.f23631a.titleId = i2;
    }

    public void setMessage(CharSequence charSequence) {
        this.f23631a.message = charSequence;
    }

    public void setTitleMessage(String str) {
        this.f23631a.titleText = str;
    }

    public void setFirstBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23631a;
        multiBtnDialogModel.firstBtnText = str;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setSecondBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23631a;
        multiBtnDialogModel.secondBtnText = str;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setThirdBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23631a;
        multiBtnDialogModel.thirdBtnText = str;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public PromptMultiBtnDialog(Context context, int i2) {
        super(context, i2);
        this.f23631a = new MultiBtnDialogModel();
        this.f23632b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }
}
