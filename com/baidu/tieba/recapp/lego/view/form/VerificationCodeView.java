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
    private EditText mWd;
    private Button mWe;
    private a mWf;

    /* loaded from: classes8.dex */
    public interface a {
        void dDM();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mWd = null;
        this.mWe = null;
        this.mWf = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mWd = null;
        this.mWe = null;
        this.mWf = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mWd = null;
        this.mWe = null;
        this.mWf = null;
        init();
    }

    private void init() {
        dDV();
        dDW();
    }

    private void dDV() {
        this.mWe = new Button(this.mContext);
        this.mWe.setId(1);
        this.mWe.setTextColor(this.mButtonFontColor);
        this.mWe.setTextSize(0, this.cKa);
        this.mWe.setBackgroundColor(this.mVR);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mVJ);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mWe, layoutParams);
        this.mWe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mWf != null) {
                    VerificationCodeView.this.mWf.dDM();
                }
            }
        });
    }

    private void dDW() {
        this.mWd = new EditText(this.mContext);
        this.mWd.setTextColor(this.mVM);
        this.mWd.setHintTextColor(this.mVN);
        this.mWd.setTextSize(0, this.cKa);
        this.mWd.setGravity(19);
        int paddingBottom = this.mWd.getPaddingBottom();
        this.mWd.setPadding(this.mVG, this.mWd.getPaddingTop(), this.mWd.getPaddingRight(), paddingBottom);
        this.mWd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dDJ()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mWd, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mWd, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mVJ);
        layoutParams.addRule(0, this.mWe.getId());
        layoutParams.addRule(15);
        a(this.mWd, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mWd, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mSY)) {
                this.mWe.setText(hVar.mSY);
                this.mWe.setTextSize(0, this.cKa);
                this.mWe.getLayoutParams().height = this.mVJ;
                this.mWe.setPadding(this.mVG, 0, this.mVG, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mWd.setHint(hVar.content);
                this.mWd.setTextSize(0, this.cKa);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWd.getLayoutParams();
                marginLayoutParams.height = this.mVJ;
                marginLayoutParams.rightMargin = this.mVG;
                this.mWd.setPadding(this.mVG, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mWd.setText("");
    }

    public void setListener(a aVar) {
        this.mWf = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDJ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
