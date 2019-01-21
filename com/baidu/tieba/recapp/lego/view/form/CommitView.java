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
    private Button gTq;
    private int gTr;
    private String gTs;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.gTq = null;
        this.gTr = 1;
        this.gTs = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.gTq = null;
        this.gTr = 1;
        this.gTs = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.gTq = null;
        this.gTr = 1;
        this.gTs = "";
        init();
    }

    private void init() {
        bws();
        bwt();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gTs;
    }

    private void bws() {
        this.mCheckBox = new CheckBox(this.mContext, null, e.k.form_check_box_style);
        this.mCheckBox.setId(this.gTr);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(e.C0210e.fontsize20));
        this.mCheckBox.setTextColor(this.gTW);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.gTq.setClickable(true);
                    CommitView.this.gTq.setBackgroundResource(e.d.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.gTq.setClickable(false);
                CommitView.this.gTq.setBackgroundResource(e.d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gTR;
        addView(this.mCheckBox, layoutParams);
    }

    private void bwt() {
        this.gTq = new Button(this.mContext);
        this.gTq.setGravity(17);
        this.gTq.setTextColor(this.gTZ);
        this.gTq.setTextSize(0, this.mFontSize);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gTS);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.gTq.setBackgroundDrawable(this.mResources.getDrawable(e.f.form_commit_button_selector));
        addView(this.gTq, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gQM)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.gTX);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gTR;
                marginLayoutParams.height = d(this.mCheckBox.getPaint(), cVar.gQM);
                Drawable drawable = this.mResources.getDrawable(e.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gTP, this.gTP);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.gTP);
                this.mCheckBox.setText(cVar.gQM);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(e.j.push_commit);
            }
            this.gTq.getLayoutParams().height = this.gTS;
            this.gTq.setPadding(0, 0, 0, 0);
            this.gTq.setTextSize(0, this.mFontSize);
            this.gTq.setText(str);
            this.gTs = cVar.postUrl;
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
    public boolean bwu() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gTq;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gTq.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
