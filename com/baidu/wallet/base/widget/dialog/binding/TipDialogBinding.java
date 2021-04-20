package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.TipDialogModel;
/* loaded from: classes5.dex */
public class TipDialogBinding extends BaseBinding<TipDialogModel> {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f23738a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f23739b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f23740c;

    public TipDialogBinding(View view) {
        super(view);
        this.f23738a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f23739b = (Button) view.findViewById(ResUtils.id(this.context, "positive_btn"));
        this.f23740c = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        T t = this.viewModel;
        if (((TipDialogModel) t).btnTextId != 0) {
            this.f23739b.setText(((TipDialogModel) t).btnTextId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t).btnText)) {
            this.f23739b.setText(((TipDialogModel) this.viewModel).btnText);
        }
        T t2 = this.viewModel;
        if (((TipDialogModel) t2).titleId != 0) {
            this.f23738a.setText(((TipDialogModel) t2).titleId);
        } else if (!TextUtils.isEmpty(((TipDialogModel) t2).titleText)) {
            this.f23738a.setText(((TipDialogModel) this.viewModel).titleText);
        }
        TextPaint paint = this.f23739b.getPaint();
        if (paint != null) {
            paint.setFakeBoldText(true);
        }
        this.f23739b.setOnClickListener(((TipDialogModel) this.viewModel).defaultClickListener);
        T t3 = this.viewModel;
        if (((TipDialogModel) t3).messageId != 0) {
            this.f23740c.setText(((TipDialogModel) t3).messageId);
        } else if (TextUtils.isEmpty(((TipDialogModel) t3).message)) {
        } else {
            this.f23740c.setText(((TipDialogModel) this.viewModel).message);
        }
    }
}
