package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes20.dex */
public class TitleView extends FormItemBaseView {
    private TextView dJr;
    private ImageView lqs;
    private ImageView lqt;
    private ImageView lqu;
    private ImageView lqv;

    public TitleView(Context context) {
        super(context);
        this.dJr = null;
        this.lqs = null;
        this.lqt = null;
        this.lqu = null;
        this.lqv = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJr = null;
        this.lqs = null;
        this.lqt = null;
        this.lqu = null;
        this.lqv = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJr = null;
        this.lqs = null;
        this.lqt = null;
        this.lqu = null;
        this.lqv = null;
        init();
    }

    private void init() {
        this.dJr = new TextView(this.mContext);
        this.lqs = new ImageView(this.mContext);
        this.lqt = new ImageView(this.mContext);
        this.lqu = new ImageView(this.mContext);
        this.lqv = new ImageView(this.mContext);
        dcK();
        a(this.lqu, true, 2);
        a(this.lqv, false, 3);
        c(this.lqs, true);
        c(this.lqt, false);
    }

    private void dcK() {
        this.dJr.setTextSize(0, this.lqh);
        this.dJr.setTextColor(-1);
        this.dJr.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dJr, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.lqu.getId());
        } else {
            layoutParams.addRule(1, this.lqv.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.lql);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dJr.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dJr.getId());
        }
        layoutParams.leftMargin = this.lpY;
        layoutParams.rightMargin = this.lpY;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dJr.setTextSize(0, this.lqh);
            this.dJr.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lqu.getLayoutParams();
            marginLayoutParams.leftMargin = this.lpY;
            marginLayoutParams.rightMargin = this.lpY;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lqv.getLayoutParams();
            marginLayoutParams2.leftMargin = this.lpY;
            marginLayoutParams2.rightMargin = this.lpY;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dcz() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
