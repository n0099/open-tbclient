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
    private EditText ljb;
    private Button ljc;
    private a ljd;

    /* loaded from: classes13.dex */
    public interface a {
        void cZv();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.ljb = null;
        this.ljc = null;
        this.ljd = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ljb = null;
        this.ljc = null;
        this.ljd = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ljb = null;
        this.ljc = null;
        this.ljd = null;
        init();
    }

    private void init() {
        cZE();
        cZF();
    }

    private void cZE() {
        this.ljc = new Button(this.mContext);
        this.ljc.setId(1);
        this.ljc.setTextColor(this.liN);
        this.ljc.setTextSize(0, this.bTc);
        this.ljc.setBackgroundColor(this.liP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.liG);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ljc, layoutParams);
        this.ljc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.ljd != null) {
                    VerificationCodeView.this.ljd.cZv();
                }
            }
        });
    }

    private void cZF() {
        this.ljb = new EditText(this.mContext);
        this.ljb.setTextColor(this.liJ);
        this.ljb.setHintTextColor(this.liK);
        this.ljb.setTextSize(0, this.bTc);
        this.ljb.setGravity(19);
        int paddingBottom = this.ljb.getPaddingBottom();
        this.ljb.setPadding(this.liD, this.ljb.getPaddingTop(), this.ljb.getPaddingRight(), paddingBottom);
        this.ljb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cZs()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.ljb, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.ljb, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.liG);
        layoutParams.addRule(0, this.ljc.getId());
        layoutParams.addRule(15);
        a(this.ljb, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ljb, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.lfY)) {
                this.ljc.setText(hVar.lfY);
                this.ljc.setTextSize(0, this.bTc);
                this.ljc.getLayoutParams().height = this.liG;
                this.ljc.setPadding(this.liD, 0, this.liD, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.ljb.setHint(hVar.content);
                this.ljb.setTextSize(0, this.bTc);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ljb.getLayoutParams();
                marginLayoutParams.height = this.liG;
                marginLayoutParams.rightMargin = this.liD;
                this.ljb.setPadding(this.liD, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ljb.setText("");
    }

    public void setListener(a aVar) {
        this.ljd = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cZs() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
