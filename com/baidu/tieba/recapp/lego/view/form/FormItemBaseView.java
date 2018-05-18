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
    protected float gcc;
    protected Drawable gcf;
    protected Drawable gcg;
    protected int gch;
    protected int gci;
    protected int gcj;
    protected int gck;
    protected int gcl;
    protected int gcm;
    protected int gcn;
    protected int gco;
    protected float gcp;
    protected float gcq;
    protected float gcr;
    protected int gcs;
    protected int gct;
    protected int gcu;
    protected int gcv;
    protected View gcw;
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
        this.gcf = null;
        this.gcg = null;
        this.gch = 0;
        this.gci = 0;
        this.gcj = 0;
        this.gck = 0;
        this.gcl = 0;
        this.gcm = 0;
        this.gcn = 0;
        this.gco = 0;
        this.gcp = 0.0f;
        this.gcq = 0.0f;
        this.gcr = 0.0f;
        this.gcs = 0;
        this.gct = 0;
        this.gcu = 0;
        this.gcv = 0;
        this.gcw = null;
        this.mTag = "";
        this.mActivity = null;
        this.gcc = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gcf = null;
        this.gcg = null;
        this.gch = 0;
        this.gci = 0;
        this.gcj = 0;
        this.gck = 0;
        this.gcl = 0;
        this.gcm = 0;
        this.gcn = 0;
        this.gco = 0;
        this.gcp = 0.0f;
        this.gcq = 0.0f;
        this.gcr = 0.0f;
        this.gcs = 0;
        this.gct = 0;
        this.gcu = 0;
        this.gcv = 0;
        this.gcw = null;
        this.mTag = "";
        this.mActivity = null;
        this.gcc = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gcf = null;
        this.gcg = null;
        this.gch = 0;
        this.gci = 0;
        this.gcj = 0;
        this.gck = 0;
        this.gcl = 0;
        this.gcm = 0;
        this.gcn = 0;
        this.gco = 0;
        this.gcp = 0.0f;
        this.gcq = 0.0f;
        this.gcr = 0.0f;
        this.gcs = 0;
        this.gct = 0;
        this.gcu = 0;
        this.gcv = 0;
        this.gcw = null;
        this.mTag = "";
        this.mActivity = null;
        this.gcc = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gco = this.mResources.getColor(d.C0126d.form_font_color);
        this.gcs = this.mResources.getColor(d.C0126d.form_button_font_color);
        this.gcu = this.mResources.getColor(d.C0126d.form_button_grey_bg_color);
        this.gct = -1;
        this.gcv = -1;
        this.gcn = -1;
        this.gcf = this.mResources.getDrawable(d.f.form_frame_white);
        this.gcg = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view2, DrawableType drawableType) {
        this.gcw = view2;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gcw.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gcw.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.gcw.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gcw;
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
    public int bjT() {
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
        this.gcc = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.gch = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.gcc);
        this.gci = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.gcc);
        this.gcj = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.gcc);
        this.gck = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.gcc);
        this.gcl = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.gcc);
        this.gcm = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.gcc);
        this.gcp = (int) (this.gcc * dimension);
        this.gcq = (int) (this.gcc * dimension2);
        this.gcr = (int) (this.gcc * dimension3);
    }
}
