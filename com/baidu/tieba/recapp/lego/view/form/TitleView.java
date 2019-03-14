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
    private TextView btZ;
    private ImageView ilF;
    private ImageView ilG;
    private ImageView ilH;
    private ImageView ilI;

    public TitleView(Context context) {
        super(context);
        this.btZ = null;
        this.ilF = null;
        this.ilG = null;
        this.ilH = null;
        this.ilI = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btZ = null;
        this.ilF = null;
        this.ilG = null;
        this.ilH = null;
        this.ilI = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btZ = null;
        this.ilF = null;
        this.ilG = null;
        this.ilH = null;
        this.ilI = null;
        init();
    }

    private void init() {
        this.btZ = new TextView(this.mContext);
        this.ilF = new ImageView(this.mContext);
        this.ilG = new ImageView(this.mContext);
        this.ilH = new ImageView(this.mContext);
        this.ilI = new ImageView(this.mContext);
        bXw();
        a(this.ilH, true, 2);
        a(this.ilI, false, 3);
        a(this.ilF, true);
        a(this.ilG, false);
    }

    private void bXw() {
        this.btZ.setTextSize(0, this.ilu);
        this.btZ.setTextColor(-1);
        this.btZ.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.btZ, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.ilH.getId());
        } else {
            layoutParams.addRule(1, this.ilI.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.ily);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.btZ.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.btZ.getId());
        }
        layoutParams.leftMargin = this.ill;
        layoutParams.rightMargin = this.ill;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.btZ.setTextSize(0, this.ilu);
            this.btZ.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilH.getLayoutParams();
            marginLayoutParams.leftMargin = this.ill;
            marginLayoutParams.rightMargin = this.ill;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ilI.getLayoutParams();
            marginLayoutParams2.leftMargin = this.ill;
            marginLayoutParams2.rightMargin = this.ill;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
