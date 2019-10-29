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
    private EditText iMV;
    private Button iMW;
    private a iMX;

    /* loaded from: classes3.dex */
    public interface a {
        void cgr();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iMV = null;
        this.iMW = null;
        this.iMX = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMV = null;
        this.iMW = null;
        this.iMX = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iMV = null;
        this.iMW = null;
        this.iMX = null;
        init();
    }

    private void init() {
        cgB();
        cgC();
    }

    private void cgB() {
        this.iMW = new Button(this.mContext);
        this.iMW.setId(1);
        this.iMW.setTextColor(this.iMH);
        this.iMW.setTextSize(0, this.aGv);
        this.iMW.setBackgroundColor(this.iMJ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iMA);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iMW, layoutParams);
        this.iMW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iMX != null) {
                    VerificationCodeView.this.iMX.cgr();
                }
            }
        });
    }

    private void cgC() {
        this.iMV = new EditText(this.mContext);
        this.iMV.setTextColor(this.iMD);
        this.iMV.setHintTextColor(this.iME);
        this.iMV.setTextSize(0, this.aGv);
        this.iMV.setGravity(19);
        int paddingBottom = this.iMV.getPaddingBottom();
        this.iMV.setPadding(this.iMx, this.iMV.getPaddingTop(), this.iMV.getPaddingRight(), paddingBottom);
        this.iMV.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cgo()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iMV, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iMV, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iMA);
        layoutParams.addRule(0, this.iMW.getId());
        layoutParams.addRule(15);
        a(this.iMV, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iMV, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iJA)) {
                this.iMW.setText(hVar.iJA);
                this.iMW.setTextSize(0, this.aGv);
                this.iMW.getLayoutParams().height = this.iMA;
                this.iMW.setPadding(this.iMx, 0, this.iMx, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iMV.setHint(hVar.content);
                this.iMV.setTextSize(0, this.aGv);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iMV.getLayoutParams();
                marginLayoutParams.height = this.iMA;
                marginLayoutParams.rightMargin = this.iMx;
                this.iMV.setPadding(this.iMx, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iMV.setText("");
    }

    public void setListener(a aVar) {
        this.iMX = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgo() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
