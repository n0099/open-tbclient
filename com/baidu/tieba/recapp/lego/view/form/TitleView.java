package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes7.dex */
public class TitleView extends FormItemBaseView {
    private TextView eFr;
    private ImageView mML;
    private ImageView mMM;
    private ImageView mMN;
    private ImageView mMO;

    public TitleView(Context context) {
        super(context);
        this.eFr = null;
        this.mML = null;
        this.mMM = null;
        this.mMN = null;
        this.mMO = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFr = null;
        this.mML = null;
        this.mMM = null;
        this.mMN = null;
        this.mMO = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFr = null;
        this.mML = null;
        this.mMM = null;
        this.mMN = null;
        this.mMO = null;
        init();
    }

    private void init() {
        this.eFr = new TextView(this.mContext);
        this.mML = new ImageView(this.mContext);
        this.mMM = new ImageView(this.mContext);
        this.mMN = new ImageView(this.mContext);
        this.mMO = new ImageView(this.mContext);
        dBM();
        a(this.mMN, true, 2);
        a(this.mMO, false, 3);
        c(this.mML, true);
        c(this.mMM, false);
    }

    private void dBM() {
        this.eFr.setTextSize(0, this.mMA);
        this.eFr.setTextColor(-1);
        this.eFr.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.eFr, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mMN.getId());
        } else {
            layoutParams.addRule(1, this.mMO.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mME);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.eFr.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.eFr.getId());
        }
        layoutParams.leftMargin = this.mMr;
        layoutParams.rightMargin = this.mMr;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eFr.setTextSize(0, this.mMA);
            this.eFr.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mMN.getLayoutParams();
            marginLayoutParams.leftMargin = this.mMr;
            marginLayoutParams.rightMargin = this.mMr;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mMO.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mMr;
            marginLayoutParams2.rightMargin = this.mMr;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dBB() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
