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
/* loaded from: classes7.dex */
public class CommitView extends FormItemBaseView {
    private CheckBox mCheckBox;
    private Button mLT;
    private int mLU;
    private String mLV;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mLT = null;
        this.mLU = 1;
        this.mLV = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mLT = null;
        this.mLU = 1;
        this.mLV = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mLT = null;
        this.mLU = 1;
        this.mLV = "";
        init();
    }

    private void init() {
        dBz();
        dBA();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mLV;
    }

    private void dBz() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mLU);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mMy);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mLT.setClickable(true);
                    CommitView.this.mLT.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mLT.setClickable(false);
                CommitView.this.mLT.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mMt;
        addView(this.mCheckBox, layoutParams);
    }

    private void dBA() {
        this.mLT = new Button(this.mContext);
        this.mLT.setGravity(17);
        this.mLT.setTextColor(this.mMB);
        this.mLT.setTextSize(0, this.cHI);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mMu);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mLT.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mLT, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.mJL)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mMz);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mMt;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.mJL);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mMr, this.mMr);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mMr);
                this.mCheckBox.setText(cVar.mJL);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mLT.getLayoutParams().height = this.mMu;
            this.mLT.setPadding(0, 0, 0, 0);
            this.mLT.setTextSize(0, this.cHI);
            this.mLT.setText(str);
            this.mLV = cVar.postUrl;
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
    public boolean dBB() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mLT;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mLT.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
