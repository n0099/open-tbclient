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
/* loaded from: classes20.dex */
public class CommitView extends FormItemBaseView {
    private Button lpA;
    private int lpB;
    private String lpC;
    private CheckBox mCheckBox;

    public CommitView(Context context) {
        super(context);
        this.mCheckBox = null;
        this.lpA = null;
        this.lpB = 1;
        this.lpC = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mCheckBox = null;
        this.lpA = null;
        this.lpB = 1;
        this.lpC = "";
        init();
    }

    public CommitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mCheckBox = null;
        this.lpA = null;
        this.lpB = 1;
        this.lpC = "";
        init();
    }

    private void init() {
        dcx();
        dcy();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.lpC;
    }

    private void dcx() {
        this.mCheckBox = new CheckBox(this.mContext, null, R.style.form_check_box_style);
        this.mCheckBox.setId(this.lpB);
        this.mCheckBox.setTextSize(0, (int) this.mResources.getDimension(R.dimen.fontsize20));
        this.mCheckBox.setTextColor(this.lqf);
        this.mCheckBox.setGravity(19);
        this.mCheckBox.setChecked(true);
        this.mCheckBox.setButtonDrawable((Drawable) null);
        this.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.CommitView.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    CommitView.this.lpA.setClickable(true);
                    CommitView.this.lpA.setBackgroundResource(R.color.form_button_bg_color_enable);
                    return;
                }
                CommitView.this.lpA.setClickable(false);
                CommitView.this.lpA.setBackgroundResource(R.color.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.lqa;
        addView(this.mCheckBox, layoutParams);
    }

    private void dcy() {
        this.lpA = new Button(this.mContext);
        this.lpA.setGravity(17);
        this.lpA.setTextColor(this.lqi);
        this.lpA.setTextSize(0, this.bTU);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.lqb);
        layoutParams.addRule(3, this.mCheckBox.getId());
        this.lpA.setBackgroundDrawable(this.mResources.getDrawable(R.drawable.form_commit_button_selector));
        addView(this.lpA, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.lnl)) {
                this.mCheckBox.setVisibility(8);
            } else {
                this.mCheckBox.setVisibility(0);
                this.mCheckBox.setTextSize(0, this.lqg);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mCheckBox.getLayoutParams();
                marginLayoutParams.bottomMargin = this.lqa;
                marginLayoutParams.height = a(this.mCheckBox.getPaint(), cVar.lnl);
                Drawable drawable = this.mResources.getDrawable(R.drawable.form_checkbox_selector);
                drawable.setBounds(0, 0, this.lpY, this.lpY);
                this.mCheckBox.setCompoundDrawables(drawable, null, null, null);
                this.mCheckBox.setCompoundDrawablePadding(this.lpY);
                this.mCheckBox.setText(cVar.lnl);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(R.string.push_commit);
            }
            this.lpA.getLayoutParams().height = this.lqb;
            this.lpA.setPadding(0, 0, 0, 0);
            this.lpA.setTextSize(0, this.bTU);
            this.lpA.setText(str);
            this.lpC = cVar.postUrl;
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
    public boolean dcz() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.lpA;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.lpA.setClickable(z);
        this.mCheckBox.setClickable(z);
    }
}
