package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes26.dex */
public class CommitView extends FormItemBaseView {
    private CheckBox mCheckBox;
    private Button mLp;
    private int mLq;
    private String mLr;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mLp = null;
        this.mLq = 1;
        this.mLr = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mLp = null;
        this.mLq = 1;
        this.mLr = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mLp = null;
        this.mLq = 1;
        this.mLr = "";
        init();
    }

    private void init() {
        dFA();
        dFB();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mLr;
    }

    private void dFA() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mLq);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mLU);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mLp.setClickable(true);
                    CommitView.this.mLp.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mLp.setClickable(false);
                CommitView.this.mLp.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mLP;
        addView(this.mCheckBox, layoutParams);
    }

    private void dFB() {
        this.mLp = new Button(this.mContext);
        this.mLp.setGravity(17);
        this.mLp.setTextColor(this.mLX);
        this.mLp.setTextSize(0, this.cHF);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mLQ);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mLp.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mLp, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.mJg)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mLV);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mLP;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.mJg);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mLN, this.mLN);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mLN);
                this.mCheckBox.setText(cVar.mJg);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mLp.getLayoutParams().height = this.mLQ;
            this.mLp.setPadding(0, 0, 0, 0);
            this.mLp.setTextSize(0, this.cHF);
            this.mLp.setText(str);
            this.mLr = cVar.postUrl;
            return true;
        }
        return false;
    }

    private int b(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFC() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mLp;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mLp.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
