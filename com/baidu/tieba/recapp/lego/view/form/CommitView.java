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
    private Button lif;
    private int lig;
    private String lih;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.lif = null;
        this.lig = 1;
        this.lih = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.lif = null;
        this.lig = 1;
        this.lih = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.lif = null;
        this.lig = 1;
        this.lih = "";
        init();
    }

    private void init() {
        cZp();
        cZq();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.lih;
    }

    private void cZp() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.lig);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.liK);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.lif.setClickable(true);
                    CommitView.this.lif.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.lif.setClickable(false);
                CommitView.this.lif.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.liF;
        addView(this.mCheckBox, layoutParams);
    }

    private void cZq() {
        this.lif = new Button(this.mContext);
        this.lif.setGravity(17);
        this.lif.setTextColor(this.liN);
        this.lif.setTextSize(0, this.bTc);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.liG);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.lif.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.lif, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.lfU)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.liL);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.liF;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.lfU);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.liD, this.liD);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.liD);
                this.mCheckBox.setText(cVar.lfU);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.lif.getLayoutParams().height = this.liG;
            this.lif.setPadding(0, 0, 0, 0);
            this.lif.setTextSize(0, this.bTc);
            this.lif.setText(str);
            this.lih = cVar.postUrl;
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
    public boolean cZr() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.lif;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.lif.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
