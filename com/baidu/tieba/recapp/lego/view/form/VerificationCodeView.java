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
    private EditText gHY;
    private Button gHZ;
    private a gIa;

    /* loaded from: classes3.dex */
    public interface a {
        void btO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gHY = null;
        this.gHZ = null;
        this.gIa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHY = null;
        this.gHZ = null;
        this.gIa = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHY = null;
        this.gHZ = null;
        this.gIa = null;
        init();
    }

    private void init() {
        btY();
        btZ();
    }

    private void btY() {
        this.gHZ = new Button(this.mContext);
        this.gHZ.setId(1);
        this.gHZ.setTextColor(this.gHK);
        this.gHZ.setTextSize(0, this.mFontSize);
        this.gHZ.setBackgroundColor(this.gHM);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gHD);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gHZ, layoutParams);
        this.gHZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gIa != null) {
                    VerificationCodeView.this.gIa.btO();
                }
            }
        });
    }

    private void btZ() {
        this.gHY = new EditText(this.mContext);
        this.gHY.setTextColor(this.gHG);
        this.gHY.setHintTextColor(this.gHH);
        this.gHY.setTextSize(0, this.mFontSize);
        this.gHY.setGravity(19);
        int paddingBottom = this.gHY.getPaddingBottom();
        this.gHY.setPadding(this.gHA, this.gHY.getPaddingTop(), this.gHY.getPaddingRight(), paddingBottom);
        this.gHY.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.btL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gHY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gHY, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gHD);
        layoutParams.addRule(0, this.gHZ.getId());
        layoutParams.addRule(15);
        a(this.gHY, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gHY, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gED)) {
                this.gHZ.setText(hVar.gED);
                this.gHZ.setTextSize(0, this.mFontSize);
                this.gHZ.getLayoutParams().height = this.gHD;
                this.gHZ.setPadding(this.gHA, 0, this.gHA, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gHY.setHint(hVar.content);
                this.gHY.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gHY.getLayoutParams();
                marginLayoutParams.height = this.gHD;
                marginLayoutParams.rightMargin = this.gHA;
                this.gHY.setPadding(this.gHA, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gHY.setText("");
    }

    public void setListener(a aVar) {
        this.gIa = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean btL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
