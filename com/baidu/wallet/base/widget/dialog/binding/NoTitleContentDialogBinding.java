package com.baidu.wallet.base.widget.dialog.binding;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.BaseDialogModel;
import com.baidu.wallet.base.widget.dialog.model.ContentDialogModel;
/* loaded from: classes5.dex */
public class NoTitleContentDialogBinding extends BaseBinding<BaseDialogModel> {

    /* renamed from: a  reason: collision with root package name */
    public TextView f23745a;
    public View btnLayouts;
    public View btnLine;
    public Button negativeButton;
    public Button positiveButton;

    public NoTitleContentDialogBinding(View view) {
        super(view);
        this.rootView = view;
        Context context = view.getContext();
        this.context = context;
        this.f23745a = (TextView) view.findViewById(ResUtils.id(context, "dialog_text_content"));
        this.negativeButton = (Button) view.findViewById(ResUtils.id(this.context, "negative_btn"));
        this.positiveButton = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
        this.btnLayouts = view.findViewById(ResUtils.id(this.context, "dialog_btns"));
        this.btnLine = view.findViewById(ResUtils.id(this.context, "btn_line"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        ContentDialogModel contentDialogModel = (ContentDialogModel) getViewModel();
        int i = 8;
        if (contentDialogModel.hideMessage) {
            this.f23745a.setVisibility(8);
            return;
        }
        int i2 = contentDialogModel.messageId;
        if (i2 != 0) {
            this.f23745a.setText(i2);
        } else if (!TextUtils.isEmpty(contentDialogModel.message)) {
            this.f23745a.setText(contentDialogModel.message);
        }
        this.f23745a.setMovementMethod(LinkMovementMethod.getInstance());
        int i3 = contentDialogModel.messageColor;
        if (i3 != 0) {
            this.f23745a.setTextColor(i3);
        }
        int i4 = contentDialogModel.backgroundColor;
        if (i4 != 0) {
            this.f23745a.setBackgroundColor(i4);
        }
        int i5 = contentDialogModel.messageSize;
        if (i5 != 0) {
            this.f23745a.setTextSize(i5);
        }
        int i6 = contentDialogModel.dialogBackgound;
        if (i6 != 0) {
            this.rootView.setBackgroundColor(i6);
        }
        int i7 = contentDialogModel.positiveBtnTextId;
        if (i7 != 0) {
            this.positiveButton.setText(i7);
        } else if (!TextUtils.isEmpty(contentDialogModel.positiveBtnText)) {
            this.positiveButton.setText(contentDialogModel.positiveBtnText);
        }
        int i8 = contentDialogModel.positiveBtnTextColor;
        if (i8 != 0) {
            this.positiveButton.setTextColor(i8);
        }
        int i9 = contentDialogModel.positiveBtnTextSize;
        if (i9 != 0) {
            this.positiveButton.setTextSize(i9);
        }
        int i10 = contentDialogModel.negativeBtnTextId;
        if (i10 != 0) {
            this.negativeButton.setText(i10);
        } else if (!TextUtils.isEmpty(contentDialogModel.negativeBtnText)) {
            this.negativeButton.setText(contentDialogModel.negativeBtnText);
        }
        int i11 = contentDialogModel.negativeBtnTextColor;
        if (i11 != 0) {
            this.positiveButton.setTextColor(i11);
        }
        int i12 = contentDialogModel.negativeBtnTextSize;
        if (i12 != 0) {
            this.positiveButton.setTextSize(i12);
        }
        this.positiveButton.setOnClickListener(contentDialogModel.defaultListener);
        this.negativeButton.setOnClickListener(contentDialogModel.defaultListener);
        View.OnClickListener onClickListener = contentDialogModel.positiveBtnClickListener;
        if (onClickListener != null) {
            this.positiveButton.setOnClickListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = contentDialogModel.negativeBtnClickListener;
        if (onClickListener2 != null) {
            this.negativeButton.setOnClickListener(onClickListener2);
        }
        this.btnLayouts.setVisibility(contentDialogModel.hideButtons ? 8 : 0);
        this.positiveButton.setVisibility(contentDialogModel.hidePositiveBtn ? 8 : 0);
        this.negativeButton.setVisibility(contentDialogModel.hideNegativeBtn ? 8 : 0);
        TextPaint paint = this.positiveButton.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        if (contentDialogModel.hidePositiveBtn) {
            TextPaint paint2 = this.negativeButton.getPaint();
            if (paint2 != null) {
                paint2.setFakeBoldText(true);
            }
            Button button = this.negativeButton;
            button.setBackgroundDrawable(ResUtils.getDrawable(button.getContext(), "wallet_base_dialog_btn_selector"));
        } else if (contentDialogModel.hideNegativeBtn) {
            Button button2 = this.positiveButton;
            button2.setBackgroundDrawable(ResUtils.getDrawable(button2.getContext(), "wallet_base_dialog_btn_selector"));
        }
        View view = this.btnLine;
        if (!contentDialogModel.hideNegativeBtn && !contentDialogModel.hidePositiveBtn) {
            i = 0;
        }
        view.setVisibility(i);
    }
}
