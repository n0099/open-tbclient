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
    private Button jKb;
    private int jKc;
    private CheckBox mCheckBox;
    private String mPostUrl;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.jKb = null;
        this.jKc = 1;
        this.mPostUrl = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.jKb = null;
        this.jKc = 1;
        this.mPostUrl = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.jKb = null;
        this.jKc = 1;
        this.mPostUrl = "";
        init();
    }

    private void init() {
        cCT();
        cCU();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mPostUrl;
    }

    private void cCT() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.jKc);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.jKF);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.jKb.setClickable(true);
                    CommitView.this.jKb.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.jKb.setClickable(false);
                CommitView.this.jKb.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.jKA;
        addView(this.mCheckBox, layoutParams);
    }

    private void cCU() {
        this.jKb = new Button(this.mContext);
        this.jKb.setGravity(17);
        this.jKb.setTextColor(this.jKI);
        this.jKb.setTextSize(0, this.bgR);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.jKB);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.jKb.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.jKb, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.jHu)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.jKG);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.jKA;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.jHu);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.jKy, this.jKy);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.jKy);
                this.mCheckBox.setText(cVar.jHu);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.jKb.getLayoutParams().height = this.jKB;
            this.jKb.setPadding(0, 0, 0, 0);
            this.jKb.setTextSize(0, this.bgR);
            this.jKb.setText(str);
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
    public boolean cCV() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.jKb;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.jKb.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
