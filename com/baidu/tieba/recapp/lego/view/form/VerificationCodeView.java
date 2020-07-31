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
/* loaded from: classes20.dex */
public class VerificationCodeView extends FormItemBaseView {
    private EditText lqu;
    private Button lqv;
    private a lqw;

    /* loaded from: classes20.dex */
    public interface a {
        void dcC();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.lqu = null;
        this.lqv = null;
        this.lqw = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lqu = null;
        this.lqv = null;
        this.lqw = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lqu = null;
        this.lqv = null;
        this.lqw = null;
        init();
    }

    private void init() {
        dcL();
        dcM();
    }

    private void dcL() {
        this.lqv = new Button(this.mContext);
        this.lqv.setId(1);
        this.lqv.setTextColor(this.lqg);
        this.lqv.setTextSize(0, this.bTU);
        this.lqv.setBackgroundColor(this.lqi);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.lpZ);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lqv, layoutParams);
        this.lqv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.lqw != null) {
                    VerificationCodeView.this.lqw.dcC();
                }
            }
        });
    }

    private void dcM() {
        this.lqu = new EditText(this.mContext);
        this.lqu.setTextColor(this.lqc);
        this.lqu.setHintTextColor(this.lqd);
        this.lqu.setTextSize(0, this.bTU);
        this.lqu.setGravity(19);
        int paddingBottom = this.lqu.getPaddingBottom();
        this.lqu.setPadding(this.lpW, this.lqu.getPaddingTop(), this.lqu.getPaddingRight(), paddingBottom);
        this.lqu.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dcz()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.lqu, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.lqu, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lpZ);
        layoutParams.addRule(0, this.lqv.getId());
        layoutParams.addRule(15);
        a(this.lqu, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lqu, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.lnn)) {
                this.lqv.setText(hVar.lnn);
                this.lqv.setTextSize(0, this.bTU);
                this.lqv.getLayoutParams().height = this.lpZ;
                this.lqv.setPadding(this.lpW, 0, this.lpW, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.lqu.setHint(hVar.content);
                this.lqu.setTextSize(0, this.bTU);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lqu.getLayoutParams();
                marginLayoutParams.height = this.lpZ;
                marginLayoutParams.rightMargin = this.lpW;
                this.lqu.setPadding(this.lpW, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lqu.setText("");
    }

    public void setListener(a aVar) {
        this.lqw = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dcz() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
