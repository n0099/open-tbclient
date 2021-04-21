package com.baidu.tieba.video.editvideo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import d.b.c.e.p.l;
import d.b.i0.z0.i0;
import d.b.j0.q3.j.c.a;
import d.b.j0.q3.j.f.b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class CoverPendantDragView extends FrameLayout {
    public float A;
    public float B;
    public float C;
    public d.b.j0.q3.j.h.c D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int I;
    public boolean J;
    public float K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public float R;
    public int S;
    public float T;
    public int U;
    public Map<String, Bitmap> V;
    public Bitmap W;
    public long a0;
    public float b0;
    public float c0;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f21458e;

    /* renamed from: f  reason: collision with root package name */
    public RotateFrameLayout f21459f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f21460g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21461h;
    public EditText i;
    public ImageView j;
    public ImageView k;
    public int l;
    public int m;
    public int n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public boolean t;
    public float u;
    public float v;
    public int w;
    public int x;
    public float y;
    public float z;

    /* loaded from: classes5.dex */
    public class a implements View.OnTouchListener {

        /* renamed from: e  reason: collision with root package name */
        public long f21462e = 0;

        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f21462e = System.currentTimeMillis();
                CoverPendantDragView.this.J(view, motionEvent);
                if (CoverPendantDragView.this.l == 4) {
                    CoverPendantDragView.this.R();
                }
            } else if (action == 1) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - CoverPendantDragView.this.p);
                float abs2 = Math.abs(rawY - CoverPendantDragView.this.q);
                if (!CoverPendantDragView.this.t && abs < CoverPendantDragView.this.o && abs2 < CoverPendantDragView.this.o && System.currentTimeMillis() - this.f21462e < 300) {
                    CoverPendantDragView.this.S();
                }
                CoverPendantDragView.this.u = 0.0f;
                CoverPendantDragView.this.v = 0.0f;
                CoverPendantDragView.this.t = false;
            } else if (action != 2) {
                if (action == 6) {
                    CoverPendantDragView.this.u = 0.0f;
                    CoverPendantDragView.this.v = 0.0f;
                }
            } else if (!CoverPendantDragView.this.C(motionEvent)) {
                CoverPendantDragView.this.F(motionEvent);
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CoverPendantDragView.this.i.setText("");
            CoverPendantDragView.this.A();
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnTouchListener {
        public c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                CoverPendantDragView.this.J(view, motionEvent);
            } else if (action != 1) {
                if (action == 2 && !CoverPendantDragView.this.C(motionEvent)) {
                    CoverPendantDragView.this.O(motionEvent);
                }
            } else {
                CoverPendantDragView.this.v = 0.0f;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (CoverPendantDragView.this.l != 4) {
                String E = CoverPendantDragView.this.E(CoverPendantDragView.this.f21461h.getPaint(), obj);
                if (!E.equals(obj)) {
                    editable.delete(E.length(), obj.length());
                    l.K(CoverPendantDragView.this.getContext(), R.string.cover_text_length_max_tips);
                }
            } else if (i0.c(obj) < 20) {
                if (obj.length() > CoverPendantDragView.this.f21461h.getText().length()) {
                    CoverPendantDragView.this.M(obj);
                } else {
                    CoverPendantDragView.this.N(obj);
                }
            } else {
                String l = i0.l(obj, 20);
                editable.delete(l.length(), obj.length());
                CoverPendantDragView.this.M(l);
                l.K(CoverPendantDragView.this.getContext(), R.string.cover_pendant_length_max_tips);
            }
            CoverPendantDragView.this.f21461h.setText(editable.toString());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes5.dex */
    public class e implements TextView.OnEditorActionListener {
        public e() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return keyEvent.getKeyCode() == 66;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements b.InterfaceC1547b {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a.c> f21468a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<CoverPendantDragView> f21469b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<PendantData> f21470c;

        public f(a.c cVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            if (cVar != null) {
                this.f21468a = new WeakReference<>(cVar);
            }
            if (coverPendantDragView != null) {
                this.f21469b = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.f21470c = new WeakReference<>(pendantData);
            }
        }

        @Override // d.b.j0.q3.j.f.b.InterfaceC1547b
        public void a(String str) {
            WeakReference<a.c> weakReference = this.f21468a;
            if (weakReference != null && weakReference.get() != null) {
                this.f21468a.get().f61042c.setVisibility(8);
            }
            WeakReference<CoverPendantDragView> weakReference2 = this.f21469b;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            l.L(this.f21469b.get().getContext(), str);
        }

        @Override // d.b.j0.q3.j.f.b.InterfaceC1547b
        public void b() {
            WeakReference<a.c> weakReference = this.f21468a;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f21468a.get().f61042c.setVisibility(8);
        }

        @Override // d.b.j0.q3.j.f.b.InterfaceC1547b
        public void c(String str, String str2) {
            WeakReference<PendantData> weakReference;
            WeakReference<a.c> weakReference2 = this.f21468a;
            if (weakReference2 != null && weakReference2.get() != null) {
                this.f21468a.get().f61042c.setVisibility(8);
            }
            WeakReference<CoverPendantDragView> weakReference3 = this.f21469b;
            if (weakReference3 == null || weakReference3.get() == null || (weakReference = this.f21470c) == null || weakReference.get() == null) {
                return;
            }
            this.f21469b.get().G(str2, this.f21470c.get());
        }
    }

    public CoverPendantDragView(Context context) {
        this(context, null);
    }

    public void A() {
        this.f21461h.setText(this.i.getText());
        this.f21461h.setVisibility(0);
        this.i.setVisibility(8);
        setEditTextEnable(false);
        if (TextUtils.isEmpty(this.f21461h.getText())) {
            this.l = 0;
            this.f21458e.setVisibility(8);
        }
        if (this.l == 4) {
            z();
        }
        this.D.HidenSoftKeyPad(this.i);
    }

    public final void B() {
        this.f21459f = (RotateFrameLayout) this.f21458e.findViewById(R.id.content_container);
        this.f21461h = (TextView) this.f21458e.findViewById(R.id.cover_text);
        this.f21460g = (FrameLayout) this.f21458e.findViewById(R.id.content_view);
        this.i = (EditText) this.f21458e.findViewById(R.id.cover_edit);
        this.j = (ImageView) this.f21458e.findViewById(R.id.cover_delete);
        this.k = (ImageView) this.f21458e.findViewById(R.id.cover_scale);
    }

    public final boolean C(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getRawX() - this.p);
        float abs2 = Math.abs(motionEvent.getRawY() - this.q);
        float f2 = this.o;
        return abs < f2 && abs2 < f2;
    }

    public final void D(String str, float f2) {
        TextPaint paint = this.i.getPaint();
        float measureText = paint.measureText(str);
        while (measureText > f2) {
            setTextSize(0, this.i.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    public final String E(TextPaint textPaint, String str) {
        float measureText = textPaint.measureText(str);
        while (str.length() > 0 && measureText > this.m - l.g(getContext(), R.dimen.ds120)) {
            str = i0.m(str, i0.d(str) - 1);
            measureText = textPaint.measureText(str);
        }
        return str;
    }

    public final void F(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.l != 4) {
            float y = (this.f21458e.getY() + rawY) - this.s;
            float f2 = this.F;
            if (y < f2) {
                y = f2;
            } else if (y > (f2 + this.n) - this.f21458e.getHeight()) {
                y = (this.F + this.n) - this.f21458e.getHeight();
            }
            this.f21458e.setY(y);
        } else {
            int pointerCount = motionEvent.getPointerCount();
            if (pointerCount >= 2) {
                this.t = true;
                float y2 = y(motionEvent);
                float w = w(motionEvent);
                float f3 = this.u;
                if (f3 != 0.0f) {
                    int i = (int) (f3 - y2);
                    Q(i, (int) (i / this.A));
                }
                float f4 = this.v;
                if (f4 != 0.0f) {
                    FrameLayout frameLayout = this.f21458e;
                    frameLayout.setRotation(frameLayout.getRotation() - (f4 - w));
                }
                this.v = w;
                this.u = y2;
            } else if (!this.t && pointerCount == 1) {
                float y3 = (this.f21458e.getY() + rawY) - this.s;
                if (y3 < this.F - (this.f21458e.getHeight() / 2)) {
                    y3 = this.F - (this.f21458e.getHeight() / 2);
                } else if (y3 > ((this.F + this.n) - this.f21458e.getHeight()) + (this.f21458e.getHeight() / 2)) {
                    y3 = ((this.F + this.n) - this.f21458e.getHeight()) + (this.f21458e.getHeight() / 2);
                }
                float x = (this.f21458e.getX() + rawX) - this.r;
                if (x < this.E - (this.f21458e.getWidth() / 2)) {
                    x = this.E - (this.f21458e.getWidth() / 2);
                } else if (x > ((this.E + this.m) - this.f21458e.getWidth()) + (this.f21458e.getWidth() / 2)) {
                    x = ((this.E + this.m) - this.f21458e.getWidth()) + (this.f21458e.getWidth() / 2);
                }
                this.f21458e.setX(x);
                this.f21458e.setY(y3);
            }
        }
        this.r = rawX;
        this.s = rawY;
    }

    public final void G(String str, PendantData pendantData) {
        Map<String, Bitmap> map;
        if (TextUtils.isEmpty(str) || pendantData == null || (map = this.V) == null) {
            return;
        }
        Bitmap bitmap = map.get(str);
        if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
            this.V.put(str, bitmap);
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return;
        }
        z();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.B = 1.0f;
        this.C = 1.0f;
        int e2 = l.e(getContext(), width / 2);
        float f2 = e2;
        float f3 = height;
        float f4 = width;
        int i = (int) ((f2 * f3) / f4);
        int i2 = (this.m * 2) / 3;
        if (e2 > i2) {
            float f5 = i2;
            this.B = (f5 * 1.0f) / f2;
            i = (int) ((f5 * f3) / f4);
            e2 = i2;
        }
        this.f21460g.setBackgroundDrawable(new BitmapDrawable(bitmap));
        L(e2, i, this.I, pendantData);
        int i3 = this.P;
        int i4 = width + (i3 * 2);
        this.w = i4;
        int i5 = height + (i3 * 2);
        this.x = i5;
        this.A = (i4 * 1.0f) / i5;
        this.f21458e.setX((((this.m - e2) - (i3 * 2)) / 2) + this.E);
        this.f21458e.setY((((this.n - i) - (this.P * 2)) / 2) + this.F);
    }

    public final void H(PendantData pendantData) {
        z();
        L(this.m, l.g(getContext(), R.dimen.ds100), this.I, pendantData);
        int i = this.l;
        if (i == 4 || i == 0) {
            this.f21458e.setX(this.E);
            this.f21458e.setY(((this.n - l.g(getContext(), R.dimen.ds100)) / 2) + this.F);
            String obj = this.i.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            String E = E(this.i.getPaint(), obj);
            if (E.equals(obj)) {
                return;
            }
            this.f21461h.setText(E);
            this.i.setText(E);
        }
    }

    public void I() {
        for (Map.Entry<String, Bitmap> entry : this.V.entrySet()) {
            Bitmap value = entry.getValue();
            if (value != null && !value.isRecycled()) {
                value.recycle();
            }
        }
        this.V.clear();
        this.V = null;
        v();
    }

    public final void J(View view, MotionEvent motionEvent) {
        this.p = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        this.q = rawY;
        this.r = this.p;
        this.s = rawY;
        this.y = (this.f21458e.getWidth() / 2) + this.f21458e.getX();
        this.z = (this.f21458e.getHeight() / 2) + this.f21458e.getY();
        this.f21461h.setText(this.i.getText());
        this.f21461h.setVisibility(0);
        this.i.setVisibility(8);
        setEditTextEnable(false);
        this.D.HidenSoftKeyPad(this.i);
    }

    public void K(boolean z) {
        if (this.l == 0) {
            return;
        }
        if (z) {
            v();
            this.f21458e.setVisibility(0);
            return;
        }
        A();
        getTempBitmap();
        this.f21458e.setVisibility(8);
    }

    public void L(int i, int i2, int i3, PendantData pendantData) {
        if (pendantData.pendantType != 4) {
            this.i.setTextAppearance(getContext(), R.style.cover_text_style);
            this.f21461h.setTextAppearance(getContext(), R.style.cover_text_style);
            float f2 = i;
            float f3 = i3;
            i2 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * f2) / f3);
            setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * f2) / f3);
            this.P = 0;
            this.i.setMaxLines(1);
            this.f21461h.setMaxLines(1);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21461h.getLayoutParams();
            layoutParams.height = -1;
            layoutParams.width = -2;
            layoutParams.gravity = 17;
            this.i.setLayoutParams(layoutParams);
            this.f21460g.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
        } else {
            this.i.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.f21461h.setTextAppearance(getContext(), R.style.cover_pendant_style);
            this.P = l.g(getContext(), R.dimen.ds40);
            this.i.setMaxLines(2);
            this.f21461h.setMaxLines(2);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f21461h.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            layoutParams2.gravity = 17;
            this.i.setLayoutParams(layoutParams2);
            this.L = (int) (l.e(getContext(), pendantData.left) * this.B);
            this.M = (int) (l.e(getContext(), pendantData.top) * this.B);
            this.N = (int) (l.e(getContext(), pendantData.right) * this.B);
            int e2 = (int) (l.e(getContext(), pendantData.bottom) * this.B);
            this.O = e2;
            this.f21460g.setPadding(this.L, this.M, this.N, e2);
            this.K = l.g(getContext(), R.dimen.fontsize40) * this.B;
            String text = getText();
            this.Q = (i2 - this.M) - this.O;
            this.R = (i - this.L) - this.N;
            this.T = this.S + l.g(getContext(), R.dimen.ds6);
            setTextSize(0, this.K);
            if (TextUtils.isEmpty(text)) {
                D(getContext().getString(R.string.cover_hint), this.R);
                this.K = this.i.getTextSize();
                R();
                S();
            } else {
                if (i0.c(text) > 20) {
                    text = i0.l(text, 20);
                    this.i.setText(text);
                    this.f21461h.setText(text);
                }
                M(text);
            }
        }
        this.f21461h.setIncludeFontPadding(false);
        this.i.setIncludeFontPadding(false);
        this.f21461h.setLineSpacing(this.S, 1.0f);
        this.i.setLineSpacing(this.S, 1.0f);
        this.f21458e.setRotation(0.0f);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f21458e.getLayoutParams();
        int i4 = this.P;
        layoutParams3.height = i2 + (i4 * 2);
        layoutParams3.width = (i4 * 2) + i;
        this.f21458e.setLayoutParams(layoutParams3);
        this.U = i + (this.P * 2);
        int i5 = this.P;
        ((FrameLayout.LayoutParams) this.f21459f.getLayoutParams()).setMargins(i5, i5, i5, i5);
        this.f21458e.setVisibility(0);
    }

    public final void M(String str) {
        TextPaint paint = this.i.getPaint();
        float measureText = paint.measureText(str);
        while (true) {
            float textSize = this.i.getTextSize();
            float f2 = this.Q;
            float f3 = this.C;
            if (textSize <= ((f2 * f3) / 2.0f) - (this.T * f3) || measureText <= this.R * f3) {
                return;
            }
            setTextSize(0, this.i.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    public final void N(String str) {
        TextPaint paint = this.i.getPaint();
        float measureText = paint.measureText(str);
        while (this.i.getLineCount() == 1) {
            float textSize = this.i.getTextSize();
            float f2 = this.K;
            float f3 = this.C;
            if (textSize >= f2 * f3 || measureText >= this.R * f3) {
                break;
            }
            setTextSize(0, this.i.getTextSize() + 1.0f);
            measureText = paint.measureText(str);
        }
        if (i0.c(str) <= i0.c(getResources().getString(R.string.cover_hint))) {
            float textSize2 = this.i.getTextSize();
            float f4 = this.K;
            float f5 = this.C;
            if (textSize2 != f4 * f5) {
                setTextSize(0, f4 * f5);
            }
        }
    }

    public final void O(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float x = x(motionEvent);
        float abs = Math.abs(this.r - rawX);
        float abs2 = Math.abs(this.s - rawY);
        int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
        float abs3 = Math.abs(this.y - rawX);
        float abs4 = Math.abs(this.z - rawY);
        int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
        float abs5 = Math.abs(this.y - this.r);
        float abs6 = Math.abs(this.z - this.s);
        if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
            sqrt = -sqrt;
        }
        Q(sqrt, (int) (sqrt / this.A));
        float f2 = this.v;
        if (f2 != 0.0f) {
            FrameLayout frameLayout = this.f21458e;
            frameLayout.setRotation(frameLayout.getRotation() - (f2 - x));
        }
        this.v = x;
        this.r = rawX;
        this.s = rawY;
    }

    public final void P() {
        buildDrawingCache();
        Bitmap drawingCache = getDrawingCache();
        if (drawingCache != null) {
            this.W = Bitmap.createBitmap(drawingCache);
        }
        destroyDrawingCache();
    }

    public final void Q(int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f21458e.getLayoutParams();
        int width = this.f21458e.getWidth() - i;
        float f2 = this.A;
        int i3 = (int) (width / f2);
        int i4 = this.w;
        if (width < i4) {
            i3 = (int) (i4 / f2);
            width = i4;
        }
        int i5 = this.P;
        float f3 = ((width * 1.0f) - (i5 * 2)) / (this.U - (i5 * 2));
        this.C = f3;
        this.f21460g.setPadding((int) (this.L * f3), (int) (this.M * f3), (int) (this.N * f3), (int) (this.O * f3));
        setTextSize(0, (this.i.getTextSize() * i3) / this.f21458e.getHeight());
        layoutParams.width = width;
        layoutParams.height = i3;
        this.f21458e.setLayoutParams(layoutParams);
        float f4 = this.y - (layoutParams.width / 2);
        float f5 = this.z - (layoutParams.height / 2);
        this.f21458e.setX(f4);
        this.f21458e.setY(f5);
    }

    public final void R() {
        if (this.J) {
            return;
        }
        this.J = true;
        this.j.setVisibility(0);
        this.k.setVisibility(0);
        this.f21459f.setBackgroundResource(R.drawable.bg_cover_pendant_container);
    }

    public void S() {
        this.f21461h.setText(this.i.getText());
        this.f21461h.setVisibility(8);
        this.i.setVisibility(0);
        setEditTextEnable(true);
        this.D.ShowSoftKeyPad(this.i);
    }

    public Bitmap getTempBitmap() {
        if (this.W == null) {
            P();
        }
        return this.W;
    }

    public String getText() {
        TextView textView = this.f21461h;
        if (textView == null || textView.getText() == null) {
            return null;
        }
        return this.f21461h.getText().toString();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.m == 0 && this.n == 0) {
            this.m = getMeasuredWidth();
            this.n = getMeasuredHeight();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a0 = System.currentTimeMillis();
            this.b0 = motionEvent.getRawX();
            this.c0 = motionEvent.getRawY();
        } else if (action == 1) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float abs = Math.abs(rawX - this.b0);
            float abs2 = Math.abs(rawY - this.c0);
            if (motionEvent.getPointerCount() <= 1) {
                float f2 = this.o;
                if (abs < f2 && abs2 < f2 && System.currentTimeMillis() - this.a0 < 300) {
                    A();
                }
            }
        }
        return true;
    }

    public void setEditTextEnable(boolean z) {
        if (z) {
            this.i.setFocusable(true);
            this.i.setFocusableInTouchMode(true);
            this.i.requestFocus();
            return;
        }
        this.i.setFocusable(false);
        this.i.setFocusableInTouchMode(false);
    }

    public void setParentViewController(d.b.j0.q3.j.h.c cVar) {
        this.D = cVar;
    }

    public void setTextSize(int i, float f2) {
        if (this.i.getTextSize() != f2) {
            this.i.setTextSize(i, f2);
        }
        if (this.f21461h.getTextSize() != f2) {
            this.f21461h.setTextSize(i, f2);
        }
    }

    public void setVideoLocation(float f2, float f3, float f4, float f5) {
        this.E = f2;
        this.F = f3;
        this.G = f4;
        this.H = f5;
        if (f2 > 0.0f) {
            View view = new View(getContext());
            view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.E, -1);
            layoutParams.gravity = 3;
            addView(view, layoutParams);
        }
        if (this.F > 0.0f) {
            View view2 = new View(getContext());
            view2.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.F);
            layoutParams2.gravity = 48;
            addView(view2, layoutParams2);
        }
        if (this.G > 0.0f) {
            View view3 = new View(getContext());
            view3.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.G) - this.m, -1);
            layoutParams3.gravity = 5;
            addView(view3, layoutParams3);
        }
        if (this.H > 0.0f) {
            View view4 = new View(getContext());
            view4.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.H) - this.n);
            layoutParams4.gravity = 80;
            addView(view4, layoutParams4);
        }
    }

    public void setVideoSize(int i, int i2) {
        this.m = i;
        this.n = i2;
    }

    public final float[] t(MotionEvent motionEvent, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f21458e.getRotation());
        float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
        matrix.mapPoints(fArr);
        return fArr;
    }

    public void u(View view, PendantData pendantData) {
        if (pendantData == null) {
            return;
        }
        int i = pendantData.pendantType;
        if (i == 0) {
            this.i.setText("");
            A();
        } else if (i == 1) {
            H(pendantData);
            this.f21460g.setBackgroundResource(R.drawable.bg_cover_edit_blue);
            S();
        } else if (i == 2) {
            H(pendantData);
            this.f21460g.setBackgroundResource(R.drawable.bg_cover_edit_black);
            S();
        } else if (i != 3) {
            A();
            String f2 = d.b.j0.q3.j.f.b.g().f(pendantData.resource);
            if (TextUtils.isEmpty(f2)) {
                if (view != null && (view.getTag() instanceof a.c)) {
                    a.c cVar = (a.c) view.getTag();
                    cVar.f61042c.setVisibility(0);
                    d.b.j0.q3.j.f.b.g().e(pendantData.id, pendantData.resource, new f(cVar, this, pendantData));
                }
            } else {
                G(f2, pendantData);
            }
        } else {
            H(pendantData);
            this.f21460g.setBackgroundDrawable(null);
            S();
        }
        this.l = pendantData.pendantType;
    }

    public void v() {
        Bitmap bitmap = this.W;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        this.W.recycle();
        this.W = null;
    }

    public final float w(MotionEvent motionEvent) {
        float[] t = t(motionEvent, 0);
        float f2 = t[0];
        float f3 = t[1];
        float[] t2 = t(motionEvent, 1);
        float f4 = t2[0];
        return (float) Math.toDegrees(Math.atan2(f3 - t2[1], f2 - f4));
    }

    public final float x(MotionEvent motionEvent) {
        return (float) Math.toDegrees(Math.atan2(this.z - motionEvent.getRawY(), this.y - motionEvent.getRawX()));
    }

    public final float y(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    public final void z() {
        if (this.J) {
            this.J = false;
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            this.f21459f.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = 0;
        this.B = 1.0f;
        this.C = 1.0f;
        this.J = true;
        this.V = new HashMap();
        this.a0 = 0L;
        this.b0 = 0.0f;
        this.c0 = 0.0f;
        this.I = l.k(TbadkCoreApplication.getInst());
        this.K = l.g(getContext(), R.dimen.fontsize40);
        this.S = l.g(getContext(), R.dimen.ds2);
        this.o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f21458e = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        B();
        addView(this.f21458e);
        this.f21458e.setOnTouchListener(new a());
        this.j.setOnClickListener(new b());
        this.k.setOnTouchListener(new c());
        this.i.addTextChangedListener(new d());
        this.i.setOnEditorActionListener(new e());
        this.f21458e.setVisibility(8);
    }
}
