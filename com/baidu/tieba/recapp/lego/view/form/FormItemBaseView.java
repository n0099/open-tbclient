package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float alL;
    protected float ilg;
    protected Drawable ilj;
    protected Drawable ilk;
    protected int ill;
    protected int ilm;
    protected int iln;
    protected int ilo;
    protected int ilp;
    protected int ilq;
    protected int ilr;
    protected int ils;
    protected float ilt;
    protected float ilu;
    protected int ilv;
    protected int ilw;
    protected int ilx;
    protected int ily;
    protected View ilz;
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
        this.ilj = null;
        this.ilk = null;
        this.ill = 0;
        this.ilm = 0;
        this.iln = 0;
        this.ilo = 0;
        this.ilp = 0;
        this.ilq = 0;
        this.ilr = 0;
        this.ils = 0;
        this.alL = 0.0f;
        this.ilt = 0.0f;
        this.ilu = 0.0f;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.ilz = null;
        this.mTag = "";
        this.mActivity = null;
        this.ilg = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.ilj = null;
        this.ilk = null;
        this.ill = 0;
        this.ilm = 0;
        this.iln = 0;
        this.ilo = 0;
        this.ilp = 0;
        this.ilq = 0;
        this.ilr = 0;
        this.ils = 0;
        this.alL = 0.0f;
        this.ilt = 0.0f;
        this.ilu = 0.0f;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.ilz = null;
        this.mTag = "";
        this.mActivity = null;
        this.ilg = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.ilj = null;
        this.ilk = null;
        this.ill = 0;
        this.ilm = 0;
        this.iln = 0;
        this.ilo = 0;
        this.ilp = 0;
        this.ilq = 0;
        this.ilr = 0;
        this.ils = 0;
        this.alL = 0.0f;
        this.ilt = 0.0f;
        this.ilu = 0.0f;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.ilz = null;
        this.mTag = "";
        this.mActivity = null;
        this.ilg = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.ils = this.mResources.getColor(d.C0277d.form_font_color);
        this.ilv = this.mResources.getColor(d.C0277d.form_button_font_color);
        this.ilx = this.mResources.getColor(d.C0277d.form_button_grey_bg_color);
        this.ilw = -1;
        this.ily = -1;
        this.ilr = -1;
        this.ilj = this.mResources.getDrawable(d.f.form_frame_white);
        this.ilk = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.ilz = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.ilz.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.ilz.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.ilz.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.ilz;
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
    public int bXt() {
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

    public void aL(float f) {
        this.ilg = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.ill = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.ilg);
        this.ilm = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.ilg);
        this.iln = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.ilg);
        this.ilo = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.ilg);
        this.ilp = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.ilg);
        this.ilq = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.ilg);
        this.alL = (int) (this.ilg * dimension);
        this.ilt = (int) (this.ilg * dimension2);
        this.ilu = (int) (this.ilg * dimension3);
    }
}
