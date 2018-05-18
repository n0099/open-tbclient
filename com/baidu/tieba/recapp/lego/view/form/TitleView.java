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
    private TextView Ti;
    private ImageView gcC;
    private ImageView gcD;
    private ImageView gcE;
    private ImageView gcF;

    public TitleView(Context context) {
        super(context);
        this.Ti = null;
        this.gcC = null;
        this.gcD = null;
        this.gcE = null;
        this.gcF = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ti = null;
        this.gcC = null;
        this.gcD = null;
        this.gcE = null;
        this.gcF = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ti = null;
        this.gcC = null;
        this.gcD = null;
        this.gcE = null;
        this.gcF = null;
        init();
    }

    private void init() {
        this.Ti = new TextView(this.mContext);
        this.gcC = new ImageView(this.mContext);
        this.gcD = new ImageView(this.mContext);
        this.gcE = new ImageView(this.mContext);
        this.gcF = new ImageView(this.mContext);
        bjV();
        a(this.gcE, true, 2);
        a(this.gcF, false, 3);
        a(this.gcC, true);
        a(this.gcD, false);
    }

    private void bjV() {
        this.Ti.setTextSize(0, this.gcr);
        this.Ti.setTextColor(-1);
        this.Ti.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.Ti, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(d.e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gcE.getId());
        } else {
            layoutParams.addRule(1, this.gcF.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gcv);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(d.f.form_title_icon_left);
            layoutParams.addRule(0, this.Ti.getId());
        } else {
            imageView.setImageResource(d.f.form_title_icon_right);
            layoutParams.addRule(1, this.Ti.getId());
        }
        layoutParams.leftMargin = this.gch;
        layoutParams.rightMargin = this.gch;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.Ti.setTextSize(0, this.gcr);
            this.Ti.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gcE.getLayoutParams();
            marginLayoutParams.leftMargin = this.gch;
            marginLayoutParams.rightMargin = this.gch;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gcF.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gch;
            marginLayoutParams2.rightMargin = this.gch;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bjK() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
