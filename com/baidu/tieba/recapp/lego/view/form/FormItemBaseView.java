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
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float aGd;
    protected float iLB;
    protected Drawable iLE;
    protected Drawable iLF;
    protected int iLG;
    protected int iLH;
    protected int iLI;
    protected int iLJ;
    protected int iLK;
    protected int iLL;
    protected int iLM;
    protected int iLN;
    protected float iLO;
    protected float iLP;
    protected int iLQ;
    protected int iLR;
    protected int iLS;
    protected int iLT;
    protected View iLU;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* loaded from: classes3.dex */
    protected enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.iLE = null;
        this.iLF = null;
        this.iLG = 0;
        this.iLH = 0;
        this.iLI = 0;
        this.iLJ = 0;
        this.iLK = 0;
        this.iLL = 0;
        this.iLM = 0;
        this.iLN = 0;
        this.aGd = 0.0f;
        this.iLO = 0.0f;
        this.iLP = 0.0f;
        this.iLQ = 0;
        this.iLR = 0;
        this.iLS = 0;
        this.iLT = 0;
        this.iLU = null;
        this.mTag = "";
        this.mActivity = null;
        this.iLB = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.iLE = null;
        this.iLF = null;
        this.iLG = 0;
        this.iLH = 0;
        this.iLI = 0;
        this.iLJ = 0;
        this.iLK = 0;
        this.iLL = 0;
        this.iLM = 0;
        this.iLN = 0;
        this.aGd = 0.0f;
        this.iLO = 0.0f;
        this.iLP = 0.0f;
        this.iLQ = 0;
        this.iLR = 0;
        this.iLS = 0;
        this.iLT = 0;
        this.iLU = null;
        this.mTag = "";
        this.mActivity = null;
        this.iLB = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.iLE = null;
        this.iLF = null;
        this.iLG = 0;
        this.iLH = 0;
        this.iLI = 0;
        this.iLJ = 0;
        this.iLK = 0;
        this.iLL = 0;
        this.iLM = 0;
        this.iLN = 0;
        this.aGd = 0.0f;
        this.iLO = 0.0f;
        this.iLP = 0.0f;
        this.iLQ = 0;
        this.iLR = 0;
        this.iLS = 0;
        this.iLT = 0;
        this.iLU = null;
        this.mTag = "";
        this.mActivity = null;
        this.iLB = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.iLN = this.mResources.getColor(R.color.form_font_color);
        this.iLQ = this.mResources.getColor(R.color.form_button_font_color);
        this.iLS = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.iLR = -1;
        this.iLT = -1;
        this.iLM = -1;
        this.iLE = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.iLF = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.iLU = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.iLU.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.iLU.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.iLU.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.iLU;
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
    public int cgv() {
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

    public void au(float f) {
        this.iLB = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.iLG = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.iLB);
        this.iLH = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.iLB);
        this.iLI = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.iLB);
        this.iLJ = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.iLB);
        this.iLK = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.iLB);
        this.iLL = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.iLB);
        this.aGd = (int) (this.iLB * dimension);
        this.iLO = (int) (this.iLB * dimension2);
        this.iLP = (int) (this.iLB * dimension3);
    }
}
