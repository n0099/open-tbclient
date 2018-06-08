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
    protected int gnA;
    protected int gnB;
    protected int gnC;
    protected int gnD;
    protected int gnE;
    protected int gnF;
    protected int gnG;
    protected float gnH;
    protected float gnI;
    protected float gnJ;
    protected int gnK;
    protected int gnL;
    protected int gnM;
    protected int gnN;
    protected View gnO;
    protected float gnu;
    protected Drawable gnx;
    protected Drawable gny;
    protected int gnz;
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
        this.gnx = null;
        this.gny = null;
        this.gnz = 0;
        this.gnA = 0;
        this.gnB = 0;
        this.gnC = 0;
        this.gnD = 0;
        this.gnE = 0;
        this.gnF = 0;
        this.gnG = 0;
        this.gnH = 0.0f;
        this.gnI = 0.0f;
        this.gnJ = 0.0f;
        this.gnK = 0;
        this.gnL = 0;
        this.gnM = 0;
        this.gnN = 0;
        this.gnO = null;
        this.mTag = "";
        this.mActivity = null;
        this.gnu = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = null;
        this.mResources = null;
        this.gnx = null;
        this.gny = null;
        this.gnz = 0;
        this.gnA = 0;
        this.gnB = 0;
        this.gnC = 0;
        this.gnD = 0;
        this.gnE = 0;
        this.gnF = 0;
        this.gnG = 0;
        this.gnH = 0.0f;
        this.gnI = 0.0f;
        this.gnJ = 0.0f;
        this.gnK = 0;
        this.gnL = 0;
        this.gnM = 0;
        this.gnN = 0;
        this.gnO = null;
        this.mTag = "";
        this.mActivity = null;
        this.gnu = 1.0f;
        init(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = null;
        this.mResources = null;
        this.gnx = null;
        this.gny = null;
        this.gnz = 0;
        this.gnA = 0;
        this.gnB = 0;
        this.gnC = 0;
        this.gnD = 0;
        this.gnE = 0;
        this.gnF = 0;
        this.gnG = 0;
        this.gnH = 0.0f;
        this.gnI = 0.0f;
        this.gnJ = 0.0f;
        this.gnK = 0;
        this.gnL = 0;
        this.gnM = 0;
        this.gnN = 0;
        this.gnO = null;
        this.mTag = "";
        this.mActivity = null;
        this.gnu = 1.0f;
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.mActivity = (Activity) this.mContext;
        this.mResources = context.getApplicationContext().getResources();
        this.gnG = this.mResources.getColor(d.C0141d.form_font_color);
        this.gnK = this.mResources.getColor(d.C0141d.form_button_font_color);
        this.gnM = this.mResources.getColor(d.C0141d.form_button_grey_bg_color);
        this.gnL = -1;
        this.gnN = -1;
        this.gnF = -1;
        this.gnx = this.mResources.getDrawable(d.f.form_frame_white);
        this.gny = this.mResources.getDrawable(d.f.form_frame_red);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view, DrawableType drawableType) {
        this.gnO = view;
        switch (drawableType) {
            case ERROR_FRAME:
                this.gnO.setBackgroundResource(d.f.form_frame_red);
                return;
            case ORDINARY_FRAME:
                this.gnO.setBackgroundResource(d.f.form_frame_white);
                return;
            default:
                this.gnO.setBackgroundDrawable(null);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getFrameView() {
        return this.gnO;
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
    public int boS() {
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
        this.gnu = f;
        float dimension = this.mResources.getDimension(d.e.form_font_size28);
        float dimension2 = this.mResources.getDimension(d.e.form_font_size20);
        float dimension3 = this.mResources.getDimension(d.e.form_font_size36);
        this.gnz = (int) (((int) this.mResources.getDimension(d.e.form_size20)) * this.gnu);
        this.gnA = (int) (((int) this.mResources.getDimension(d.e.form_size40)) * this.gnu);
        this.gnB = (int) (((int) this.mResources.getDimension(d.e.form_size50)) * this.gnu);
        this.gnC = (int) (((int) this.mResources.getDimension(d.e.form_size80)) * this.gnu);
        this.gnD = (int) (((int) this.mResources.getDimension(d.e.form_size90)) * this.gnu);
        this.gnE = (int) (((int) this.mResources.getDimension(d.e.form_size240)) * this.gnu);
        this.gnH = (int) (this.gnu * dimension);
        this.gnI = (int) (this.gnu * dimension2);
        this.gnJ = (int) (this.gnu * dimension3);
    }
}
