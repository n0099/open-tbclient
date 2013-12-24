package com.baidu.zeus;

import android.net.Uri;
import com.baidu.browser.webpool.BdWebPoolView;
import java.io.FileNotFoundException;
/* loaded from: classes.dex */
class ContentLoader extends StreamLoader {
    private String mContentType;
    private String mUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentLoader(String str, LoadListener loadListener) {
        super(loadListener);
        int lastIndexOf = str.lastIndexOf(63);
        if (lastIndexOf != -1) {
            this.mUrl = str.substring(0, lastIndexOf);
            this.mContentType = str.substring(lastIndexOf + 1);
            return;
        }
        this.mUrl = str;
    }

    private String errString(Exception exc) {
        String message = exc.getMessage();
        return message != null ? "The requested file was not found. " + message : "The requested file was not found.";
    }

    @Override // com.baidu.zeus.StreamLoader
    protected boolean setupStreamAndSendStatus() {
        Uri parse = Uri.parse(this.mUrl);
        if (parse == null) {
            this.mLoadListener.error(-14, "The requested file was not found. " + this.mUrl);
            return false;
        }
        try {
            this.mDataStream = this.mContext.getContentResolver().openInputStream(parse);
            this.mLoadListener.status(1, 1, BdWebPoolView.DELAYED_TIME, "OK");
            return true;
        } catch (FileNotFoundException e) {
            this.mLoadListener.error(-14, errString(e));
            return false;
        } catch (RuntimeException e2) {
            this.mLoadListener.error(-13, errString(e2));
            return false;
        }
    }

    @Override // com.baidu.zeus.StreamLoader
    protected void buildHeaders(Headers headers) {
        if (this.mContentType != null) {
            headers.setContentType("text/html");
        }
        headers.setCacheControl("no-store, no-cache");
    }
}
