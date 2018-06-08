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
    private EditText gnY;
    private Button gnZ;
    private a goa;

    /* loaded from: classes3.dex */
    public interface a {
        void boM();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gnY = null;
        this.gnZ = null;
        this.goa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gnY = null;
        this.gnZ = null;
        this.goa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gnY = null;
        this.gnZ = null;
        this.goa = null;
        init();
    }

    private void init() {
        boV();
        boW();
    }

    private void boV() {
        this.gnZ = new Button(this.mContext);
        this.gnZ.setId(1);
        this.gnZ.setTextColor(this.gnK);
        this.gnZ.setTextSize(0, this.gnH);
        this.gnZ.setBackgroundColor(this.gnM);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gnC);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gnZ, layoutParams);
        this.gnZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.goa != null) {
                    VerificationCodeView.this.goa.boM();
                }
            }
        });
    }

    private void boW() {
        this.gnY = new EditText(this.mContext);
        this.gnY.setTextColor(this.gnF);
        this.gnY.setHintTextColor(this.gnG);
        this.gnY.setTextSize(0, this.gnH);
        this.gnY.setGravity(19);
        int paddingBottom = this.gnY.getPaddingBottom();
        this.gnY.setPadding(this.gnz, this.gnY.getPaddingTop(), this.gnY.getPaddingRight(), paddingBottom);
        this.gnY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.boJ()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gnY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gnY, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gnC);
        layoutParams.addRule(0, this.gnZ.getId());
        layoutParams.addRule(15);
        a(this.gnY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gnY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gkH)) {
                this.gnZ.setText(hVar.gkH);
                this.gnZ.setTextSize(0, this.gnH);
                this.gnZ.getLayoutParams().height = this.gnC;
                this.gnZ.setPadding(this.gnz, 0, this.gnz, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gnY.setHint(hVar.content);
                this.gnY.setTextSize(0, this.gnH);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gnY.getLayoutParams();
                marginLayoutParams.height = this.gnC;
                marginLayoutParams.rightMargin = this.gnz;
                this.gnY.setPadding(this.gnz, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gnY.setText("");
    }

    public void setListener(a aVar) {
        this.goa = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean boJ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
