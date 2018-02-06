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
    private TextView aIe;
    private ImageView gGA;
    private ImageView gGB;
    private ImageView gGC;
    private ImageView gGD;

    public e(Context context) {
        super(context);
        this.aIe = null;
        this.gGA = null;
        this.gGB = null;
        this.gGC = null;
        this.gGD = null;
        init();
    }

    private void init() {
        this.aIe = new TextView(this.mContext);
        this.gGA = new ImageView(this.mContext);
        this.gGB = new ImageView(this.mContext);
        this.gGC = new ImageView(this.mContext);
        this.gGD = new ImageView(this.mContext);
        Jo();
        a(this.gGC, true, 2);
        a(this.gGD, false, 3);
        a(this.gGA, true);
        a(this.gGB, false);
    }

    private void Jo() {
        this.aIe.setTextSize(0, this.gGo);
        this.aIe.setTextColor(-1);
        this.aIe.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.aIe, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gGC.getId());
        } else {
            layoutParams.addRule(1, this.gGD.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gGs);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.aIe.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.aIe.getId());
        }
        layoutParams.leftMargin = this.gGe;
        layoutParams.rightMargin = this.gGe;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.aIe.setTextSize(0, this.gGo);
            this.aIe.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGC.getLayoutParams();
            marginLayoutParams.leftMargin = this.gGe;
            marginLayoutParams.rightMargin = this.gGe;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gGD.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gGe;
            marginLayoutParams2.rightMargin = this.gGe;
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
