package com.bytedance.sdk.openadsdk.core.video.d;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1010b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC1010b interfaceC1010b) {
        new a(interfaceC1010b, j).execute(str);
    }

    /* loaded from: classes6.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private InterfaceC1010b f6720a;

        /* renamed from: b  reason: collision with root package name */
        private long f6721b;

        public a(InterfaceC1010b interfaceC1010b, long j) {
            this.f6721b = 0L;
            this.f6720a = interfaceC1010b;
            this.f6721b = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Bitmap doInBackground(String... strArr) {
            Bitmap bitmap = null;
            try {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                String str = strArr[0];
                if (str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.f6721b * 1000, 3);
                mediaMetadataRetriever.release();
                return bitmap;
            } catch (Throwable th) {
                u.c("MediaUtils", "MediaUtils doInBackground : ", th);
                return bitmap;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (this.f6720a != null) {
                this.f6720a.a(bitmap);
            }
        }
    }
}
