package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.f;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float gsA;
    protected Drawable gsD;
    protected Drawable gsE;
    protected int gsF;
    protected int gsG;
    protected int gsH;
    protected int gsI;
    protected int gsJ;
    protected int gsK;
    protected int gsL;
    protected int gsM;
    protected float gsN;
    protected float gsO;
    protected float gsP;
    protected int gsQ;
    protected int gsR;
    protected int gsS;
    protected int gsT;
    protected View gsU;
    protected Activity mActivity;
    protected Context mContext;
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
        this.gsD = null;
        this.gsE = null;
        this.gsF = 0;
        this.gsG = 0;
        this.gsH = 0;
        this.gsI = 0;
        this.gsJ = 0;
        this.gsK = 0;
        this.gsL = 0;
        this.gsM = 0;
        this.gsN = 0.0f;
        this.gsO = 0.0f;
        this.gsP = 0.0f;
        this.gsQ = 0;
        this.gsR = 0;
        this.gsS = 0;
        this.gsT = 0;
        this.gsU = null;
        this.mTag = "";
        this.mActivity = null;
        this.gsA = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gsD = null;
        this.gsE = null;
        this.gsF = 0;
        this.gsG = 0;
        this.gsH = 0;
        this.gsI = 0;
        this.gsJ = 0;
        this.gsK = 0;
        this.gsL = 0;
        this.gsM = 0;
        this.gsN = 0.0f;
        this.gsO = 0.0f;
        this.gsP = 0.0f;
        this.gsQ = 0;
        this.gsR = 0;
        this.gsS = 0;
        this.gsT = 0;
        this.gsU = null;
        this.mTag = "";
        this.mActivity = null;
        this.gsA = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gsD = null;
        this.gsE = null;
        this.gsF = 0;
        this.gsG = 0;
        this.gsH = 0;
        this.gsI = 0;
        this.gsJ = 0;
        this.gsK = 0;
        this.gsL = 0;
        this.gsM = 0;
        this.gsN = 0.0f;
        this.gsO = 0.0f;
        this.gsP = 0.0f;
        this.gsQ = 0;
        this.gsR = 0;
        this.gsS = 0;
        this.gsT = 0;
        this.gsU = null;
        this.mTag = "";
        this.mActivity = null;
        this.gsA = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gsM = this.mResources.getColor(f.d.form_font_color);
        this.gsQ = this.mResources.getColor(f.d.form_button_font_color);
        this.gsS = this.mResources.getColor(f.d.form_button_grey_bg_color);
        this.gsR = -1;
        this.gsT = -1;
        this.gsL = -1;
        this.gsD = this.mResources.getDrawable(f.C0146f.form_frame_white);
        this.gsE = this.mResources.getDrawable(f.C0146f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gsU = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gsU.setBackgroundResource(f.C0146f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gsU.setBackgroundResource(f.C0146f.form_frame_white);
                return;
            default:
                this.gsU.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gsU;
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
    public int bnY() {
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

    public void aB(float f) {
        this.gsA = f;
        float dimension = this.mResources.getDimension(f.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(f.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(f.e.form_font_size36);
        this.gsF = (int) (((int) this.mResources.getDimension(f.e.form_size20)) * this.gsA);
        this.gsG = (int) (((int) this.mResources.getDimension(f.e.form_size40)) * this.gsA);
        this.gsH = (int) (((int) this.mResources.getDimension(f.e.form_size50)) * this.gsA);
        this.gsI = (int) (((int) this.mResources.getDimension(f.e.form_size80)) * this.gsA);
        this.gsJ = (int) (((int) this.mResources.getDimension(f.e.form_size90)) * this.gsA);
        this.gsK = (int) (((int) this.mResources.getDimension(f.e.form_size240)) * this.gsA);
        this.gsN = (int) (this.gsA * dimension);
        this.gsO = (int) (this.gsA * dimension2);
        this.gsP = (int) (this.gsA * dimension3);
    }
}
