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
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import c.a.t0.d1.p0;
import c.a.u0.n4.i.c.a;
import c.a.u0.n4.i.f.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes13.dex */
public class CoverPendantDragView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public c.a.u0.n4.i.h.c D;
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
    public FrameLayout f48729e;

    /* renamed from: f  reason: collision with root package name */
    public RotateFrameLayout f48730f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f48731g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48732h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f48733i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f48734j;
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

    /* loaded from: classes13.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f48735e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f48736f;

        public a(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48736f = coverPendantDragView;
            this.f48735e = 0L;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f48735e = System.currentTimeMillis();
                    this.f48736f.F(view, motionEvent);
                    if (this.f48736f.l == 4) {
                        this.f48736f.L();
                    }
                } else if (action == 1) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float abs = Math.abs(rawX - this.f48736f.p);
                    float abs2 = Math.abs(rawY - this.f48736f.q);
                    if (!this.f48736f.t && abs < this.f48736f.o && abs2 < this.f48736f.o && System.currentTimeMillis() - this.f48735e < 300) {
                        this.f48736f.showSoftKeyPad();
                    }
                    this.f48736f.u = 0.0f;
                    this.f48736f.v = 0.0f;
                    this.f48736f.t = false;
                } else if (action != 2) {
                    if (action == 6) {
                        this.f48736f.u = 0.0f;
                        this.f48736f.v = 0.0f;
                    }
                } else if (!this.f48736f.z(motionEvent)) {
                    this.f48736f.C(motionEvent);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f48737e;

        public b(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48737e = coverPendantDragView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f48737e.f48733i.setText("");
                this.f48737e.hideSoftKeyPad();
            }
        }
    }

    /* loaded from: classes13.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f48738e;

        public c(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48738e = coverPendantDragView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f48738e.F(view, motionEvent);
                } else if (action != 1) {
                    if (action == 2 && !this.f48738e.z(motionEvent)) {
                        this.f48738e.I(motionEvent);
                    }
                } else {
                    this.f48738e.v = 0.0f;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f48739e;

        public d(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48739e = coverPendantDragView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (this.f48739e.l != 4) {
                    String B = this.f48739e.B(this.f48739e.f48732h.getPaint(), obj);
                    if (!B.equals(obj)) {
                        editable.delete(B.length(), obj.length());
                        n.M(this.f48739e.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (p0.c(obj) < 20) {
                    if (obj.length() > this.f48739e.f48732h.getText().length()) {
                        this.f48739e.G(obj);
                    } else {
                        this.f48739e.H(obj);
                    }
                } else {
                    String m = p0.m(obj, 20);
                    editable.delete(m.length(), obj.length());
                    this.f48739e.G(m);
                    n.M(this.f48739e.getContext(), R.string.cover_pendant_length_max_tips);
                }
                this.f48739e.f48732h.setText(editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2, i3, i4) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i2, i3, i4) == null) {
            }
        }
    }

    /* loaded from: classes13.dex */
    public class e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverPendantDragView a;

        public e(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverPendantDragView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) ? keyEvent.getKeyCode() == 66 : invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes13.dex */
    public static class f implements b.InterfaceC1223b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<a.c> a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<CoverPendantDragView> f48740b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<PendantData> f48741c;

        public f(a.c cVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, coverPendantDragView, pendantData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (cVar != null) {
                this.a = new WeakReference<>(cVar);
            }
            if (coverPendantDragView != null) {
                this.f48740b = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.f48741c = new WeakReference<>(pendantData);
            }
        }

        @Override // c.a.u0.n4.i.f.b.InterfaceC1223b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                WeakReference<a.c> weakReference = this.a;
                if (weakReference != null && weakReference.get() != null) {
                    this.a.get().f19815c.setVisibility(8);
                }
                WeakReference<CoverPendantDragView> weakReference2 = this.f48740b;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                n.N(this.f48740b.get().getContext(), str);
            }
        }

        @Override // c.a.u0.n4.i.f.b.InterfaceC1223b
        public void b() {
            WeakReference<a.c> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.a) == null || weakReference.get() == null) {
                return;
            }
            this.a.get().f19815c.setVisibility(8);
        }

        @Override // c.a.u0.n4.i.f.b.InterfaceC1223b
        public void c(String str, String str2) {
            WeakReference<PendantData> weakReference;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                WeakReference<a.c> weakReference2 = this.a;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.a.get().f19815c.setVisibility(8);
                }
                WeakReference<CoverPendantDragView> weakReference3 = this.f48740b;
                if (weakReference3 == null || weakReference3.get() == null || (weakReference = this.f48741c) == null || weakReference.get() == null) {
                    return;
                }
                this.f48740b.get().D(str2, this.f48741c.get());
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverPendantDragView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void A(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, str, f2) == null) {
            TextPaint paint = this.f48733i.getPaint();
            float measureText = paint.measureText(str);
            while (measureText > f2) {
                setTextSize(0, this.f48733i.getTextSize() - 1.0f);
                measureText = paint.measureText(str);
            }
        }
    }

    public final String B(TextPaint textPaint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint, str)) == null) {
            float measureText = textPaint.measureText(str);
            while (str.length() > 0 && measureText > this.m - n.f(getContext(), R.dimen.ds120)) {
                str = p0.n(str, p0.d(str) - 1);
                measureText = textPaint.measureText(str);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public final void C(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (this.l != 4) {
                float y = (this.f48729e.getY() + rawY) - this.s;
                float f2 = this.F;
                if (y < f2) {
                    y = f2;
                } else if (y > (f2 + this.n) - this.f48729e.getHeight()) {
                    y = (this.F + this.n) - this.f48729e.getHeight();
                }
                this.f48729e.setY(y);
            } else {
                int pointerCount = motionEvent.getPointerCount();
                if (pointerCount >= 2) {
                    this.t = true;
                    float w = w(motionEvent);
                    float u = u(motionEvent);
                    float f3 = this.u;
                    if (f3 != 0.0f) {
                        int i2 = (int) (f3 - w);
                        K(i2, (int) (i2 / this.A));
                    }
                    float f4 = this.v;
                    if (f4 != 0.0f) {
                        FrameLayout frameLayout = this.f48729e;
                        frameLayout.setRotation(frameLayout.getRotation() - (f4 - u));
                    }
                    this.v = u;
                    this.u = w;
                } else if (!this.t && pointerCount == 1) {
                    float y2 = (this.f48729e.getY() + rawY) - this.s;
                    if (y2 < this.F - (this.f48729e.getHeight() / 2)) {
                        y2 = this.F - (this.f48729e.getHeight() / 2);
                    } else if (y2 > ((this.F + this.n) - this.f48729e.getHeight()) + (this.f48729e.getHeight() / 2)) {
                        y2 = ((this.F + this.n) - this.f48729e.getHeight()) + (this.f48729e.getHeight() / 2);
                    }
                    float x = (this.f48729e.getX() + rawX) - this.r;
                    if (x < this.E - (this.f48729e.getWidth() / 2)) {
                        x = this.E - (this.f48729e.getWidth() / 2);
                    } else if (x > ((this.E + this.m) - this.f48729e.getWidth()) + (this.f48729e.getWidth() / 2)) {
                        x = ((this.E + this.m) - this.f48729e.getWidth()) + (this.f48729e.getWidth() / 2);
                    }
                    this.f48729e.setX(x);
                    this.f48729e.setY(y2);
                }
            }
            this.r = rawX;
            this.s = rawY;
        }
    }

    public final void D(String str, PendantData pendantData) {
        Map<String, Bitmap> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, str, pendantData) == null) || TextUtils.isEmpty(str) || pendantData == null || (map = this.V) == null) {
            return;
        }
        Bitmap bitmap = map.get(str);
        if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
            this.V.put(str, bitmap);
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return;
        }
        x();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.B = 1.0f;
        this.C = 1.0f;
        int d2 = n.d(getContext(), width / 2);
        float f2 = d2;
        float f3 = height;
        float f4 = width;
        int i2 = (int) ((f2 * f3) / f4);
        int i3 = (this.m * 2) / 3;
        if (d2 > i3) {
            float f5 = i3;
            this.B = (f5 * 1.0f) / f2;
            i2 = (int) ((f5 * f3) / f4);
            d2 = i3;
        }
        this.f48731g.setBackgroundDrawable(new BitmapDrawable(bitmap));
        resizeTextAndContainer(d2, i2, this.I, pendantData);
        int i4 = this.P;
        int i5 = width + (i4 * 2);
        this.w = i5;
        int i6 = height + (i4 * 2);
        this.x = i6;
        this.A = (i5 * 1.0f) / i6;
        this.f48729e.setX((((this.m - d2) - (i4 * 2)) / 2) + this.E);
        this.f48729e.setY((((this.n - i2) - (this.P * 2)) / 2) + this.F);
    }

    public final void E(PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pendantData) == null) {
            x();
            resizeTextAndContainer(this.m, n.f(getContext(), R.dimen.ds100), this.I, pendantData);
            int i2 = this.l;
            if (i2 == 4 || i2 == 0) {
                this.f48729e.setX(this.E);
                this.f48729e.setY(((this.n - n.f(getContext(), R.dimen.ds100)) / 2) + this.F);
                String obj = this.f48733i.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                String B = B(this.f48733i.getPaint(), obj);
                if (B.equals(obj)) {
                    return;
                }
                this.f48732h.setText(B);
                this.f48733i.setText(B);
            }
        }
    }

    public final void F(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, motionEvent) == null) {
            this.p = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            this.q = rawY;
            this.r = this.p;
            this.s = rawY;
            this.y = (this.f48729e.getWidth() / 2) + this.f48729e.getX();
            this.z = (this.f48729e.getHeight() / 2) + this.f48729e.getY();
            this.f48732h.setText(this.f48733i.getText());
            this.f48732h.setVisibility(0);
            this.f48733i.setVisibility(8);
            setEditTextEnable(false);
            this.D.HidenSoftKeyPad(this.f48733i);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        TextPaint paint = this.f48733i.getPaint();
        float measureText = paint.measureText(str);
        while (true) {
            float textSize = this.f48733i.getTextSize();
            float f2 = this.Q;
            float f3 = this.C;
            if (textSize <= ((f2 * f3) / 2.0f) - (this.T * f3) || measureText <= this.R * f3) {
                return;
            }
            setTextSize(0, this.f48733i.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            TextPaint paint = this.f48733i.getPaint();
            float measureText = paint.measureText(str);
            while (this.f48733i.getLineCount() == 1) {
                float textSize = this.f48733i.getTextSize();
                float f2 = this.K;
                float f3 = this.C;
                if (textSize >= f2 * f3 || measureText >= this.R * f3) {
                    break;
                }
                setTextSize(0, this.f48733i.getTextSize() + 1.0f);
                measureText = paint.measureText(str);
            }
            if (p0.c(str) <= p0.c(getResources().getString(R.string.cover_hint))) {
                float textSize2 = this.f48733i.getTextSize();
                float f4 = this.K;
                float f5 = this.C;
                if (textSize2 != f4 * f5) {
                    setTextSize(0, f4 * f5);
                }
            }
        }
    }

    public final void I(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent) == null) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float v = v(motionEvent);
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
            K(sqrt, (int) (sqrt / this.A));
            float f2 = this.v;
            if (f2 != 0.0f) {
                FrameLayout frameLayout = this.f48729e;
                frameLayout.setRotation(frameLayout.getRotation() - (f2 - v));
            }
            this.v = v;
            this.r = rawX;
            this.s = rawY;
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            buildDrawingCache();
            Bitmap drawingCache = getDrawingCache();
            if (drawingCache != null) {
                this.W = Bitmap.createBitmap(drawingCache);
            }
            destroyDrawingCache();
        }
    }

    public final void K(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048586, this, i2, i3) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f48729e.getLayoutParams();
            int width = this.f48729e.getWidth() - i2;
            float f2 = this.A;
            int i4 = (int) (width / f2);
            int i5 = this.w;
            if (width < i5) {
                i4 = (int) (i5 / f2);
                width = i5;
            }
            int i6 = this.P;
            float f3 = ((width * 1.0f) - (i6 * 2)) / (this.U - (i6 * 2));
            this.C = f3;
            this.f48731g.setPadding((int) (this.L * f3), (int) (this.M * f3), (int) (this.N * f3), (int) (this.O * f3));
            setTextSize(0, (this.f48733i.getTextSize() * i4) / this.f48729e.getHeight());
            layoutParams.width = width;
            layoutParams.height = i4;
            this.f48729e.setLayoutParams(layoutParams);
            float f4 = this.y - (layoutParams.width / 2);
            float f5 = this.z - (layoutParams.height / 2);
            this.f48729e.setX(f4);
            this.f48729e.setY(f5);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.J) {
            return;
        }
        this.J = true;
        this.f48734j.setVisibility(0);
        this.k.setVisibility(0);
        this.f48730f.setBackgroundResource(R.drawable.bg_cover_pendant_container);
    }

    public void changeEditState(View view, PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, view, pendantData) == null) || pendantData == null) {
            return;
        }
        int i2 = pendantData.pendantType;
        if (i2 == 0) {
            this.f48733i.setText("");
            hideSoftKeyPad();
        } else if (i2 == 1) {
            E(pendantData);
            this.f48731g.setBackgroundResource(R.drawable.bg_cover_edit_blue);
            showSoftKeyPad();
        } else if (i2 == 2) {
            E(pendantData);
            this.f48731g.setBackgroundResource(R.drawable.bg_cover_edit_black);
            showSoftKeyPad();
        } else if (i2 != 3) {
            hideSoftKeyPad();
            String f2 = c.a.u0.n4.i.f.b.g().f(pendantData.resource);
            if (TextUtils.isEmpty(f2)) {
                if (view != null && (view.getTag() instanceof a.c)) {
                    a.c cVar = (a.c) view.getTag();
                    cVar.f19815c.setVisibility(0);
                    c.a.u0.n4.i.f.b.g().e(pendantData.id, pendantData.resource, new f(cVar, this, pendantData));
                }
            } else {
                D(f2, pendantData);
            }
        } else {
            E(pendantData);
            this.f48731g.setBackgroundDrawable(null);
            showSoftKeyPad();
        }
        this.l = pendantData.pendantType;
    }

    public void clearTempBitmap() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (bitmap = this.W) == null || bitmap.isRecycled()) {
            return;
        }
        this.W.recycle();
        this.W = null;
    }

    public Bitmap getTempBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.W == null) {
                J();
            }
            return this.W;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            TextView textView = this.f48732h;
            if (textView == null || textView.getText() == null) {
                return null;
            }
            return this.f48732h.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    public void hideSoftKeyPad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f48732h.setText(this.f48733i.getText());
            this.f48732h.setVisibility(0);
            this.f48733i.setVisibility(8);
            setEditTextEnable(false);
            if (TextUtils.isEmpty(this.f48732h.getText())) {
                this.l = 0;
                this.f48729e.setVisibility(8);
            }
            if (this.l == 4) {
                x();
            }
            this.D.HidenSoftKeyPad(this.f48733i);
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            for (Map.Entry<String, Bitmap> entry : this.V.entrySet()) {
                Bitmap value = entry.getValue();
                if (value != null && !value.isRecycled()) {
                    value.recycle();
                }
            }
            this.V.clear();
            this.V = null;
            clearTempBitmap();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048594, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.m == 0 && this.n == 0) {
                this.m = getMeasuredWidth();
                this.n = getMeasuredHeight();
            }
        }
    }

    public void onSelectChange(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048595, this, z) == null) || this.l == 0) {
            return;
        }
        if (z) {
            clearTempBitmap();
            this.f48729e.setVisibility(0);
            return;
        }
        hideSoftKeyPad();
        getTempBitmap();
        this.f48729e.setVisibility(8);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, motionEvent)) == null) {
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
                        hideSoftKeyPad();
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void resizeTextAndContainer(int i2, int i3, int i4, PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), pendantData}) == null) {
            if (pendantData.pendantType != 4) {
                this.f48733i.setTextAppearance(getContext(), R.style.cover_text_style);
                this.f48732h.setTextAppearance(getContext(), R.style.cover_text_style);
                float f2 = i2;
                float f3 = i4;
                i3 = (int) ((n.f(TbadkCoreApplication.getInst(), R.dimen.ds100) * f2) / f3);
                setTextSize(0, (n.f(getContext(), R.dimen.fontsize40) * f2) / f3);
                this.P = 0;
                this.f48733i.setMaxLines(1);
                this.f48732h.setMaxLines(1);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f48732h.getLayoutParams();
                layoutParams.height = -1;
                layoutParams.width = -2;
                layoutParams.gravity = 17;
                this.f48733i.setLayoutParams(layoutParams);
                this.f48731g.setPadding(n.f(getContext(), R.dimen.ds60), 0, n.f(getContext(), R.dimen.ds60), 0);
            } else {
                this.f48733i.setTextAppearance(getContext(), R.style.cover_pendant_style);
                this.f48732h.setTextAppearance(getContext(), R.style.cover_pendant_style);
                this.P = n.f(getContext(), R.dimen.ds40);
                this.f48733i.setMaxLines(2);
                this.f48732h.setMaxLines(2);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f48732h.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                layoutParams2.gravity = 17;
                this.f48733i.setLayoutParams(layoutParams2);
                this.L = (int) (n.d(getContext(), pendantData.left) * this.B);
                this.M = (int) (n.d(getContext(), pendantData.top) * this.B);
                this.N = (int) (n.d(getContext(), pendantData.right) * this.B);
                int d2 = (int) (n.d(getContext(), pendantData.bottom) * this.B);
                this.O = d2;
                this.f48731g.setPadding(this.L, this.M, this.N, d2);
                this.K = n.f(getContext(), R.dimen.fontsize40) * this.B;
                String text = getText();
                this.Q = (i3 - this.M) - this.O;
                this.R = (i2 - this.L) - this.N;
                this.T = this.S + n.f(getContext(), R.dimen.ds6);
                setTextSize(0, this.K);
                if (TextUtils.isEmpty(text)) {
                    A(getContext().getString(R.string.cover_hint), this.R);
                    this.K = this.f48733i.getTextSize();
                    L();
                    showSoftKeyPad();
                } else {
                    if (p0.c(text) > 20) {
                        text = p0.m(text, 20);
                        this.f48733i.setText(text);
                        this.f48732h.setText(text);
                    }
                    G(text);
                }
            }
            this.f48732h.setIncludeFontPadding(false);
            this.f48733i.setIncludeFontPadding(false);
            this.f48732h.setLineSpacing(this.S, 1.0f);
            this.f48733i.setLineSpacing(this.S, 1.0f);
            this.f48729e.setRotation(0.0f);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f48729e.getLayoutParams();
            int i5 = this.P;
            layoutParams3.height = i3 + (i5 * 2);
            layoutParams3.width = (i5 * 2) + i2;
            this.f48729e.setLayoutParams(layoutParams3);
            this.U = i2 + (this.P * 2);
            int i6 = this.P;
            ((FrameLayout.LayoutParams) this.f48730f.getLayoutParams()).setMargins(i6, i6, i6, i6);
            this.f48729e.setVisibility(0);
        }
    }

    public void setEditTextEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (z) {
                this.f48733i.setFocusable(true);
                this.f48733i.setFocusableInTouchMode(true);
                this.f48733i.requestFocus();
                return;
            }
            this.f48733i.setFocusable(false);
            this.f48733i.setFocusableInTouchMode(false);
        }
    }

    public void setParentViewController(c.a.u0.n4.i.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.D = cVar;
        }
    }

    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.f48733i.getTextSize() != f2) {
                this.f48733i.setTextSize(i2, f2);
            }
            if (this.f48732h.getTextSize() != f2) {
                this.f48732h.setTextSize(i2, f2);
            }
        }
    }

    public void setVideoLocation(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
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
    }

    public void setVideoSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048602, this, i2, i3) == null) {
            this.m = i2;
            this.n = i3;
        }
    }

    public void showSoftKeyPad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.f48732h.setText(this.f48733i.getText());
            this.f48732h.setVisibility(8);
            this.f48733i.setVisibility(0);
            setEditTextEnable(true);
            this.D.ShowSoftKeyPad(this.f48733i);
        }
    }

    public final float[] t(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, motionEvent, i2)) == null) {
            Matrix matrix = new Matrix();
            matrix.postRotate(this.f48729e.getRotation());
            float[] fArr = {motionEvent.getX(i2), motionEvent.getY(i2)};
            matrix.mapPoints(fArr);
            return fArr;
        }
        return (float[]) invokeLI.objValue;
    }

    public final float u(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, motionEvent)) == null) {
            float[] t = t(motionEvent, 0);
            float f2 = t[0];
            float f3 = t[1];
            float[] t2 = t(motionEvent, 1);
            return (float) Math.toDegrees(Math.atan2(f3 - t2[1], f2 - t2[0]));
        }
        return invokeL.floatValue;
    }

    public final float v(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, motionEvent)) == null) ? (float) Math.toDegrees(Math.atan2(this.z - motionEvent.getRawY(), this.y - motionEvent.getRawX())) : invokeL.floatValue;
    }

    public final float w(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048608, this) == null) && this.J) {
            this.J = false;
            this.f48734j.setVisibility(8);
            this.k.setVisibility(8);
            this.f48730f.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f48730f = (RotateFrameLayout) this.f48729e.findViewById(R.id.content_container);
            this.f48732h = (TextView) this.f48729e.findViewById(R.id.cover_text);
            this.f48731g = (FrameLayout) this.f48729e.findViewById(R.id.content_view);
            this.f48733i = (EditText) this.f48729e.findViewById(R.id.cover_edit);
            this.f48734j = (ImageView) this.f48729e.findViewById(R.id.cover_delete);
            this.k = (ImageView) this.f48729e.findViewById(R.id.cover_scale);
        }
    }

    public final boolean z(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.p);
            float abs2 = Math.abs(motionEvent.getRawY() - this.q);
            float f2 = this.o;
            return abs < f2 && abs2 < f2;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CoverPendantDragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.l = 0;
        this.B = 1.0f;
        this.C = 1.0f;
        this.J = true;
        this.V = new HashMap();
        this.a0 = 0L;
        this.b0 = 0.0f;
        this.c0 = 0.0f;
        this.I = n.k(TbadkCoreApplication.getInst());
        this.K = n.f(getContext(), R.dimen.fontsize40);
        this.S = n.f(getContext(), R.dimen.ds2);
        this.o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f48729e = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        y();
        addView(this.f48729e);
        this.f48729e.setOnTouchListener(new a(this));
        this.f48734j.setOnClickListener(new b(this));
        this.k.setOnTouchListener(new c(this));
        this.f48733i.addTextChangedListener(new d(this));
        this.f48733i.setOnEditorActionListener(new e(this));
        this.f48729e.setVisibility(8);
    }
}
