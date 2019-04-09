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
    private EditText ilw;
    private Button ilx;
    private a ily;

    /* loaded from: classes3.dex */
    public interface a {
        void bXj();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.ilw = null;
        this.ilx = null;
        this.ily = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ilw = null;
        this.ilx = null;
        this.ily = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilw = null;
        this.ilx = null;
        this.ily = null;
        init();
    }

    private void init() {
        bXt();
        bXu();
    }

    private void bXt() {
        this.ilx = new Button(this.mContext);
        this.ilx.setId(1);
        this.ilx.setTextColor(this.ili);
        this.ilx.setTextSize(0, this.alQ);
        this.ilx.setBackgroundColor(this.ilk);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.ilb);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.ilx, layoutParams);
        this.ilx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.ily != null) {
                    VerificationCodeView.this.ily.bXj();
                }
            }
        });
    }

    private void bXu() {
        this.ilw = new EditText(this.mContext);
        this.ilw.setTextColor(this.ile);
        this.ilw.setHintTextColor(this.ilf);
        this.ilw.setTextSize(0, this.alQ);
        this.ilw.setGravity(19);
        int paddingBottom = this.ilw.getPaddingBottom();
        this.ilw.setPadding(this.ikY, this.ilw.getPaddingTop(), this.ilw.getPaddingRight(), paddingBottom);
        this.ilw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.bXg()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.ilw, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilb);
        layoutParams.addRule(0, this.ilx.getId());
        layoutParams.addRule(15);
        a(this.ilw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.ilw, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.iic)) {
                this.ilx.setText(hVar.iic);
                this.ilx.setTextSize(0, this.alQ);
                this.ilx.getLayoutParams().height = this.ilb;
                this.ilx.setPadding(this.ikY, 0, this.ikY, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.ilw.setHint(hVar.content);
                this.ilw.setTextSize(0, this.alQ);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilw.getLayoutParams();
                marginLayoutParams.height = this.ilb;
                marginLayoutParams.rightMargin = this.ikY;
                this.ilw.setPadding(this.ikY, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.ilw.setText("");
    }

    public void setListener(a aVar) {
        this.ily = aVar;
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
