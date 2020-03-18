package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes13.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float bhg;
    protected int jMA;
    protected int jMB;
    protected View jMC;
    protected float jMj;
    protected Drawable jMm;
    protected Drawable jMn;
    protected int jMo;
    protected int jMp;
    protected int jMq;
    protected int jMr;
    protected int jMs;
    protected int jMt;
    protected int jMu;
    protected int jMv;
    protected float jMw;
    protected float jMx;
    protected int jMy;
    protected int jMz;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* loaded from: classes13.dex */
    protected enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.jMm = null;
        this.jMn = null;
        this.jMo = 0;
        this.jMp = 0;
        this.jMq = 0;
        this.jMr = 0;
        this.jMs = 0;
        this.jMt = 0;
        this.jMu = 0;
        this.jMv = 0;
        this.bhg = 0.0f;
        this.jMw = 0.0f;
        this.jMx = 0.0f;
        this.jMy = 0;
        this.jMz = 0;
        this.jMA = 0;
        this.jMB = 0;
        this.jMC = null;
        this.mTag = "";
        this.mActivity = null;
        this.jMj = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.jMm = null;
        this.jMn = null;
        this.jMo = 0;
        this.jMp = 0;
        this.jMq = 0;
        this.jMr = 0;
        this.jMs = 0;
        this.jMt = 0;
        this.jMu = 0;
        this.jMv = 0;
        this.bhg = 0.0f;
        this.jMw = 0.0f;
        this.jMx = 0.0f;
        this.jMy = 0;
        this.jMz = 0;
        this.jMA = 0;
        this.jMB = 0;
        this.jMC = null;
        this.mTag = "";
        this.mActivity = null;
        this.jMj = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.jMm = null;
        this.jMn = null;
        this.jMo = 0;
        this.jMp = 0;
        this.jMq = 0;
        this.jMr = 0;
        this.jMs = 0;
        this.jMt = 0;
        this.jMu = 0;
        this.jMv = 0;
        this.bhg = 0.0f;
        this.jMw = 0.0f;
        this.jMx = 0.0f;
        this.jMy = 0;
        this.jMz = 0;
        this.jMA = 0;
        this.jMB = 0;
        this.jMC = null;
        this.mTag = "";
        this.mActivity = null;
        this.jMj = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.jMv = this.mResources.getColor(R.color.form_font_color);
        this.jMy = this.mResources.getColor(R.color.form_button_font_color);
        this.jMA = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.jMz = -1;
        this.jMB = -1;
        this.jMu = -1;
        this.jMm = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.jMn = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.jMC = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.jMC.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.jMC.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.jMC.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.jMC;
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
    public int cDB() {
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

    public void aJ(float f) {
        this.jMj = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.jMo = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.jMj);
        this.jMp = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.jMj);
        this.jMq = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.jMj);
        this.jMr = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.jMj);
        this.jMs = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.jMj);
        this.jMt = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.jMj);
        this.bhg = (int) (this.jMj * dimension);
        this.jMw = (int) (this.jMj * dimension2);
        this.jMx = (int) (this.jMj * dimension3);
    }
}
