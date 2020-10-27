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
    private TextView epn;
    private ImageView mrK;
    private ImageView mrL;
    private ImageView mrM;
    private ImageView mrN;

    public TitleView(Context context) {
        super(context);
        this.epn = null;
        this.mrK = null;
        this.mrL = null;
        this.mrM = null;
        this.mrN = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.epn = null;
        this.mrK = null;
        this.mrL = null;
        this.mrM = null;
        this.mrN = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.epn = null;
        this.mrK = null;
        this.mrL = null;
        this.mrM = null;
        this.mrN = null;
        init();
    }

    private void init() {
        this.epn = new TextView(this.mContext);
        this.mrK = new ImageView(this.mContext);
        this.mrL = new ImageView(this.mContext);
        this.mrM = new ImageView(this.mContext);
        this.mrN = new ImageView(this.mContext);
        dyx();
        a(this.mrM, true, 2);
        a(this.mrN, false, 3);
        c(this.mrK, true);
        c(this.mrL, false);
    }

    private void dyx() {
        this.epn.setTextSize(0, this.mrz);
        this.epn.setTextColor(-1);
        this.epn.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.epn, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mrM.getId());
        } else {
            layoutParams.addRule(1, this.mrN.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mrD);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.epn.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.epn.getId());
        }
        layoutParams.leftMargin = this.mrq;
        layoutParams.rightMargin = this.mrq;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.epn.setTextSize(0, this.mrz);
            this.epn.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mrM.getLayoutParams();
            marginLayoutParams.leftMargin = this.mrq;
            marginLayoutParams.rightMargin = this.mrq;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mrN.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mrq;
            marginLayoutParams2.rightMargin = this.mrq;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dym() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
