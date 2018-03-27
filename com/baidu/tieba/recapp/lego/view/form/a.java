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
    private Button gFG;
    private int gFH;
    private String gFI;

    public a(Context context) {
        super(context);
        this.Io = null;
        this.gFG = null;
        this.gFH = 1;
        this.gFI = "";
        init();
    }

    private void init() {
        boD();
        boE();
        setBackgroundColor(0);
    }

    public String getPostUrl() {
        return this.gFI;
    }

    private void boD() {
        this.Io = new CheckBox(this.mContext, null, d.k.form_check_box_style);
        this.Io.setId(this.gFH);
        this.Io.setTextSize(0, (int) this.mResources.getDimension(d.e.fontsize20));
        this.Io.setTextColor(this.gGm);
        this.Io.setGravity(19);
        this.Io.setChecked(true);
        this.Io.setButtonDrawable((Drawable) null);
        this.Io.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.recapp.lego.view.form.a.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    a.this.gFG.setClickable(true);
                    a.this.gFG.setBackgroundResource(d.C0141d.form_button_bg_color_enable);
                    return;
                }
                a.this.gFG.setClickable(false);
                a.this.gFG.setBackgroundResource(d.C0141d.form_button_bg_color_unenable);
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = this.gGh;
        addView(this.Io, layoutParams);
    }

    private void boE() {
        this.gFG = new Button(this.mContext);
        this.gFG.setGravity(17);
        this.gFG.setTextColor(this.gGq);
        this.gFG.setTextSize(0, this.gGn);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.gGi);
        layoutParams.addRule(3, this.Io.getId());
        this.gFG.setBackgroundDrawable(this.mResources.getDrawable(d.f.form_commit_button_selector));
        addView(this.gFG, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            FormCard.c cVar = (FormCard.c) bVar;
            if (TextUtils.isEmpty(cVar.gDu)) {
                this.Io.setVisibility(8);
            } else {
                this.Io.setVisibility(0);
                this.Io.setTextSize(0, this.gGo);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Io.getLayoutParams();
                marginLayoutParams.bottomMargin = this.gGh;
                marginLayoutParams.height = c(this.Io.getPaint(), cVar.gDu);
                Drawable drawable = this.mResources.getDrawable(d.f.form_checkbox_selector);
                drawable.setBounds(0, 0, this.gGf, this.gGf);
                this.Io.setCompoundDrawables(drawable, null, null, null);
                this.Io.setCompoundDrawablePadding(this.gGf);
                this.Io.setText(cVar.gDu);
            }
            String str = cVar.content;
            if (TextUtils.isEmpty(str)) {
                str = this.mResources.getString(d.j.push_commit);
            }
            this.gFG.getLayoutParams().height = this.gGi;
            this.gFG.setPadding(0, 0, 0, 0);
            this.gFG.setTextSize(0, this.gGn);
            this.gFG.setText(str);
            this.gFI = cVar.postUrl;
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
        return this.gFG;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        this.gFG.setClickable(z);
        this.Io.setClickable(z);
    }
}
