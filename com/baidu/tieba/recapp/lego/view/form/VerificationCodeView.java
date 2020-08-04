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
    private EditText lqw;
    private Button lqx;
    private a lqy;

    /* loaded from: classes20.dex */
    public interface a {
        void dcC();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.lqw = null;
        this.lqx = null;
        this.lqy = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lqw = null;
        this.lqx = null;
        this.lqy = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lqw = null;
        this.lqx = null;
        this.lqy = null;
        init();
    }

    private void init() {
        dcL();
        dcM();
    }

    private void dcL() {
        this.lqx = new Button(this.mContext);
        this.lqx.setId(1);
        this.lqx.setTextColor(this.lqi);
        this.lqx.setTextSize(0, this.bTU);
        this.lqx.setBackgroundColor(this.lqk);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.lqb);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.lqx, layoutParams);
        this.lqx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VerificationCodeView.this.lqy != null) {
                    VerificationCodeView.this.lqy.dcC();
                }
            }
        });
    }

    private void dcM() {
        this.lqw = new EditText(this.mContext);
        this.lqw.setTextColor(this.lqe);
        this.lqw.setHintTextColor(this.lqf);
        this.lqw.setTextSize(0, this.bTU);
        this.lqw.setGravity(19);
        int paddingBottom = this.lqw.getPaddingBottom();
        this.lqw.setPadding(this.lpY, this.lqw.getPaddingTop(), this.lqw.getPaddingRight(), paddingBottom);
        this.lqw.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                if (z || VerificationCodeView.this.dcz()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.lqw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.lqw, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lqb);
        layoutParams.addRule(0, this.lqx.getId());
        layoutParams.addRule(15);
        a(this.lqw, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.lqw, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.lnp)) {
                this.lqx.setText(hVar.lnp);
                this.lqx.setTextSize(0, this.bTU);
                this.lqx.getLayoutParams().height = this.lqb;
                this.lqx.setPadding(this.lpY, 0, this.lpY, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.lqw.setHint(hVar.content);
                this.lqw.setTextSize(0, this.bTU);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lqw.getLayoutParams();
                marginLayoutParams.height = this.lqb;
                marginLayoutParams.rightMargin = this.lpY;
                this.lqw.setPadding(this.lpY, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.lqw.setText("");
    }

    public void setListener(a aVar) {
        this.lqy = aVar;
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
