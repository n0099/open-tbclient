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
    protected float gaW;
    protected Drawable gaZ;
    protected Drawable gba;
    protected int gbb;
    protected int gbc;
    protected int gbd;
    protected int gbe;
    protected int gbf;
    protected int gbg;
    protected int gbh;
    protected int gbi;
    protected float gbj;
    protected float gbk;
    protected float gbl;
    protected int gbm;
    protected int gbn;
    protected int gbo;
    protected int gbp;
    protected View gbq;
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
        this.gaZ = null;
        this.gba = null;
        this.gbb = 0;
        this.gbc = 0;
        this.gbd = 0;
        this.gbe = 0;
        this.gbf = 0;
        this.gbg = 0;
        this.gbh = 0;
        this.gbi = 0;
        this.gbj = 0.0f;
        this.gbk = 0.0f;
        this.gbl = 0.0f;
        this.gbm = 0;
        this.gbn = 0;
        this.gbo = 0;
        this.gbp = 0;
        this.gbq = null;
        this.mTag = "";
        this.mActivity = null;
        this.gaW = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gaZ = null;
        this.gba = null;
        this.gbb = 0;
        this.gbc = 0;
        this.gbd = 0;
        this.gbe = 0;
        this.gbf = 0;
        this.gbg = 0;
        this.gbh = 0;
        this.gbi = 0;
        this.gbj = 0.0f;
        this.gbk = 0.0f;
        this.gbl = 0.0f;
        this.gbm = 0;
        this.gbn = 0;
        this.gbo = 0;
        this.gbp = 0;
        this.gbq = null;
        this.mTag = "";
        this.mActivity = null;
        this.gaW = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gaZ = null;
        this.gba = null;
        this.gbb = 0;
        this.gbc = 0;
        this.gbd = 0;
        this.gbe = 0;
        this.gbf = 0;
        this.gbg = 0;
        this.gbh = 0;
        this.gbi = 0;
        this.gbj = 0.0f;
        this.gbk = 0.0f;
        this.gbl = 0.0f;
        this.gbm = 0;
        this.gbn = 0;
        this.gbo = 0;
        this.gbp = 0;
        this.gbq = null;
        this.mTag = "";
        this.mActivity = null;
        this.gaW = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gbi = this.mResources.getColor(d.C0126d.form_font_color);
        this.gbm = this.mResources.getColor(d.C0126d.form_button_font_color);
        this.gbo = this.mResources.getColor(d.C0126d.form_button_grey_bg_color);
        this.gbn = -1;
        this.gbp = -1;
        this.gbh = -1;
        this.gaZ = this.mResources.getDrawable(d.f.form_frame_white);
        this.gba = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view2, DrawableType drawableType) {
        this.gbq = view2;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gbq.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gbq.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.gbq.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gbq;
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
        this.gaW = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.gbb = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.gaW);
        this.gbc = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.gaW);
        this.gbd = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.gaW);
        this.gbe = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.gaW);
        this.gbf = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.gaW);
        this.gbg = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.gaW);
        this.gbj = (int) (this.gaW * dimension);
        this.gbk = (int) (this.gaW * dimension2);
        this.gbl = (int) (this.gaW * dimension3);
    }
}
