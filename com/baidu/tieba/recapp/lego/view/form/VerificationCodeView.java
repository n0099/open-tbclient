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
/* loaded from: classes25.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText lPY;
    private Button lPZ;
    private a lQa;

    /* loaded from: classes25.dex */
    public interface a {
        void drx();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.lPY = null;
        this.lPZ = null;
        this.lQa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lPY = null;
        this.lPZ = null;
        this.lQa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lPY = null;
        this.lPZ = null;
        this.lQa = null;
        init();
    }

    private void init() {
        drG();
        drH();
    }

    private void drG() {
        this.lPZ = new Button(this.mContext);
        this.lPZ.setId(1);
        this.lPZ.setTextColor(this.lPK);
        this.lPZ.setTextSize(0, this.cbH);
        this.lPZ.setBackgroundColor(this.lPM);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.lPD);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lPZ, layoutParams);
        this.lPZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.lQa != null) {
                    VerificationCodeView.this.lQa.drx();
                }
            }
        });
    }

    private void drH() {
        this.lPY = new EditText(this.mContext);
        this.lPY.setTextColor(this.lPG);
        this.lPY.setHintTextColor(this.lPH);
        this.lPY.setTextSize(0, this.cbH);
        this.lPY.setGravity(19);
        int paddingBottom = this.lPY.getPaddingBottom();
        this.lPY.setPadding(this.lPA, this.lPY.getPaddingTop(), this.lPY.getPaddingRight(), paddingBottom);
        this.lPY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dru()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.lPY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.lPY, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lPD);
        layoutParams.addRule(0, this.lPZ.getId());
        layoutParams.addRule(15);
        a(this.lPY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lPY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.lMU)) {
                this.lPZ.setText(hVar.lMU);
                this.lPZ.setTextSize(0, this.cbH);
                this.lPZ.getLayoutParams().height = this.lPD;
                this.lPZ.setPadding(this.lPA, 0, this.lPA, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.lPY.setHint(hVar.content);
                this.lPY.setTextSize(0, this.cbH);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lPY.getLayoutParams();
                marginLayoutParams.height = this.lPD;
                marginLayoutParams.rightMargin = this.lPA;
                this.lPY.setPadding(this.lPA, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lPY.setText("");
    }

    public void setListener(a aVar) {
        this.lQa = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dru() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
