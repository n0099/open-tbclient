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
/* loaded from: classes13.dex */
public class CommitView extends FormItemBaseView {
    private Button jKp;
    private int jKq;
    private CheckBox mCheckBox;
    private String mPostUrl;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.jKp = null;
        this.jKq = 1;
        this.mPostUrl = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.jKp = null;
        this.jKq = 1;
        this.mPostUrl = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.jKp = null;
        this.jKq = 1;
        this.mPostUrl = "";
        init();
    }

    private void init() {
        cCW();
        cCX();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mPostUrl;
    }

    private void cCW() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.jKq);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.jKT);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.jKp.setClickable(true);
                    CommitView.this.jKp.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.jKp.setClickable(false);
                CommitView.this.jKp.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.jKO;
        addView(this.mCheckBox, layoutParams);
    }

    private void cCX() {
        this.jKp = new Button(this.mContext);
        this.jKp.setGravity(17);
        this.jKp.setTextColor(this.jKW);
        this.jKp.setTextSize(0, this.bgT);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKP);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.jKp.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.jKp, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.jHI)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.jKU);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.jKO;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.jHI);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.jKM, this.jKM);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.jKM);
                this.mCheckBox.setText(cVar.jHI);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.jKp.getLayoutParams().height = this.jKP;
            this.jKp.setPadding(0, 0, 0, 0);
            this.jKp.setTextSize(0, this.bgT);
            this.jKp.setText(str);
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
    public boolean cCY() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.jKp;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.jKp.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
