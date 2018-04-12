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
    protected float gaZ;
    protected Drawable gbc;
    protected Drawable gbd;
    protected int gbe;
    protected int gbf;
    protected int gbg;
    protected int gbh;
    protected int gbi;
    protected int gbj;
    protected int gbk;
    protected int gbl;
    protected float gbm;
    protected float gbn;
    protected float gbo;
    protected int gbp;
    protected int gbq;
    protected int gbr;
    protected int gbs;
    protected View gbt;
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
        this.gbc = null;
        this.gbd = null;
        this.gbe = 0;
        this.gbf = 0;
        this.gbg = 0;
        this.gbh = 0;
        this.gbi = 0;
        this.gbj = 0;
        this.gbk = 0;
        this.gbl = 0;
        this.gbm = 0.0f;
        this.gbn = 0.0f;
        this.gbo = 0.0f;
        this.gbp = 0;
        this.gbq = 0;
        this.gbr = 0;
        this.gbs = 0;
        this.gbt = null;
        this.mTag = "";
        this.mActivity = null;
        this.gaZ = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gbc = null;
        this.gbd = null;
        this.gbe = 0;
        this.gbf = 0;
        this.gbg = 0;
        this.gbh = 0;
        this.gbi = 0;
        this.gbj = 0;
        this.gbk = 0;
        this.gbl = 0;
        this.gbm = 0.0f;
        this.gbn = 0.0f;
        this.gbo = 0.0f;
        this.gbp = 0;
        this.gbq = 0;
        this.gbr = 0;
        this.gbs = 0;
        this.gbt = null;
        this.mTag = "";
        this.mActivity = null;
        this.gaZ = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gbc = null;
        this.gbd = null;
        this.gbe = 0;
        this.gbf = 0;
        this.gbg = 0;
        this.gbh = 0;
        this.gbi = 0;
        this.gbj = 0;
        this.gbk = 0;
        this.gbl = 0;
        this.gbm = 0.0f;
        this.gbn = 0.0f;
        this.gbo = 0.0f;
        this.gbp = 0;
        this.gbq = 0;
        this.gbr = 0;
        this.gbs = 0;
        this.gbt = null;
        this.mTag = "";
        this.mActivity = null;
        this.gaZ = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gbl = this.mResources.getColor(d.C0126d.form_font_color);
        this.gbp = this.mResources.getColor(d.C0126d.form_button_font_color);
        this.gbr = this.mResources.getColor(d.C0126d.form_button_grey_bg_color);
        this.gbq = -1;
        this.gbs = -1;
        this.gbk = -1;
        this.gbc = this.mResources.getDrawable(d.f.form_frame_white);
        this.gbd = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view2, DrawableType drawableType) {
        this.gbt = view2;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gbt.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gbt.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.gbt.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gbt;
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
    public int bjU() {
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

    public void ar(float f) {
        this.gaZ = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.gbe = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.gaZ);
        this.gbf = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.gaZ);
        this.gbg = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.gaZ);
        this.gbh = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.gaZ);
        this.gbi = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.gaZ);
        this.gbj = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.gaZ);
        this.gbm = (int) (this.gaZ * dimension);
        this.gbn = (int) (this.gaZ * dimension2);
        this.gbo = (int) (this.gaZ * dimension3);
    }
}
