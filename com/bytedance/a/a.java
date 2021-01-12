package com.bytedance.a;

import android.util.Log;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public interface a {
    void h(String str, String str2, @Nullable Throwable th);

    void j(String str, String str2, @Nullable Throwable th);

    void k(String str, String str2, @Nullable Throwable th);

    /* renamed from: com.bytedance.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0980a implements a {
        @Override // com.bytedance.a.a
        public void h(String str, String str2, Throwable th) {
            Log.v(str, str2, th);
        }

        @Override // com.bytedance.a.a
        public void j(String str, String str2, Throwable th) {
            Log.d(str, str2, th);
        }

        @Override // com.bytedance.a.a
        public void k(String str, String str2, Throwable th) {
            Log.e(str, str2, th);
        }
    }
}
