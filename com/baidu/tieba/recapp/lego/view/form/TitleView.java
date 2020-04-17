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
    private TextView dkk;
    private ImageView kvY;
    private ImageView kvZ;
    private ImageView kwa;
    private ImageView kwb;

    public TitleView(Context context) {
        super(context);
        this.dkk = null;
        this.kvY = null;
        this.kvZ = null;
        this.kwa = null;
        this.kwb = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dkk = null;
        this.kvY = null;
        this.kvZ = null;
        this.kwa = null;
        this.kwb = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dkk = null;
        this.kvY = null;
        this.kvZ = null;
        this.kwa = null;
        this.kwb = null;
        init();
    }

    private void init() {
        this.dkk = new TextView(this.mContext);
        this.kvY = new ImageView(this.mContext);
        this.kvZ = new ImageView(this.mContext);
        this.kwa = new ImageView(this.mContext);
        this.kwb = new ImageView(this.mContext);
        cNY();
        a(this.kwa, true, 2);
        a(this.kwb, false, 3);
        c(this.kvY, true);
        c(this.kvZ, false);
    }

    private void cNY() {
        this.dkk.setTextSize(0, this.kvN);
        this.dkk.setTextColor(-1);
        this.dkk.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.dkk, layoutParams);
    }

    private void c(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(R.dimen.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.kwa.getId());
        } else {
            layoutParams.addRule(1, this.kwb.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.kvR);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(R.drawable.form_title_icon_left);
            layoutParams.addRule(0, this.dkk.getId());
        } else {
            imageView.setImageResource(R.drawable.form_title_icon_right);
            layoutParams.addRule(1, this.dkk.getId());
        }
        layoutParams.leftMargin = this.kvE;
        layoutParams.rightMargin = this.kvE;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.dkk.setTextSize(0, this.kvN);
            this.dkk.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.kwa.getLayoutParams();
            marginLayoutParams.leftMargin = this.kvE;
            marginLayoutParams.rightMargin = this.kvE;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.kwb.getLayoutParams();
            marginLayoutParams2.leftMargin = this.kvE;
            marginLayoutParams2.rightMargin = this.kvE;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean cNN() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
