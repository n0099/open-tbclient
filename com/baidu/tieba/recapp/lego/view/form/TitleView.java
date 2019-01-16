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
    private TextView anp;
    private ImageView gUi;
    private ImageView gUj;
    private ImageView gUk;
    private ImageView gUl;

    public TitleView(Context context) {
        super(context);
        this.anp = null;
        this.gUi = null;
        this.gUj = null;
        this.gUk = null;
        this.gUl = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.anp = null;
        this.gUi = null;
        this.gUj = null;
        this.gUk = null;
        this.gUl = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.anp = null;
        this.gUi = null;
        this.gUj = null;
        this.gUk = null;
        this.gUl = null;
        init();
    }

    private void init() {
        this.anp = new TextView(this.mContext);
        this.gUi = new ImageView(this.mContext);
        this.gUj = new ImageView(this.mContext);
        this.gUk = new ImageView(this.mContext);
        this.gUl = new ImageView(this.mContext);
        bwG();
        a(this.gUk, true, 2);
        a(this.gUl, false, 3);
        a(this.gUi, true);
        a(this.gUj, false);
    }

    private void bwG() {
        this.anp.setTextSize(0, this.gTX);
        this.anp.setTextColor(-1);
        this.anp.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.anp, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(e.C0210e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gUk.getId());
        } else {
            layoutParams.addRule(1, this.gUl.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gUb);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(e.f.form_title_icon_left);
            layoutParams.addRule(0, this.anp.getId());
        } else {
            imageView.setImageResource(e.f.form_title_icon_right);
            layoutParams.addRule(1, this.anp.getId());
        }
        layoutParams.leftMargin = this.gTO;
        layoutParams.rightMargin = this.gTO;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.anp.setTextSize(0, this.gTX);
            this.anp.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gUk.getLayoutParams();
            marginLayoutParams.leftMargin = this.gTO;
            marginLayoutParams.rightMargin = this.gTO;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gUl.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gTO;
            marginLayoutParams2.rightMargin = this.gTO;
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
