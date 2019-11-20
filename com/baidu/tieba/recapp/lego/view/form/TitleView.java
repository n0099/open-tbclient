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
    private TextView bUf;
    private ImageView iMa;
    private ImageView iMb;
    private ImageView iMc;
    private ImageView iMd;

    public TitleView(Context context) {
        super(context);
        this.bUf = null;
        this.iMa = null;
        this.iMb = null;
        this.iMc = null;
        this.iMd = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bUf = null;
        this.iMa = null;
        this.iMb = null;
        this.iMc = null;
        this.iMd = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bUf = null;
        this.iMa = null;
        this.iMb = null;
        this.iMc = null;
        this.iMd = null;
        init();
    }

    private void init() {
        this.bUf = new TextView(this.mContext);
        this.iMa = new ImageView(this.mContext);
        this.iMb = new ImageView(this.mContext);
        this.iMc = new ImageView(this.mContext);
        this.iMd = new ImageView(this.mContext);
        cgy();
        a(this.iMc, true, 2);
        a(this.iMd, false, 3);
        c(this.iMa, true);
        c(this.iMb, false);
    }

    private void cgy() {
        this.bUf.setTextSize(0, this.iLP);
        this.bUf.setTextColor(-1);
        this.bUf.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.bUf, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.iMc.getId());
        } else {
            layoutParams.addRule(1, this.iMd.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iLT);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.bUf.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.bUf.getId());
        }
        layoutParams.leftMargin = this.iLG;
        layoutParams.rightMargin = this.iLG;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bUf.setTextSize(0, this.iLP);
            this.bUf.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iMc.getLayoutParams();
            marginLayoutParams.leftMargin = this.iLG;
            marginLayoutParams.rightMargin = this.iLG;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iMd.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iLG;
            marginLayoutParams2.rightMargin = this.iLG;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cgm() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
