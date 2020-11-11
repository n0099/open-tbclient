package com.baidu.tieba.recapp.lego.view.form;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
/* loaded from: classes26.dex */
public class TitleView extends FormItemBaseView {
    private TextView evg;
    private ImageView mxH;
    private ImageView mxI;
    private ImageView mxJ;
    private ImageView mxK;

    public TitleView(Context context) {
        super(context);
        this.evg = null;
        this.mxH = null;
        this.mxI = null;
        this.mxJ = null;
        this.mxK = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.evg = null;
        this.mxH = null;
        this.mxI = null;
        this.mxJ = null;
        this.mxK = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evg = null;
        this.mxH = null;
        this.mxI = null;
        this.mxJ = null;
        this.mxK = null;
        init();
    }

    private void init() {
        this.evg = new TextView(this.mContext);
        this.mxH = new ImageView(this.mContext);
        this.mxI = new ImageView(this.mContext);
        this.mxJ = new ImageView(this.mContext);
        this.mxK = new ImageView(this.mContext);
        dAZ();
        a(this.mxJ, true, 2);
        a(this.mxK, false, 3);
        c(this.mxH, true);
        c(this.mxI, false);
    }

    private void dAZ() {
        this.evg.setTextSize(0, this.mxw);
        this.evg.setTextColor(-1);
        this.evg.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.evg, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.mxJ.getId());
        } else {
            layoutParams.addRule(1, this.mxK.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.mxA);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.evg.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.evg.getId());
        }
        layoutParams.leftMargin = this.mxn;
        layoutParams.rightMargin = this.mxn;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.evg.setTextSize(0, this.mxw);
            this.evg.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mxJ.getLayoutParams();
            marginLayoutParams.leftMargin = this.mxn;
            marginLayoutParams.rightMargin = this.mxn;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.mxK.getLayoutParams();
            marginLayoutParams2.leftMargin = this.mxn;
            marginLayoutParams2.rightMargin = this.mxn;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean dAO() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
