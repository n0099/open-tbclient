package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.c;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements c.a {
    protected float gFK;
    protected Drawable gFN;
    protected Drawable gFO;
    protected int gFP;
    protected int gFQ;
    protected int gFR;
    protected int gFS;
    protected int gFT;
    protected int gFU;
    protected int gFV;
    protected int gFW;
    protected float gFX;
    protected float gFY;
    protected float gFZ;
    protected int gGa;
    protected int gGb;
    protected int gGc;
    protected int gGd;
    protected View gGe;
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
        this.gFN = null;
        this.gFO = null;
        this.gFP = 0;
        this.gFQ = 0;
        this.gFR = 0;
        this.gFS = 0;
        this.gFT = 0;
        this.gFU = 0;
        this.gFV = 0;
        this.gFW = 0;
        this.gFX = 0.0f;
        this.gFY = 0.0f;
        this.gFZ = 0.0f;
        this.gGa = 0;
        this.gGb = 0;
        this.gGc = 0;
        this.gGd = 0;
        this.gGe = null;
        this.mTag = "";
        this.mActivity = null;
        this.gFK = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gFW = this.mResources.getColor(d.C0141d.form_font_color);
        this.gGa = this.mResources.getColor(d.C0141d.form_button_font_color);
        this.gGc = this.mResources.getColor(d.C0141d.form_button_grey_bg_color);
        this.gGb = -1;
        this.gGd = -1;
        this.gFV = -1;
        this.gFN = this.mResources.getDrawable(d.f.form_frame_white);
        this.gFO = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gGe = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gGe.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gGe.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.gGe.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gGe;
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
    public int boN() {
        return -2;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.c.a
    public FormItemBaseView getFormView() {
        return this;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public String getTag() {
        return this.mTag;
    }

    public void aD(float f) {
        this.gFK = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.gFP = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.gFK);
        this.gFQ = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.gFK);
        this.gFR = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.gFK);
        this.gFS = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.gFK);
        this.gFT = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.gFK);
        this.gFU = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.gFK);
        this.gFX = (int) (this.gFK * dimension);
        this.gFY = (int) (this.gFK * dimension2);
        this.gFZ = (int) (this.gFK * dimension3);
    }
}
