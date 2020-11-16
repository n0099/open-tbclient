package com.baidu.tieba.tbadkCore.e.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    protected HashMap<String, List<String>> mAsyncCallBackNameList;
    protected HashSet<String> mNotificationNameList;

    public abstract b dispatch(d dVar, b bVar);

    public abstract List<b> processNotification(String str, HashMap hashMap);

    public b addObserver(String str, b bVar) {
        if (bVar == null) {
            bVar = new b();
        }
        if (this.mNotificationNameList.contains(str)) {
            bVar.xB(false);
            bVar.xA(true);
            List<String> list = this.mAsyncCallBackNameList.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(bVar.getMethodName());
            this.mAsyncCallBackNameList.put(str, list);
        }
        return bVar;
    }
}
