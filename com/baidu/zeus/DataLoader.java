package com.baidu.zeus;

import com.baidu.zeus.util.Base64;
import java.io.ByteArrayInputStream;
/* loaded from: classes.dex */
class DataLoader extends StreamLoader {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DataLoader(String str, LoadListener loadListener) {
        super(loadListener);
        byte[] bytes;
        String substring = str.substring("data:".length());
        int indexOf = substring.indexOf(44);
        if (indexOf != -1) {
            String substring2 = substring.substring(0, indexOf);
            bytes = substring.substring(indexOf + 1).getBytes();
            loadListener.parseContentTypeHeader(substring2);
            if ("base64".equals(loadListener.transferEncoding())) {
                bytes = Base64.decode(bytes);
            }
        } else {
            bytes = substring.getBytes();
        }
        if (bytes != null) {
            this.mDataStream = new ByteArrayInputStream(bytes);
            this.mContentLength = bytes.length;
        }
    }

    @Override // com.baidu.zeus.StreamLoader
    protected boolean setupStreamAndSendStatus() {
        if (this.mDataStream != null) {
            this.mLoadListener.status(1, 1, 200, "OK");
            return true;
        }
        this.mLoadListener.error(-1, this.mContext.getString(17039600));
        return false;
    }

    @Override // com.baidu.zeus.StreamLoader
    protected void buildHeaders(Headers headers) {
    }
}
