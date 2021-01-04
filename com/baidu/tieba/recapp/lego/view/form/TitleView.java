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
    private ImageView mRs;
    private ImageView mRt;
    private ImageView mRu;
    private ImageView mRv;

    public TitleView(Context context) {
        super(context);
        this.eKc = null;
        this.mRs = null;
        this.mRt = null;
        this.mRu = null;
        this.mRv = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eKc = null;
        this.mRs = null;
        this.mRt = null;
        this.mRu = null;
        this.mRv = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eKc = null;
        this.mRs = null;
        this.mRt = null;
        this.mRu = null;
        this.mRv = null;
        init();
    }

    private void init() {
        this.eKc = new TextView(this.mContext);
        this.mRs = new ImageView(this.mContext);
        this.mRt = new ImageView(this.mContext);
        this.mRu = new ImageView(this.mContext);
        this.mRv = new ImageView(this.mContext);
        dFD();
        a(this.mRu, true, 2);
        a(this.mRv, false, 3);
        c(this.mRs, true);
        c(this.mRt, false);
    }

    private void dFD() {
        this.eKc.setTextSize(0, this.mRh);
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
            layoutParams.addRule(0, this.mRu.getId());
        } else {
            layoutParams.addRule(1, this.mRv.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mRl);
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
        layoutParams.leftMargin = this.mQY;
        layoutParams.rightMargin = this.mQY;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eKc.setTextSize(0, this.mRh);
            this.eKc.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mRu.getLayoutParams();
            marginLayoutParams.leftMargin = this.mQY;
            marginLayoutParams.rightMargin = this.mQY;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mRv.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mQY;
            marginLayoutParams2.rightMargin = this.mQY;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dFs() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
