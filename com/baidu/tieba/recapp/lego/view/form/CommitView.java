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
    private Button gIC;
    private int gID;
    private String gIE;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gIC = null;
        this.gID = 1;
        this.gIE = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gIC = null;
        this.gID = 1;
        this.gIE = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gIC = null;
        this.gID = 1;
        this.gIE = "";
        init();
    }

    private void init() {
        btf();
        btg();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gIE;
    }

    private void btf() {
        this.mCheckBox = new CheckBox(this.mContext, null, e.k.form_check_box_style);
        this.mCheckBox.setId(this.gID);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(e.C0200e.fontsize20));
        this.mCheckBox.setTextColor(this.gJi);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gIC.setClickable(true);
                    CommitView.this.gIC.setBackgroundResource(e.d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gIC.setClickable(false);
                CommitView.this.gIC.setBackgroundResource(e.d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gJd;
        addView(this.mCheckBox, layoutParams);
    }

    private void btg() {
        this.gIC = new Button(this.mContext);
        this.gIC.setGravity(17);
        this.gIC.setTextColor(this.gJl);
        this.gIC.setTextSize(0, this.mFontSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gJe);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gIC.setBackgroundDrawable(this.mResources.getDrawable(e.f.form_commit_button_selector));
        addView(this.gIC, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gGa)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gJj);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gJd;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gGa);
                Drawable drawable = this.mResources.getDrawable(e.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gJb, this.gJb);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gJb);
                this.mCheckBox.setText(cVar.gGa);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(e.j.push_commit);
            }
            this.gIC.getLayoutParams().height = this.gJe;
            this.gIC.setPadding(0, 0, 0, 0);
            this.gIC.setTextSize(0, this.mFontSize);
            this.gIC.setText(str);
            this.gIE = cVar.postUrl;
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
    public boolean bth() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gIC;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gIC.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
