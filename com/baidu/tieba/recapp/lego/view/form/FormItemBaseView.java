package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected int gAa;
    protected int gAb;
    protected int gAc;
    protected int gAd;
    protected int gAe;
    protected int gAf;
    protected int gAg;
    protected float gAh;
    protected float gAi;
    protected float gAj;
    protected int gAk;
    protected int gAl;
    protected int gAm;
    protected int gAn;
    protected View gAo;
    protected float gzU;
    protected Drawable gzX;
    protected Drawable gzY;
    protected int gzZ;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.gzX = null;
        this.gzY = null;
        this.gzZ = 0;
        this.gAa = 0;
        this.gAb = 0;
        this.gAc = 0;
        this.gAd = 0;
        this.gAe = 0;
        this.gAf = 0;
        this.gAg = 0;
        this.gAh = 0.0f;
        this.gAi = 0.0f;
        this.gAj = 0.0f;
        this.gAk = 0;
        this.gAl = 0;
        this.gAm = 0;
        this.gAn = 0;
        this.gAo = null;
        this.mTag = "";
        this.mActivity = null;
        this.gzU = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gzX = null;
        this.gzY = null;
        this.gzZ = 0;
        this.gAa = 0;
        this.gAb = 0;
        this.gAc = 0;
        this.gAd = 0;
        this.gAe = 0;
        this.gAf = 0;
        this.gAg = 0;
        this.gAh = 0.0f;
        this.gAi = 0.0f;
        this.gAj = 0.0f;
        this.gAk = 0;
        this.gAl = 0;
        this.gAm = 0;
        this.gAn = 0;
        this.gAo = null;
        this.mTag = "";
        this.mActivity = null;
        this.gzU = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gzX = null;
        this.gzY = null;
        this.gzZ = 0;
        this.gAa = 0;
        this.gAb = 0;
        this.gAc = 0;
        this.gAd = 0;
        this.gAe = 0;
        this.gAf = 0;
        this.gAg = 0;
        this.gAh = 0.0f;
        this.gAi = 0.0f;
        this.gAj = 0.0f;
        this.gAk = 0;
        this.gAl = 0;
        this.gAm = 0;
        this.gAn = 0;
        this.gAo = null;
        this.mTag = "";
        this.mActivity = null;
        this.gzU = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gAg = this.mResources.getColor(e.d.form_font_color);
        this.gAk = this.mResources.getColor(e.d.form_button_font_color);
        this.gAm = this.mResources.getColor(e.d.form_button_grey_bg_color);
        this.gAl = -1;
        this.gAn = -1;
        this.gAf = -1;
        this.gzX = this.mResources.getDrawable(e.f.form_frame_white);
        this.gzY = this.mResources.getDrawable(e.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gAo = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gAo.setBackgroundResource(e.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gAo.setBackgroundResource(e.f.form_frame_white);
                return;
            default:
                this.gAo.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gAo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(FormCard.b bVar) {
        if (bVar == null || bVar.type == -1 || TextUtils.isEmpty(bVar.content)) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        reset();
        this.mTag = bVar.tag;
        return true;
    }

    protected void reset() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int bqF() {
        return -2;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.a
    public FormItemBaseView getFormView() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public String getTag() {
        return this.mTag;
    }

    public void av(float f) {
        this.gzU = f;
        float dimension = this.mResources.getDimension(e.C0141e.form_font_size28);
        float dimension2 = this.mResources.getDimension(e.C0141e.form_font_size20);
        float dimension3 = this.mResources.getDimension(e.C0141e.form_font_size36);
        this.gzZ = (int) (((int) this.mResources.getDimension(e.C0141e.form_size20)) * this.gzU);
        this.gAa = (int) (((int) this.mResources.getDimension(e.C0141e.form_size40)) * this.gzU);
        this.gAb = (int) (((int) this.mResources.getDimension(e.C0141e.form_size50)) * this.gzU);
        this.gAc = (int) (((int) this.mResources.getDimension(e.C0141e.form_size80)) * this.gzU);
        this.gAd = (int) (((int) this.mResources.getDimension(e.C0141e.form_size90)) * this.gzU);
        this.gAe = (int) (((int) this.mResources.getDimension(e.C0141e.form_size240)) * this.gzU);
        this.gAh = (int) (this.gzU * dimension);
        this.gAi = (int) (this.gzU * dimension2);
        this.gAj = (int) (this.gzU * dimension3);
    }
}
