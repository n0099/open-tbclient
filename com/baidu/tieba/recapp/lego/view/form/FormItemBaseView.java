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
/* loaded from: classes26.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float cnX;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;
    protected float meN;
    protected Drawable meQ;
    protected Drawable meR;
    protected int meS;
    protected int meT;
    protected int meU;
    protected int meV;
    protected int meW;
    protected int meX;
    protected int meY;
    protected int meZ;
    protected float mfa;
    protected float mfb;
    protected int mfc;
    protected int mfd;
    protected int mfe;
    protected int mff;
    protected View mfg;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes26.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.meQ = null;
        this.meR = null;
        this.meS = 0;
        this.meT = 0;
        this.meU = 0;
        this.meV = 0;
        this.meW = 0;
        this.meX = 0;
        this.meY = 0;
        this.meZ = 0;
        this.cnX = 0.0f;
        this.mfa = 0.0f;
        this.mfb = 0.0f;
        this.mfc = 0;
        this.mfd = 0;
        this.mfe = 0;
        this.mff = 0;
        this.mfg = null;
        this.mTag = "";
        this.mActivity = null;
        this.meN = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.meQ = null;
        this.meR = null;
        this.meS = 0;
        this.meT = 0;
        this.meU = 0;
        this.meV = 0;
        this.meW = 0;
        this.meX = 0;
        this.meY = 0;
        this.meZ = 0;
        this.cnX = 0.0f;
        this.mfa = 0.0f;
        this.mfb = 0.0f;
        this.mfc = 0;
        this.mfd = 0;
        this.mfe = 0;
        this.mff = 0;
        this.mfg = null;
        this.mTag = "";
        this.mActivity = null;
        this.meN = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.meQ = null;
        this.meR = null;
        this.meS = 0;
        this.meT = 0;
        this.meU = 0;
        this.meV = 0;
        this.meW = 0;
        this.meX = 0;
        this.meY = 0;
        this.meZ = 0;
        this.cnX = 0.0f;
        this.mfa = 0.0f;
        this.mfb = 0.0f;
        this.mfc = 0;
        this.mfd = 0;
        this.mfe = 0;
        this.mff = 0;
        this.mfg = null;
        this.mTag = "";
        this.mActivity = null;
        this.meN = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.meZ = this.mResources.getColor(R.color.form_font_color);
        this.mfc = this.mResources.getColor(R.color.form_button_font_color);
        this.mfe = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mfd = -1;
        this.mff = -1;
        this.meY = -1;
        this.meQ = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.meR = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mfg = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mfg.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mfg.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mfg.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mfg;
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
    public int dvo() {
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

    public void aI(float f) {
        this.meN = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.meS = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.meN);
        this.meT = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.meN);
        this.meU = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.meN);
        this.meV = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.meN);
        this.meW = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.meN);
        this.meX = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.meN);
        this.cnX = (int) (this.meN * dimension);
        this.mfa = (int) (this.meN * dimension2);
        this.mfb = (int) (this.meN * dimension3);
    }
}
