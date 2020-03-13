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
/* loaded from: classes13.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText jLk;
    private Button jLl;
    private a jLm;

    /* loaded from: classes13.dex */
    public interface a {
        void cDb();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.jLk = null;
        this.jLl = null;
        this.jLm = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jLk = null;
        this.jLl = null;
        this.jLm = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jLk = null;
        this.jLl = null;
        this.jLm = null;
        init();
    }

    private void init() {
        cDj();
        cDk();
    }

    private void cDj() {
        this.jLl = new Button(this.mContext);
        this.jLl.setId(1);
        this.jLl.setTextColor(this.jKW);
        this.jLl.setTextSize(0, this.bgT);
        this.jLl.setBackgroundColor(this.jKY);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.jKP);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jLl, layoutParams);
        this.jLl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.jLm != null) {
                    VerificationCodeView.this.jLm.cDb();
                }
            }
        });
    }

    private void cDk() {
        this.jLk = new EditText(this.mContext);
        this.jLk.setTextColor(this.jKS);
        this.jLk.setHintTextColor(this.jKT);
        this.jLk.setTextSize(0, this.bgT);
        this.jLk.setGravity(19);
        int paddingBottom = this.jLk.getPaddingBottom();
        this.jLk.setPadding(this.jKM, this.jLk.getPaddingTop(), this.jLk.getPaddingRight(), paddingBottom);
        this.jLk.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cCY()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.jLk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.jLk, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKP);
        layoutParams.addRule(0, this.jLl.getId());
        layoutParams.addRule(15);
        a(this.jLk, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jLk, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.jHM)) {
                this.jLl.setText(hVar.jHM);
                this.jLl.setTextSize(0, this.bgT);
                this.jLl.getLayoutParams().height = this.jKP;
                this.jLl.setPadding(this.jKM, 0, this.jKM, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.jLk.setHint(hVar.content);
                this.jLk.setTextSize(0, this.bgT);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jLk.getLayoutParams();
                marginLayoutParams.height = this.jKP;
                marginLayoutParams.rightMargin = this.jKM;
                this.jLk.setPadding(this.jKM, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jLk.setText("");
    }

    public void setListener(a aVar) {
        this.jLm = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCY() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
