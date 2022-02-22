package com.baidu.tieba.square.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes13.dex */
public class CommonImageLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PADDING = 7;

    /* renamed from: j  reason: collision with root package name */
    public static float[] f48220j;
    public static float[] k;
    public static int l;
    public static int m;
    public static int n;
    public static float sRatio;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MediaData[] f48221e;

    /* renamed from: f  reason: collision with root package name */
    public int f48222f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48223g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48224h;

    /* renamed from: i  reason: collision with root package name */
    public final Context f48225i;
    public TbImageView mTbImageView1;
    public TbImageView mTbImageView2;
    public TbImageView mTbImageView3;

    /* loaded from: classes13.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MediaData f48226e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CommonImageLayout f48227f;

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
            this.f48227f = commonImageLayout;
            this.f48226e = mediaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                c.a.t0.m.a.m(this.f48227f.f48225i, this.f48226e.getVideoUrl());
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
        f48220j = new float[]{306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
        k = new float[]{138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
        l = 2;
        m = 4;
        n = 0;
        sRatio = -1.0f;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || sRatio >= 0.0f) {
            return;
        }
        sRatio = n.k(this.f48225i) / 320.0f;
        int i2 = 0;
        while (true) {
            float[] fArr = f48220j;
            if (i2 < fArr.length) {
                float f2 = fArr[i2];
                float f3 = sRatio;
                fArr[i2] = f2 * f3;
                float[] fArr2 = k;
                fArr2[i2] = fArr2[i2] * f3;
                i2++;
            } else {
                float f4 = sRatio;
                l = (int) (l * f4);
                m = (int) (m * f4);
                return;
            }
        }
    }

    public final void c(TbImageView tbImageView, MediaData mediaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, mediaData) == null) || tbImageView == null) {
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
        tbImageView.startLoad(picUrl, 13, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) || (mediaDataArr = this.f48221e) == null || mediaDataArr.length == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        int length = this.f48221e.length;
        if (length == 1) {
            drawChild(canvas, this.mTbImageView1, drawingTime);
        } else if (length == 2) {
            drawChild(canvas, this.mTbImageView1, drawingTime);
            drawChild(canvas, this.mTbImageView2, drawingTime);
        } else if (length != 3) {
        } else {
            drawChild(canvas, this.mTbImageView1, drawingTime);
            drawChild(canvas, this.mTbImageView2, drawingTime);
            drawChild(canvas, this.mTbImageView3, drawingTime);
        }
    }

    public int getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f48222f : invokeV.intValue;
    }

    public boolean isFromCDN() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f48224h : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            reset();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        MediaData[] mediaDataArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (mediaDataArr = this.f48221e) == null || mediaDataArr.length == 0) {
            return;
        }
        int length = mediaDataArr.length;
        if (length == 1) {
            if (this.f48223g) {
                float f2 = f48220j[0];
                this.mTbImageView1.layout(0, 0, i4, i5 - i3);
            } else {
                TbImageView tbImageView = this.mTbImageView1;
                int i6 = this.f48222f;
                tbImageView.layout(i6, 0, ((int) (f48220j[4] + 0.5f)) + i6, i5 - i3);
            }
            this.mTbImageView2.layout(0, 0, 0, 0);
            this.mTbImageView3.layout(0, 0, 0, 0);
        } else if (length == 2) {
            if (this.f48223g) {
                int i7 = (int) (f48220j[1] + 0.5f);
                TbImageView tbImageView2 = this.mTbImageView1;
                int i8 = this.f48222f;
                int i9 = i5 - i3;
                tbImageView2.layout(i8, 0, i8 + i7, i9);
                TbImageView tbImageView3 = this.mTbImageView2;
                int i10 = this.f48222f;
                tbImageView3.layout(i7 + i10 + m, 0, (i4 - i10) - i2, i9);
            } else {
                int i11 = (int) (f48220j[4] + 0.5f);
                TbImageView tbImageView4 = this.mTbImageView1;
                int i12 = this.f48222f;
                int i13 = i5 - i3;
                tbImageView4.layout(i12, 0, i12 + i11, i13);
                TbImageView tbImageView5 = this.mTbImageView2;
                int i14 = this.f48222f;
                int i15 = l;
                tbImageView5.layout(i14 + i11 + i15, 0, i14 + (i11 * 2) + i15, i13);
            }
            this.mTbImageView3.layout(0, 0, 0, 0);
        } else if (length != 3) {
        } else {
            if (this.f48223g) {
                float[] fArr = f48220j;
                int i16 = (int) (fArr[2] + 0.5f);
                int i17 = (int) (fArr[3] + 0.5f);
                int i18 = i5 - i3;
                this.mTbImageView1.layout(0, 0, i16, i18);
                this.mTbImageView2.layout(l + i16, 0, i4, i17);
                TbImageView tbImageView6 = this.mTbImageView3;
                int i19 = l;
                tbImageView6.layout(i16 + i19, i17 + i19, i4, i18);
                return;
            }
            int i20 = (int) (f48220j[4] + 0.5f);
            TbImageView tbImageView7 = this.mTbImageView1;
            int i21 = this.f48222f;
            int i22 = i5 - i3;
            tbImageView7.layout(i21, 0, i20 + i21, i22);
            TbImageView tbImageView8 = this.mTbImageView2;
            int i23 = this.f48222f;
            int i24 = l;
            int i25 = i20 * 2;
            tbImageView8.layout(i20 + i23 + i24, 0, i23 + i25 + i24, i22);
            TbImageView tbImageView9 = this.mTbImageView3;
            int i26 = this.f48222f;
            tbImageView9.layout(i25 + i26 + (l * 2), 0, (i4 - i26) - i2, i22);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            int i5 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            if (n == 0) {
                n = i5;
            }
            MediaData[] mediaDataArr = this.f48221e;
            if (mediaDataArr != null && mediaDataArr.length != 0) {
                if (this.f48223g) {
                    setMeasuredDimension(n, (int) (k[mediaDataArr.length - 1] + 0.5f));
                } else {
                    setMeasuredDimension(n, (int) (k[4] + 0.5f));
                }
                int length = this.f48221e.length;
                if (length == 1) {
                    if (this.f48223g) {
                        measureChild(this.mTbImageView1, n + 1073741824, ((int) (k[0] + 0.5f)) + 1073741824);
                    } else {
                        measureChild(this.mTbImageView1, ((int) (f48220j[4] + 0.5f)) + 1073741824, ((int) (k[4] + 0.5f)) + 1073741824);
                    }
                    measureChild(this.mTbImageView2, 0, 0);
                    measureChild(this.mTbImageView3, 0, 0);
                    return;
                } else if (length == 2) {
                    if (this.f48223g) {
                        i4 = ((int) (f48220j[1] + 0.5f)) + 1073741824;
                        f2 = k[1];
                    } else {
                        i4 = ((int) (f48220j[4] + 0.5f)) + 1073741824;
                        f2 = k[4];
                    }
                    int i6 = ((int) (f2 + 0.5f)) + 1073741824;
                    measureChild(this.mTbImageView1, i4, i6);
                    measureChild(this.mTbImageView2, i4, i6);
                    measureChild(this.mTbImageView3, 0, 0);
                    return;
                } else if (length != 3) {
                    return;
                } else {
                    if (this.f48223g) {
                        float[] fArr = f48220j;
                        float[] fArr2 = k;
                        int i7 = ((int) (fArr[3] + 0.5f)) + 1073741824;
                        int i8 = ((int) (fArr2[3] + 0.5f)) + 1073741824;
                        measureChild(this.mTbImageView1, ((int) (fArr[2] + 0.5f)) + 1073741824, ((int) (fArr2[2] + 0.5f)) + 1073741824);
                        measureChild(this.mTbImageView2, i7, i8);
                        measureChild(this.mTbImageView3, i7, i8);
                        return;
                    }
                    int i9 = ((int) (f48220j[4] + 0.5f)) + 1073741824;
                    int i10 = ((int) (k[4] + 0.5f)) + 1073741824;
                    measureChild(this.mTbImageView1, i9, i10);
                    measureChild(this.mTbImageView2, i9, i10);
                    measureChild(this.mTbImageView3, i9, i10);
                    return;
                }
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    public void setData(MediaData[] mediaDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, mediaDataArr) == null) {
            this.f48221e = mediaDataArr;
            if (mediaDataArr != null && mediaDataArr.length > 0) {
                int length = mediaDataArr.length;
                if (length == 1) {
                    c(this.mTbImageView1, mediaDataArr[0]);
                    TbImageView tbImageView = this.mTbImageView2;
                    if (tbImageView != null) {
                        tbImageView.setTag(null);
                        this.mTbImageView2.setClickable(false);
                    }
                    TbImageView tbImageView2 = this.mTbImageView3;
                    if (tbImageView2 != null) {
                        tbImageView2.setTag(null);
                        this.mTbImageView3.setClickable(false);
                    }
                } else if (length == 2) {
                    c(this.mTbImageView1, mediaDataArr[0]);
                    c(this.mTbImageView2, this.f48221e[1]);
                    TbImageView tbImageView3 = this.mTbImageView3;
                    if (tbImageView3 != null) {
                        tbImageView3.setTag(null);
                        this.mTbImageView3.setClickable(false);
                    }
                } else if (length == 3) {
                    c(this.mTbImageView1, mediaDataArr[0]);
                    c(this.mTbImageView2, this.f48221e[1]);
                    c(this.mTbImageView3, this.f48221e[2]);
                }
                requestLayout();
                invalidate();
                return;
            }
            TbImageView tbImageView4 = this.mTbImageView1;
            if (tbImageView4 != null) {
                tbImageView4.setTag(null);
            }
            TbImageView tbImageView5 = this.mTbImageView2;
            if (tbImageView5 != null) {
                tbImageView5.setTag(null);
            }
            TbImageView tbImageView6 = this.mTbImageView3;
            if (tbImageView6 != null) {
                tbImageView6.setTag(null);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.f48224h = z;
        }
    }

    public void setPadding(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f48222f = i2;
        }
    }

    public void setShowBig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.f48223g = z;
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
        this.f48222f = 7;
        this.f48223g = false;
        this.f48224h = false;
        this.f48225i = context;
        b();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = SkinManager.getDrawable(R.color.common_color_10220);
        this.mTbImageView1 = new TbImageView(context);
        this.mTbImageView2 = new TbImageView(context);
        this.mTbImageView3 = new TbImageView(context);
        this.mTbImageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTbImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTbImageView3.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.mTbImageView1.setDefaultBg(drawable);
        this.mTbImageView2.setDefaultBg(drawable);
        this.mTbImageView3.setDefaultBg(drawable);
        addView(this.mTbImageView1);
        addView(this.mTbImageView2);
        addView(this.mTbImageView3);
        this.f48222f = (int) (this.f48222f * sRatio);
    }
}
