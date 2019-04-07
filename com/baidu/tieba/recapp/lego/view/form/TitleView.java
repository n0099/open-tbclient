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
    private TextView buc;
    private ImageView ilr;
    private ImageView ils;
    private ImageView ilt;
    private ImageView ilu;

    public TitleView(Context context) {
        super(context);
        this.buc = null;
        this.ilr = null;
        this.ils = null;
        this.ilt = null;
        this.ilu = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.buc = null;
        this.ilr = null;
        this.ils = null;
        this.ilt = null;
        this.ilu = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.buc = null;
        this.ilr = null;
        this.ils = null;
        this.ilt = null;
        this.ilu = null;
        init();
    }

    private void init() {
        this.buc = new TextView(this.mContext);
        this.ilr = new ImageView(this.mContext);
        this.ils = new ImageView(this.mContext);
        this.ilt = new ImageView(this.mContext);
        this.ilu = new ImageView(this.mContext);
        bXs();
        a(this.ilt, true, 2);
        a(this.ilu, false, 3);
        a(this.ilr, true);
        a(this.ils, false);
    }

    private void bXs() {
        this.buc.setTextSize(0, this.ilg);
        this.buc.setTextColor(-1);
        this.buc.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.buc, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.ilt.getId());
        } else {
            layoutParams.addRule(1, this.ilu.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.ilk);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.buc.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.buc.getId());
        }
        layoutParams.leftMargin = this.ikX;
        layoutParams.rightMargin = this.ikX;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.buc.setTextSize(0, this.ilg);
            this.buc.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilt.getLayoutParams();
            marginLayoutParams.leftMargin = this.ikX;
            marginLayoutParams.rightMargin = this.ikX;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ilu.getLayoutParams();
            marginLayoutParams2.leftMargin = this.ikX;
            marginLayoutParams2.rightMargin = this.ikX;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXg() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
