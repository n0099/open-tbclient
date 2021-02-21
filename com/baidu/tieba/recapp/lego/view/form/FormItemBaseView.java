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
    protected float cKa;
    protected Activity mActivity;
    protected int mButtonFontColor;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;
    protected float mWb;
    protected Drawable mWe;
    protected Drawable mWf;
    protected int mWg;
    protected int mWh;
    protected int mWi;
    protected int mWj;
    protected int mWk;
    protected int mWl;
    protected int mWm;
    protected int mWn;
    protected float mWo;
    protected float mWp;
    protected int mWq;
    protected int mWr;
    protected int mWs;
    protected View mWt;

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
        this.mWe = null;
        this.mWf = null;
        this.mWg = 0;
        this.mWh = 0;
        this.mWi = 0;
        this.mWj = 0;
        this.mWk = 0;
        this.mWl = 0;
        this.mWm = 0;
        this.mWn = 0;
        this.cKa = 0.0f;
        this.mWo = 0.0f;
        this.mWp = 0.0f;
        this.mButtonFontColor = 0;
        this.mWq = 0;
        this.mWr = 0;
        this.mWs = 0;
        this.mWt = null;
        this.mTag = "";
        this.mActivity = null;
        this.mWb = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.mWe = null;
        this.mWf = null;
        this.mWg = 0;
        this.mWh = 0;
        this.mWi = 0;
        this.mWj = 0;
        this.mWk = 0;
        this.mWl = 0;
        this.mWm = 0;
        this.mWn = 0;
        this.cKa = 0.0f;
        this.mWo = 0.0f;
        this.mWp = 0.0f;
        this.mButtonFontColor = 0;
        this.mWq = 0;
        this.mWr = 0;
        this.mWs = 0;
        this.mWt = null;
        this.mTag = "";
        this.mActivity = null;
        this.mWb = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.mWe = null;
        this.mWf = null;
        this.mWg = 0;
        this.mWh = 0;
        this.mWi = 0;
        this.mWj = 0;
        this.mWk = 0;
        this.mWl = 0;
        this.mWm = 0;
        this.mWn = 0;
        this.cKa = 0.0f;
        this.mWo = 0.0f;
        this.mWp = 0.0f;
        this.mButtonFontColor = 0;
        this.mWq = 0;
        this.mWr = 0;
        this.mWs = 0;
        this.mWt = null;
        this.mTag = "";
        this.mActivity = null;
        this.mWb = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.mWn = this.mResources.getColor(R.color.form_font_color);
        this.mButtonFontColor = this.mResources.getColor(R.color.form_button_font_color);
        this.mWr = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.mWq = -1;
        this.mWs = -1;
        this.mWm = -1;
        this.mWe = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.mWf = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.mWt = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.mWt.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.mWt.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.mWt.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.mWt;
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
    public int dEa() {
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

    public void aZ(float f) {
        this.mWb = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.mWg = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.mWb);
        this.mWh = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.mWb);
        this.mWi = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.mWb);
        this.mWj = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.mWb);
        this.mWk = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.mWb);
        this.mWl = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.mWb);
        this.cKa = (int) (this.mWb * dimension);
        this.mWo = (int) (this.mWb * dimension2);
        this.mWp = (int) (this.mWb * dimension3);
    }
}
