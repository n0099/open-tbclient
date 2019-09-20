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
    protected float and;
    protected float iNA;
    protected Drawable iND;
    protected Drawable iNE;
    protected int iNF;
    protected int iNG;
    protected int iNH;
    protected int iNI;
    protected int iNJ;
    protected int iNK;
    protected int iNL;
    protected int iNM;
    protected float iNN;
    protected float iNO;
    protected int iNP;
    protected int iNQ;
    protected int iNR;
    protected int iNS;
    protected View iNT;
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
        this.iND = null;
        this.iNE = null;
        this.iNF = 0;
        this.iNG = 0;
        this.iNH = 0;
        this.iNI = 0;
        this.iNJ = 0;
        this.iNK = 0;
        this.iNL = 0;
        this.iNM = 0;
        this.and = 0.0f;
        this.iNN = 0.0f;
        this.iNO = 0.0f;
        this.iNP = 0;
        this.iNQ = 0;
        this.iNR = 0;
        this.iNS = 0;
        this.iNT = null;
        this.mTag = "";
        this.mActivity = null;
        this.iNA = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.iND = null;
        this.iNE = null;
        this.iNF = 0;
        this.iNG = 0;
        this.iNH = 0;
        this.iNI = 0;
        this.iNJ = 0;
        this.iNK = 0;
        this.iNL = 0;
        this.iNM = 0;
        this.and = 0.0f;
        this.iNN = 0.0f;
        this.iNO = 0.0f;
        this.iNP = 0;
        this.iNQ = 0;
        this.iNR = 0;
        this.iNS = 0;
        this.iNT = null;
        this.mTag = "";
        this.mActivity = null;
        this.iNA = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.iND = null;
        this.iNE = null;
        this.iNF = 0;
        this.iNG = 0;
        this.iNH = 0;
        this.iNI = 0;
        this.iNJ = 0;
        this.iNK = 0;
        this.iNL = 0;
        this.iNM = 0;
        this.and = 0.0f;
        this.iNN = 0.0f;
        this.iNO = 0.0f;
        this.iNP = 0;
        this.iNQ = 0;
        this.iNR = 0;
        this.iNS = 0;
        this.iNT = null;
        this.mTag = "";
        this.mActivity = null;
        this.iNA = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.iNM = this.mResources.getColor(R.color.form_font_color);
        this.iNP = this.mResources.getColor(R.color.form_button_font_color);
        this.iNR = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.iNQ = -1;
        this.iNS = -1;
        this.iNL = -1;
        this.iND = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.iNE = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.iNT = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.iNT.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.iNT.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.iNT.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.iNT;
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
    public int cjt() {
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

    public void aR(float f) {
        this.iNA = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.iNF = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.iNA);
        this.iNG = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.iNA);
        this.iNH = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.iNA);
        this.iNI = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.iNA);
        this.iNJ = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.iNA);
        this.iNK = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.iNA);
        this.and = (int) (this.iNA * dimension);
        this.iNN = (int) (this.iNA * dimension2);
        this.iNO = (int) (this.iNA * dimension3);
    }
}
