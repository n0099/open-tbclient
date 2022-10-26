package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes6.dex */
public abstract class uy1 extends zy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-359393985, "Lcom/baidu/tieba/uy1$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-359393985, "Lcom/baidu/tieba/uy1$a;");
                    return;
                }
            }
            int[] iArr = new int[PathType.values().length];
            a = iArr;
            try {
                iArr[PathType.BD_FILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[PathType.RELATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[PathType.NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[PathType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public uy1(Context context, vy1 vy1Var) {
        super(context, vy1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vy1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (az1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Uri W(String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            PathType s = ua3.s(str);
            m33 M = m33.M();
            if (M != null) {
                str2 = M.b;
                str3 = M.k0();
            } else {
                str2 = null;
                str3 = null;
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return null;
            }
            int i = a.a[s.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return Uri.parse(str);
                }
                File file = new File(str);
                if (file.exists()) {
                    return Uri.fromFile(file);
                }
                String L = ua3.L(str, M, str3);
                if (TextUtils.isEmpty(L)) {
                    return null;
                }
                return Uri.fromFile(new File(L));
            }
            String M2 = ua3.M(str, str2);
            if (TextUtils.isEmpty(M2)) {
                return null;
            }
            return Uri.fromFile(new File(M2));
        }
        return (Uri) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zy1
    /* renamed from: T */
    public void O(SimpleDraweeView simpleDraweeView, vy1 vy1Var, e02 e02Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, simpleDraweeView, vy1Var, e02Var) == null) {
            super.C(simpleDraweeView, vy1Var, e02Var);
            if (e02Var.a(9)) {
                U(simpleDraweeView, vy1Var);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zy1, com.baidu.tieba.bz1
    /* renamed from: S */
    public e02 k(vy1 vy1Var, vy1 vy1Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, vy1Var, vy1Var2)) == null) {
            e02 k = super.k(vy1Var, vy1Var2);
            if (!TextUtils.equals(vy1Var.t, vy1Var2.t)) {
                k.b(9);
            }
            return k;
        }
        return (e02) invokeLL.objValue;
    }

    public void U(SimpleDraweeView simpleDraweeView, vy1 vy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, simpleDraweeView, vy1Var) == null) {
            V(simpleDraweeView, vy1Var, null);
        }
    }

    public final void V(SimpleDraweeView simpleDraweeView, vy1 vy1Var, BaseControllerListener baseControllerListener) {
        Uri W;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, simpleDraweeView, vy1Var, baseControllerListener) != null) || vy1Var.j == null) {
            return;
        }
        if (bz1.h) {
            Log.d("Component-SimpleDrawee", "renderImageStyle");
        }
        String str = vy1Var.t;
        if (TextUtils.isEmpty(str) || (W = W(str)) == null) {
            return;
        }
        m02.i("Component-SimpleDrawee", "Image Uri:" + W);
        PipelineDraweeControllerBuilder pipelineDraweeControllerBuilder = (PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController());
        if (baseControllerListener != null) {
            pipelineDraweeControllerBuilder.setControllerListener(baseControllerListener);
        }
        HashMap hashMap = new HashMap();
        String g0 = ga2.U().g0();
        if (!TextUtils.isEmpty(g0)) {
            hashMap.put("User-Agent", g0);
        }
        String b = tg3.b();
        if (!TextUtils.isEmpty(b) && tg3.c(W.toString())) {
            hashMap.put("Referer", b);
        }
        go1 C = tm2.C();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(W);
        C.e(newBuilderWithSource, hashMap);
        pipelineDraweeControllerBuilder.setImageRequest(newBuilderWithSource.build());
        DraweeController build = pipelineDraweeControllerBuilder.build();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadius(vy1Var.n);
        GenericDraweeHierarchy build2 = new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).build();
        build2.setRoundingParams(roundingParams);
        build2.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        simpleDraweeView.setHierarchy(build2);
        simpleDraweeView.setController(build);
    }
}
