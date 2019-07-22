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
    private ImageView iKA;
    private ImageView iKB;
    private ImageView iKC;
    private ImageView iKz;

    public TitleView(Context context) {
        super(context);
        this.bCd = null;
        this.iKz = null;
        this.iKA = null;
        this.iKB = null;
        this.iKC = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bCd = null;
        this.iKz = null;
        this.iKA = null;
        this.iKB = null;
        this.iKC = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bCd = null;
        this.iKz = null;
        this.iKA = null;
        this.iKB = null;
        this.iKC = null;
        init();
    }

    private void init() {
        this.bCd = new TextView(this.mContext);
        this.iKz = new ImageView(this.mContext);
        this.iKA = new ImageView(this.mContext);
        this.iKB = new ImageView(this.mContext);
        this.iKC = new ImageView(this.mContext);
        ciq();
        a(this.iKB, true, 2);
        a(this.iKC, false, 3);
        a(this.iKz, true);
        a(this.iKA, false);
    }

    private void ciq() {
        this.bCd.setTextSize(0, this.iKo);
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
            layoutParams.addRule(0, this.iKB.getId());
        } else {
            layoutParams.addRule(1, this.iKC.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.iKs);
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
        layoutParams.leftMargin = this.iKf;
        layoutParams.rightMargin = this.iKf;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.bCd.setTextSize(0, this.iKo);
            this.bCd.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.iKB.getLayoutParams();
            marginLayoutParams.leftMargin = this.iKf;
            marginLayoutParams.rightMargin = this.iKf;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.iKC.getLayoutParams();
            marginLayoutParams2.leftMargin = this.iKf;
            marginLayoutParams2.rightMargin = this.iKf;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cie() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
