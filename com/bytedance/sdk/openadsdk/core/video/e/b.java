package com.bytedance.sdk.openadsdk.core.video.e;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0314b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC0314b interfaceC0314b) {
        new a(interfaceC0314b, j).execute(str);
    }

    /* loaded from: classes5.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public InterfaceC0314b f28386a;

        /* renamed from: b  reason: collision with root package name */
        public long f28387b;

        public a(InterfaceC0314b interfaceC0314b, long j) {
            this.f28387b = 0L;
            this.f28386a = interfaceC0314b;
            this.f28387b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmap = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.f28387b * 1000, 3);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Throwable th) {
                u.c("MediaUtils", "MediaUtils doInBackground : ", th);
                return bitmap;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            InterfaceC0314b interfaceC0314b = this.f28386a;
            if (interfaceC0314b != null) {
                interfaceC0314b.a(bitmap);
            }
        }
    }
}
