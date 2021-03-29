package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.b.h0.r.f0.m.c;
/* loaded from: classes5.dex */
public class CustomPrivacyDialogView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public EMTextView f22359e;

    /* renamed from: f  reason: collision with root package name */
    public TBSpecificationBtn f22360f;

    /* renamed from: g  reason: collision with root package name */
    public TBSpecificationBtn f22361g;

    public CustomPrivacyDialogView(Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        LinearLayout.inflate(context, R.layout.custom_privacy_dialog_view, this);
        this.f22359e = (EMTextView) findViewById(R.id.privacy_message);
        this.f22360f = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_cancel_button);
        this.f22361g = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_confirm_button);
        this.f22360f.setTextSize(R.dimen.tbds34);
        c cVar = new c();
        cVar.q(R.color.CAM_X0105);
        this.f22360f.setConfig(cVar);
        this.f22361g.setTextSize(R.dimen.tbds34);
        c cVar2 = new c();
        cVar2.o(R.color.CAM_X0302);
        this.f22361g.setConfig(cVar2);
    }

    public void setMessageTextViewColor(int i) {
        EMTextView eMTextView = this.f22359e;
        if (eMTextView != null) {
            eMTextView.setTextColor(i);
        }
    }

    public void setMessageTextViewMessage(String str) {
        EMTextView eMTextView = this.f22359e;
        if (eMTextView != null) {
            eMTextView.setText(str);
        }
    }

    public void setPrivacyDialogCancelButtonListener(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn = this.f22360f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogCancelButtonText(String str) {
        TBSpecificationBtn tBSpecificationBtn = this.f22360f;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setText(str);
        }
    }

    public void setPrivacyDialogConfirmButtonListener(View.OnClickListener onClickListener) {
        TBSpecificationBtn tBSpecificationBtn = this.f22361g;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogConfirmButtonText(String str) {
        TBSpecificationBtn tBSpecificationBtn = this.f22361g;
        if (tBSpecificationBtn != null) {
            tBSpecificationBtn.setText(str);
        }
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }
}
