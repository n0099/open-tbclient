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
/* loaded from: classes20.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float bZC;
    protected int lGA;
    protected float lGB;
    protected float lGC;
    protected int lGD;
    protected int lGE;
    protected int lGF;
    protected int lGG;
    protected View lGH;
    protected float lGo;
    protected Drawable lGr;
    protected Drawable lGs;
    protected int lGt;
    protected int lGu;
    protected int lGv;
    protected int lGw;
    protected int lGx;
    protected int lGy;
    protected int lGz;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.lGr = null;
        this.lGs = null;
        this.lGt = 0;
        this.lGu = 0;
        this.lGv = 0;
        this.lGw = 0;
        this.lGx = 0;
        this.lGy = 0;
        this.lGz = 0;
        this.lGA = 0;
        this.bZC = 0.0f;
        this.lGB = 0.0f;
        this.lGC = 0.0f;
        this.lGD = 0;
        this.lGE = 0;
        this.lGF = 0;
        this.lGG = 0;
        this.lGH = null;
        this.mTag = "";
        this.mActivity = null;
        this.lGo = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.lGr = null;
        this.lGs = null;
        this.lGt = 0;
        this.lGu = 0;
        this.lGv = 0;
        this.lGw = 0;
        this.lGx = 0;
        this.lGy = 0;
        this.lGz = 0;
        this.lGA = 0;
        this.bZC = 0.0f;
        this.lGB = 0.0f;
        this.lGC = 0.0f;
        this.lGD = 0;
        this.lGE = 0;
        this.lGF = 0;
        this.lGG = 0;
        this.lGH = null;
        this.mTag = "";
        this.mActivity = null;
        this.lGo = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.lGr = null;
        this.lGs = null;
        this.lGt = 0;
        this.lGu = 0;
        this.lGv = 0;
        this.lGw = 0;
        this.lGx = 0;
        this.lGy = 0;
        this.lGz = 0;
        this.lGA = 0;
        this.bZC = 0.0f;
        this.lGB = 0.0f;
        this.lGC = 0.0f;
        this.lGD = 0;
        this.lGE = 0;
        this.lGF = 0;
        this.lGG = 0;
        this.lGH = null;
        this.mTag = "";
        this.mActivity = null;
        this.lGo = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.lGA = this.mResources.getColor(R.color.form_font_color);
        this.lGD = this.mResources.getColor(R.color.form_button_font_color);
        this.lGF = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.lGE = -1;
        this.lGG = -1;
        this.lGz = -1;
        this.lGr = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.lGs = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.lGH = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.lGH.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.lGH.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.lGH.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.lGH;
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
    public int dnR() {
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
        this.lGo = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.lGt = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.lGo);
        this.lGu = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.lGo);
        this.lGv = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.lGo);
        this.lGw = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.lGo);
        this.lGx = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.lGo);
        this.lGy = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.lGo);
        this.bZC = (int) (this.lGo * dimension);
        this.lGB = (int) (this.lGo * dimension2);
        this.lGC = (int) (this.lGo * dimension3);
    }
}
