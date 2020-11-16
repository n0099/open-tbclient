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
/* loaded from: classes25.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText mxZ;
    private Button mya;
    private a myb;

    /* loaded from: classes25.dex */
    public interface a {
        void dAo();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mxZ = null;
        this.mya = null;
        this.myb = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mxZ = null;
        this.mya = null;
        this.myb = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mxZ = null;
        this.mya = null;
        this.myb = null;
        init();
    }

    private void init() {
        dAx();
        dAy();
    }

    private void dAx() {
        this.mya = new Button(this.mContext);
        this.mya.setId(1);
        this.mya.setTextColor(this.mxL);
        this.mya.setTextSize(0, this.cAJ);
        this.mya.setBackgroundColor(this.mxN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mxE);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mya, layoutParams);
        this.mya.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.myb != null) {
                    VerificationCodeView.this.myb.dAo();
                }
            }
        });
    }

    private void dAy() {
        this.mxZ = new EditText(this.mContext);
        this.mxZ.setTextColor(this.mxH);
        this.mxZ.setHintTextColor(this.mxI);
        this.mxZ.setTextSize(0, this.cAJ);
        this.mxZ.setGravity(19);
        int paddingBottom = this.mxZ.getPaddingBottom();
        this.mxZ.setPadding(this.mxB, this.mxZ.getPaddingTop(), this.mxZ.getPaddingRight(), paddingBottom);
        this.mxZ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dAl()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mxZ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mxZ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mxE);
        layoutParams.addRule(0, this.mya.getId());
        layoutParams.addRule(15);
        a(this.mxZ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mxZ, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.muY)) {
                this.mya.setText(hVar.muY);
                this.mya.setTextSize(0, this.cAJ);
                this.mya.getLayoutParams().height = this.mxE;
                this.mya.setPadding(this.mxB, 0, this.mxB, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mxZ.setHint(hVar.content);
                this.mxZ.setTextSize(0, this.cAJ);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mxZ.getLayoutParams();
                marginLayoutParams.height = this.mxE;
                marginLayoutParams.rightMargin = this.mxB;
                this.mxZ.setPadding(this.mxB, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mxZ.setText("");
    }

    public void setListener(a aVar) {
        this.myb = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dAl() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
