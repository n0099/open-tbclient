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
/* loaded from: classes8.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float cKa;
    protected Activity mActivity;
    protected int mButtonFontColor;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;
    protected float mVB;
    protected Drawable mVE;
    protected Drawable mVF;
    protected int mVG;
    protected int mVH;
    protected int mVI;
    protected int mVJ;
    protected int mVK;
    protected int mVL;
    protected int mVM;
    protected int mVN;
    protected float mVO;
    protected float mVP;
    protected int mVQ;
    protected int mVR;
    protected int mVS;
    protected View mVT;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.mVE = null;
        this.mVF = null;
        this.mVG = 0;
        this.mVH = 0;
        this.mVI = 0;
        this.mVJ = 0;
        this.mVK = 0;
        this.mVL = 0;
        this.mVM = 0;
        this.mVN = 0;
        this.cKa = 0.0f;
        this.mVO = 0.0f;
        this.mVP = 0.0f;
        this.mButtonFontColor = 0;
        this.mVQ = 0;
        this.mVR = 0;
        this.mVS = 0;
        this.mVT = null;
        this.mTag = "";
        this.mActivity = null;
        this.mVB = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mVE = null;
        this.mVF = null;
        this.mVG = 0;
        this.mVH = 0;
        this.mVI = 0;
        this.mVJ = 0;
        this.mVK = 0;
        this.mVL = 0;
        this.mVM = 0;
        this.mVN = 0;
        this.cKa = 0.0f;
        this.mVO = 0.0f;
        this.mVP = 0.0f;
        this.mButtonFontColor = 0;
        this.mVQ = 0;
        this.mVR = 0;
        this.mVS = 0;
        this.mVT = null;
        this.mTag = "";
        this.mActivity = null;
        this.mVB = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mVE = null;
        this.mVF = null;
        this.mVG = 0;
        this.mVH = 0;
        this.mVI = 0;
        this.mVJ = 0;
        this.mVK = 0;
        this.mVL = 0;
        this.mVM = 0;
        this.mVN = 0;
        this.cKa = 0.0f;
        this.mVO = 0.0f;
        this.mVP = 0.0f;
        this.mButtonFontColor = 0;
        this.mVQ = 0;
        this.mVR = 0;
        this.mVS = 0;
        this.mVT = null;
        this.mTag = "";
        this.mActivity = null;
        this.mVB = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mVN = this.mResources.getColor(R.color.form_font_color);
        this.mButtonFontColor = this.mResources.getColor(R.color.form_button_font_color);
        this.mVR = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mVQ = -1;
        this.mVS = -1;
        this.mVM = -1;
        this.mVE = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mVF = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mVT = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mVT.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mVT.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mVT.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mVT;
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
    public int dDS() {
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

    public void aZ(float f) {
        this.mVB = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mVG = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mVB);
        this.mVH = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mVB);
        this.mVI = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mVB);
        this.mVJ = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mVB);
        this.mVK = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mVB);
        this.mVL = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mVB);
        this.cKa = (int) (this.mVB * dimension);
        this.mVO = (int) (this.mVB * dimension2);
        this.mVP = (int) (this.mVB * dimension3);
    }
}
