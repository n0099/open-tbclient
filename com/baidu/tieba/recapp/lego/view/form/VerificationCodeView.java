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
/* loaded from: classes8.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText mRv;
    private Button mRw;
    private a mRx;

    /* loaded from: classes8.dex */
    public interface a {
        void dFw();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mRv = null;
        this.mRw = null;
        this.mRx = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRv = null;
        this.mRw = null;
        this.mRx = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRv = null;
        this.mRw = null;
        this.mRx = null;
        init();
    }

    private void init() {
        dFF();
        dFG();
    }

    private void dFF() {
        this.mRw = new Button(this.mContext);
        this.mRw.setId(1);
        this.mRw.setTextColor(this.mRh);
        this.mRw.setTextSize(0, this.cMu);
        this.mRw.setBackgroundColor(this.mRj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mRa);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mRw, layoutParams);
        this.mRw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mRx != null) {
                    VerificationCodeView.this.mRx.dFw();
                }
            }
        });
    }

    private void dFG() {
        this.mRv = new EditText(this.mContext);
        this.mRv.setTextColor(this.mRd);
        this.mRv.setHintTextColor(this.mRe);
        this.mRv.setTextSize(0, this.cMu);
        this.mRv.setGravity(19);
        int paddingBottom = this.mRv.getPaddingBottom();
        this.mRv.setPadding(this.mQX, this.mRv.getPaddingTop(), this.mRv.getPaddingRight(), paddingBottom);
        this.mRv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dFt()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mRv, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mRv, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mRa);
        layoutParams.addRule(0, this.mRw.getId());
        layoutParams.addRule(15);
        a(this.mRv, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mRv, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mOt)) {
                this.mRw.setText(hVar.mOt);
                this.mRw.setTextSize(0, this.cMu);
                this.mRw.getLayoutParams().height = this.mRa;
                this.mRw.setPadding(this.mQX, 0, this.mQX, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mRv.setHint(hVar.content);
                this.mRv.setTextSize(0, this.cMu);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRv.getLayoutParams();
                marginLayoutParams.height = this.mRa;
                marginLayoutParams.rightMargin = this.mQX;
                this.mRv.setPadding(this.mQX, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mRv.setText("");
    }

    public void setListener(a aVar) {
        this.mRx = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFt() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
