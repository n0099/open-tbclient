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
    private Button gJA;
    private a gJB;
    private EditText gJz;

    /* loaded from: classes3.dex */
    public interface a {
        void btk();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gJz = null;
        this.gJA = null;
        this.gJB = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gJz = null;
        this.gJA = null;
        this.gJB = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gJz = null;
        this.gJA = null;
        this.gJB = null;
        init();
    }

    private void init() {
        btu();
        btv();
    }

    private void btu() {
        this.gJA = new Button(this.mContext);
        this.gJA.setId(1);
        this.gJA.setTextColor(this.gJl);
        this.gJA.setTextSize(0, this.mFontSize);
        this.gJA.setBackgroundColor(this.gJn);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gJe);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gJA, layoutParams);
        this.gJA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gJB != null) {
                    VerificationCodeView.this.gJB.btk();
                }
            }
        });
    }

    private void btv() {
        this.gJz = new EditText(this.mContext);
        this.gJz.setTextColor(this.gJh);
        this.gJz.setHintTextColor(this.gJi);
        this.gJz.setTextSize(0, this.mFontSize);
        this.gJz.setGravity(19);
        int paddingBottom = this.gJz.getPaddingBottom();
        this.gJz.setPadding(this.gJb, this.gJz.getPaddingTop(), this.gJz.getPaddingRight(), paddingBottom);
        this.gJz.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bth()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gJz, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gJz, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gJe);
        layoutParams.addRule(0, this.gJA.getId());
        layoutParams.addRule(15);
        a(this.gJz, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gJz, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gGe)) {
                this.gJA.setText(hVar.gGe);
                this.gJA.setTextSize(0, this.mFontSize);
                this.gJA.getLayoutParams().height = this.gJe;
                this.gJA.setPadding(this.gJb, 0, this.gJb, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gJz.setHint(hVar.content);
                this.gJz.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gJz.getLayoutParams();
                marginLayoutParams.height = this.gJe;
                marginLayoutParams.rightMargin = this.gJb;
                this.gJz.setPadding(this.gJb, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gJz.setText("");
    }

    public void setListener(a aVar) {
        this.gJB = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bth() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
