package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView bUW;
    private ImageView iMR;
    private ImageView iMS;
    private ImageView iMT;
    private ImageView iMU;

    public TitleView(Context context) {
        super(context);
        this.bUW = null;
        this.iMR = null;
        this.iMS = null;
        this.iMT = null;
        this.iMU = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUW = null;
        this.iMR = null;
        this.iMS = null;
        this.iMT = null;
        this.iMU = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUW = null;
        this.iMR = null;
        this.iMS = null;
        this.iMT = null;
        this.iMU = null;
        init();
    }

    private void init() {
        this.bUW = new TextView(this.mContext);
        this.iMR = new ImageView(this.mContext);
        this.iMS = new ImageView(this.mContext);
        this.iMT = new ImageView(this.mContext);
        this.iMU = new ImageView(this.mContext);
        cgA();
        a(this.iMT, true, 2);
        a(this.iMU, false, 3);
        c(this.iMR, true);
        c(this.iMS, false);
    }

    private void cgA() {
        this.bUW.setTextSize(0, this.iMG);
        this.bUW.setTextColor(-1);
        this.bUW.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.bUW, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.iMT.getId());
        } else {
            layoutParams.addRule(1, this.iMU.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iMK);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.bUW.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.bUW.getId());
        }
        layoutParams.leftMargin = this.iMx;
        layoutParams.rightMargin = this.iMx;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bUW.setTextSize(0, this.iMG);
            this.bUW.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iMT.getLayoutParams();
            marginLayoutParams.leftMargin = this.iMx;
            marginLayoutParams.rightMargin = this.iMx;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iMU.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iMx;
            marginLayoutParams2.rightMargin = this.iMx;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgo() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
