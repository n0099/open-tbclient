package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class e extends FormItemBaseView {
    private TextView aHU;
    private ImageView gGB;
    private ImageView gGC;
    private ImageView gGD;
    private ImageView gGE;

    public e(Context context) {
        super(context);
        this.aHU = null;
        this.gGB = null;
        this.gGC = null;
        this.gGD = null;
        this.gGE = null;
        init();
    }

    private void init() {
        this.aHU = new TextView(this.mContext);
        this.gGB = new ImageView(this.mContext);
        this.gGC = new ImageView(this.mContext);
        this.gGD = new ImageView(this.mContext);
        this.gGE = new ImageView(this.mContext);
        Jo();
        a(this.gGD, true, 2);
        a(this.gGE, false, 3);
        a(this.gGB, true);
        a(this.gGC, false);
    }

    private void Jo() {
        this.aHU.setTextSize(0, this.gGp);
        this.aHU.setTextColor(-1);
        this.aHU.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.aHU, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gGD.getId());
        } else {
            layoutParams.addRule(1, this.gGE.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gGt);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.aHU.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.aHU.getId());
        }
        layoutParams.leftMargin = this.gGf;
        layoutParams.rightMargin = this.gGf;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.aHU.setTextSize(0, this.gGp);
            this.aHU.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGD.getLayoutParams();
            marginLayoutParams.leftMargin = this.gGf;
            marginLayoutParams.rightMargin = this.gGf;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gGE.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gGf;
            marginLayoutParams2.rightMargin = this.gGf;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boF() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
