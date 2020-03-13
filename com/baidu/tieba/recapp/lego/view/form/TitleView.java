package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes13.dex */
public class TitleView extends FormItemBaseView {
    private TextView cKS;
    private ImageView jLg;
    private ImageView jLh;
    private ImageView jLi;
    private ImageView jLj;

    public TitleView(Context context) {
        super(context);
        this.cKS = null;
        this.jLg = null;
        this.jLh = null;
        this.jLi = null;
        this.jLj = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKS = null;
        this.jLg = null;
        this.jLh = null;
        this.jLi = null;
        this.jLj = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKS = null;
        this.jLg = null;
        this.jLh = null;
        this.jLi = null;
        this.jLj = null;
        init();
    }

    private void init() {
        this.cKS = new TextView(this.mContext);
        this.jLg = new ImageView(this.mContext);
        this.jLh = new ImageView(this.mContext);
        this.jLi = new ImageView(this.mContext);
        this.jLj = new ImageView(this.mContext);
        cDi();
        a(this.jLi, true, 2);
        a(this.jLj, false, 3);
        c(this.jLg, true);
        c(this.jLh, false);
    }

    private void cDi() {
        this.cKS.setTextSize(0, this.jKV);
        this.cKS.setTextColor(-1);
        this.cKS.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.cKS, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.jLi.getId());
        } else {
            layoutParams.addRule(1, this.jLj.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.jKZ);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.cKS.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.cKS.getId());
        }
        layoutParams.leftMargin = this.jKM;
        layoutParams.rightMargin = this.jKM;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.cKS.setTextSize(0, this.jKV);
            this.cKS.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jLi.getLayoutParams();
            marginLayoutParams.leftMargin = this.jKM;
            marginLayoutParams.rightMargin = this.jKM;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jLj.getLayoutParams();
            marginLayoutParams2.leftMargin = this.jKM;
            marginLayoutParams2.rightMargin = this.jKM;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCY() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
