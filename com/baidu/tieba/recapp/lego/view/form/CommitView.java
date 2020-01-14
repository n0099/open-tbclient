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
/* loaded from: classes11.dex */
public class CommitView extends FormItemBaseView {
    private Button jJf;
    private int jJg;
    private CheckBox mCheckBox;
    private String mPostUrl;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.jJf = null;
        this.jJg = 1;
        this.mPostUrl = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.jJf = null;
        this.jJg = 1;
        this.mPostUrl = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.jJf = null;
        this.jJg = 1;
        this.mPostUrl = "";
        init();
    }

    private void init() {
        cBx();
        cBy();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mPostUrl;
    }

    private void cBx() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.jJg);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.jJJ);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.jJf.setClickable(true);
                    CommitView.this.jJf.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.jJf.setClickable(false);
                CommitView.this.jJf.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.jJE;
        addView(this.mCheckBox, layoutParams);
    }

    private void cBy() {
        this.jJf = new Button(this.mContext);
        this.jJf.setGravity(17);
        this.jJf.setTextColor(this.jJM);
        this.jJf.setTextSize(0, this.bcC);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jJF);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.jJf.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.jJf, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.jGD)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.jJK);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.jJE;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.jGD);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.jJC, this.jJC);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.jJC);
                this.mCheckBox.setText(cVar.jGD);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.jJf.getLayoutParams().height = this.jJF;
            this.jJf.setPadding(0, 0, 0, 0);
            this.jJf.setTextSize(0, this.bcC);
            this.jJf.setText(str);
            this.mPostUrl = cVar.postUrl;
            return true;
        }
        return false;
    }

    private int a(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cBz() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.jJf;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.jJf.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
