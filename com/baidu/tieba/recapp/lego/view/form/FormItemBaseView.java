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
    protected float cHF;
    protected Activity mActivity;
    protected Context mContext;
    protected float mLK;
    protected Drawable mLN;
    protected Drawable mLO;
    protected int mLP;
    protected int mLQ;
    protected int mLR;
    protected int mLS;
    protected int mLT;
    protected int mLU;
    protected int mLV;
    protected int mLW;
    protected float mLX;
    protected float mLY;
    protected int mLZ;
    protected int mMa;
    protected int mMb;
    protected int mMc;
    protected View mMd;
    protected Resources mResources;
    protected String mTag;

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
        this.mLN = null;
        this.mLO = null;
        this.mLP = 0;
        this.mLQ = 0;
        this.mLR = 0;
        this.mLS = 0;
        this.mLT = 0;
        this.mLU = 0;
        this.mLV = 0;
        this.mLW = 0;
        this.cHF = 0.0f;
        this.mLX = 0.0f;
        this.mLY = 0.0f;
        this.mLZ = 0;
        this.mMa = 0;
        this.mMb = 0;
        this.mMc = 0;
        this.mMd = null;
        this.mTag = "";
        this.mActivity = null;
        this.mLK = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mLN = null;
        this.mLO = null;
        this.mLP = 0;
        this.mLQ = 0;
        this.mLR = 0;
        this.mLS = 0;
        this.mLT = 0;
        this.mLU = 0;
        this.mLV = 0;
        this.mLW = 0;
        this.cHF = 0.0f;
        this.mLX = 0.0f;
        this.mLY = 0.0f;
        this.mLZ = 0;
        this.mMa = 0;
        this.mMb = 0;
        this.mMc = 0;
        this.mMd = null;
        this.mTag = "";
        this.mActivity = null;
        this.mLK = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mLN = null;
        this.mLO = null;
        this.mLP = 0;
        this.mLQ = 0;
        this.mLR = 0;
        this.mLS = 0;
        this.mLT = 0;
        this.mLU = 0;
        this.mLV = 0;
        this.mLW = 0;
        this.cHF = 0.0f;
        this.mLX = 0.0f;
        this.mLY = 0.0f;
        this.mLZ = 0;
        this.mMa = 0;
        this.mMb = 0;
        this.mMc = 0;
        this.mMd = null;
        this.mTag = "";
        this.mActivity = null;
        this.mLK = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mLW = this.mResources.getColor(R.color.form_font_color);
        this.mLZ = this.mResources.getColor(R.color.form_button_font_color);
        this.mMb = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mMa = -1;
        this.mMc = -1;
        this.mLV = -1;
        this.mLN = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mLO = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mMd = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mMd.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mMd.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mMd.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mMd;
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
    public int dFM() {
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

    public void aU(float f) {
        this.mLK = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mLP = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mLK);
        this.mLQ = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mLK);
        this.mLR = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mLK);
        this.mLS = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mLK);
        this.mLT = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mLK);
        this.mLU = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mLK);
        this.cHF = (int) (this.mLK * dimension);
        this.mLX = (int) (this.mLK * dimension2);
        this.mLY = (int) (this.mLK * dimension3);
    }
}
