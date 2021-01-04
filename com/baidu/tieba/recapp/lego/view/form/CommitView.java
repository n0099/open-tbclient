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
/* loaded from: classes8.dex */
public class CommitView extends FormItemBaseView {
    private CheckBox mCheckBox;
    private Button mQA;
    private int mQB;
    private String mQC;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mQA = null;
        this.mQB = 1;
        this.mQC = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mQA = null;
        this.mQB = 1;
        this.mQC = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mQA = null;
        this.mQB = 1;
        this.mQC = "";
        init();
    }

    private void init() {
        dFq();
        dFr();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mQC;
    }

    private void dFq() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mQB);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mRf);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mQA.setClickable(true);
                    CommitView.this.mQA.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mQA.setClickable(false);
                CommitView.this.mQA.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mRa;
        addView(this.mCheckBox, layoutParams);
    }

    private void dFr() {
        this.mQA = new Button(this.mContext);
        this.mQA.setGravity(17);
        this.mQA.setTextColor(this.mRi);
        this.mQA.setTextSize(0, this.cMu);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mRb);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mQA.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mQA, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.mOq)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mRg);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mRa;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.mOq);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mQY, this.mQY);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mQY);
                this.mCheckBox.setText(cVar.mOq);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mQA.getLayoutParams().height = this.mRb;
            this.mQA.setPadding(0, 0, 0, 0);
            this.mQA.setTextSize(0, this.cMu);
            this.mQA.setText(str);
            this.mQC = cVar.postUrl;
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
    public boolean dFs() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mQA;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mQA.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
