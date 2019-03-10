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
    private Button ikT;
    private int ikU;
    private String ikV;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.ikT = null;
        this.ikU = 1;
        this.ikV = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.ikT = null;
        this.ikU = 1;
        this.ikV = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.ikT = null;
        this.ikU = 1;
        this.ikV = "";
        init();
    }

    private void init() {
        bXg();
        bXh();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.ikV;
    }

    private void bXg() {
        this.mCheckBox = new CheckBox(this.mContext, null, d.k.form_check_box_style);
        this.mCheckBox.setId(this.ikU);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.mCheckBox.setTextColor(this.ilz);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.ikT.setClickable(true);
                    CommitView.this.ikT.setBackgroundResource(d.C0236d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.ikT.setClickable(false);
                CommitView.this.ikT.setBackgroundResource(d.C0236d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.ilu;
        addView(this.mCheckBox, layoutParams);
    }

    private void bXh() {
        this.ikT = new Button(this.mContext);
        this.ikT.setGravity(17);
        this.ikT.setTextColor(this.ilC);
        this.ikT.setTextSize(0, this.alK);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.ilv);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.ikT.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.ikT, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.iir)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.ilA);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.ilu;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.iir);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.ils, this.ils);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.ils);
                this.mCheckBox.setText(cVar.iir);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.j.push_commit);
            }
            this.ikT.getLayoutParams().height = this.ilv;
            this.ikT.setPadding(0, 0, 0, 0);
            this.ikT.setTextSize(0, this.alK);
            this.ikT.setText(str);
            this.ikV = cVar.postUrl;
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
    public boolean bXi() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.ikT;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.ikT.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
