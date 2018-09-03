package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView aaX;
    private ImageView gta;
    private ImageView gtb;
    private ImageView gtc;
    private ImageView gtd;

    public TitleView(Context context) {
        super(context);
        this.aaX = null;
        this.gta = null;
        this.gtb = null;
        this.gtc = null;
        this.gtd = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaX = null;
        this.gta = null;
        this.gtb = null;
        this.gtc = null;
        this.gtd = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaX = null;
        this.gta = null;
        this.gtb = null;
        this.gtc = null;
        this.gtd = null;
        init();
    }

    private void init() {
        this.aaX = new TextView(this.mContext);
        this.gta = new ImageView(this.mContext);
        this.gtb = new ImageView(this.mContext);
        this.gtc = new ImageView(this.mContext);
        this.gtd = new ImageView(this.mContext);
        bob();
        a(this.gtc, true, 2);
        a(this.gtd, false, 3);
        a(this.gta, true);
        a(this.gtb, false);
    }

    private void bob() {
        this.aaX.setTextSize(0, this.gsP);
        this.aaX.setTextColor(-1);
        this.aaX.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.aaX, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(f.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gtc.getId());
        } else {
            layoutParams.addRule(1, this.gtd.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gsT);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(f.C0146f.form_title_icon_left);
            layoutParams.addRule(0, this.aaX.getId());
        } else {
            imageView.setImageResource(f.C0146f.form_title_icon_right);
            layoutParams.addRule(1, this.aaX.getId());
        }
        layoutParams.leftMargin = this.gsF;
        layoutParams.rightMargin = this.gsF;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.aaX.setTextSize(0, this.gsP);
            this.aaX.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gtc.getLayoutParams();
            marginLayoutParams.leftMargin = this.gsF;
            marginLayoutParams.rightMargin = this.gsF;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gtd.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gsF;
            marginLayoutParams2.rightMargin = this.gsF;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bnP() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
