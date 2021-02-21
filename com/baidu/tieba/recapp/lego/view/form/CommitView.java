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
/* loaded from: classes8.dex */
public class CommitView extends FormItemBaseView {
    private CheckBox mCheckBox;
    private Button mVI;
    private int mVJ;
    private String mVK;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mVI = null;
        this.mVJ = 1;
        this.mVK = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mVI = null;
        this.mVJ = 1;
        this.mVK = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mVI = null;
        this.mVJ = 1;
        this.mVK = "";
        init();
    }

    private void init() {
        dDP();
        dDQ();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mVK;
    }

    private void dDP() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mVJ);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mWn);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mVI.setClickable(true);
                    CommitView.this.mVI.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mVI.setClickable(false);
                CommitView.this.mVI.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mWi;
        addView(this.mCheckBox, layoutParams);
    }

    private void dDQ() {
        this.mVI = new Button(this.mContext);
        this.mVI.setGravity(17);
        this.mVI.setTextColor(this.mButtonFontColor);
        this.mVI.setTextSize(0, this.cKa);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mWj);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mVI.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mVI, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.mTw)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mWo);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mWi;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.mTw);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mWg, this.mWg);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mWg);
                this.mCheckBox.setText(cVar.mTw);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mVI.getLayoutParams().height = this.mWj;
            this.mVI.setPadding(0, 0, 0, 0);
            this.mVI.setTextSize(0, this.cKa);
            this.mVI.setText(str);
            this.mVK = cVar.postUrl;
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
    public boolean dDR() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mVI;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mVI.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
