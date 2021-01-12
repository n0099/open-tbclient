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
/* loaded from: classes7.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText mMP;
    private Button mMQ;
    private a mMR;

    /* loaded from: classes7.dex */
    public interface a {
        void dBE();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mMP = null;
        this.mMQ = null;
        this.mMR = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMP = null;
        this.mMQ = null;
        this.mMR = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMP = null;
        this.mMQ = null;
        this.mMR = null;
        init();
    }

    private void init() {
        dBN();
        dBO();
    }

    private void dBN() {
        this.mMQ = new Button(this.mContext);
        this.mMQ.setId(1);
        this.mMQ.setTextColor(this.mMB);
        this.mMQ.setTextSize(0, this.cHI);
        this.mMQ.setBackgroundColor(this.mMD);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mMu);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mMQ, layoutParams);
        this.mMQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mMR != null) {
                    VerificationCodeView.this.mMR.dBE();
                }
            }
        });
    }

    private void dBO() {
        this.mMP = new EditText(this.mContext);
        this.mMP.setTextColor(this.mMx);
        this.mMP.setHintTextColor(this.mMy);
        this.mMP.setTextSize(0, this.cHI);
        this.mMP.setGravity(19);
        int paddingBottom = this.mMP.getPaddingBottom();
        this.mMP.setPadding(this.mMr, this.mMP.getPaddingTop(), this.mMP.getPaddingRight(), paddingBottom);
        this.mMP.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dBB()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mMP, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mMP, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mMu);
        layoutParams.addRule(0, this.mMQ.getId());
        layoutParams.addRule(15);
        a(this.mMP, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mMP, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mJP)) {
                this.mMQ.setText(hVar.mJP);
                this.mMQ.setTextSize(0, this.cHI);
                this.mMQ.getLayoutParams().height = this.mMu;
                this.mMQ.setPadding(this.mMr, 0, this.mMr, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mMP.setHint(hVar.content);
                this.mMP.setTextSize(0, this.cHI);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMP.getLayoutParams();
                marginLayoutParams.height = this.mMu;
                marginLayoutParams.rightMargin = this.mMr;
                this.mMP.setPadding(this.mMr, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mMP.setText("");
    }

    public void setListener(a aVar) {
        this.mMR = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dBB() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
