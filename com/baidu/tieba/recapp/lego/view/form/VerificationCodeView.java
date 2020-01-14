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
/* loaded from: classes11.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText jKa;
    private Button jKb;
    private a jKc;

    /* loaded from: classes11.dex */
    public interface a {
        void cBC();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.jKa = null;
        this.jKb = null;
        this.jKc = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jKa = null;
        this.jKb = null;
        this.jKc = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jKa = null;
        this.jKb = null;
        this.jKc = null;
        init();
    }

    private void init() {
        cBK();
        cBL();
    }

    private void cBK() {
        this.jKb = new Button(this.mContext);
        this.jKb.setId(1);
        this.jKb.setTextColor(this.jJM);
        this.jKb.setTextSize(0, this.bcC);
        this.jKb.setBackgroundColor(this.jJO);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.jJF);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jKb, layoutParams);
        this.jKb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.jKc != null) {
                    VerificationCodeView.this.jKc.cBC();
                }
            }
        });
    }

    private void cBL() {
        this.jKa = new EditText(this.mContext);
        this.jKa.setTextColor(this.jJI);
        this.jKa.setHintTextColor(this.jJJ);
        this.jKa.setTextSize(0, this.bcC);
        this.jKa.setGravity(19);
        int paddingBottom = this.jKa.getPaddingBottom();
        this.jKa.setPadding(this.jJC, this.jKa.getPaddingTop(), this.jKa.getPaddingRight(), paddingBottom);
        this.jKa.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cBz()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.jKa, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.jKa, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jJF);
        layoutParams.addRule(0, this.jKb.getId());
        layoutParams.addRule(15);
        a(this.jKa, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jKa, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.jGH)) {
                this.jKb.setText(hVar.jGH);
                this.jKb.setTextSize(0, this.bcC);
                this.jKb.getLayoutParams().height = this.jJF;
                this.jKb.setPadding(this.jJC, 0, this.jJC, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.jKa.setHint(hVar.content);
                this.jKa.setTextSize(0, this.bcC);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKa.getLayoutParams();
                marginLayoutParams.height = this.jJF;
                marginLayoutParams.rightMargin = this.jJC;
                this.jKa.setPadding(this.jJC, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jKa.setText("");
    }

    public void setListener(a aVar) {
        this.jKc = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cBz() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
