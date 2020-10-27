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
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes26.dex */
public class CommitView extends FormItemBaseView {
    private CheckBox mCheckBox;
    private Button mqS;
    private int mqT;
    private String mqU;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mqS = null;
        this.mqT = 1;
        this.mqU = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mqS = null;
        this.mqT = 1;
        this.mqU = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mqS = null;
        this.mqT = 1;
        this.mqU = "";
        init();
    }

    private void init() {
        dyk();
        dyl();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mqU;
    }

    private void dyk() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mqT);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mrx);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mqS.setClickable(true);
                    CommitView.this.mqS.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mqS.setClickable(false);
                CommitView.this.mqS.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mrs;
        addView(this.mCheckBox, layoutParams);
    }

    private void dyl() {
        this.mqS = new Button(this.mContext);
        this.mqS.setGravity(17);
        this.mqS.setTextColor(this.mrA);
        this.mqS.setTextSize(0, this.cwA);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mrt);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mqS.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mqS, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.moG)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mry);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mrs;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.moG);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mrq, this.mrq);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mrq);
                this.mCheckBox.setText(cVar.moG);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mqS.getLayoutParams().height = this.mrt;
            this.mqS.setPadding(0, 0, 0, 0);
            this.mqS.setTextSize(0, this.cwA);
            this.mqS.setText(str);
            this.mqU = cVar.postUrl;
            return true;
        }
        return false;
    }

    private int b(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dym() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mqS;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mqS.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
