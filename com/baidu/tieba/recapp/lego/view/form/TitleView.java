package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes8.dex */
public class TitleView extends FormItemBaseView {
    private TextView eHx;
    private ImageView mVZ;
    private ImageView mWa;
    private ImageView mWb;
    private ImageView mWc;

    public TitleView(Context context) {
        super(context);
        this.eHx = null;
        this.mVZ = null;
        this.mWa = null;
        this.mWb = null;
        this.mWc = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHx = null;
        this.mVZ = null;
        this.mWa = null;
        this.mWb = null;
        this.mWc = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHx = null;
        this.mVZ = null;
        this.mWa = null;
        this.mWb = null;
        this.mWc = null;
        init();
    }

    private void init() {
        this.eHx = new TextView(this.mContext);
        this.mVZ = new ImageView(this.mContext);
        this.mWa = new ImageView(this.mContext);
        this.mWb = new ImageView(this.mContext);
        this.mWc = new ImageView(this.mContext);
        dDU();
        a(this.mWb, true, 2);
        a(this.mWc, false, 3);
        c(this.mVZ, true);
        c(this.mWa, false);
    }

    private void dDU() {
        this.eHx.setTextSize(0, this.mVP);
        this.eHx.setTextColor(-1);
        this.eHx.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.eHx, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mWb.getId());
        } else {
            layoutParams.addRule(1, this.mWc.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mVS);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.eHx.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.eHx.getId());
        }
        layoutParams.leftMargin = this.mVG;
        layoutParams.rightMargin = this.mVG;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eHx.setTextSize(0, this.mVP);
            this.eHx.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWb.getLayoutParams();
            marginLayoutParams.leftMargin = this.mVG;
            marginLayoutParams.rightMargin = this.mVG;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mWc.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mVG;
            marginLayoutParams2.rightMargin = this.mVG;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDJ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
