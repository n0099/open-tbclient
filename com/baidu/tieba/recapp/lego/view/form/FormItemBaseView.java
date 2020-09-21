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
/* loaded from: classes25.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float cbH;
    protected int lPA;
    protected int lPB;
    protected int lPC;
    protected int lPD;
    protected int lPE;
    protected int lPF;
    protected int lPG;
    protected int lPH;
    protected float lPI;
    protected float lPJ;
    protected int lPK;
    protected int lPL;
    protected int lPM;
    protected int lPN;
    protected View lPO;
    protected float lPv;
    protected Drawable lPy;
    protected Drawable lPz;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes25.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.lPy = null;
        this.lPz = null;
        this.lPA = 0;
        this.lPB = 0;
        this.lPC = 0;
        this.lPD = 0;
        this.lPE = 0;
        this.lPF = 0;
        this.lPG = 0;
        this.lPH = 0;
        this.cbH = 0.0f;
        this.lPI = 0.0f;
        this.lPJ = 0.0f;
        this.lPK = 0;
        this.lPL = 0;
        this.lPM = 0;
        this.lPN = 0;
        this.lPO = null;
        this.mTag = "";
        this.mActivity = null;
        this.lPv = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.lPy = null;
        this.lPz = null;
        this.lPA = 0;
        this.lPB = 0;
        this.lPC = 0;
        this.lPD = 0;
        this.lPE = 0;
        this.lPF = 0;
        this.lPG = 0;
        this.lPH = 0;
        this.cbH = 0.0f;
        this.lPI = 0.0f;
        this.lPJ = 0.0f;
        this.lPK = 0;
        this.lPL = 0;
        this.lPM = 0;
        this.lPN = 0;
        this.lPO = null;
        this.mTag = "";
        this.mActivity = null;
        this.lPv = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.lPy = null;
        this.lPz = null;
        this.lPA = 0;
        this.lPB = 0;
        this.lPC = 0;
        this.lPD = 0;
        this.lPE = 0;
        this.lPF = 0;
        this.lPG = 0;
        this.lPH = 0;
        this.cbH = 0.0f;
        this.lPI = 0.0f;
        this.lPJ = 0.0f;
        this.lPK = 0;
        this.lPL = 0;
        this.lPM = 0;
        this.lPN = 0;
        this.lPO = null;
        this.mTag = "";
        this.mActivity = null;
        this.lPv = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.lPH = this.mResources.getColor(R.color.form_font_color);
        this.lPK = this.mResources.getColor(R.color.form_button_font_color);
        this.lPM = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.lPL = -1;
        this.lPN = -1;
        this.lPG = -1;
        this.lPy = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.lPz = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.lPO = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.lPO.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.lPO.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.lPO.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.lPO;
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
    public int drD() {
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
        this.lPv = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.lPA = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.lPv);
        this.lPB = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.lPv);
        this.lPC = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.lPv);
        this.lPD = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.lPv);
        this.lPE = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.lPv);
        this.lPF = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.lPv);
        this.cbH = (int) (this.lPv * dimension);
        this.lPI = (int) (this.lPv * dimension2);
        this.lPJ = (int) (this.lPv * dimension3);
    }
}
