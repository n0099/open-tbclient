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
    private EditText mRw;
    private Button mRx;
    private a mRy;

    /* loaded from: classes8.dex */
    public interface a {
        void dFv();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mRw = null;
        this.mRx = null;
        this.mRy = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRw = null;
        this.mRx = null;
        this.mRy = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRw = null;
        this.mRx = null;
        this.mRy = null;
        init();
    }

    private void init() {
        dFE();
        dFF();
    }

    private void dFE() {
        this.mRx = new Button(this.mContext);
        this.mRx.setId(1);
        this.mRx.setTextColor(this.mRi);
        this.mRx.setTextSize(0, this.cMu);
        this.mRx.setBackgroundColor(this.mRk);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mRb);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mRx, layoutParams);
        this.mRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mRy != null) {
                    VerificationCodeView.this.mRy.dFv();
                }
            }
        });
    }

    private void dFF() {
        this.mRw = new EditText(this.mContext);
        this.mRw.setTextColor(this.mRe);
        this.mRw.setHintTextColor(this.mRf);
        this.mRw.setTextSize(0, this.cMu);
        this.mRw.setGravity(19);
        int paddingBottom = this.mRw.getPaddingBottom();
        this.mRw.setPadding(this.mQY, this.mRw.getPaddingTop(), this.mRw.getPaddingRight(), paddingBottom);
        this.mRw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dFs()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mRw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mRw, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mRb);
        layoutParams.addRule(0, this.mRx.getId());
        layoutParams.addRule(15);
        a(this.mRw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mRw, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mOu)) {
                this.mRx.setText(hVar.mOu);
                this.mRx.setTextSize(0, this.cMu);
                this.mRx.getLayoutParams().height = this.mRb;
                this.mRx.setPadding(this.mQY, 0, this.mQY, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mRw.setHint(hVar.content);
                this.mRw.setTextSize(0, this.cMu);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRw.getLayoutParams();
                marginLayoutParams.height = this.mRb;
                marginLayoutParams.rightMargin = this.mQY;
                this.mRw.setPadding(this.mQY, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mRw.setText("");
    }

    public void setListener(a aVar) {
        this.mRy = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFs() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
