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
    private Button mLr;
    private int mLs;
    private String mLt;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mLr = null;
        this.mLs = 1;
        this.mLt = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mLr = null;
        this.mLs = 1;
        this.mLt = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mLr = null;
        this.mLs = 1;
        this.mLt = "";
        init();
    }

    private void init() {
        dFB();
        dFC();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mLt;
    }

    private void dFB() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mLs);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mLW);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mLr.setClickable(true);
                    CommitView.this.mLr.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mLr.setClickable(false);
                CommitView.this.mLr.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mLR;
        addView(this.mCheckBox, layoutParams);
    }

    private void dFC() {
        this.mLr = new Button(this.mContext);
        this.mLr.setGravity(17);
        this.mLr.setTextColor(this.mLZ);
        this.mLr.setTextSize(0, this.cHF);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mLS);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mLr.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mLr, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.mJi)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mLX);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mLR;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.mJi);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mLP, this.mLP);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mLP);
                this.mCheckBox.setText(cVar.mJi);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mLr.getLayoutParams().height = this.mLS;
            this.mLr.setPadding(0, 0, 0, 0);
            this.mLr.setTextSize(0, this.cHF);
            this.mLr.setText(str);
            this.mLt = cVar.postUrl;
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
    public boolean dFD() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mLr;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mLr.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
