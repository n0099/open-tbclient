package com.baidu.webkit.sdk;
/* loaded from: classes14.dex */
public class MimeTypeMap {
    private static final MimeTypeMap sMimeTypeMap = new MimeTypeMap();

    public static String getFileExtensionFromUrl(String str) {
        return WebViewFactory.getProvider().getMimeTypeMap().getFileExtensionFromUrlImpl(str);
    }

    public static MimeTypeMap getSingleton() {
        return sMimeTypeMap;
    }

    public String getExtensionFromMimeType(String str) {
        return WebViewFactory.getProvider().getMimeTypeMap().getExtensionFromMimeType(str);
    }

    public String getFileExtensionFromUrlImpl(String str) {
        return "";
    }

    public String getMimeTypeFromExtension(String str) {
        return WebViewFactory.getProvider().getMimeTypeMap().getMimeTypeFromExtension(str);
    }

    public boolean hasExtension(String str) {
        return WebViewFactory.getProvider().getMimeTypeMap().hasExtension(str);
    }

    public boolean hasMimeType(String str) {
        return WebViewFactory.getProvider().getMimeTypeMap().hasMimeType(str);
    }
}
