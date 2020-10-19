package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes26.dex */
public class TitleView extends FormItemBaseView {
    private TextView egP;
    private ImageView mfm;
    private ImageView mfn;
    private ImageView mfo;
    private ImageView mfp;

    public TitleView(Context context) {
        super(context);
        this.egP = null;
        this.mfm = null;
        this.mfn = null;
        this.mfo = null;
        this.mfp = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.egP = null;
        this.mfm = null;
        this.mfn = null;
        this.mfo = null;
        this.mfp = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.egP = null;
        this.mfm = null;
        this.mfn = null;
        this.mfo = null;
        this.mfp = null;
        init();
    }

    private void init() {
        this.egP = new TextView(this.mContext);
        this.mfm = new ImageView(this.mContext);
        this.mfn = new ImageView(this.mContext);
        this.mfo = new ImageView(this.mContext);
        this.mfp = new ImageView(this.mContext);
        dvq();
        a(this.mfo, true, 2);
        a(this.mfp, false, 3);
        c(this.mfm, true);
        c(this.mfn, false);
    }

    private void dvq() {
        this.egP.setTextSize(0, this.mfb);
        this.egP.setTextColor(-1);
        this.egP.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.egP, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mfo.getId());
        } else {
            layoutParams.addRule(1, this.mfp.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mff);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.egP.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.egP.getId());
        }
        layoutParams.leftMargin = this.meS;
        layoutParams.rightMargin = this.meS;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.egP.setTextSize(0, this.mfb);
            this.egP.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mfo.getLayoutParams();
            marginLayoutParams.leftMargin = this.meS;
            marginLayoutParams.rightMargin = this.meS;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mfp.getLayoutParams();
            marginLayoutParams2.leftMargin = this.meS;
            marginLayoutParams2.rightMargin = this.meS;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dvf() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
