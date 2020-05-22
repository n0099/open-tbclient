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
    private EditText kNZ;
    private Button kOa;
    private a kOb;

    /* loaded from: classes13.dex */
    public interface a {
        void cUO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.kNZ = null;
        this.kOa = null;
        this.kOb = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kNZ = null;
        this.kOa = null;
        this.kOb = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kNZ = null;
        this.kOa = null;
        this.kOb = null;
        init();
    }

    private void init() {
        cUX();
        cUY();
    }

    private void cUX() {
        this.kOa = new Button(this.mContext);
        this.kOa.setId(1);
        this.kOa.setTextColor(this.kNL);
        this.kOa.setTextSize(0, this.bOo);
        this.kOa.setBackgroundColor(this.kNN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.kNE);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.kOa, layoutParams);
        this.kOa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.kOb != null) {
                    VerificationCodeView.this.kOb.cUO();
                }
            }
        });
    }

    private void cUY() {
        this.kNZ = new EditText(this.mContext);
        this.kNZ.setTextColor(this.kNH);
        this.kNZ.setHintTextColor(this.kNI);
        this.kNZ.setTextSize(0, this.bOo);
        this.kNZ.setGravity(19);
        int paddingBottom = this.kNZ.getPaddingBottom();
        this.kNZ.setPadding(this.kNB, this.kNZ.getPaddingTop(), this.kNZ.getPaddingRight(), paddingBottom);
        this.kNZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cUL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.kNZ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.kNZ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kNE);
        layoutParams.addRule(0, this.kOa.getId());
        layoutParams.addRule(15);
        a(this.kNZ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kNZ, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.kKV)) {
                this.kOa.setText(hVar.kKV);
                this.kOa.setTextSize(0, this.bOo);
                this.kOa.getLayoutParams().height = this.kNE;
                this.kOa.setPadding(this.kNB, 0, this.kNB, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.kNZ.setHint(hVar.content);
                this.kNZ.setTextSize(0, this.bOo);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kNZ.getLayoutParams();
                marginLayoutParams.height = this.kNE;
                marginLayoutParams.rightMargin = this.kNB;
                this.kNZ.setPadding(this.kNB, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kNZ.setText("");
    }

    public void setListener(a aVar) {
        this.kOb = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cUL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
