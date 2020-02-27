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
    protected float bgR;
    protected int jKA;
    protected int jKB;
    protected int jKC;
    protected int jKD;
    protected int jKE;
    protected int jKF;
    protected float jKG;
    protected float jKH;
    protected int jKI;
    protected int jKJ;
    protected int jKK;
    protected int jKL;
    protected View jKM;
    protected float jKt;
    protected Drawable jKw;
    protected Drawable jKx;
    protected int jKy;
    protected int jKz;
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
        this.jKw = null;
        this.jKx = null;
        this.jKy = 0;
        this.jKz = 0;
        this.jKA = 0;
        this.jKB = 0;
        this.jKC = 0;
        this.jKD = 0;
        this.jKE = 0;
        this.jKF = 0;
        this.bgR = 0.0f;
        this.jKG = 0.0f;
        this.jKH = 0.0f;
        this.jKI = 0;
        this.jKJ = 0;
        this.jKK = 0;
        this.jKL = 0;
        this.jKM = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKt = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.jKw = null;
        this.jKx = null;
        this.jKy = 0;
        this.jKz = 0;
        this.jKA = 0;
        this.jKB = 0;
        this.jKC = 0;
        this.jKD = 0;
        this.jKE = 0;
        this.jKF = 0;
        this.bgR = 0.0f;
        this.jKG = 0.0f;
        this.jKH = 0.0f;
        this.jKI = 0;
        this.jKJ = 0;
        this.jKK = 0;
        this.jKL = 0;
        this.jKM = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKt = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.jKw = null;
        this.jKx = null;
        this.jKy = 0;
        this.jKz = 0;
        this.jKA = 0;
        this.jKB = 0;
        this.jKC = 0;
        this.jKD = 0;
        this.jKE = 0;
        this.jKF = 0;
        this.bgR = 0.0f;
        this.jKG = 0.0f;
        this.jKH = 0.0f;
        this.jKI = 0;
        this.jKJ = 0;
        this.jKK = 0;
        this.jKL = 0;
        this.jKM = null;
        this.mTag = "";
        this.mActivity = null;
        this.jKt = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.jKF = this.mResources.getColor(R.color.form_font_color);
        this.jKI = this.mResources.getColor(R.color.form_button_font_color);
        this.jKK = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.jKJ = -1;
        this.jKL = -1;
        this.jKE = -1;
        this.jKw = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.jKx = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.jKM = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.jKM.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.jKM.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.jKM.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.jKM;
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
    public int cDe() {
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
        this.jKt = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.jKy = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.jKt);
        this.jKz = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.jKt);
        this.jKA = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.jKt);
        this.jKB = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.jKt);
        this.jKC = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.jKt);
        this.jKD = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.jKt);
        this.bgR = (int) (this.jKt * dimension);
        this.jKG = (int) (this.jKt * dimension2);
        this.jKH = (int) (this.jKt * dimension3);
    }
}
