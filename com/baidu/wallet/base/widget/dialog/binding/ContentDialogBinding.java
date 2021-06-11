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
    public final TextView f23749a;

    public ContentDialogBinding(View view) {
        super(view);
        this.f23749a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseDialogBinding, com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        super.executeBindings();
        ContentDialogModel contentDialogModel = (ContentDialogModel) getViewModel();
        if (contentDialogModel.hideMessage) {
            this.f23749a.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.titleText.getLayoutParams();
            layoutParams.bottomMargin += ((LinearLayout.LayoutParams) this.f23749a.getLayoutParams()).bottomMargin;
            this.titleText.setLayoutParams(layoutParams);
            return;
        }
        int i2 = contentDialogModel.messageId;
        if (i2 != 0) {
            this.f23749a.setText(i2);
        } else if (!TextUtils.isEmpty(contentDialogModel.message)) {
            this.f23749a.setText(contentDialogModel.message);
        }
        this.f23749a.setMovementMethod(LinkMovementMethod.getInstance());
        int i3 = contentDialogModel.messageColor;
        if (i3 != 0) {
            this.f23749a.setTextColor(i3);
        }
        int i4 = contentDialogModel.backgroundColor;
        if (i4 != 0) {
            this.f23749a.setBackgroundColor(i4);
        }
        int i5 = contentDialogModel.messageSize;
        if (i5 != 0) {
            this.f23749a.setTextSize(i5);
        }
    }
}
