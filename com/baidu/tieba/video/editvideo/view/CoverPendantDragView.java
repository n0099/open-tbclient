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
import c.a.o0.c1.o0;
import c.a.p0.n4.i.c.a;
import c.a.p0.n4.i.f.b;
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
/* loaded from: classes6.dex */
public class CoverPendantDragView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public float D;
    public int E;
    public boolean F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public float M;
    public float N;
    public int O;
    public float P;
    public int Q;
    public Map<String, Bitmap> R;
    public Bitmap S;
    public long T;
    public float U;
    public float V;
    public FrameLayout a;

    /* renamed from: b  reason: collision with root package name */
    public RotateFrameLayout f36426b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f36427c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f36428d;

    /* renamed from: e  reason: collision with root package name */
    public EditText f36429e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f36430f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f36431g;

    /* renamed from: h  reason: collision with root package name */
    public int f36432h;
    public int i;
    public int j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public boolean p;
    public float q;
    public float r;
    public int s;
    public int t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public c.a.p0.n4.i.h.c z;

    /* loaded from: classes6.dex */
    public class a implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CoverPendantDragView f36433b;

        public a(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36433b = coverPendantDragView;
            this.a = 0L;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a = System.currentTimeMillis();
                    this.f36433b.J(view, motionEvent);
                    if (this.f36433b.f36432h == 4) {
                        this.f36433b.R();
                    }
                } else if (action == 1) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float abs = Math.abs(rawX - this.f36433b.l);
                    float abs2 = Math.abs(rawY - this.f36433b.m);
                    if (!this.f36433b.p && abs < this.f36433b.k && abs2 < this.f36433b.k && System.currentTimeMillis() - this.a < 300) {
                        this.f36433b.S();
                    }
                    this.f36433b.q = 0.0f;
                    this.f36433b.r = 0.0f;
                    this.f36433b.p = false;
                } else if (action != 2) {
                    if (action == 6) {
                        this.f36433b.q = 0.0f;
                        this.f36433b.r = 0.0f;
                    }
                } else if (!this.f36433b.C(motionEvent)) {
                    this.f36433b.F(motionEvent);
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverPendantDragView a;

        public b(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverPendantDragView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.f36429e.setText("");
                this.a.A();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverPendantDragView a;

        public c(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverPendantDragView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.J(view, motionEvent);
                } else if (action != 1) {
                    if (action == 2 && !this.a.C(motionEvent)) {
                        this.a.O(motionEvent);
                    }
                } else {
                    this.a.r = 0.0f;
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CoverPendantDragView a;

        public d(CoverPendantDragView coverPendantDragView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {coverPendantDragView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverPendantDragView;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                String obj = editable.toString();
                if (this.a.f36432h != 4) {
                    String E = this.a.E(this.a.f36428d.getPaint(), obj);
                    if (!E.equals(obj)) {
                        editable.delete(E.length(), obj.length());
                        n.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f044e);
                    }
                } else if (o0.c(obj) < 20) {
                    if (obj.length() > this.a.f36428d.getText().length()) {
                        this.a.M(obj);
                    } else {
                        this.a.N(obj);
                    }
                } else {
                    String m = o0.m(obj, 20);
                    editable.delete(m.length(), obj.length());
                    this.a.M(m);
                    n.M(this.a.getContext(), R.string.obfuscated_res_0x7f0f044d);
                }
                this.a.f36428d.setText(editable.toString());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = coverPendantDragView;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) ? keyEvent.getKeyCode() == 66 : invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class f implements b.InterfaceC1245b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public WeakReference<a.c> a;

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<CoverPendantDragView> f36434b;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<PendantData> f36435c;

        public f(a.c cVar, CoverPendantDragView coverPendantDragView, PendantData pendantData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, coverPendantDragView, pendantData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (cVar != null) {
                this.a = new WeakReference<>(cVar);
            }
            if (coverPendantDragView != null) {
                this.f36434b = new WeakReference<>(coverPendantDragView);
            }
            if (pendantData != null) {
                this.f36435c = new WeakReference<>(pendantData);
            }
        }

        @Override // c.a.p0.n4.i.f.b.InterfaceC1245b
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                WeakReference<a.c> weakReference = this.a;
                if (weakReference != null && weakReference.get() != null) {
                    this.a.get().f16621c.setVisibility(8);
                }
                WeakReference<CoverPendantDragView> weakReference2 = this.f36434b;
                if (weakReference2 == null || weakReference2.get() == null) {
                    return;
                }
                n.N(this.f36434b.get().getContext(), str);
            }
        }

        @Override // c.a.p0.n4.i.f.b.InterfaceC1245b
        public void b() {
            WeakReference<a.c> weakReference;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (weakReference = this.a) == null || weakReference.get() == null) {
                return;
            }
            this.a.get().f16621c.setVisibility(8);
        }

        @Override // c.a.p0.n4.i.f.b.InterfaceC1245b
        public void c(String str, String str2) {
            WeakReference<PendantData> weakReference;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
                WeakReference<a.c> weakReference2 = this.a;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.a.get().f16621c.setVisibility(8);
                }
                WeakReference<CoverPendantDragView> weakReference3 = this.f36434b;
                if (weakReference3 == null || weakReference3.get() == null || (weakReference = this.f36435c) == null || weakReference.get() == null) {
                    return;
                }
                this.f36434b.get().G(str2, this.f36435c.get());
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36428d.setText(this.f36429e.getText());
            this.f36428d.setVisibility(0);
            this.f36429e.setVisibility(8);
            setEditTextEnable(false);
            if (TextUtils.isEmpty(this.f36428d.getText())) {
                this.f36432h = 0;
                this.a.setVisibility(8);
            }
            if (this.f36432h == 4) {
                z();
            }
            this.z.HidenSoftKeyPad(this.f36429e);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f36426b = (RotateFrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906df);
            this.f36428d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090715);
            this.f36427c = (FrameLayout) this.a.findViewById(R.id.obfuscated_res_0x7f0906e9);
            this.f36429e = (EditText) this.a.findViewById(R.id.obfuscated_res_0x7f090709);
            this.f36430f = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090708);
            this.f36431g = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f09070f);
        }
    }

    public final boolean C(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            float abs = Math.abs(motionEvent.getRawX() - this.l);
            float abs2 = Math.abs(motionEvent.getRawY() - this.m);
            float f2 = this.k;
            return abs < f2 && abs2 < f2;
        }
        return invokeL.booleanValue;
    }

    public final void D(String str, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048579, this, str, f2) == null) {
            TextPaint paint = this.f36429e.getPaint();
            float measureText = paint.measureText(str);
            while (measureText > f2) {
                setTextSize(0, this.f36429e.getTextSize() - 1.0f);
                measureText = paint.measureText(str);
            }
        }
    }

    public final String E(TextPaint textPaint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, textPaint, str)) == null) {
            float measureText = textPaint.measureText(str);
            while (str.length() > 0 && measureText > this.i - n.f(getContext(), R.dimen.obfuscated_res_0x7f070235)) {
                str = o0.n(str, o0.d(str) - 1);
                measureText = textPaint.measureText(str);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public final void F(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (this.f36432h != 4) {
                float y = (this.a.getY() + rawY) - this.o;
                float f2 = this.B;
                if (y < f2) {
                    y = f2;
                } else if (y > (f2 + this.j) - this.a.getHeight()) {
                    y = (this.B + this.j) - this.a.getHeight();
                }
                this.a.setY(y);
            } else {
                int pointerCount = motionEvent.getPointerCount();
                if (pointerCount >= 2) {
                    this.p = true;
                    float y2 = y(motionEvent);
                    float w = w(motionEvent);
                    float f3 = this.q;
                    if (f3 != 0.0f) {
                        int i = (int) (f3 - y2);
                        Q(i, (int) (i / this.w));
                    }
                    float f4 = this.r;
                    if (f4 != 0.0f) {
                        FrameLayout frameLayout = this.a;
                        frameLayout.setRotation(frameLayout.getRotation() - (f4 - w));
                    }
                    this.r = w;
                    this.q = y2;
                } else if (!this.p && pointerCount == 1) {
                    float y3 = (this.a.getY() + rawY) - this.o;
                    if (y3 < this.B - (this.a.getHeight() / 2)) {
                        y3 = this.B - (this.a.getHeight() / 2);
                    } else if (y3 > ((this.B + this.j) - this.a.getHeight()) + (this.a.getHeight() / 2)) {
                        y3 = ((this.B + this.j) - this.a.getHeight()) + (this.a.getHeight() / 2);
                    }
                    float x = (this.a.getX() + rawX) - this.n;
                    if (x < this.A - (this.a.getWidth() / 2)) {
                        x = this.A - (this.a.getWidth() / 2);
                    } else if (x > ((this.A + this.i) - this.a.getWidth()) + (this.a.getWidth() / 2)) {
                        x = ((this.A + this.i) - this.a.getWidth()) + (this.a.getWidth() / 2);
                    }
                    this.a.setX(x);
                    this.a.setY(y3);
                }
            }
            this.n = rawX;
            this.o = rawY;
        }
    }

    public final void G(String str, PendantData pendantData) {
        Map<String, Bitmap> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048582, this, str, pendantData) == null) || TextUtils.isEmpty(str) || pendantData == null || (map = this.R) == null) {
            return;
        }
        Bitmap bitmap = map.get(str);
        if ((bitmap == null || bitmap.isRecycled()) && (bitmap = BitmapHelper.loadBitmap(str)) != null) {
            this.R.put(str, bitmap);
        }
        if (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return;
        }
        z();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.x = 1.0f;
        this.y = 1.0f;
        int d2 = n.d(getContext(), width / 2);
        float f2 = d2;
        float f3 = height;
        float f4 = width;
        int i = (int) ((f2 * f3) / f4);
        int i2 = (this.i * 2) / 3;
        if (d2 > i2) {
            float f5 = i2;
            this.x = (f5 * 1.0f) / f2;
            i = (int) ((f5 * f3) / f4);
            d2 = i2;
        }
        this.f36427c.setBackgroundDrawable(new BitmapDrawable(bitmap));
        L(d2, i, this.E, pendantData);
        int i3 = this.L;
        int i4 = width + (i3 * 2);
        this.s = i4;
        int i5 = height + (i3 * 2);
        this.t = i5;
        this.w = (i4 * 1.0f) / i5;
        this.a.setX((((this.i - d2) - (i3 * 2)) / 2) + this.A);
        this.a.setY((((this.j - i) - (this.L * 2)) / 2) + this.B);
    }

    public final void H(PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, pendantData) == null) {
            z();
            L(this.i, n.f(getContext(), R.dimen.obfuscated_res_0x7f07019a), this.E, pendantData);
            int i = this.f36432h;
            if (i == 4 || i == 0) {
                this.a.setX(this.A);
                this.a.setY(((this.j - n.f(getContext(), R.dimen.obfuscated_res_0x7f07019a)) / 2) + this.B);
                String obj = this.f36429e.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return;
                }
                String E = E(this.f36429e.getPaint(), obj);
                if (E.equals(obj)) {
                    return;
                }
                this.f36428d.setText(E);
                this.f36429e.setText(E);
            }
        }
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            for (Map.Entry<String, Bitmap> entry : this.R.entrySet()) {
                Bitmap value = entry.getValue();
                if (value != null && !value.isRecycled()) {
                    value.recycle();
                }
            }
            this.R.clear();
            this.R = null;
            v();
        }
    }

    public final void J(View view, MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view, motionEvent) == null) {
            this.l = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            this.m = rawY;
            this.n = this.l;
            this.o = rawY;
            this.u = (this.a.getWidth() / 2) + this.a.getX();
            this.v = (this.a.getHeight() / 2) + this.a.getY();
            this.f36428d.setText(this.f36429e.getText());
            this.f36428d.setVisibility(0);
            this.f36429e.setVisibility(8);
            setEditTextEnable(false);
            this.z.HidenSoftKeyPad(this.f36429e);
        }
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048586, this, z) == null) || this.f36432h == 0) {
            return;
        }
        if (z) {
            v();
            this.a.setVisibility(0);
            return;
        }
        A();
        getTempBitmap();
        this.a.setVisibility(8);
    }

    public void L(int i, int i2, int i3, PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), pendantData}) == null) {
            if (pendantData.pendantType != 4) {
                this.f36429e.setTextAppearance(getContext(), R.style.obfuscated_res_0x7f1003a0);
                this.f36428d.setTextAppearance(getContext(), R.style.obfuscated_res_0x7f1003a0);
                float f2 = i;
                float f3 = i3;
                i2 = (int) ((n.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f07019a) * f2) / f3);
                setTextSize(0, (n.f(getContext(), R.dimen.obfuscated_res_0x7f070329) * f2) / f3);
                this.L = 0;
                this.f36429e.setMaxLines(1);
                this.f36428d.setMaxLines(1);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f36428d.getLayoutParams();
                layoutParams.height = -1;
                layoutParams.width = -2;
                layoutParams.gravity = 17;
                this.f36429e.setLayoutParams(layoutParams);
                this.f36427c.setPadding(n.f(getContext(), R.dimen.obfuscated_res_0x7f070253), 0, n.f(getContext(), R.dimen.obfuscated_res_0x7f070253), 0);
            } else {
                this.f36429e.setTextAppearance(getContext(), R.style.obfuscated_res_0x7f10039f);
                this.f36428d.setTextAppearance(getContext(), R.style.obfuscated_res_0x7f10039f);
                this.L = n.f(getContext(), R.dimen.obfuscated_res_0x7f070225);
                this.f36429e.setMaxLines(2);
                this.f36428d.setMaxLines(2);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f36428d.getLayoutParams();
                layoutParams2.height = -2;
                layoutParams2.width = -2;
                layoutParams2.gravity = 17;
                this.f36429e.setLayoutParams(layoutParams2);
                this.H = (int) (n.d(getContext(), pendantData.left) * this.x);
                this.I = (int) (n.d(getContext(), pendantData.top) * this.x);
                this.J = (int) (n.d(getContext(), pendantData.right) * this.x);
                int d2 = (int) (n.d(getContext(), pendantData.bottom) * this.x);
                this.K = d2;
                this.f36427c.setPadding(this.H, this.I, this.J, d2);
                this.G = n.f(getContext(), R.dimen.obfuscated_res_0x7f070329) * this.x;
                String text = getText();
                this.M = (i2 - this.I) - this.K;
                this.N = (i - this.H) - this.J;
                this.P = this.O + n.f(getContext(), R.dimen.obfuscated_res_0x7f0702df);
                setTextSize(0, this.G);
                if (TextUtils.isEmpty(text)) {
                    D(getContext().getString(R.string.obfuscated_res_0x7f0f044c), this.N);
                    this.G = this.f36429e.getTextSize();
                    R();
                    S();
                } else {
                    if (o0.c(text) > 20) {
                        text = o0.m(text, 20);
                        this.f36429e.setText(text);
                        this.f36428d.setText(text);
                    }
                    M(text);
                }
            }
            this.f36428d.setIncludeFontPadding(false);
            this.f36429e.setIncludeFontPadding(false);
            this.f36428d.setLineSpacing(this.O, 1.0f);
            this.f36429e.setLineSpacing(this.O, 1.0f);
            this.a.setRotation(0.0f);
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            int i4 = this.L;
            layoutParams3.height = i2 + (i4 * 2);
            layoutParams3.width = (i4 * 2) + i;
            this.a.setLayoutParams(layoutParams3);
            this.Q = i + (this.L * 2);
            int i5 = this.L;
            ((FrameLayout.LayoutParams) this.f36426b.getLayoutParams()).setMargins(i5, i5, i5, i5);
            this.a.setVisibility(0);
        }
    }

    public final void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048588, this, str) != null) {
            return;
        }
        TextPaint paint = this.f36429e.getPaint();
        float measureText = paint.measureText(str);
        while (true) {
            float textSize = this.f36429e.getTextSize();
            float f2 = this.M;
            float f3 = this.y;
            if (textSize <= ((f2 * f3) / 2.0f) - (this.P * f3) || measureText <= this.N * f3) {
                return;
            }
            setTextSize(0, this.f36429e.getTextSize() - 1.0f);
            measureText = paint.measureText(str);
        }
    }

    public final void N(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            TextPaint paint = this.f36429e.getPaint();
            float measureText = paint.measureText(str);
            while (this.f36429e.getLineCount() == 1) {
                float textSize = this.f36429e.getTextSize();
                float f2 = this.G;
                float f3 = this.y;
                if (textSize >= f2 * f3 || measureText >= this.N * f3) {
                    break;
                }
                setTextSize(0, this.f36429e.getTextSize() + 1.0f);
                measureText = paint.measureText(str);
            }
            if (o0.c(str) <= o0.c(getResources().getString(R.string.obfuscated_res_0x7f0f044c))) {
                float textSize2 = this.f36429e.getTextSize();
                float f4 = this.G;
                float f5 = this.y;
                if (textSize2 != f4 * f5) {
                    setTextSize(0, f4 * f5);
                }
            }
        }
    }

    public final void O(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, motionEvent) == null) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float x = x(motionEvent);
            float abs = Math.abs(this.n - rawX);
            float abs2 = Math.abs(this.o - rawY);
            int sqrt = (int) Math.sqrt((abs * abs) + (abs2 * abs2));
            float abs3 = Math.abs(this.u - rawX);
            float abs4 = Math.abs(this.v - rawY);
            int sqrt2 = (int) Math.sqrt((abs3 * abs3) + (abs4 * abs4));
            float abs5 = Math.abs(this.u - this.n);
            float abs6 = Math.abs(this.v - this.o);
            if (sqrt2 > ((int) Math.sqrt((abs5 * abs5) + (abs6 * abs6)))) {
                sqrt = -sqrt;
            }
            Q(sqrt, (int) (sqrt / this.w));
            float f2 = this.r;
            if (f2 != 0.0f) {
                FrameLayout frameLayout = this.a;
                frameLayout.setRotation(frameLayout.getRotation() - (f2 - x));
            }
            this.r = x;
            this.n = rawX;
            this.o = rawY;
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            buildDrawingCache();
            Bitmap drawingCache = getDrawingCache();
            if (drawingCache != null) {
                this.S = Bitmap.createBitmap(drawingCache);
            }
            destroyDrawingCache();
        }
    }

    public final void Q(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i, i2) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.a.getLayoutParams();
            int width = this.a.getWidth() - i;
            float f2 = this.w;
            int i3 = (int) (width / f2);
            int i4 = this.s;
            if (width < i4) {
                i3 = (int) (i4 / f2);
                width = i4;
            }
            int i5 = this.L;
            float f3 = ((width * 1.0f) - (i5 * 2)) / (this.Q - (i5 * 2));
            this.y = f3;
            this.f36427c.setPadding((int) (this.H * f3), (int) (this.I * f3), (int) (this.J * f3), (int) (this.K * f3));
            setTextSize(0, (this.f36429e.getTextSize() * i3) / this.a.getHeight());
            layoutParams.width = width;
            layoutParams.height = i3;
            this.a.setLayoutParams(layoutParams);
            float f4 = this.u - (layoutParams.width / 2);
            float f5 = this.v - (layoutParams.height / 2);
            this.a.setX(f4);
            this.a.setY(f5);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.F) {
            return;
        }
        this.F = true;
        this.f36430f.setVisibility(0);
        this.f36431g.setVisibility(0);
        this.f36426b.setBackgroundResource(R.drawable.obfuscated_res_0x7f080266);
    }

    public void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.f36428d.setText(this.f36429e.getText());
            this.f36428d.setVisibility(8);
            this.f36429e.setVisibility(0);
            setEditTextEnable(true);
            this.z.ShowSoftKeyPad(this.f36429e);
        }
    }

    public Bitmap getTempBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.S == null) {
                P();
            }
            return this.S;
        }
        return (Bitmap) invokeV.objValue;
    }

    public String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            TextView textView = this.f36428d;
            if (textView == null || textView.getText() == null) {
                return null;
            }
            return this.f36428d.getText().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (this.i == 0 && this.j == 0) {
                this.i = getMeasuredWidth();
                this.j = getMeasuredHeight();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.T = System.currentTimeMillis();
                this.U = motionEvent.getRawX();
                this.V = motionEvent.getRawY();
            } else if (action == 1) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float abs = Math.abs(rawX - this.U);
                float abs2 = Math.abs(rawY - this.V);
                if (motionEvent.getPointerCount() <= 1) {
                    float f2 = this.k;
                    if (abs < f2 && abs2 < f2 && System.currentTimeMillis() - this.T < 300) {
                        A();
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setEditTextEnable(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            if (z) {
                this.f36429e.setFocusable(true);
                this.f36429e.setFocusableInTouchMode(true);
                this.f36429e.requestFocus();
                return;
            }
            this.f36429e.setFocusable(false);
            this.f36429e.setFocusableInTouchMode(false);
        }
    }

    public void setParentViewController(c.a.p0.n4.i.h.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, cVar) == null) {
            this.z = cVar;
        }
    }

    public void setTextSize(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            if (this.f36429e.getTextSize() != f2) {
                this.f36429e.setTextSize(i, f2);
            }
            if (this.f36428d.getTextSize() != f2) {
                this.f36428d.setTextSize(i, f2);
            }
        }
    }

    public void setVideoLocation(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.A = f2;
            this.B = f3;
            this.C = f4;
            this.D = f5;
            if (f2 > 0.0f) {
                View view = new View(getContext());
                view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.A, -1);
                layoutParams.gravity = 3;
                addView(view, layoutParams);
            }
            if (this.B > 0.0f) {
                View view2 = new View(getContext());
                view2.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, (int) this.B);
                layoutParams2.gravity = 48;
                addView(view2, layoutParams2);
            }
            if (this.C > 0.0f) {
                View view3 = new View(getContext());
                view3.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(((int) this.C) - this.i, -1);
                layoutParams3.gravity = 5;
                addView(view3, layoutParams3);
            }
            if (this.D > 0.0f) {
                View view4 = new View(getContext());
                view4.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, ((int) this.D) - this.j);
                layoutParams4.gravity = 80;
                addView(view4, layoutParams4);
            }
        }
    }

    public void setVideoSize(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048603, this, i, i2) == null) {
            this.i = i;
            this.j = i2;
        }
    }

    public final float[] t(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048604, this, motionEvent, i)) == null) {
            Matrix matrix = new Matrix();
            matrix.postRotate(this.a.getRotation());
            float[] fArr = {motionEvent.getX(i), motionEvent.getY(i)};
            matrix.mapPoints(fArr);
            return fArr;
        }
        return (float[]) invokeLI.objValue;
    }

    public void u(View view, PendantData pendantData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048605, this, view, pendantData) == null) || pendantData == null) {
            return;
        }
        int i = pendantData.pendantType;
        if (i == 0) {
            this.f36429e.setText("");
            A();
        } else if (i == 1) {
            H(pendantData);
            this.f36427c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080265);
            S();
        } else if (i == 2) {
            H(pendantData);
            this.f36427c.setBackgroundResource(R.drawable.obfuscated_res_0x7f080264);
            S();
        } else if (i != 3) {
            A();
            String f2 = c.a.p0.n4.i.f.b.g().f(pendantData.resource);
            if (TextUtils.isEmpty(f2)) {
                if (view != null && (view.getTag() instanceof a.c)) {
                    a.c cVar = (a.c) view.getTag();
                    cVar.f16621c.setVisibility(0);
                    c.a.p0.n4.i.f.b.g().e(pendantData.id, pendantData.resource, new f(cVar, this, pendantData));
                }
            } else {
                G(f2, pendantData);
            }
        } else {
            H(pendantData);
            this.f36427c.setBackgroundDrawable(null);
            S();
        }
        this.f36432h = pendantData.pendantType;
    }

    public void v() {
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048606, this) == null) || (bitmap = this.S) == null || bitmap.isRecycled()) {
            return;
        }
        this.S.recycle();
        this.S = null;
    }

    public final float w(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, motionEvent)) == null) {
            float[] t = t(motionEvent, 0);
            float f2 = t[0];
            float f3 = t[1];
            float[] t2 = t(motionEvent, 1);
            return (float) Math.toDegrees(Math.atan2(f3 - t2[1], f2 - t2[0]));
        }
        return invokeL.floatValue;
    }

    public final float x(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, motionEvent)) == null) ? (float) Math.toDegrees(Math.atan2(this.v - motionEvent.getRawY(), this.u - motionEvent.getRawX())) : invokeL.floatValue;
    }

    public final float y(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, motionEvent)) == null) {
            float x = motionEvent.getX(0) - motionEvent.getX(1);
            float y = motionEvent.getY(0) - motionEvent.getY(1);
            return (float) Math.sqrt((x * x) + (y * y));
        }
        return invokeL.floatValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048610, this) == null) && this.F) {
            this.F = false;
            this.f36430f.setVisibility(8);
            this.f36431g.setVisibility(8);
            this.f36426b.setBackgroundColor(getResources().getColor(R.color.transparent));
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoverPendantDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36432h = 0;
        this.x = 1.0f;
        this.y = 1.0f;
        this.F = true;
        this.R = new HashMap();
        this.T = 0L;
        this.U = 0.0f;
        this.V = 0.0f;
        this.E = n.k(TbadkCoreApplication.getInst());
        this.G = n.f(getContext(), R.dimen.obfuscated_res_0x7f070329);
        this.O = n.f(getContext(), R.dimen.obfuscated_res_0x7f0701d4);
        this.k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.a = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0493, (ViewGroup) null);
        B();
        addView(this.a);
        this.a.setOnTouchListener(new a(this));
        this.f36430f.setOnClickListener(new b(this));
        this.f36431g.setOnTouchListener(new c(this));
        this.f36429e.addTextChangedListener(new d(this));
        this.f36429e.setOnEditorActionListener(new e(this));
        this.a.setVisibility(8);
    }
}
