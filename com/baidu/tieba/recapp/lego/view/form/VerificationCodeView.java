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
    private a gAA;
    private EditText gAy;
    private Button gAz;

    /* loaded from: classes3.dex */
    public interface a {
        void bqz();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gAy = null;
        this.gAz = null;
        this.gAA = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gAy = null;
        this.gAz = null;
        this.gAA = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gAy = null;
        this.gAz = null;
        this.gAA = null;
        init();
    }

    private void init() {
        bqJ();
        bqK();
    }

    private void bqJ() {
        this.gAz = new Button(this.mContext);
        this.gAz.setId(1);
        this.gAz.setTextColor(this.gAk);
        this.gAz.setTextSize(0, this.gAh);
        this.gAz.setBackgroundColor(this.gAm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gAc);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gAz, layoutParams);
        this.gAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gAA != null) {
                    VerificationCodeView.this.gAA.bqz();
                }
            }
        });
    }

    private void bqK() {
        this.gAy = new EditText(this.mContext);
        this.gAy.setTextColor(this.gAf);
        this.gAy.setHintTextColor(this.gAg);
        this.gAy.setTextSize(0, this.gAh);
        this.gAy.setGravity(19);
        int paddingBottom = this.gAy.getPaddingBottom();
        this.gAy.setPadding(this.gzZ, this.gAy.getPaddingTop(), this.gAy.getPaddingRight(), paddingBottom);
        this.gAy.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bqw()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gAy, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gAy, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gAc);
        layoutParams.addRule(0, this.gAz.getId());
        layoutParams.addRule(15);
        a(this.gAy, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gAy, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gxc)) {
                this.gAz.setText(hVar.gxc);
                this.gAz.setTextSize(0, this.gAh);
                this.gAz.getLayoutParams().height = this.gAc;
                this.gAz.setPadding(this.gzZ, 0, this.gzZ, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gAy.setHint(hVar.content);
                this.gAy.setTextSize(0, this.gAh);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gAy.getLayoutParams();
                marginLayoutParams.height = this.gAc;
                marginLayoutParams.rightMargin = this.gzZ;
                this.gAy.setPadding(this.gzZ, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gAy.setText("");
    }

    public void setListener(a aVar) {
        this.gAA = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bqw() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
