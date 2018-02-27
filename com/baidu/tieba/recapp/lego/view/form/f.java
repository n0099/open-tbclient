package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormItemBaseView;
/* loaded from: classes3.dex */
public class f extends FormItemBaseView {
    private EditText gGp;
    private Button gGq;
    private a gGr;

    /* loaded from: classes3.dex */
    public interface a {
        void boH();
    }

    public f(Context context) {
        super(context);
        this.gGp = null;
        this.gGq = null;
        this.gGr = null;
        init();
    }

    private void init() {
        boP();
        boQ();
    }

    private void boP() {
        this.gGq = new Button(this.mContext);
        this.gGq.setId(1);
        this.gGq.setTextColor(this.gGa);
        this.gGq.setTextSize(0, this.gFX);
        this.gGq.setBackgroundColor(this.gGc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gFS);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gGq, layoutParams);
        this.gGq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gGr != null) {
                    f.this.gGr.boH();
                }
            }
        });
    }

    private void boQ() {
        this.gGp = new EditText(this.mContext);
        this.gGp.setTextColor(this.gFV);
        this.gGp.setHintTextColor(this.gFW);
        this.gGp.setTextSize(0, this.gFX);
        this.gGp.setGravity(19);
        int paddingBottom = this.gGp.getPaddingBottom();
        this.gGp.setPadding(this.gFP, this.gGp.getPaddingTop(), this.gGp.getPaddingRight(), paddingBottom);
        this.gGp.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.f.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || f.this.boE()) {
                    f.this.a(f.this.gGp, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    f.this.a(f.this.gGp, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gFS);
        layoutParams.addRule(0, this.gGq.getId());
        layoutParams.addRule(15);
        a(this.gGp, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gGp, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gDi)) {
                this.gGq.setText(hVar.gDi);
                this.gGq.setTextSize(0, this.gFX);
                this.gGq.getLayoutParams().height = this.gFS;
                this.gGq.setPadding(this.gFP, 0, this.gFP, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gGp.setHint(hVar.content);
                this.gGp.setTextSize(0, this.gFX);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGp.getLayoutParams();
                marginLayoutParams.height = this.gFS;
                marginLayoutParams.rightMargin = this.gFP;
                this.gGp.setPadding(this.gFP, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gGp.setText("");
    }

    public void setListener(a aVar) {
        this.gGr = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boE() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
