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
    private EditText ilP;
    private Button ilQ;
    private a ilR;

    /* loaded from: classes3.dex */
    public interface a {
        void bXk();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.ilP = null;
        this.ilQ = null;
        this.ilR = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ilP = null;
        this.ilQ = null;
        this.ilR = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilP = null;
        this.ilQ = null;
        this.ilR = null;
        init();
    }

    private void init() {
        bXu();
        bXv();
    }

    private void bXu() {
        this.ilQ = new Button(this.mContext);
        this.ilQ.setId(1);
        this.ilQ.setTextColor(this.ilB);
        this.ilQ.setTextSize(0, this.alK);
        this.ilQ.setBackgroundColor(this.ilD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.ilu);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ilQ, layoutParams);
        this.ilQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.ilR != null) {
                    VerificationCodeView.this.ilR.bXk();
                }
            }
        });
    }

    private void bXv() {
        this.ilP = new EditText(this.mContext);
        this.ilP.setTextColor(this.ilx);
        this.ilP.setHintTextColor(this.ily);
        this.ilP.setTextSize(0, this.alK);
        this.ilP.setGravity(19);
        int paddingBottom = this.ilP.getPaddingBottom();
        this.ilP.setPadding(this.ilr, this.ilP.getPaddingTop(), this.ilP.getPaddingRight(), paddingBottom);
        this.ilP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bXh()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilP, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilP, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilu);
        layoutParams.addRule(0, this.ilQ.getId());
        layoutParams.addRule(15);
        a(this.ilP, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ilP, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iiu)) {
                this.ilQ.setText(hVar.iiu);
                this.ilQ.setTextSize(0, this.alK);
                this.ilQ.getLayoutParams().height = this.ilu;
                this.ilQ.setPadding(this.ilr, 0, this.ilr, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.ilP.setHint(hVar.content);
                this.ilP.setTextSize(0, this.alK);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilP.getLayoutParams();
                marginLayoutParams.height = this.ilu;
                marginLayoutParams.rightMargin = this.ilr;
                this.ilP.setPadding(this.ilr, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ilP.setText("");
    }

    public void setListener(a aVar) {
        this.ilR = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXh() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
