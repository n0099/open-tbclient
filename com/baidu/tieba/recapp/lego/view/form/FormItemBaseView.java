package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float gPM;
    protected Drawable gPP;
    protected Drawable gPQ;
    protected int gPR;
    protected int gPS;
    protected int gPT;
    protected int gPU;
    protected int gPV;
    protected int gPW;
    protected int gPX;
    protected int gPY;
    protected float gPZ;
    protected float gQa;
    protected int gQb;
    protected int gQc;
    protected int gQd;
    protected int gQe;
    protected View gQf;
    protected Activity mActivity;
    protected Context mContext;
    protected float mFontSize;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.gPP = null;
        this.gPQ = null;
        this.gPR = 0;
        this.gPS = 0;
        this.gPT = 0;
        this.gPU = 0;
        this.gPV = 0;
        this.gPW = 0;
        this.gPX = 0;
        this.gPY = 0;
        this.mFontSize = 0.0f;
        this.gPZ = 0.0f;
        this.gQa = 0.0f;
        this.gQb = 0;
        this.gQc = 0;
        this.gQd = 0;
        this.gQe = 0;
        this.gQf = null;
        this.mTag = "";
        this.mActivity = null;
        this.gPM = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gPP = null;
        this.gPQ = null;
        this.gPR = 0;
        this.gPS = 0;
        this.gPT = 0;
        this.gPU = 0;
        this.gPV = 0;
        this.gPW = 0;
        this.gPX = 0;
        this.gPY = 0;
        this.mFontSize = 0.0f;
        this.gPZ = 0.0f;
        this.gQa = 0.0f;
        this.gQb = 0;
        this.gQc = 0;
        this.gQd = 0;
        this.gQe = 0;
        this.gQf = null;
        this.mTag = "";
        this.mActivity = null;
        this.gPM = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gPP = null;
        this.gPQ = null;
        this.gPR = 0;
        this.gPS = 0;
        this.gPT = 0;
        this.gPU = 0;
        this.gPV = 0;
        this.gPW = 0;
        this.gPX = 0;
        this.gPY = 0;
        this.mFontSize = 0.0f;
        this.gPZ = 0.0f;
        this.gQa = 0.0f;
        this.gQb = 0;
        this.gQc = 0;
        this.gQd = 0;
        this.gQe = 0;
        this.gQf = null;
        this.mTag = "";
        this.mActivity = null;
        this.gPM = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gPY = this.mResources.getColor(e.d.form_font_color);
        this.gQb = this.mResources.getColor(e.d.form_button_font_color);
        this.gQd = this.mResources.getColor(e.d.form_button_grey_bg_color);
        this.gQc = -1;
        this.gQe = -1;
        this.gPX = -1;
        this.gPP = this.mResources.getDrawable(e.f.form_frame_white);
        this.gPQ = this.mResources.getDrawable(e.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gQf = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gQf.setBackgroundResource(e.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gQf.setBackgroundResource(e.f.form_frame_white);
                return;
            default:
                this.gQf.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gQf;
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
    public int bvj() {
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

    public void ay(float f) {
        this.gPM = f;
        float dimension = this.mResources.getDimension(e.C0210e.form_font_size28);
        float dimension2 = this.mResources.getDimension(e.C0210e.form_font_size20);
        float dimension3 = this.mResources.getDimension(e.C0210e.form_font_size36);
        this.gPR = (int) (((int) this.mResources.getDimension(e.C0210e.form_size20)) * this.gPM);
        this.gPS = (int) (((int) this.mResources.getDimension(e.C0210e.form_size40)) * this.gPM);
        this.gPT = (int) (((int) this.mResources.getDimension(e.C0210e.form_size50)) * this.gPM);
        this.gPU = (int) (((int) this.mResources.getDimension(e.C0210e.form_size80)) * this.gPM);
        this.gPV = (int) (((int) this.mResources.getDimension(e.C0210e.form_size90)) * this.gPM);
        this.gPW = (int) (((int) this.mResources.getDimension(e.C0210e.form_size240)) * this.gPM);
        this.mFontSize = (int) (this.gPM * dimension);
        this.gPZ = (int) (this.gPM * dimension2);
        this.gQa = (int) (this.gPM * dimension3);
    }
}
