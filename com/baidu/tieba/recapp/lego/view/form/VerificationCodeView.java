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
/* loaded from: classes11.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText jJV;
    private Button jJW;
    private a jJX;

    /* loaded from: classes11.dex */
    public interface a {
        void cBA();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.jJV = null;
        this.jJW = null;
        this.jJX = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jJV = null;
        this.jJW = null;
        this.jJX = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jJV = null;
        this.jJW = null;
        this.jJX = null;
        init();
    }

    private void init() {
        cBI();
        cBJ();
    }

    private void cBI() {
        this.jJW = new Button(this.mContext);
        this.jJW.setId(1);
        this.jJW.setTextColor(this.jJH);
        this.jJW.setTextSize(0, this.bcC);
        this.jJW.setBackgroundColor(this.jJJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.jJA);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jJW, layoutParams);
        this.jJW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.jJX != null) {
                    VerificationCodeView.this.jJX.cBA();
                }
            }
        });
    }

    private void cBJ() {
        this.jJV = new EditText(this.mContext);
        this.jJV.setTextColor(this.jJD);
        this.jJV.setHintTextColor(this.jJE);
        this.jJV.setTextSize(0, this.bcC);
        this.jJV.setGravity(19);
        int paddingBottom = this.jJV.getPaddingBottom();
        this.jJV.setPadding(this.jJx, this.jJV.getPaddingTop(), this.jJV.getPaddingRight(), paddingBottom);
        this.jJV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cBx()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.jJV, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.jJV, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jJA);
        layoutParams.addRule(0, this.jJW.getId());
        layoutParams.addRule(15);
        a(this.jJV, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jJV, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.jGC)) {
                this.jJW.setText(hVar.jGC);
                this.jJW.setTextSize(0, this.bcC);
                this.jJW.getLayoutParams().height = this.jJA;
                this.jJW.setPadding(this.jJx, 0, this.jJx, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.jJV.setHint(hVar.content);
                this.jJV.setTextSize(0, this.bcC);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jJV.getLayoutParams();
                marginLayoutParams.height = this.jJA;
                marginLayoutParams.rightMargin = this.jJx;
                this.jJV.setPadding(this.jJx, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jJV.setText("");
    }

    public void setListener(a aVar) {
        this.jJX = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cBx() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
