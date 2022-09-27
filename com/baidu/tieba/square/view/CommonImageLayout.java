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
import com.baidu.tieba.ej;
import com.baidu.tieba.yo4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes5.dex */
public class CommonImageLayout extends ViewGroup {
    public static /* synthetic */ Interceptable $ic;
    public static float[] h;
    public static float[] i;
    public static int j;
    public static int k;
    public static int l;
    public static float m;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView a;
    public TbImageView b;
    public TbImageView c;
    public MediaData[] d;
    public int e;
    public boolean f;
    public final Context g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MediaData a;
        public final /* synthetic */ CommonImageLayout b;

        public a(CommonImageLayout commonImageLayout, MediaData mediaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonImageLayout, mediaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = commonImageLayout;
            this.a = mediaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                yo4.o(this.b.g, this.a.getVideoUrl());
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
        h = new float[]{306.0f, 144.0f, 204.0f, 101.0f, 97.0f};
        i = new float[]{138.0f, 144.0f, 204.0f, 101.0f, 97.0f};
        j = 2;
        k = 4;
        l = 0;
        m = -1.0f;
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
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || m >= 0.0f) {
            return;
        }
        m = ej.k(this.g) / 320.0f;
        int i2 = 0;
        while (true) {
            float[] fArr = h;
            if (i2 < fArr.length) {
                float f = fArr[i2];
                float f2 = m;
                fArr[i2] = f * f2;
                float[] fArr2 = i;
                fArr2[i2] = fArr2[i2] * f2;
                i2++;
            } else {
                float f3 = m;
                j = (int) (j * f3);
                k = (int) (k * f3);
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
        tbImageView.K(picUrl, 13, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        MediaData[] mediaDataArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) || (mediaDataArr = this.d) == null || mediaDataArr.length == 0) {
            return;
        }
        long drawingTime = getDrawingTime();
        int length = this.d.length;
        if (length == 1) {
            drawChild(canvas, this.a, drawingTime);
        } else if (length == 2) {
            drawChild(canvas, this.a, drawingTime);
            drawChild(canvas, this.b, drawingTime);
        } else if (length != 3) {
        } else {
            drawChild(canvas, this.a, drawingTime);
            drawChild(canvas, this.b, drawingTime);
            drawChild(canvas, this.c, drawingTime);
        }
    }

    public int getPadding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.e : invokeV.intValue;
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
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (mediaDataArr = this.d) == null || mediaDataArr.length == 0) {
            return;
        }
        int length = mediaDataArr.length;
        if (length == 1) {
            if (this.f) {
                float f = h[0];
                this.a.layout(0, 0, i4, i5 - i3);
            } else {
                TbImageView tbImageView = this.a;
                int i6 = this.e;
                tbImageView.layout(i6, 0, ((int) (h[4] + 0.5f)) + i6, i5 - i3);
            }
            this.b.layout(0, 0, 0, 0);
            this.c.layout(0, 0, 0, 0);
        } else if (length == 2) {
            if (this.f) {
                int i7 = (int) (h[1] + 0.5f);
                TbImageView tbImageView2 = this.a;
                int i8 = this.e;
                int i9 = i5 - i3;
                tbImageView2.layout(i8, 0, i8 + i7, i9);
                TbImageView tbImageView3 = this.b;
                int i10 = this.e;
                tbImageView3.layout(i7 + i10 + k, 0, (i4 - i10) - i2, i9);
            } else {
                int i11 = (int) (h[4] + 0.5f);
                TbImageView tbImageView4 = this.a;
                int i12 = this.e;
                int i13 = i5 - i3;
                tbImageView4.layout(i12, 0, i12 + i11, i13);
                TbImageView tbImageView5 = this.b;
                int i14 = this.e;
                int i15 = j;
                tbImageView5.layout(i14 + i11 + i15, 0, i14 + (i11 * 2) + i15, i13);
            }
            this.c.layout(0, 0, 0, 0);
        } else if (length != 3) {
        } else {
            if (this.f) {
                float[] fArr = h;
                int i16 = (int) (fArr[2] + 0.5f);
                int i17 = (int) (fArr[3] + 0.5f);
                int i18 = i5 - i3;
                this.a.layout(0, 0, i16, i18);
                this.b.layout(j + i16, 0, i4, i17);
                TbImageView tbImageView6 = this.c;
                int i19 = j;
                tbImageView6.layout(i16 + i19, i17 + i19, i4, i18);
                return;
            }
            int i20 = (int) (h[4] + 0.5f);
            TbImageView tbImageView7 = this.a;
            int i21 = this.e;
            int i22 = i5 - i3;
            tbImageView7.layout(i21, 0, i20 + i21, i22);
            TbImageView tbImageView8 = this.b;
            int i23 = this.e;
            int i24 = j;
            int i25 = i20 * 2;
            tbImageView8.layout(i20 + i23 + i24, 0, i23 + i25 + i24, i22);
            TbImageView tbImageView9 = this.c;
            int i26 = this.e;
            tbImageView9.layout(i25 + i26 + (j * 2), 0, (i4 - i26) - i2, i22);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            int i5 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            if (l == 0) {
                l = i5;
            }
            MediaData[] mediaDataArr = this.d;
            if (mediaDataArr != null && mediaDataArr.length != 0) {
                if (this.f) {
                    setMeasuredDimension(l, (int) (i[mediaDataArr.length - 1] + 0.5f));
                } else {
                    setMeasuredDimension(l, (int) (i[4] + 0.5f));
                }
                int length = this.d.length;
                if (length == 1) {
                    if (this.f) {
                        measureChild(this.a, l + 1073741824, ((int) (i[0] + 0.5f)) + 1073741824);
                    } else {
                        measureChild(this.a, ((int) (h[4] + 0.5f)) + 1073741824, ((int) (i[4] + 0.5f)) + 1073741824);
                    }
                    measureChild(this.b, 0, 0);
                    measureChild(this.c, 0, 0);
                    return;
                } else if (length == 2) {
                    if (this.f) {
                        i4 = ((int) (h[1] + 0.5f)) + 1073741824;
                        f = i[1];
                    } else {
                        i4 = ((int) (h[4] + 0.5f)) + 1073741824;
                        f = i[4];
                    }
                    int i6 = ((int) (f + 0.5f)) + 1073741824;
                    measureChild(this.a, i4, i6);
                    measureChild(this.b, i4, i6);
                    measureChild(this.c, 0, 0);
                    return;
                } else if (length != 3) {
                    return;
                } else {
                    if (this.f) {
                        float[] fArr = h;
                        float[] fArr2 = i;
                        int i7 = ((int) (fArr[3] + 0.5f)) + 1073741824;
                        int i8 = ((int) (fArr2[3] + 0.5f)) + 1073741824;
                        measureChild(this.a, ((int) (fArr[2] + 0.5f)) + 1073741824, ((int) (fArr2[2] + 0.5f)) + 1073741824);
                        measureChild(this.b, i7, i8);
                        measureChild(this.c, i7, i8);
                        return;
                    }
                    int i9 = ((int) (h[4] + 0.5f)) + 1073741824;
                    int i10 = ((int) (i[4] + 0.5f)) + 1073741824;
                    measureChild(this.a, i9, i10);
                    measureChild(this.b, i9, i10);
                    measureChild(this.c, i9, i10);
                    return;
                }
            }
            setMeasuredDimension(0, 0);
        }
    }

    public void setData(MediaData[] mediaDataArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, mediaDataArr) == null) {
            this.d = mediaDataArr;
            if (mediaDataArr != null && mediaDataArr.length > 0) {
                int length = mediaDataArr.length;
                if (length == 1) {
                    d(this.a, mediaDataArr[0]);
                    TbImageView tbImageView = this.b;
                    if (tbImageView != null) {
                        tbImageView.setTag(null);
                        this.b.setClickable(false);
                    }
                    TbImageView tbImageView2 = this.c;
                    if (tbImageView2 != null) {
                        tbImageView2.setTag(null);
                        this.c.setClickable(false);
                    }
                } else if (length == 2) {
                    d(this.a, mediaDataArr[0]);
                    d(this.b, this.d[1]);
                    TbImageView tbImageView3 = this.c;
                    if (tbImageView3 != null) {
                        tbImageView3.setTag(null);
                        this.c.setClickable(false);
                    }
                } else if (length == 3) {
                    d(this.a, mediaDataArr[0]);
                    d(this.b, this.d[1]);
                    d(this.c, this.d[2]);
                }
                requestLayout();
                invalidate();
                return;
            }
            TbImageView tbImageView4 = this.a;
            if (tbImageView4 != null) {
                tbImageView4.setTag(null);
            }
            TbImageView tbImageView5 = this.b;
            if (tbImageView5 != null) {
                tbImageView5.setTag(null);
            }
            TbImageView tbImageView6 = this.c;
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
            this.e = i2;
        }
    }

    public void setShowBig(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f = z;
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
        this.e = 7;
        this.f = false;
        this.g = context;
        b();
        TbadkCoreApplication.getInst().getSkinType();
        Drawable drawable = SkinManager.getDrawable(R.color.common_color_10220);
        this.a = new TbImageView(context);
        this.b = new TbImageView(context);
        this.c = new TbImageView(context);
        this.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.a.setDefaultBg(drawable);
        this.b.setDefaultBg(drawable);
        this.c.setDefaultBg(drawable);
        addView(this.a);
        addView(this.b);
        addView(this.c);
        this.e = (int) (this.e * m);
    }
}
