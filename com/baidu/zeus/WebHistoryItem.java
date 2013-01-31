package com.baidu.zeus;

import android.graphics.Bitmap;
/* loaded from: classes.dex */
public class WebHistoryItem implements Cloneable {
    private static int sNextId = 0;
    private Object mCustomData;
    private Bitmap mFavicon;
    private byte[] mFlattenedData;
    private final int mId;
    private String mOriginalUrl;
    private String mTitle;
    private String mTouchIconUrl;
    private String mUrl;

    private native void inflate(int i, byte[] bArr);

    private WebHistoryItem() {
        synchronized (WebHistoryItem.class) {
            int i = sNextId;
            sNextId = i + 1;
            this.mId = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebHistoryItem(byte[] bArr) {
        this.mUrl = null;
        this.mFlattenedData = bArr;
        synchronized (WebHistoryItem.class) {
            int i = sNextId;
            sNextId = i + 1;
            this.mId = i;
        }
    }

    private WebHistoryItem(WebHistoryItem webHistoryItem) {
        this.mUrl = webHistoryItem.mUrl;
        this.mTitle = webHistoryItem.mTitle;
        this.mFlattenedData = webHistoryItem.mFlattenedData;
        this.mFavicon = webHistoryItem.mFavicon;
        this.mId = webHistoryItem.mId;
    }

    public int getId() {
        return this.mId;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public Bitmap getFavicon() {
        return this.mFavicon;
    }

    public String getTouchIconUrl() {
        return this.mTouchIconUrl;
    }

    public Object getCustomData() {
        return this.mCustomData;
    }

    public void setCustomData(Object obj) {
        this.mCustomData = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFavicon(Bitmap bitmap) {
        this.mFavicon = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTouchIconUrl(String str) {
        this.mTouchIconUrl = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getFlattenedData() {
        return this.mFlattenedData;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void inflate(int i) {
        inflate(i, this.mFlattenedData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public synchronized WebHistoryItem m250clone() {
        return new WebHistoryItem(this);
    }

    private void update(String str, String str2, String str3, Bitmap bitmap, byte[] bArr) {
        this.mUrl = str;
        this.mOriginalUrl = str2;
        this.mTitle = str3;
        this.mFavicon = bitmap;
        this.mFlattenedData = bArr;
    }
}
