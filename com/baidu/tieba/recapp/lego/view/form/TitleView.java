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
    private TextView bCd;
    private ImageView iLD;
    private ImageView iLE;
    private ImageView iLF;
    private ImageView iLG;

    public TitleView(Context context) {
        super(context);
        this.bCd = null;
        this.iLD = null;
        this.iLE = null;
        this.iLF = null;
        this.iLG = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCd = null;
        this.iLD = null;
        this.iLE = null;
        this.iLF = null;
        this.iLG = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCd = null;
        this.iLD = null;
        this.iLE = null;
        this.iLF = null;
        this.iLG = null;
        init();
    }

    private void init() {
        this.bCd = new TextView(this.mContext);
        this.iLD = new ImageView(this.mContext);
        this.iLE = new ImageView(this.mContext);
        this.iLF = new ImageView(this.mContext);
        this.iLG = new ImageView(this.mContext);
        ciI();
        a(this.iLF, true, 2);
        a(this.iLG, false, 3);
        a(this.iLD, true);
        a(this.iLE, false);
    }

    private void ciI() {
        this.bCd.setTextSize(0, this.iLs);
        this.bCd.setTextColor(-1);
        this.bCd.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.bCd, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.iLF.getId());
        } else {
            layoutParams.addRule(1, this.iLG.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iLw);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.bCd.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.bCd.getId());
        }
        layoutParams.leftMargin = this.iLj;
        layoutParams.rightMargin = this.iLj;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bCd.setTextSize(0, this.iLs);
            this.bCd.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iLF.getLayoutParams();
            marginLayoutParams.leftMargin = this.iLj;
            marginLayoutParams.rightMargin = this.iLj;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iLG.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iLj;
            marginLayoutParams2.rightMargin = this.iLj;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean ciw() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
