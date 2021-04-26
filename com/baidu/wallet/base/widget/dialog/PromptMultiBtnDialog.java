package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;
import com.baidu.wallet.base.widget.dialog.view.MultiBtnDialogAdapter;
/* loaded from: classes5.dex */
public class PromptMultiBtnDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public MultiBtnDialogModel f24457a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f24458b;

    public PromptMultiBtnDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f24457a = new MultiBtnDialogModel();
        this.f24458b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        MultiBtnDialogModel multiBtnDialogModel = this.f24457a;
        multiBtnDialogModel.defaultClickListener = this.f24458b;
        setAdapter(new MultiBtnDialogAdapter(multiBtnDialogModel));
    }

    public void setFirstBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f24457a;
        multiBtnDialogModel.firstBtnTextId = i2;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setFirstBtnTextBold() {
        this.f24457a.firstBtnTextBold = true;
    }

    public void setMessage(int i2) {
        this.f24457a.messageId = i2;
    }

    public void setSecondBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f24457a;
        multiBtnDialogModel.secondBtnTextId = i2;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setSecondBtnTextBold() {
        this.f24457a.secondBtnTextBold = true;
    }

    public void setThirdBtn(int i2, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f24457a;
        multiBtnDialogModel.thirdBtnTextId = i2;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public void setThirdBtnTextBold() {
        this.f24457a.thirdBtnTextBold = true;
    }

    public void setTitleMessage(int i2) {
        this.f24457a.titleId = i2;
    }

    public void setMessage(CharSequence charSequence) {
        this.f24457a.message = charSequence;
    }

    public void setTitleMessage(String str) {
        this.f24457a.titleText = str;
    }

    public void setFirstBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f24457a;
        multiBtnDialogModel.firstBtnText = str;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setSecondBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f24457a;
        multiBtnDialogModel.secondBtnText = str;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setThirdBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f24457a;
        multiBtnDialogModel.thirdBtnText = str;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public PromptMultiBtnDialog(Context context, int i2) {
        super(context, i2);
        this.f24457a = new MultiBtnDialogModel();
        this.f24458b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }
}
