package com.baidu.wallet.lightapp.base.datamodel;

import android.text.TextUtils;
import com.baidu.apollon.NoProguard;
import com.baidu.wallet.api.ILightAppListener;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class LightAppShareModel implements NoProguard {
    public int appid;
    public String content;
    public String extraParam;
    public String imageUrl;
    public String linkUrl;
    public String mediaType;
    public int menumode;
    public String title;

    public LightAppShareModel() {
    }

    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.mediaType)) {
            hashMap.put(ILightAppListener.KEY_SHARE_MEDIATYPE, this.mediaType);
        }
        if (!TextUtils.isEmpty(this.title)) {
            hashMap.put(ILightAppListener.KEY_SHARE_TITLE, this.title);
        }
        if (!TextUtils.isEmpty(this.content)) {
            hashMap.put(ILightAppListener.KEY_SHARE_CONTENT, this.content);
        }
        if (!TextUtils.isEmpty(this.linkUrl)) {
            hashMap.put(ILightAppListener.KEY_SHARE_LINK, this.linkUrl);
        }
        if (!TextUtils.isEmpty(this.imageUrl)) {
            hashMap.put(ILightAppListener.KEY_SHARE_IMAGE, this.imageUrl);
        }
        if (!TextUtils.isEmpty(this.extraParam)) {
            hashMap.put(ILightAppListener.KEY_SHARE_EXTRA, this.extraParam);
        }
        return hashMap;
    }

    public boolean valid() {
        return !TextUtils.isEmpty(this.linkUrl);
    }

    public LightAppShareModel(String str, String str2, String str3, String str4) {
        this();
        this.title = str;
        this.content = str2;
        this.linkUrl = str3;
        this.imageUrl = str4;
    }
}
