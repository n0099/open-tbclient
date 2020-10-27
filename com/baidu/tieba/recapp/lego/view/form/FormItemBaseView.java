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
    protected float cwA;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;
    protected int mrA;
    protected int mrB;
    protected int mrC;
    protected int mrD;
    protected View mrE;
    protected float mrl;
    protected Drawable mro;
    protected Drawable mrp;
    protected int mrq;
    protected int mrr;
    protected int mrs;
    protected int mrt;
    protected int mru;
    protected int mrv;
    protected int mrw;
    protected int mrx;
    protected float mry;
    protected float mrz;

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
        this.mro = null;
        this.mrp = null;
        this.mrq = 0;
        this.mrr = 0;
        this.mrs = 0;
        this.mrt = 0;
        this.mru = 0;
        this.mrv = 0;
        this.mrw = 0;
        this.mrx = 0;
        this.cwA = 0.0f;
        this.mry = 0.0f;
        this.mrz = 0.0f;
        this.mrA = 0;
        this.mrB = 0;
        this.mrC = 0;
        this.mrD = 0;
        this.mrE = null;
        this.mTag = "";
        this.mActivity = null;
        this.mrl = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mro = null;
        this.mrp = null;
        this.mrq = 0;
        this.mrr = 0;
        this.mrs = 0;
        this.mrt = 0;
        this.mru = 0;
        this.mrv = 0;
        this.mrw = 0;
        this.mrx = 0;
        this.cwA = 0.0f;
        this.mry = 0.0f;
        this.mrz = 0.0f;
        this.mrA = 0;
        this.mrB = 0;
        this.mrC = 0;
        this.mrD = 0;
        this.mrE = null;
        this.mTag = "";
        this.mActivity = null;
        this.mrl = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mro = null;
        this.mrp = null;
        this.mrq = 0;
        this.mrr = 0;
        this.mrs = 0;
        this.mrt = 0;
        this.mru = 0;
        this.mrv = 0;
        this.mrw = 0;
        this.mrx = 0;
        this.cwA = 0.0f;
        this.mry = 0.0f;
        this.mrz = 0.0f;
        this.mrA = 0;
        this.mrB = 0;
        this.mrC = 0;
        this.mrD = 0;
        this.mrE = null;
        this.mTag = "";
        this.mActivity = null;
        this.mrl = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mrx = this.mResources.getColor(R.color.form_font_color);
        this.mrA = this.mResources.getColor(R.color.form_button_font_color);
        this.mrC = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mrB = -1;
        this.mrD = -1;
        this.mrw = -1;
        this.mro = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mrp = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mrE = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mrE.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mrE.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mrE.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mrE;
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
    public int dyv() {
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

    public void aK(float f) {
        this.mrl = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mrq = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mrl);
        this.mrr = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mrl);
        this.mrs = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mrl);
        this.mrt = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mrl);
        this.mru = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mrl);
        this.mrv = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mrl);
        this.cwA = (int) (this.mrl * dimension);
        this.mry = (int) (this.mrl * dimension2);
        this.mrz = (int) (this.mrl * dimension3);
    }
}
