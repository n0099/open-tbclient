package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.ImageDialogModel;
/* loaded from: classes5.dex */
public class ImageDialogBinding extends BaseBinding<ImageDialogModel> {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23718a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23719b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23720c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f23721d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23722e;

    public ImageDialogBinding(View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip_1"));
        this.f23722e = textView;
        textView.setVisibility(8);
        this.f23718a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip"));
        this.f23719b = (ImageView) view.findViewById(ResUtils.id(this.context, "dialog_image"));
        this.f23720c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f23721d = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        T t = this.viewModel;
        if (((ImageDialogModel) t).messageId != 0) {
            this.f23718a.setText(((ImageDialogModel) t).messageId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t).message)) {
            this.f23718a.setText(((ImageDialogModel) this.viewModel).message);
        }
        T t2 = this.viewModel;
        if (((ImageDialogModel) t2).messageTempId != 0) {
            this.f23722e.setVisibility(0);
            this.f23722e.setText(((ImageDialogModel) this.viewModel).messageTempId);
        } else if (((ImageDialogModel) t2).messageTemp != null) {
            this.f23722e.setVisibility(0);
            this.f23722e.setText(((ImageDialogModel) this.viewModel).messageTemp);
        }
        T t3 = this.viewModel;
        if (((ImageDialogModel) t3).buttonTextId != 0) {
            this.f23721d.setText(((ImageDialogModel) t3).buttonTextId);
        } else if (((ImageDialogModel) t3).buttonText != null) {
            this.f23721d.setText(((ImageDialogModel) t3).buttonText);
        }
        T t4 = this.viewModel;
        if (((ImageDialogModel) t4).imageId != 0) {
            this.f23719b.setImageResource(((ImageDialogModel) t4).imageId);
        } else if (((ImageDialogModel) t4).imageDrawable != null) {
            this.f23719b.setImageDrawable(((ImageDialogModel) t4).imageDrawable);
        }
        T t5 = this.viewModel;
        if (((ImageDialogModel) t5).titleTextId != 0) {
            this.f23720c.setText(((ImageDialogModel) t5).titleTextId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t5).titleText)) {
            this.f23720c.setText(((ImageDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.f23721d.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.f23721d.setOnClickListener(((ImageDialogModel) this.viewModel).defaultClickListener);
    }
}
