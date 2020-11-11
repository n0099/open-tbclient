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
    private EditText mxL;
    private Button mxM;
    private a mxN;

    /* loaded from: classes26.dex */
    public interface a {
        void dAR();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mxL = null;
        this.mxM = null;
        this.mxN = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mxL = null;
        this.mxM = null;
        this.mxN = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mxL = null;
        this.mxM = null;
        this.mxN = null;
        init();
    }

    private void init() {
        dBa();
        dBb();
    }

    private void dBa() {
        this.mxM = new Button(this.mContext);
        this.mxM.setId(1);
        this.mxM.setTextColor(this.mxx);
        this.mxM.setTextSize(0, this.cCt);
        this.mxM.setBackgroundColor(this.mxz);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mxq);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mxM, layoutParams);
        this.mxM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mxN != null) {
                    VerificationCodeView.this.mxN.dAR();
                }
            }
        });
    }

    private void dBb() {
        this.mxL = new EditText(this.mContext);
        this.mxL.setTextColor(this.mxt);
        this.mxL.setHintTextColor(this.mxu);
        this.mxL.setTextSize(0, this.cCt);
        this.mxL.setGravity(19);
        int paddingBottom = this.mxL.getPaddingBottom();
        this.mxL.setPadding(this.mxn, this.mxL.getPaddingTop(), this.mxL.getPaddingRight(), paddingBottom);
        this.mxL.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dAO()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mxL, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mxL, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mxq);
        layoutParams.addRule(0, this.mxM.getId());
        layoutParams.addRule(15);
        a(this.mxL, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mxL, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.muH)) {
                this.mxM.setText(hVar.muH);
                this.mxM.setTextSize(0, this.cCt);
                this.mxM.getLayoutParams().height = this.mxq;
                this.mxM.setPadding(this.mxn, 0, this.mxn, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mxL.setHint(hVar.content);
                this.mxL.setTextSize(0, this.cCt);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mxL.getLayoutParams();
                marginLayoutParams.height = this.mxq;
                marginLayoutParams.rightMargin = this.mxn;
                this.mxL.setPadding(this.mxn, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mxL.setText("");
    }

    public void setListener(a aVar) {
        this.mxN = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dAO() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
