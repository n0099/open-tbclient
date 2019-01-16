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
    private EditText gUm;
    private Button gUn;
    private a gUo;

    /* loaded from: classes3.dex */
    public interface a {
        void bwx();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gUm = null;
        this.gUn = null;
        this.gUo = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUm = null;
        this.gUn = null;
        this.gUo = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gUm = null;
        this.gUn = null;
        this.gUo = null;
        init();
    }

    private void init() {
        bwH();
        bwI();
    }

    private void bwH() {
        this.gUn = new Button(this.mContext);
        this.gUn.setId(1);
        this.gUn.setTextColor(this.gTY);
        this.gUn.setTextSize(0, this.mFontSize);
        this.gUn.setBackgroundColor(this.gUa);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gTR);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gUn, layoutParams);
        this.gUn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gUo != null) {
                    VerificationCodeView.this.gUo.bwx();
                }
            }
        });
    }

    private void bwI() {
        this.gUm = new EditText(this.mContext);
        this.gUm.setTextColor(this.gTU);
        this.gUm.setHintTextColor(this.gTV);
        this.gUm.setTextSize(0, this.mFontSize);
        this.gUm.setGravity(19);
        int paddingBottom = this.gUm.getPaddingBottom();
        this.gUm.setPadding(this.gTO, this.gUm.getPaddingTop(), this.gUm.getPaddingRight(), paddingBottom);
        this.gUm.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bwu()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gUm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gUm, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gTR);
        layoutParams.addRule(0, this.gUn.getId());
        layoutParams.addRule(15);
        a(this.gUm, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gUm, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gQP)) {
                this.gUn.setText(hVar.gQP);
                this.gUn.setTextSize(0, this.mFontSize);
                this.gUn.getLayoutParams().height = this.gTR;
                this.gUn.setPadding(this.gTO, 0, this.gTO, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gUm.setHint(hVar.content);
                this.gUm.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gUm.getLayoutParams();
                marginLayoutParams.height = this.gTR;
                marginLayoutParams.rightMargin = this.gTO;
                this.gUm.setPadding(this.gTO, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gUm.setText("");
    }

    public void setListener(a aVar) {
        this.gUo = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bwu() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
