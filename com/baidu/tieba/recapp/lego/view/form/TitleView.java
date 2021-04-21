package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes4.dex */
public class TitleView extends FormItemBaseView {
    public ImageView A;
    public ImageView B;
    public TextView x;
    public ImageView y;
    public ImageView z;

    public TitleView(Context context) {
        super(context);
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        h();
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public boolean a() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean g(FormCard.b bVar) {
        if (super.g(bVar)) {
            this.x.setTextSize(0, this.p);
            this.x.setText(bVar.f20424b);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.A.getLayoutParams();
            int i = this.f20518g;
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = i;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
            int i2 = this.f20518g;
            marginLayoutParams2.leftMargin = i2;
            marginLayoutParams2.rightMargin = i2;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public String getResult() {
        return "NEGLIGIBLE";
    }

    public final void h() {
        this.x = new TextView(this.f20516e);
        this.y = new ImageView(this.f20516e);
        this.z = new ImageView(this.f20516e);
        this.A = new ImageView(this.f20516e);
        this.B = new ImageView(this.f20516e);
        k();
        i(this.A, true, 2);
        i(this.B, false, 3);
        j(this.y, true);
        j(this.z, false);
    }

    public final void i(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.x.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.x.getId());
        }
        int i2 = this.f20518g;
        layoutParams.leftMargin = i2;
        layoutParams.rightMargin = i2;
        addView(imageView, layoutParams);
    }

    public final void j(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.f20517f.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.A.getId());
        } else {
            layoutParams.addRule(1, this.B.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.s);
    }

    public final void k() {
        this.x.setTextSize(0, this.p);
        this.x.setTextColor(-1);
        this.x.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.x, layoutParams);
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        h();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        h();
    }
}
