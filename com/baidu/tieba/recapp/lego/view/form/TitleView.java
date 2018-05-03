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
    private ImageView gbw;
    private ImageView gbx;
    private ImageView gby;
    private ImageView gbz;

    public TitleView(Context context) {
        super(context);
        this.Tm = null;
        this.gbw = null;
        this.gbx = null;
        this.gby = null;
        this.gbz = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Tm = null;
        this.gbw = null;
        this.gbx = null;
        this.gby = null;
        this.gbz = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Tm = null;
        this.gbw = null;
        this.gbx = null;
        this.gby = null;
        this.gbz = null;
        init();
    }

    private void init() {
        this.Tm = new TextView(this.mContext);
        this.gbw = new ImageView(this.mContext);
        this.gbx = new ImageView(this.mContext);
        this.gby = new ImageView(this.mContext);
        this.gbz = new ImageView(this.mContext);
        bjW();
        a(this.gby, true, 2);
        a(this.gbz, false, 3);
        a(this.gbw, true);
        a(this.gbx, false);
    }

    private void bjW() {
        this.Tm.setTextSize(0, this.gbl);
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
            layoutParams.addRule(0, this.gby.getId());
        } else {
            layoutParams.addRule(1, this.gbz.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gbp);
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
        layoutParams.leftMargin = this.gbb;
        layoutParams.rightMargin = this.gbb;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.Tm.setTextSize(0, this.gbl);
            this.Tm.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gby.getLayoutParams();
            marginLayoutParams.leftMargin = this.gbb;
            marginLayoutParams.rightMargin = this.gbb;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gbz.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gbb;
            marginLayoutParams2.rightMargin = this.gbb;
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
