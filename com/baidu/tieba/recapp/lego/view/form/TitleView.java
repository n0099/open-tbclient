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
    private TextView btX;
    private ImageView ilM;
    private ImageView ilN;
    private ImageView ilO;
    private ImageView ilP;

    public TitleView(Context context) {
        super(context);
        this.btX = null;
        this.ilM = null;
        this.ilN = null;
        this.ilO = null;
        this.ilP = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.btX = null;
        this.ilM = null;
        this.ilN = null;
        this.ilO = null;
        this.ilP = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btX = null;
        this.ilM = null;
        this.ilN = null;
        this.ilO = null;
        this.ilP = null;
        init();
    }

    private void init() {
        this.btX = new TextView(this.mContext);
        this.ilM = new ImageView(this.mContext);
        this.ilN = new ImageView(this.mContext);
        this.ilO = new ImageView(this.mContext);
        this.ilP = new ImageView(this.mContext);
        bXu();
        a(this.ilO, true, 2);
        a(this.ilP, false, 3);
        a(this.ilM, true);
        a(this.ilN, false);
    }

    private void bXu() {
        this.btX.setTextSize(0, this.ilB);
        this.btX.setTextColor(-1);
        this.btX.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.btX, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.ilO.getId());
        } else {
            layoutParams.addRule(1, this.ilP.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.ilF);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.btX.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.btX.getId());
        }
        layoutParams.leftMargin = this.ils;
        layoutParams.rightMargin = this.ils;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.btX.setTextSize(0, this.ilB);
            this.btX.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.ilO.getLayoutParams();
            marginLayoutParams.leftMargin = this.ils;
            marginLayoutParams.rightMargin = this.ils;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ilP.getLayoutParams();
            marginLayoutParams2.leftMargin = this.ils;
            marginLayoutParams2.rightMargin = this.ils;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bXi() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
