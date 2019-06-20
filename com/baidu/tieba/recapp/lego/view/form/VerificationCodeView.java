package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
/* loaded from: classes3.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText iEl;
    private Button iEm;
    private a iEn;

    /* loaded from: classes3.dex */
    public interface a {
        void cfq();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iEl = null;
        this.iEm = null;
        this.iEn = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iEl = null;
        this.iEm = null;
        this.iEn = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEl = null;
        this.iEm = null;
        this.iEn = null;
        init();
    }

    private void init() {
        cfA();
        cfB();
    }

    private void cfA() {
        this.iEm = new Button(this.mContext);
        this.iEm.setId(1);
        this.iEm.setTextColor(this.iDX);
        this.iEm.setTextSize(0, this.amc);
        this.iEm.setBackgroundColor(this.iDZ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iDQ);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iEm, layoutParams);
        this.iEm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iEn != null) {
                    VerificationCodeView.this.iEn.cfq();
                }
            }
        });
    }

    private void cfB() {
        this.iEl = new EditText(this.mContext);
        this.iEl.setTextColor(this.iDT);
        this.iEl.setHintTextColor(this.iDU);
        this.iEl.setTextSize(0, this.amc);
        this.iEl.setGravity(19);
        int paddingBottom = this.iEl.getPaddingBottom();
        this.iEl.setPadding(this.iDN, this.iEl.getPaddingTop(), this.iEl.getPaddingRight(), paddingBottom);
        this.iEl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cfn()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iEl, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iEl, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iDQ);
        layoutParams.addRule(0, this.iEm.getId());
        layoutParams.addRule(15);
        a(this.iEl, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iEl, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iAR)) {
                this.iEm.setText(hVar.iAR);
                this.iEm.setTextSize(0, this.amc);
                this.iEm.getLayoutParams().height = this.iDQ;
                this.iEm.setPadding(this.iDN, 0, this.iDN, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iEl.setHint(hVar.content);
                this.iEl.setTextSize(0, this.amc);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEl.getLayoutParams();
                marginLayoutParams.height = this.iDQ;
                marginLayoutParams.rightMargin = this.iDN;
                this.iEl.setPadding(this.iDN, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iEl.setText("");
    }

    public void setListener(a aVar) {
        this.iEn = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfn() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
