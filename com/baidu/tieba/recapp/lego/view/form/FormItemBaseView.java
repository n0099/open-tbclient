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
/* loaded from: classes13.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float bFr;
    protected Drawable kvC;
    protected Drawable kvD;
    protected int kvE;
    protected int kvF;
    protected int kvG;
    protected int kvH;
    protected int kvI;
    protected int kvJ;
    protected int kvK;
    protected int kvL;
    protected float kvM;
    protected float kvN;
    protected int kvO;
    protected int kvP;
    protected int kvQ;
    protected int kvR;
    protected View kvS;
    protected float kvz;
    protected Activity mActivity;
    protected Context mContext;
    protected Resources mResources;
    protected String mTag;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes13.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.mContext = null;
        this.mResources = null;
        this.kvC = null;
        this.kvD = null;
        this.kvE = 0;
        this.kvF = 0;
        this.kvG = 0;
        this.kvH = 0;
        this.kvI = 0;
        this.kvJ = 0;
        this.kvK = 0;
        this.kvL = 0;
        this.bFr = 0.0f;
        this.kvM = 0.0f;
        this.kvN = 0.0f;
        this.kvO = 0;
        this.kvP = 0;
        this.kvQ = 0;
        this.kvR = 0;
        this.kvS = null;
        this.mTag = "";
        this.mActivity = null;
        this.kvz = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.kvC = null;
        this.kvD = null;
        this.kvE = 0;
        this.kvF = 0;
        this.kvG = 0;
        this.kvH = 0;
        this.kvI = 0;
        this.kvJ = 0;
        this.kvK = 0;
        this.kvL = 0;
        this.bFr = 0.0f;
        this.kvM = 0.0f;
        this.kvN = 0.0f;
        this.kvO = 0;
        this.kvP = 0;
        this.kvQ = 0;
        this.kvR = 0;
        this.kvS = null;
        this.mTag = "";
        this.mActivity = null;
        this.kvz = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.kvC = null;
        this.kvD = null;
        this.kvE = 0;
        this.kvF = 0;
        this.kvG = 0;
        this.kvH = 0;
        this.kvI = 0;
        this.kvJ = 0;
        this.kvK = 0;
        this.kvL = 0;
        this.bFr = 0.0f;
        this.kvM = 0.0f;
        this.kvN = 0.0f;
        this.kvO = 0;
        this.kvP = 0;
        this.kvQ = 0;
        this.kvR = 0;
        this.kvS = null;
        this.mTag = "";
        this.mActivity = null;
        this.kvz = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.kvL = this.mResources.getColor(R.color.form_font_color);
        this.kvO = this.mResources.getColor(R.color.form_button_font_color);
        this.kvQ = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.kvP = -1;
        this.kvR = -1;
        this.kvK = -1;
        this.kvC = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.kvD = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.kvS = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.kvS.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.kvS.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.kvS.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.kvS;
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
    public int cNW() {
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

    public void at(float f) {
        this.kvz = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.kvE = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.kvz);
        this.kvF = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.kvz);
        this.kvG = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.kvz);
        this.kvH = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.kvz);
        this.kvI = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.kvz);
        this.kvJ = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.kvz);
        this.bFr = (int) (this.kvz * dimension);
        this.kvM = (int) (this.kvz * dimension2);
        this.kvN = (int) (this.kvz * dimension3);
    }
}
