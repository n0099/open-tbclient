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
    private TextView btX;
    private ImageView ilL;
    private ImageView ilM;
    private ImageView ilN;
    private ImageView ilO;

    public TitleView(Context context) {
        super(context);
        this.btX = null;
        this.ilL = null;
        this.ilM = null;
        this.ilN = null;
        this.ilO = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btX = null;
        this.ilL = null;
        this.ilM = null;
        this.ilN = null;
        this.ilO = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btX = null;
        this.ilL = null;
        this.ilM = null;
        this.ilN = null;
        this.ilO = null;
        init();
    }

    private void init() {
        this.btX = new TextView(this.mContext);
        this.ilL = new ImageView(this.mContext);
        this.ilM = new ImageView(this.mContext);
        this.ilN = new ImageView(this.mContext);
        this.ilO = new ImageView(this.mContext);
        bXt();
        a(this.ilN, true, 2);
        a(this.ilO, false, 3);
        a(this.ilL, true);
        a(this.ilM, false);
    }

    private void bXt() {
        this.btX.setTextSize(0, this.ilA);
        this.btX.setTextColor(-1);
        this.btX.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.btX, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.ilN.getId());
        } else {
            layoutParams.addRule(1, this.ilO.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.ilE);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.btX.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.btX.getId());
        }
        layoutParams.leftMargin = this.ilr;
        layoutParams.rightMargin = this.ilr;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.btX.setTextSize(0, this.ilA);
            this.btX.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilN.getLayoutParams();
            marginLayoutParams.leftMargin = this.ilr;
            marginLayoutParams.rightMargin = this.ilr;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ilO.getLayoutParams();
            marginLayoutParams2.leftMargin = this.ilr;
            marginLayoutParams2.rightMargin = this.ilr;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXh() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
