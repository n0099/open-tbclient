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
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float aGv;
    protected int iMA;
    protected int iMB;
    protected int iMC;
    protected int iMD;
    protected int iME;
    protected float iMF;
    protected float iMG;
    protected int iMH;
    protected int iMI;
    protected int iMJ;
    protected int iMK;
    protected View iML;
    protected float iMs;
    protected Drawable iMv;
    protected Drawable iMw;
    protected int iMx;
    protected int iMy;
    protected int iMz;
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
        this.iMv = null;
        this.iMw = null;
        this.iMx = 0;
        this.iMy = 0;
        this.iMz = 0;
        this.iMA = 0;
        this.iMB = 0;
        this.iMC = 0;
        this.iMD = 0;
        this.iME = 0;
        this.aGv = 0.0f;
        this.iMF = 0.0f;
        this.iMG = 0.0f;
        this.iMH = 0;
        this.iMI = 0;
        this.iMJ = 0;
        this.iMK = 0;
        this.iML = null;
        this.mTag = "";
        this.mActivity = null;
        this.iMs = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.iMv = null;
        this.iMw = null;
        this.iMx = 0;
        this.iMy = 0;
        this.iMz = 0;
        this.iMA = 0;
        this.iMB = 0;
        this.iMC = 0;
        this.iMD = 0;
        this.iME = 0;
        this.aGv = 0.0f;
        this.iMF = 0.0f;
        this.iMG = 0.0f;
        this.iMH = 0;
        this.iMI = 0;
        this.iMJ = 0;
        this.iMK = 0;
        this.iML = null;
        this.mTag = "";
        this.mActivity = null;
        this.iMs = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.iMv = null;
        this.iMw = null;
        this.iMx = 0;
        this.iMy = 0;
        this.iMz = 0;
        this.iMA = 0;
        this.iMB = 0;
        this.iMC = 0;
        this.iMD = 0;
        this.iME = 0;
        this.aGv = 0.0f;
        this.iMF = 0.0f;
        this.iMG = 0.0f;
        this.iMH = 0;
        this.iMI = 0;
        this.iMJ = 0;
        this.iMK = 0;
        this.iML = null;
        this.mTag = "";
        this.mActivity = null;
        this.iMs = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.iME = this.mResources.getColor(R.color.form_font_color);
        this.iMH = this.mResources.getColor(R.color.form_button_font_color);
        this.iMJ = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.iMI = -1;
        this.iMK = -1;
        this.iMD = -1;
        this.iMv = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.iMw = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.iML = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.iML.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.iML.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.iML.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.iML;
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
    public int cgx() {
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

    public void au(float f) {
        this.iMs = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.iMx = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.iMs);
        this.iMy = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.iMs);
        this.iMz = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.iMs);
        this.iMA = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.iMs);
        this.iMB = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.iMs);
        this.iMC = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.iMs);
        this.aGv = (int) (this.iMs * dimension);
        this.iMF = (int) (this.iMs * dimension2);
        this.iMG = (int) (this.iMs * dimension3);
    }
}
