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
    private EditText kPi;
    private Button kPj;
    private a kPk;

    /* loaded from: classes13.dex */
    public interface a {
        void cVe();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.kPi = null;
        this.kPj = null;
        this.kPk = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kPi = null;
        this.kPj = null;
        this.kPk = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kPi = null;
        this.kPj = null;
        this.kPk = null;
        init();
    }

    private void init() {
        cVn();
        cVo();
    }

    private void cVn() {
        this.kPj = new Button(this.mContext);
        this.kPj.setId(1);
        this.kPj.setTextColor(this.kOU);
        this.kPj.setTextSize(0, this.bOo);
        this.kPj.setBackgroundColor(this.kOW);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.kON);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.kPj, layoutParams);
        this.kPj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.kPk != null) {
                    VerificationCodeView.this.kPk.cVe();
                }
            }
        });
    }

    private void cVo() {
        this.kPi = new EditText(this.mContext);
        this.kPi.setTextColor(this.kOQ);
        this.kPi.setHintTextColor(this.kOR);
        this.kPi.setTextSize(0, this.bOo);
        this.kPi.setGravity(19);
        int paddingBottom = this.kPi.getPaddingBottom();
        this.kPi.setPadding(this.kOK, this.kPi.getPaddingTop(), this.kPi.getPaddingRight(), paddingBottom);
        this.kPi.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cVb()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.kPi, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.kPi, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kON);
        layoutParams.addRule(0, this.kPj.getId());
        layoutParams.addRule(15);
        a(this.kPi, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kPi, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.kMe)) {
                this.kPj.setText(hVar.kMe);
                this.kPj.setTextSize(0, this.bOo);
                this.kPj.getLayoutParams().height = this.kON;
                this.kPj.setPadding(this.kOK, 0, this.kOK, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.kPi.setHint(hVar.content);
                this.kPi.setTextSize(0, this.bOo);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kPi.getLayoutParams();
                marginLayoutParams.height = this.kON;
                marginLayoutParams.rightMargin = this.kOK;
                this.kPi.setPadding(this.kOK, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kPi.setText("");
    }

    public void setListener(a aVar) {
        this.kPk = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cVb() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
