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
/* loaded from: classes20.dex */
public class CommitView extends FormItemBaseView {
    private String lpA;
    private Button lpy;
    private int lpz;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.lpy = null;
        this.lpz = 1;
        this.lpA = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.lpy = null;
        this.lpz = 1;
        this.lpA = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.lpy = null;
        this.lpz = 1;
        this.lpA = "";
        init();
    }

    private void init() {
        dcx();
        dcy();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.lpA;
    }

    private void dcx() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.lpz);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.lqd);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.lpy.setClickable(true);
                    CommitView.this.lpy.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.lpy.setClickable(false);
                CommitView.this.lpy.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.lpY;
        addView(this.mCheckBox, layoutParams);
    }

    private void dcy() {
        this.lpy = new Button(this.mContext);
        this.lpy.setGravity(17);
        this.lpy.setTextColor(this.lqg);
        this.lpy.setTextSize(0, this.bTU);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lpZ);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.lpy.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.lpy, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.lnj)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.lqe);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.lpY;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.lnj);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.lpW, this.lpW);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.lpW);
                this.mCheckBox.setText(cVar.lnj);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.lpy.getLayoutParams().height = this.lpZ;
            this.lpy.setPadding(0, 0, 0, 0);
            this.lpy.setTextSize(0, this.bTU);
            this.lpy.setText(str);
            this.lpA = cVar.postUrl;
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
    public boolean dcz() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.lpy;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.lpy.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
