package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
/* loaded from: classes5.dex */
public class ContentDialogBinding extends BaseDialogBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23734a;

    public ContentDialogBinding(View view) {
        super(view);
        this.f23734a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseDialogBinding, com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        super.executeBindings();
        ContentDialogModel contentDialogModel = (ContentDialogModel) getViewModel();
        if (contentDialogModel.hideMessage) {
            this.f23734a.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.titleText.getLayoutParams();
            layoutParams.bottomMargin += ((LinearLayout.LayoutParams) this.f23734a.getLayoutParams()).bottomMargin;
            this.titleText.setLayoutParams(layoutParams);
            return;
        }
        int i = contentDialogModel.messageId;
        if (i != 0) {
            this.f23734a.setText(i);
        } else if (!TextUtils.isEmpty(contentDialogModel.message)) {
            this.f23734a.setText(contentDialogModel.message);
        }
        this.f23734a.setMovementMethod(LinkMovementMethod.getInstance());
        int i2 = contentDialogModel.messageColor;
        if (i2 != 0) {
            this.f23734a.setTextColor(i2);
        }
        int i3 = contentDialogModel.backgroundColor;
        if (i3 != 0) {
            this.f23734a.setBackgroundColor(i3);
        }
        int i4 = contentDialogModel.messageSize;
        if (i4 != 0) {
            this.f23734a.setTextSize(i4);
        }
    }
}
