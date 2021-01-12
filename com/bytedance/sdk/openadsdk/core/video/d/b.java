package com.bytedance.sdk.openadsdk.core.video.d;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1006b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC1006b interfaceC1006b) {
        new a(interfaceC1006b, j).execute(str);
    }

    /* loaded from: classes4.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private InterfaceC1006b f6718a;

        /* renamed from: b  reason: collision with root package name */
        private long f6719b;

        public a(InterfaceC1006b interfaceC1006b, long j) {
            this.f6719b = 0L;
            this.f6718a = interfaceC1006b;
            this.f6719b = j;
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
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.f6719b * 1000, 3);
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
            if (this.f6718a != null) {
                this.f6718a.a(bitmap);
            }
        }
    }
}
