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
    private EditText iKD;
    private Button iKE;
    private a iKF;

    /* loaded from: classes3.dex */
    public interface a {
        void cih();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iKD = null;
        this.iKE = null;
        this.iKF = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iKD = null;
        this.iKE = null;
        this.iKF = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iKD = null;
        this.iKE = null;
        this.iKF = null;
        init();
    }

    private void init() {
        cir();
        cis();
    }

    private void cir() {
        this.iKE = new Button(this.mContext);
        this.iKE.setId(1);
        this.iKE.setTextColor(this.iKp);
        this.iKE.setTextSize(0, this.amF);
        this.iKE.setBackgroundColor(this.iKr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iKi);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iKE, layoutParams);
        this.iKE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iKF != null) {
                    VerificationCodeView.this.iKF.cih();
                }
            }
        });
    }

    private void cis() {
        this.iKD = new EditText(this.mContext);
        this.iKD.setTextColor(this.iKl);
        this.iKD.setHintTextColor(this.iKm);
        this.iKD.setTextSize(0, this.amF);
        this.iKD.setGravity(19);
        int paddingBottom = this.iKD.getPaddingBottom();
        this.iKD.setPadding(this.iKf, this.iKD.getPaddingTop(), this.iKD.getPaddingRight(), paddingBottom);
        this.iKD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cie()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iKD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iKD, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iKi);
        layoutParams.addRule(0, this.iKE.getId());
        layoutParams.addRule(15);
        a(this.iKD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iKD, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iHj)) {
                this.iKE.setText(hVar.iHj);
                this.iKE.setTextSize(0, this.amF);
                this.iKE.getLayoutParams().height = this.iKi;
                this.iKE.setPadding(this.iKf, 0, this.iKf, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iKD.setHint(hVar.content);
                this.iKD.setTextSize(0, this.amF);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iKD.getLayoutParams();
                marginLayoutParams.height = this.iKi;
                marginLayoutParams.rightMargin = this.iKf;
                this.iKD.setPadding(this.iKf, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iKD.setText("");
    }

    public void setListener(a aVar) {
        this.iKF = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cie() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
