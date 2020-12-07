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
    private EditText mMl;
    private Button mMm;
    private a mMn;

    /* loaded from: classes26.dex */
    public interface a {
        void dFF();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mMl = null;
        this.mMm = null;
        this.mMn = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMl = null;
        this.mMm = null;
        this.mMn = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMl = null;
        this.mMm = null;
        this.mMn = null;
        init();
    }

    private void init() {
        dFO();
        dFP();
    }

    private void dFO() {
        this.mMm = new Button(this.mContext);
        this.mMm.setId(1);
        this.mMm.setTextColor(this.mLX);
        this.mMm.setTextSize(0, this.cHF);
        this.mMm.setBackgroundColor(this.mLZ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mLQ);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mMm, layoutParams);
        this.mMm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mMn != null) {
                    VerificationCodeView.this.mMn.dFF();
                }
            }
        });
    }

    private void dFP() {
        this.mMl = new EditText(this.mContext);
        this.mMl.setTextColor(this.mLT);
        this.mMl.setHintTextColor(this.mLU);
        this.mMl.setTextSize(0, this.cHF);
        this.mMl.setGravity(19);
        int paddingBottom = this.mMl.getPaddingBottom();
        this.mMl.setPadding(this.mLN, this.mMl.getPaddingTop(), this.mMl.getPaddingRight(), paddingBottom);
        this.mMl.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dFC()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mMl, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mMl, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mLQ);
        layoutParams.addRule(0, this.mMm.getId());
        layoutParams.addRule(15);
        a(this.mMl, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mMl, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mJk)) {
                this.mMm.setText(hVar.mJk);
                this.mMm.setTextSize(0, this.cHF);
                this.mMm.getLayoutParams().height = this.mLQ;
                this.mMm.setPadding(this.mLN, 0, this.mLN, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mMl.setHint(hVar.content);
                this.mMl.setTextSize(0, this.cHF);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMl.getLayoutParams();
                marginLayoutParams.height = this.mLQ;
                marginLayoutParams.rightMargin = this.mLN;
                this.mMl.setPadding(this.mLN, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mMl.setText("");
    }

    public void setListener(a aVar) {
        this.mMn = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFC() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
