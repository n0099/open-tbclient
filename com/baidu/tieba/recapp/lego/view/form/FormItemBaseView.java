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
    protected float gFZ;
    protected Drawable gGc;
    protected Drawable gGd;
    protected int gGe;
    protected int gGf;
    protected int gGg;
    protected int gGh;
    protected int gGi;
    protected int gGj;
    protected int gGk;
    protected int gGl;
    protected float gGm;
    protected float gGn;
    protected float gGo;
    protected int gGp;
    protected int gGq;
    protected int gGr;
    protected int gGs;
    protected View gGt;
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
        this.gGc = null;
        this.gGd = null;
        this.gGe = 0;
        this.gGf = 0;
        this.gGg = 0;
        this.gGh = 0;
        this.gGi = 0;
        this.gGj = 0;
        this.gGk = 0;
        this.gGl = 0;
        this.gGm = 0.0f;
        this.gGn = 0.0f;
        this.gGo = 0.0f;
        this.gGp = 0;
        this.gGq = 0;
        this.gGr = 0;
        this.gGs = 0;
        this.gGt = null;
        this.mTag = "";
        this.mActivity = null;
        this.gFZ = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gGl = this.mResources.getColor(d.C0140d.form_font_color);
        this.gGp = this.mResources.getColor(d.C0140d.form_button_font_color);
        this.gGr = this.mResources.getColor(d.C0140d.form_button_grey_bg_color);
        this.gGq = -1;
        this.gGs = -1;
        this.gGk = -1;
        this.gGc = this.mResources.getDrawable(d.f.form_frame_white);
        this.gGd = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gGt = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gGt.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gGt.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.gGt.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gGt;
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
    public int boO() {
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
        this.gFZ = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.gGe = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.gFZ);
        this.gGf = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.gFZ);
        this.gGg = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.gFZ);
        this.gGh = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.gFZ);
        this.gGi = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.gFZ);
        this.gGj = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.gFZ);
        this.gGm = (int) (this.gFZ * dimension);
        this.gGn = (int) (this.gFZ * dimension2);
        this.gGo = (int) (this.gFZ * dimension3);
    }
}
