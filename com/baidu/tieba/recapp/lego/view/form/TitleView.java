package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView adB;
    private ImageView gAu;
    private ImageView gAv;
    private ImageView gAw;
    private ImageView gAx;

    public TitleView(Context context) {
        super(context);
        this.adB = null;
        this.gAu = null;
        this.gAv = null;
        this.gAw = null;
        this.gAx = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.adB = null;
        this.gAu = null;
        this.gAv = null;
        this.gAw = null;
        this.gAx = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.adB = null;
        this.gAu = null;
        this.gAv = null;
        this.gAw = null;
        this.gAx = null;
        init();
    }

    private void init() {
        this.adB = new TextView(this.mContext);
        this.gAu = new ImageView(this.mContext);
        this.gAv = new ImageView(this.mContext);
        this.gAw = new ImageView(this.mContext);
        this.gAx = new ImageView(this.mContext);
        bqI();
        a(this.gAw, true, 2);
        a(this.gAx, false, 3);
        a(this.gAu, true);
        a(this.gAv, false);
    }

    private void bqI() {
        this.adB.setTextSize(0, this.gAj);
        this.adB.setTextColor(-1);
        this.adB.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.adB, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(e.C0141e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gAw.getId());
        } else {
            layoutParams.addRule(1, this.gAx.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gAn);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(e.f.form_title_icon_left);
            layoutParams.addRule(0, this.adB.getId());
        } else {
            imageView.setImageResource(e.f.form_title_icon_right);
            layoutParams.addRule(1, this.adB.getId());
        }
        layoutParams.leftMargin = this.gzZ;
        layoutParams.rightMargin = this.gzZ;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.adB.setTextSize(0, this.gAj);
            this.adB.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gAw.getLayoutParams();
            marginLayoutParams.leftMargin = this.gzZ;
            marginLayoutParams.rightMargin = this.gzZ;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gAx.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gzZ;
            marginLayoutParams2.rightMargin = this.gzZ;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bqw() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
