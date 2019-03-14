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
    private Button ikM;
    private int ikN;
    private String ikO;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.ikM = null;
        this.ikN = 1;
        this.ikO = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.ikM = null;
        this.ikN = 1;
        this.ikO = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.ikM = null;
        this.ikN = 1;
        this.ikO = "";
        init();
    }

    private void init() {
        bXi();
        bXj();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.ikO;
    }

    private void bXi() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.k.form_check_box_style);
        this.mCheckBox.setId(this.ikN);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.ils);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.ikM.setClickable(true);
                    CommitView.this.ikM.setBackgroundResource(d.C0277d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.ikM.setClickable(false);
                CommitView.this.ikM.setBackgroundResource(d.C0277d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.iln;
        addView(this.mCheckBox, layoutParams);
    }

    private void bXj() {
        this.ikM = new Button(this.mContext);
        this.ikM.setGravity(17);
        this.ikM.setTextColor(this.ilv);
        this.ikM.setTextSize(0, this.alL);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilo);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.ikM.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.ikM, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.iil)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.ilt);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.iln;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.iil);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.ill, this.ill);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.ill);
                this.mCheckBox.setText(cVar.iil);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.j.push_commit);
            }
            this.ikM.getLayoutParams().height = this.ilo;
            this.ikM.setPadding(0, 0, 0, 0);
            this.ikM.setTextSize(0, this.alL);
            this.ikM.setText(str);
            this.ikO = cVar.postUrl;
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
    public boolean bXk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.ikM;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.ikM.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
