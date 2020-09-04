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
/* loaded from: classes20.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText lHe;
    private Button lHf;
    private a lHg;

    /* loaded from: classes20.dex */
    public interface a {
        void dnO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.lHe = null;
        this.lHf = null;
        this.lHg = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lHe = null;
        this.lHf = null;
        this.lHg = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lHe = null;
        this.lHf = null;
        this.lHg = null;
        init();
    }

    private void init() {
        dnX();
        dnY();
    }

    private void dnX() {
        this.lHf = new Button(this.mContext);
        this.lHf.setId(1);
        this.lHf.setTextColor(this.lGQ);
        this.lHf.setTextSize(0, this.bZG);
        this.lHf.setBackgroundColor(this.lGS);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.lGJ);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lHf, layoutParams);
        this.lHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.lHg != null) {
                    VerificationCodeView.this.lHg.dnO();
                }
            }
        });
    }

    private void dnY() {
        this.lHe = new EditText(this.mContext);
        this.lHe.setTextColor(this.lGM);
        this.lHe.setHintTextColor(this.lGN);
        this.lHe.setTextSize(0, this.bZG);
        this.lHe.setGravity(19);
        int paddingBottom = this.lHe.getPaddingBottom();
        this.lHe.setPadding(this.lGG, this.lHe.getPaddingTop(), this.lHe.getPaddingRight(), paddingBottom);
        this.lHe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dnL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.lHe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.lHe, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lGJ);
        layoutParams.addRule(0, this.lHf.getId());
        layoutParams.addRule(15);
        a(this.lHe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lHe, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.lEa)) {
                this.lHf.setText(hVar.lEa);
                this.lHf.setTextSize(0, this.bZG);
                this.lHf.getLayoutParams().height = this.lGJ;
                this.lHf.setPadding(this.lGG, 0, this.lGG, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.lHe.setHint(hVar.content);
                this.lHe.setTextSize(0, this.bZG);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lHe.getLayoutParams();
                marginLayoutParams.height = this.lGJ;
                marginLayoutParams.rightMargin = this.lGG;
                this.lHe.setPadding(this.lGG, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lHe.setText("");
    }

    public void setListener(a aVar) {
        this.lHg = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dnL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
