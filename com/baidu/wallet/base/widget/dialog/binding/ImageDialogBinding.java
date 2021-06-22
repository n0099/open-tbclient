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
    public final TextView f23832a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23833b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23834c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f23835d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23836e;

    public ImageDialogBinding(View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip_1"));
        this.f23836e = textView;
        textView.setVisibility(8);
        this.f23832a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip"));
        this.f23833b = (ImageView) view.findViewById(ResUtils.id(this.context, "dialog_image"));
        this.f23834c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f23835d = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        T t = this.viewModel;
        if (((ImageDialogModel) t).messageId != 0) {
            this.f23832a.setText(((ImageDialogModel) t).messageId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t).message)) {
            this.f23832a.setText(((ImageDialogModel) this.viewModel).message);
        }
        T t2 = this.viewModel;
        if (((ImageDialogModel) t2).messageTempId != 0) {
            this.f23836e.setVisibility(0);
            this.f23836e.setText(((ImageDialogModel) this.viewModel).messageTempId);
        } else if (((ImageDialogModel) t2).messageTemp != null) {
            this.f23836e.setVisibility(0);
            this.f23836e.setText(((ImageDialogModel) this.viewModel).messageTemp);
        }
        T t3 = this.viewModel;
        if (((ImageDialogModel) t3).buttonTextId != 0) {
            this.f23835d.setText(((ImageDialogModel) t3).buttonTextId);
        } else if (((ImageDialogModel) t3).buttonText != null) {
            this.f23835d.setText(((ImageDialogModel) t3).buttonText);
        }
        T t4 = this.viewModel;
        if (((ImageDialogModel) t4).imageId != 0) {
            this.f23833b.setImageResource(((ImageDialogModel) t4).imageId);
        } else if (((ImageDialogModel) t4).imageDrawable != null) {
            this.f23833b.setImageDrawable(((ImageDialogModel) t4).imageDrawable);
        }
        T t5 = this.viewModel;
        if (((ImageDialogModel) t5).titleTextId != 0) {
            this.f23834c.setText(((ImageDialogModel) t5).titleTextId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t5).titleText)) {
            this.f23834c.setText(((ImageDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.f23835d.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.f23835d.setOnClickListener(((ImageDialogModel) this.viewModel).defaultClickListener);
    }
}
