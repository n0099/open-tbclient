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
/* loaded from: classes7.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText mYO;
    private Button mYP;
    private a mYQ;

    /* loaded from: classes7.dex */
    public interface a {
        void dEc();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mYO = null;
        this.mYP = null;
        this.mYQ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mYO = null;
        this.mYP = null;
        this.mYQ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mYO = null;
        this.mYP = null;
        this.mYQ = null;
        init();
    }

    private void init() {
        dEl();
        dEm();
    }

    private void dEl() {
        this.mYP = new Button(this.mContext);
        this.mYP.setId(1);
        this.mYP.setTextColor(this.mButtonFontColor);
        this.mYP.setTextSize(0, this.cLA);
        this.mYP.setBackgroundColor(this.mYC);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mYu);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mYP, layoutParams);
        this.mYP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mYQ != null) {
                    VerificationCodeView.this.mYQ.dEc();
                }
            }
        });
    }

    private void dEm() {
        this.mYO = new EditText(this.mContext);
        this.mYO.setTextColor(this.mYx);
        this.mYO.setHintTextColor(this.mYy);
        this.mYO.setTextSize(0, this.cLA);
        this.mYO.setGravity(19);
        int paddingBottom = this.mYO.getPaddingBottom();
        this.mYO.setPadding(this.mYr, this.mYO.getPaddingTop(), this.mYO.getPaddingRight(), paddingBottom);
        this.mYO.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dDZ()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mYO, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mYO, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mYu);
        layoutParams.addRule(0, this.mYP.getId());
        layoutParams.addRule(15);
        a(this.mYO, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mYO, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mVK)) {
                this.mYP.setText(hVar.mVK);
                this.mYP.setTextSize(0, this.cLA);
                this.mYP.getLayoutParams().height = this.mYu;
                this.mYP.setPadding(this.mYr, 0, this.mYr, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mYO.setHint(hVar.content);
                this.mYO.setTextSize(0, this.cLA);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mYO.getLayoutParams();
                marginLayoutParams.height = this.mYu;
                marginLayoutParams.rightMargin = this.mYr;
                this.mYO.setPadding(this.mYr, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mYO.setText("");
    }

    public void setListener(a aVar) {
        this.mYQ = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDZ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
