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
    protected int jJA;
    protected int jJB;
    protected int jJC;
    protected int jJD;
    protected int jJE;
    protected float jJF;
    protected float jJG;
    protected int jJH;
    protected int jJI;
    protected int jJJ;
    protected int jJK;
    protected View jJL;
    protected float jJs;
    protected Drawable jJv;
    protected Drawable jJw;
    protected int jJx;
    protected int jJy;
    protected int jJz;
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
        this.jJv = null;
        this.jJw = null;
        this.jJx = 0;
        this.jJy = 0;
        this.jJz = 0;
        this.jJA = 0;
        this.jJB = 0;
        this.jJC = 0;
        this.jJD = 0;
        this.jJE = 0;
        this.bcC = 0.0f;
        this.jJF = 0.0f;
        this.jJG = 0.0f;
        this.jJH = 0;
        this.jJI = 0;
        this.jJJ = 0;
        this.jJK = 0;
        this.jJL = null;
        this.mTag = "";
        this.mActivity = null;
        this.jJs = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.jJv = null;
        this.jJw = null;
        this.jJx = 0;
        this.jJy = 0;
        this.jJz = 0;
        this.jJA = 0;
        this.jJB = 0;
        this.jJC = 0;
        this.jJD = 0;
        this.jJE = 0;
        this.bcC = 0.0f;
        this.jJF = 0.0f;
        this.jJG = 0.0f;
        this.jJH = 0;
        this.jJI = 0;
        this.jJJ = 0;
        this.jJK = 0;
        this.jJL = null;
        this.mTag = "";
        this.mActivity = null;
        this.jJs = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.jJv = null;
        this.jJw = null;
        this.jJx = 0;
        this.jJy = 0;
        this.jJz = 0;
        this.jJA = 0;
        this.jJB = 0;
        this.jJC = 0;
        this.jJD = 0;
        this.jJE = 0;
        this.bcC = 0.0f;
        this.jJF = 0.0f;
        this.jJG = 0.0f;
        this.jJH = 0;
        this.jJI = 0;
        this.jJJ = 0;
        this.jJK = 0;
        this.jJL = null;
        this.mTag = "";
        this.mActivity = null;
        this.jJs = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.jJE = this.mResources.getColor(R.color.form_font_color);
        this.jJH = this.mResources.getColor(R.color.form_button_font_color);
        this.jJJ = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.jJI = -1;
        this.jJK = -1;
        this.jJD = -1;
        this.jJv = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.jJw = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.jJL = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.jJL.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.jJL.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.jJL.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.jJL;
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
    public int cBG() {
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
        this.jJs = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.jJx = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.jJs);
        this.jJy = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.jJs);
        this.jJz = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.jJs);
        this.jJA = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.jJs);
        this.jJB = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.jJs);
        this.jJC = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.jJs);
        this.bcC = (int) (this.jJs * dimension);
        this.jJF = (int) (this.jJs * dimension2);
        this.jJG = (int) (this.jJs * dimension3);
    }
}
