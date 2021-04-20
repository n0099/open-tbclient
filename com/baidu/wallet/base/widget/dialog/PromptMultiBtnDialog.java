package com.baidu.wallet.base.widget.dialog;

import android.content.Context;
import android.view.View;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;
import com.baidu.wallet.base.widget.dialog.view.MultiBtnDialogAdapter;
/* loaded from: classes5.dex */
public class PromptMultiBtnDialog extends WalletDialog {

    /* renamed from: a  reason: collision with root package name */
    public MultiBtnDialogModel f23711a;

    /* renamed from: b  reason: collision with root package name */
    public View.OnClickListener f23712b;

    public PromptMultiBtnDialog(Context context) {
        super(context, ResUtils.style(context, "EbpayPromptDialog"));
        this.f23711a = new MultiBtnDialogModel();
        this.f23712b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }

    private void a() {
        MultiBtnDialogModel multiBtnDialogModel = this.f23711a;
        multiBtnDialogModel.defaultClickListener = this.f23712b;
        setAdapter(new MultiBtnDialogAdapter(multiBtnDialogModel));
    }

    public void setFirstBtn(int i, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23711a;
        multiBtnDialogModel.firstBtnTextId = i;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setFirstBtnTextBold() {
        this.f23711a.firstBtnTextBold = true;
    }

    public void setMessage(int i) {
        this.f23711a.messageId = i;
    }

    public void setSecondBtn(int i, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23711a;
        multiBtnDialogModel.secondBtnTextId = i;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setSecondBtnTextBold() {
        this.f23711a.secondBtnTextBold = true;
    }

    public void setThirdBtn(int i, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23711a;
        multiBtnDialogModel.thirdBtnTextId = i;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public void setThirdBtnTextBold() {
        this.f23711a.thirdBtnTextBold = true;
    }

    public void setTitleMessage(int i) {
        this.f23711a.titleId = i;
    }

    public void setMessage(CharSequence charSequence) {
        this.f23711a.message = charSequence;
    }

    public void setTitleMessage(String str) {
        this.f23711a.titleText = str;
    }

    public void setFirstBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23711a;
        multiBtnDialogModel.firstBtnText = str;
        multiBtnDialogModel.firstBtnClickListener = onClickListener;
    }

    public void setSecondBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23711a;
        multiBtnDialogModel.secondBtnText = str;
        multiBtnDialogModel.secondBtnClickListener = onClickListener;
    }

    public void setThirdBtn(String str, View.OnClickListener onClickListener) {
        MultiBtnDialogModel multiBtnDialogModel = this.f23711a;
        multiBtnDialogModel.thirdBtnText = str;
        multiBtnDialogModel.thirdBtnClickListener = onClickListener;
    }

    public PromptMultiBtnDialog(Context context, int i) {
        super(context, i);
        this.f23711a = new MultiBtnDialogModel();
        this.f23712b = new View.OnClickListener() { // from class: com.baidu.wallet.base.widget.dialog.PromptMultiBtnDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PromptMultiBtnDialog.this.dismiss();
            }
        };
        a();
    }
}
