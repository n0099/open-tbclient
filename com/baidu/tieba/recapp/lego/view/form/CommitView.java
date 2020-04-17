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
    private Button kvg;
    private int kvh;
    private String kvi;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.kvg = null;
        this.kvh = 1;
        this.kvi = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.kvg = null;
        this.kvh = 1;
        this.kvi = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.kvg = null;
        this.kvh = 1;
        this.kvi = "";
        init();
    }

    private void init() {
        cNL();
        cNM();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.kvi;
    }

    private void cNL() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.kvh);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.kvL);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.kvg.setClickable(true);
                    CommitView.this.kvg.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.kvg.setClickable(false);
                CommitView.this.kvg.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.kvG;
        addView(this.mCheckBox, layoutParams);
    }

    private void cNM() {
        this.kvg = new Button(this.mContext);
        this.kvg.setGravity(17);
        this.kvg.setTextColor(this.kvO);
        this.kvg.setTextSize(0, this.bFr);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kvH);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.kvg.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.kvg, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.ksT)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.kvM);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.kvG;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.ksT);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.kvE, this.kvE);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.kvE);
                this.mCheckBox.setText(cVar.ksT);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.kvg.getLayoutParams().height = this.kvH;
            this.kvg.setPadding(0, 0, 0, 0);
            this.kvg.setTextSize(0, this.bFr);
            this.kvg.setText(str);
            this.kvi = cVar.postUrl;
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
    public boolean cNN() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.kvg;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.kvg.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
