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
    protected float iDI;
    protected Drawable iDL;
    protected Drawable iDM;
    protected int iDN;
    protected int iDO;
    protected int iDP;
    protected int iDQ;
    protected int iDR;
    protected int iDS;
    protected int iDT;
    protected int iDU;
    protected float iDV;
    protected float iDW;
    protected int iDX;
    protected int iDY;
    protected int iDZ;
    protected int iEa;
    protected View iEb;
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
        this.iDL = null;
        this.iDM = null;
        this.iDN = 0;
        this.iDO = 0;
        this.iDP = 0;
        this.iDQ = 0;
        this.iDR = 0;
        this.iDS = 0;
        this.iDT = 0;
        this.iDU = 0;
        this.amc = 0.0f;
        this.iDV = 0.0f;
        this.iDW = 0.0f;
        this.iDX = 0;
        this.iDY = 0;
        this.iDZ = 0;
        this.iEa = 0;
        this.iEb = null;
        this.mTag = "";
        this.mActivity = null;
        this.iDI = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.iDL = null;
        this.iDM = null;
        this.iDN = 0;
        this.iDO = 0;
        this.iDP = 0;
        this.iDQ = 0;
        this.iDR = 0;
        this.iDS = 0;
        this.iDT = 0;
        this.iDU = 0;
        this.amc = 0.0f;
        this.iDV = 0.0f;
        this.iDW = 0.0f;
        this.iDX = 0;
        this.iDY = 0;
        this.iDZ = 0;
        this.iEa = 0;
        this.iEb = null;
        this.mTag = "";
        this.mActivity = null;
        this.iDI = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.iDL = null;
        this.iDM = null;
        this.iDN = 0;
        this.iDO = 0;
        this.iDP = 0;
        this.iDQ = 0;
        this.iDR = 0;
        this.iDS = 0;
        this.iDT = 0;
        this.iDU = 0;
        this.amc = 0.0f;
        this.iDV = 0.0f;
        this.iDW = 0.0f;
        this.iDX = 0;
        this.iDY = 0;
        this.iDZ = 0;
        this.iEa = 0;
        this.iEb = null;
        this.mTag = "";
        this.mActivity = null;
        this.iDI = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.iDU = this.mResources.getColor(R.color.form_font_color);
        this.iDX = this.mResources.getColor(R.color.form_button_font_color);
        this.iDZ = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.iDY = -1;
        this.iEa = -1;
        this.iDT = -1;
        this.iDL = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.iDM = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.iEb = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.iEb.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.iEb.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.iEb.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.iEb;
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
    public int cfw() {
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
        this.iDI = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.iDN = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.iDI);
        this.iDO = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.iDI);
        this.iDP = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.iDI);
        this.iDQ = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.iDI);
        this.iDR = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.iDI);
        this.iDS = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.iDI);
        this.amc = (int) (this.iDI * dimension);
        this.iDV = (int) (this.iDI * dimension2);
        this.iDW = (int) (this.iDI * dimension3);
    }
}
