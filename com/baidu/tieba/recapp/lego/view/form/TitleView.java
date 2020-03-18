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
    private TextView cLd;
    private ImageView jMI;
    private ImageView jMJ;
    private ImageView jMK;
    private ImageView jML;

    public TitleView(Context context) {
        super(context);
        this.cLd = null;
        this.jMI = null;
        this.jMJ = null;
        this.jMK = null;
        this.jML = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cLd = null;
        this.jMI = null;
        this.jMJ = null;
        this.jMK = null;
        this.jML = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cLd = null;
        this.jMI = null;
        this.jMJ = null;
        this.jMK = null;
        this.jML = null;
        init();
    }

    private void init() {
        this.cLd = new TextView(this.mContext);
        this.jMI = new ImageView(this.mContext);
        this.jMJ = new ImageView(this.mContext);
        this.jMK = new ImageView(this.mContext);
        this.jML = new ImageView(this.mContext);
        cDC();
        a(this.jMK, true, 2);
        a(this.jML, false, 3);
        c(this.jMI, true);
        c(this.jMJ, false);
    }

    private void cDC() {
        this.cLd.setTextSize(0, this.jMx);
        this.cLd.setTextColor(-1);
        this.cLd.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.cLd, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.jMK.getId());
        } else {
            layoutParams.addRule(1, this.jML.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.jMB);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.cLd.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.cLd.getId());
        }
        layoutParams.leftMargin = this.jMo;
        layoutParams.rightMargin = this.jMo;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.cLd.setTextSize(0, this.jMx);
            this.cLd.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jMK.getLayoutParams();
            marginLayoutParams.leftMargin = this.jMo;
            marginLayoutParams.rightMargin = this.jMo;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jML.getLayoutParams();
            marginLayoutParams2.leftMargin = this.jMo;
            marginLayoutParams2.rightMargin = this.jMo;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cDs() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
