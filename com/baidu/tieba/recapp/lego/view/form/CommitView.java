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
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class CommitView extends FormItemBaseView {
    private Button gHa;
    private int gHb;
    private String gHc;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gHa = null;
        this.gHb = 1;
        this.gHc = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gHa = null;
        this.gHb = 1;
        this.gHc = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gHa = null;
        this.gHb = 1;
        this.gHc = "";
        init();
    }

    private void init() {
        btJ();
        btK();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gHc;
    }

    private void btJ() {
        this.mCheckBox = new CheckBox(this.mContext, null, e.k.form_check_box_style);
        this.mCheckBox.setId(this.gHb);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(e.C0175e.fontsize20));
        this.mCheckBox.setTextColor(this.gHG);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gHa.setClickable(true);
                    CommitView.this.gHa.setBackgroundResource(e.d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gHa.setClickable(false);
                CommitView.this.gHa.setBackgroundResource(e.d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gHB;
        addView(this.mCheckBox, layoutParams);
    }

    private void btK() {
        this.gHa = new Button(this.mContext);
        this.gHa.setGravity(17);
        this.gHa.setTextColor(this.gHJ);
        this.gHa.setTextSize(0, this.mFontSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gHC);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gHa.setBackgroundDrawable(this.mResources.getDrawable(e.f.form_commit_button_selector));
        addView(this.gHa, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gEy)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gHH);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gHB;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gEy);
                Drawable drawable = this.mResources.getDrawable(e.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gHz, this.gHz);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gHz);
                this.mCheckBox.setText(cVar.gEy);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(e.j.push_commit);
            }
            this.gHa.getLayoutParams().height = this.gHC;
            this.gHa.setPadding(0, 0, 0, 0);
            this.gHa.setTextSize(0, this.mFontSize);
            this.gHa.setText(str);
            this.gHc = cVar.postUrl;
            return true;
        }
        return false;
    }

    private int d(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean btL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gHa;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gHa.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
