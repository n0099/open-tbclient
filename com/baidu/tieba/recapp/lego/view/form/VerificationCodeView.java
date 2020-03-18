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
/* loaded from: classes13.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText jMM;
    private Button jMN;
    private a jMO;

    /* loaded from: classes13.dex */
    public interface a {
        void cDv();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.jMM = null;
        this.jMN = null;
        this.jMO = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jMM = null;
        this.jMN = null;
        this.jMO = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jMM = null;
        this.jMN = null;
        this.jMO = null;
        init();
    }

    private void init() {
        cDD();
        cDE();
    }

    private void cDD() {
        this.jMN = new Button(this.mContext);
        this.jMN.setId(1);
        this.jMN.setTextColor(this.jMy);
        this.jMN.setTextSize(0, this.bhg);
        this.jMN.setBackgroundColor(this.jMA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.jMr);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jMN, layoutParams);
        this.jMN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.jMO != null) {
                    VerificationCodeView.this.jMO.cDv();
                }
            }
        });
    }

    private void cDE() {
        this.jMM = new EditText(this.mContext);
        this.jMM.setTextColor(this.jMu);
        this.jMM.setHintTextColor(this.jMv);
        this.jMM.setTextSize(0, this.bhg);
        this.jMM.setGravity(19);
        int paddingBottom = this.jMM.getPaddingBottom();
        this.jMM.setPadding(this.jMo, this.jMM.getPaddingTop(), this.jMM.getPaddingRight(), paddingBottom);
        this.jMM.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cDs()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.jMM, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.jMM, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jMr);
        layoutParams.addRule(0, this.jMN.getId());
        layoutParams.addRule(15);
        a(this.jMM, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jMM, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.jJl)) {
                this.jMN.setText(hVar.jJl);
                this.jMN.setTextSize(0, this.bhg);
                this.jMN.getLayoutParams().height = this.jMr;
                this.jMN.setPadding(this.jMo, 0, this.jMo, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.jMM.setHint(hVar.content);
                this.jMM.setTextSize(0, this.bhg);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jMM.getLayoutParams();
                marginLayoutParams.height = this.jMr;
                marginLayoutParams.rightMargin = this.jMo;
                this.jMM.setPadding(this.jMo, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jMM.setText("");
    }

    public void setListener(a aVar) {
        this.jMO = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cDs() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
