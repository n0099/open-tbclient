package com.baidu.wallet.base.widget.dialog.binding;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.dialog.model.MultiBtnDialogModel;
/* loaded from: classes5.dex */
public class MultiBtnDialogBinding extends BaseBinding<MultiBtnDialogModel> {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f24478a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f24479b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f24480c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f24481d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f24482e;

    public MultiBtnDialogBinding(View view) {
        super(view);
        this.f24478a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f24479b = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
        this.f24480c = (Button) view.findViewById(ResUtils.id(this.context, "first_btn"));
        this.f24481d = (Button) view.findViewById(ResUtils.id(this.context, "second_btn"));
        this.f24482e = (Button) view.findViewById(ResUtils.id(this.context, "third_btn"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        TextPaint paint3;
        T t = this.viewModel;
        if (((MultiBtnDialogModel) t).titleId != 0) {
            this.f24478a.setText(((MultiBtnDialogModel) t).titleId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t).titleText)) {
            this.f24478a.setText(((MultiBtnDialogModel) this.viewModel).titleText);
        }
        T t2 = this.viewModel;
        if (((MultiBtnDialogModel) t2).messageId != 0) {
            this.f24479b.setText(((MultiBtnDialogModel) t2).messageId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t2).message)) {
            this.f24479b.setText(((MultiBtnDialogModel) this.viewModel).message);
        }
        this.f24480c.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f24481d.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f24482e.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        T t3 = this.viewModel;
        if (((MultiBtnDialogModel) t3).firstBtnClickListener != null) {
            this.f24480c.setOnClickListener(((MultiBtnDialogModel) t3).firstBtnClickListener);
        }
        T t4 = this.viewModel;
        if (((MultiBtnDialogModel) t4).secondBtnClickListener != null) {
            this.f24481d.setOnClickListener(((MultiBtnDialogModel) t4).secondBtnClickListener);
        }
        T t5 = this.viewModel;
        if (((MultiBtnDialogModel) t5).thirdBtnClickListener != null) {
            this.f24482e.setOnClickListener(((MultiBtnDialogModel) t5).thirdBtnClickListener);
        }
        T t6 = this.viewModel;
        if (((MultiBtnDialogModel) t6).firstBtnTextId != 0) {
            this.f24480c.setText(((MultiBtnDialogModel) t6).firstBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t6).firstBtnText)) {
            this.f24480c.setText(((MultiBtnDialogModel) this.viewModel).firstBtnText);
        }
        T t7 = this.viewModel;
        if (((MultiBtnDialogModel) t7).secondBtnTextId != 0) {
            this.f24481d.setText(((MultiBtnDialogModel) t7).secondBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t7).secondBtnText)) {
            this.f24481d.setText(((MultiBtnDialogModel) this.viewModel).secondBtnText);
        }
        T t8 = this.viewModel;
        if (((MultiBtnDialogModel) t8).thirdBtnTextId != 0) {
            this.f24482e.setText(((MultiBtnDialogModel) t8).thirdBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t8).thirdBtnText)) {
            this.f24482e.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnText);
        }
        if (((MultiBtnDialogModel) this.viewModel).firstBtnTextBold && (paint3 = this.f24480c.getPaint()) != null) {
            paint3.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).secondBtnTextBold && (paint2 = this.f24481d.getPaint()) != null) {
            paint2.setFakeBoldText(true);
        }
        if (!((MultiBtnDialogModel) this.viewModel).thirdBtnTextBold || (paint = this.f24482e.getPaint()) == null) {
            return;
        }
        paint.setFakeBoldText(true);
    }
}
