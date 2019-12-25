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
/* loaded from: classes10.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float bbM;
    protected float jFQ;
    protected Drawable jFT;
    protected Drawable jFU;
    protected int jFV;
    protected int jFW;
    protected int jFX;
    protected int jFY;
    protected int jFZ;
    protected int jGa;
    protected int jGb;
    protected int jGc;
    protected float jGd;
    protected float jGe;
    protected int jGf;
    protected int jGg;
    protected int jGh;
    protected int jGi;
    protected View jGj;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* loaded from: classes10.dex */
    protected enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.jFT = null;
        this.jFU = null;
        this.jFV = 0;
        this.jFW = 0;
        this.jFX = 0;
        this.jFY = 0;
        this.jFZ = 0;
        this.jGa = 0;
        this.jGb = 0;
        this.jGc = 0;
        this.bbM = 0.0f;
        this.jGd = 0.0f;
        this.jGe = 0.0f;
        this.jGf = 0;
        this.jGg = 0;
        this.jGh = 0;
        this.jGi = 0;
        this.jGj = null;
        this.mTag = "";
        this.mActivity = null;
        this.jFQ = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.jFT = null;
        this.jFU = null;
        this.jFV = 0;
        this.jFW = 0;
        this.jFX = 0;
        this.jFY = 0;
        this.jFZ = 0;
        this.jGa = 0;
        this.jGb = 0;
        this.jGc = 0;
        this.bbM = 0.0f;
        this.jGd = 0.0f;
        this.jGe = 0.0f;
        this.jGf = 0;
        this.jGg = 0;
        this.jGh = 0;
        this.jGi = 0;
        this.jGj = null;
        this.mTag = "";
        this.mActivity = null;
        this.jFQ = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.jFT = null;
        this.jFU = null;
        this.jFV = 0;
        this.jFW = 0;
        this.jFX = 0;
        this.jFY = 0;
        this.jFZ = 0;
        this.jGa = 0;
        this.jGb = 0;
        this.jGc = 0;
        this.bbM = 0.0f;
        this.jGd = 0.0f;
        this.jGe = 0.0f;
        this.jGf = 0;
        this.jGg = 0;
        this.jGh = 0;
        this.jGi = 0;
        this.jGj = null;
        this.mTag = "";
        this.mActivity = null;
        this.jFQ = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.jGc = this.mResources.getColor(R.color.form_font_color);
        this.jGf = this.mResources.getColor(R.color.form_button_font_color);
        this.jGh = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.jGg = -1;
        this.jGi = -1;
        this.jGb = -1;
        this.jFT = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.jFU = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.jGj = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.jGj.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.jGj.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.jGj.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.jGj;
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
    public int cAz() {
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
        this.jFQ = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.jFV = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.jFQ);
        this.jFW = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.jFQ);
        this.jFX = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.jFQ);
        this.jFY = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.jFQ);
        this.jFZ = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.jFQ);
        this.jGa = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.jFQ);
        this.bbM = (int) (this.jFQ * dimension);
        this.jGd = (int) (this.jFQ * dimension2);
        this.jGe = (int) (this.jFQ * dimension3);
    }
}
