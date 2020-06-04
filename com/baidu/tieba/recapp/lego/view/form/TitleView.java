package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes13.dex */
public class TitleView extends FormItemBaseView {
    private TextView dyo;
    private ImageView kPe;
    private ImageView kPf;
    private ImageView kPg;
    private ImageView kPh;

    public TitleView(Context context) {
        super(context);
        this.dyo = null;
        this.kPe = null;
        this.kPf = null;
        this.kPg = null;
        this.kPh = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dyo = null;
        this.kPe = null;
        this.kPf = null;
        this.kPg = null;
        this.kPh = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dyo = null;
        this.kPe = null;
        this.kPf = null;
        this.kPg = null;
        this.kPh = null;
        init();
    }

    private void init() {
        this.dyo = new TextView(this.mContext);
        this.kPe = new ImageView(this.mContext);
        this.kPf = new ImageView(this.mContext);
        this.kPg = new ImageView(this.mContext);
        this.kPh = new ImageView(this.mContext);
        cVm();
        a(this.kPg, true, 2);
        a(this.kPh, false, 3);
        c(this.kPe, true);
        c(this.kPf, false);
    }

    private void cVm() {
        this.dyo.setTextSize(0, this.kOT);
        this.dyo.setTextColor(-1);
        this.dyo.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dyo, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.kPg.getId());
        } else {
            layoutParams.addRule(1, this.kPh.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.kOX);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dyo.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dyo.getId());
        }
        layoutParams.leftMargin = this.kOK;
        layoutParams.rightMargin = this.kOK;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dyo.setTextSize(0, this.kOT);
            this.dyo.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kPg.getLayoutParams();
            marginLayoutParams.leftMargin = this.kOK;
            marginLayoutParams.rightMargin = this.kOK;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kPh.getLayoutParams();
            marginLayoutParams2.leftMargin = this.kOK;
            marginLayoutParams2.rightMargin = this.kOK;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cVb() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
