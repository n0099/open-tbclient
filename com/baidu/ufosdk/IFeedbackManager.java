package com.baidu.ufosdk;

import android.content.Intent;
/* loaded from: classes8.dex */
public interface IFeedbackManager {
    IFeedbackMethodCallback getFeedbackCallback();

    Intent getFeedbackIntentWithCategory(int i);

    Intent getFeedbackIntentWithCategory(int i, String str);

    Intent getFeedbackIntentWithCategory(int i, String str, String str2, String str3);

    String getFeedbackNoticeFlag();

    String getHostPackageName();

    long getLastSendMessageTime();

    String getSDKVersion();

    void initFeedbackPlugin(IConfigurations iConfigurations);

    void initFeedbackSDK(IConfigurations iConfigurations);

    void setAccount(String str, String str2);

    void setBaiduCuid(String str);

    void setExtraData(String str);

    void setFeedbackCallback(IFeedbackMethodCallback iFeedbackMethodCallback);

    void setFeedbackChannel(String str);

    void setLocation(String str);

    void setThemeMode(int i);
}
