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
    protected float alQ;
    protected float ikT;
    protected Drawable ikW;
    protected Drawable ikX;
    protected int ikY;
    protected int ikZ;
    protected int ila;
    protected int ilb;
    protected int ilc;
    protected int ild;
    protected int ile;
    protected int ilf;
    protected float ilg;
    protected float ilh;
    protected int ili;
    protected int ilj;
    protected int ilk;
    protected int ill;
    protected View ilm;
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
        this.ikW = null;
        this.ikX = null;
        this.ikY = 0;
        this.ikZ = 0;
        this.ila = 0;
        this.ilb = 0;
        this.ilc = 0;
        this.ild = 0;
        this.ile = 0;
        this.ilf = 0;
        this.alQ = 0.0f;
        this.ilg = 0.0f;
        this.ilh = 0.0f;
        this.ili = 0;
        this.ilj = 0;
        this.ilk = 0;
        this.ill = 0;
        this.ilm = null;
        this.mTag = "";
        this.mActivity = null;
        this.ikT = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.ikW = null;
        this.ikX = null;
        this.ikY = 0;
        this.ikZ = 0;
        this.ila = 0;
        this.ilb = 0;
        this.ilc = 0;
        this.ild = 0;
        this.ile = 0;
        this.ilf = 0;
        this.alQ = 0.0f;
        this.ilg = 0.0f;
        this.ilh = 0.0f;
        this.ili = 0;
        this.ilj = 0;
        this.ilk = 0;
        this.ill = 0;
        this.ilm = null;
        this.mTag = "";
        this.mActivity = null;
        this.ikT = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.ikW = null;
        this.ikX = null;
        this.ikY = 0;
        this.ikZ = 0;
        this.ila = 0;
        this.ilb = 0;
        this.ilc = 0;
        this.ild = 0;
        this.ile = 0;
        this.ilf = 0;
        this.alQ = 0.0f;
        this.ilg = 0.0f;
        this.ilh = 0.0f;
        this.ili = 0;
        this.ilj = 0;
        this.ilk = 0;
        this.ill = 0;
        this.ilm = null;
        this.mTag = "";
        this.mActivity = null;
        this.ikT = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.ilf = this.mResources.getColor(d.C0277d.form_font_color);
        this.ili = this.mResources.getColor(d.C0277d.form_button_font_color);
        this.ilk = this.mResources.getColor(d.C0277d.form_button_grey_bg_color);
        this.ilj = -1;
        this.ill = -1;
        this.ile = -1;
        this.ikW = this.mResources.getDrawable(d.f.form_frame_white);
        this.ikX = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.ilm = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.ilm.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.ilm.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.ilm.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.ilm;
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
    public int bXp() {
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

    public void aL(float f) {
        this.ikT = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.ikY = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.ikT);
        this.ikZ = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.ikT);
        this.ila = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.ikT);
        this.ilb = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.ikT);
        this.ilc = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.ikT);
        this.ild = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.ikT);
        this.alQ = (int) (this.ikT * dimension);
        this.ilg = (int) (this.ikT * dimension2);
        this.ilh = (int) (this.ikT * dimension3);
    }
}
