package com.bytedance.sdk.openadsdk.core.video.e;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.AsyncTask;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0311b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC0311b interfaceC0311b) {
        new a(interfaceC0311b, j).execute(str);
    }

    /* loaded from: classes6.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public InterfaceC0311b f28700a;

        /* renamed from: b  reason: collision with root package name */
        public long f28701b;

        public a(InterfaceC0311b interfaceC0311b, long j) {
            this.f28701b = 0L;
            this.f28700a = interfaceC0311b;
            this.f28701b = j;
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
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.f28701b * 1000, 3);
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
            InterfaceC0311b interfaceC0311b = this.f28700a;
            if (interfaceC0311b != null) {
                interfaceC0311b.a(bitmap);
            }
        }
    }
}
