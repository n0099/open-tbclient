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
    private TextView aHT;
    private ImageView gGl;
    private ImageView gGm;
    private ImageView gGn;
    private ImageView gGo;

    public e(Context context) {
        super(context);
        this.aHT = null;
        this.gGl = null;
        this.gGm = null;
        this.gGn = null;
        this.gGo = null;
        init();
    }

    private void init() {
        this.aHT = new TextView(this.mContext);
        this.gGl = new ImageView(this.mContext);
        this.gGm = new ImageView(this.mContext);
        this.gGn = new ImageView(this.mContext);
        this.gGo = new ImageView(this.mContext);
        Jn();
        a(this.gGn, true, 2);
        a(this.gGo, false, 3);
        a(this.gGl, true);
        a(this.gGm, false);
    }

    private void Jn() {
        this.aHT.setTextSize(0, this.gFZ);
        this.aHT.setTextColor(-1);
        this.aHT.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.aHT, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gGn.getId());
        } else {
            layoutParams.addRule(1, this.gGo.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gGd);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.aHT.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.aHT.getId());
        }
        layoutParams.leftMargin = this.gFP;
        layoutParams.rightMargin = this.gFP;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.aHT.setTextSize(0, this.gFZ);
            this.aHT.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gGn.getLayoutParams();
            marginLayoutParams.leftMargin = this.gFP;
            marginLayoutParams.rightMargin = this.gFP;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gGo.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gFP;
            marginLayoutParams2.rightMargin = this.gFP;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public boolean boE() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
