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
    private EditText jKY;
    private Button jKZ;
    private a jLa;

    /* loaded from: classes13.dex */
    public interface a {
        void cDa();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.jKY = null;
        this.jKZ = null;
        this.jLa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jKY = null;
        this.jKZ = null;
        this.jLa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jKY = null;
        this.jKZ = null;
        this.jLa = null;
        init();
    }

    private void init() {
        cDi();
        cDj();
    }

    private void cDi() {
        this.jKZ = new Button(this.mContext);
        this.jKZ.setId(1);
        this.jKZ.setTextColor(this.jKK);
        this.jKZ.setTextSize(0, this.bgS);
        this.jKZ.setBackgroundColor(this.jKM);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.jKD);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jKZ, layoutParams);
        this.jKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.jLa != null) {
                    VerificationCodeView.this.jLa.cDa();
                }
            }
        });
    }

    private void cDj() {
        this.jKY = new EditText(this.mContext);
        this.jKY.setTextColor(this.jKG);
        this.jKY.setHintTextColor(this.jKH);
        this.jKY.setTextSize(0, this.bgS);
        this.jKY.setGravity(19);
        int paddingBottom = this.jKY.getPaddingBottom();
        this.jKY.setPadding(this.jKA, this.jKY.getPaddingTop(), this.jKY.getPaddingRight(), paddingBottom);
        this.jKY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cCX()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.jKY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.jKY, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKD);
        layoutParams.addRule(0, this.jKZ.getId());
        layoutParams.addRule(15);
        a(this.jKY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jKY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.jHA)) {
                this.jKZ.setText(hVar.jHA);
                this.jKZ.setTextSize(0, this.bgS);
                this.jKZ.getLayoutParams().height = this.jKD;
                this.jKZ.setPadding(this.jKA, 0, this.jKA, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.jKY.setHint(hVar.content);
                this.jKY.setTextSize(0, this.bgS);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKY.getLayoutParams();
                marginLayoutParams.height = this.jKD;
                marginLayoutParams.rightMargin = this.jKA;
                this.jKY.setPadding(this.jKA, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jKY.setText("");
    }

    public void setListener(a aVar) {
        this.jLa = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCX() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
