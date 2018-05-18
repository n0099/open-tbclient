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
    private EditText gcG;
    private Button gcH;
    private a gcI;

    /* loaded from: classes3.dex */
    public interface a {
        void bjN();
    }

    public VerificationCodeView(Context context) {
        super(context);
        this.gcG = null;
        this.gcH = null;
        this.gcI = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gcG = null;
        this.gcH = null;
        this.gcI = null;
        init();
    }

    public VerificationCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gcG = null;
        this.gcH = null;
        this.gcI = null;
        init();
    }

    private void init() {
        bjW();
        bjX();
    }

    private void bjW() {
        this.gcH = new Button(this.mContext);
        this.gcH.setId(1);
        this.gcH.setTextColor(this.gcs);
        this.gcH.setTextSize(0, this.gcp);
        this.gcH.setBackgroundColor(this.gcu);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.gck);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.gcH, layoutParams);
        this.gcH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (VerificationCodeView.this.gcI != null) {
                    VerificationCodeView.this.gcI.bjN();
                }
            }
        });
    }

    private void bjX() {
        this.gcG = new EditText(this.mContext);
        this.gcG.setTextColor(this.gcn);
        this.gcG.setHintTextColor(this.gco);
        this.gcG.setTextSize(0, this.gcp);
        this.gcG.setGravity(19);
        int paddingBottom = this.gcG.getPaddingBottom();
        this.gcG.setPadding(this.gch, this.gcG.getPaddingTop(), this.gcG.getPaddingRight(), paddingBottom);
        this.gcG.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.VerificationCodeView.2
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z) {
                if (z || VerificationCodeView.this.bjK()) {
                    VerificationCodeView.this.a(VerificationCodeView.this.gcG, FormItemBaseView.DrawableType.ORDINARY_FRAME);
                } else {
                    VerificationCodeView.this.a(VerificationCodeView.this.gcG, FormItemBaseView.DrawableType.ERROR_FRAME);
                }
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gck);
        layoutParams.addRule(0, this.gcH.getId());
        layoutParams.addRule(15);
        a(this.gcG, FormItemBaseView.DrawableType.ORDINARY_FRAME);
        addView(this.gcG, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.h hVar = (FormCard.h) bVar;
            if (!TextUtils.isEmpty(hVar.fZp)) {
                this.gcH.setText(hVar.fZp);
                this.gcH.setTextSize(0, this.gcp);
                this.gcH.getLayoutParams().height = this.gck;
                this.gcH.setPadding(this.gch, 0, this.gch, 0);
            }
            if (!TextUtils.isEmpty(hVar.content)) {
                this.gcG.setHint(hVar.content);
                this.gcG.setTextSize(0, this.gcp);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gcG.getLayoutParams();
                marginLayoutParams.height = this.gck;
                marginLayoutParams.rightMargin = this.gch;
                this.gcG.setPadding(this.gch, 0, 0, 0);
            }
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    protected void reset() {
        this.gcG.setText("");
    }

    public void setListener(a aVar) {
        this.gcI = aVar;
    }

    public void setVerificationInfo(String str) {
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjK() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
