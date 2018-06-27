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
    private Button gqR;
    private int gqS;
    private String gqT;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gqR = null;
        this.gqS = 1;
        this.gqT = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gqR = null;
        this.gqS = 1;
        this.gqT = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gqR = null;
        this.gqS = 1;
        this.gqT = "";
        init();
    }

    private void init() {
        bpi();
        bpj();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gqT;
    }

    private void bpi() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.l.form_check_box_style);
        this.mCheckBox.setId(this.gqS);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.grx);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gqR.setClickable(true);
                    CommitView.this.gqR.setBackgroundResource(d.C0142d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gqR.setClickable(false);
                CommitView.this.gqR.setBackgroundResource(d.C0142d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.grs;
        addView(this.mCheckBox, layoutParams);
    }

    private void bpj() {
        this.gqR = new Button(this.mContext);
        this.gqR.setGravity(17);
        this.gqR.setTextColor(this.grB);
        this.gqR.setTextSize(0, this.gry);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.grt);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gqR.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gqR, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.got)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.grz);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.grs;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.got);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.grq, this.grq);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.grq);
                this.mCheckBox.setText(cVar.got);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.k.push_commit);
            }
            this.gqR.getLayoutParams().height = this.grt;
            this.gqR.setPadding(0, 0, 0, 0);
            this.gqR.setTextSize(0, this.gry);
            this.gqR.setText(str);
            this.gqT = cVar.postUrl;
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
    public boolean bpk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gqR;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gqR.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
