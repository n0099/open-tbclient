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
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class CommitView extends FormItemBaseView {
    private Button gna;
    private int gnb;
    private String gnc;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gna = null;
        this.gnb = 1;
        this.gnc = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gna = null;
        this.gnb = 1;
        this.gnc = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gna = null;
        this.gnb = 1;
        this.gnc = "";
        init();
    }

    private void init() {
        boH();
        boI();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gnc;
    }

    private void boH() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.l.form_check_box_style);
        this.mCheckBox.setId(this.gnb);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.gnG);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gna.setClickable(true);
                    CommitView.this.gna.setBackgroundResource(d.C0141d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gna.setClickable(false);
                CommitView.this.gna.setBackgroundResource(d.C0141d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gnB;
        addView(this.mCheckBox, layoutParams);
    }

    private void boI() {
        this.gna = new Button(this.mContext);
        this.gna.setGravity(17);
        this.gna.setTextColor(this.gnK);
        this.gna.setTextSize(0, this.gnH);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gnC);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gna.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gna, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gkD)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gnI);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gnB;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gkD);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gnz, this.gnz);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gnz);
                this.mCheckBox.setText(cVar.gkD);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.k.push_commit);
            }
            this.gna.getLayoutParams().height = this.gnC;
            this.gna.setPadding(0, 0, 0, 0);
            this.gna.setTextSize(0, this.gnH);
            this.gna.setText(str);
            this.gnc = cVar.postUrl;
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
    public boolean boJ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gna;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gna.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
