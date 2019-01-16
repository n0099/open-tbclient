package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float gTJ;
    protected Drawable gTM;
    protected Drawable gTN;
    protected int gTO;
    protected int gTP;
    protected int gTQ;
    protected int gTR;
    protected int gTS;
    protected int gTT;
    protected int gTU;
    protected int gTV;
    protected float gTW;
    protected float gTX;
    protected int gTY;
    protected int gTZ;
    protected int gUa;
    protected int gUb;
    protected View gUc;
    protected Activity mActivity;
    protected Context mContext;
    protected float mFontSize;
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
        this.gTM = null;
        this.gTN = null;
        this.gTO = 0;
        this.gTP = 0;
        this.gTQ = 0;
        this.gTR = 0;
        this.gTS = 0;
        this.gTT = 0;
        this.gTU = 0;
        this.gTV = 0;
        this.mFontSize = 0.0f;
        this.gTW = 0.0f;
        this.gTX = 0.0f;
        this.gTY = 0;
        this.gTZ = 0;
        this.gUa = 0;
        this.gUb = 0;
        this.gUc = null;
        this.mTag = "";
        this.mActivity = null;
        this.gTJ = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gTM = null;
        this.gTN = null;
        this.gTO = 0;
        this.gTP = 0;
        this.gTQ = 0;
        this.gTR = 0;
        this.gTS = 0;
        this.gTT = 0;
        this.gTU = 0;
        this.gTV = 0;
        this.mFontSize = 0.0f;
        this.gTW = 0.0f;
        this.gTX = 0.0f;
        this.gTY = 0;
        this.gTZ = 0;
        this.gUa = 0;
        this.gUb = 0;
        this.gUc = null;
        this.mTag = "";
        this.mActivity = null;
        this.gTJ = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gTM = null;
        this.gTN = null;
        this.gTO = 0;
        this.gTP = 0;
        this.gTQ = 0;
        this.gTR = 0;
        this.gTS = 0;
        this.gTT = 0;
        this.gTU = 0;
        this.gTV = 0;
        this.mFontSize = 0.0f;
        this.gTW = 0.0f;
        this.gTX = 0.0f;
        this.gTY = 0;
        this.gTZ = 0;
        this.gUa = 0;
        this.gUb = 0;
        this.gUc = null;
        this.mTag = "";
        this.mActivity = null;
        this.gTJ = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gTV = this.mResources.getColor(e.d.form_font_color);
        this.gTY = this.mResources.getColor(e.d.form_button_font_color);
        this.gUa = this.mResources.getColor(e.d.form_button_grey_bg_color);
        this.gTZ = -1;
        this.gUb = -1;
        this.gTU = -1;
        this.gTM = this.mResources.getDrawable(e.f.form_frame_white);
        this.gTN = this.mResources.getDrawable(e.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gUc = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gUc.setBackgroundResource(e.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gUc.setBackgroundResource(e.f.form_frame_white);
                return;
            default:
                this.gUc.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gUc;
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
    public int bwD() {
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

    public void ay(float f) {
        this.gTJ = f;
        float dimension = this.mResources.getDimension(e.C0210e.form_font_size28);
        float dimension2 = this.mResources.getDimension(e.C0210e.form_font_size20);
        float dimension3 = this.mResources.getDimension(e.C0210e.form_font_size36);
        this.gTO = (int) (((int) this.mResources.getDimension(e.C0210e.form_size20)) * this.gTJ);
        this.gTP = (int) (((int) this.mResources.getDimension(e.C0210e.form_size40)) * this.gTJ);
        this.gTQ = (int) (((int) this.mResources.getDimension(e.C0210e.form_size50)) * this.gTJ);
        this.gTR = (int) (((int) this.mResources.getDimension(e.C0210e.form_size80)) * this.gTJ);
        this.gTS = (int) (((int) this.mResources.getDimension(e.C0210e.form_size90)) * this.gTJ);
        this.gTT = (int) (((int) this.mResources.getDimension(e.C0210e.form_size240)) * this.gTJ);
        this.mFontSize = (int) (this.gTJ * dimension);
        this.gTW = (int) (this.gTJ * dimension2);
        this.gTX = (int) (this.gTJ * dimension3);
    }
}
