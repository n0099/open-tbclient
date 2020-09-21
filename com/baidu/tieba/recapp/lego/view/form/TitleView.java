package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes25.dex */
public class TitleView extends FormItemBaseView {
    private TextView dUN;
    private ImageView lPU;
    private ImageView lPV;
    private ImageView lPW;
    private ImageView lPX;

    public TitleView(Context context) {
        super(context);
        this.dUN = null;
        this.lPU = null;
        this.lPV = null;
        this.lPW = null;
        this.lPX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dUN = null;
        this.lPU = null;
        this.lPV = null;
        this.lPW = null;
        this.lPX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dUN = null;
        this.lPU = null;
        this.lPV = null;
        this.lPW = null;
        this.lPX = null;
        init();
    }

    private void init() {
        this.dUN = new TextView(this.mContext);
        this.lPU = new ImageView(this.mContext);
        this.lPV = new ImageView(this.mContext);
        this.lPW = new ImageView(this.mContext);
        this.lPX = new ImageView(this.mContext);
        drF();
        a(this.lPW, true, 2);
        a(this.lPX, false, 3);
        c(this.lPU, true);
        c(this.lPV, false);
    }

    private void drF() {
        this.dUN.setTextSize(0, this.lPJ);
        this.dUN.setTextColor(-1);
        this.dUN.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dUN, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.lPW.getId());
        } else {
            layoutParams.addRule(1, this.lPX.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.lPN);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dUN.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dUN.getId());
        }
        layoutParams.leftMargin = this.lPA;
        layoutParams.rightMargin = this.lPA;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dUN.setTextSize(0, this.lPJ);
            this.dUN.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lPW.getLayoutParams();
            marginLayoutParams.leftMargin = this.lPA;
            marginLayoutParams.rightMargin = this.lPA;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lPX.getLayoutParams();
            marginLayoutParams2.leftMargin = this.lPA;
            marginLayoutParams2.rightMargin = this.lPA;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dru() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
