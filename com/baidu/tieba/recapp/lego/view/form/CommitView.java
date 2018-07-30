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
    private Button gsd;
    private int gse;
    private String gsf;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gsd = null;
        this.gse = 1;
        this.gsf = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gsd = null;
        this.gse = 1;
        this.gsf = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gsd = null;
        this.gse = 1;
        this.gsf = "";
        init();
    }

    private void init() {
        bnM();
        bnN();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gsf;
    }

    private void bnM() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.k.form_check_box_style);
        this.mCheckBox.setId(this.gse);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.gsJ);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gsd.setClickable(true);
                    CommitView.this.gsd.setBackgroundResource(d.C0140d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gsd.setClickable(false);
                CommitView.this.gsd.setBackgroundResource(d.C0140d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gsE;
        addView(this.mCheckBox, layoutParams);
    }

    private void bnN() {
        this.gsd = new Button(this.mContext);
        this.gsd.setGravity(17);
        this.gsd.setTextColor(this.gsN);
        this.gsd.setTextSize(0, this.gsK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gsF);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gsd.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gsd, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gpD)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gsL);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gsE;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gpD);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gsC, this.gsC);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gsC);
                this.mCheckBox.setText(cVar.gpD);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.j.push_commit);
            }
            this.gsd.getLayoutParams().height = this.gsF;
            this.gsd.setPadding(0, 0, 0, 0);
            this.gsd.setTextSize(0, this.gsK);
            this.gsd.setText(str);
            this.gsf = cVar.postUrl;
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
    public boolean bnO() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gsd;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gsd.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
