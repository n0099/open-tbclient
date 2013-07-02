package com.baidu.zeus;

import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes.dex */
class FileLoader extends StreamLoader {
    private static final String LOGTAG = "webkit";
    static final int TYPE_ASSET = 1;
    static final int TYPE_FILE = 3;
    static final int TYPE_RES = 2;
    private boolean mAllowFileAccess;
    private String mPath;
    private int mType;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FileLoader(String str, LoadListener loadListener, int i, boolean z) {
        super(loadListener);
        this.mType = i;
        this.mAllowFileAccess = z;
        int indexOf = str.indexOf(63);
        if (this.mType == 1) {
            this.mPath = indexOf > 0 ? URLUtil.stripAnchor(str.substring("file:///android_asset/".length(), indexOf)) : URLUtil.stripAnchor(str.substring("file:///android_asset/".length()));
        } else if (this.mType == 2) {
            this.mPath = indexOf > 0 ? URLUtil.stripAnchor(str.substring("file:///android_res/".length(), indexOf)) : URLUtil.stripAnchor(str.substring("file:///android_res/".length()));
        } else {
            this.mPath = indexOf > 0 ? URLUtil.stripAnchor(str.substring("file://".length(), indexOf)) : URLUtil.stripAnchor(str.substring("file://".length()));
        }
    }

    private String errString(Exception exc) {
        String message = exc.getMessage();
        return message != null ? "The requested file was not found. " + message : "The requested file was not found.";
    }

    @Override // com.baidu.zeus.StreamLoader
    protected boolean setupStreamAndSendStatus() {
        try {
            try {
                if (this.mType == 1) {
                    try {
                        this.mDataStream = this.mContext.getAssets().open(this.mPath);
                    } catch (FileNotFoundException e) {
                        this.mDataStream = this.mContext.getAssets().openNonAsset(this.mPath);
                    }
                } else if (this.mType == 2) {
                    if (this.mPath == null || this.mPath.length() == 0) {
                        Log.e(LOGTAG, "Need a path to resolve the res file");
                        this.mLoadListener.error(-13, this.mContext.getString(17039611));
                        return false;
                    }
                    int indexOf = this.mPath.indexOf(47);
                    int indexOf2 = this.mPath.indexOf(46, indexOf);
                    if (indexOf == -1 || indexOf2 == -1) {
                        Log.e(LOGTAG, "Incorrect res path: " + this.mPath);
                        this.mLoadListener.error(-13, this.mContext.getString(17039611));
                        return false;
                    }
                    String substring = this.mPath.substring(0, indexOf);
                    String substring2 = this.mPath.substring(indexOf + 1, indexOf2);
                    String str = null;
                    try {
                        int i = this.mContext.getApplicationContext().getClassLoader().loadClass(this.mContext.getPackageName() + ".R$" + substring).getField(substring2).getInt(null);
                        TypedValue typedValue = new TypedValue();
                        this.mContext.getResources().getValue(i, typedValue, true);
                        if (typedValue.type == 3) {
                            this.mDataStream = this.mContext.getAssets().openNonAsset(typedValue.assetCookie, typedValue.string.toString(), 2);
                        } else {
                            str = "Only support TYPE_STRING for the res files";
                        }
                    } catch (ClassNotFoundException e2) {
                        str = "Can't find class:  " + this.mContext.getPackageName() + ".R$" + substring;
                    } catch (IllegalAccessException e3) {
                        str = "Caught IllegalAccessException: " + e3;
                    } catch (IllegalArgumentException e4) {
                        str = "Caught IllegalArgumentException: " + e4;
                    } catch (NoSuchFieldException e5) {
                        str = "Can't find field:  " + substring2 + " in " + this.mContext.getPackageName() + ".R$" + substring;
                    } catch (SecurityException e6) {
                        str = "Caught SecurityException: " + e6;
                    }
                    if (str != null) {
                        this.mLoadListener.error(-13, this.mContext.getString(17039611));
                        return false;
                    }
                } else if (!this.mAllowFileAccess) {
                    this.mLoadListener.error(-13, "The requested file was not found.");
                    return false;
                } else {
                    this.mDataStream = new FileInputStream(this.mPath);
                    this.mContentLength = new File(this.mPath).length();
                }
                this.mLoadListener.status(1, 1, 200, "OK");
                return true;
            } catch (FileNotFoundException e7) {
                this.mLoadListener.error(-14, errString(e7));
                return false;
            }
        } catch (IOException e8) {
            this.mLoadListener.error(-13, errString(e8));
            return false;
        }
    }

    @Override // com.baidu.zeus.StreamLoader
    protected void buildHeaders(Headers headers) {
    }
}
