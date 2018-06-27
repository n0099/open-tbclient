package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView abu;
    private ImageView grL;
    private ImageView grM;
    private ImageView grN;
    private ImageView grO;

    public TitleView(Context context) {
        super(context);
        this.abu = null;
        this.grL = null;
        this.grM = null;
        this.grN = null;
        this.grO = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.abu = null;
        this.grL = null;
        this.grM = null;
        this.grN = null;
        this.grO = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.abu = null;
        this.grL = null;
        this.grM = null;
        this.grN = null;
        this.grO = null;
        init();
    }

    private void init() {
        this.abu = new TextView(this.mContext);
        this.grL = new ImageView(this.mContext);
        this.grM = new ImageView(this.mContext);
        this.grN = new ImageView(this.mContext);
        this.grO = new ImageView(this.mContext);
        bpv();
        a(this.grN, true, 2);
        a(this.grO, false, 3);
        a(this.grL, true);
        a(this.grM, false);
    }

    private void bpv() {
        this.abu.setTextSize(0, this.grA);
        this.abu.setTextColor(-1);
        this.abu.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.abu, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.grN.getId());
        } else {
            layoutParams.addRule(1, this.grO.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.grE);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.abu.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.abu.getId());
        }
        layoutParams.leftMargin = this.grq;
        layoutParams.rightMargin = this.grq;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.abu.setTextSize(0, this.grA);
            this.abu.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.grN.getLayoutParams();
            marginLayoutParams.leftMargin = this.grq;
            marginLayoutParams.rightMargin = this.grq;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.grO.getLayoutParams();
            marginLayoutParams2.leftMargin = this.grq;
            marginLayoutParams2.rightMargin = this.grq;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bpk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
