package com.baidu.tieba;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.fy6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class nl6 implements fy6.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView.h a;

    /* loaded from: classes6.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        public a(nl6 nl6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nl6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            float f;
            float f2;
            float f3;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && tbImageView != null && tbImageView.getImageMatrix() != null) {
                cn z = TbImageMemoryCache.u().z(lg.h().g(tbImageView.getUrl(), 10));
                int i2 = 0;
                if (z != null) {
                    i2 = z.r();
                    i = z.m();
                } else {
                    i = 0;
                }
                if (i2 != 0 && i != 0) {
                    int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    Matrix imageMatrix = tbImageView.getImageMatrix();
                    if (tbImageView.B() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                        float smartCropCenterPointWidthRatio = tbImageView.getSmartCropCenterPointWidthRatio();
                        float smartCropCenterPointHeightRatio = tbImageView.getSmartCropCenterPointHeightRatio();
                        float f4 = 0.0f;
                        if (i2 * height > width * i) {
                            f = height / i;
                            float f5 = i2;
                            float f6 = smartCropCenterPointWidthRatio * f5 * f;
                            float f7 = width;
                            float f8 = 0.5f * f7;
                            if (f6 < f8) {
                                f3 = 0.0f;
                            } else {
                                float f9 = f5 * f;
                                if (f9 - f6 < f8) {
                                    f3 = f7 - f9;
                                } else {
                                    f3 = f8 - f6;
                                }
                            }
                            f4 = f3;
                        } else {
                            float f10 = width / i2;
                            float f11 = i;
                            float f12 = smartCropCenterPointHeightRatio * f11 * f10;
                            float f13 = height;
                            float f14 = 0.5f * f13;
                            if (f12 < f14) {
                                f = f10;
                            } else {
                                float f15 = f11 * f10;
                                if (f15 - f12 < f14) {
                                    f2 = f13 - f15;
                                    f = f10;
                                } else {
                                    float f16 = f14 - f12;
                                    f = f10;
                                    f2 = f16;
                                }
                                imageMatrix.setScale(f, f);
                                imageMatrix.postTranslate(f4, f2);
                            }
                        }
                        f2 = 0.0f;
                        imageMatrix.setScale(f, f);
                        imageMatrix.postTranslate(f4, f2);
                    }
                }
            }
        }
    }

    public nl6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new a(this);
    }

    @Override // com.baidu.tieba.fy6.d
    public void a(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) {
            ((TbImageView) view2).setPlaceHolder(i);
        }
    }

    @Override // com.baidu.tieba.fy6.d
    public void c(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, view2, i) == null) {
            ((TbImageView) view2).setDefaultBgResource(i);
        }
    }

    @Override // com.baidu.tieba.fy6.d
    public void e(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view2, str) == null) {
            ((TbImageView) view2).N(str, 10, false);
        }
    }

    @Override // com.baidu.tieba.fy6.d
    public void f(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, view2, i) == null) {
            ((TbImageView) view2).setDefaultResource(i);
        }
    }

    @Override // com.baidu.tieba.fy6.d
    public void g(View view2, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, view2, scaleType) == null) {
            ((TbImageView) view2).setScaleType(scaleType);
        }
    }

    @Override // com.baidu.tieba.fy6.d
    public void h(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2, str) == null) {
            ((TbImageView) view2).N(str, 25, false);
        }
    }

    @Override // com.baidu.tieba.fy6.d
    public void b(View view2, fy6.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, cVar) != null) || cVar == null) {
            return;
        }
        TbImageView tbImageView = (TbImageView) view2;
        tbImageView.setRadiusById(cVar.a);
        tbImageView.setConrers(cVar.b);
        tbImageView.setBorderWidth(cVar.c);
        tbImageView.setBorderColor(cVar.d);
        tbImageView.setDrawCorner(true);
        tbImageView.setPlaceHolder(3);
        tbImageView.setLongIconSupport(true);
        tbImageView.setGifIconSupport(true);
    }

    @Override // com.baidu.tieba.fy6.d
    public View create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, context)) == null) {
            return new TbImageView(context);
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.fy6.d
    public void d(View view2, boolean z, float f, float f2) {
        TbImageView.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{view2, Boolean.valueOf(z), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            TbImageView tbImageView = (TbImageView) view2;
            tbImageView.setIsSmartCrop(z);
            tbImageView.setSmartCropCenterPointWidthRatio(f);
            tbImageView.setSmartCropCenterPointHeightRatio(f2);
            if (z) {
                hVar = this.a;
            } else {
                hVar = null;
            }
            tbImageView.setOnDrawListener(hVar);
        }
    }
}
