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
    private int ikA;
    private String ikB;
    private Button ikz;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.ikz = null;
        this.ikA = 1;
        this.ikB = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.ikz = null;
        this.ikA = 1;
        this.ikB = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.ikz = null;
        this.ikA = 1;
        this.ikB = "";
        init();
    }

    private void init() {
        bXe();
        bXf();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.ikB;
    }

    private void bXe() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.k.form_check_box_style);
        this.mCheckBox.setId(this.ikA);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.ilf);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.ikz.setClickable(true);
                    CommitView.this.ikz.setBackgroundResource(d.C0277d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.ikz.setClickable(false);
                CommitView.this.ikz.setBackgroundResource(d.C0277d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.ila;
        addView(this.mCheckBox, layoutParams);
    }

    private void bXf() {
        this.ikz = new Button(this.mContext);
        this.ikz.setGravity(17);
        this.ikz.setTextColor(this.ili);
        this.ikz.setTextSize(0, this.alQ);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilb);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.ikz.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.ikz, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.ihY)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.ilg);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.ila;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.ihY);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.ikY, this.ikY);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.ikY);
                this.mCheckBox.setText(cVar.ihY);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.j.push_commit);
            }
            this.ikz.getLayoutParams().height = this.ilb;
            this.ikz.setPadding(0, 0, 0, 0);
            this.ikz.setTextSize(0, this.alQ);
            this.ikz.setText(str);
            this.ikB = cVar.postUrl;
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
    public boolean bXg() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.ikz;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.ikz.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
