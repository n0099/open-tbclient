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
    private EditText jKW;
    private Button jKX;
    private a jKY;

    /* loaded from: classes13.dex */
    public interface a {
        void cCY();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.jKW = null;
        this.jKX = null;
        this.jKY = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jKW = null;
        this.jKX = null;
        this.jKY = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jKW = null;
        this.jKX = null;
        this.jKY = null;
        init();
    }

    private void init() {
        cDg();
        cDh();
    }

    private void cDg() {
        this.jKX = new Button(this.mContext);
        this.jKX.setId(1);
        this.jKX.setTextColor(this.jKI);
        this.jKX.setTextSize(0, this.bgR);
        this.jKX.setBackgroundColor(this.jKK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.jKB);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.jKX, layoutParams);
        this.jKX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.jKY != null) {
                    VerificationCodeView.this.jKY.cCY();
                }
            }
        });
    }

    private void cDh() {
        this.jKW = new EditText(this.mContext);
        this.jKW.setTextColor(this.jKE);
        this.jKW.setHintTextColor(this.jKF);
        this.jKW.setTextSize(0, this.bgR);
        this.jKW.setGravity(19);
        int paddingBottom = this.jKW.getPaddingBottom();
        this.jKW.setPadding(this.jKy, this.jKW.getPaddingTop(), this.jKW.getPaddingRight(), paddingBottom);
        this.jKW.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cCV()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.jKW, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.jKW, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKB);
        layoutParams.addRule(0, this.jKX.getId());
        layoutParams.addRule(15);
        a(this.jKW, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.jKW, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.jHy)) {
                this.jKX.setText(hVar.jHy);
                this.jKX.setTextSize(0, this.bgR);
                this.jKX.getLayoutParams().height = this.jKB;
                this.jKX.setPadding(this.jKy, 0, this.jKy, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.jKW.setHint(hVar.content);
                this.jKW.setTextSize(0, this.bgR);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKW.getLayoutParams();
                marginLayoutParams.height = this.jKB;
                marginLayoutParams.rightMargin = this.jKy;
                this.jKW.setPadding(this.jKy, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.jKW.setText("");
    }

    public void setListener(a aVar) {
        this.jKY = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCV() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
