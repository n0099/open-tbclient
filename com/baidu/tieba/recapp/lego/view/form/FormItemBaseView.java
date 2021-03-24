package com.baidu.tieba.recapp.lego.view.form;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.recapp.lego.model.FormCard;
import com.baidu.tieba.recapp.lego.view.form.FormCardView;
/* loaded from: classes5.dex */
public abstract class FormItemBaseView extends RelativeLayout implements FormCardView.d {

    /* renamed from: e  reason: collision with root package name */
    public Context f20823e;

    /* renamed from: f  reason: collision with root package name */
    public Resources f20824f;

    /* renamed from: g  reason: collision with root package name */
    public int f20825g;

    /* renamed from: h  reason: collision with root package name */
    public int f20826h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;
    public int q;
    public int r;
    public int s;
    public View t;
    public String u;
    public Activity v;
    public float w;

    /* loaded from: classes5.dex */
    public enum DrawableType {
        ERROR_FRAME,
        ORDINARY_FRAME
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f20827a;

        static {
            int[] iArr = new int[DrawableType.values().length];
            f20827a = iArr;
            try {
                iArr[DrawableType.ERROR_FRAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20827a[DrawableType.ORDINARY_FRAME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public FormItemBaseView(Context context) {
        super(context);
        this.f20823e = null;
        this.f20824f = null;
        this.f20825g = 0;
        this.f20826h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = "";
        this.w = 1.0f;
        d(context);
    }

    public int b() {
        return -2;
    }

    public void c(View view, DrawableType drawableType) {
        this.t = view;
        int i = a.f20827a[drawableType.ordinal()];
        if (i == 1) {
            this.t.setBackgroundResource(R.drawable.form_frame_red);
        } else if (i != 2) {
            this.t.setBackgroundDrawable(null);
        } else {
            this.t.setBackgroundResource(R.drawable.form_frame_white);
        }
    }

    public final void d(Context context) {
        this.f20823e = context;
        this.v = (Activity) context;
        Resources resources = context.getApplicationContext().getResources();
        this.f20824f = resources;
        this.m = resources.getColor(R.color.form_font_color);
        this.q = this.f20824f.getColor(R.color.form_button_font_color);
        this.r = this.f20824f.getColor(R.color.form_button_grey_bg_color);
        this.s = -1;
        this.l = -1;
        this.f20824f.getDrawable(R.drawable.form_frame_white);
        this.f20824f.getDrawable(R.drawable.form_frame_red);
    }

    public void e() {
    }

    public void f(float f2) {
        this.w = f2;
        this.f20824f.getDimension(R.dimen.form_size90);
        float dimension = this.f20824f.getDimension(R.dimen.form_font_size28);
        float dimension2 = this.f20824f.getDimension(R.dimen.form_font_size20);
        float dimension3 = this.f20824f.getDimension(R.dimen.form_font_size36);
        float f3 = this.w;
        this.f20825g = (int) (((int) this.f20824f.getDimension(R.dimen.form_size20)) * f3);
        this.f20826h = (int) (((int) this.f20824f.getDimension(R.dimen.form_size40)) * f3);
        this.i = (int) (((int) this.f20824f.getDimension(R.dimen.form_size50)) * f3);
        this.j = (int) (((int) this.f20824f.getDimension(R.dimen.form_size80)) * f3);
        this.k = (int) (((int) this.f20824f.getDimension(R.dimen.form_size240)) * f3);
        this.n = (int) (dimension * f3);
        this.o = (int) (dimension2 * f3);
        this.p = (int) (dimension3 * f3);
    }

    public boolean g(FormCard.b bVar) {
        if (bVar != null && bVar.f20730a != -1 && !TextUtils.isEmpty(bVar.f20731b)) {
            setVisibility(0);
            e();
            this.u = bVar.f20732c;
            return true;
        }
        setVisibility(8);
        return false;
    }

    @Override // com.baidu.tieba.recapp.lego.view.form.FormCardView.d
    public FormItemBaseView getFormView() {
        return this;
    }

    public View getFrameView() {
        return this.t;
    }

    public abstract /* synthetic */ String getResult();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.View
    public String getTag() {
        return this.u;
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20823e = null;
        this.f20824f = null;
        this.f20825g = 0;
        this.f20826h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = "";
        this.w = 1.0f;
        d(context);
    }

    public FormItemBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20823e = null;
        this.f20824f = null;
        this.f20825g = 0;
        this.f20826h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0.0f;
        this.o = 0.0f;
        this.p = 0.0f;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = null;
        this.u = "";
        this.w = 1.0f;
        d(context);
    }
}
