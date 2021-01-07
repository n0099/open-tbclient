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
    private TextView eKc;
    private ImageView mRr;
    private ImageView mRs;
    private ImageView mRt;
    private ImageView mRu;

    public TitleView(Context context) {
        super(context);
        this.eKc = null;
        this.mRr = null;
        this.mRs = null;
        this.mRt = null;
        this.mRu = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eKc = null;
        this.mRr = null;
        this.mRs = null;
        this.mRt = null;
        this.mRu = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eKc = null;
        this.mRr = null;
        this.mRs = null;
        this.mRt = null;
        this.mRu = null;
        init();
    }

    private void init() {
        this.eKc = new TextView(this.mContext);
        this.mRr = new ImageView(this.mContext);
        this.mRs = new ImageView(this.mContext);
        this.mRt = new ImageView(this.mContext);
        this.mRu = new ImageView(this.mContext);
        dFE();
        a(this.mRt, true, 2);
        a(this.mRu, false, 3);
        c(this.mRr, true);
        c(this.mRs, false);
    }

    private void dFE() {
        this.eKc.setTextSize(0, this.mRg);
        this.eKc.setTextColor(-1);
        this.eKc.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.eKc, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mRt.getId());
        } else {
            layoutParams.addRule(1, this.mRu.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mRk);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.eKc.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.eKc.getId());
        }
        layoutParams.leftMargin = this.mQX;
        layoutParams.rightMargin = this.mQX;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eKc.setTextSize(0, this.mRg);
            this.eKc.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRt.getLayoutParams();
            marginLayoutParams.leftMargin = this.mQX;
            marginLayoutParams.rightMargin = this.mQX;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mRu.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mQX;
            marginLayoutParams2.rightMargin = this.mQX;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFt() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
