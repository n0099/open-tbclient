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
/* loaded from: classes26.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText mrO;
    private Button mrP;
    private a mrQ;

    /* loaded from: classes26.dex */
    public interface a {
        void dyp();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mrO = null;
        this.mrP = null;
        this.mrQ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mrO = null;
        this.mrP = null;
        this.mrQ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mrO = null;
        this.mrP = null;
        this.mrQ = null;
        init();
    }

    private void init() {
        dyy();
        dyz();
    }

    private void dyy() {
        this.mrP = new Button(this.mContext);
        this.mrP.setId(1);
        this.mrP.setTextColor(this.mrA);
        this.mrP.setTextSize(0, this.cwA);
        this.mrP.setBackgroundColor(this.mrC);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mrt);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mrP, layoutParams);
        this.mrP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mrQ != null) {
                    VerificationCodeView.this.mrQ.dyp();
                }
            }
        });
    }

    private void dyz() {
        this.mrO = new EditText(this.mContext);
        this.mrO.setTextColor(this.mrw);
        this.mrO.setHintTextColor(this.mrx);
        this.mrO.setTextSize(0, this.cwA);
        this.mrO.setGravity(19);
        int paddingBottom = this.mrO.getPaddingBottom();
        this.mrO.setPadding(this.mrq, this.mrO.getPaddingTop(), this.mrO.getPaddingRight(), paddingBottom);
        this.mrO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dym()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mrO, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mrO, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mrt);
        layoutParams.addRule(0, this.mrP.getId());
        layoutParams.addRule(15);
        a(this.mrO, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mrO, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.moK)) {
                this.mrP.setText(hVar.moK);
                this.mrP.setTextSize(0, this.cwA);
                this.mrP.getLayoutParams().height = this.mrt;
                this.mrP.setPadding(this.mrq, 0, this.mrq, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mrO.setHint(hVar.content);
                this.mrO.setTextSize(0, this.cwA);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mrO.getLayoutParams();
                marginLayoutParams.height = this.mrt;
                marginLayoutParams.rightMargin = this.mrq;
                this.mrO.setPadding(this.mrq, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mrO.setText("");
    }

    public void setListener(a aVar) {
        this.mrQ = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dym() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
