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
/* loaded from: classes26.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText mfq;
    private Button mfr;
    private a mfs;

    /* loaded from: classes26.dex */
    public interface a {
        void dvi();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mfq = null;
        this.mfr = null;
        this.mfs = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mfq = null;
        this.mfr = null;
        this.mfs = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mfq = null;
        this.mfr = null;
        this.mfs = null;
        init();
    }

    private void init() {
        dvr();
        dvs();
    }

    private void dvr() {
        this.mfr = new Button(this.mContext);
        this.mfr.setId(1);
        this.mfr.setTextColor(this.mfc);
        this.mfr.setTextSize(0, this.cnX);
        this.mfr.setBackgroundColor(this.mfe);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.meV);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mfr, layoutParams);
        this.mfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mfs != null) {
                    VerificationCodeView.this.mfs.dvi();
                }
            }
        });
    }

    private void dvs() {
        this.mfq = new EditText(this.mContext);
        this.mfq.setTextColor(this.meY);
        this.mfq.setHintTextColor(this.meZ);
        this.mfq.setTextSize(0, this.cnX);
        this.mfq.setGravity(19);
        int paddingBottom = this.mfq.getPaddingBottom();
        this.mfq.setPadding(this.meS, this.mfq.getPaddingTop(), this.mfq.getPaddingRight(), paddingBottom);
        this.mfq.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dvf()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mfq, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mfq, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.meV);
        layoutParams.addRule(0, this.mfr.getId());
        layoutParams.addRule(15);
        a(this.mfq, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mfq, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mcl)) {
                this.mfr.setText(hVar.mcl);
                this.mfr.setTextSize(0, this.cnX);
                this.mfr.getLayoutParams().height = this.meV;
                this.mfr.setPadding(this.meS, 0, this.meS, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mfq.setHint(hVar.content);
                this.mfq.setTextSize(0, this.cnX);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mfq.getLayoutParams();
                marginLayoutParams.height = this.meV;
                marginLayoutParams.rightMargin = this.meS;
                this.mfq.setPadding(this.meS, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mfq.setText("");
    }

    public void setListener(a aVar) {
        this.mfs = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dvf() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
