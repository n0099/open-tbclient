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
    protected float bgS;
    protected int jKA;
    protected int jKB;
    protected int jKC;
    protected int jKD;
    protected int jKE;
    protected int jKF;
    protected int jKG;
    protected int jKH;
    protected float jKI;
    protected float jKJ;
    protected int jKK;
    protected int jKL;
    protected int jKM;
    protected int jKN;
    protected View jKO;
    protected float jKv;
    protected Drawable jKy;
    protected Drawable jKz;
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
        this.jKy = null;
        this.jKz = null;
        this.jKA = 0;
        this.jKB = 0;
        this.jKC = 0;
        this.jKD = 0;
        this.jKE = 0;
        this.jKF = 0;
        this.jKG = 0;
        this.jKH = 0;
        this.bgS = 0.0f;
        this.jKI = 0.0f;
        this.jKJ = 0.0f;
        this.jKK = 0;
        this.jKL = 0;
        this.jKM = 0;
        this.jKN = 0;
        this.jKO = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKv = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.jKy = null;
        this.jKz = null;
        this.jKA = 0;
        this.jKB = 0;
        this.jKC = 0;
        this.jKD = 0;
        this.jKE = 0;
        this.jKF = 0;
        this.jKG = 0;
        this.jKH = 0;
        this.bgS = 0.0f;
        this.jKI = 0.0f;
        this.jKJ = 0.0f;
        this.jKK = 0;
        this.jKL = 0;
        this.jKM = 0;
        this.jKN = 0;
        this.jKO = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKv = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.jKy = null;
        this.jKz = null;
        this.jKA = 0;
        this.jKB = 0;
        this.jKC = 0;
        this.jKD = 0;
        this.jKE = 0;
        this.jKF = 0;
        this.jKG = 0;
        this.jKH = 0;
        this.bgS = 0.0f;
        this.jKI = 0.0f;
        this.jKJ = 0.0f;
        this.jKK = 0;
        this.jKL = 0;
        this.jKM = 0;
        this.jKN = 0;
        this.jKO = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKv = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.jKH = this.mResources.getColor(R.color.form_font_color);
        this.jKK = this.mResources.getColor(R.color.form_button_font_color);
        this.jKM = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.jKL = -1;
        this.jKN = -1;
        this.jKG = -1;
        this.jKy = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.jKz = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.jKO = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.jKO.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.jKO.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.jKO.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.jKO;
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
    public int cDg() {
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
        this.jKv = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.jKA = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.jKv);
        this.jKB = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.jKv);
        this.jKC = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.jKv);
        this.jKD = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.jKv);
        this.jKE = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.jKv);
        this.jKF = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.jKv);
        this.bgS = (int) (this.jKv * dimension);
        this.jKI = (int) (this.jKv * dimension2);
        this.jKJ = (int) (this.jKv * dimension3);
    }
}
