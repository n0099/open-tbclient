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
    private EditText gtb;
    private Button gtc;
    private a gtd;

    /* loaded from: classes3.dex */
    public interface a {
        void bnR();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gtb = null;
        this.gtc = null;
        this.gtd = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtb = null;
        this.gtc = null;
        this.gtd = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtb = null;
        this.gtc = null;
        this.gtd = null;
        init();
    }

    private void init() {
        bob();
        boc();
    }

    private void bob() {
        this.gtc = new Button(this.mContext);
        this.gtc.setId(1);
        this.gtc.setTextColor(this.gsN);
        this.gtc.setTextSize(0, this.gsK);
        this.gtc.setBackgroundColor(this.gsP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gsF);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gtc, layoutParams);
        this.gtc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.gtd != null) {
                    VerificationCodeView.this.gtd.bnR();
                }
            }
        });
    }

    private void boc() {
        this.gtb = new EditText(this.mContext);
        this.gtb.setTextColor(this.gsI);
        this.gtb.setHintTextColor(this.gsJ);
        this.gtb.setTextSize(0, this.gsK);
        this.gtb.setGravity(19);
        int paddingBottom = this.gtb.getPaddingBottom();
        this.gtb.setPadding(this.gsC, this.gtb.getPaddingTop(), this.gtb.getPaddingRight(), paddingBottom);
        this.gtb.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bnO()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gtb, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gtb, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gsF);
        layoutParams.addRule(0, this.gtc.getId());
        layoutParams.addRule(15);
        a(this.gtb, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gtb, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gpH)) {
                this.gtc.setText(hVar.gpH);
                this.gtc.setTextSize(0, this.gsK);
                this.gtc.getLayoutParams().height = this.gsF;
                this.gtc.setPadding(this.gsC, 0, this.gsC, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gtb.setHint(hVar.content);
                this.gtb.setTextSize(0, this.gsK);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gtb.getLayoutParams();
                marginLayoutParams.height = this.gsF;
                marginLayoutParams.rightMargin = this.gsC;
                this.gtb.setPadding(this.gsC, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gtb.setText("");
    }

    public void setListener(a aVar) {
        this.gtd = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bnO() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
