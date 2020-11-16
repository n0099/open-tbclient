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
    protected float cAJ;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;
    protected Drawable mxA;
    protected int mxB;
    protected int mxC;
    protected int mxD;
    protected int mxE;
    protected int mxF;
    protected int mxG;
    protected int mxH;
    protected int mxI;
    protected float mxJ;
    protected float mxK;
    protected int mxL;
    protected int mxM;
    protected int mxN;
    protected int mxO;
    protected View mxP;
    protected float mxw;
    protected Drawable mxz;

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
        this.mxz = null;
        this.mxA = null;
        this.mxB = 0;
        this.mxC = 0;
        this.mxD = 0;
        this.mxE = 0;
        this.mxF = 0;
        this.mxG = 0;
        this.mxH = 0;
        this.mxI = 0;
        this.cAJ = 0.0f;
        this.mxJ = 0.0f;
        this.mxK = 0.0f;
        this.mxL = 0;
        this.mxM = 0;
        this.mxN = 0;
        this.mxO = 0;
        this.mxP = null;
        this.mTag = "";
        this.mActivity = null;
        this.mxw = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mxz = null;
        this.mxA = null;
        this.mxB = 0;
        this.mxC = 0;
        this.mxD = 0;
        this.mxE = 0;
        this.mxF = 0;
        this.mxG = 0;
        this.mxH = 0;
        this.mxI = 0;
        this.cAJ = 0.0f;
        this.mxJ = 0.0f;
        this.mxK = 0.0f;
        this.mxL = 0;
        this.mxM = 0;
        this.mxN = 0;
        this.mxO = 0;
        this.mxP = null;
        this.mTag = "";
        this.mActivity = null;
        this.mxw = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mxz = null;
        this.mxA = null;
        this.mxB = 0;
        this.mxC = 0;
        this.mxD = 0;
        this.mxE = 0;
        this.mxF = 0;
        this.mxG = 0;
        this.mxH = 0;
        this.mxI = 0;
        this.cAJ = 0.0f;
        this.mxJ = 0.0f;
        this.mxK = 0.0f;
        this.mxL = 0;
        this.mxM = 0;
        this.mxN = 0;
        this.mxO = 0;
        this.mxP = null;
        this.mTag = "";
        this.mActivity = null;
        this.mxw = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mxI = this.mResources.getColor(R.color.form_font_color);
        this.mxL = this.mResources.getColor(R.color.form_button_font_color);
        this.mxN = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mxM = -1;
        this.mxO = -1;
        this.mxH = -1;
        this.mxz = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mxA = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mxP = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mxP.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mxP.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mxP.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mxP;
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
    public int dAu() {
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

    public void aT(float f) {
        this.mxw = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mxB = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mxw);
        this.mxC = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mxw);
        this.mxD = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mxw);
        this.mxE = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mxw);
        this.mxF = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mxw);
        this.mxG = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mxw);
        this.cAJ = (int) (this.mxw * dimension);
        this.mxJ = (int) (this.mxw * dimension2);
        this.mxK = (int) (this.mxw * dimension3);
    }
}
