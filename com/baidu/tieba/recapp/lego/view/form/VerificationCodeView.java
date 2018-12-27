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
    private EditText gTh;
    private Button gTi;
    private a gTj;

    /* loaded from: classes3.dex */
    public interface a {
        void bvO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gTh = null;
        this.gTi = null;
        this.gTj = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gTh = null;
        this.gTi = null;
        this.gTj = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gTh = null;
        this.gTi = null;
        this.gTj = null;
        init();
    }

    private void init() {
        bvY();
        bvZ();
    }

    private void bvY() {
        this.gTi = new Button(this.mContext);
        this.gTi.setId(1);
        this.gTi.setTextColor(this.gST);
        this.gTi.setTextSize(0, this.mFontSize);
        this.gTi.setBackgroundColor(this.gSV);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gSM);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gTi, layoutParams);
        this.gTi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gTj != null) {
                    VerificationCodeView.this.gTj.bvO();
                }
            }
        });
    }

    private void bvZ() {
        this.gTh = new EditText(this.mContext);
        this.gTh.setTextColor(this.gSP);
        this.gTh.setHintTextColor(this.gSQ);
        this.gTh.setTextSize(0, this.mFontSize);
        this.gTh.setGravity(19);
        int paddingBottom = this.gTh.getPaddingBottom();
        this.gTh.setPadding(this.gSJ, this.gTh.getPaddingTop(), this.gTh.getPaddingRight(), paddingBottom);
        this.gTh.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bvL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gTh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gTh, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gSM);
        layoutParams.addRule(0, this.gTi.getId());
        layoutParams.addRule(15);
        a(this.gTh, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gTh, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gPM)) {
                this.gTi.setText(hVar.gPM);
                this.gTi.setTextSize(0, this.mFontSize);
                this.gTi.getLayoutParams().height = this.gSM;
                this.gTi.setPadding(this.gSJ, 0, this.gSJ, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gTh.setHint(hVar.content);
                this.gTh.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gTh.getLayoutParams();
                marginLayoutParams.height = this.gSM;
                marginLayoutParams.rightMargin = this.gSJ;
                this.gTh.setPadding(this.gSJ, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gTh.setText("");
    }

    public void setListener(a aVar) {
        this.gTj = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bvL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
