package com.baidu.tieba;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.apps.media.chooser.activity.SwanAppAlbumPreviewActivity;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.facade.picture.wallpaper.PictureWallpaperActivity;
import com.baidu.tieba.xt1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes7.dex */
public class yt3 implements os1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.os1
    public void c(GenericDraweeHierarchy genericDraweeHierarchy, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, genericDraweeHierarchy, z) == null) {
        }
    }

    @Override // com.baidu.tieba.os1
    public ImageRequestBuilder e(ImageRequestBuilder imageRequestBuilder, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, imageRequestBuilder, map)) == null) ? imageRequestBuilder : (ImageRequestBuilder) invokeLL.objValue;
    }

    /* loaded from: classes7.dex */
    public class a implements xt1.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        public a(yt3 yt3Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt3Var, context};
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
    }

    /* loaded from: classes7.dex */
    public static class b implements pm3<OutputStream, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PooledByteBufferInputStream a;

        public b(PooledByteBufferInputStream pooledByteBufferInputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pooledByteBufferInputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pooledByteBufferInputStream;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pm3
        /* renamed from: b */
        public Boolean a(OutputStream outputStream) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream)) == null) {
                if (yn4.g(this.a, outputStream) > 0) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class c extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> implements Runnable, x23 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final JSONObject b;
        public final /* synthetic */ yt3 c;

        public c(yt3 yt3Var, Context context, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yt3Var, context, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = yt3Var;
            this.a = context;
            this.b = jSONObject;
        }

        @Override // com.baidu.tieba.x23
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                return;
            }
            this.c.l(this.a, this.b, this);
        }

        public final void c(boolean z) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
                if (z) {
                    i = R.string.obfuscated_res_0x7f0f1331;
                } else {
                    i = R.string.obfuscated_res_0x7f0f132e;
                }
                m73.f(this.a, i).v();
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, dataSource) == null) {
                c(false);
            }
        }

        @Override // com.baidu.tieba.x23
        public void b(int i, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
                c(false);
            }
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onNewResultImpl(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048580, this, dataSource) != null) || !dataSource.isFinished()) {
                return;
            }
            CloseableReference<PooledByteBuffer> result = dataSource.getResult();
            if (result == null) {
                c(false);
                return;
            }
            PooledByteBufferInputStream pooledByteBufferInputStream = new PooledByteBufferInputStream(result.get());
            try {
                c(yt3.m(this.a, pooledByteBufferInputStream));
            } finally {
                CloseableReference.closeSafely(result);
                yn4.d(pooledByteBufferInputStream);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                yt3.j(this.a, this);
            }
        }
    }

    public yt3() {
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

    public static void j(Context context, x23 x23Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, x23Var) == null) {
            w23.e("android.permission.WRITE_EXTERNAL_STORAGE", new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3, context, x23Var);
        }
    }

    @Override // com.baidu.tieba.os1
    public void a(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, jSONObject) == null) {
            PictureWallpaperActivity.J(context, jSONObject.optString("imageUrl"), jSONObject.optString(Config.LAUNCH_REFERER));
        }
    }

    public static boolean m(Context context, PooledByteBufferInputStream pooledByteBufferInputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, pooledByteBufferInputStream)) == null) {
            try {
                ImageFormat imageFormat = ImageFormatChecker.getImageFormat(pooledByteBufferInputStream);
                if (imageFormat != null) {
                    String fileExtension = imageFormat.getFileExtension();
                    if (!TextUtils.isEmpty(fileExtension)) {
                        String format = String.format("IMG_%s.%s", new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.CHINA).format(new Date()), fileExtension);
                        String format2 = String.format("image/%s", fileExtension);
                        if (Build.VERSION.SDK_INT >= 29) {
                            return n(context, pooledByteBufferInputStream, format2, format);
                        }
                        String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + "Image" + File.separator + format;
                        boolean q = sk3.q(str, new b(pooledByteBufferInputStream));
                        if (q) {
                            sk3.r(context, str);
                        }
                        return q;
                    }
                }
                return false;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                yn4.d(pooledByteBufferInputStream);
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean n(@NonNull Context context, @NonNull InputStream inputStream, @NonNull String str, @NonNull String str2) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65542, null, context, inputStream, str, str2)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str2);
            contentValues.put("mime_type", str);
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/Image/");
            } else {
                contentValues.put("_data", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath() + "/Image");
            }
            Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (insert == null) {
                u42.o("FacadeSwanAppImageImpl", "insert uri is null");
                return false;
            }
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
                if (openOutputStream == null) {
                    yn4.d(openOutputStream);
                    return false;
                }
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        openOutputStream.write(bArr, 0, read);
                    } else {
                        yn4.d(openOutputStream);
                        return true;
                    }
                }
            } catch (IOException unused) {
                yn4.d(null);
                return false;
            } catch (Throwable th) {
                yn4.d(null);
                throw th;
            }
        } else {
            return invokeLLLL.booleanValue;
        }
    }

    @Override // com.baidu.tieba.os1
    public void b(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject) != null) || jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("index");
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            ArrayList<MediaModel> arrayList = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                String optString = optJSONArray.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(new ImageModel(optString));
                }
            }
            k(context, arrayList, optInt);
        }
    }

    @Override // com.baidu.tieba.os1
    public void f(Context context, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, context, jSONObject) == null) {
            xt1 v = br2.v();
            if (v.i()) {
                String optString = jSONObject.optString("imageUrl");
                if (!TextUtils.isEmpty(optString)) {
                    v.C(context, new yt1().H(optString).I(true), new a(this, context));
                    return;
                } else {
                    m73.g(context, "保存失败").v();
                    return;
                }
            }
            new c(this, context, jSONObject).run();
        }
    }

    @Override // com.baidu.tieba.os1
    public void d(Context context, String[] strArr, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048579, this, context, strArr, i) == null) && strArr != null && strArr.length > 0) {
            ArrayList<MediaModel> arrayList = new ArrayList<>(strArr.length);
            for (String str : strArr) {
                arrayList.add(new ImageModel(str));
            }
            k(context, arrayList, i);
        }
    }

    public final void k(Context context, ArrayList<MediaModel> arrayList, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, context, arrayList, i) == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("mediaModels", arrayList);
            bundle.putInt("previewPosition", i);
            bundle.putString("previewFrom", UnitedSchemeConstants.SCHEME_INVOKE_TYPE_OUTSIDE);
            Intent intent = new Intent(context, SwanAppAlbumPreviewActivity.class);
            intent.putExtra("launchParams", bundle);
            context.startActivity(intent);
        }
    }

    public final void l(Context context, JSONObject jSONObject, BaseDataSubscriber<CloseableReference<PooledByteBuffer>> baseDataSubscriber) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, context, jSONObject, baseDataSubscriber) == null) {
            String optString = jSONObject.optString("imageUrl");
            String optString2 = jSONObject.optString(Config.LAUNCH_REFERER);
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(optString));
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(optString2)) {
                hashMap.put(Config.LAUNCH_REFERER, optString2);
            }
            br2.C().e(newBuilderWithSource, hashMap);
            Fresco.getImagePipeline().fetchEncodedImage(newBuilderWithSource.build(), context).subscribe(baseDataSubscriber, UiThreadImmediateExecutorService.getInstance());
        }
    }
}
