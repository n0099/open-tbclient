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
    private EditText mMn;
    private Button mMo;
    private a mMp;

    /* loaded from: classes26.dex */
    public interface a {
        void dFG();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.mMn = null;
        this.mMo = null;
        this.mMp = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMn = null;
        this.mMo = null;
        this.mMp = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMn = null;
        this.mMo = null;
        this.mMp = null;
        init();
    }

    private void init() {
        dFP();
        dFQ();
    }

    private void dFP() {
        this.mMo = new Button(this.mContext);
        this.mMo.setId(1);
        this.mMo.setTextColor(this.mLZ);
        this.mMo.setTextSize(0, this.cHF);
        this.mMo.setBackgroundColor(this.mMb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mLS);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.mMo, layoutParams);
        this.mMo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.mMp != null) {
                    VerificationCodeView.this.mMp.dFG();
                }
            }
        });
    }

    private void dFQ() {
        this.mMn = new EditText(this.mContext);
        this.mMn.setTextColor(this.mLV);
        this.mMn.setHintTextColor(this.mLW);
        this.mMn.setTextSize(0, this.cHF);
        this.mMn.setGravity(19);
        int paddingBottom = this.mMn.getPaddingBottom();
        this.mMn.setPadding(this.mLP, this.mMn.getPaddingTop(), this.mMn.getPaddingRight(), paddingBottom);
        this.mMn.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dFD()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.mMn, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.mMn, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mLS);
        layoutParams.addRule(0, this.mMo.getId());
        layoutParams.addRule(15);
        a(this.mMn, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.mMn, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.mJm)) {
                this.mMo.setText(hVar.mJm);
                this.mMo.setTextSize(0, this.cHF);
                this.mMo.getLayoutParams().height = this.mLS;
                this.mMo.setPadding(this.mLP, 0, this.mLP, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.mMn.setHint(hVar.content);
                this.mMn.setTextSize(0, this.cHF);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMn.getLayoutParams();
                marginLayoutParams.height = this.mLS;
                marginLayoutParams.rightMargin = this.mLP;
                this.mMn.setPadding(this.mLP, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.mMn.setText("");
    }

    public void setListener(a aVar) {
        this.mMp = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFD() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
