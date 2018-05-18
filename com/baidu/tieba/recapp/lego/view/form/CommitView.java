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
    private Button gbI;
    private int gbJ;
    private String gbK;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gbI = null;
        this.gbJ = 1;
        this.gbK = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gbI = null;
        this.gbJ = 1;
        this.gbK = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gbI = null;
        this.gbJ = 1;
        this.gbK = "";
        init();
    }

    private void init() {
        bjI();
        bjJ();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gbK;
    }

    private void bjI() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.l.form_check_box_style);
        this.mCheckBox.setId(this.gbJ);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.gco);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gbI.setClickable(true);
                    CommitView.this.gbI.setBackgroundResource(d.C0126d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gbI.setClickable(false);
                CommitView.this.gbI.setBackgroundResource(d.C0126d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gcj;
        addView(this.mCheckBox, layoutParams);
    }

    private void bjJ() {
        this.gbI = new Button(this.mContext);
        this.gbI.setGravity(17);
        this.gbI.setTextColor(this.gcs);
        this.gbI.setTextSize(0, this.gcp);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gck);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gbI.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gbI, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.fZl)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gcq);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gcj;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.fZl);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gch, this.gch);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gch);
                this.mCheckBox.setText(cVar.fZl);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.k.push_commit);
            }
            this.gbI.getLayoutParams().height = this.gck;
            this.gbI.setPadding(0, 0, 0, 0);
            this.gbI.setTextSize(0, this.gcp);
            this.gbI.setText(str);
            this.gbK = cVar.postUrl;
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
    public boolean bjK() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gbI;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gbI.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
