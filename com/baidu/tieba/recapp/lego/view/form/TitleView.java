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
    private TextView ajl;
    private ImageView gJv;
    private ImageView gJw;
    private ImageView gJx;
    private ImageView gJy;

    public TitleView(Context context) {
        super(context);
        this.ajl = null;
        this.gJv = null;
        this.gJw = null;
        this.gJx = null;
        this.gJy = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ajl = null;
        this.gJv = null;
        this.gJw = null;
        this.gJx = null;
        this.gJy = null;
        init();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ajl = null;
        this.gJv = null;
        this.gJw = null;
        this.gJx = null;
        this.gJy = null;
        init();
    }

    private void init() {
        this.ajl = new TextView(this.mContext);
        this.gJv = new ImageView(this.mContext);
        this.gJw = new ImageView(this.mContext);
        this.gJx = new ImageView(this.mContext);
        this.gJy = new ImageView(this.mContext);
        btt();
        a(this.gJx, true, 2);
        a(this.gJy, false, 3);
        a(this.gJv, true);
        a(this.gJw, false);
    }

    private void btt() {
        this.ajl.setTextSize(0, this.gJk);
        this.ajl.setTextColor(-1);
        this.ajl.setId(1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.ajl, layoutParams);
    }

    private void a(ImageView imageView, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.mResources.getDimension(e.C0200e.ds1));
        layoutParams.addRule(15);
        if (z) {
            layoutParams.addRule(0, this.gJx.getId());
        } else {
            layoutParams.addRule(1, this.gJy.getId());
        }
        addView(imageView, layoutParams);
        imageView.setBackgroundColor(this.gJo);
    }

    private void a(ImageView imageView, boolean z, int i) {
        imageView.setId(i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        if (z) {
            imageView.setImageResource(e.f.form_title_icon_left);
            layoutParams.addRule(0, this.ajl.getId());
        } else {
            imageView.setImageResource(e.f.form_title_icon_right);
            layoutParams.addRule(1, this.ajl.getId());
        }
        layoutParams.leftMargin = this.gJb;
        layoutParams.rightMargin = this.gJb;
        addView(imageView, layoutParams);
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormItemBaseView
    public boolean a(FormCard.b bVar) {
        if (super.a(bVar)) {
            this.ajl.setTextSize(0, this.gJk);
            this.ajl.setText(bVar.content);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.gJx.getLayoutParams();
            marginLayoutParams.leftMargin = this.gJb;
            marginLayoutParams.rightMargin = this.gJb;
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.gJy.getLayoutParams();
            marginLayoutParams2.leftMargin = this.gJb;
            marginLayoutParams2.rightMargin = this.gJb;
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public boolean bth() {
        return true;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public String getResult() {
        return "NEGLIGIBLE";
    }
}
