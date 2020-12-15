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
    private TextView eAz;
    private ImageView mMj;
    private ImageView mMk;
    private ImageView mMl;
    private ImageView mMm;

    public TitleView(Context context) {
        super(context);
        this.eAz = null;
        this.mMj = null;
        this.mMk = null;
        this.mMl = null;
        this.mMm = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAz = null;
        this.mMj = null;
        this.mMk = null;
        this.mMl = null;
        this.mMm = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAz = null;
        this.mMj = null;
        this.mMk = null;
        this.mMl = null;
        this.mMm = null;
        init();
    }

    private void init() {
        this.eAz = new TextView(this.mContext);
        this.mMj = new ImageView(this.mContext);
        this.mMk = new ImageView(this.mContext);
        this.mMl = new ImageView(this.mContext);
        this.mMm = new ImageView(this.mContext);
        dFO();
        a(this.mMl, true, 2);
        a(this.mMm, false, 3);
        c(this.mMj, true);
        c(this.mMk, false);
    }

    private void dFO() {
        this.eAz.setTextSize(0, this.mLY);
        this.eAz.setTextColor(-1);
        this.eAz.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.eAz, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mMl.getId());
        } else {
            layoutParams.addRule(1, this.mMm.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mMc);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.eAz.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.eAz.getId());
        }
        layoutParams.leftMargin = this.mLP;
        layoutParams.rightMargin = this.mLP;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eAz.setTextSize(0, this.mLY);
            this.eAz.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMl.getLayoutParams();
            marginLayoutParams.leftMargin = this.mLP;
            marginLayoutParams.rightMargin = this.mLP;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mMm.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mLP;
            marginLayoutParams2.rightMargin = this.mLP;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFD() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
