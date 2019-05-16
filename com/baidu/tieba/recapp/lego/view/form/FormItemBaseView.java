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
    protected float amc;
    protected float iDF;
    protected Drawable iDI;
    protected Drawable iDJ;
    protected int iDK;
    protected int iDL;
    protected int iDM;
    protected int iDN;
    protected int iDO;
    protected int iDP;
    protected int iDQ;
    protected int iDR;
    protected float iDS;
    protected float iDT;
    protected int iDU;
    protected int iDV;
    protected int iDW;
    protected int iDX;
    protected View iDY;
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
        this.iDI = null;
        this.iDJ = null;
        this.iDK = 0;
        this.iDL = 0;
        this.iDM = 0;
        this.iDN = 0;
        this.iDO = 0;
        this.iDP = 0;
        this.iDQ = 0;
        this.iDR = 0;
        this.amc = 0.0f;
        this.iDS = 0.0f;
        this.iDT = 0.0f;
        this.iDU = 0;
        this.iDV = 0;
        this.iDW = 0;
        this.iDX = 0;
        this.iDY = null;
        this.mTag = "";
        this.mActivity = null;
        this.iDF = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.iDI = null;
        this.iDJ = null;
        this.iDK = 0;
        this.iDL = 0;
        this.iDM = 0;
        this.iDN = 0;
        this.iDO = 0;
        this.iDP = 0;
        this.iDQ = 0;
        this.iDR = 0;
        this.amc = 0.0f;
        this.iDS = 0.0f;
        this.iDT = 0.0f;
        this.iDU = 0;
        this.iDV = 0;
        this.iDW = 0;
        this.iDX = 0;
        this.iDY = null;
        this.mTag = "";
        this.mActivity = null;
        this.iDF = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.iDI = null;
        this.iDJ = null;
        this.iDK = 0;
        this.iDL = 0;
        this.iDM = 0;
        this.iDN = 0;
        this.iDO = 0;
        this.iDP = 0;
        this.iDQ = 0;
        this.iDR = 0;
        this.amc = 0.0f;
        this.iDS = 0.0f;
        this.iDT = 0.0f;
        this.iDU = 0;
        this.iDV = 0;
        this.iDW = 0;
        this.iDX = 0;
        this.iDY = null;
        this.mTag = "";
        this.mActivity = null;
        this.iDF = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.iDR = this.mResources.getColor(R.color.form_font_color);
        this.iDU = this.mResources.getColor(R.color.form_button_font_color);
        this.iDW = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.iDV = -1;
        this.iDX = -1;
        this.iDQ = -1;
        this.iDI = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.iDJ = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.iDY = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.iDY.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.iDY.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.iDY.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.iDY;
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
    public int cft() {
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

    public void aP(float f) {
        this.iDF = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.iDK = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.iDF);
        this.iDL = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.iDF);
        this.iDM = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.iDF);
        this.iDN = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.iDF);
        this.iDO = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.iDF);
        this.iDP = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.iDF);
        this.amc = (int) (this.iDF * dimension);
        this.iDS = (int) (this.iDF * dimension2);
        this.iDT = (int) (this.iDF * dimension3);
    }
}
