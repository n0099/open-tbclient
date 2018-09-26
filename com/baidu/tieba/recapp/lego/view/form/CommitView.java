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
    private Button gzA;
    private int gzB;
    private String gzC;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gzA = null;
        this.gzB = 1;
        this.gzC = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gzA = null;
        this.gzB = 1;
        this.gzC = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gzA = null;
        this.gzB = 1;
        this.gzC = "";
        init();
    }

    private void init() {
        bqu();
        bqv();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gzC;
    }

    private void bqu() {
        this.mCheckBox = new CheckBox(this.mContext, null, e.k.form_check_box_style);
        this.mCheckBox.setId(this.gzB);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(e.C0141e.fontsize20));
        this.mCheckBox.setTextColor(this.gAg);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gzA.setClickable(true);
                    CommitView.this.gzA.setBackgroundResource(e.d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gzA.setClickable(false);
                CommitView.this.gzA.setBackgroundResource(e.d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gAb;
        addView(this.mCheckBox, layoutParams);
    }

    private void bqv() {
        this.gzA = new Button(this.mContext);
        this.gzA.setGravity(17);
        this.gzA.setTextColor(this.gAk);
        this.gzA.setTextSize(0, this.gAh);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gAc);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gzA.setBackgroundDrawable(this.mResources.getDrawable(e.f.form_commit_button_selector));
        addView(this.gzA, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gwY)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gAi);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gAb;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gwY);
                Drawable drawable = this.mResources.getDrawable(e.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gzZ, this.gzZ);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gzZ);
                this.mCheckBox.setText(cVar.gwY);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(e.j.push_commit);
            }
            this.gzA.getLayoutParams().height = this.gAc;
            this.gzA.setPadding(0, 0, 0, 0);
            this.gzA.setTextSize(0, this.gAh);
            this.gzA.setText(str);
            this.gzC = cVar.postUrl;
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
    public boolean bqw() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gzA;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gzA.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
