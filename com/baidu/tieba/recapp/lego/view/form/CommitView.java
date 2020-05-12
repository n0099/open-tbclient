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
/* loaded from: classes13.dex */
public class CommitView extends FormItemBaseView {
    private Button kvk;
    private int kvl;
    private String kvm;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.kvk = null;
        this.kvl = 1;
        this.kvm = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.kvk = null;
        this.kvl = 1;
        this.kvm = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.kvk = null;
        this.kvl = 1;
        this.kvm = "";
        init();
    }

    private void init() {
        cNJ();
        cNK();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.kvm;
    }

    private void cNJ() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.kvl);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.kvP);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.kvk.setClickable(true);
                    CommitView.this.kvk.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.kvk.setClickable(false);
                CommitView.this.kvk.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.kvK;
        addView(this.mCheckBox, layoutParams);
    }

    private void cNK() {
        this.kvk = new Button(this.mContext);
        this.kvk.setGravity(17);
        this.kvk.setTextColor(this.kvS);
        this.kvk.setTextSize(0, this.bFw);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kvL);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.kvk.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.kvk, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.ksX)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.kvQ);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.kvK;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.ksX);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.kvI, this.kvI);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.kvI);
                this.mCheckBox.setText(cVar.ksX);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.kvk.getLayoutParams().height = this.kvL;
            this.kvk.setPadding(0, 0, 0, 0);
            this.kvk.setTextSize(0, this.bFw);
            this.kvk.setText(str);
            this.kvm = cVar.postUrl;
            return true;
        }
        return false;
    }

    private int a(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.kvk;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.kvk.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
