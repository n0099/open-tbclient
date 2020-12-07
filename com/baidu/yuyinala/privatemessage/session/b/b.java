package com.baidu.yuyinala.privatemessage.session.b;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends c<a> {
    private static volatile b oXp;
    private ArrayList<ChatSession> oXo = new ArrayList<>();
    private HashMap<BIMManager.CATEGORY, List<ChatSession>> oXq = new HashMap<>();

    private b() {
    }

    public static b eok() {
        if (oXp == null) {
            synchronized (b.class) {
                if (oXp == null) {
                    oXp = new b();
                }
            }
        }
        return oXp;
    }

    public void ie(long j) {
        List<ChatSession> list = this.oXq.get(BIMManager.CATEGORY.SINGLEPERSON);
        if (list != null && list.size() > 0) {
            Iterator<ChatSession> it = list.iterator();
            while (it.hasNext()) {
                if (j == it.next().getContacterId()) {
                    it.remove();
                }
            }
        }
    }
}
