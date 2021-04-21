package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;
import com.baidu.wallet.base.widget.dialog.view.MultiBtnDialogAdapter;
/* loaded from: classes5.dex */
public class PromptMultiBtnDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public MultiBtnDialogModel f23719a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f23720b;

    public PromptMultiBtnDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23719a = new MultiBtnDialogModel();
        this.f23720b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        MultiBtnDialogModel multiBtnDialogModel = this.f23719a;
        multiBtnDialogModel.defaultClickListener = this.f23720b;
        setAdapter(new MultiBtnDialogAdapter(multiBtnDialogModel));
    }

    public void setFirstBtn(int i, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23719a;
        multiBtnDialogModel.firstBtnTextId = i;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setFirstBtnTextBold() {
        this.f23719a.firstBtnTextBold = true;
    }

    public void setMessage(int i) {
        this.f23719a.messageId = i;
    }

    public void setSecondBtn(int i, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23719a;
        multiBtnDialogModel.secondBtnTextId = i;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setSecondBtnTextBold() {
        this.f23719a.secondBtnTextBold = true;
    }

    public void setThirdBtn(int i, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23719a;
        multiBtnDialogModel.thirdBtnTextId = i;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public void setThirdBtnTextBold() {
        this.f23719a.thirdBtnTextBold = true;
    }

    public void setTitleMessage(int i) {
        this.f23719a.titleId = i;
    }

    public void setMessage(CharSequence charSequence) {
        this.f23719a.message = charSequence;
    }

    public void setTitleMessage(String str) {
        this.f23719a.titleText = str;
    }

    public void setFirstBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23719a;
        multiBtnDialogModel.firstBtnText = str;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setSecondBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23719a;
        multiBtnDialogModel.secondBtnText = str;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setThirdBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23719a;
        multiBtnDialogModel.thirdBtnText = str;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public PromptMultiBtnDialog(Context context, int i) {
        super(context, i);
        this.f23719a = new MultiBtnDialogModel();
        this.f23720b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }
}
