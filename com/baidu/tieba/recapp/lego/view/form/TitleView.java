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
    private TextView cKQ;
    private ImageView jKS;
    private ImageView jKT;
    private ImageView jKU;
    private ImageView jKV;

    public TitleView(Context context) {
        super(context);
        this.cKQ = null;
        this.jKS = null;
        this.jKT = null;
        this.jKU = null;
        this.jKV = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKQ = null;
        this.jKS = null;
        this.jKT = null;
        this.jKU = null;
        this.jKV = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKQ = null;
        this.jKS = null;
        this.jKT = null;
        this.jKU = null;
        this.jKV = null;
        init();
    }

    private void init() {
        this.cKQ = new TextView(this.mContext);
        this.jKS = new ImageView(this.mContext);
        this.jKT = new ImageView(this.mContext);
        this.jKU = new ImageView(this.mContext);
        this.jKV = new ImageView(this.mContext);
        cDf();
        a(this.jKU, true, 2);
        a(this.jKV, false, 3);
        c(this.jKS, true);
        c(this.jKT, false);
    }

    private void cDf() {
        this.cKQ.setTextSize(0, this.jKH);
        this.cKQ.setTextColor(-1);
        this.cKQ.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.cKQ, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.jKU.getId());
        } else {
            layoutParams.addRule(1, this.jKV.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.jKL);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.cKQ.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.cKQ.getId());
        }
        layoutParams.leftMargin = this.jKy;
        layoutParams.rightMargin = this.jKy;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.cKQ.setTextSize(0, this.jKH);
            this.cKQ.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKU.getLayoutParams();
            marginLayoutParams.leftMargin = this.jKy;
            marginLayoutParams.rightMargin = this.jKy;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jKV.getLayoutParams();
            marginLayoutParams2.leftMargin = this.jKy;
            marginLayoutParams2.rightMargin = this.jKy;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCV() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
