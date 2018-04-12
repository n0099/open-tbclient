package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView Tm;
    private ImageView gbA;
    private ImageView gbB;
    private ImageView gbC;
    private ImageView gbz;

    public TitleView(Context context) {
        super(context);
        this.Tm = null;
        this.gbz = null;
        this.gbA = null;
        this.gbB = null;
        this.gbC = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tm = null;
        this.gbz = null;
        this.gbA = null;
        this.gbB = null;
        this.gbC = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Tm = null;
        this.gbz = null;
        this.gbA = null;
        this.gbB = null;
        this.gbC = null;
        init();
    }

    private void init() {
        this.Tm = new TextView(this.mContext);
        this.gbz = new ImageView(this.mContext);
        this.gbA = new ImageView(this.mContext);
        this.gbB = new ImageView(this.mContext);
        this.gbC = new ImageView(this.mContext);
        bjW();
        a(this.gbB, true, 2);
        a(this.gbC, false, 3);
        a(this.gbz, true);
        a(this.gbA, false);
    }

    private void bjW() {
        this.Tm.setTextSize(0, this.gbo);
        this.Tm.setTextColor(-1);
        this.Tm.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.Tm, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gbB.getId());
        } else {
            layoutParams.addRule(1, this.gbC.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gbs);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.Tm.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.Tm.getId());
        }
        layoutParams.leftMargin = this.gbe;
        layoutParams.rightMargin = this.gbe;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.Tm.setTextSize(0, this.gbo);
            this.Tm.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gbB.getLayoutParams();
            marginLayoutParams.leftMargin = this.gbe;
            marginLayoutParams.rightMargin = this.gbe;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gbC.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gbe;
            marginLayoutParams2.rightMargin = this.gbe;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
