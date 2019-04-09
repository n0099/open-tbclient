package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView bud;
    private ImageView ils;
    private ImageView ilt;
    private ImageView ilu;
    private ImageView ilv;

    public TitleView(Context context) {
        super(context);
        this.bud = null;
        this.ils = null;
        this.ilt = null;
        this.ilu = null;
        this.ilv = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bud = null;
        this.ils = null;
        this.ilt = null;
        this.ilu = null;
        this.ilv = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bud = null;
        this.ils = null;
        this.ilt = null;
        this.ilu = null;
        this.ilv = null;
        init();
    }

    private void init() {
        this.bud = new TextView(this.mContext);
        this.ils = new ImageView(this.mContext);
        this.ilt = new ImageView(this.mContext);
        this.ilu = new ImageView(this.mContext);
        this.ilv = new ImageView(this.mContext);
        bXs();
        a(this.ilu, true, 2);
        a(this.ilv, false, 3);
        a(this.ils, true);
        a(this.ilt, false);
    }

    private void bXs() {
        this.bud.setTextSize(0, this.ilh);
        this.bud.setTextColor(-1);
        this.bud.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.bud, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.ilu.getId());
        } else {
            layoutParams.addRule(1, this.ilv.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.ill);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.bud.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.bud.getId());
        }
        layoutParams.leftMargin = this.ikY;
        layoutParams.rightMargin = this.ikY;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bud.setTextSize(0, this.ilh);
            this.bud.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilu.getLayoutParams();
            marginLayoutParams.leftMargin = this.ikY;
            marginLayoutParams.rightMargin = this.ikY;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ilv.getLayoutParams();
            marginLayoutParams2.leftMargin = this.ikY;
            marginLayoutParams2.rightMargin = this.ikY;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXg() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
