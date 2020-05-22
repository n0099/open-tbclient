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
    private Button kNd;
    private int kNe;
    private String kNf;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.kNd = null;
        this.kNe = 1;
        this.kNf = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.kNd = null;
        this.kNe = 1;
        this.kNf = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.kNd = null;
        this.kNe = 1;
        this.kNf = "";
        init();
    }

    private void init() {
        cUJ();
        cUK();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.kNf;
    }

    private void cUJ() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.kNe);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.kNI);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.kNd.setClickable(true);
                    CommitView.this.kNd.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.kNd.setClickable(false);
                CommitView.this.kNd.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.kND;
        addView(this.mCheckBox, layoutParams);
    }

    private void cUK() {
        this.kNd = new Button(this.mContext);
        this.kNd.setGravity(17);
        this.kNd.setTextColor(this.kNL);
        this.kNd.setTextSize(0, this.bOo);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.kNE);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.kNd.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.kNd, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.kKR)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.kNJ);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.kND;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.kKR);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.kNB, this.kNB);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.kNB);
                this.mCheckBox.setText(cVar.kKR);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.kNd.getLayoutParams().height = this.kNE;
            this.kNd.setPadding(0, 0, 0, 0);
            this.kNd.setTextSize(0, this.bOo);
            this.kNd.setText(str);
            this.kNf = cVar.postUrl;
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
    public boolean cUL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.kNd;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.kNd.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
