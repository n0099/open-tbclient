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
    private Button gaF;
    private int gaG;
    private String gaH;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gaF = null;
        this.gaG = 1;
        this.gaH = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gaF = null;
        this.gaG = 1;
        this.gaH = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gaF = null;
        this.gaG = 1;
        this.gaH = "";
        init();
    }

    private void init() {
        bjJ();
        bjK();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gaH;
    }

    private void bjJ() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.l.form_check_box_style);
        this.mCheckBox.setId(this.gaG);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.gbl);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gaF.setClickable(true);
                    CommitView.this.gaF.setBackgroundResource(d.C0126d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gaF.setClickable(false);
                CommitView.this.gaF.setBackgroundResource(d.C0126d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gbg;
        addView(this.mCheckBox, layoutParams);
    }

    private void bjK() {
        this.gaF = new Button(this.mContext);
        this.gaF.setGravity(17);
        this.gaF.setTextColor(this.gbp);
        this.gaF.setTextSize(0, this.gbm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gbh);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gaF.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gaF, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.fYi)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gbn);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gbg;
                marginLayoutParams.height = c(this.mCheckBox.getPaint(), cVar.fYi);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gbe, this.gbe);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gbe);
                this.mCheckBox.setText(cVar.fYi);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.k.push_commit);
            }
            this.gaF.getLayoutParams().height = this.gbh;
            this.gaF.setPadding(0, 0, 0, 0);
            this.gaF.setTextSize(0, this.gbm);
            this.gaF.setText(str);
            this.gaH = cVar.postUrl;
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
        return this.gaF;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gaF.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
