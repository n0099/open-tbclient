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
/* loaded from: classes20.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText lGR;
    private Button lGS;
    private a lGT;

    /* loaded from: classes20.dex */
    public interface a {
        void dnL();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.lGR = null;
        this.lGS = null;
        this.lGT = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lGR = null;
        this.lGS = null;
        this.lGT = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lGR = null;
        this.lGS = null;
        this.lGT = null;
        init();
    }

    private void init() {
        dnU();
        dnV();
    }

    private void dnU() {
        this.lGS = new Button(this.mContext);
        this.lGS.setId(1);
        this.lGS.setTextColor(this.lGD);
        this.lGS.setTextSize(0, this.bZC);
        this.lGS.setBackgroundColor(this.lGF);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.lGw);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lGS, layoutParams);
        this.lGS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.lGT != null) {
                    VerificationCodeView.this.lGT.dnL();
                }
            }
        });
    }

    private void dnV() {
        this.lGR = new EditText(this.mContext);
        this.lGR.setTextColor(this.lGz);
        this.lGR.setHintTextColor(this.lGA);
        this.lGR.setTextSize(0, this.bZC);
        this.lGR.setGravity(19);
        int paddingBottom = this.lGR.getPaddingBottom();
        this.lGR.setPadding(this.lGt, this.lGR.getPaddingTop(), this.lGR.getPaddingRight(), paddingBottom);
        this.lGR.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dnI()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.lGR, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.lGR, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lGw);
        layoutParams.addRule(0, this.lGS.getId());
        layoutParams.addRule(15);
        a(this.lGR, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lGR, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.lDP)) {
                this.lGS.setText(hVar.lDP);
                this.lGS.setTextSize(0, this.bZC);
                this.lGS.getLayoutParams().height = this.lGw;
                this.lGS.setPadding(this.lGt, 0, this.lGt, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.lGR.setHint(hVar.content);
                this.lGR.setTextSize(0, this.bZC);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lGR.getLayoutParams();
                marginLayoutParams.height = this.lGw;
                marginLayoutParams.rightMargin = this.lGt;
                this.lGR.setPadding(this.lGt, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lGR.setText("");
    }

    public void setListener(a aVar) {
        this.lGT = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dnI() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
