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
    private TextView anq;
    private ImageView gUj;
    private ImageView gUk;
    private ImageView gUl;
    private ImageView gUm;

    public TitleView(Context context) {
        super(context);
        this.anq = null;
        this.gUj = null;
        this.gUk = null;
        this.gUl = null;
        this.gUm = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anq = null;
        this.gUj = null;
        this.gUk = null;
        this.gUl = null;
        this.gUm = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anq = null;
        this.gUj = null;
        this.gUk = null;
        this.gUl = null;
        this.gUm = null;
        init();
    }

    private void init() {
        this.anq = new TextView(this.mContext);
        this.gUj = new ImageView(this.mContext);
        this.gUk = new ImageView(this.mContext);
        this.gUl = new ImageView(this.mContext);
        this.gUm = new ImageView(this.mContext);
        bwG();
        a(this.gUl, true, 2);
        a(this.gUm, false, 3);
        a(this.gUj, true);
        a(this.gUk, false);
    }

    private void bwG() {
        this.anq.setTextSize(0, this.gTY);
        this.anq.setTextColor(-1);
        this.anq.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.anq, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(e.C0210e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gUl.getId());
        } else {
            layoutParams.addRule(1, this.gUm.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gUc);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(e.f.form_title_icon_left);
            layoutParams.addRule(0, this.anq.getId());
        } else {
            imageView.setImageResource(e.f.form_title_icon_right);
            layoutParams.addRule(1, this.anq.getId());
        }
        layoutParams.leftMargin = this.gTP;
        layoutParams.rightMargin = this.gTP;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.anq.setTextSize(0, this.gTY);
            this.anq.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gUl.getLayoutParams();
            marginLayoutParams.leftMargin = this.gTP;
            marginLayoutParams.rightMargin = this.gTP;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gUm.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gTP;
            marginLayoutParams2.rightMargin = this.gTP;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bwu() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
