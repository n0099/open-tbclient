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
    protected float alK;
    protected float ilA;
    protected float ilB;
    protected int ilC;
    protected int ilD;
    protected int ilE;
    protected int ilF;
    protected View ilG;
    protected float iln;
    protected Drawable ilq;
    protected Drawable ilr;
    protected int ils;
    protected int ilt;
    protected int ilu;
    protected int ilv;
    protected int ilw;
    protected int ilx;
    protected int ily;
    protected int ilz;
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
        this.ilq = null;
        this.ilr = null;
        this.ils = 0;
        this.ilt = 0;
        this.ilu = 0;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.ilz = 0;
        this.alK = 0.0f;
        this.ilA = 0.0f;
        this.ilB = 0.0f;
        this.ilC = 0;
        this.ilD = 0;
        this.ilE = 0;
        this.ilF = 0;
        this.ilG = null;
        this.mTag = "";
        this.mActivity = null;
        this.iln = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.ilq = null;
        this.ilr = null;
        this.ils = 0;
        this.ilt = 0;
        this.ilu = 0;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.ilz = 0;
        this.alK = 0.0f;
        this.ilA = 0.0f;
        this.ilB = 0.0f;
        this.ilC = 0;
        this.ilD = 0;
        this.ilE = 0;
        this.ilF = 0;
        this.ilG = null;
        this.mTag = "";
        this.mActivity = null;
        this.iln = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.ilq = null;
        this.ilr = null;
        this.ils = 0;
        this.ilt = 0;
        this.ilu = 0;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.ilz = 0;
        this.alK = 0.0f;
        this.ilA = 0.0f;
        this.ilB = 0.0f;
        this.ilC = 0;
        this.ilD = 0;
        this.ilE = 0;
        this.ilF = 0;
        this.ilG = null;
        this.mTag = "";
        this.mActivity = null;
        this.iln = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.ilz = this.mResources.getColor(d.C0236d.form_font_color);
        this.ilC = this.mResources.getColor(d.C0236d.form_button_font_color);
        this.ilE = this.mResources.getColor(d.C0236d.form_button_grey_bg_color);
        this.ilD = -1;
        this.ilF = -1;
        this.ily = -1;
        this.ilq = this.mResources.getDrawable(d.f.form_frame_white);
        this.ilr = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.ilG = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.ilG.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.ilG.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.ilG.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.ilG;
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
    public int bXr() {
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
        this.iln = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.ils = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.iln);
        this.ilt = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.iln);
        this.ilu = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.iln);
        this.ilv = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.iln);
        this.ilw = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.iln);
        this.ilx = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.iln);
        this.alK = (int) (this.iln * dimension);
        this.ilA = (int) (this.iln * dimension2);
        this.ilB = (int) (this.iln * dimension3);
    }
}
