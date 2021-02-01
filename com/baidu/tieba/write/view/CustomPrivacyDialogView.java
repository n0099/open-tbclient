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
/* loaded from: classes8.dex */
public class CustomPrivacyDialogView extends LinearLayout {
    private EMTextView ohA;
    private TBSpecificationBtn ohB;
    private TBSpecificationBtn ohC;

    public CustomPrivacyDialogView(Context context) {
        this(context, null);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    private void initView(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_privacy_dialog_view, this);
        this.ohA = (EMTextView) findViewById(R.id.privacy_message);
        this.ohB = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_cancel_button);
        this.ohC = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_confirm_button);
        this.ohB.setTextSize(R.dimen.tbds34);
        c cVar = new c();
        cVar.pT(R.color.CAM_X0105);
        this.ohB.setConfig(cVar);
        this.ohC.setTextSize(R.dimen.tbds34);
        c cVar2 = new c();
        cVar2.pR(R.color.CAM_X0302);
        this.ohC.setConfig(cVar2);
    }

    public void setMessageTextViewColor(int i) {
        if (this.ohA != null) {
            this.ohA.setTextColor(i);
        }
    }

    public void setMessageTextViewMessage(String str) {
        if (this.ohA != null) {
            this.ohA.setText(str);
        }
    }

    public void setPrivacyDialogCancelButtonListener(View.OnClickListener onClickListener) {
        if (this.ohB != null) {
            this.ohB.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogConfirmButtonListener(View.OnClickListener onClickListener) {
        if (this.ohC != null) {
            this.ohC.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogCancelButtonText(String str) {
        if (this.ohB != null) {
            this.ohB.setText(str);
        }
    }

    public void setPrivacyDialogConfirmButtonText(String str) {
        if (this.ohC != null) {
            this.ohC.setText(str);
        }
    }
}
