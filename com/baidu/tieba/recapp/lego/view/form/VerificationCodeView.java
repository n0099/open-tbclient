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
    private EditText gUn;
    private Button gUo;
    private a gUp;

    /* loaded from: classes3.dex */
    public interface a {
        void bwx();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gUn = null;
        this.gUo = null;
        this.gUp = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gUn = null;
        this.gUo = null;
        this.gUp = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gUn = null;
        this.gUo = null;
        this.gUp = null;
        init();
    }

    private void init() {
        bwH();
        bwI();
    }

    private void bwH() {
        this.gUo = new Button(this.mContext);
        this.gUo.setId(1);
        this.gUo.setTextColor(this.gTZ);
        this.gUo.setTextSize(0, this.mFontSize);
        this.gUo.setBackgroundColor(this.gUb);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gTS);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gUo, layoutParams);
        this.gUo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gUp != null) {
                    VerificationCodeView.this.gUp.bwx();
                }
            }
        });
    }

    private void bwI() {
        this.gUn = new EditText(this.mContext);
        this.gUn.setTextColor(this.gTV);
        this.gUn.setHintTextColor(this.gTW);
        this.gUn.setTextSize(0, this.mFontSize);
        this.gUn.setGravity(19);
        int paddingBottom = this.gUn.getPaddingBottom();
        this.gUn.setPadding(this.gTP, this.gUn.getPaddingTop(), this.gUn.getPaddingRight(), paddingBottom);
        this.gUn.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bwu()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gUn, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gUn, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gTS);
        layoutParams.addRule(0, this.gUo.getId());
        layoutParams.addRule(15);
        a(this.gUn, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gUn, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gQQ)) {
                this.gUo.setText(hVar.gQQ);
                this.gUo.setTextSize(0, this.mFontSize);
                this.gUo.getLayoutParams().height = this.gTS;
                this.gUo.setPadding(this.gTP, 0, this.gTP, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gUn.setHint(hVar.content);
                this.gUn.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gUn.getLayoutParams();
                marginLayoutParams.height = this.gTS;
                marginLayoutParams.rightMargin = this.gTP;
                this.gUn.setPadding(this.gTP, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gUn.setText("");
    }

    public void setListener(a aVar) {
        this.gUp = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bwu() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
