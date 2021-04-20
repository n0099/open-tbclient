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
/* loaded from: classes4.dex */
public class VerificationCodeView extends FormItemBaseView {
    public EditText x;
    public Button y;
    public c z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VerificationCodeView.this.z != null) {
                VerificationCodeView.this.z.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (!z && !VerificationCodeView.this.a()) {
                VerificationCodeView verificationCodeView = VerificationCodeView.this;
                verificationCodeView.c(verificationCodeView.x, FormItemBaseView.DrawableType.ERROR_FRAME);
                return;
            }
            VerificationCodeView verificationCodeView2 = VerificationCodeView.this;
            verificationCodeView2.c(verificationCodeView2.x, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.x = null;
        this.y = null;
        this.z = null;
        j();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean a() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public void e() {
        this.x.setText("");
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean g(FormCard.b bVar) {
        if (super.g(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.f20425d)) {
                this.y.setText(hVar.f20425d);
                this.y.setTextSize(0, this.n);
                this.y.getLayoutParams().height = this.j;
                Button button = this.y;
                int i = this.f20510g;
                button.setPadding(i, 0, i, 0);
            }
            if (TextUtils.isEmpty(hVar.f20416b)) {
                return true;
            }
            this.x.setHint(hVar.f20416b);
            this.x.setTextSize(0, this.n);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.x.getLayoutParams();
            marginLayoutParams.height = this.j;
            int i2 = this.f20510g;
            marginLayoutParams.rightMargin = i2;
            this.x.setPadding(i2, 0, 0, 0);
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public final void j() {
        k();
        l();
    }

    public final void k() {
        Button button = new Button(this.f20508e);
        this.y = button;
        button.setId(1);
        this.y.setTextColor(this.q);
        this.y.setTextSize(0, this.n);
        this.y.setBackgroundColor(this.r);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.j);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.y, layoutParams);
        this.y.setOnClickListener(new a());
    }

    public final void l() {
        EditText editText = new EditText(this.f20508e);
        this.x = editText;
        editText.setTextColor(this.l);
        this.x.setHintTextColor(this.m);
        this.x.setTextSize(0, this.n);
        this.x.setGravity(19);
        int paddingBottom = this.x.getPaddingBottom();
        this.x.setPadding(this.f20510g, this.x.getPaddingTop(), this.x.getPaddingRight(), paddingBottom);
        this.x.setOnFocusChangeListener(new b());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.j);
        layoutParams.addRule(0, this.y.getId());
        layoutParams.addRule(15);
        c(this.x, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.x, layoutParams);
    }

    public void setListener(c cVar) {
        this.z = cVar;
    }

    public void setVerificationInfo(String str) {
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = null;
        this.y = null;
        this.z = null;
        j();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = null;
        this.y = null;
        this.z = null;
        j();
    }
}
