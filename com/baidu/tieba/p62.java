package com.baidu.tieba;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.storage.PathType;
import com.baidu.tieba.q62;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes7.dex */
public abstract class p62<V extends SimpleDraweeView, M extends q62> extends u62<V, M> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-564385856, "Lcom/baidu/tieba/p62$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-564385856, "Lcom/baidu/tieba/p62$a;");
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
    public p62(@Nullable Context context, @NonNull M m) {
        super(context, m);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (v62) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Uri W(@NonNull String str) {
        InterceptResult invokeL;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            PathType s = pi3.s(str);
            hb3 M = hb3.M();
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
                String L = pi3.L(str, M, str3);
                if (TextUtils.isEmpty(L)) {
                    return null;
                }
                return Uri.fromFile(new File(L));
            }
            String M2 = pi3.M(str, str2);
            if (TextUtils.isEmpty(M2)) {
                return null;
            }
            return Uri.fromFile(new File(M2));
        }
        return (Uri) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62
    /* renamed from: T */
    public void O(@NonNull V v, @NonNull M m, @NonNull z72 z72Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, v, m, z72Var) == null) {
            super.C(v, m, z72Var);
            if (z72Var.a(9)) {
                U(v, m);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.u62, com.baidu.tieba.w62
    @NonNull
    /* renamed from: S */
    public z72 k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, m, m2)) == null) {
            z72 k = super.k(m, m2);
            if (!TextUtils.equals(m.t, m2.t)) {
                k.b(9);
            }
            return k;
        }
        return (z72) invokeLL.objValue;
    }

    public void U(@NonNull V v, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, v, m) == null) {
            V(v, m, null);
        }
    }

    public final void V(@NonNull V v, @NonNull M m, @Nullable BaseControllerListener<ImageInfo> baseControllerListener) {
        Uri W;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(1048582, this, v, m, baseControllerListener) != null) || m.j == null) {
            return;
        }
        if (w62.h) {
            Log.d("Component-SimpleDrawee", "renderImageStyle");
        }
        String str = m.t;
        if (TextUtils.isEmpty(str) || (W = W(str)) == null) {
            return;
        }
        h82.i("Component-SimpleDrawee", "Image Uri:" + W);
        PipelineDraweeControllerBuilder oldController = Fresco.newDraweeControllerBuilder().setOldController(v.getController());
        if (baseControllerListener != null) {
            oldController.setControllerListener(baseControllerListener);
        }
        HashMap hashMap = new HashMap();
        String g0 = bi2.U().g0();
        if (!TextUtils.isEmpty(g0)) {
            hashMap.put("User-Agent", g0);
        }
        String b = oo3.b();
        if (!TextUtils.isEmpty(b) && oo3.c(W.toString())) {
            hashMap.put("Referer", b);
        }
        bw1 C = ou2.C();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(W);
        C.e(newBuilderWithSource, hashMap);
        oldController.setImageRequest(newBuilderWithSource.build());
        AbstractDraweeController build = oldController.build();
        RoundingParams roundingParams = new RoundingParams();
        roundingParams.setCornersRadius(m.n);
        GenericDraweeHierarchy build2 = new GenericDraweeHierarchyBuilder(v.getResources()).build();
        build2.setRoundingParams(roundingParams);
        build2.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
        v.setHierarchy(build2);
        v.setController(build);
    }
}
