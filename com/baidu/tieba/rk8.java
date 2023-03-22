package com.baidu.tieba;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.widget.ImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class rk8 extends qt5 {
    public static /* synthetic */ Interceptable $ic = null;
    public static double O = 0.5d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948124618, "Lcom/baidu/tieba/rk8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948124618, "Lcom/baidu/tieba/rk8;");
        }
    }

    /* loaded from: classes6.dex */
    public class a implements TbImageView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rk8 a;

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void a(TbImageView tbImageView, Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, tbImageView, canvas) == null) {
            }
        }

        public a(rk8 rk8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rk8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rk8Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.h
        public void b(TbImageView tbImageView, Canvas canvas) {
            int i;
            int i2;
            float f;
            float f2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbImageView, canvas) == null) && tbImageView != null && tbImageView.getImageMatrix() != null && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                Matrix imageMatrix = tbImageView.getImageMatrix();
                if (this.a.u) {
                    i = 17;
                } else {
                    i = 18;
                }
                rm u = TbImageMemoryCache.o().u(cg.h().g(tbImageView.getUrl(), i));
                int i3 = 0;
                if (u != null) {
                    i3 = u.r();
                    i2 = u.m();
                } else {
                    i2 = 0;
                }
                if (i3 != 0 && i2 != 0) {
                    int width = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                    int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                    if (i3 * height > width * i2) {
                        f = height;
                        f2 = i2;
                    } else {
                        f = width;
                        f2 = i3;
                    }
                    float f3 = f / f2;
                    imageMatrix.setScale(f3, f3);
                    imageMatrix.postTranslate(0.0f, 0.0f);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public rk8(qt5 qt5Var) {
        super(qt5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qt5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((qt5) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        l(true);
        v();
        p(TbConfig.getPostLineSpace(), 1.0f);
        A(0);
        m(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30));
        n(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12));
        j(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48), hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds48));
        t(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004), hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        k(hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_H_X004));
        this.J = hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds749);
        this.K = hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
        hi.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds26);
        this.M = new a(this);
    }

    @Override // com.baidu.tieba.qt5
    public int[] f(int i, int i2, int i3, int i4) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048576, this, i, i2, i3, i4)) == null) {
            if (i2 > 0 && i > 0 && i3 > 0 && i4 > 0) {
                if (this.v) {
                    float f = qt5.N;
                    if (f > 1.0f) {
                        float f2 = i;
                        if (f2 * f <= i3 * O) {
                            i3 = (int) (f2 * f);
                        }
                        i2 = (i2 * i3) / i;
                        if (i2 > 4096) {
                            this.s = ImageView.ScaleType.MATRIX;
                            i = i3;
                            i2 = 4096;
                        } else {
                            this.s = ImageView.ScaleType.CENTER_CROP;
                            i = i3;
                        }
                    }
                }
                return new int[]{i, i2};
            }
            return null;
        }
        return (int[]) invokeIIII.objValue;
    }
}
