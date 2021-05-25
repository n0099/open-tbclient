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
    public final TextView f23647a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23648b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23649c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f23650d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f23651e;

    public ImageDialogBinding(View view) {
        super(view);
        TextView textView = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip_1"));
        this.f23651e = textView;
        textView.setVisibility(8);
        this.f23647a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_image_tip"));
        this.f23648b = (ImageView) view.findViewById(ResUtils.id(this.context, "dialog_image"));
        this.f23649c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f23650d = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        T t = this.viewModel;
        if (((ImageDialogModel) t).messageId != 0) {
            this.f23647a.setText(((ImageDialogModel) t).messageId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t).message)) {
            this.f23647a.setText(((ImageDialogModel) this.viewModel).message);
        }
        T t2 = this.viewModel;
        if (((ImageDialogModel) t2).messageTempId != 0) {
            this.f23651e.setVisibility(0);
            this.f23651e.setText(((ImageDialogModel) this.viewModel).messageTempId);
        } else if (((ImageDialogModel) t2).messageTemp != null) {
            this.f23651e.setVisibility(0);
            this.f23651e.setText(((ImageDialogModel) this.viewModel).messageTemp);
        }
        T t3 = this.viewModel;
        if (((ImageDialogModel) t3).buttonTextId != 0) {
            this.f23650d.setText(((ImageDialogModel) t3).buttonTextId);
        } else if (((ImageDialogModel) t3).buttonText != null) {
            this.f23650d.setText(((ImageDialogModel) t3).buttonText);
        }
        T t4 = this.viewModel;
        if (((ImageDialogModel) t4).imageId != 0) {
            this.f23648b.setImageResource(((ImageDialogModel) t4).imageId);
        } else if (((ImageDialogModel) t4).imageDrawable != null) {
            this.f23648b.setImageDrawable(((ImageDialogModel) t4).imageDrawable);
        }
        T t5 = this.viewModel;
        if (((ImageDialogModel) t5).titleTextId != 0) {
            this.f23649c.setText(((ImageDialogModel) t5).titleTextId);
        } else if (!TextUtils.isEmpty(((ImageDialogModel) t5).titleText)) {
            this.f23649c.setText(((ImageDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.f23650d.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.f23650d.setOnClickListener(((ImageDialogModel) this.viewModel).defaultClickListener);
    }
}
