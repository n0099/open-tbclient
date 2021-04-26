package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public interface a {
    void closeTopWebview();

    void closeWindow();

    String exeSSCommand(String str, String str2, String str3);

    void executeJsFunction(String str, String str2);

    Activity getActivity();

    Context getContext();

    String getLoadTimeLine();

    void historyGo(int i2);

    boolean isActiveCell();

    void loadAlubm(String str);

    void openInNewWebView(String str, boolean z);

    void preLoadException(String str);

    void preLoadUrl(ArrayList<String> arrayList, int i2);

    void selectPhoneFromAddressBook();

    JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2);

    void setIsCheckPermission(boolean z);

    void setMenuInMainThread(JSONArray jSONArray);

    void setTitlesInMainThread(String str, String str2, boolean z);
}
