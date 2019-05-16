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
    private TextView bBh;
    private ImageView iEe;
    private ImageView iEf;
    private ImageView iEg;
    private ImageView iEh;

    public TitleView(Context context) {
        super(context);
        this.bBh = null;
        this.iEe = null;
        this.iEf = null;
        this.iEg = null;
        this.iEh = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBh = null;
        this.iEe = null;
        this.iEf = null;
        this.iEg = null;
        this.iEh = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBh = null;
        this.iEe = null;
        this.iEf = null;
        this.iEg = null;
        this.iEh = null;
        init();
    }

    private void init() {
        this.bBh = new TextView(this.mContext);
        this.iEe = new ImageView(this.mContext);
        this.iEf = new ImageView(this.mContext);
        this.iEg = new ImageView(this.mContext);
        this.iEh = new ImageView(this.mContext);
        cfw();
        a(this.iEg, true, 2);
        a(this.iEh, false, 3);
        a(this.iEe, true);
        a(this.iEf, false);
    }

    private void cfw() {
        this.bBh.setTextSize(0, this.iDT);
        this.bBh.setTextColor(-1);
        this.bBh.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.bBh, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.iEg.getId());
        } else {
            layoutParams.addRule(1, this.iEh.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iDX);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.bBh.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.bBh.getId());
        }
        layoutParams.leftMargin = this.iDK;
        layoutParams.rightMargin = this.iDK;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bBh.setTextSize(0, this.iDT);
            this.bBh.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iEg.getLayoutParams();
            marginLayoutParams.leftMargin = this.iDK;
            marginLayoutParams.rightMargin = this.iDK;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iEh.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iDK;
            marginLayoutParams2.rightMargin = this.iDK;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cfk() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
