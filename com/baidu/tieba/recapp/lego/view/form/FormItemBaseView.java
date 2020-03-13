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
    protected float bgT;
    protected float jKH;
    protected Drawable jKK;
    protected Drawable jKL;
    protected int jKM;
    protected int jKN;
    protected int jKO;
    protected int jKP;
    protected int jKQ;
    protected int jKR;
    protected int jKS;
    protected int jKT;
    protected float jKU;
    protected float jKV;
    protected int jKW;
    protected int jKX;
    protected int jKY;
    protected int jKZ;
    protected View jLa;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes13.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.jKK = null;
        this.jKL = null;
        this.jKM = 0;
        this.jKN = 0;
        this.jKO = 0;
        this.jKP = 0;
        this.jKQ = 0;
        this.jKR = 0;
        this.jKS = 0;
        this.jKT = 0;
        this.bgT = 0.0f;
        this.jKU = 0.0f;
        this.jKV = 0.0f;
        this.jKW = 0;
        this.jKX = 0;
        this.jKY = 0;
        this.jKZ = 0;
        this.jLa = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKH = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.jKK = null;
        this.jKL = null;
        this.jKM = 0;
        this.jKN = 0;
        this.jKO = 0;
        this.jKP = 0;
        this.jKQ = 0;
        this.jKR = 0;
        this.jKS = 0;
        this.jKT = 0;
        this.bgT = 0.0f;
        this.jKU = 0.0f;
        this.jKV = 0.0f;
        this.jKW = 0;
        this.jKX = 0;
        this.jKY = 0;
        this.jKZ = 0;
        this.jLa = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKH = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.jKK = null;
        this.jKL = null;
        this.jKM = 0;
        this.jKN = 0;
        this.jKO = 0;
        this.jKP = 0;
        this.jKQ = 0;
        this.jKR = 0;
        this.jKS = 0;
        this.jKT = 0;
        this.bgT = 0.0f;
        this.jKU = 0.0f;
        this.jKV = 0.0f;
        this.jKW = 0;
        this.jKX = 0;
        this.jKY = 0;
        this.jKZ = 0;
        this.jLa = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKH = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.jKT = this.mResources.getColor(R.color.form_font_color);
        this.jKW = this.mResources.getColor(R.color.form_button_font_color);
        this.jKY = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.jKX = -1;
        this.jKZ = -1;
        this.jKS = -1;
        this.jKK = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.jKL = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.jLa = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.jLa.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.jLa.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.jLa.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.jLa;
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
    public int cDh() {
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

    public void aJ(float f) {
        this.jKH = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.jKM = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.jKH);
        this.jKN = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.jKH);
        this.jKO = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.jKH);
        this.jKP = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.jKH);
        this.jKQ = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.jKH);
        this.jKR = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.jKH);
        this.bgT = (int) (this.jKH * dimension);
        this.jKU = (int) (this.jKH * dimension2);
        this.jKV = (int) (this.jKH * dimension3);
    }
}
