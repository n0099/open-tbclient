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
    private Button gaC;
    private int gaD;
    private String gaE;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gaC = null;
        this.gaD = 1;
        this.gaE = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gaC = null;
        this.gaD = 1;
        this.gaE = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gaC = null;
        this.gaD = 1;
        this.gaE = "";
        init();
    }

    private void init() {
        bjJ();
        bjK();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gaE;
    }

    private void bjJ() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.l.form_check_box_style);
        this.mCheckBox.setId(this.gaD);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.gbi);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gaC.setClickable(true);
                    CommitView.this.gaC.setBackgroundResource(d.C0126d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gaC.setClickable(false);
                CommitView.this.gaC.setBackgroundResource(d.C0126d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gbd;
        addView(this.mCheckBox, layoutParams);
    }

    private void bjK() {
        this.gaC = new Button(this.mContext);
        this.gaC.setGravity(17);
        this.gaC.setTextColor(this.gbm);
        this.gaC.setTextSize(0, this.gbj);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gbe);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gaC.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gaC, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.fYf)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gbk);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gbd;
                marginLayoutParams.height = c(this.mCheckBox.getPaint(), cVar.fYf);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gbb, this.gbb);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gbb);
                this.mCheckBox.setText(cVar.fYf);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.k.push_commit);
            }
            this.gaC.getLayoutParams().height = this.gbe;
            this.gaC.setPadding(0, 0, 0, 0);
            this.gaC.setTextSize(0, this.gbj);
            this.gaC.setText(str);
            this.gaE = cVar.postUrl;
            return true;
        }
        return false;
    }

    private int c(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gaC;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gaC.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
