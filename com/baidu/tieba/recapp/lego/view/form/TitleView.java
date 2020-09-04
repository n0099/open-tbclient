package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes20.dex */
public class TitleView extends FormItemBaseView {
    private TextView dSD;
    private ImageView lHa;
    private ImageView lHb;
    private ImageView lHc;
    private ImageView lHd;

    public TitleView(Context context) {
        super(context);
        this.dSD = null;
        this.lHa = null;
        this.lHb = null;
        this.lHc = null;
        this.lHd = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSD = null;
        this.lHa = null;
        this.lHb = null;
        this.lHc = null;
        this.lHd = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSD = null;
        this.lHa = null;
        this.lHb = null;
        this.lHc = null;
        this.lHd = null;
        init();
    }

    private void init() {
        this.dSD = new TextView(this.mContext);
        this.lHa = new ImageView(this.mContext);
        this.lHb = new ImageView(this.mContext);
        this.lHc = new ImageView(this.mContext);
        this.lHd = new ImageView(this.mContext);
        dnW();
        a(this.lHc, true, 2);
        a(this.lHd, false, 3);
        c(this.lHa, true);
        c(this.lHb, false);
    }

    private void dnW() {
        this.dSD.setTextSize(0, this.lGP);
        this.dSD.setTextColor(-1);
        this.dSD.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dSD, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.lHc.getId());
        } else {
            layoutParams.addRule(1, this.lHd.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.lGT);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dSD.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dSD.getId());
        }
        layoutParams.leftMargin = this.lGG;
        layoutParams.rightMargin = this.lGG;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dSD.setTextSize(0, this.lGP);
            this.dSD.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lHc.getLayoutParams();
            marginLayoutParams.leftMargin = this.lGG;
            marginLayoutParams.rightMargin = this.lGG;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lHd.getLayoutParams();
            marginLayoutParams2.leftMargin = this.lGG;
            marginLayoutParams2.rightMargin = this.lGG;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dnL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
