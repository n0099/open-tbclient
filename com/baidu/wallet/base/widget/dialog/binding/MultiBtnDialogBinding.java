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
    public final TextView f23652a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f23653b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f23654c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f23655d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f23656e;

    public MultiBtnDialogBinding(View view) {
        super(view);
        this.f23652a = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_title"));
        this.f23653b = (TextView) view.findViewById(ResUtils.id(this.context, "dialog_text_content"));
        this.f23654c = (Button) view.findViewById(ResUtils.id(this.context, "first_btn"));
        this.f23655d = (Button) view.findViewById(ResUtils.id(this.context, "second_btn"));
        this.f23656e = (Button) view.findViewById(ResUtils.id(this.context, "third_btn"));
    }

    @Override // com.baidu.wallet.base.widget.dialog.binding.BaseBinding
    public void executeBindings() {
        TextPaint paint;
        TextPaint paint2;
        TextPaint paint3;
        T t = this.viewModel;
        if (((MultiBtnDialogModel) t).titleId != 0) {
            this.f23652a.setText(((MultiBtnDialogModel) t).titleId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t).titleText)) {
            this.f23652a.setText(((MultiBtnDialogModel) this.viewModel).titleText);
        }
        T t2 = this.viewModel;
        if (((MultiBtnDialogModel) t2).messageId != 0) {
            this.f23653b.setText(((MultiBtnDialogModel) t2).messageId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t2).message)) {
            this.f23653b.setText(((MultiBtnDialogModel) this.viewModel).message);
        }
        this.f23654c.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f23655d.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        this.f23656e.setOnClickListener(((MultiBtnDialogModel) this.viewModel).defaultClickListener);
        T t3 = this.viewModel;
        if (((MultiBtnDialogModel) t3).firstBtnClickListener != null) {
            this.f23654c.setOnClickListener(((MultiBtnDialogModel) t3).firstBtnClickListener);
        }
        T t4 = this.viewModel;
        if (((MultiBtnDialogModel) t4).secondBtnClickListener != null) {
            this.f23655d.setOnClickListener(((MultiBtnDialogModel) t4).secondBtnClickListener);
        }
        T t5 = this.viewModel;
        if (((MultiBtnDialogModel) t5).thirdBtnClickListener != null) {
            this.f23656e.setOnClickListener(((MultiBtnDialogModel) t5).thirdBtnClickListener);
        }
        T t6 = this.viewModel;
        if (((MultiBtnDialogModel) t6).firstBtnTextId != 0) {
            this.f23654c.setText(((MultiBtnDialogModel) t6).firstBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t6).firstBtnText)) {
            this.f23654c.setText(((MultiBtnDialogModel) this.viewModel).firstBtnText);
        }
        T t7 = this.viewModel;
        if (((MultiBtnDialogModel) t7).secondBtnTextId != 0) {
            this.f23655d.setText(((MultiBtnDialogModel) t7).secondBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t7).secondBtnText)) {
            this.f23655d.setText(((MultiBtnDialogModel) this.viewModel).secondBtnText);
        }
        T t8 = this.viewModel;
        if (((MultiBtnDialogModel) t8).thirdBtnTextId != 0) {
            this.f23656e.setText(((MultiBtnDialogModel) t8).thirdBtnTextId);
        } else if (!TextUtils.isEmpty(((MultiBtnDialogModel) t8).thirdBtnText)) {
            this.f23656e.setText(((MultiBtnDialogModel) this.viewModel).thirdBtnText);
        }
        if (((MultiBtnDialogModel) this.viewModel).firstBtnTextBold && (paint3 = this.f23654c.getPaint()) != null) {
            paint3.setFakeBoldText(true);
        }
        if (((MultiBtnDialogModel) this.viewModel).secondBtnTextBold && (paint2 = this.f23655d.getPaint()) != null) {
            paint2.setFakeBoldText(true);
        }
        if (!((MultiBtnDialogModel) this.viewModel).thirdBtnTextBold || (paint = this.f23656e.getPaint()) == null) {
            return;
        }
        paint.setFakeBoldText(true);
    }
}
