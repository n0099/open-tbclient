package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes3.dex */
public class TitleView extends FormItemBaseView {
    private TextView bCB;
    private ImageView iNZ;
    private ImageView iOa;
    private ImageView iOb;
    private ImageView iOc;

    public TitleView(Context context) {
        super(context);
        this.bCB = null;
        this.iNZ = null;
        this.iOa = null;
        this.iOb = null;
        this.iOc = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCB = null;
        this.iNZ = null;
        this.iOa = null;
        this.iOb = null;
        this.iOc = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCB = null;
        this.iNZ = null;
        this.iOa = null;
        this.iOb = null;
        this.iOc = null;
        init();
    }

    private void init() {
        this.bCB = new TextView(this.mContext);
        this.iNZ = new ImageView(this.mContext);
        this.iOa = new ImageView(this.mContext);
        this.iOb = new ImageView(this.mContext);
        this.iOc = new ImageView(this.mContext);
        cjw();
        a(this.iOb, true, 2);
        a(this.iOc, false, 3);
        a(this.iNZ, true);
        a(this.iOa, false);
    }

    private void cjw() {
        this.bCB.setTextSize(0, this.iNO);
        this.bCB.setTextColor(-1);
        this.bCB.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.bCB, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.iOb.getId());
        } else {
            layoutParams.addRule(1, this.iOc.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iNS);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.bCB.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.bCB.getId());
        }
        layoutParams.leftMargin = this.iNF;
        layoutParams.rightMargin = this.iNF;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bCB.setTextSize(0, this.iNO);
            this.bCB.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iOb.getLayoutParams();
            marginLayoutParams.leftMargin = this.iNF;
            marginLayoutParams.rightMargin = this.iNF;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iOc.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iNF;
            marginLayoutParams2.rightMargin = this.iNF;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cjk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
