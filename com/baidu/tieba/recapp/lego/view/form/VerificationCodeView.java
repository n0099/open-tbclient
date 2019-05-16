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
    private EditText iEi;
    private Button iEj;
    private a iEk;

    /* loaded from: classes3.dex */
    public interface a {
        void cfn();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iEi = null;
        this.iEj = null;
        this.iEk = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iEi = null;
        this.iEj = null;
        this.iEk = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iEi = null;
        this.iEj = null;
        this.iEk = null;
        init();
    }

    private void init() {
        cfx();
        cfy();
    }

    private void cfx() {
        this.iEj = new Button(this.mContext);
        this.iEj.setId(1);
        this.iEj.setTextColor(this.iDU);
        this.iEj.setTextSize(0, this.amc);
        this.iEj.setBackgroundColor(this.iDW);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iDN);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iEj, layoutParams);
        this.iEj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iEk != null) {
                    VerificationCodeView.this.iEk.cfn();
                }
            }
        });
    }

    private void cfy() {
        this.iEi = new EditText(this.mContext);
        this.iEi.setTextColor(this.iDQ);
        this.iEi.setHintTextColor(this.iDR);
        this.iEi.setTextSize(0, this.amc);
        this.iEi.setGravity(19);
        int paddingBottom = this.iEi.getPaddingBottom();
        this.iEi.setPadding(this.iDK, this.iEi.getPaddingTop(), this.iEi.getPaddingRight(), paddingBottom);
        this.iEi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cfk()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iEi, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iEi, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iDN);
        layoutParams.addRule(0, this.iEj.getId());
        layoutParams.addRule(15);
        a(this.iEi, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iEi, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iAO)) {
                this.iEj.setText(hVar.iAO);
                this.iEj.setTextSize(0, this.amc);
                this.iEj.getLayoutParams().height = this.iDN;
                this.iEj.setPadding(this.iDK, 0, this.iDK, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iEi.setHint(hVar.content);
                this.iEi.setTextSize(0, this.amc);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEi.getLayoutParams();
                marginLayoutParams.height = this.iDN;
                marginLayoutParams.rightMargin = this.iDK;
                this.iEi.setPadding(this.iDK, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iEi.setText("");
    }

    public void setListener(a aVar) {
        this.iEk = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
