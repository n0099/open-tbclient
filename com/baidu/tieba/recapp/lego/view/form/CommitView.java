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
/* loaded from: classes25.dex */
public class CommitView extends FormItemBaseView {
    private Button lPc;
    private int lPd;
    private String lPe;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.lPc = null;
        this.lPd = 1;
        this.lPe = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.lPc = null;
        this.lPd = 1;
        this.lPe = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.lPc = null;
        this.lPd = 1;
        this.lPe = "";
        init();
    }

    private void init() {
        drs();
        drt();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.lPe;
    }

    private void drs() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.lPd);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.lPH);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.lPc.setClickable(true);
                    CommitView.this.lPc.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.lPc.setClickable(false);
                CommitView.this.lPc.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.lPC;
        addView(this.mCheckBox, layoutParams);
    }

    private void drt() {
        this.lPc = new Button(this.mContext);
        this.lPc.setGravity(17);
        this.lPc.setTextColor(this.lPK);
        this.lPc.setTextSize(0, this.cbH);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lPD);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.lPc.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.lPc, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.lMQ)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.lPI);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.lPC;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.lMQ);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.lPA, this.lPA);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.lPA);
                this.mCheckBox.setText(cVar.lMQ);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.lPc.getLayoutParams().height = this.lPD;
            this.lPc.setPadding(0, 0, 0, 0);
            this.lPc.setTextSize(0, this.cbH);
            this.lPc.setText(str);
            this.lPe = cVar.postUrl;
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
    public boolean dru() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.lPc;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.lPc.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
