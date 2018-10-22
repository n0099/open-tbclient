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
    private Button gHb;
    private int gHc;
    private String gHd;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gHb = null;
        this.gHc = 1;
        this.gHd = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gHb = null;
        this.gHc = 1;
        this.gHd = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gHb = null;
        this.gHc = 1;
        this.gHd = "";
        init();
    }

    private void init() {
        btJ();
        btK();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gHd;
    }

    private void btJ() {
        this.mCheckBox = new CheckBox(this.mContext, null, e.k.form_check_box_style);
        this.mCheckBox.setId(this.gHc);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(e.C0175e.fontsize20));
        this.mCheckBox.setTextColor(this.gHH);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gHb.setClickable(true);
                    CommitView.this.gHb.setBackgroundResource(e.d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gHb.setClickable(false);
                CommitView.this.gHb.setBackgroundResource(e.d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gHC;
        addView(this.mCheckBox, layoutParams);
    }

    private void btK() {
        this.gHb = new Button(this.mContext);
        this.gHb.setGravity(17);
        this.gHb.setTextColor(this.gHK);
        this.gHb.setTextSize(0, this.mFontSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gHD);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gHb.setBackgroundDrawable(this.mResources.getDrawable(e.f.form_commit_button_selector));
        addView(this.gHb, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gEz)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gHI);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gHC;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gEz);
                Drawable drawable = this.mResources.getDrawable(e.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gHA, this.gHA);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gHA);
                this.mCheckBox.setText(cVar.gEz);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(e.j.push_commit);
            }
            this.gHb.getLayoutParams().height = this.gHD;
            this.gHb.setPadding(0, 0, 0, 0);
            this.gHb.setTextSize(0, this.mFontSize);
            this.gHb.setText(str);
            this.gHd = cVar.postUrl;
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
        return this.gHb;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gHb.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
