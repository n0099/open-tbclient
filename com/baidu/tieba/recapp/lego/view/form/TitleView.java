package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView amN;
    private ImageView gTd;
    private ImageView gTe;
    private ImageView gTf;
    private ImageView gTg;

    public TitleView(Context context) {
        super(context);
        this.amN = null;
        this.gTd = null;
        this.gTe = null;
        this.gTf = null;
        this.gTg = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amN = null;
        this.gTd = null;
        this.gTe = null;
        this.gTf = null;
        this.gTg = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amN = null;
        this.gTd = null;
        this.gTe = null;
        this.gTf = null;
        this.gTg = null;
        init();
    }

    private void init() {
        this.amN = new TextView(this.mContext);
        this.gTd = new ImageView(this.mContext);
        this.gTe = new ImageView(this.mContext);
        this.gTf = new ImageView(this.mContext);
        this.gTg = new ImageView(this.mContext);
        bvX();
        a(this.gTf, true, 2);
        a(this.gTg, false, 3);
        a(this.gTd, true);
        a(this.gTe, false);
    }

    private void bvX() {
        this.amN.setTextSize(0, this.gSS);
        this.amN.setTextColor(-1);
        this.amN.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.amN, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(e.C0210e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gTf.getId());
        } else {
            layoutParams.addRule(1, this.gTg.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gSW);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(e.f.form_title_icon_left);
            layoutParams.addRule(0, this.amN.getId());
        } else {
            imageView.setImageResource(e.f.form_title_icon_right);
            layoutParams.addRule(1, this.amN.getId());
        }
        layoutParams.leftMargin = this.gSJ;
        layoutParams.rightMargin = this.gSJ;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.amN.setTextSize(0, this.gSS);
            this.amN.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gTf.getLayoutParams();
            marginLayoutParams.leftMargin = this.gSJ;
            marginLayoutParams.rightMargin = this.gSJ;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gTg.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gSJ;
            marginLayoutParams2.rightMargin = this.gSJ;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bvL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
