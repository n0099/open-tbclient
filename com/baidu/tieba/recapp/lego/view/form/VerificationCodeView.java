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
    private EditText grP;
    private Button grQ;
    private a grR;

    /* loaded from: classes3.dex */
    public interface a {
        void bpn();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.grP = null;
        this.grQ = null;
        this.grR = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.grP = null;
        this.grQ = null;
        this.grR = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.grP = null;
        this.grQ = null;
        this.grR = null;
        init();
    }

    private void init() {
        bpw();
        bpx();
    }

    private void bpw() {
        this.grQ = new Button(this.mContext);
        this.grQ.setId(1);
        this.grQ.setTextColor(this.grB);
        this.grQ.setTextSize(0, this.gry);
        this.grQ.setBackgroundColor(this.grD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.grt);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.grQ, layoutParams);
        this.grQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.grR != null) {
                    VerificationCodeView.this.grR.bpn();
                }
            }
        });
    }

    private void bpx() {
        this.grP = new EditText(this.mContext);
        this.grP.setTextColor(this.grw);
        this.grP.setHintTextColor(this.grx);
        this.grP.setTextSize(0, this.gry);
        this.grP.setGravity(19);
        int paddingBottom = this.grP.getPaddingBottom();
        this.grP.setPadding(this.grq, this.grP.getPaddingTop(), this.grP.getPaddingRight(), paddingBottom);
        this.grP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bpk()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.grP, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.grP, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.grt);
        layoutParams.addRule(0, this.grQ.getId());
        layoutParams.addRule(15);
        a(this.grP, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.grP, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gox)) {
                this.grQ.setText(hVar.gox);
                this.grQ.setTextSize(0, this.gry);
                this.grQ.getLayoutParams().height = this.grt;
                this.grQ.setPadding(this.grq, 0, this.grq, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.grP.setHint(hVar.content);
                this.grP.setTextSize(0, this.gry);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.grP.getLayoutParams();
                marginLayoutParams.height = this.grt;
                marginLayoutParams.rightMargin = this.grq;
                this.grP.setPadding(this.grq, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.grP.setText("");
    }

    public void setListener(a aVar) {
        this.grR = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bpk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
