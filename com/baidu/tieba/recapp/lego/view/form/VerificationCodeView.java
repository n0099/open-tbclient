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
    private EditText iMe;
    private Button iMf;
    private a iMg;

    /* loaded from: classes3.dex */
    public interface a {
        void cgp();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iMe = null;
        this.iMf = null;
        this.iMg = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iMe = null;
        this.iMf = null;
        this.iMg = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iMe = null;
        this.iMf = null;
        this.iMg = null;
        init();
    }

    private void init() {
        cgz();
        cgA();
    }

    private void cgz() {
        this.iMf = new Button(this.mContext);
        this.iMf.setId(1);
        this.iMf.setTextColor(this.iLQ);
        this.iMf.setTextSize(0, this.aGd);
        this.iMf.setBackgroundColor(this.iLS);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iLJ);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iMf, layoutParams);
        this.iMf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iMg != null) {
                    VerificationCodeView.this.iMg.cgp();
                }
            }
        });
    }

    private void cgA() {
        this.iMe = new EditText(this.mContext);
        this.iMe.setTextColor(this.iLM);
        this.iMe.setHintTextColor(this.iLN);
        this.iMe.setTextSize(0, this.aGd);
        this.iMe.setGravity(19);
        int paddingBottom = this.iMe.getPaddingBottom();
        this.iMe.setPadding(this.iLG, this.iMe.getPaddingTop(), this.iMe.getPaddingRight(), paddingBottom);
        this.iMe.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cgm()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iMe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iMe, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iLJ);
        layoutParams.addRule(0, this.iMf.getId());
        layoutParams.addRule(15);
        a(this.iMe, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iMe, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iIJ)) {
                this.iMf.setText(hVar.iIJ);
                this.iMf.setTextSize(0, this.aGd);
                this.iMf.getLayoutParams().height = this.iLJ;
                this.iMf.setPadding(this.iLG, 0, this.iLG, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iMe.setHint(hVar.content);
                this.iMe.setTextSize(0, this.aGd);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iMe.getLayoutParams();
                marginLayoutParams.height = this.iLJ;
                marginLayoutParams.rightMargin = this.iLG;
                this.iMe.setPadding(this.iLG, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iMe.setText("");
    }

    public void setListener(a aVar) {
        this.iMg = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgm() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
