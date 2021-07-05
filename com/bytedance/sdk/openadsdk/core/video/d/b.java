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
import com.bytedance.sdk.component.utils.j;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0344b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC0344b interfaceC0344b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Long.valueOf(j), str, interfaceC0344b}) == null) {
            new a(interfaceC0344b, j).execute(str);
        }
    }

    /* loaded from: classes6.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public InterfaceC0344b f30535a;

        /* renamed from: b  reason: collision with root package name */
        public long f30536b;

        public a(InterfaceC0344b interfaceC0344b, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {interfaceC0344b, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30536b = 0L;
            this.f30535a = interfaceC0344b;
            this.f30536b = j;
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
                    bitmap = mediaMetadataRetriever.getFrameAtTime(this.f30536b * 1000, 3);
                    mediaMetadataRetriever.release();
                    return bitmap;
                } catch (Throwable th) {
                    j.c("MediaUtils", "MediaUtils doInBackground : ", th);
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
                InterfaceC0344b interfaceC0344b = this.f30535a;
                if (interfaceC0344b != null) {
                    interfaceC0344b.a(bitmap);
                }
            }
        }
    }
}
