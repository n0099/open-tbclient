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
    private EditText kwc;
    private Button kwd;
    private a kwe;

    /* loaded from: classes13.dex */
    public interface a {
        void cNQ();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.kwc = null;
        this.kwd = null;
        this.kwe = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kwc = null;
        this.kwd = null;
        this.kwe = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kwc = null;
        this.kwd = null;
        this.kwe = null;
        init();
    }

    private void init() {
        cNZ();
        cOa();
    }

    private void cNZ() {
        this.kwd = new Button(this.mContext);
        this.kwd.setId(1);
        this.kwd.setTextColor(this.kvO);
        this.kwd.setTextSize(0, this.bFr);
        this.kwd.setBackgroundColor(this.kvQ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.kvH);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.kwd, layoutParams);
        this.kwd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.kwe != null) {
                    VerificationCodeView.this.kwe.cNQ();
                }
            }
        });
    }

    private void cOa() {
        this.kwc = new EditText(this.mContext);
        this.kwc.setTextColor(this.kvK);
        this.kwc.setHintTextColor(this.kvL);
        this.kwc.setTextSize(0, this.bFr);
        this.kwc.setGravity(19);
        int paddingBottom = this.kwc.getPaddingBottom();
        this.kwc.setPadding(this.kvE, this.kwc.getPaddingTop(), this.kwc.getPaddingRight(), paddingBottom);
        this.kwc.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.cNN()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.kwc, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.kwc, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kvH);
        layoutParams.addRule(0, this.kwd.getId());
        layoutParams.addRule(15);
        a(this.kwc, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.kwc, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.ksX)) {
                this.kwd.setText(hVar.ksX);
                this.kwd.setTextSize(0, this.bFr);
                this.kwd.getLayoutParams().height = this.kvH;
                this.kwd.setPadding(this.kvE, 0, this.kvE, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.kwc.setHint(hVar.content);
                this.kwc.setTextSize(0, this.bFr);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kwc.getLayoutParams();
                marginLayoutParams.height = this.kvH;
                marginLayoutParams.rightMargin = this.kvE;
                this.kwc.setPadding(this.kvE, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.kwc.setText("");
    }

    public void setListener(a aVar) {
        this.kwe = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNN() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
