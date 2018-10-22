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
    protected int gHA;
    protected int gHB;
    protected int gHC;
    protected int gHD;
    protected int gHE;
    protected int gHF;
    protected int gHG;
    protected int gHH;
    protected float gHI;
    protected float gHJ;
    protected int gHK;
    protected int gHL;
    protected int gHM;
    protected int gHN;
    protected View gHO;
    protected float gHv;
    protected Drawable gHy;
    protected Drawable gHz;
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
        this.gHy = null;
        this.gHz = null;
        this.gHA = 0;
        this.gHB = 0;
        this.gHC = 0;
        this.gHD = 0;
        this.gHE = 0;
        this.gHF = 0;
        this.gHG = 0;
        this.gHH = 0;
        this.mFontSize = 0.0f;
        this.gHI = 0.0f;
        this.gHJ = 0.0f;
        this.gHK = 0;
        this.gHL = 0;
        this.gHM = 0;
        this.gHN = 0;
        this.gHO = null;
        this.mTag = "";
        this.mActivity = null;
        this.gHv = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gHy = null;
        this.gHz = null;
        this.gHA = 0;
        this.gHB = 0;
        this.gHC = 0;
        this.gHD = 0;
        this.gHE = 0;
        this.gHF = 0;
        this.gHG = 0;
        this.gHH = 0;
        this.mFontSize = 0.0f;
        this.gHI = 0.0f;
        this.gHJ = 0.0f;
        this.gHK = 0;
        this.gHL = 0;
        this.gHM = 0;
        this.gHN = 0;
        this.gHO = null;
        this.mTag = "";
        this.mActivity = null;
        this.gHv = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gHy = null;
        this.gHz = null;
        this.gHA = 0;
        this.gHB = 0;
        this.gHC = 0;
        this.gHD = 0;
        this.gHE = 0;
        this.gHF = 0;
        this.gHG = 0;
        this.gHH = 0;
        this.mFontSize = 0.0f;
        this.gHI = 0.0f;
        this.gHJ = 0.0f;
        this.gHK = 0;
        this.gHL = 0;
        this.gHM = 0;
        this.gHN = 0;
        this.gHO = null;
        this.mTag = "";
        this.mActivity = null;
        this.gHv = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gHH = this.mResources.getColor(e.d.form_font_color);
        this.gHK = this.mResources.getColor(e.d.form_button_font_color);
        this.gHM = this.mResources.getColor(e.d.form_button_grey_bg_color);
        this.gHL = -1;
        this.gHN = -1;
        this.gHG = -1;
        this.gHy = this.mResources.getDrawable(e.f.form_frame_white);
        this.gHz = this.mResources.getDrawable(e.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gHO = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gHO.setBackgroundResource(e.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gHO.setBackgroundResource(e.f.form_frame_white);
                return;
            default:
                this.gHO.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gHO;
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
    public int btU() {
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

    public void aw(float f) {
        this.gHv = f;
        float dimension = this.mResources.getDimension(e.C0175e.form_font_size28);
        float dimension2 = this.mResources.getDimension(e.C0175e.form_font_size20);
        float dimension3 = this.mResources.getDimension(e.C0175e.form_font_size36);
        this.gHA = (int) (((int) this.mResources.getDimension(e.C0175e.form_size20)) * this.gHv);
        this.gHB = (int) (((int) this.mResources.getDimension(e.C0175e.form_size40)) * this.gHv);
        this.gHC = (int) (((int) this.mResources.getDimension(e.C0175e.form_size50)) * this.gHv);
        this.gHD = (int) (((int) this.mResources.getDimension(e.C0175e.form_size80)) * this.gHv);
        this.gHE = (int) (((int) this.mResources.getDimension(e.C0175e.form_size90)) * this.gHv);
        this.gHF = (int) (((int) this.mResources.getDimension(e.C0175e.form_size240)) * this.gHv);
        this.mFontSize = (int) (this.gHv * dimension);
        this.gHI = (int) (this.gHv * dimension2);
        this.gHJ = (int) (this.gHv * dimension3);
    }
}
