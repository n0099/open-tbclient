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
    private ImageView mMh;
    private ImageView mMi;
    private ImageView mMj;
    private ImageView mMk;

    public TitleView(Context context) {
        super(context);
        this.eAz = null;
        this.mMh = null;
        this.mMi = null;
        this.mMj = null;
        this.mMk = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eAz = null;
        this.mMh = null;
        this.mMi = null;
        this.mMj = null;
        this.mMk = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eAz = null;
        this.mMh = null;
        this.mMi = null;
        this.mMj = null;
        this.mMk = null;
        init();
    }

    private void init() {
        this.eAz = new TextView(this.mContext);
        this.mMh = new ImageView(this.mContext);
        this.mMi = new ImageView(this.mContext);
        this.mMj = new ImageView(this.mContext);
        this.mMk = new ImageView(this.mContext);
        dFN();
        a(this.mMj, true, 2);
        a(this.mMk, false, 3);
        c(this.mMh, true);
        c(this.mMi, false);
    }

    private void dFN() {
        this.eAz.setTextSize(0, this.mLW);
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
            layoutParams.addRule(0, this.mMj.getId());
        } else {
            layoutParams.addRule(1, this.mMk.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mMa);
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
        layoutParams.leftMargin = this.mLN;
        layoutParams.rightMargin = this.mLN;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eAz.setTextSize(0, this.mLW);
            this.eAz.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMj.getLayoutParams();
            marginLayoutParams.leftMargin = this.mLN;
            marginLayoutParams.rightMargin = this.mLN;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mMk.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mLN;
            marginLayoutParams2.rightMargin = this.mLN;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFC() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
