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
    private TextView dko;
    private ImageView kwc;
    private ImageView kwd;
    private ImageView kwe;
    private ImageView kwf;

    public TitleView(Context context) {
        super(context);
        this.dko = null;
        this.kwc = null;
        this.kwd = null;
        this.kwe = null;
        this.kwf = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dko = null;
        this.kwc = null;
        this.kwd = null;
        this.kwe = null;
        this.kwf = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dko = null;
        this.kwc = null;
        this.kwd = null;
        this.kwe = null;
        this.kwf = null;
        init();
    }

    private void init() {
        this.dko = new TextView(this.mContext);
        this.kwc = new ImageView(this.mContext);
        this.kwd = new ImageView(this.mContext);
        this.kwe = new ImageView(this.mContext);
        this.kwf = new ImageView(this.mContext);
        cNV();
        a(this.kwe, true, 2);
        a(this.kwf, false, 3);
        c(this.kwc, true);
        c(this.kwd, false);
    }

    private void cNV() {
        this.dko.setTextSize(0, this.kvR);
        this.dko.setTextColor(-1);
        this.dko.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dko, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.kwe.getId());
        } else {
            layoutParams.addRule(1, this.kwf.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.kvV);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dko.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dko.getId());
        }
        layoutParams.leftMargin = this.kvI;
        layoutParams.rightMargin = this.kvI;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dko.setTextSize(0, this.kvR);
            this.dko.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kwe.getLayoutParams();
            marginLayoutParams.leftMargin = this.kvI;
            marginLayoutParams.rightMargin = this.kvI;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kwf.getLayoutParams();
            marginLayoutParams2.leftMargin = this.kvI;
            marginLayoutParams2.rightMargin = this.kvI;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNK() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
