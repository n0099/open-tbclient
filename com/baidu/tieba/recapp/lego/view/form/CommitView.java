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
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class CommitView extends FormItemBaseView {
    private Button gsg;
    private int gsh;
    private String gsi;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gsg = null;
        this.gsh = 1;
        this.gsi = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gsg = null;
        this.gsh = 1;
        this.gsi = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gsg = null;
        this.gsh = 1;
        this.gsi = "";
        init();
    }

    private void init() {
        bnN();
        bnO();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gsi;
    }

    private void bnN() {
        this.mCheckBox = new CheckBox(this.mContext, null, f.k.form_check_box_style);
        this.mCheckBox.setId(this.gsh);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(f.e.fontsize20));
        this.mCheckBox.setTextColor(this.gsM);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gsg.setClickable(true);
                    CommitView.this.gsg.setBackgroundResource(f.d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gsg.setClickable(false);
                CommitView.this.gsg.setBackgroundResource(f.d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gsH;
        addView(this.mCheckBox, layoutParams);
    }

    private void bnO() {
        this.gsg = new Button(this.mContext);
        this.gsg.setGravity(17);
        this.gsg.setTextColor(this.gsQ);
        this.gsg.setTextSize(0, this.gsN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gsI);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gsg.setBackgroundDrawable(this.mResources.getDrawable(f.C0146f.form_commit_button_selector));
        addView(this.gsg, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gpG)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gsO);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gsH;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gpG);
                Drawable drawable = this.mResources.getDrawable(f.C0146f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gsF, this.gsF);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gsF);
                this.mCheckBox.setText(cVar.gpG);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(f.j.push_commit);
            }
            this.gsg.getLayoutParams().height = this.gsI;
            this.gsg.setPadding(0, 0, 0, 0);
            this.gsg.setTextSize(0, this.gsN);
            this.gsg.setText(str);
            this.gsi = cVar.postUrl;
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
    public boolean bnP() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gsg;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gsg.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
