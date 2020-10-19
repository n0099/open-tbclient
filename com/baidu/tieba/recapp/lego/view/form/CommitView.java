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
    private Button meu;
    private int mev;
    private String mew;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.meu = null;
        this.mev = 1;
        this.mew = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.meu = null;
        this.mev = 1;
        this.mew = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.meu = null;
        this.mev = 1;
        this.mew = "";
        init();
    }

    private void init() {
        dvd();
        dve();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.mew;
    }

    private void dvd() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.mev);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.meZ);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.meu.setClickable(true);
                    CommitView.this.meu.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.meu.setClickable(false);
                CommitView.this.meu.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.meU;
        addView(this.mCheckBox, layoutParams);
    }

    private void dve() {
        this.meu = new Button(this.mContext);
        this.meu.setGravity(17);
        this.meu.setTextColor(this.mfc);
        this.meu.setTextSize(0, this.cnX);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.meV);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.meu.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.meu, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.mch)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.mfa);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.meU;
                marginLayoutParams.height = b(this.mCheckBox.getPaint(), cVar.mch);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.meS, this.meS);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.meS);
                this.mCheckBox.setText(cVar.mch);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.meu.getLayoutParams().height = this.meV;
            this.meu.setPadding(0, 0, 0, 0);
            this.meu.setTextSize(0, this.cnX);
            this.meu.setText(str);
            this.mew = cVar.postUrl;
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
    public boolean dvf() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.meu;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.meu.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
