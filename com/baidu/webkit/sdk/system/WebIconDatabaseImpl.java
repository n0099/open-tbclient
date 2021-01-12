package com.baidu.webkit.sdk.system;

import android.graphics.Bitmap;
import android.os.Looper;
import android.webkit.WebIconDatabase;
import com.baidu.webkit.sdk.WebIconDatabase;
/* loaded from: classes14.dex */
final class WebIconDatabaseImpl extends WebIconDatabase {

    /* loaded from: classes14.dex */
    private static class IconWrapper implements WebIconDatabase.IconListener {
        private final WebIconDatabase.IconListener mListener;

        private IconWrapper(WebIconDatabase.IconListener iconListener) {
            this.mListener = iconListener;
        }

        static WebIconDatabase.IconListener from(WebIconDatabase.IconListener iconListener) {
            if (iconListener == null) {
                return null;
            }
            return new IconWrapper(iconListener);
        }

        @Override // android.webkit.WebIconDatabase.IconListener
        public void onReceivedIcon(String str, Bitmap bitmap) {
            this.mListener.onReceivedIcon(str, bitmap);
        }
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void close() {
        android.webkit.WebIconDatabase.getInstance().close();
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void open(String str) {
        Looper.prepare();
        android.webkit.WebIconDatabase.getInstance().open(str);
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void releaseIconForPageUrl(String str) {
        android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void removeAllIcons() {
        android.webkit.WebIconDatabase.getInstance().removeAllIcons();
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void requestIconForPageUrl(String str, WebIconDatabase.IconListener iconListener) {
        android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, IconWrapper.from(iconListener));
    }

    @Override // com.baidu.webkit.sdk.WebIconDatabase
    public final void retainIconForPageUrl(String str) {
        android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
    }
}
