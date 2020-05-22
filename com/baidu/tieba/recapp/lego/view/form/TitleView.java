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
    private TextView dyo;
    private ImageView kNV;
    private ImageView kNW;
    private ImageView kNX;
    private ImageView kNY;

    public TitleView(Context context) {
        super(context);
        this.dyo = null;
        this.kNV = null;
        this.kNW = null;
        this.kNX = null;
        this.kNY = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyo = null;
        this.kNV = null;
        this.kNW = null;
        this.kNX = null;
        this.kNY = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyo = null;
        this.kNV = null;
        this.kNW = null;
        this.kNX = null;
        this.kNY = null;
        init();
    }

    private void init() {
        this.dyo = new TextView(this.mContext);
        this.kNV = new ImageView(this.mContext);
        this.kNW = new ImageView(this.mContext);
        this.kNX = new ImageView(this.mContext);
        this.kNY = new ImageView(this.mContext);
        cUW();
        a(this.kNX, true, 2);
        a(this.kNY, false, 3);
        c(this.kNV, true);
        c(this.kNW, false);
    }

    private void cUW() {
        this.dyo.setTextSize(0, this.kNK);
        this.dyo.setTextColor(-1);
        this.dyo.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dyo, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.kNX.getId());
        } else {
            layoutParams.addRule(1, this.kNY.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.kNO);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dyo.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dyo.getId());
        }
        layoutParams.leftMargin = this.kNB;
        layoutParams.rightMargin = this.kNB;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dyo.setTextSize(0, this.kNK);
            this.dyo.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kNX.getLayoutParams();
            marginLayoutParams.leftMargin = this.kNB;
            marginLayoutParams.rightMargin = this.kNB;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kNY.getLayoutParams();
            marginLayoutParams2.leftMargin = this.kNB;
            marginLayoutParams2.rightMargin = this.kNB;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cUL() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
