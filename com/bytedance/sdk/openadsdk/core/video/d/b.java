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
/* loaded from: classes5.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0346b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC0346b interfaceC0346b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), str, interfaceC0346b}) == null) {
            new a(interfaceC0346b, j).execute(str);
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public InterfaceC0346b f30821a;

        /* renamed from: b  reason: collision with root package name */
        public long f30822b;

        public a(InterfaceC0346b interfaceC0346b, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0346b, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30822b = 0L;
            this.f30821a = interfaceC0346b;
            this.f30822b = j;
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
                    bitmap = mediaMetadataRetriever.getFrameAtTime(this.f30822b * 1000, 3);
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
                InterfaceC0346b interfaceC0346b = this.f30821a;
                if (interfaceC0346b != null) {
                    interfaceC0346b.a(bitmap);
                }
            }
        }
    }
}
