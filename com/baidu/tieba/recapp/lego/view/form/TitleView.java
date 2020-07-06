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
    private TextView dDu;
    private ImageView liX;
    private ImageView liY;
    private ImageView liZ;
    private ImageView lja;

    public TitleView(Context context) {
        super(context);
        this.dDu = null;
        this.liX = null;
        this.liY = null;
        this.liZ = null;
        this.lja = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dDu = null;
        this.liX = null;
        this.liY = null;
        this.liZ = null;
        this.lja = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dDu = null;
        this.liX = null;
        this.liY = null;
        this.liZ = null;
        this.lja = null;
        init();
    }

    private void init() {
        this.dDu = new TextView(this.mContext);
        this.liX = new ImageView(this.mContext);
        this.liY = new ImageView(this.mContext);
        this.liZ = new ImageView(this.mContext);
        this.lja = new ImageView(this.mContext);
        cZD();
        a(this.liZ, true, 2);
        a(this.lja, false, 3);
        c(this.liX, true);
        c(this.liY, false);
    }

    private void cZD() {
        this.dDu.setTextSize(0, this.liM);
        this.dDu.setTextColor(-1);
        this.dDu.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dDu, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.liZ.getId());
        } else {
            layoutParams.addRule(1, this.lja.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.liQ);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dDu.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dDu.getId());
        }
        layoutParams.leftMargin = this.liD;
        layoutParams.rightMargin = this.liD;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dDu.setTextSize(0, this.liM);
            this.dDu.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.liZ.getLayoutParams();
            marginLayoutParams.leftMargin = this.liD;
            marginLayoutParams.rightMargin = this.liD;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lja.getLayoutParams();
            marginLayoutParams2.leftMargin = this.liD;
            marginLayoutParams2.rightMargin = this.liD;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cZs() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
