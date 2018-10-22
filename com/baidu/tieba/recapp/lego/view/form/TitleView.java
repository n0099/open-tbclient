package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView aiy;
    private ImageView gHU;
    private ImageView gHV;
    private ImageView gHW;
    private ImageView gHX;

    public TitleView(Context context) {
        super(context);
        this.aiy = null;
        this.gHU = null;
        this.gHV = null;
        this.gHW = null;
        this.gHX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aiy = null;
        this.gHU = null;
        this.gHV = null;
        this.gHW = null;
        this.gHX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aiy = null;
        this.gHU = null;
        this.gHV = null;
        this.gHW = null;
        this.gHX = null;
        init();
    }

    private void init() {
        this.aiy = new TextView(this.mContext);
        this.gHU = new ImageView(this.mContext);
        this.gHV = new ImageView(this.mContext);
        this.gHW = new ImageView(this.mContext);
        this.gHX = new ImageView(this.mContext);
        btX();
        a(this.gHW, true, 2);
        a(this.gHX, false, 3);
        a(this.gHU, true);
        a(this.gHV, false);
    }

    private void btX() {
        this.aiy.setTextSize(0, this.gHJ);
        this.aiy.setTextColor(-1);
        this.aiy.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.aiy, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(e.C0175e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gHW.getId());
        } else {
            layoutParams.addRule(1, this.gHX.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gHN);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(e.f.form_title_icon_left);
            layoutParams.addRule(0, this.aiy.getId());
        } else {
            imageView.setImageResource(e.f.form_title_icon_right);
            layoutParams.addRule(1, this.aiy.getId());
        }
        layoutParams.leftMargin = this.gHA;
        layoutParams.rightMargin = this.gHA;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.aiy.setTextSize(0, this.gHJ);
            this.aiy.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gHW.getLayoutParams();
            marginLayoutParams.leftMargin = this.gHA;
            marginLayoutParams.rightMargin = this.gHA;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gHX.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gHA;
            marginLayoutParams2.rightMargin = this.gHA;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean btL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
