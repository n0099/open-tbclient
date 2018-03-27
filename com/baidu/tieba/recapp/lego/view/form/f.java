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
    private EditText gGF;
    private Button gGG;
    private a gGH;

    /* loaded from: classes3.dex */
    public interface a {
        void boI();
    }

    public f(Context context) {
        super(context);
        this.gGF = null;
        this.gGG = null;
        this.gGH = null;
        init();
    }

    private void init() {
        boQ();
        boR();
    }

    private void boQ() {
        this.gGG = new Button(this.mContext);
        this.gGG.setId(1);
        this.gGG.setTextColor(this.gGq);
        this.gGG.setTextSize(0, this.gGn);
        this.gGG.setBackgroundColor(this.gGs);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gGi);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gGG, layoutParams);
        this.gGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gGH != null) {
                    f.this.gGH.boI();
                }
            }
        });
    }

    private void boR() {
        this.gGF = new EditText(this.mContext);
        this.gGF.setTextColor(this.gGl);
        this.gGF.setHintTextColor(this.gGm);
        this.gGF.setTextSize(0, this.gGn);
        this.gGF.setGravity(19);
        int paddingBottom = this.gGF.getPaddingBottom();
        this.gGF.setPadding(this.gGf, this.gGF.getPaddingTop(), this.gGF.getPaddingRight(), paddingBottom);
        this.gGF.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.f.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || f.this.boF()) {
                    f.this.a(f.this.gGF, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    f.this.a(f.this.gGF, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gGi);
        layoutParams.addRule(0, this.gGG.getId());
        layoutParams.addRule(15);
        a(this.gGF, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gGF, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gDy)) {
                this.gGG.setText(hVar.gDy);
                this.gGG.setTextSize(0, this.gGn);
                this.gGG.getLayoutParams().height = this.gGi;
                this.gGG.setPadding(this.gGf, 0, this.gGf, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gGF.setHint(hVar.content);
                this.gGF.setTextSize(0, this.gGn);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGF.getLayoutParams();
                marginLayoutParams.height = this.gGi;
                marginLayoutParams.rightMargin = this.gGf;
                this.gGF.setPadding(this.gGf, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gGF.setText("");
    }

    public void setListener(a aVar) {
        this.gGH = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boF() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
