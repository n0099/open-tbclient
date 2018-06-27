package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.d;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes3.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.a {
    protected float grA;
    protected int grB;
    protected int grC;
    protected int grD;
    protected int grE;
    protected View grF;
    protected float grl;
    protected Drawable gro;
    protected Drawable grp;
    protected int grq;
    protected int grr;
    protected int grs;
    protected int grt;
    protected int gru;
    protected int grv;
    protected int grw;
    protected int grx;
    protected float gry;
    protected float grz;
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
        this.gro = null;
        this.grp = null;
        this.grq = 0;
        this.grr = 0;
        this.grs = 0;
        this.grt = 0;
        this.gru = 0;
        this.grv = 0;
        this.grw = 0;
        this.grx = 0;
        this.gry = 0.0f;
        this.grz = 0.0f;
        this.grA = 0.0f;
        this.grB = 0;
        this.grC = 0;
        this.grD = 0;
        this.grE = 0;
        this.grF = null;
        this.mTag = "";
        this.mActivity = null;
        this.grl = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gro = null;
        this.grp = null;
        this.grq = 0;
        this.grr = 0;
        this.grs = 0;
        this.grt = 0;
        this.gru = 0;
        this.grv = 0;
        this.grw = 0;
        this.grx = 0;
        this.gry = 0.0f;
        this.grz = 0.0f;
        this.grA = 0.0f;
        this.grB = 0;
        this.grC = 0;
        this.grD = 0;
        this.grE = 0;
        this.grF = null;
        this.mTag = "";
        this.mActivity = null;
        this.grl = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gro = null;
        this.grp = null;
        this.grq = 0;
        this.grr = 0;
        this.grs = 0;
        this.grt = 0;
        this.gru = 0;
        this.grv = 0;
        this.grw = 0;
        this.grx = 0;
        this.gry = 0.0f;
        this.grz = 0.0f;
        this.grA = 0.0f;
        this.grB = 0;
        this.grC = 0;
        this.grD = 0;
        this.grE = 0;
        this.grF = null;
        this.mTag = "";
        this.mActivity = null;
        this.grl = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.grx = this.mResources.getColor(d.C0142d.form_font_color);
        this.grB = this.mResources.getColor(d.C0142d.form_button_font_color);
        this.grD = this.mResources.getColor(d.C0142d.form_button_grey_bg_color);
        this.grC = -1;
        this.grE = -1;
        this.grw = -1;
        this.gro = this.mResources.getDrawable(d.f.form_frame_white);
        this.grp = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.grF = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.grF.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.grF.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.grF.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.grF;
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
    public int bpt() {
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

    public void aB(float f) {
        this.grl = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.grq = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.grl);
        this.grr = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.grl);
        this.grs = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.grl);
        this.grt = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.grl);
        this.gru = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.grl);
        this.grv = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.grl);
        this.gry = (int) (this.grl * dimension);
        this.grz = (int) (this.grl * dimension2);
        this.grA = (int) (this.grl * dimension3);
    }
}
