package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes10.dex */
public class TitleView extends FormItemBaseView {
    private TextView cGB;
    private ImageView jGp;
    private ImageView jGq;
    private ImageView jGr;
    private ImageView jGs;

    public TitleView(Context context) {
        super(context);
        this.cGB = null;
        this.jGp = null;
        this.jGq = null;
        this.jGr = null;
        this.jGs = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGB = null;
        this.jGp = null;
        this.jGq = null;
        this.jGr = null;
        this.jGs = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGB = null;
        this.jGp = null;
        this.jGq = null;
        this.jGr = null;
        this.jGs = null;
        init();
    }

    private void init() {
        this.cGB = new TextView(this.mContext);
        this.jGp = new ImageView(this.mContext);
        this.jGq = new ImageView(this.mContext);
        this.jGr = new ImageView(this.mContext);
        this.jGs = new ImageView(this.mContext);
        cAB();
        a(this.jGr, true, 2);
        a(this.jGs, false, 3);
        c(this.jGp, true);
        c(this.jGq, false);
    }

    private void cAB() {
        this.cGB.setTextSize(0, this.jGe);
        this.cGB.setTextColor(-1);
        this.cGB.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.cGB, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.jGr.getId());
        } else {
            layoutParams.addRule(1, this.jGs.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.jGi);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.cGB.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.cGB.getId());
        }
        layoutParams.leftMargin = this.jFV;
        layoutParams.rightMargin = this.jFV;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.cGB.setTextSize(0, this.jGe);
            this.cGB.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jGr.getLayoutParams();
            marginLayoutParams.leftMargin = this.jFV;
            marginLayoutParams.rightMargin = this.jFV;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jGs.getLayoutParams();
            marginLayoutParams2.leftMargin = this.jFV;
            marginLayoutParams2.rightMargin = this.jFV;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cAq() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
