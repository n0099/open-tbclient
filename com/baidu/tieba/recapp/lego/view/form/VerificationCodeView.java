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
    private EditText ilJ;
    private Button ilK;
    private a ilL;

    /* loaded from: classes3.dex */
    public interface a {
        void bXn();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.ilJ = null;
        this.ilK = null;
        this.ilL = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ilJ = null;
        this.ilK = null;
        this.ilL = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilJ = null;
        this.ilK = null;
        this.ilL = null;
        init();
    }

    private void init() {
        bXx();
        bXy();
    }

    private void bXx() {
        this.ilK = new Button(this.mContext);
        this.ilK.setId(1);
        this.ilK.setTextColor(this.ilv);
        this.ilK.setTextSize(0, this.alL);
        this.ilK.setBackgroundColor(this.ilx);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.ilo);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ilK, layoutParams);
        this.ilK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.ilL != null) {
                    VerificationCodeView.this.ilL.bXn();
                }
            }
        });
    }

    private void bXy() {
        this.ilJ = new EditText(this.mContext);
        this.ilJ.setTextColor(this.ilr);
        this.ilJ.setHintTextColor(this.ils);
        this.ilJ.setTextSize(0, this.alL);
        this.ilJ.setGravity(19);
        int paddingBottom = this.ilJ.getPaddingBottom();
        this.ilJ.setPadding(this.ill, this.ilJ.getPaddingTop(), this.ilJ.getPaddingRight(), paddingBottom);
        this.ilJ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bXk()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilJ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilJ, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilo);
        layoutParams.addRule(0, this.ilK.getId());
        layoutParams.addRule(15);
        a(this.ilJ, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ilJ, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iip)) {
                this.ilK.setText(hVar.iip);
                this.ilK.setTextSize(0, this.alL);
                this.ilK.getLayoutParams().height = this.ilo;
                this.ilK.setPadding(this.ill, 0, this.ill, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.ilJ.setHint(hVar.content);
                this.ilJ.setTextSize(0, this.alL);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilJ.getLayoutParams();
                marginLayoutParams.height = this.ilo;
                marginLayoutParams.rightMargin = this.ill;
                this.ilJ.setPadding(this.ill, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ilJ.setText("");
    }

    public void setListener(a aVar) {
        this.ilL = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
