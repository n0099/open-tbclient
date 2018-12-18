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
    private ImageView gQl;
    private ImageView gQm;
    private ImageView gQn;
    private ImageView gQo;

    public TitleView(Context context) {
        super(context);
        this.amN = null;
        this.gQl = null;
        this.gQm = null;
        this.gQn = null;
        this.gQo = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.amN = null;
        this.gQl = null;
        this.gQm = null;
        this.gQn = null;
        this.gQo = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.amN = null;
        this.gQl = null;
        this.gQm = null;
        this.gQn = null;
        this.gQo = null;
        init();
    }

    private void init() {
        this.amN = new TextView(this.mContext);
        this.gQl = new ImageView(this.mContext);
        this.gQm = new ImageView(this.mContext);
        this.gQn = new ImageView(this.mContext);
        this.gQo = new ImageView(this.mContext);
        bvl();
        a(this.gQn, true, 2);
        a(this.gQo, false, 3);
        a(this.gQl, true);
        a(this.gQm, false);
    }

    private void bvl() {
        this.amN.setTextSize(0, this.gQa);
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
            layoutParams.addRule(0, this.gQn.getId());
        } else {
            layoutParams.addRule(1, this.gQo.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gQe);
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
        layoutParams.leftMargin = this.gPR;
        layoutParams.rightMargin = this.gPR;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.amN.setTextSize(0, this.gQa);
            this.amN.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gQn.getLayoutParams();
            marginLayoutParams.leftMargin = this.gPR;
            marginLayoutParams.rightMargin = this.gPR;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gQo.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gPR;
            marginLayoutParams2.rightMargin = this.gPR;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean buZ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
