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
    private CheckBox Io;
    private Button gFq;
    private int gFr;
    private String gFs;

    public a(Context context) {
        super(context);
        this.Io = null;
        this.gFq = null;
        this.gFr = 1;
        this.gFs = "";
        init();
    }

    private void init() {
        boC();
        boD();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gFs;
    }

    private void boC() {
        this.Io = new CheckBox(this.mContext, null, d.k.form_check_box_style);
        this.Io.setId(this.gFr);
        this.Io.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.Io.setTextColor(this.gFW);
        this.Io.setGravity(19);
        this.Io.setChecked(true);
        this.Io.setButtonDrawable((Drawable) null);
        this.Io.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    a.this.gFq.setClickable(true);
                    a.this.gFq.setBackgroundResource(d.C0141d.form_button_bg_color_enable);
                    return;
                }
                a.this.gFq.setClickable(false);
                a.this.gFq.setBackgroundResource(d.C0141d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gFR;
        addView(this.Io, layoutParams);
    }

    private void boD() {
        this.gFq = new Button(this.mContext);
        this.gFq.setGravity(17);
        this.gFq.setTextColor(this.gGa);
        this.gFq.setTextSize(0, this.gFX);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gFS);
        layoutParams.addRule(3, this.Io.getId());
        this.gFq.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gFq, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gDe)) {
                this.Io.setVisibility(8);
            } else {
                this.Io.setVisibility(0);
                this.Io.setTextSize(0, this.gFY);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Io.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gFR;
                marginLayoutParams.height = c(this.Io.getPaint(), cVar.gDe);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gFP, this.gFP);
                this.Io.setCompoundDrawables(drawable, null, null, null);
                this.Io.setCompoundDrawablePadding(this.gFP);
                this.Io.setText(cVar.gDe);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.j.push_commit);
            }
            this.gFq.getLayoutParams().height = this.gFS;
            this.gFq.setPadding(0, 0, 0, 0);
            this.gFq.setTextSize(0, this.gFX);
            this.gFq.setText(str);
            this.gFs = cVar.postUrl;
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
    public boolean boE() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public Button getCommitButton() {
        return this.gFq;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gFq.setClickable(z);
        this.Io.setClickable(z);
    }
}
