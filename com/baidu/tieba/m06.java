package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class m06 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947918902, "Lcom/baidu/tieba/m06;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947918902, "Lcom/baidu/tieba/m06;");
                return;
            }
        }
        a = new a(null);
    }

    /* loaded from: classes7.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @SuppressLint({"UseCompatLoadingForDrawables"})
        public final Drawable a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return TbadkCoreApplication.getInst().getDrawable(SkinManager.getResourceId(R.drawable.pic_use_header_28_n));
            }
            return (Drawable) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k06 a;

        public b(k06 k06Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k06Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k06Var;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                this.a.b();
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            CloseableReference<CloseableImage> result;
            Bitmap underlyingBitmap;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) == null) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                if (dataSource.isFinished() && (result = dataSource.getResult()) != null) {
                    k06 k06Var = this.a;
                    CloseableReference<CloseableImage> mo169clone = result.mo169clone();
                    Intrinsics.checkNotNullExpressionValue(mo169clone, "clone()");
                    try {
                        CloseableImage closeableImage = mo169clone.get();
                        if ((closeableImage instanceof CloseableBitmap) && (underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap()) != null && !underlyingBitmap.isRecycled() && underlyingBitmap.getConfig() != null) {
                            Bitmap tempBitmap = underlyingBitmap.copy(underlyingBitmap.getConfig(), false);
                            Intrinsics.checkNotNullExpressionValue(tempBitmap, "tempBitmap");
                            k06Var.a(tempBitmap);
                        }
                    } finally {
                        result.close();
                        mo169clone.close();
                    }
                }
            }
        }
    }

    public m06() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void a(String url, SimpleDraweeView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, url, imageView) == null) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            GenericDraweeHierarchyBuilder fadeDuration = new GenericDraweeHierarchyBuilder(imageView.getResources()).setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER).setFadeDuration(0);
            AbstractDraweeController build = Fresco.newDraweeControllerBuilder().setUri(url).setAutoPlayAnimations(true).build();
            Drawable a2 = a.a();
            if (a2 != null) {
                fadeDuration.setPlaceholderImage(a2);
            }
            imageView.setHierarchy(fadeDuration.build());
            imageView.setController(build);
        }
    }

    public final void b(String str, k06 k06Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, k06Var) == null) && !TextUtils.isEmpty(str) && k06Var != null) {
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), TbadkCoreApplication.getInst()).subscribe(new b(k06Var), UiThreadImmediateExecutorService.getInstance());
        }
    }

    public final Bitmap c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            Bitmap bitmap = null;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache = Fresco.getImagePipeline().fetchImageFromBitmapCache(ImageRequest.fromUri(Uri.parse(str)), CallerThreadExecutor.getInstance());
            try {
                CloseableReference<CloseableImage> result = fetchImageFromBitmapCache.getResult();
                if (result == null) {
                    return null;
                }
                CloseableBitmap closeableBitmap = (CloseableBitmap) result.get();
                if (closeableBitmap != null) {
                    bitmap = closeableBitmap.getUnderlyingBitmap();
                }
                CloseableReference.closeSafely(result);
                return bitmap;
            } finally {
                fetchImageFromBitmapCache.close();
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public void d(String str, k06 k06Var) {
        Bitmap c;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048579, this, str, k06Var) != null) || k06Var == null) {
            return;
        }
        if (Fresco.getImagePipeline().isInBitmapMemoryCache(ImageRequest.fromUri(str)) && (c = c(str)) != null) {
            k06Var.a(c);
        } else {
            b(str, k06Var);
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            Fresco.getImagePipeline().prefetchToBitmapCache(ImageRequest.fromUri(str), TbadkCoreApplication.getInst());
        }
    }
}
