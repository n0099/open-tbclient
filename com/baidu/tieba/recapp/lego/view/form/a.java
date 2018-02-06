package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class a extends FormItemBaseView {
    private CheckBox It;
    private Button gFF;
    private int gFG;
    private String gFH;

    public a(Context context) {
        super(context);
        this.It = null;
        this.gFF = null;
        this.gFG = 1;
        this.gFH = "";
        init();
    }

    private void init() {
        boD();
        boE();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gFH;
    }

    private void boD() {
        this.It = new CheckBox(this.mContext, null, d.k.form_check_box_style);
        this.It.setId(this.gFG);
        this.It.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.It.setTextColor(this.gGl);
        this.It.setGravity(19);
        this.It.setChecked(true);
        this.It.setButtonDrawable((Drawable) null);
        this.It.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    a.this.gFF.setClickable(true);
                    a.this.gFF.setBackgroundResource(d.C0140d.form_button_bg_color_enable);
                    return;
                }
                a.this.gFF.setClickable(false);
                a.this.gFF.setBackgroundResource(d.C0140d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gGg;
        addView(this.It, layoutParams);
    }

    private void boE() {
        this.gFF = new Button(this.mContext);
        this.gFF.setGravity(17);
        this.gFF.setTextColor(this.gGp);
        this.gFF.setTextSize(0, this.gGm);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gGh);
        layoutParams.addRule(3, this.It.getId());
        this.gFF.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gFF, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gDt)) {
                this.It.setVisibility(8);
            } else {
                this.It.setVisibility(0);
                this.It.setTextSize(0, this.gGn);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.It.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gGg;
                marginLayoutParams.height = c(this.It.getPaint(), cVar.gDt);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gGe, this.gGe);
                this.It.setCompoundDrawables(drawable, null, null, null);
                this.It.setCompoundDrawablePadding(this.gGe);
                this.It.setText(cVar.gDt);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.j.push_commit);
            }
            this.gFF.getLayoutParams().height = this.gGh;
            this.gFF.setPadding(0, 0, 0, 0);
            this.gFF.setTextSize(0, this.gGm);
            this.gFF.setText(str);
            this.gFH = cVar.postUrl;
            return true;
        }
        return false;
    }

    private int c(Paint paint, String str) {
        paint.getTextBounds(str, 0, str.length(), new Rect());
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        return fontMetricsInt.bottom - fontMetricsInt.top;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boF() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gFF;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gFF.setClickable(z);
        this.It.setClickable(z);
    }
}
