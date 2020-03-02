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
    private TextView cKR;
    private ImageView jKU;
    private ImageView jKV;
    private ImageView jKW;
    private ImageView jKX;

    public TitleView(Context context) {
        super(context);
        this.cKR = null;
        this.jKU = null;
        this.jKV = null;
        this.jKW = null;
        this.jKX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKR = null;
        this.jKU = null;
        this.jKV = null;
        this.jKW = null;
        this.jKX = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cKR = null;
        this.jKU = null;
        this.jKV = null;
        this.jKW = null;
        this.jKX = null;
        init();
    }

    private void init() {
        this.cKR = new TextView(this.mContext);
        this.jKU = new ImageView(this.mContext);
        this.jKV = new ImageView(this.mContext);
        this.jKW = new ImageView(this.mContext);
        this.jKX = new ImageView(this.mContext);
        cDh();
        a(this.jKW, true, 2);
        a(this.jKX, false, 3);
        c(this.jKU, true);
        c(this.jKV, false);
    }

    private void cDh() {
        this.cKR.setTextSize(0, this.jKJ);
        this.cKR.setTextColor(-1);
        this.cKR.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.cKR, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.jKW.getId());
        } else {
            layoutParams.addRule(1, this.jKX.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.jKN);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.cKR.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.cKR.getId());
        }
        layoutParams.leftMargin = this.jKA;
        layoutParams.rightMargin = this.jKA;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.cKR.setTextSize(0, this.jKJ);
            this.cKR.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.jKW.getLayoutParams();
            marginLayoutParams.leftMargin = this.jKA;
            marginLayoutParams.rightMargin = this.jKA;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.jKX.getLayoutParams();
            marginLayoutParams2.leftMargin = this.jKA;
            marginLayoutParams2.rightMargin = this.jKA;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cCX() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
