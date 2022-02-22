package com.baidu.wallet.lightapp.multipage;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface a {
    void checkClodDown(String str, List<String> list, String str2);

    void closeTopWebview();

    void closeWindow();

    String exeSSCommand(String str, String str2, String str3);

    void executeJsFunction(String str, String str2);

    Activity getActivity();

    String getCellHashStamps();

    Context getContext();

    String getLoadTimeLine();

    void historyGo(int i2);

    boolean isActiveCell();

    boolean isPreloaded();

    void loadAlubm(String str);

    void openInNewWebView(String str, String str2);

    void preLoadException(String str);

    void preLoadUrl(ArrayList<String> arrayList, int i2);

    void rmFromPreloadPool();

    void selectPhoneFromAddressBook();

    JSONObject setFullScreenInMainThread(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2);

    void setIsCheckPermission(boolean z);

    void setMenuInMainThread(JSONArray jSONArray);

    void setSubMenu(String str, String str2, String str3, int i2);

    void setTitlesInMainThread(String str, String str2, boolean z);

    void startNewLightApp(Context context, String str, String str2, boolean z, boolean z2);
}
