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
/* loaded from: classes7.dex */
public class CommitView extends FormItemBaseView {
    private CheckBox mCheckBox;
    private Button mXT;
    private int mXU;
    private String mXV;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mXT = null;
        this.mXU = 1;
        this.mXV = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mXT = null;
        this.mXU = 1;
        this.mXV = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mXT = null;
        this.mXU = 1;
        this.mXV = "";
        init();
    }

    private void init() {
        dDX();
        dDY();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mXV;
    }

    private void dDX() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mXU);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mYy);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mXT.setClickable(true);
                    CommitView.this.mXT.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mXT.setClickable(false);
                CommitView.this.mXT.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mYt;
        addView(this.mCheckBox, layoutParams);
    }

    private void dDY() {
        this.mXT = new Button(this.mContext);
        this.mXT.setGravity(17);
        this.mXT.setTextColor(this.mButtonFontColor);
        this.mXT.setTextSize(0, this.cLA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mYu);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mXT.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mXT, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.mVG)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mYz);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mYt;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.mVG);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mYr, this.mYr);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mYr);
                this.mCheckBox.setText(cVar.mVG);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mXT.getLayoutParams().height = this.mYu;
            this.mXT.setPadding(0, 0, 0, 0);
            this.mXT.setTextSize(0, this.cLA);
            this.mXT.setText(str);
            this.mXV = cVar.postUrl;
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
    public boolean dDZ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mXT;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mXT.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
