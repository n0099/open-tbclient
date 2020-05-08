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
    protected float bFw;
    protected float kvD;
    protected Drawable kvG;
    protected Drawable kvH;
    protected int kvI;
    protected int kvJ;
    protected int kvK;
    protected int kvL;
    protected int kvM;
    protected int kvN;
    protected int kvO;
    protected int kvP;
    protected float kvQ;
    protected float kvR;
    protected int kvS;
    protected int kvT;
    protected int kvU;
    protected int kvV;
    protected View kvW;
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
        this.kvG = null;
        this.kvH = null;
        this.kvI = 0;
        this.kvJ = 0;
        this.kvK = 0;
        this.kvL = 0;
        this.kvM = 0;
        this.kvN = 0;
        this.kvO = 0;
        this.kvP = 0;
        this.bFw = 0.0f;
        this.kvQ = 0.0f;
        this.kvR = 0.0f;
        this.kvS = 0;
        this.kvT = 0;
        this.kvU = 0;
        this.kvV = 0;
        this.kvW = null;
        this.mTag = "";
        this.mActivity = null;
        this.kvD = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.kvG = null;
        this.kvH = null;
        this.kvI = 0;
        this.kvJ = 0;
        this.kvK = 0;
        this.kvL = 0;
        this.kvM = 0;
        this.kvN = 0;
        this.kvO = 0;
        this.kvP = 0;
        this.bFw = 0.0f;
        this.kvQ = 0.0f;
        this.kvR = 0.0f;
        this.kvS = 0;
        this.kvT = 0;
        this.kvU = 0;
        this.kvV = 0;
        this.kvW = null;
        this.mTag = "";
        this.mActivity = null;
        this.kvD = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.kvG = null;
        this.kvH = null;
        this.kvI = 0;
        this.kvJ = 0;
        this.kvK = 0;
        this.kvL = 0;
        this.kvM = 0;
        this.kvN = 0;
        this.kvO = 0;
        this.kvP = 0;
        this.bFw = 0.0f;
        this.kvQ = 0.0f;
        this.kvR = 0.0f;
        this.kvS = 0;
        this.kvT = 0;
        this.kvU = 0;
        this.kvV = 0;
        this.kvW = null;
        this.mTag = "";
        this.mActivity = null;
        this.kvD = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.kvP = this.mResources.getColor(R.color.form_font_color);
        this.kvS = this.mResources.getColor(R.color.form_button_font_color);
        this.kvU = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.kvT = -1;
        this.kvV = -1;
        this.kvO = -1;
        this.kvG = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.kvH = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.kvW = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.kvW.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.kvW.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.kvW.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.kvW;
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
    public int cNT() {
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

    public void at(float f) {
        this.kvD = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.kvI = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.kvD);
        this.kvJ = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.kvD);
        this.kvK = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.kvD);
        this.kvL = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.kvD);
        this.kvM = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.kvD);
        this.kvN = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.kvD);
        this.bFw = (int) (this.kvD * dimension);
        this.kvQ = (int) (this.kvD * dimension2);
        this.kvR = (int) (this.kvD * dimension3);
    }
}
