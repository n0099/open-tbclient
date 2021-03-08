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
/* loaded from: classes7.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float cLA;
    protected Activity mActivity;
    protected int mButtonFontColor;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;
    protected float mYA;
    protected int mYB;
    protected int mYC;
    protected int mYD;
    protected View mYE;
    protected float mYm;
    protected Drawable mYp;
    protected Drawable mYq;
    protected int mYr;
    protected int mYs;
    protected int mYt;
    protected int mYu;
    protected int mYv;
    protected int mYw;
    protected int mYx;
    protected int mYy;
    protected float mYz;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes7.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.mYp = null;
        this.mYq = null;
        this.mYr = 0;
        this.mYs = 0;
        this.mYt = 0;
        this.mYu = 0;
        this.mYv = 0;
        this.mYw = 0;
        this.mYx = 0;
        this.mYy = 0;
        this.cLA = 0.0f;
        this.mYz = 0.0f;
        this.mYA = 0.0f;
        this.mButtonFontColor = 0;
        this.mYB = 0;
        this.mYC = 0;
        this.mYD = 0;
        this.mYE = null;
        this.mTag = "";
        this.mActivity = null;
        this.mYm = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mYp = null;
        this.mYq = null;
        this.mYr = 0;
        this.mYs = 0;
        this.mYt = 0;
        this.mYu = 0;
        this.mYv = 0;
        this.mYw = 0;
        this.mYx = 0;
        this.mYy = 0;
        this.cLA = 0.0f;
        this.mYz = 0.0f;
        this.mYA = 0.0f;
        this.mButtonFontColor = 0;
        this.mYB = 0;
        this.mYC = 0;
        this.mYD = 0;
        this.mYE = null;
        this.mTag = "";
        this.mActivity = null;
        this.mYm = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mYp = null;
        this.mYq = null;
        this.mYr = 0;
        this.mYs = 0;
        this.mYt = 0;
        this.mYu = 0;
        this.mYv = 0;
        this.mYw = 0;
        this.mYx = 0;
        this.mYy = 0;
        this.cLA = 0.0f;
        this.mYz = 0.0f;
        this.mYA = 0.0f;
        this.mButtonFontColor = 0;
        this.mYB = 0;
        this.mYC = 0;
        this.mYD = 0;
        this.mYE = null;
        this.mTag = "";
        this.mActivity = null;
        this.mYm = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mYy = this.mResources.getColor(R.color.form_font_color);
        this.mButtonFontColor = this.mResources.getColor(R.color.form_button_font_color);
        this.mYC = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mYB = -1;
        this.mYD = -1;
        this.mYx = -1;
        this.mYp = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mYq = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mYE = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mYE.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mYE.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mYE.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mYE;
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
    public int dEi() {
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

    public void bd(float f) {
        this.mYm = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mYr = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mYm);
        this.mYs = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mYm);
        this.mYt = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mYm);
        this.mYu = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mYm);
        this.mYv = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mYm);
        this.mYw = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mYm);
        this.cLA = (int) (this.mYm * dimension);
        this.mYz = (int) (this.mYm * dimension2);
        this.mYA = (int) (this.mYm * dimension3);
    }
}
