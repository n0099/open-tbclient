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
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float amF;
    protected float iLe;
    protected Drawable iLh;
    protected Drawable iLi;
    protected int iLj;
    protected int iLk;
    protected int iLl;
    protected int iLm;
    protected int iLn;
    protected int iLo;
    protected int iLp;
    protected int iLq;
    protected float iLr;
    protected float iLs;
    protected int iLt;
    protected int iLu;
    protected int iLv;
    protected int iLw;
    protected View iLx;
    protected Activity mActivity;
    protected Context mContext;
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
        this.iLh = null;
        this.iLi = null;
        this.iLj = 0;
        this.iLk = 0;
        this.iLl = 0;
        this.iLm = 0;
        this.iLn = 0;
        this.iLo = 0;
        this.iLp = 0;
        this.iLq = 0;
        this.amF = 0.0f;
        this.iLr = 0.0f;
        this.iLs = 0.0f;
        this.iLt = 0;
        this.iLu = 0;
        this.iLv = 0;
        this.iLw = 0;
        this.iLx = null;
        this.mTag = "";
        this.mActivity = null;
        this.iLe = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.iLh = null;
        this.iLi = null;
        this.iLj = 0;
        this.iLk = 0;
        this.iLl = 0;
        this.iLm = 0;
        this.iLn = 0;
        this.iLo = 0;
        this.iLp = 0;
        this.iLq = 0;
        this.amF = 0.0f;
        this.iLr = 0.0f;
        this.iLs = 0.0f;
        this.iLt = 0;
        this.iLu = 0;
        this.iLv = 0;
        this.iLw = 0;
        this.iLx = null;
        this.mTag = "";
        this.mActivity = null;
        this.iLe = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.iLh = null;
        this.iLi = null;
        this.iLj = 0;
        this.iLk = 0;
        this.iLl = 0;
        this.iLm = 0;
        this.iLn = 0;
        this.iLo = 0;
        this.iLp = 0;
        this.iLq = 0;
        this.amF = 0.0f;
        this.iLr = 0.0f;
        this.iLs = 0.0f;
        this.iLt = 0;
        this.iLu = 0;
        this.iLv = 0;
        this.iLw = 0;
        this.iLx = null;
        this.mTag = "";
        this.mActivity = null;
        this.iLe = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.iLq = this.mResources.getColor(R.color.form_font_color);
        this.iLt = this.mResources.getColor(R.color.form_button_font_color);
        this.iLv = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.iLu = -1;
        this.iLw = -1;
        this.iLp = -1;
        this.iLh = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.iLi = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.iLx = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.iLx.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.iLx.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.iLx.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.iLx;
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
    public int ciF() {
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

    public void aQ(float f) {
        this.iLe = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.iLj = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.iLe);
        this.iLk = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.iLe);
        this.iLl = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.iLe);
        this.iLm = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.iLe);
        this.iLn = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.iLe);
        this.iLo = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.iLe);
        this.amF = (int) (this.iLe * dimension);
        this.iLr = (int) (this.iLe * dimension2);
        this.iLs = (int) (this.iLe * dimension3);
    }
}
