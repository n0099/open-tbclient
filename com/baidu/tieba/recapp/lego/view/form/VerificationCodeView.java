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
    private EditText gbA;
    private Button gbB;
    private a gbC;

    /* loaded from: classes3.dex */
    public interface a {
        void bjO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gbA = null;
        this.gbB = null;
        this.gbC = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbA = null;
        this.gbB = null;
        this.gbC = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbA = null;
        this.gbB = null;
        this.gbC = null;
        init();
    }

    private void init() {
        bjX();
        bjY();
    }

    private void bjX() {
        this.gbB = new Button(this.mContext);
        this.gbB.setId(1);
        this.gbB.setTextColor(this.gbm);
        this.gbB.setTextSize(0, this.gbj);
        this.gbB.setBackgroundColor(this.gbo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gbe);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gbB, layoutParams);
        this.gbB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VerificationCodeView.this.gbC != null) {
                    VerificationCodeView.this.gbC.bjO();
                }
            }
        });
    }

    private void bjY() {
        this.gbA = new EditText(this.mContext);
        this.gbA.setTextColor(this.gbh);
        this.gbA.setHintTextColor(this.gbi);
        this.gbA.setTextSize(0, this.gbj);
        this.gbA.setGravity(19);
        int paddingBottom = this.gbA.getPaddingBottom();
        this.gbA.setPadding(this.gbb, this.gbA.getPaddingTop(), this.gbA.getPaddingRight(), paddingBottom);
        this.gbA.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || VerificationCodeView.this.bjL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gbA, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gbA, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gbe);
        layoutParams.addRule(0, this.gbB.getId());
        layoutParams.addRule(15);
        a(this.gbA, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gbA, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.fYj)) {
                this.gbB.setText(hVar.fYj);
                this.gbB.setTextSize(0, this.gbj);
                this.gbB.getLayoutParams().height = this.gbe;
                this.gbB.setPadding(this.gbb, 0, this.gbb, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gbA.setHint(hVar.content);
                this.gbA.setTextSize(0, this.gbj);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gbA.getLayoutParams();
                marginLayoutParams.height = this.gbe;
                marginLayoutParams.rightMargin = this.gbb;
                this.gbA.setPadding(this.gbb, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gbA.setText("");
    }

    public void setListener(a aVar) {
        this.gbC = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
