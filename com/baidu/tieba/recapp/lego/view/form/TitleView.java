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
    private TextView dSz;
    private ImageView lGN;
    private ImageView lGO;
    private ImageView lGP;
    private ImageView lGQ;

    public TitleView(Context context) {
        super(context);
        this.dSz = null;
        this.lGN = null;
        this.lGO = null;
        this.lGP = null;
        this.lGQ = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dSz = null;
        this.lGN = null;
        this.lGO = null;
        this.lGP = null;
        this.lGQ = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dSz = null;
        this.lGN = null;
        this.lGO = null;
        this.lGP = null;
        this.lGQ = null;
        init();
    }

    private void init() {
        this.dSz = new TextView(this.mContext);
        this.lGN = new ImageView(this.mContext);
        this.lGO = new ImageView(this.mContext);
        this.lGP = new ImageView(this.mContext);
        this.lGQ = new ImageView(this.mContext);
        dnT();
        a(this.lGP, true, 2);
        a(this.lGQ, false, 3);
        c(this.lGN, true);
        c(this.lGO, false);
    }

    private void dnT() {
        this.dSz.setTextSize(0, this.lGC);
        this.dSz.setTextColor(-1);
        this.dSz.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dSz, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.lGP.getId());
        } else {
            layoutParams.addRule(1, this.lGQ.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.lGG);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dSz.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dSz.getId());
        }
        layoutParams.leftMargin = this.lGt;
        layoutParams.rightMargin = this.lGt;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dSz.setTextSize(0, this.lGC);
            this.dSz.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lGP.getLayoutParams();
            marginLayoutParams.leftMargin = this.lGt;
            marginLayoutParams.rightMargin = this.lGt;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.lGQ.getLayoutParams();
            marginLayoutParams2.leftMargin = this.lGt;
            marginLayoutParams2.rightMargin = this.lGt;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dnI() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
