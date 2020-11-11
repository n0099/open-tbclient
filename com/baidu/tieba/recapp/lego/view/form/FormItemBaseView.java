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
    protected float cCt;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;
    protected int mxA;
    protected View mxB;
    protected float mxi;
    protected Drawable mxl;
    protected Drawable mxm;
    protected int mxn;
    protected int mxo;
    protected int mxp;
    protected int mxq;
    protected int mxr;
    protected int mxs;
    protected int mxt;
    protected int mxu;
    protected float mxv;
    protected float mxw;
    protected int mxx;
    protected int mxy;
    protected int mxz;

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
        this.mxl = null;
        this.mxm = null;
        this.mxn = 0;
        this.mxo = 0;
        this.mxp = 0;
        this.mxq = 0;
        this.mxr = 0;
        this.mxs = 0;
        this.mxt = 0;
        this.mxu = 0;
        this.cCt = 0.0f;
        this.mxv = 0.0f;
        this.mxw = 0.0f;
        this.mxx = 0;
        this.mxy = 0;
        this.mxz = 0;
        this.mxA = 0;
        this.mxB = null;
        this.mTag = "";
        this.mActivity = null;
        this.mxi = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mxl = null;
        this.mxm = null;
        this.mxn = 0;
        this.mxo = 0;
        this.mxp = 0;
        this.mxq = 0;
        this.mxr = 0;
        this.mxs = 0;
        this.mxt = 0;
        this.mxu = 0;
        this.cCt = 0.0f;
        this.mxv = 0.0f;
        this.mxw = 0.0f;
        this.mxx = 0;
        this.mxy = 0;
        this.mxz = 0;
        this.mxA = 0;
        this.mxB = null;
        this.mTag = "";
        this.mActivity = null;
        this.mxi = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mxl = null;
        this.mxm = null;
        this.mxn = 0;
        this.mxo = 0;
        this.mxp = 0;
        this.mxq = 0;
        this.mxr = 0;
        this.mxs = 0;
        this.mxt = 0;
        this.mxu = 0;
        this.cCt = 0.0f;
        this.mxv = 0.0f;
        this.mxw = 0.0f;
        this.mxx = 0;
        this.mxy = 0;
        this.mxz = 0;
        this.mxA = 0;
        this.mxB = null;
        this.mTag = "";
        this.mActivity = null;
        this.mxi = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mxu = this.mResources.getColor(R.color.form_font_color);
        this.mxx = this.mResources.getColor(R.color.form_button_font_color);
        this.mxz = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mxy = -1;
        this.mxA = -1;
        this.mxt = -1;
        this.mxl = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mxm = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mxB = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mxB.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mxB.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mxB.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mxB;
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
    public int dAX() {
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

    public void aM(float f) {
        this.mxi = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mxn = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mxi);
        this.mxo = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mxi);
        this.mxp = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mxi);
        this.mxq = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mxi);
        this.mxr = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mxi);
        this.mxs = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mxi);
        this.cCt = (int) (this.mxi * dimension);
        this.mxv = (int) (this.mxi * dimension2);
        this.mxw = (int) (this.mxi * dimension3);
    }
}
