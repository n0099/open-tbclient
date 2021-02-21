package com.baidu.tieba.tbadkCore.e.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public abstract class a {
    public static final String PROXY_CLASS_NAME_SUFFIX = "_Proxy";
    public static final String PROXY_CLASS_PACKAGE_NAME = "com.baidu.tieba.h5power";
    protected HashMap<String, List<b>> mAsyncCallBackMethodList;
    protected HashSet<String> mNotificationNameList;

    public abstract c dispatch(e eVar, c cVar);

    public abstract List<c> processNotification(String str, HashMap hashMap);

    public c addObserver(String str, c cVar, boolean z) {
        if (cVar == null) {
            cVar = new c();
        }
        if (this.mNotificationNameList.contains(str)) {
            cVar.yA(false);
            cVar.yz(true);
            List<b> list = this.mAsyncCallBackMethodList.get(str);
            if (list == null) {
                list = new ArrayList<>();
            }
            b bVar = new b();
            bVar.setName(cVar.cuC());
            bVar.yx(z);
            list.add(bVar);
            this.mAsyncCallBackMethodList.put(str, list);
        }
        return cVar;
    }
}
