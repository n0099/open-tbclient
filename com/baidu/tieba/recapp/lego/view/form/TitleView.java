package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes25.dex */
public class TitleView extends FormItemBaseView {
    private TextView etx;
    private ImageView mxV;
    private ImageView mxW;
    private ImageView mxX;
    private ImageView mxY;

    public TitleView(Context context) {
        super(context);
        this.etx = null;
        this.mxV = null;
        this.mxW = null;
        this.mxX = null;
        this.mxY = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.etx = null;
        this.mxV = null;
        this.mxW = null;
        this.mxX = null;
        this.mxY = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.etx = null;
        this.mxV = null;
        this.mxW = null;
        this.mxX = null;
        this.mxY = null;
        init();
    }

    private void init() {
        this.etx = new TextView(this.mContext);
        this.mxV = new ImageView(this.mContext);
        this.mxW = new ImageView(this.mContext);
        this.mxX = new ImageView(this.mContext);
        this.mxY = new ImageView(this.mContext);
        dAw();
        a(this.mxX, true, 2);
        a(this.mxY, false, 3);
        c(this.mxV, true);
        c(this.mxW, false);
    }

    private void dAw() {
        this.etx.setTextSize(0, this.mxK);
        this.etx.setTextColor(-1);
        this.etx.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.etx, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mxX.getId());
        } else {
            layoutParams.addRule(1, this.mxY.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mxO);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.etx.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.etx.getId());
        }
        layoutParams.leftMargin = this.mxB;
        layoutParams.rightMargin = this.mxB;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.etx.setTextSize(0, this.mxK);
            this.etx.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mxX.getLayoutParams();
            marginLayoutParams.leftMargin = this.mxB;
            marginLayoutParams.rightMargin = this.mxB;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mxY.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mxB;
            marginLayoutParams2.rightMargin = this.mxB;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dAl() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
