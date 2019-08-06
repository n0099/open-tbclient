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
    private EditText iLH;
    private Button iLI;
    private a iLJ;

    /* loaded from: classes3.dex */
    public interface a {
        void ciz();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iLH = null;
        this.iLI = null;
        this.iLJ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iLH = null;
        this.iLI = null;
        this.iLJ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iLH = null;
        this.iLI = null;
        this.iLJ = null;
        init();
    }

    private void init() {
        ciJ();
        ciK();
    }

    private void ciJ() {
        this.iLI = new Button(this.mContext);
        this.iLI.setId(1);
        this.iLI.setTextColor(this.iLt);
        this.iLI.setTextSize(0, this.amF);
        this.iLI.setBackgroundColor(this.iLv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iLm);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iLI, layoutParams);
        this.iLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iLJ != null) {
                    VerificationCodeView.this.iLJ.ciz();
                }
            }
        });
    }

    private void ciK() {
        this.iLH = new EditText(this.mContext);
        this.iLH.setTextColor(this.iLp);
        this.iLH.setHintTextColor(this.iLq);
        this.iLH.setTextSize(0, this.amF);
        this.iLH.setGravity(19);
        int paddingBottom = this.iLH.getPaddingBottom();
        this.iLH.setPadding(this.iLj, this.iLH.getPaddingTop(), this.iLH.getPaddingRight(), paddingBottom);
        this.iLH.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.ciw()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iLH, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iLH, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iLm);
        layoutParams.addRule(0, this.iLI.getId());
        layoutParams.addRule(15);
        a(this.iLH, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iLH, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iIn)) {
                this.iLI.setText(hVar.iIn);
                this.iLI.setTextSize(0, this.amF);
                this.iLI.getLayoutParams().height = this.iLm;
                this.iLI.setPadding(this.iLj, 0, this.iLj, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iLH.setHint(hVar.content);
                this.iLH.setTextSize(0, this.amF);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iLH.getLayoutParams();
                marginLayoutParams.height = this.iLm;
                marginLayoutParams.rightMargin = this.iLj;
                this.iLH.setPadding(this.iLj, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iLH.setText("");
    }

    public void setListener(a aVar) {
        this.iLJ = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean ciw() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
