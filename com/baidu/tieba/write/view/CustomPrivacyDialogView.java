package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CustomPrivacyDialogView extends LinearLayout {
    private TextView ncm;
    private TBSpecificationBtn ncn;
    private TBSpecificationBtn nco;

    public CustomPrivacyDialogView(Context context) {
        this(context, null);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dK(context);
    }

    private void dK(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_k));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_privacy_dialog_view, this);
        this.ncm = (TextView) findViewById(R.id.privacy_message);
        this.ncn = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_cancel_button);
        this.nco = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_confirm_button);
        this.ncn.setTextSize(R.dimen.tbds34);
        c cVar = new c();
        cVar.pr(R.color.cp_cont_b);
        this.ncn.setConfig(cVar);
        this.nco.setTextSize(R.dimen.tbds34);
        c cVar2 = new c();
        cVar2.pp(R.color.cp_link_tip_a);
        this.nco.setConfig(cVar2);
    }

    public void setMessageTextViewColor(int i) {
        if (this.ncm != null) {
            this.ncm.setTextColor(i);
        }
    }

    public void setMessageTextViewMessage(String str) {
        if (this.ncm != null) {
            this.ncm.setText(str);
        }
    }

    public void setPrivacyDialogCancelButtonListener(View.OnClickListener onClickListener) {
        if (this.ncn != null) {
            this.ncn.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogConfirmButtonListener(View.OnClickListener onClickListener) {
        if (this.nco != null) {
            this.nco.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogCancelButtonText(String str) {
        if (this.ncn != null) {
            this.ncn.setText(str);
        }
    }

    public void setPrivacyDialogConfirmButtonText(String str) {
        if (this.nco != null) {
            this.nco.setText(str);
        }
    }
}
