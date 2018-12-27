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
    private Button gSk;
    private int gSl;
    private String gSm;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gSk = null;
        this.gSl = 1;
        this.gSm = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gSk = null;
        this.gSl = 1;
        this.gSm = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gSk = null;
        this.gSl = 1;
        this.gSm = "";
        init();
    }

    private void init() {
        bvJ();
        bvK();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gSm;
    }

    private void bvJ() {
        this.mCheckBox = new CheckBox(this.mContext, null, e.k.form_check_box_style);
        this.mCheckBox.setId(this.gSl);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(e.C0210e.fontsize20));
        this.mCheckBox.setTextColor(this.gSQ);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gSk.setClickable(true);
                    CommitView.this.gSk.setBackgroundResource(e.d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gSk.setClickable(false);
                CommitView.this.gSk.setBackgroundResource(e.d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gSL;
        addView(this.mCheckBox, layoutParams);
    }

    private void bvK() {
        this.gSk = new Button(this.mContext);
        this.gSk.setGravity(17);
        this.gSk.setTextColor(this.gST);
        this.gSk.setTextSize(0, this.mFontSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gSM);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gSk.setBackgroundDrawable(this.mResources.getDrawable(e.f.form_commit_button_selector));
        addView(this.gSk, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gPI)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gSR);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gSL;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gPI);
                Drawable drawable = this.mResources.getDrawable(e.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gSJ, this.gSJ);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gSJ);
                this.mCheckBox.setText(cVar.gPI);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(e.j.push_commit);
            }
            this.gSk.getLayoutParams().height = this.gSM;
            this.gSk.setPadding(0, 0, 0, 0);
            this.gSk.setTextSize(0, this.mFontSize);
            this.gSk.setText(str);
            this.gSm = cVar.postUrl;
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
    public boolean bvL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gSk;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gSk.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
