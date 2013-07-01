package com.baidu.zeus;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PreFileLoader extends StreamLoader {
    private Context mContext;
    private String mPath;

    PreFileLoader(String str, LoadListener loadListener, Context context) {
        super(loadListener);
        this.mContext = context;
        this.mPath = URLUtil.stripAnchor(str.substring("file://".length()));
    }

    private String errString(Exception exc) {
        String message = exc.getMessage();
        return message != null ? "The requested file was not found. " + message : "The requested file was not found.";
    }

    @Override // com.baidu.zeus.StreamLoader
    protected boolean setupStreamAndSendStatus() {
        try {
            this.mDataStream = new FileInputStream(this.mPath);
            this.mContentLength = new File(this.mPath).length();
            this.mLoadListener.status(1, 1, 0, "OK");
            return true;
        } catch (FileNotFoundException e) {
            this.mLoadListener.error(-14, errString(e));
            return false;
        } catch (IOException e2) {
            this.mLoadListener.error(-13, errString(e2));
            return false;
        }
    }

    @Override // com.baidu.zeus.StreamLoader
    protected void buildHeaders(Headers headers) {
        headers.setContentType("application/xhtml+xml");
        headers.setCacheControl("no-store, no-cache");
    }

    public static void requestUrl(String str, LoadListener loadListener, Context context) {
        new PreFileLoader(str, loadListener, context).load();
    }
}
