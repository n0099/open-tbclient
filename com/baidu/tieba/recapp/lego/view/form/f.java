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
    private EditText gGE;
    private Button gGF;
    private a gGG;

    /* loaded from: classes3.dex */
    public interface a {
        void boI();
    }

    public f(Context context) {
        super(context);
        this.gGE = null;
        this.gGF = null;
        this.gGG = null;
        init();
    }

    private void init() {
        boQ();
        boR();
    }

    private void boQ() {
        this.gGF = new Button(this.mContext);
        this.gGF.setId(1);
        this.gGF.setTextColor(this.gGp);
        this.gGF.setTextSize(0, this.gGm);
        this.gGF.setBackgroundColor(this.gGr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gGh);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gGF, layoutParams);
        this.gGF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (f.this.gGG != null) {
                    f.this.gGG.boI();
                }
            }
        });
    }

    private void boR() {
        this.gGE = new EditText(this.mContext);
        this.gGE.setTextColor(this.gGk);
        this.gGE.setHintTextColor(this.gGl);
        this.gGE.setTextSize(0, this.gGm);
        this.gGE.setGravity(19);
        int paddingBottom = this.gGE.getPaddingBottom();
        this.gGE.setPadding(this.gGe, this.gGE.getPaddingTop(), this.gGE.getPaddingRight(), paddingBottom);
        this.gGE.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.f.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || f.this.boF()) {
                    f.this.a(f.this.gGE, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    f.this.a(f.this.gGE, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gGh);
        layoutParams.addRule(0, this.gGF.getId());
        layoutParams.addRule(15);
        a(this.gGE, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gGE, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.gDx)) {
                this.gGF.setText(hVar.gDx);
                this.gGF.setTextSize(0, this.gGm);
                this.gGF.getLayoutParams().height = this.gGh;
                this.gGF.setPadding(this.gGe, 0, this.gGe, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gGE.setHint(hVar.content);
                this.gGE.setTextSize(0, this.gGm);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGE.getLayoutParams();
                marginLayoutParams.height = this.gGh;
                marginLayoutParams.rightMargin = this.gGe;
                this.gGE.setPadding(this.gGe, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gGE.setText("");
    }

    public void setListener(a aVar) {
        this.gGG = aVar;
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
