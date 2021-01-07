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
/* loaded from: classes8.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float cMu;
    protected Activity mActivity;
    protected Context mContext;
    protected float mQS;
    protected Drawable mQV;
    protected Drawable mQW;
    protected int mQX;
    protected int mQY;
    protected int mQZ;
    protected int mRa;
    protected int mRb;
    protected int mRc;
    protected int mRd;
    protected int mRe;
    protected Resources mResources;
    protected float mRf;
    protected float mRg;
    protected int mRh;
    protected int mRi;
    protected int mRj;
    protected int mRk;
    protected View mRl;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.mQV = null;
        this.mQW = null;
        this.mQX = 0;
        this.mQY = 0;
        this.mQZ = 0;
        this.mRa = 0;
        this.mRb = 0;
        this.mRc = 0;
        this.mRd = 0;
        this.mRe = 0;
        this.cMu = 0.0f;
        this.mRf = 0.0f;
        this.mRg = 0.0f;
        this.mRh = 0;
        this.mRi = 0;
        this.mRj = 0;
        this.mRk = 0;
        this.mRl = null;
        this.mTag = "";
        this.mActivity = null;
        this.mQS = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mQV = null;
        this.mQW = null;
        this.mQX = 0;
        this.mQY = 0;
        this.mQZ = 0;
        this.mRa = 0;
        this.mRb = 0;
        this.mRc = 0;
        this.mRd = 0;
        this.mRe = 0;
        this.cMu = 0.0f;
        this.mRf = 0.0f;
        this.mRg = 0.0f;
        this.mRh = 0;
        this.mRi = 0;
        this.mRj = 0;
        this.mRk = 0;
        this.mRl = null;
        this.mTag = "";
        this.mActivity = null;
        this.mQS = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mQV = null;
        this.mQW = null;
        this.mQX = 0;
        this.mQY = 0;
        this.mQZ = 0;
        this.mRa = 0;
        this.mRb = 0;
        this.mRc = 0;
        this.mRd = 0;
        this.mRe = 0;
        this.cMu = 0.0f;
        this.mRf = 0.0f;
        this.mRg = 0.0f;
        this.mRh = 0;
        this.mRi = 0;
        this.mRj = 0;
        this.mRk = 0;
        this.mRl = null;
        this.mTag = "";
        this.mActivity = null;
        this.mQS = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mRe = this.mResources.getColor(R.color.form_font_color);
        this.mRh = this.mResources.getColor(R.color.form_button_font_color);
        this.mRj = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mRi = -1;
        this.mRk = -1;
        this.mRd = -1;
        this.mQV = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mQW = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mRl = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mRl.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mRl.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mRl.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mRl;
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
    public int dFC() {
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

    public void aW(float f) {
        this.mQS = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mQX = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mQS);
        this.mQY = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mQS);
        this.mQZ = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mQS);
        this.mRa = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mQS);
        this.mRb = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mQS);
        this.mRc = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mQS);
        this.cMu = (int) (this.mQS * dimension);
        this.mRf = (int) (this.mQS * dimension2);
        this.mRg = (int) (this.mQS * dimension3);
    }
}
