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
    private ImageView mWA;
    private ImageView mWB;
    private ImageView mWC;
    private ImageView mWz;

    public TitleView(Context context) {
        super(context);
        this.eHx = null;
        this.mWz = null;
        this.mWA = null;
        this.mWB = null;
        this.mWC = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eHx = null;
        this.mWz = null;
        this.mWA = null;
        this.mWB = null;
        this.mWC = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eHx = null;
        this.mWz = null;
        this.mWA = null;
        this.mWB = null;
        this.mWC = null;
        init();
    }

    private void init() {
        this.eHx = new TextView(this.mContext);
        this.mWz = new ImageView(this.mContext);
        this.mWA = new ImageView(this.mContext);
        this.mWB = new ImageView(this.mContext);
        this.mWC = new ImageView(this.mContext);
        dEc();
        a(this.mWB, true, 2);
        a(this.mWC, false, 3);
        c(this.mWz, true);
        c(this.mWA, false);
    }

    private void dEc() {
        this.eHx.setTextSize(0, this.mWp);
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
            layoutParams.addRule(0, this.mWB.getId());
        } else {
            layoutParams.addRule(1, this.mWC.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mWs);
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
        layoutParams.leftMargin = this.mWg;
        layoutParams.rightMargin = this.mWg;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eHx.setTextSize(0, this.mWp);
            this.eHx.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mWB.getLayoutParams();
            marginLayoutParams.leftMargin = this.mWg;
            marginLayoutParams.rightMargin = this.mWg;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mWC.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mWg;
            marginLayoutParams2.rightMargin = this.mWg;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDR() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
