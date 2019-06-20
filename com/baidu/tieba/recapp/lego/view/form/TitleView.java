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
    private TextView bBh;
    private ImageView iEh;
    private ImageView iEi;
    private ImageView iEj;
    private ImageView iEk;

    public TitleView(Context context) {
        super(context);
        this.bBh = null;
        this.iEh = null;
        this.iEi = null;
        this.iEj = null;
        this.iEk = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBh = null;
        this.iEh = null;
        this.iEi = null;
        this.iEj = null;
        this.iEk = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBh = null;
        this.iEh = null;
        this.iEi = null;
        this.iEj = null;
        this.iEk = null;
        init();
    }

    private void init() {
        this.bBh = new TextView(this.mContext);
        this.iEh = new ImageView(this.mContext);
        this.iEi = new ImageView(this.mContext);
        this.iEj = new ImageView(this.mContext);
        this.iEk = new ImageView(this.mContext);
        cfz();
        a(this.iEj, true, 2);
        a(this.iEk, false, 3);
        a(this.iEh, true);
        a(this.iEi, false);
    }

    private void cfz() {
        this.bBh.setTextSize(0, this.iDW);
        this.bBh.setTextColor(-1);
        this.bBh.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.bBh, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.iEj.getId());
        } else {
            layoutParams.addRule(1, this.iEk.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iEa);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.bBh.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.bBh.getId());
        }
        layoutParams.leftMargin = this.iDN;
        layoutParams.rightMargin = this.iDN;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bBh.setTextSize(0, this.iDW);
            this.bBh.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEj.getLayoutParams();
            marginLayoutParams.leftMargin = this.iDN;
            marginLayoutParams.rightMargin = this.iDN;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iEk.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iDN;
            marginLayoutParams2.rightMargin = this.iDN;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfn() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
