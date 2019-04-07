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
    private EditText ilv;
    private Button ilw;
    private a ilx;

    /* loaded from: classes3.dex */
    public interface a {
        void bXj();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.ilv = null;
        this.ilw = null;
        this.ilx = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ilv = null;
        this.ilw = null;
        this.ilx = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilv = null;
        this.ilw = null;
        this.ilx = null;
        init();
    }

    private void init() {
        bXt();
        bXu();
    }

    private void bXt() {
        this.ilw = new Button(this.mContext);
        this.ilw.setId(1);
        this.ilw.setTextColor(this.ilh);
        this.ilw.setTextSize(0, this.alP);
        this.ilw.setBackgroundColor(this.ilj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.ila);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ilw, layoutParams);
        this.ilw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.ilx != null) {
                    VerificationCodeView.this.ilx.bXj();
                }
            }
        });
    }

    private void bXu() {
        this.ilv = new EditText(this.mContext);
        this.ilv.setTextColor(this.ild);
        this.ilv.setHintTextColor(this.ile);
        this.ilv.setTextSize(0, this.alP);
        this.ilv.setGravity(19);
        int paddingBottom = this.ilv.getPaddingBottom();
        this.ilv.setPadding(this.ikX, this.ilv.getPaddingTop(), this.ilv.getPaddingRight(), paddingBottom);
        this.ilv.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bXg()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilv, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilv, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ila);
        layoutParams.addRule(0, this.ilw.getId());
        layoutParams.addRule(15);
        a(this.ilv, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ilv, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iib)) {
                this.ilw.setText(hVar.iib);
                this.ilw.setTextSize(0, this.alP);
                this.ilw.getLayoutParams().height = this.ila;
                this.ilw.setPadding(this.ikX, 0, this.ikX, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.ilv.setHint(hVar.content);
                this.ilv.setTextSize(0, this.alP);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilv.getLayoutParams();
                marginLayoutParams.height = this.ila;
                marginLayoutParams.rightMargin = this.ikX;
                this.ilv.setPadding(this.ikX, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ilv.setText("");
    }

    public void setListener(a aVar) {
        this.ilx = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXg() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
