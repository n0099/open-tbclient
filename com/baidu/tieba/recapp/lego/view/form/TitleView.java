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
    private ImageView jJW;
    private ImageView jJX;
    private ImageView jJY;
    private ImageView jJZ;

    public TitleView(Context context) {
        super(context);
        this.cGN = null;
        this.jJW = null;
        this.jJX = null;
        this.jJY = null;
        this.jJZ = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGN = null;
        this.jJW = null;
        this.jJX = null;
        this.jJY = null;
        this.jJZ = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGN = null;
        this.jJW = null;
        this.jJX = null;
        this.jJY = null;
        this.jJZ = null;
        init();
    }

    private void init() {
        this.cGN = new TextView(this.mContext);
        this.jJW = new ImageView(this.mContext);
        this.jJX = new ImageView(this.mContext);
        this.jJY = new ImageView(this.mContext);
        this.jJZ = new ImageView(this.mContext);
        cBJ();
        a(this.jJY, true, 2);
        a(this.jJZ, false, 3);
        c(this.jJW, true);
        c(this.jJX, false);
    }

    private void cBJ() {
        this.cGN.setTextSize(0, this.jJL);
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
            layoutParams.addRule(0, this.jJY.getId());
        } else {
            layoutParams.addRule(1, this.jJZ.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.jJP);
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
        layoutParams.leftMargin = this.jJC;
        layoutParams.rightMargin = this.jJC;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.cGN.setTextSize(0, this.jJL);
            this.cGN.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jJY.getLayoutParams();
            marginLayoutParams.leftMargin = this.jJC;
            marginLayoutParams.rightMargin = this.jJC;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jJZ.getLayoutParams();
            marginLayoutParams2.leftMargin = this.jJC;
            marginLayoutParams2.rightMargin = this.jJC;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cBz() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
