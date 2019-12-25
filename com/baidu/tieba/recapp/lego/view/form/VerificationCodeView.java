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
/* loaded from: classes10.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText jGt;
    private Button jGu;
    private a jGv;

    /* loaded from: classes10.dex */
    public interface a {
        void cAt();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.jGt = null;
        this.jGu = null;
        this.jGv = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jGt = null;
        this.jGu = null;
        this.jGv = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jGt = null;
        this.jGu = null;
        this.jGv = null;
        init();
    }

    private void init() {
        cAC();
        cAD();
    }

    private void cAC() {
        this.jGu = new Button(this.mContext);
        this.jGu.setId(1);
        this.jGu.setTextColor(this.jGf);
        this.jGu.setTextSize(0, this.bbM);
        this.jGu.setBackgroundColor(this.jGh);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.jFY);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jGu, layoutParams);
        this.jGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.jGv != null) {
                    VerificationCodeView.this.jGv.cAt();
                }
            }
        });
    }

    private void cAD() {
        this.jGt = new EditText(this.mContext);
        this.jGt.setTextColor(this.jGb);
        this.jGt.setHintTextColor(this.jGc);
        this.jGt.setTextSize(0, this.bbM);
        this.jGt.setGravity(19);
        int paddingBottom = this.jGt.getPaddingBottom();
        this.jGt.setPadding(this.jFV, this.jGt.getPaddingTop(), this.jGt.getPaddingRight(), paddingBottom);
        this.jGt.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cAq()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.jGt, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.jGt, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jFY);
        layoutParams.addRule(0, this.jGu.getId());
        layoutParams.addRule(15);
        a(this.jGt, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jGt, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.jDa)) {
                this.jGu.setText(hVar.jDa);
                this.jGu.setTextSize(0, this.bbM);
                this.jGu.getLayoutParams().height = this.jFY;
                this.jGu.setPadding(this.jFV, 0, this.jFV, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.jGt.setHint(hVar.content);
                this.jGt.setTextSize(0, this.bbM);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jGt.getLayoutParams();
                marginLayoutParams.height = this.jFY;
                marginLayoutParams.rightMargin = this.jFV;
                this.jGt.setPadding(this.jFV, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jGt.setText("");
    }

    public void setListener(a aVar) {
        this.jGv = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cAq() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
