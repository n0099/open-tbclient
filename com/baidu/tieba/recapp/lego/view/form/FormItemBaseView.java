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
    protected float bTc;
    protected Drawable liB;
    protected Drawable liC;
    protected int liD;
    protected int liE;
    protected int liF;
    protected int liG;
    protected int liH;
    protected int liI;
    protected int liJ;
    protected int liK;
    protected float liL;
    protected float liM;
    protected int liN;
    protected int liO;
    protected int liP;
    protected int liQ;
    protected View liR;
    protected float liy;
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
        this.liB = null;
        this.liC = null;
        this.liD = 0;
        this.liE = 0;
        this.liF = 0;
        this.liG = 0;
        this.liH = 0;
        this.liI = 0;
        this.liJ = 0;
        this.liK = 0;
        this.bTc = 0.0f;
        this.liL = 0.0f;
        this.liM = 0.0f;
        this.liN = 0;
        this.liO = 0;
        this.liP = 0;
        this.liQ = 0;
        this.liR = null;
        this.mTag = "";
        this.mActivity = null;
        this.liy = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.liB = null;
        this.liC = null;
        this.liD = 0;
        this.liE = 0;
        this.liF = 0;
        this.liG = 0;
        this.liH = 0;
        this.liI = 0;
        this.liJ = 0;
        this.liK = 0;
        this.bTc = 0.0f;
        this.liL = 0.0f;
        this.liM = 0.0f;
        this.liN = 0;
        this.liO = 0;
        this.liP = 0;
        this.liQ = 0;
        this.liR = null;
        this.mTag = "";
        this.mActivity = null;
        this.liy = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.liB = null;
        this.liC = null;
        this.liD = 0;
        this.liE = 0;
        this.liF = 0;
        this.liG = 0;
        this.liH = 0;
        this.liI = 0;
        this.liJ = 0;
        this.liK = 0;
        this.bTc = 0.0f;
        this.liL = 0.0f;
        this.liM = 0.0f;
        this.liN = 0;
        this.liO = 0;
        this.liP = 0;
        this.liQ = 0;
        this.liR = null;
        this.mTag = "";
        this.mActivity = null;
        this.liy = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.liK = this.mResources.getColor(R.color.form_font_color);
        this.liN = this.mResources.getColor(R.color.form_button_font_color);
        this.liP = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.liO = -1;
        this.liQ = -1;
        this.liJ = -1;
        this.liB = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.liC = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.liR = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.liR.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.liR.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.liR.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.liR;
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
    public int cZA() {
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

    public void ax(float f) {
        this.liy = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.liD = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.liy);
        this.liE = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.liy);
        this.liF = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.liy);
        this.liG = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.liy);
        this.liH = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.liy);
        this.liI = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.liy);
        this.bTc = (int) (this.liy * dimension);
        this.liL = (int) (this.liy * dimension2);
        this.liM = (int) (this.liy * dimension3);
    }
}
