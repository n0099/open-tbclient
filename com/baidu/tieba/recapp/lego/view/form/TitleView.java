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
    private TextView eIY;
    private ImageView mYK;
    private ImageView mYL;
    private ImageView mYM;
    private ImageView mYN;

    public TitleView(Context context) {
        super(context);
        this.eIY = null;
        this.mYK = null;
        this.mYL = null;
        this.mYM = null;
        this.mYN = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eIY = null;
        this.mYK = null;
        this.mYL = null;
        this.mYM = null;
        this.mYN = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eIY = null;
        this.mYK = null;
        this.mYL = null;
        this.mYM = null;
        this.mYN = null;
        init();
    }

    private void init() {
        this.eIY = new TextView(this.mContext);
        this.mYK = new ImageView(this.mContext);
        this.mYL = new ImageView(this.mContext);
        this.mYM = new ImageView(this.mContext);
        this.mYN = new ImageView(this.mContext);
        dEk();
        a(this.mYM, true, 2);
        a(this.mYN, false, 3);
        c(this.mYK, true);
        c(this.mYL, false);
    }

    private void dEk() {
        this.eIY.setTextSize(0, this.mYA);
        this.eIY.setTextColor(-1);
        this.eIY.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.eIY, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mYM.getId());
        } else {
            layoutParams.addRule(1, this.mYN.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mYD);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.eIY.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.eIY.getId());
        }
        layoutParams.leftMargin = this.mYr;
        layoutParams.rightMargin = this.mYr;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.eIY.setTextSize(0, this.mYA);
            this.eIY.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mYM.getLayoutParams();
            marginLayoutParams.leftMargin = this.mYr;
            marginLayoutParams.rightMargin = this.mYr;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mYN.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mYr;
            marginLayoutParams2.rightMargin = this.mYr;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dDZ() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
