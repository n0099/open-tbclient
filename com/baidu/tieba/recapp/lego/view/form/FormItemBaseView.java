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
/* loaded from: classes11.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float bcC;
    protected Drawable jJA;
    protected Drawable jJB;
    protected int jJC;
    protected int jJD;
    protected int jJE;
    protected int jJF;
    protected int jJG;
    protected int jJH;
    protected int jJI;
    protected int jJJ;
    protected float jJK;
    protected float jJL;
    protected int jJM;
    protected int jJN;
    protected int jJO;
    protected int jJP;
    protected View jJQ;
    protected float jJx;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.jJA = null;
        this.jJB = null;
        this.jJC = 0;
        this.jJD = 0;
        this.jJE = 0;
        this.jJF = 0;
        this.jJG = 0;
        this.jJH = 0;
        this.jJI = 0;
        this.jJJ = 0;
        this.bcC = 0.0f;
        this.jJK = 0.0f;
        this.jJL = 0.0f;
        this.jJM = 0;
        this.jJN = 0;
        this.jJO = 0;
        this.jJP = 0;
        this.jJQ = null;
        this.mTag = "";
        this.mActivity = null;
        this.jJx = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.jJA = null;
        this.jJB = null;
        this.jJC = 0;
        this.jJD = 0;
        this.jJE = 0;
        this.jJF = 0;
        this.jJG = 0;
        this.jJH = 0;
        this.jJI = 0;
        this.jJJ = 0;
        this.bcC = 0.0f;
        this.jJK = 0.0f;
        this.jJL = 0.0f;
        this.jJM = 0;
        this.jJN = 0;
        this.jJO = 0;
        this.jJP = 0;
        this.jJQ = null;
        this.mTag = "";
        this.mActivity = null;
        this.jJx = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.jJA = null;
        this.jJB = null;
        this.jJC = 0;
        this.jJD = 0;
        this.jJE = 0;
        this.jJF = 0;
        this.jJG = 0;
        this.jJH = 0;
        this.jJI = 0;
        this.jJJ = 0;
        this.bcC = 0.0f;
        this.jJK = 0.0f;
        this.jJL = 0.0f;
        this.jJM = 0;
        this.jJN = 0;
        this.jJO = 0;
        this.jJP = 0;
        this.jJQ = null;
        this.mTag = "";
        this.mActivity = null;
        this.jJx = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.jJJ = this.mResources.getColor(R.color.form_font_color);
        this.jJM = this.mResources.getColor(R.color.form_button_font_color);
        this.jJO = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.jJN = -1;
        this.jJP = -1;
        this.jJI = -1;
        this.jJA = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.jJB = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.jJQ = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.jJQ.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.jJQ.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.jJQ.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.jJQ;
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
    public int cBI() {
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

    public void aK(float f) {
        this.jJx = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.jJC = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.jJx);
        this.jJD = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.jJx);
        this.jJE = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.jJx);
        this.jJF = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.jJx);
        this.jJG = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.jJx);
        this.jJH = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.jJx);
        this.bcC = (int) (this.jJx * dimension);
        this.jJK = (int) (this.jJx * dimension2);
        this.jJL = (int) (this.jJx * dimension3);
    }
}
