package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
/* loaded from: classes6.dex */
public interface d {
    void backPressed();

    void closeTopWebview();

    void closeWindow();

    boolean createLangbridgeCell(String str, boolean z, boolean z2, String str2);

    Activity getControllerActivity();

    long getLangbridgeHash();

    String getLangbridgeStamp();

    int getLangbridgeStatus();

    String getOwnerTag();

    void historyGo(int i2);

    boolean isActiveCell(c cVar);

    boolean isBottomCell(c cVar);

    void setLangbridgeStamp(String str);

    void setRnAuthResult(int i2, String str);
}
