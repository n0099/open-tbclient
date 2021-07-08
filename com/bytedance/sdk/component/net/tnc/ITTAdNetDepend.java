package com.bytedance.sdk.component.net.tnc;

import android.content.Context;
import android.location.Address;
import java.util.Map;
/* loaded from: classes5.dex */
public interface ITTAdNetDepend {
    int getAid();

    String getChannel();

    String[] getConfigServers();

    Context getContext();

    String getDid();

    Address getLocationAdress(Context context);

    String getPlatform();

    int getProviderInt(Context context, String str, int i2);

    String getProviderString(Context context, String str, String str2);

    int getVersionCode();

    void saveMapToProvider(Context context, Map<String, ?> map);
}
