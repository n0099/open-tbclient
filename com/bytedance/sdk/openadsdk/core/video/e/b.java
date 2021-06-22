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
    public interface InterfaceC0302b {
        void a(Bitmap bitmap);
    }

    public static void a(long j, String str, InterfaceC0302b interfaceC0302b) {
        new a(interfaceC0302b, j).execute(str);
    }

    /* loaded from: classes6.dex */
    public static class a extends AsyncTask<String, Integer, Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        public InterfaceC0302b f28624a;

        /* renamed from: b  reason: collision with root package name */
        public long f28625b;

        public a(InterfaceC0302b interfaceC0302b, long j) {
            this.f28625b = 0L;
            this.f28624a = interfaceC0302b;
            this.f28625b = j;
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
                bitmap = mediaMetadataRetriever.getFrameAtTime(this.f28625b * 1000, 3);
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
            InterfaceC0302b interfaceC0302b = this.f28624a;
            if (interfaceC0302b != null) {
                interfaceC0302b.a(bitmap);
            }
        }
    }
}
