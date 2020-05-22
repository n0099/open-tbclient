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
    protected float bOo;
    protected Drawable kNA;
    protected int kNB;
    protected int kNC;
    protected int kND;
    protected int kNE;
    protected int kNF;
    protected int kNG;
    protected int kNH;
    protected int kNI;
    protected float kNJ;
    protected float kNK;
    protected int kNL;
    protected int kNM;
    protected int kNN;
    protected int kNO;
    protected View kNP;
    protected float kNw;
    protected Drawable kNz;
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
        this.kNz = null;
        this.kNA = null;
        this.kNB = 0;
        this.kNC = 0;
        this.kND = 0;
        this.kNE = 0;
        this.kNF = 0;
        this.kNG = 0;
        this.kNH = 0;
        this.kNI = 0;
        this.bOo = 0.0f;
        this.kNJ = 0.0f;
        this.kNK = 0.0f;
        this.kNL = 0;
        this.kNM = 0;
        this.kNN = 0;
        this.kNO = 0;
        this.kNP = null;
        this.mTag = "";
        this.mActivity = null;
        this.kNw = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.kNz = null;
        this.kNA = null;
        this.kNB = 0;
        this.kNC = 0;
        this.kND = 0;
        this.kNE = 0;
        this.kNF = 0;
        this.kNG = 0;
        this.kNH = 0;
        this.kNI = 0;
        this.bOo = 0.0f;
        this.kNJ = 0.0f;
        this.kNK = 0.0f;
        this.kNL = 0;
        this.kNM = 0;
        this.kNN = 0;
        this.kNO = 0;
        this.kNP = null;
        this.mTag = "";
        this.mActivity = null;
        this.kNw = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.kNz = null;
        this.kNA = null;
        this.kNB = 0;
        this.kNC = 0;
        this.kND = 0;
        this.kNE = 0;
        this.kNF = 0;
        this.kNG = 0;
        this.kNH = 0;
        this.kNI = 0;
        this.bOo = 0.0f;
        this.kNJ = 0.0f;
        this.kNK = 0.0f;
        this.kNL = 0;
        this.kNM = 0;
        this.kNN = 0;
        this.kNO = 0;
        this.kNP = null;
        this.mTag = "";
        this.mActivity = null;
        this.kNw = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.kNI = this.mResources.getColor(R.color.form_font_color);
        this.kNL = this.mResources.getColor(R.color.form_button_font_color);
        this.kNN = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.kNM = -1;
        this.kNO = -1;
        this.kNH = -1;
        this.kNz = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.kNA = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.kNP = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.kNP.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.kNP.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.kNP.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.kNP;
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
    public int cUU() {
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

    public void as(float f) {
        this.kNw = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.kNB = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.kNw);
        this.kNC = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.kNw);
        this.kND = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.kNw);
        this.kNE = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.kNw);
        this.kNF = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.kNw);
        this.kNG = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.kNw);
        this.bOo = (int) (this.kNw * dimension);
        this.kNJ = (int) (this.kNw * dimension2);
        this.kNK = (int) (this.kNw * dimension3);
    }
}
