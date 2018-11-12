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
    protected float gIW;
    protected Drawable gIZ;
    protected Drawable gJa;
    protected int gJb;
    protected int gJc;
    protected int gJd;
    protected int gJe;
    protected int gJf;
    protected int gJg;
    protected int gJh;
    protected int gJi;
    protected float gJj;
    protected float gJk;
    protected int gJl;
    protected int gJm;
    protected int gJn;
    protected int gJo;
    protected View gJp;
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
        this.gIZ = null;
        this.gJa = null;
        this.gJb = 0;
        this.gJc = 0;
        this.gJd = 0;
        this.gJe = 0;
        this.gJf = 0;
        this.gJg = 0;
        this.gJh = 0;
        this.gJi = 0;
        this.mFontSize = 0.0f;
        this.gJj = 0.0f;
        this.gJk = 0.0f;
        this.gJl = 0;
        this.gJm = 0;
        this.gJn = 0;
        this.gJo = 0;
        this.gJp = null;
        this.mTag = "";
        this.mActivity = null;
        this.gIW = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gIZ = null;
        this.gJa = null;
        this.gJb = 0;
        this.gJc = 0;
        this.gJd = 0;
        this.gJe = 0;
        this.gJf = 0;
        this.gJg = 0;
        this.gJh = 0;
        this.gJi = 0;
        this.mFontSize = 0.0f;
        this.gJj = 0.0f;
        this.gJk = 0.0f;
        this.gJl = 0;
        this.gJm = 0;
        this.gJn = 0;
        this.gJo = 0;
        this.gJp = null;
        this.mTag = "";
        this.mActivity = null;
        this.gIW = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gIZ = null;
        this.gJa = null;
        this.gJb = 0;
        this.gJc = 0;
        this.gJd = 0;
        this.gJe = 0;
        this.gJf = 0;
        this.gJg = 0;
        this.gJh = 0;
        this.gJi = 0;
        this.mFontSize = 0.0f;
        this.gJj = 0.0f;
        this.gJk = 0.0f;
        this.gJl = 0;
        this.gJm = 0;
        this.gJn = 0;
        this.gJo = 0;
        this.gJp = null;
        this.mTag = "";
        this.mActivity = null;
        this.gIW = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gJi = this.mResources.getColor(e.d.form_font_color);
        this.gJl = this.mResources.getColor(e.d.form_button_font_color);
        this.gJn = this.mResources.getColor(e.d.form_button_grey_bg_color);
        this.gJm = -1;
        this.gJo = -1;
        this.gJh = -1;
        this.gIZ = this.mResources.getDrawable(e.f.form_frame_white);
        this.gJa = this.mResources.getDrawable(e.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gJp = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gJp.setBackgroundResource(e.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gJp.setBackgroundResource(e.f.form_frame_white);
                return;
            default:
                this.gJp.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gJp;
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
    public int btq() {
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
        this.gIW = f;
        float dimension = this.mResources.getDimension(e.C0200e.form_font_size28);
        float dimension2 = this.mResources.getDimension(e.C0200e.form_font_size20);
        float dimension3 = this.mResources.getDimension(e.C0200e.form_font_size36);
        this.gJb = (int) (((int) this.mResources.getDimension(e.C0200e.form_size20)) * this.gIW);
        this.gJc = (int) (((int) this.mResources.getDimension(e.C0200e.form_size40)) * this.gIW);
        this.gJd = (int) (((int) this.mResources.getDimension(e.C0200e.form_size50)) * this.gIW);
        this.gJe = (int) (((int) this.mResources.getDimension(e.C0200e.form_size80)) * this.gIW);
        this.gJf = (int) (((int) this.mResources.getDimension(e.C0200e.form_size90)) * this.gIW);
        this.gJg = (int) (((int) this.mResources.getDimension(e.C0200e.form_size240)) * this.gIW);
        this.mFontSize = (int) (this.gIW * dimension);
        this.gJj = (int) (this.gIW * dimension2);
        this.gJk = (int) (this.gIW * dimension3);
    }
}
