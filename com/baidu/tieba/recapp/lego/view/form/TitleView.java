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
    private TextView aaW;
    private ImageView gsX;
    private ImageView gsY;
    private ImageView gsZ;
    private ImageView gta;

    public TitleView(Context context) {
        super(context);
        this.aaW = null;
        this.gsX = null;
        this.gsY = null;
        this.gsZ = null;
        this.gta = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aaW = null;
        this.gsX = null;
        this.gsY = null;
        this.gsZ = null;
        this.gta = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aaW = null;
        this.gsX = null;
        this.gsY = null;
        this.gsZ = null;
        this.gta = null;
        init();
    }

    private void init() {
        this.aaW = new TextView(this.mContext);
        this.gsX = new ImageView(this.mContext);
        this.gsY = new ImageView(this.mContext);
        this.gsZ = new ImageView(this.mContext);
        this.gta = new ImageView(this.mContext);
        boa();
        a(this.gsZ, true, 2);
        a(this.gta, false, 3);
        a(this.gsX, true);
        a(this.gsY, false);
    }

    private void boa() {
        this.aaW.setTextSize(0, this.gsM);
        this.aaW.setTextColor(-1);
        this.aaW.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.aaW, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gsZ.getId());
        } else {
            layoutParams.addRule(1, this.gta.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gsQ);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.aaW.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.aaW.getId());
        }
        layoutParams.leftMargin = this.gsC;
        layoutParams.rightMargin = this.gsC;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.aaW.setTextSize(0, this.gsM);
            this.aaW.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gsZ.getLayoutParams();
            marginLayoutParams.leftMargin = this.gsC;
            marginLayoutParams.rightMargin = this.gsC;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gta.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gsC;
            marginLayoutParams2.rightMargin = this.gsC;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bnO() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
