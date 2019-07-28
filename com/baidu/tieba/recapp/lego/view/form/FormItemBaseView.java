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
    protected float iKa;
    protected Drawable iKd;
    protected Drawable iKe;
    protected int iKf;
    protected int iKg;
    protected int iKh;
    protected int iKi;
    protected int iKj;
    protected int iKk;
    protected int iKl;
    protected int iKm;
    protected float iKn;
    protected float iKo;
    protected int iKp;
    protected int iKq;
    protected int iKr;
    protected int iKs;
    protected View iKt;
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
        this.iKd = null;
        this.iKe = null;
        this.iKf = 0;
        this.iKg = 0;
        this.iKh = 0;
        this.iKi = 0;
        this.iKj = 0;
        this.iKk = 0;
        this.iKl = 0;
        this.iKm = 0;
        this.amF = 0.0f;
        this.iKn = 0.0f;
        this.iKo = 0.0f;
        this.iKp = 0;
        this.iKq = 0;
        this.iKr = 0;
        this.iKs = 0;
        this.iKt = null;
        this.mTag = "";
        this.mActivity = null;
        this.iKa = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.iKd = null;
        this.iKe = null;
        this.iKf = 0;
        this.iKg = 0;
        this.iKh = 0;
        this.iKi = 0;
        this.iKj = 0;
        this.iKk = 0;
        this.iKl = 0;
        this.iKm = 0;
        this.amF = 0.0f;
        this.iKn = 0.0f;
        this.iKo = 0.0f;
        this.iKp = 0;
        this.iKq = 0;
        this.iKr = 0;
        this.iKs = 0;
        this.iKt = null;
        this.mTag = "";
        this.mActivity = null;
        this.iKa = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.iKd = null;
        this.iKe = null;
        this.iKf = 0;
        this.iKg = 0;
        this.iKh = 0;
        this.iKi = 0;
        this.iKj = 0;
        this.iKk = 0;
        this.iKl = 0;
        this.iKm = 0;
        this.amF = 0.0f;
        this.iKn = 0.0f;
        this.iKo = 0.0f;
        this.iKp = 0;
        this.iKq = 0;
        this.iKr = 0;
        this.iKs = 0;
        this.iKt = null;
        this.mTag = "";
        this.mActivity = null;
        this.iKa = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.iKm = this.mResources.getColor(R.color.form_font_color);
        this.iKp = this.mResources.getColor(R.color.form_button_font_color);
        this.iKr = this.mResources.getColor(R.color.form_button_grey_bg_color);
        this.iKq = -1;
        this.iKs = -1;
        this.iKl = -1;
        this.iKd = this.mResources.getDrawable(R.drawable.form_frame_white);
        this.iKe = this.mResources.getDrawable(R.drawable.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.iKt = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.iKt.setBackgroundResource(R.drawable.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.iKt.setBackgroundResource(R.drawable.form_frame_white);
                return;
            default:
                this.iKt.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.iKt;
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
    public int cin() {
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
        this.iKa = f;
        float dimension = this.mResources.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.mResources.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.mResources.getDimension(R.dimen.form_font_size36);
        this.iKf = (int) (((int) this.mResources.getDimension(R.dimen.form_size20)) * this.iKa);
        this.iKg = (int) (((int) this.mResources.getDimension(R.dimen.form_size40)) * this.iKa);
        this.iKh = (int) (((int) this.mResources.getDimension(R.dimen.form_size50)) * this.iKa);
        this.iKi = (int) (((int) this.mResources.getDimension(R.dimen.form_size80)) * this.iKa);
        this.iKj = (int) (((int) this.mResources.getDimension(R.dimen.form_size90)) * this.iKa);
        this.iKk = (int) (((int) this.mResources.getDimension(R.dimen.form_size240)) * this.iKa);
        this.amF = (int) (this.iKa * dimension);
        this.iKn = (int) (this.iKa * dimension2);
        this.iKo = (int) (this.iKa * dimension3);
    }
}
