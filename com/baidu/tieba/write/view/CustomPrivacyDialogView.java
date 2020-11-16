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
    private EMTextView nLF;
    private TBSpecificationBtn nLG;
    private TBSpecificationBtn nLH;

    public CustomPrivacyDialogView(Context context) {
        this(context, null);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomPrivacyDialogView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        dQ(context);
    }

    private void dQ(Context context) {
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        setOrientation(1);
        setGravity(1);
        setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimension(R.dimen.tbds31));
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0211));
        setBackgroundDrawable(gradientDrawable);
        inflate(context, R.layout.custom_privacy_dialog_view, this);
        this.nLF = (EMTextView) findViewById(R.id.privacy_message);
        this.nLG = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_cancel_button);
        this.nLH = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_confirm_button);
        this.nLG.setTextSize(R.dimen.tbds34);
        c cVar = new c();
        cVar.qI(R.color.CAM_X0105);
        this.nLG.setConfig(cVar);
        this.nLH.setTextSize(R.dimen.tbds34);
        c cVar2 = new c();
        cVar2.qG(R.color.CAM_X0302);
        this.nLH.setConfig(cVar2);
    }

    public void setMessageTextViewColor(int i) {
        if (this.nLF != null) {
            this.nLF.setTextColor(i);
        }
    }

    public void setMessageTextViewMessage(String str) {
        if (this.nLF != null) {
            this.nLF.setText(str);
        }
    }

    public void setPrivacyDialogCancelButtonListener(View.OnClickListener onClickListener) {
        if (this.nLG != null) {
            this.nLG.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogConfirmButtonListener(View.OnClickListener onClickListener) {
        if (this.nLH != null) {
            this.nLH.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogCancelButtonText(String str) {
        if (this.nLG != null) {
            this.nLG.setText(str);
        }
    }

    public void setPrivacyDialogConfirmButtonText(String str) {
        if (this.nLH != null) {
            this.nLH.setText(str);
        }
    }
}
