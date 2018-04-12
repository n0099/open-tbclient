package com.baidu.tieba.sharesdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
/* loaded from: classes3.dex */
public class c {
    public static void a(Context context, Oauth2AccessToken oauth2AccessToken) {
        if (context != null && oauth2AccessToken != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("com_weibo_sdk_android", 32768).edit();
            edit.putString("uid", oauth2AccessToken.getUid());
            edit.putString("access_token", oauth2AccessToken.getToken());
            edit.putString(Oauth2AccessToken.KEY_REFRESH_TOKEN, oauth2AccessToken.getRefreshToken());
            edit.putLong("expires_in", oauth2AccessToken.getExpiresTime());
            edit.commit();
        }
    }

    public static Oauth2AccessToken bV(Context context) {
        if (context == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com_weibo_sdk_android", 32768);
        oauth2AccessToken.setUid(sharedPreferences.getString("uid", ""));
        oauth2AccessToken.setToken(sharedPreferences.getString("access_token", ""));
        oauth2AccessToken.setRefreshToken(sharedPreferences.getString(Oauth2AccessToken.KEY_REFRESH_TOKEN, ""));
        oauth2AccessToken.setExpiresTime(sharedPreferences.getLong("expires_in", 0L));
        return oauth2AccessToken;
    }
}
