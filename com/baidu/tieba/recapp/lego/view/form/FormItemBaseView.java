package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float gSE;
    protected Drawable gSH;
    protected Drawable gSI;
    protected int gSJ;
    protected int gSK;
    protected int gSL;
    protected int gSM;
    protected int gSN;
    protected int gSO;
    protected int gSP;
    protected int gSQ;
    protected float gSR;
    protected float gSS;
    protected int gST;
    protected int gSU;
    protected int gSV;
    protected int gSW;
    protected View gSX;
    protected Activity mActivity;
    protected Context mContext;
    protected float mFontSize;
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
        this.gSH = null;
        this.gSI = null;
        this.gSJ = 0;
        this.gSK = 0;
        this.gSL = 0;
        this.gSM = 0;
        this.gSN = 0;
        this.gSO = 0;
        this.gSP = 0;
        this.gSQ = 0;
        this.mFontSize = 0.0f;
        this.gSR = 0.0f;
        this.gSS = 0.0f;
        this.gST = 0;
        this.gSU = 0;
        this.gSV = 0;
        this.gSW = 0;
        this.gSX = null;
        this.mTag = "";
        this.mActivity = null;
        this.gSE = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gSH = null;
        this.gSI = null;
        this.gSJ = 0;
        this.gSK = 0;
        this.gSL = 0;
        this.gSM = 0;
        this.gSN = 0;
        this.gSO = 0;
        this.gSP = 0;
        this.gSQ = 0;
        this.mFontSize = 0.0f;
        this.gSR = 0.0f;
        this.gSS = 0.0f;
        this.gST = 0;
        this.gSU = 0;
        this.gSV = 0;
        this.gSW = 0;
        this.gSX = null;
        this.mTag = "";
        this.mActivity = null;
        this.gSE = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gSH = null;
        this.gSI = null;
        this.gSJ = 0;
        this.gSK = 0;
        this.gSL = 0;
        this.gSM = 0;
        this.gSN = 0;
        this.gSO = 0;
        this.gSP = 0;
        this.gSQ = 0;
        this.mFontSize = 0.0f;
        this.gSR = 0.0f;
        this.gSS = 0.0f;
        this.gST = 0;
        this.gSU = 0;
        this.gSV = 0;
        this.gSW = 0;
        this.gSX = null;
        this.mTag = "";
        this.mActivity = null;
        this.gSE = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gSQ = this.mResources.getColor(e.d.form_font_color);
        this.gST = this.mResources.getColor(e.d.form_button_font_color);
        this.gSV = this.mResources.getColor(e.d.form_button_grey_bg_color);
        this.gSU = -1;
        this.gSW = -1;
        this.gSP = -1;
        this.gSH = this.mResources.getDrawable(e.f.form_frame_white);
        this.gSI = this.mResources.getDrawable(e.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gSX = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gSX.setBackgroundResource(e.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gSX.setBackgroundResource(e.f.form_frame_white);
                return;
            default:
                this.gSX.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gSX;
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
    public int bvU() {
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

    public void ay(float f) {
        this.gSE = f;
        float dimension = this.mResources.getDimension(e.C0210e.form_font_size28);
        float dimension2 = this.mResources.getDimension(e.C0210e.form_font_size20);
        float dimension3 = this.mResources.getDimension(e.C0210e.form_font_size36);
        this.gSJ = (int) (((int) this.mResources.getDimension(e.C0210e.form_size20)) * this.gSE);
        this.gSK = (int) (((int) this.mResources.getDimension(e.C0210e.form_size40)) * this.gSE);
        this.gSL = (int) (((int) this.mResources.getDimension(e.C0210e.form_size50)) * this.gSE);
        this.gSM = (int) (((int) this.mResources.getDimension(e.C0210e.form_size80)) * this.gSE);
        this.gSN = (int) (((int) this.mResources.getDimension(e.C0210e.form_size90)) * this.gSE);
        this.gSO = (int) (((int) this.mResources.getDimension(e.C0210e.form_size240)) * this.gSE);
        this.mFontSize = (int) (this.gSE * dimension);
        this.gSR = (int) (this.gSE * dimension2);
        this.gSS = (int) (this.gSE * dimension3);
    }
}
