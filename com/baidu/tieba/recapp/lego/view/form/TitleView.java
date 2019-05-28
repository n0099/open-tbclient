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
    private ImageView iEg;
    private ImageView iEh;
    private ImageView iEi;
    private ImageView iEj;

    public TitleView(Context context) {
        super(context);
        this.bBh = null;
        this.iEg = null;
        this.iEh = null;
        this.iEi = null;
        this.iEj = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBh = null;
        this.iEg = null;
        this.iEh = null;
        this.iEi = null;
        this.iEj = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBh = null;
        this.iEg = null;
        this.iEh = null;
        this.iEi = null;
        this.iEj = null;
        init();
    }

    private void init() {
        this.bBh = new TextView(this.mContext);
        this.iEg = new ImageView(this.mContext);
        this.iEh = new ImageView(this.mContext);
        this.iEi = new ImageView(this.mContext);
        this.iEj = new ImageView(this.mContext);
        cfy();
        a(this.iEi, true, 2);
        a(this.iEj, false, 3);
        a(this.iEg, true);
        a(this.iEh, false);
    }

    private void cfy() {
        this.bBh.setTextSize(0, this.iDV);
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
            layoutParams.addRule(0, this.iEi.getId());
        } else {
            layoutParams.addRule(1, this.iEj.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iDZ);
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
        layoutParams.leftMargin = this.iDM;
        layoutParams.rightMargin = this.iDM;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bBh.setTextSize(0, this.iDV);
            this.bBh.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEi.getLayoutParams();
            marginLayoutParams.leftMargin = this.iDM;
            marginLayoutParams.rightMargin = this.iDM;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iEj.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iDM;
            marginLayoutParams2.rightMargin = this.iDM;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfm() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
