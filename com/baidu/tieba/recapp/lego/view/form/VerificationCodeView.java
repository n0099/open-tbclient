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
    private EditText ilQ;
    private Button ilR;
    private a ilS;

    /* loaded from: classes3.dex */
    public interface a {
        void bXl();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.ilQ = null;
        this.ilR = null;
        this.ilS = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ilQ = null;
        this.ilR = null;
        this.ilS = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilQ = null;
        this.ilR = null;
        this.ilS = null;
        init();
    }

    private void init() {
        bXv();
        bXw();
    }

    private void bXv() {
        this.ilR = new Button(this.mContext);
        this.ilR.setId(1);
        this.ilR.setTextColor(this.ilC);
        this.ilR.setTextSize(0, this.alK);
        this.ilR.setBackgroundColor(this.ilE);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.ilv);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ilR, layoutParams);
        this.ilR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.ilS != null) {
                    VerificationCodeView.this.ilS.bXl();
                }
            }
        });
    }

    private void bXw() {
        this.ilQ = new EditText(this.mContext);
        this.ilQ.setTextColor(this.ily);
        this.ilQ.setHintTextColor(this.ilz);
        this.ilQ.setTextSize(0, this.alK);
        this.ilQ.setGravity(19);
        int paddingBottom = this.ilQ.getPaddingBottom();
        this.ilQ.setPadding(this.ils, this.ilQ.getPaddingTop(), this.ilQ.getPaddingRight(), paddingBottom);
        this.ilQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bXi()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilQ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilQ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilv);
        layoutParams.addRule(0, this.ilR.getId());
        layoutParams.addRule(15);
        a(this.ilQ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ilQ, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iiv)) {
                this.ilR.setText(hVar.iiv);
                this.ilR.setTextSize(0, this.alK);
                this.ilR.getLayoutParams().height = this.ilv;
                this.ilR.setPadding(this.ils, 0, this.ils, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.ilQ.setHint(hVar.content);
                this.ilQ.setTextSize(0, this.alK);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilQ.getLayoutParams();
                marginLayoutParams.height = this.ilv;
                marginLayoutParams.rightMargin = this.ils;
                this.ilQ.setPadding(this.ils, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ilQ.setText("");
    }

    public void setListener(a aVar) {
        this.ilS = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXi() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
