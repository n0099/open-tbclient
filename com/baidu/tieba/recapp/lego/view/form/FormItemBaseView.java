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
    protected float kOF;
    protected Drawable kOI;
    protected Drawable kOJ;
    protected int kOK;
    protected int kOL;
    protected int kOM;
    protected int kON;
    protected int kOO;
    protected int kOP;
    protected int kOQ;
    protected int kOR;
    protected float kOS;
    protected float kOT;
    protected int kOU;
    protected int kOV;
    protected int kOW;
    protected int kOX;
    protected View kOY;
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
        this.kOI = null;
        this.kOJ = null;
        this.kOK = 0;
        this.kOL = 0;
        this.kOM = 0;
        this.kON = 0;
        this.kOO = 0;
        this.kOP = 0;
        this.kOQ = 0;
        this.kOR = 0;
        this.bOo = 0.0f;
        this.kOS = 0.0f;
        this.kOT = 0.0f;
        this.kOU = 0;
        this.kOV = 0;
        this.kOW = 0;
        this.kOX = 0;
        this.kOY = null;
        this.mTag = "";
        this.mActivity = null;
        this.kOF = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.kOI = null;
        this.kOJ = null;
        this.kOK = 0;
        this.kOL = 0;
        this.kOM = 0;
        this.kON = 0;
        this.kOO = 0;
        this.kOP = 0;
        this.kOQ = 0;
        this.kOR = 0;
        this.bOo = 0.0f;
        this.kOS = 0.0f;
        this.kOT = 0.0f;
        this.kOU = 0;
        this.kOV = 0;
        this.kOW = 0;
        this.kOX = 0;
        this.kOY = null;
        this.mTag = "";
        this.mActivity = null;
        this.kOF = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.kOI = null;
        this.kOJ = null;
        this.kOK = 0;
        this.kOL = 0;
        this.kOM = 0;
        this.kON = 0;
        this.kOO = 0;
        this.kOP = 0;
        this.kOQ = 0;
        this.kOR = 0;
        this.bOo = 0.0f;
        this.kOS = 0.0f;
        this.kOT = 0.0f;
        this.kOU = 0;
        this.kOV = 0;
        this.kOW = 0;
        this.kOX = 0;
        this.kOY = null;
        this.mTag = "";
        this.mActivity = null;
        this.kOF = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.kOR = this.mResources.getColor(R.color.form_font_color);
        this.kOU = this.mResources.getColor(R.color.form_button_font_color);
        this.kOW = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.kOV = -1;
        this.kOX = -1;
        this.kOQ = -1;
        this.kOI = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.kOJ = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.kOY = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.kOY.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.kOY.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.kOY.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.kOY;
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
    public int cVk() {
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
        this.kOF = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.kOK = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.kOF);
        this.kOL = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.kOF);
        this.kOM = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.kOF);
        this.kON = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.kOF);
        this.kOO = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.kOF);
        this.kOP = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.kOF);
        this.bOo = (int) (this.kOF * dimension);
        this.kOS = (int) (this.kOF * dimension2);
        this.kOT = (int) (this.kOF * dimension3);
    }
}
