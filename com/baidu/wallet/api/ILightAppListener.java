package com.baidu.wallet.api;

import android.app.Activity;
import android.content.Context;
import com.baidu.apollon.NoProguard;
import java.util.Map;
import java.util.Set;
/* loaded from: classes11.dex */
public interface ILightAppListener extends NoProguard, ILightappInvoker {
    public static final String KEY_SHARE_CONTENT = "key_share_content";
    public static final String KEY_SHARE_EXTRA = "key_share_extra";
    public static final String KEY_SHARE_IMAGE = "key_share_icon";
    public static final String KEY_SHARE_LINK = "key_share_link";
    public static final String KEY_SHARE_MEDIATYPE = "key_share_mediatype";
    public static final String KEY_SHARE_TITLE = "key_share_title";

    boolean callShare(Activity activity, Map<String, String> map, ILightappInvokerCallback iLightappInvokerCallback);

    boolean getCurrentLocation(ILocationCallback iLocationCallback);

    Set<String> getMethodList();

    void lightappInvoke(Context context, String str, ILightappInvokerCallback iLightappInvokerCallback);
}
