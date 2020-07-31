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
    private ImageView lqq;
    private ImageView lqr;
    private ImageView lqs;
    private ImageView lqt;

    public TitleView(Context context) {
        super(context);
        this.dJr = null;
        this.lqq = null;
        this.lqr = null;
        this.lqs = null;
        this.lqt = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dJr = null;
        this.lqq = null;
        this.lqr = null;
        this.lqs = null;
        this.lqt = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dJr = null;
        this.lqq = null;
        this.lqr = null;
        this.lqs = null;
        this.lqt = null;
        init();
    }

    private void init() {
        this.dJr = new TextView(this.mContext);
        this.lqq = new ImageView(this.mContext);
        this.lqr = new ImageView(this.mContext);
        this.lqs = new ImageView(this.mContext);
        this.lqt = new ImageView(this.mContext);
        dcK();
        a(this.lqs, true, 2);
        a(this.lqt, false, 3);
        c(this.lqq, true);
        c(this.lqr, false);
    }

    private void dcK() {
        this.dJr.setTextSize(0, this.lqf);
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
            layoutParams.addRule(0, this.lqs.getId());
        } else {
            layoutParams.addRule(1, this.lqt.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.lqj);
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
        layoutParams.leftMargin = this.lpW;
        layoutParams.rightMargin = this.lpW;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dJr.setTextSize(0, this.lqf);
            this.dJr.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lqs.getLayoutParams();
            marginLayoutParams.leftMargin = this.lpW;
            marginLayoutParams.rightMargin = this.lpW;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lqt.getLayoutParams();
            marginLayoutParams2.leftMargin = this.lpW;
            marginLayoutParams2.rightMargin = this.lpW;
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
