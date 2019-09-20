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
    private EditText iOd;
    private Button iOe;
    private a iOf;

    /* loaded from: classes3.dex */
    public interface a {
        void cjn();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.iOd = null;
        this.iOe = null;
        this.iOf = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iOd = null;
        this.iOe = null;
        this.iOf = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iOd = null;
        this.iOe = null;
        this.iOf = null;
        init();
    }

    private void init() {
        cjx();
        cjy();
    }

    private void cjx() {
        this.iOe = new Button(this.mContext);
        this.iOe.setId(1);
        this.iOe.setTextColor(this.iNP);
        this.iOe.setTextSize(0, this.and);
        this.iOe.setBackgroundColor(this.iNR);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.iNI);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.iOe, layoutParams);
        this.iOe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.iOf != null) {
                    VerificationCodeView.this.iOf.cjn();
                }
            }
        });
    }

    private void cjy() {
        this.iOd = new EditText(this.mContext);
        this.iOd.setTextColor(this.iNL);
        this.iOd.setHintTextColor(this.iNM);
        this.iOd.setTextSize(0, this.and);
        this.iOd.setGravity(19);
        int paddingBottom = this.iOd.getPaddingBottom();
        this.iOd.setPadding(this.iNF, this.iOd.getPaddingTop(), this.iOd.getPaddingRight(), paddingBottom);
        this.iOd.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cjk()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.iOd, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.iOd, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.iNI);
        layoutParams.addRule(0, this.iOe.getId());
        layoutParams.addRule(15);
        a(this.iOd, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.iOd, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iKJ)) {
                this.iOe.setText(hVar.iKJ);
                this.iOe.setTextSize(0, this.and);
                this.iOe.getLayoutParams().height = this.iNI;
                this.iOe.setPadding(this.iNF, 0, this.iNF, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.iOd.setHint(hVar.content);
                this.iOd.setTextSize(0, this.and);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iOd.getLayoutParams();
                marginLayoutParams.height = this.iNI;
                marginLayoutParams.rightMargin = this.iNF;
                this.iOd.setPadding(this.iNF, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.iOd.setText("");
    }

    public void setListener(a aVar) {
        this.iOf = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cjk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
