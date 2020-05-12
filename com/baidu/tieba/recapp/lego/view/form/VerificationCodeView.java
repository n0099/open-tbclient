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
    private EditText kwg;
    private Button kwh;
    private a kwi;

    /* loaded from: classes13.dex */
    public interface a {
        void cNO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.kwg = null;
        this.kwh = null;
        this.kwi = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kwg = null;
        this.kwh = null;
        this.kwi = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kwg = null;
        this.kwh = null;
        this.kwi = null;
        init();
    }

    private void init() {
        cNX();
        cNY();
    }

    private void cNX() {
        this.kwh = new Button(this.mContext);
        this.kwh.setId(1);
        this.kwh.setTextColor(this.kvS);
        this.kwh.setTextSize(0, this.bFw);
        this.kwh.setBackgroundColor(this.kvU);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.kvL);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.kwh, layoutParams);
        this.kwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.kwi != null) {
                    VerificationCodeView.this.kwi.cNO();
                }
            }
        });
    }

    private void cNY() {
        this.kwg = new EditText(this.mContext);
        this.kwg.setTextColor(this.kvO);
        this.kwg.setHintTextColor(this.kvP);
        this.kwg.setTextSize(0, this.bFw);
        this.kwg.setGravity(19);
        int paddingBottom = this.kwg.getPaddingBottom();
        this.kwg.setPadding(this.kvI, this.kwg.getPaddingTop(), this.kwg.getPaddingRight(), paddingBottom);
        this.kwg.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cNL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.kwg, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.kwg, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kvL);
        layoutParams.addRule(0, this.kwh.getId());
        layoutParams.addRule(15);
        a(this.kwg, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kwg, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.ktb)) {
                this.kwh.setText(hVar.ktb);
                this.kwh.setTextSize(0, this.bFw);
                this.kwh.getLayoutParams().height = this.kvL;
                this.kwh.setPadding(this.kvI, 0, this.kvI, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.kwg.setHint(hVar.content);
                this.kwg.setTextSize(0, this.bFw);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kwg.getLayoutParams();
                marginLayoutParams.height = this.kvL;
                marginLayoutParams.rightMargin = this.kvI;
                this.kwg.setPadding(this.kvI, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kwg.setText("");
    }

    public void setListener(a aVar) {
        this.kwi = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
