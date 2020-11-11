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
    private Button mwP;
    private int mwQ;
    private String mwR;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.mwP = null;
        this.mwQ = 1;
        this.mwR = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.mwP = null;
        this.mwQ = 1;
        this.mwR = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.mwP = null;
        this.mwQ = 1;
        this.mwR = "";
        init();
    }

    private void init() {
        dAM();
        dAN();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mwR;
    }

    private void dAM() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mwQ);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.mxu);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.mwP.setClickable(true);
                    CommitView.this.mwP.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.mwP.setClickable(false);
                CommitView.this.mwP.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.mxp;
        addView(this.mCheckBox, layoutParams);
    }

    private void dAN() {
        this.mwP = new Button(this.mContext);
        this.mwP.setGravity(17);
        this.mwP.setTextColor(this.mxx);
        this.mwP.setTextSize(0, this.cCt);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mxq);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.mwP.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.mwP, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.muD)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mxv);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.mxp;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.muD);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.mxn, this.mxn);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.mxn);
                this.mCheckBox.setText(cVar.muD);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.mwP.getLayoutParams().height = this.mxq;
            this.mwP.setPadding(0, 0, 0, 0);
            this.mwP.setTextSize(0, this.cCt);
            this.mwP.setText(str);
            this.mwR = cVar.postUrl;
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
    public boolean dAO() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.mwP;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.mwP.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
