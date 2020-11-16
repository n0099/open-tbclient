package com.baidu.webkit.sdk.system;

import com.baidu.webkit.sdk.MimeTypeMap;
/* loaded from: classes5.dex */
final class MimeTypeMapImpl extends MimeTypeMap {
    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final String getExtensionFromMimeType(String str) {
        return android.webkit.MimeTypeMap.getSingleton().getExtensionFromMimeType(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final String getFileExtensionFromUrlImpl(String str) {
        return android.webkit.MimeTypeMap.getFileExtensionFromUrl(str);
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final String getMimeTypeFromExtension(String str) {
        return android.webkit.MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final boolean hasExtension(String str) {
        return android.webkit.MimeTypeMap.getSingleton().hasExtension(str);
    }

    @Override // com.baidu.webkit.sdk.MimeTypeMap
    public final boolean hasMimeType(String str) {
        return android.webkit.MimeTypeMap.getSingleton().hasMimeType(str);
    }
}
