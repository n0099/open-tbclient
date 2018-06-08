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
    private TextView abq;
    private ImageView gnU;
    private ImageView gnV;
    private ImageView gnW;
    private ImageView gnX;

    public TitleView(Context context) {
        super(context);
        this.abq = null;
        this.gnU = null;
        this.gnV = null;
        this.gnW = null;
        this.gnX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abq = null;
        this.gnU = null;
        this.gnV = null;
        this.gnW = null;
        this.gnX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abq = null;
        this.gnU = null;
        this.gnV = null;
        this.gnW = null;
        this.gnX = null;
        init();
    }

    private void init() {
        this.abq = new TextView(this.mContext);
        this.gnU = new ImageView(this.mContext);
        this.gnV = new ImageView(this.mContext);
        this.gnW = new ImageView(this.mContext);
        this.gnX = new ImageView(this.mContext);
        boU();
        a(this.gnW, true, 2);
        a(this.gnX, false, 3);
        a(this.gnU, true);
        a(this.gnV, false);
    }

    private void boU() {
        this.abq.setTextSize(0, this.gnJ);
        this.abq.setTextColor(-1);
        this.abq.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.abq, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gnW.getId());
        } else {
            layoutParams.addRule(1, this.gnX.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gnN);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.abq.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.abq.getId());
        }
        layoutParams.leftMargin = this.gnz;
        layoutParams.rightMargin = this.gnz;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.abq.setTextSize(0, this.gnJ);
            this.abq.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gnW.getLayoutParams();
            marginLayoutParams.leftMargin = this.gnz;
            marginLayoutParams.rightMargin = this.gnz;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gnX.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gnz;
            marginLayoutParams2.rightMargin = this.gnz;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean boJ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
