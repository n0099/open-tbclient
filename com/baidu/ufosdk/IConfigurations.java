package com.baidu.ufosdk;
/* loaded from: classes9.dex */
public interface IConfigurations {
    String getAccountName();

    String getAccountUid();

    String getAppPkgName();

    String getAppVersion();

    int getBackbarType();

    String getBaiduCuid();

    String getExtraData();

    String getFeedbackChannel();

    String getLoaction();

    String getRobotWelcome();

    int getThemeMode();

    void setAccount(String str, String str2);

    void setBaiduCuid(String str);

    void setExtraData(String str);

    void setFeedbackChannel(String str);

    void setLocation(String str);

    void setThemeMode(int i);
}
