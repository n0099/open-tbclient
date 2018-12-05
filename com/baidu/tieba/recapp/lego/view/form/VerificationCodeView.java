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
    private EditText gQp;
    private Button gQq;
    private a gQr;

    /* loaded from: classes3.dex */
    public interface a {
        void bvd();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gQp = null;
        this.gQq = null;
        this.gQr = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gQp = null;
        this.gQq = null;
        this.gQr = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gQp = null;
        this.gQq = null;
        this.gQr = null;
        init();
    }

    private void init() {
        bvn();
        bvo();
    }

    private void bvn() {
        this.gQq = new Button(this.mContext);
        this.gQq.setId(1);
        this.gQq.setTextColor(this.gQb);
        this.gQq.setTextSize(0, this.mFontSize);
        this.gQq.setBackgroundColor(this.gQd);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gPU);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gQq, layoutParams);
        this.gQq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gQr != null) {
                    VerificationCodeView.this.gQr.bvd();
                }
            }
        });
    }

    private void bvo() {
        this.gQp = new EditText(this.mContext);
        this.gQp.setTextColor(this.gPX);
        this.gQp.setHintTextColor(this.gPY);
        this.gQp.setTextSize(0, this.mFontSize);
        this.gQp.setGravity(19);
        int paddingBottom = this.gQp.getPaddingBottom();
        this.gQp.setPadding(this.gPR, this.gQp.getPaddingTop(), this.gQp.getPaddingRight(), paddingBottom);
        this.gQp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bva()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gQp, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gQp, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gPU);
        layoutParams.addRule(0, this.gQq.getId());
        layoutParams.addRule(15);
        a(this.gQp, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gQp, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gMU)) {
                this.gQq.setText(hVar.gMU);
                this.gQq.setTextSize(0, this.mFontSize);
                this.gQq.getLayoutParams().height = this.gPU;
                this.gQq.setPadding(this.gPR, 0, this.gPR, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gQp.setHint(hVar.content);
                this.gQp.setTextSize(0, this.mFontSize);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gQp.getLayoutParams();
                marginLayoutParams.height = this.gPU;
                marginLayoutParams.rightMargin = this.gPR;
                this.gQp.setPadding(this.gPR, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gQp.setText("");
    }

    public void setListener(a aVar) {
        this.gQr = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bva() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
