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
/* loaded from: classes20.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float bZG;
    protected float lGB;
    protected Drawable lGE;
    protected Drawable lGF;
    protected int lGG;
    protected int lGH;
    protected int lGI;
    protected int lGJ;
    protected int lGK;
    protected int lGL;
    protected int lGM;
    protected int lGN;
    protected float lGO;
    protected float lGP;
    protected int lGQ;
    protected int lGR;
    protected int lGS;
    protected int lGT;
    protected View lGU;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.lGE = null;
        this.lGF = null;
        this.lGG = 0;
        this.lGH = 0;
        this.lGI = 0;
        this.lGJ = 0;
        this.lGK = 0;
        this.lGL = 0;
        this.lGM = 0;
        this.lGN = 0;
        this.bZG = 0.0f;
        this.lGO = 0.0f;
        this.lGP = 0.0f;
        this.lGQ = 0;
        this.lGR = 0;
        this.lGS = 0;
        this.lGT = 0;
        this.lGU = null;
        this.mTag = "";
        this.mActivity = null;
        this.lGB = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.lGE = null;
        this.lGF = null;
        this.lGG = 0;
        this.lGH = 0;
        this.lGI = 0;
        this.lGJ = 0;
        this.lGK = 0;
        this.lGL = 0;
        this.lGM = 0;
        this.lGN = 0;
        this.bZG = 0.0f;
        this.lGO = 0.0f;
        this.lGP = 0.0f;
        this.lGQ = 0;
        this.lGR = 0;
        this.lGS = 0;
        this.lGT = 0;
        this.lGU = null;
        this.mTag = "";
        this.mActivity = null;
        this.lGB = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.lGE = null;
        this.lGF = null;
        this.lGG = 0;
        this.lGH = 0;
        this.lGI = 0;
        this.lGJ = 0;
        this.lGK = 0;
        this.lGL = 0;
        this.lGM = 0;
        this.lGN = 0;
        this.bZG = 0.0f;
        this.lGO = 0.0f;
        this.lGP = 0.0f;
        this.lGQ = 0;
        this.lGR = 0;
        this.lGS = 0;
        this.lGT = 0;
        this.lGU = null;
        this.mTag = "";
        this.mActivity = null;
        this.lGB = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.lGN = this.mResources.getColor(R.color.form_font_color);
        this.lGQ = this.mResources.getColor(R.color.form_button_font_color);
        this.lGS = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.lGR = -1;
        this.lGT = -1;
        this.lGM = -1;
        this.lGE = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.lGF = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.lGU = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.lGU.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.lGU.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.lGU.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.lGU;
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
    public int dnU() {
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

    public void aC(float f) {
        this.lGB = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.lGG = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.lGB);
        this.lGH = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.lGB);
        this.lGI = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.lGB);
        this.lGJ = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.lGB);
        this.lGK = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.lGB);
        this.lGL = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.lGB);
        this.bZG = (int) (this.lGB * dimension);
        this.lGO = (int) (this.lGB * dimension2);
        this.lGP = (int) (this.lGB * dimension3);
    }
}
