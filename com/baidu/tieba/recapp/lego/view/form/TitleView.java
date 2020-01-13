package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes11.dex */
public class TitleView extends FormItemBaseView {
    private TextView cGN;
    private ImageView jJR;
    private ImageView jJS;
    private ImageView jJT;
    private ImageView jJU;

    public TitleView(Context context) {
        super(context);
        this.cGN = null;
        this.jJR = null;
        this.jJS = null;
        this.jJT = null;
        this.jJU = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGN = null;
        this.jJR = null;
        this.jJS = null;
        this.jJT = null;
        this.jJU = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGN = null;
        this.jJR = null;
        this.jJS = null;
        this.jJT = null;
        this.jJU = null;
        init();
    }

    private void init() {
        this.cGN = new TextView(this.mContext);
        this.jJR = new ImageView(this.mContext);
        this.jJS = new ImageView(this.mContext);
        this.jJT = new ImageView(this.mContext);
        this.jJU = new ImageView(this.mContext);
        cBH();
        a(this.jJT, true, 2);
        a(this.jJU, false, 3);
        c(this.jJR, true);
        c(this.jJS, false);
    }

    private void cBH() {
        this.cGN.setTextSize(0, this.jJG);
        this.cGN.setTextColor(-1);
        this.cGN.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.cGN, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.jJT.getId());
        } else {
            layoutParams.addRule(1, this.jJU.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.jJK);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.cGN.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.cGN.getId());
        }
        layoutParams.leftMargin = this.jJx;
        layoutParams.rightMargin = this.jJx;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.cGN.setTextSize(0, this.jJG);
            this.cGN.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jJT.getLayoutParams();
            marginLayoutParams.leftMargin = this.jJx;
            marginLayoutParams.rightMargin = this.jJx;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jJU.getLayoutParams();
            marginLayoutParams2.leftMargin = this.jJx;
            marginLayoutParams2.rightMargin = this.jJx;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cBx() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
