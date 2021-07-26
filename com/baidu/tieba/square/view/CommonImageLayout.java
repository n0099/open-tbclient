package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes4.dex */
public class CommonImageLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static float[] l;
    public static float[] m;
    public static int n;
    public static int o;
    public static int p;
    public static float q;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f21194e;

    /* renamed from: f  reason: collision with root package name */
    public TbImageView f21195f;

    /* renamed from: g  reason: collision with root package name */
    public TbImageView f21196g;

    /* renamed from: h  reason: collision with root package name */
    public MediaData[] f21197h;

    /* renamed from: i  reason: collision with root package name */
    public int f21198i;
    public boolean j;
    public final Context k;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaData f21199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonImageLayout f21200f;

        public a(CommonImageLayout commonImageLayout, MediaData mediaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonImageLayout, mediaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21200f = commonImageLayout;
            this.f21199e = mediaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.p0.m.a.l(this.f21200f.k, this.f21199e.getVideoUrl());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1791583271, "Lcom/baidu/tieba/square/view/CommonImageLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1791583271, "Lcom/baidu/tieba/square/view/CommonImageLayout;");
                return;
            }
        }
        l = new float[]{306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
        m = new float[]{138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
        n = 2;
        o = 4;
        p = 0;
        q = -1.0f;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CommonImageLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || q >= 0.0f) {
            return;
        }
        q = l.k(this.k) / 320.0f;
        int i2 = 0;
        while (true) {
            float[] fArr = l;
            if (i2 < fArr.length) {
                float f2 = fArr[i2];
                float f3 = q;
                fArr[i2] = f2 * f3;
                float[] fArr2 = m;
                fArr2[i2] = fArr2[i2] * f3;
                i2++;
            } else {
                float f4 = q;
                n = (int) (n * f4);
                o = (int) (o * f4);
                return;
            }
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public final void d(TbImageView tbImageView, MediaData mediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbImageView, mediaData) == null) || tbImageView == null) {
            return;
        }
        String picUrl = mediaData.getPicUrl();
        if (mediaData.getType() == 5) {
            picUrl = null;
            tbImageView.setDefaultResource(R.drawable.pic_video);
            tbImageView.setOnClickListener(new a(this, mediaData));
        } else {
            tbImageView.setClickable(false);
        }
        tbImageView.setTag(picUrl);
        tbImageView.M(picUrl, 13, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) || (mediaDataArr = this.f21197h) == null || mediaDataArr.length == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        int length = this.f21197h.length;
        if (length == 1) {
            drawChild(canvas, this.f21194e, drawingTime);
        } else if (length == 2) {
            drawChild(canvas, this.f21194e, drawingTime);
            drawChild(canvas, this.f21195f, drawingTime);
        } else if (length != 3) {
        } else {
            drawChild(canvas, this.f21194e, drawingTime);
            drawChild(canvas, this.f21195f, drawingTime);
            drawChild(canvas, this.f21196g, drawingTime);
        }
    }

    public int getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f21198i : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        MediaData[] mediaDataArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (mediaDataArr = this.f21197h) == null || mediaDataArr.length == 0) {
            return;
        }
        int length = mediaDataArr.length;
        if (length == 1) {
            if (this.j) {
                float f2 = l[0];
                this.f21194e.layout(0, 0, i4, i5 - i3);
            } else {
                TbImageView tbImageView = this.f21194e;
                int i6 = this.f21198i;
                tbImageView.layout(i6, 0, ((int) (l[4] + 0.5f)) + i6, i5 - i3);
            }
            this.f21195f.layout(0, 0, 0, 0);
            this.f21196g.layout(0, 0, 0, 0);
        } else if (length == 2) {
            if (this.j) {
                int i7 = (int) (l[1] + 0.5f);
                TbImageView tbImageView2 = this.f21194e;
                int i8 = this.f21198i;
                int i9 = i5 - i3;
                tbImageView2.layout(i8, 0, i8 + i7, i9);
                TbImageView tbImageView3 = this.f21195f;
                int i10 = this.f21198i;
                tbImageView3.layout(i7 + i10 + o, 0, (i4 - i10) - i2, i9);
            } else {
                int i11 = (int) (l[4] + 0.5f);
                TbImageView tbImageView4 = this.f21194e;
                int i12 = this.f21198i;
                int i13 = i5 - i3;
                tbImageView4.layout(i12, 0, i12 + i11, i13);
                TbImageView tbImageView5 = this.f21195f;
                int i14 = this.f21198i;
                int i15 = n;
                tbImageView5.layout(i14 + i11 + i15, 0, i14 + (i11 * 2) + i15, i13);
            }
            this.f21196g.layout(0, 0, 0, 0);
        } else if (length != 3) {
        } else {
            if (this.j) {
                float[] fArr = l;
                int i16 = (int) (fArr[2] + 0.5f);
                int i17 = (int) (fArr[3] + 0.5f);
                int i18 = i5 - i3;
                this.f21194e.layout(0, 0, i16, i18);
                this.f21195f.layout(n + i16, 0, i4, i17);
                TbImageView tbImageView6 = this.f21196g;
                int i19 = n;
                tbImageView6.layout(i16 + i19, i17 + i19, i4, i18);
                return;
            }
            int i20 = (int) (l[4] + 0.5f);
            TbImageView tbImageView7 = this.f21194e;
            int i21 = this.f21198i;
            int i22 = i5 - i3;
            tbImageView7.layout(i21, 0, i20 + i21, i22);
            TbImageView tbImageView8 = this.f21195f;
            int i23 = this.f21198i;
            int i24 = n;
            int i25 = i20 * 2;
            tbImageView8.layout(i20 + i23 + i24, 0, i23 + i25 + i24, i22);
            TbImageView tbImageView9 = this.f21196g;
            int i26 = this.f21198i;
            tbImageView9.layout(i25 + i26 + (n * 2), 0, (i4 - i26) - i2, i22);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            int i5 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            if (p == 0) {
                p = i5;
            }
            MediaData[] mediaDataArr = this.f21197h;
            if (mediaDataArr != null && mediaDataArr.length != 0) {
                if (this.j) {
                    setMeasuredDimension(p, (int) (m[mediaDataArr.length - 1] + 0.5f));
                } else {
                    setMeasuredDimension(p, (int) (m[4] + 0.5f));
                }
                int length = this.f21197h.length;
                if (length == 1) {
                    if (this.j) {
                        measureChild(this.f21194e, p + 1073741824, ((int) (m[0] + 0.5f)) + 1073741824);
                    } else {
                        measureChild(this.f21194e, ((int) (l[4] + 0.5f)) + 1073741824, ((int) (m[4] + 0.5f)) + 1073741824);
                    }
                    measureChild(this.f21195f, 0, 0);
                    measureChild(this.f21196g, 0, 0);
                    return;
                } else if (length == 2) {
                    if (this.j) {
                        i4 = ((int) (l[1] + 0.5f)) + 1073741824;
                        f2 = m[1];
                    } else {
                        i4 = ((int) (l[4] + 0.5f)) + 1073741824;
                        f2 = m[4];
                    }
                    int i6 = ((int) (f2 + 0.5f)) + 1073741824;
                    measureChild(this.f21194e, i4, i6);
                    measureChild(this.f21195f, i4, i6);
                    measureChild(this.f21196g, 0, 0);
                    return;
                } else if (length != 3) {
                    return;
                } else {
                    if (this.j) {
                        float[] fArr = l;
                        float[] fArr2 = m;
                        int i7 = ((int) (fArr[3] + 0.5f)) + 1073741824;
                        int i8 = ((int) (fArr2[3] + 0.5f)) + 1073741824;
                        measureChild(this.f21194e, ((int) (fArr[2] + 0.5f)) + 1073741824, ((int) (fArr2[2] + 0.5f)) + 1073741824);
                        measureChild(this.f21195f, i7, i8);
                        measureChild(this.f21196g, i7, i8);
                        return;
                    }
                    int i9 = ((int) (l[4] + 0.5f)) + 1073741824;
                    int i10 = ((int) (m[4] + 0.5f)) + 1073741824;
                    measureChild(this.f21194e, i9, i10);
                    measureChild(this.f21195f, i9, i10);
                    measureChild(this.f21196g, i9, i10);
                    return;
                }
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void setData(MediaData[] mediaDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaDataArr) == null) {
            this.f21197h = mediaDataArr;
            if (mediaDataArr != null && mediaDataArr.length > 0) {
                int length = mediaDataArr.length;
                if (length == 1) {
                    d(this.f21194e, mediaDataArr[0]);
                    TbImageView tbImageView = this.f21195f;
                    if (tbImageView != null) {
                        tbImageView.setTag(null);
                        this.f21195f.setClickable(false);
                    }
                    TbImageView tbImageView2 = this.f21196g;
                    if (tbImageView2 != null) {
                        tbImageView2.setTag(null);
                        this.f21196g.setClickable(false);
                    }
                } else if (length == 2) {
                    d(this.f21194e, mediaDataArr[0]);
                    d(this.f21195f, this.f21197h[1]);
                    TbImageView tbImageView3 = this.f21196g;
                    if (tbImageView3 != null) {
                        tbImageView3.setTag(null);
                        this.f21196g.setClickable(false);
                    }
                } else if (length == 3) {
                    d(this.f21194e, mediaDataArr[0]);
                    d(this.f21195f, this.f21197h[1]);
                    d(this.f21196g, this.f21197h[2]);
                }
                requestLayout();
                invalidate();
                return;
            }
            TbImageView tbImageView4 = this.f21194e;
            if (tbImageView4 != null) {
                tbImageView4.setTag(null);
            }
            TbImageView tbImageView5 = this.f21195f;
            if (tbImageView5 != null) {
                tbImageView5.setTag(null);
            }
            TbImageView tbImageView6 = this.f21196g;
            if (tbImageView6 != null) {
                tbImageView6.setTag(null);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            this.f21198i = i2;
        }
    }

    public void setShowBig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.j = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonImageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f21198i = 7;
        this.j = false;
        this.k = context;
        b();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = SkinManager.getDrawable(R.color.common_color_10220);
        this.f21194e = new TbImageView(context);
        this.f21195f = new TbImageView(context);
        this.f21196g = new TbImageView(context);
        this.f21194e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f21195f.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f21196g.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f21194e.setDefaultBg(drawable);
        this.f21195f.setDefaultBg(drawable);
        this.f21196g.setDefaultBg(drawable);
        addView(this.f21194e);
        addView(this.f21195f);
        addView(this.f21196g);
        this.f21198i = (int) (this.f21198i * q);
    }
}
