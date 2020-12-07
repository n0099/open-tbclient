package com.baidu.tieba.write.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.c;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class CustomPrivacyDialogView extends LinearLayout {
    private EMTextView nZL;
    private TBSpecificationBtn nZM;
    private TBSpecificationBtn nZN;

    public CustomPrivacyDialogView(Context context) {
        this(context, null);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ev(context);
    }

    private void ev(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_privacy_dialog_view, this);
        this.nZL = (EMTextView) findViewById(R.id.privacy_message);
        this.nZM = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_cancel_button);
        this.nZN = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_confirm_button);
        this.nZM.setTextSize(R.dimen.tbds34);
        c cVar = new c();
        cVar.rj(R.color.CAM_X0105);
        this.nZM.setConfig(cVar);
        this.nZN.setTextSize(R.dimen.tbds34);
        c cVar2 = new c();
        cVar2.rh(R.color.CAM_X0302);
        this.nZN.setConfig(cVar2);
    }

    public void setMessageTextViewColor(int i) {
        if (this.nZL != null) {
            this.nZL.setTextColor(i);
        }
    }

    public void setMessageTextViewMessage(String str) {
        if (this.nZL != null) {
            this.nZL.setText(str);
        }
    }

    public void setPrivacyDialogCancelButtonListener(View.OnClickListener onClickListener) {
        if (this.nZM != null) {
            this.nZM.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogConfirmButtonListener(View.OnClickListener onClickListener) {
        if (this.nZN != null) {
            this.nZN.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogCancelButtonText(String str) {
        if (this.nZM != null) {
            this.nZM.setText(str);
        }
    }

    public void setPrivacyDialogConfirmButtonText(String str) {
        if (this.nZN != null) {
            this.nZN.setText(str);
        }
    }
}
