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
import c.a.e.e.p.l;
import c.a.q0.d1.m0;
import c.a.r0.y3.i.c.a;
import c.a.r0.y3.i.f.b;
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
/* loaded from: classes7.dex */
public class CoverPendantDragView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public c.a.r0.y3.i.h.c D;
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
    public FrameLayout f57647e;

    /* renamed from: f  reason: collision with root package name */
    public RotateFrameLayout f57648f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f57649g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f57650h;

    /* renamed from: i  reason: collision with root package name */
    public EditText f57651i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f57652j;
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

    /* loaded from: classes7.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public long f57653e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f57654f;

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
            this.f57654f = coverPendantDragView;
            this.f57653e = 0L;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f57653e = System.currentTimeMillis();
                    this.f57654f.F(view, motionEvent);
                    if (this.f57654f.l == 4) {
                        this.f57654f.L();
                    }
                } else if (action == 1) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float abs = Math.abs(rawX - this.f57654f.p);
                    float abs2 = Math.abs(rawY - this.f57654f.q);
                    if (!this.f57654f.t && abs < this.f57654f.o && abs2 < this.f57654f.o && System.currentTimeMillis() - this.f57653e < 300) {
                        this.f57654f.showSoftKeyPad();
                    }
                    this.f57654f.u = 0.0f;
                    this.f57654f.v = 0.0f;
                    this.f57654f.t = false;
                } else if (action != 2) {
                    if (action == 6) {
                        this.f57654f.u = 0.0f;
                        this.f57654f.v = 0.0f;
                    }
                } else if (!this.f57654f.z(motionEvent)) {
                    this.f57654f.C(motionEvent);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f57655e;

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
            this.f57655e = coverPendantDragView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f57655e.f57651i.setText("");
                this.f57655e.hideSoftKeyPad();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f57656e;

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
            this.f57656e = coverPendantDragView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f57656e.F(view, motionEvent);
                } else if (action != 1) {
                    if (action == 2 && !this.f57656e.z(motionEvent)) {
                        this.f57656e.I(motionEvent);
                    }
                } else {
                    this.f57656e.v = 0.0f;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f57657e;

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
            this.f57657e = coverPendantDragView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (this.f57657e.l != 4) {
                    String B = this.f57657e.B(this.f57657e.f57650h.getPaint(), obj);
                    if (!B.equals(obj)) {
                        editable.delete(B.length(), obj.length());
                        l.L(this.f57657e.getContext(), R.string.cover_text_length_max_tips);
                    }
                } else if (m0.c(obj) < 20) {
                    if (obj.length() > this.f57657e.f57650h.getText().length()) {
                        this.f57657e.G(obj);
                    } else {
                        this.f57657e.H(obj);
                    }
                } else {
                    String l = m0.l(obj, 20);
                    editable.delete(l.length(), obj.length());
                    this.f57657e.G(l);
                    l.L(this.f57657e.getContext(), R.string.cover_pendant_length_max_tips);
                }
                this.f57657e.f57650h.setText(editable.toString());
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

    /* loaded from: classes7.dex */
    public class e implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f57658a;

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
            this.f57658a = coverPendantDragView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, keyEvent)) == null) ? keyEvent.getKeyCode() == 66 : invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public static class f implements b.InterfaceC1360b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<a.c> f57659a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<CoverPendantDragView> f57660b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<PendantData> f57661c;

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
                this.f57659a = new WeakReference<>(cVar);
            }
            if (coverPendantDragView != null) {
                this.f57660b = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.f57661c = new WeakReference<>(pendantData);
            }
        }

        @Override // c.a.r0.y3.i.f.b.InterfaceC1360b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                WeakReference<a.c> weakReference = this.f57659a;
                if (weakReference != null && weakReference.get() != null) {
                    this.f57659a.get().f29120c.setVisibility(8);
                }
                WeakReference<CoverPendantDragView> weakReference2 = this.f57660b;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                l.M(this.f57660b.get().getContext(), str);
            }
        }

        @Override // c.a.r0.y3.i.f.b.InterfaceC1360b
        public void b() {
            WeakReference<a.c> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.f57659a) == null || weakReference.get() == null) {
                return;
            }
            this.f57659a.get().f29120c.setVisibility(8);
        }

        @Override // c.a.r0.y3.i.f.b.InterfaceC1360b
        public void c(String str, String str2) {
            WeakReference<PendantData> weakReference;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                WeakReference<a.c> weakReference2 = this.f57659a;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f57659a.get().f29120c.setVisibility(8);
                }
                WeakReference<CoverPendantDragView> weakReference3 = this.f57660b;
                if (weakReference3 == null || weakReference3.get() == null || (weakReference = this.f57661c) == null || weakReference.get() == null) {
                    return;
                }
                this.f57660b.get().D(str2, this.f57661c.get());
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
            TextPaint paint = this.f57651i.getPaint();
            float measureText = paint.measureText(str);
            while (measureText > f2) {
                setTextSize(0, this.f57651i.getTextSize() - 1.0f);
                measureText = paint.measureText(str);
            }
        }
    }

    public final String B(TextPaint textPaint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textPaint, str)) == null) {
            float measureText = textPaint.measureText(str);
            while (str.length() > 0 && measureText > this.m - l.g(getContext(), R.dimen.ds120)) {
                str = m0.m(str, m0.d(str) - 1);
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
                float y = (this.f57647e.getY() + rawY) - this.s;
                float f2 = this.F;
                if (y < f2) {
                    y = f2;
                } else if (y > (f2 + this.n) - this.f57647e.getHeight()) {
                    y = (this.F + this.n) - this.f57647e.getHeight();
                }
                this.f57647e.setY(y);
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
                        FrameLayout frameLayout = this.f57647e;
                        frameLayout.setRotation(frameLayout.getRotation() - (f4 - u));
                    }
                    this.v = u;
                    this.u = w;
                } else if (!this.t && pointerCount == 1) {
                    float y2 = (this.f57647e.getY() + rawY) - this.s;
                    if (y2 < this.F - (this.f57647e.getHeight() / 2)) {
                        y2 = this.F - (this.f57647e.getHeight() / 2);
                    } else if (y2 > ((this.F + this.n) - this.f57647e.getHeight()) + (this.f57647e.getHeight() / 2)) {
                        y2 = ((this.F + this.n) - this.f57647e.getHeight()) + (this.f57647e.getHeight() / 2);
                    }
                    float x = (this.f57647e.getX() + rawX) - this.r;
                    if (x < this.E - (this.f57647e.getWidth() / 2)) {
                        x = this.E - (this.f57647e.getWidth() / 2);
                    } else if (x > ((this.E + this.m) - this.f57647e.getWidth()) + (this.f57647e.getWidth() / 2)) {
                        x = ((this.E + this.m) - this.f57647e.getWidth()) + (this.f57647e.getWidth() / 2);
                    }
                    this.f57647e.setX(x);
                    this.f57647e.setY(y2);
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
        int e2 = l.e(getContext(), width / 2);
        float f2 = e2;
        float f3 = height;
        float f4 = width;
        int i2 = (int) ((f2 * f3) / f4);
        int i3 = (this.m * 2) / 3;
        if (e2 > i3) {
            float f5 = i3;
            this.B = (f5 * 1.0f) / f2;
            i2 = (int) ((f5 * f3) / f4);
            e2 = i3;
        }
        this.f57649g.setBackgroundDrawable(new BitmapDrawable(bitmap));
        resizeTextAndContainer(e2, i2, this.I, pendantData);
        int i4 = this.P;
        int i5 = width + (i4 * 2);
        this.w = i5;
        int i6 = height + (i4 * 2);
        this.x = i6;
        this.A = (i5 * 1.0f) / i6;
        this.f57647e.setX((((this.m - e2) - (i4 * 2)) / 2) + this.E);
        this.f57647e.setY((((this.n - i2) - (this.P * 2)) / 2) + this.F);
    }

    public final void E(PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, pendantData) == null) {
            x();
            resizeTextAndContainer(this.m, l.g(getContext(), R.dimen.ds100), this.I, pendantData);
            int i2 = this.l;
            if (i2 == 4 || i2 == 0) {
                this.f57647e.setX(this.E);
                this.f57647e.setY(((this.n - l.g(getContext(), R.dimen.ds100)) / 2) + this.F);
                String obj = this.f57651i.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                String B = B(this.f57651i.getPaint(), obj);
                if (B.equals(obj)) {
                    return;
                }
                this.f57650h.setText(B);
                this.f57651i.setText(B);
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
            this.y = (this.f57647e.getWidth() / 2) + this.f57647e.getX();
            this.z = (this.f57647e.getHeight() / 2) + this.f57647e.getY();
            this.f57650h.setText(this.f57651i.getText());
            this.f57650h.setVisibility(0);
            this.f57651i.setVisibility(8);
            setEditTextEnable(false);
            this.D.HidenSoftKeyPad(this.f57651i);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        TextPaint paint = this.f57651i.getPaint();
        float measureText = paint.measureText(str);
        while (true) {
            float textSize = this.f57651i.getTextSize();
            float f2 = this.Q;
            float f3 = this.C;
            if (textSize <= ((f2 * f3) / 2.0f) - (this.T * f3) || measureText <= this.R * f3) {
                return;
            }
            setTextSize(0, this.f57651i.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    public final void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            TextPaint paint = this.f57651i.getPaint();
            float measureText = paint.measureText(str);
            while (this.f57651i.getLineCount() == 1) {
                float textSize = this.f57651i.getTextSize();
                float f2 = this.K;
                float f3 = this.C;
                if (textSize >= f2 * f3 || measureText >= this.R * f3) {
                    break;
                }
                setTextSize(0, this.f57651i.getTextSize() + 1.0f);
                measureText = paint.measureText(str);
            }
            if (m0.c(str) <= m0.c(getResources().getString(R.string.cover_hint))) {
                float textSize2 = this.f57651i.getTextSize();
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
                FrameLayout frameLayout = this.f57647e;
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f57647e.getLayoutParams();
            int width = this.f57647e.getWidth() - i2;
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
            this.f57649g.setPadding((int) (this.L * f3), (int) (this.M * f3), (int) (this.N * f3), (int) (this.O * f3));
            setTextSize(0, (this.f57651i.getTextSize() * i4) / this.f57647e.getHeight());
            layoutParams.width = width;
            layoutParams.height = i4;
            this.f57647e.setLayoutParams(layoutParams);
            float f4 = this.y - (layoutParams.width / 2);
            float f5 = this.z - (layoutParams.height / 2);
            this.f57647e.setX(f4);
            this.f57647e.setY(f5);
        }
    }

    public final void L() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.J) {
            return;
        }
        this.J = true;
        this.f57652j.setVisibility(0);
        this.k.setVisibility(0);
        this.f57648f.setBackgroundResource(R.drawable.bg_cover_pendant_container);
    }

    public void changeEditState(View view, PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, view, pendantData) == null) || pendantData == null) {
            return;
        }
        int i2 = pendantData.pendantType;
        if (i2 == 0) {
            this.f57651i.setText("");
            hideSoftKeyPad();
        } else if (i2 == 1) {
            E(pendantData);
            this.f57649g.setBackgroundResource(R.drawable.bg_cover_edit_blue);
            showSoftKeyPad();
        } else if (i2 == 2) {
            E(pendantData);
            this.f57649g.setBackgroundResource(R.drawable.bg_cover_edit_black);
            showSoftKeyPad();
        } else if (i2 != 3) {
            hideSoftKeyPad();
            String f2 = c.a.r0.y3.i.f.b.g().f(pendantData.resource);
            if (TextUtils.isEmpty(f2)) {
                if (view != null && (view.getTag() instanceof a.c)) {
                    a.c cVar = (a.c) view.getTag();
                    cVar.f29120c.setVisibility(0);
                    c.a.r0.y3.i.f.b.g().e(pendantData.id, pendantData.resource, new f(cVar, this, pendantData));
                }
            } else {
                D(f2, pendantData);
            }
        } else {
            E(pendantData);
            this.f57649g.setBackgroundDrawable(null);
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
            TextView textView = this.f57650h;
            if (textView == null || textView.getText() == null) {
                return null;
            }
            return this.f57650h.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    public void hideSoftKeyPad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f57650h.setText(this.f57651i.getText());
            this.f57650h.setVisibility(0);
            this.f57651i.setVisibility(8);
            setEditTextEnable(false);
            if (TextUtils.isEmpty(this.f57650h.getText())) {
                this.l = 0;
                this.f57647e.setVisibility(8);
            }
            if (this.l == 4) {
                x();
            }
            this.D.HidenSoftKeyPad(this.f57651i);
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
            this.f57647e.setVisibility(0);
            return;
        }
        hideSoftKeyPad();
        getTempBitmap();
        this.f57647e.setVisibility(8);
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
                this.f57651i.setTextAppearance(getContext(), R.style.cover_text_style);
                this.f57650h.setTextAppearance(getContext(), R.style.cover_text_style);
                float f2 = i2;
                float f3 = i4;
                i3 = (int) ((l.g(TbadkCoreApplication.getInst(), R.dimen.ds100) * f2) / f3);
                setTextSize(0, (l.g(getContext(), R.dimen.fontsize40) * f2) / f3);
                this.P = 0;
                this.f57651i.setMaxLines(1);
                this.f57650h.setMaxLines(1);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f57650h.getLayoutParams();
                layoutParams.height = -1;
                layoutParams.width = -2;
                layoutParams.gravity = 17;
                this.f57651i.setLayoutParams(layoutParams);
                this.f57649g.setPadding(l.g(getContext(), R.dimen.ds60), 0, l.g(getContext(), R.dimen.ds60), 0);
            } else {
                this.f57651i.setTextAppearance(getContext(), R.style.cover_pendant_style);
                this.f57650h.setTextAppearance(getContext(), R.style.cover_pendant_style);
                this.P = l.g(getContext(), R.dimen.ds40);
                this.f57651i.setMaxLines(2);
                this.f57650h.setMaxLines(2);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f57650h.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                layoutParams2.gravity = 17;
                this.f57651i.setLayoutParams(layoutParams2);
                this.L = (int) (l.e(getContext(), pendantData.left) * this.B);
                this.M = (int) (l.e(getContext(), pendantData.top) * this.B);
                this.N = (int) (l.e(getContext(), pendantData.right) * this.B);
                int e2 = (int) (l.e(getContext(), pendantData.bottom) * this.B);
                this.O = e2;
                this.f57649g.setPadding(this.L, this.M, this.N, e2);
                this.K = l.g(getContext(), R.dimen.fontsize40) * this.B;
                String text = getText();
                this.Q = (i3 - this.M) - this.O;
                this.R = (i2 - this.L) - this.N;
                this.T = this.S + l.g(getContext(), R.dimen.ds6);
                setTextSize(0, this.K);
                if (TextUtils.isEmpty(text)) {
                    A(getContext().getString(R.string.cover_hint), this.R);
                    this.K = this.f57651i.getTextSize();
                    L();
                    showSoftKeyPad();
                } else {
                    if (m0.c(text) > 20) {
                        text = m0.l(text, 20);
                        this.f57651i.setText(text);
                        this.f57650h.setText(text);
                    }
                    G(text);
                }
            }
            this.f57650h.setIncludeFontPadding(false);
            this.f57651i.setIncludeFontPadding(false);
            this.f57650h.setLineSpacing(this.S, 1.0f);
            this.f57651i.setLineSpacing(this.S, 1.0f);
            this.f57647e.setRotation(0.0f);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f57647e.getLayoutParams();
            int i5 = this.P;
            layoutParams3.height = i3 + (i5 * 2);
            layoutParams3.width = (i5 * 2) + i2;
            this.f57647e.setLayoutParams(layoutParams3);
            this.U = i2 + (this.P * 2);
            int i6 = this.P;
            ((FrameLayout.LayoutParams) this.f57648f.getLayoutParams()).setMargins(i6, i6, i6, i6);
            this.f57647e.setVisibility(0);
        }
    }

    public void setEditTextEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048598, this, z) == null) {
            if (z) {
                this.f57651i.setFocusable(true);
                this.f57651i.setFocusableInTouchMode(true);
                this.f57651i.requestFocus();
                return;
            }
            this.f57651i.setFocusable(false);
            this.f57651i.setFocusableInTouchMode(false);
        }
    }

    public void setParentViewController(c.a.r0.y3.i.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            this.D = cVar;
        }
    }

    public void setTextSize(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            if (this.f57651i.getTextSize() != f2) {
                this.f57651i.setTextSize(i2, f2);
            }
            if (this.f57650h.getTextSize() != f2) {
                this.f57650h.setTextSize(i2, f2);
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
            this.f57650h.setText(this.f57651i.getText());
            this.f57650h.setVisibility(8);
            this.f57651i.setVisibility(0);
            setEditTextEnable(true);
            this.D.ShowSoftKeyPad(this.f57651i);
        }
    }

    public final float[] t(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, motionEvent, i2)) == null) {
            Matrix matrix = new Matrix();
            matrix.postRotate(this.f57647e.getRotation());
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
            this.f57652j.setVisibility(8);
            this.k.setVisibility(8);
            this.f57648f.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            this.f57648f = (RotateFrameLayout) this.f57647e.findViewById(R.id.content_container);
            this.f57650h = (TextView) this.f57647e.findViewById(R.id.cover_text);
            this.f57649g = (FrameLayout) this.f57647e.findViewById(R.id.content_view);
            this.f57651i = (EditText) this.f57647e.findViewById(R.id.cover_edit);
            this.f57652j = (ImageView) this.f57647e.findViewById(R.id.cover_delete);
            this.k = (ImageView) this.f57647e.findViewById(R.id.cover_scale);
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
        this.I = l.k(TbadkCoreApplication.getInst());
        this.K = l.g(getContext(), R.dimen.fontsize40);
        this.S = l.g(getContext(), R.dimen.ds2);
        this.o = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f57647e = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.layout_cover_pendant_view, (ViewGroup) null);
        y();
        addView(this.f57647e);
        this.f57647e.setOnTouchListener(new a(this));
        this.f57652j.setOnClickListener(new b(this));
        this.k.setOnTouchListener(new c(this));
        this.f57651i.addTextChangedListener(new d(this));
        this.f57651i.setOnEditorActionListener(new e(this));
        this.f57647e.setVisibility(8);
    }
}
