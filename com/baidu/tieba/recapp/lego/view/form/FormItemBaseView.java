package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected Drawable gsA;
    protected Drawable gsB;
    protected int gsC;
    protected int gsD;
    protected int gsE;
    protected int gsF;
    protected int gsG;
    protected int gsH;
    protected int gsI;
    protected int gsJ;
    protected float gsK;
    protected float gsL;
    protected float gsM;
    protected int gsN;
    protected int gsO;
    protected int gsP;
    protected int gsQ;
    protected View gsR;
    protected float gsx;
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
        this.gsA = null;
        this.gsB = null;
        this.gsC = 0;
        this.gsD = 0;
        this.gsE = 0;
        this.gsF = 0;
        this.gsG = 0;
        this.gsH = 0;
        this.gsI = 0;
        this.gsJ = 0;
        this.gsK = 0.0f;
        this.gsL = 0.0f;
        this.gsM = 0.0f;
        this.gsN = 0;
        this.gsO = 0;
        this.gsP = 0;
        this.gsQ = 0;
        this.gsR = null;
        this.mTag = "";
        this.mActivity = null;
        this.gsx = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gsA = null;
        this.gsB = null;
        this.gsC = 0;
        this.gsD = 0;
        this.gsE = 0;
        this.gsF = 0;
        this.gsG = 0;
        this.gsH = 0;
        this.gsI = 0;
        this.gsJ = 0;
        this.gsK = 0.0f;
        this.gsL = 0.0f;
        this.gsM = 0.0f;
        this.gsN = 0;
        this.gsO = 0;
        this.gsP = 0;
        this.gsQ = 0;
        this.gsR = null;
        this.mTag = "";
        this.mActivity = null;
        this.gsx = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gsA = null;
        this.gsB = null;
        this.gsC = 0;
        this.gsD = 0;
        this.gsE = 0;
        this.gsF = 0;
        this.gsG = 0;
        this.gsH = 0;
        this.gsI = 0;
        this.gsJ = 0;
        this.gsK = 0.0f;
        this.gsL = 0.0f;
        this.gsM = 0.0f;
        this.gsN = 0;
        this.gsO = 0;
        this.gsP = 0;
        this.gsQ = 0;
        this.gsR = null;
        this.mTag = "";
        this.mActivity = null;
        this.gsx = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gsJ = this.mResources.getColor(d.C0140d.form_font_color);
        this.gsN = this.mResources.getColor(d.C0140d.form_button_font_color);
        this.gsP = this.mResources.getColor(d.C0140d.form_button_grey_bg_color);
        this.gsO = -1;
        this.gsQ = -1;
        this.gsI = -1;
        this.gsA = this.mResources.getDrawable(d.f.form_frame_white);
        this.gsB = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gsR = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gsR.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gsR.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.gsR.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gsR;
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
    public int bnX() {
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
        this.gsx = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.gsC = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.gsx);
        this.gsD = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.gsx);
        this.gsE = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.gsx);
        this.gsF = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.gsx);
        this.gsG = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.gsx);
        this.gsH = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.gsx);
        this.gsK = (int) (this.gsx * dimension);
        this.gsL = (int) (this.gsx * dimension2);
        this.gsM = (int) (this.gsx * dimension3);
    }
}
