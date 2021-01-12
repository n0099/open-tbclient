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
/* loaded from: classes7.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float cHI;
    protected Activity mActivity;
    protected Context mContext;
    protected float mMA;
    protected int mMB;
    protected int mMC;
    protected int mMD;
    protected int mME;
    protected View mMF;
    protected float mMm;
    protected Drawable mMp;
    protected Drawable mMq;
    protected int mMr;
    protected int mMs;
    protected int mMt;
    protected int mMu;
    protected int mMv;
    protected int mMw;
    protected int mMx;
    protected int mMy;
    protected float mMz;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.mMp = null;
        this.mMq = null;
        this.mMr = 0;
        this.mMs = 0;
        this.mMt = 0;
        this.mMu = 0;
        this.mMv = 0;
        this.mMw = 0;
        this.mMx = 0;
        this.mMy = 0;
        this.cHI = 0.0f;
        this.mMz = 0.0f;
        this.mMA = 0.0f;
        this.mMB = 0;
        this.mMC = 0;
        this.mMD = 0;
        this.mME = 0;
        this.mMF = null;
        this.mTag = "";
        this.mActivity = null;
        this.mMm = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mMp = null;
        this.mMq = null;
        this.mMr = 0;
        this.mMs = 0;
        this.mMt = 0;
        this.mMu = 0;
        this.mMv = 0;
        this.mMw = 0;
        this.mMx = 0;
        this.mMy = 0;
        this.cHI = 0.0f;
        this.mMz = 0.0f;
        this.mMA = 0.0f;
        this.mMB = 0;
        this.mMC = 0;
        this.mMD = 0;
        this.mME = 0;
        this.mMF = null;
        this.mTag = "";
        this.mActivity = null;
        this.mMm = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mMp = null;
        this.mMq = null;
        this.mMr = 0;
        this.mMs = 0;
        this.mMt = 0;
        this.mMu = 0;
        this.mMv = 0;
        this.mMw = 0;
        this.mMx = 0;
        this.mMy = 0;
        this.cHI = 0.0f;
        this.mMz = 0.0f;
        this.mMA = 0.0f;
        this.mMB = 0;
        this.mMC = 0;
        this.mMD = 0;
        this.mME = 0;
        this.mMF = null;
        this.mTag = "";
        this.mActivity = null;
        this.mMm = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mMy = this.mResources.getColor(R.color.form_font_color);
        this.mMB = this.mResources.getColor(R.color.form_button_font_color);
        this.mMD = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mMC = -1;
        this.mME = -1;
        this.mMx = -1;
        this.mMp = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mMq = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mMF = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mMF.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mMF.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mMF.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mMF;
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
    public int dBK() {
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

    public void aW(float f) {
        this.mMm = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mMr = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mMm);
        this.mMs = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mMm);
        this.mMt = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mMm);
        this.mMu = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mMm);
        this.mMv = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mMm);
        this.mMw = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mMm);
        this.cHI = (int) (this.mMm * dimension);
        this.mMz = (int) (this.mMm * dimension2);
        this.mMA = (int) (this.mMm * dimension3);
    }
}
