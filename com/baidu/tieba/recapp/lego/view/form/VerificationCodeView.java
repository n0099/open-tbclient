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
    private EditText gHX;
    private Button gHY;
    private a gHZ;

    /* loaded from: classes3.dex */
    public interface a {
        void btO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gHX = null;
        this.gHY = null;
        this.gHZ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gHX = null;
        this.gHY = null;
        this.gHZ = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gHX = null;
        this.gHY = null;
        this.gHZ = null;
        init();
    }

    private void init() {
        btY();
        btZ();
    }

    private void btY() {
        this.gHY = new Button(this.mContext);
        this.gHY.setId(1);
        this.gHY.setTextColor(this.gHJ);
        this.gHY.setTextSize(0, this.mFontSize);
        this.gHY.setBackgroundColor(this.gHL);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gHC);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gHY, layoutParams);
        this.gHY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gHZ != null) {
                    VerificationCodeView.this.gHZ.btO();
                }
            }
        });
    }

    private void btZ() {
        this.gHX = new EditText(this.mContext);
        this.gHX.setTextColor(this.gHF);
        this.gHX.setHintTextColor(this.gHG);
        this.gHX.setTextSize(0, this.mFontSize);
        this.gHX.setGravity(19);
        int paddingBottom = this.gHX.getPaddingBottom();
        this.gHX.setPadding(this.gHz, this.gHX.getPaddingTop(), this.gHX.getPaddingRight(), paddingBottom);
        this.gHX.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.btL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gHX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gHX, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gHC);
        layoutParams.addRule(0, this.gHY.getId());
        layoutParams.addRule(15);
        a(this.gHX, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gHX, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gEC)) {
                this.gHY.setText(hVar.gEC);
                this.gHY.setTextSize(0, this.mFontSize);
                this.gHY.getLayoutParams().height = this.gHC;
                this.gHY.setPadding(this.gHz, 0, this.gHz, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gHX.setHint(hVar.content);
                this.gHX.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gHX.getLayoutParams();
                marginLayoutParams.height = this.gHC;
                marginLayoutParams.rightMargin = this.gHz;
                this.gHX.setPadding(this.gHz, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gHX.setText("");
    }

    public void setListener(a aVar) {
        this.gHZ = aVar;
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
