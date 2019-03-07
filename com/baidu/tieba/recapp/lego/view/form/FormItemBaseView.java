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
    protected int ilB;
    protected int ilC;
    protected int ilD;
    protected int ilE;
    protected View ilF;
    protected float ilm;
    protected Drawable ilp;
    protected Drawable ilq;
    protected int ilr;
    protected int ils;
    protected int ilt;
    protected int ilu;
    protected int ilv;
    protected int ilw;
    protected int ilx;
    protected int ily;
    protected float ilz;
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
        this.ilp = null;
        this.ilq = null;
        this.ilr = 0;
        this.ils = 0;
        this.ilt = 0;
        this.ilu = 0;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.alK = 0.0f;
        this.ilz = 0.0f;
        this.ilA = 0.0f;
        this.ilB = 0;
        this.ilC = 0;
        this.ilD = 0;
        this.ilE = 0;
        this.ilF = null;
        this.mTag = "";
        this.mActivity = null;
        this.ilm = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.ilp = null;
        this.ilq = null;
        this.ilr = 0;
        this.ils = 0;
        this.ilt = 0;
        this.ilu = 0;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.alK = 0.0f;
        this.ilz = 0.0f;
        this.ilA = 0.0f;
        this.ilB = 0;
        this.ilC = 0;
        this.ilD = 0;
        this.ilE = 0;
        this.ilF = null;
        this.mTag = "";
        this.mActivity = null;
        this.ilm = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.ilp = null;
        this.ilq = null;
        this.ilr = 0;
        this.ils = 0;
        this.ilt = 0;
        this.ilu = 0;
        this.ilv = 0;
        this.ilw = 0;
        this.ilx = 0;
        this.ily = 0;
        this.alK = 0.0f;
        this.ilz = 0.0f;
        this.ilA = 0.0f;
        this.ilB = 0;
        this.ilC = 0;
        this.ilD = 0;
        this.ilE = 0;
        this.ilF = null;
        this.mTag = "";
        this.mActivity = null;
        this.ilm = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.ily = this.mResources.getColor(d.C0236d.form_font_color);
        this.ilB = this.mResources.getColor(d.C0236d.form_button_font_color);
        this.ilD = this.mResources.getColor(d.C0236d.form_button_grey_bg_color);
        this.ilC = -1;
        this.ilE = -1;
        this.ilx = -1;
        this.ilp = this.mResources.getDrawable(d.f.form_frame_white);
        this.ilq = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.ilF = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.ilF.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.ilF.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.ilF.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.ilF;
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
    public int bXq() {
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
        this.ilm = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.ilr = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.ilm);
        this.ils = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.ilm);
        this.ilt = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.ilm);
        this.ilu = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.ilm);
        this.ilv = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.ilm);
        this.ilw = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.ilm);
        this.alK = (int) (this.ilm * dimension);
        this.ilz = (int) (this.ilm * dimension2);
        this.ilA = (int) (this.ilm * dimension3);
    }
}
