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
    private EMTextView oia;
    private TBSpecificationBtn oib;
    private TBSpecificationBtn oic;

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
        this.oia = (EMTextView) findViewById(R.id.privacy_message);
        this.oib = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_cancel_button);
        this.oic = (TBSpecificationBtn) findViewById(R.id.custom_privacy_dialog_confirm_button);
        this.oib.setTextSize(R.dimen.tbds34);
        c cVar = new c();
        cVar.pT(R.color.CAM_X0105);
        this.oib.setConfig(cVar);
        this.oic.setTextSize(R.dimen.tbds34);
        c cVar2 = new c();
        cVar2.pR(R.color.CAM_X0302);
        this.oic.setConfig(cVar2);
    }

    public void setMessageTextViewColor(int i) {
        if (this.oia != null) {
            this.oia.setTextColor(i);
        }
    }

    public void setMessageTextViewMessage(String str) {
        if (this.oia != null) {
            this.oia.setText(str);
        }
    }

    public void setPrivacyDialogCancelButtonListener(View.OnClickListener onClickListener) {
        if (this.oib != null) {
            this.oib.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogConfirmButtonListener(View.OnClickListener onClickListener) {
        if (this.oic != null) {
            this.oic.setOnClickListener(onClickListener);
        }
    }

    public void setPrivacyDialogCancelButtonText(String str) {
        if (this.oib != null) {
            this.oib.setText(str);
        }
    }

    public void setPrivacyDialogConfirmButtonText(String str) {
        if (this.oic != null) {
            this.oic.setText(str);
        }
    }
}
