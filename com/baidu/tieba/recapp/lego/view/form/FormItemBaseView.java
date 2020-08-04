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
    protected float bTU;
    protected float lpT;
    protected Drawable lpW;
    protected Drawable lpX;
    protected int lpY;
    protected int lpZ;
    protected int lqa;
    protected int lqb;
    protected int lqc;
    protected int lqd;
    protected int lqe;
    protected int lqf;
    protected float lqg;
    protected float lqh;
    protected int lqi;
    protected int lqj;
    protected int lqk;
    protected int lql;
    protected View lqm;
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
        this.lpW = null;
        this.lpX = null;
        this.lpY = 0;
        this.lpZ = 0;
        this.lqa = 0;
        this.lqb = 0;
        this.lqc = 0;
        this.lqd = 0;
        this.lqe = 0;
        this.lqf = 0;
        this.bTU = 0.0f;
        this.lqg = 0.0f;
        this.lqh = 0.0f;
        this.lqi = 0;
        this.lqj = 0;
        this.lqk = 0;
        this.lql = 0;
        this.lqm = null;
        this.mTag = "";
        this.mActivity = null;
        this.lpT = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.lpW = null;
        this.lpX = null;
        this.lpY = 0;
        this.lpZ = 0;
        this.lqa = 0;
        this.lqb = 0;
        this.lqc = 0;
        this.lqd = 0;
        this.lqe = 0;
        this.lqf = 0;
        this.bTU = 0.0f;
        this.lqg = 0.0f;
        this.lqh = 0.0f;
        this.lqi = 0;
        this.lqj = 0;
        this.lqk = 0;
        this.lql = 0;
        this.lqm = null;
        this.mTag = "";
        this.mActivity = null;
        this.lpT = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.lpW = null;
        this.lpX = null;
        this.lpY = 0;
        this.lpZ = 0;
        this.lqa = 0;
        this.lqb = 0;
        this.lqc = 0;
        this.lqd = 0;
        this.lqe = 0;
        this.lqf = 0;
        this.bTU = 0.0f;
        this.lqg = 0.0f;
        this.lqh = 0.0f;
        this.lqi = 0;
        this.lqj = 0;
        this.lqk = 0;
        this.lql = 0;
        this.lqm = null;
        this.mTag = "";
        this.mActivity = null;
        this.lpT = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.lqf = this.mResources.getColor(R.color.form_font_color);
        this.lqi = this.mResources.getColor(R.color.form_button_font_color);
        this.lqk = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.lqj = -1;
        this.lql = -1;
        this.lqe = -1;
        this.lpW = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.lpX = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.lqm = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.lqm.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.lqm.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.lqm.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.lqm;
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
    public int dcI() {
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

    public void aw(float f) {
        this.lpT = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.lpY = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.lpT);
        this.lpZ = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.lpT);
        this.lqa = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.lpT);
        this.lqb = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.lpT);
        this.lqc = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.lpT);
        this.lqd = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.lpT);
        this.bTU = (int) (this.lpT * dimension);
        this.lqg = (int) (this.lpT * dimension2);
        this.lqh = (int) (this.lpT * dimension3);
    }
}
