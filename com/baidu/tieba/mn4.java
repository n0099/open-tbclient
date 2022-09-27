package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.BDPTask;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.pp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class mn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements ss {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.ss
        public void a(String str, rs rsVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, rsVar) == null) {
                mn4.d(this.a, str, rsVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements us {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // com.baidu.tieba.us
        public void a(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, str, i) == null) {
                mn4.c(str);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements qs {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public c(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
        }

        @Override // com.baidu.tieba.qs
        @Nullable
        public Map<String, Object> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                String zid = TbadkCoreApplication.getInst().getZid(this.a, null, 0, null);
                HashMap hashMap = new HashMap();
                hashMap.put("zid", zid);
                return hashMap;
            }
            return (Map) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs a;

        public d(rs rsVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rsVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rsVar;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dataSource) == null) {
                this.a.onError();
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            Throwable th;
            CloseableReference<CloseableImage> closeableReference;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataSource) != null) {
                return;
            }
            try {
                closeableReference = dataSource.getResult();
                if (closeableReference != null) {
                    try {
                        CloseableImage closeableImage = closeableReference.get();
                        if (closeableImage instanceof CloseableBitmap) {
                            Bitmap underlyingBitmap = ((CloseableBitmap) closeableImage).getUnderlyingBitmap();
                            if (underlyingBitmap != null && !underlyingBitmap.isRecycled()) {
                                this.a.a(underlyingBitmap.copy(underlyingBitmap.getConfig(), true));
                            } else {
                                this.a.onError();
                            }
                        } else {
                            this.a.onError();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        CloseableReference.closeSafely(closeableReference);
                        throw th;
                    }
                }
                CloseableReference.closeSafely(closeableReference);
            } catch (Throwable th3) {
                th = th3;
                closeableReference = null;
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
        if (currentActivity instanceof TbPageContextSupport) {
            if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    UtilHelper.dealOneScheme(currentActivity, parse.toString());
                    return;
                }
                return;
            }
            UrlManager.getInstance().dealOneLink(((TbPageContextSupport) currentActivity).getPageContext(), new String[]{str});
        }
    }

    public static void d(Context context, String str, rs rsVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65539, null, context, str, rsVar) == null) || context == null || TextUtils.isEmpty(str) || rsVar == null) {
            return;
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setProgressiveRenderingEnabled(true).build(), context).subscribe(new d(rsVar), CallerThreadExecutor.getInstance());
    }

    public static void e(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context) == null) || context == null) {
            return;
        }
        pp.b bVar = new pp.b(context);
        bVar.b(false);
        bVar.g(lv.d());
        bVar.c(lv.c());
        bVar.d(new c(context));
        bVar.f(new b());
        bVar.e(new a(context));
        BDPTask.m.x(bVar.a());
    }
}
