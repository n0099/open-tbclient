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
/* loaded from: classes8.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText mWD;
    private Button mWE;
    private a mWF;

    /* loaded from: classes8.dex */
    public interface a {
        void dDU();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mWD = null;
        this.mWE = null;
        this.mWF = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWD = null;
        this.mWE = null;
        this.mWF = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWD = null;
        this.mWE = null;
        this.mWF = null;
        init();
    }

    private void init() {
        dEd();
        dEe();
    }

    private void dEd() {
        this.mWE = new Button(this.mContext);
        this.mWE.setId(1);
        this.mWE.setTextColor(this.mButtonFontColor);
        this.mWE.setTextSize(0, this.cKa);
        this.mWE.setBackgroundColor(this.mWr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mWj);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mWE, layoutParams);
        this.mWE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mWF != null) {
                    VerificationCodeView.this.mWF.dDU();
                }
            }
        });
    }

    private void dEe() {
        this.mWD = new EditText(this.mContext);
        this.mWD.setTextColor(this.mWm);
        this.mWD.setHintTextColor(this.mWn);
        this.mWD.setTextSize(0, this.cKa);
        this.mWD.setGravity(19);
        int paddingBottom = this.mWD.getPaddingBottom();
        this.mWD.setPadding(this.mWg, this.mWD.getPaddingTop(), this.mWD.getPaddingRight(), paddingBottom);
        this.mWD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dDR()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mWD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mWD, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mWj);
        layoutParams.addRule(0, this.mWE.getId());
        layoutParams.addRule(15);
        a(this.mWD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mWD, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mTA)) {
                this.mWE.setText(hVar.mTA);
                this.mWE.setTextSize(0, this.cKa);
                this.mWE.getLayoutParams().height = this.mWj;
                this.mWE.setPadding(this.mWg, 0, this.mWg, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mWD.setHint(hVar.content);
                this.mWD.setTextSize(0, this.cKa);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWD.getLayoutParams();
                marginLayoutParams.height = this.mWj;
                marginLayoutParams.rightMargin = this.mWg;
                this.mWD.setPadding(this.mWg, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mWD.setText("");
    }

    public void setListener(a aVar) {
        this.mWF = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDR() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
