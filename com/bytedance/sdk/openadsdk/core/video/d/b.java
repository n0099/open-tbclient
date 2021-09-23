package com.bytedance.sdk.openadsdk.core.video.d;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1914b {
        void a(Bitmap bitmap);
    }

    public static void a(long j2, String str, InterfaceC1914b interfaceC1914b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j2), str, interfaceC1914b}) == null) {
            new a(interfaceC1914b, j2).execute(str);
        }
    }

    /* loaded from: classes9.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public InterfaceC1914b f67438a;

        /* renamed from: b  reason: collision with root package name */
        public long f67439b;

        public a(InterfaceC1914b interfaceC1914b, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC1914b, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67439b = 0L;
            this.f67438a = interfaceC1914b;
            this.f67439b = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, strArr)) == null) {
                Bitmap bitmap = null;
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    String str = strArr[0];
                    if (str.startsWith("http")) {
                        mediaMetadataRetriever.setDataSource(str, new HashMap());
                    } else {
                        mediaMetadataRetriever.setDataSource(str);
                    }
                    bitmap = mediaMetadataRetriever.getFrameAtTime(this.f67439b * 1000, 3);
                    mediaMetadataRetriever.release();
                    return bitmap;
                } catch (Throwable th) {
                    k.c("MediaUtils", "MediaUtils doInBackground : ", th);
                    return bitmap;
                }
            }
            return (Bitmap) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                super.onPostExecute(bitmap);
                InterfaceC1914b interfaceC1914b = this.f67438a;
                if (interfaceC1914b != null) {
                    interfaceC1914b.a(bitmap);
                }
            }
        }
    }
}
