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
    private EditText iEk;
    private Button iEl;
    private a iEm;

    /* loaded from: classes3.dex */
    public interface a {
        void cfp();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iEk = null;
        this.iEl = null;
        this.iEm = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iEk = null;
        this.iEl = null;
        this.iEm = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEk = null;
        this.iEl = null;
        this.iEm = null;
        init();
    }

    private void init() {
        cfz();
        cfA();
    }

    private void cfz() {
        this.iEl = new Button(this.mContext);
        this.iEl.setId(1);
        this.iEl.setTextColor(this.iDW);
        this.iEl.setTextSize(0, this.amc);
        this.iEl.setBackgroundColor(this.iDY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iDP);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iEl, layoutParams);
        this.iEl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iEm != null) {
                    VerificationCodeView.this.iEm.cfp();
                }
            }
        });
    }

    private void cfA() {
        this.iEk = new EditText(this.mContext);
        this.iEk.setTextColor(this.iDS);
        this.iEk.setHintTextColor(this.iDT);
        this.iEk.setTextSize(0, this.amc);
        this.iEk.setGravity(19);
        int paddingBottom = this.iEk.getPaddingBottom();
        this.iEk.setPadding(this.iDM, this.iEk.getPaddingTop(), this.iEk.getPaddingRight(), paddingBottom);
        this.iEk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cfm()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iEk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iEk, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iDP);
        layoutParams.addRule(0, this.iEl.getId());
        layoutParams.addRule(15);
        a(this.iEk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iEk, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iAQ)) {
                this.iEl.setText(hVar.iAQ);
                this.iEl.setTextSize(0, this.amc);
                this.iEl.getLayoutParams().height = this.iDP;
                this.iEl.setPadding(this.iDM, 0, this.iDM, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iEk.setHint(hVar.content);
                this.iEk.setTextSize(0, this.amc);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEk.getLayoutParams();
                marginLayoutParams.height = this.iDP;
                marginLayoutParams.rightMargin = this.iDM;
                this.iEk.setPadding(this.iDM, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iEk.setText("");
    }

    public void setListener(a aVar) {
        this.iEm = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfm() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
