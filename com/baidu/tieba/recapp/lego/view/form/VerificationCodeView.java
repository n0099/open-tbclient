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
    private EditText gbD;
    private Button gbE;
    private a gbF;

    /* loaded from: classes3.dex */
    public interface a {
        void bjO();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gbD = null;
        this.gbE = null;
        this.gbF = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gbD = null;
        this.gbE = null;
        this.gbF = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbD = null;
        this.gbE = null;
        this.gbF = null;
        init();
    }

    private void init() {
        bjX();
        bjY();
    }

    private void bjX() {
        this.gbE = new Button(this.mContext);
        this.gbE.setId(1);
        this.gbE.setTextColor(this.gbp);
        this.gbE.setTextSize(0, this.gbm);
        this.gbE.setBackgroundColor(this.gbr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gbh);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gbE, layoutParams);
        this.gbE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VerificationCodeView.this.gbF != null) {
                    VerificationCodeView.this.gbF.bjO();
                }
            }
        });
    }

    private void bjY() {
        this.gbD = new EditText(this.mContext);
        this.gbD.setTextColor(this.gbk);
        this.gbD.setHintTextColor(this.gbl);
        this.gbD.setTextSize(0, this.gbm);
        this.gbD.setGravity(19);
        int paddingBottom = this.gbD.getPaddingBottom();
        this.gbD.setPadding(this.gbe, this.gbD.getPaddingTop(), this.gbD.getPaddingRight(), paddingBottom);
        this.gbD.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || VerificationCodeView.this.bjL()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gbD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gbD, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gbh);
        layoutParams.addRule(0, this.gbE.getId());
        layoutParams.addRule(15);
        a(this.gbD, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gbD, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.fYm)) {
                this.gbE.setText(hVar.fYm);
                this.gbE.setTextSize(0, this.gbm);
                this.gbE.getLayoutParams().height = this.gbh;
                this.gbE.setPadding(this.gbe, 0, this.gbe, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gbD.setHint(hVar.content);
                this.gbD.setTextSize(0, this.gbm);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gbD.getLayoutParams();
                marginLayoutParams.height = this.gbh;
                marginLayoutParams.rightMargin = this.gbe;
                this.gbD.setPadding(this.gbe, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gbD.setText("");
    }

    public void setListener(a aVar) {
        this.gbF = aVar;
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
