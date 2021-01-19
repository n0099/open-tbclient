package com.baidu.yuyinala.privatemessage.session.b;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends c<a> {
    private static volatile b oYW;
    private ArrayList<ChatSession> oYV = new ArrayList<>();
    private HashMap<BIMManager.CATEGORY, List<ChatSession>> oYX = new HashMap<>();

    private b() {
    }

    public static b eky() {
        if (oYW == null) {
            synchronized (b.class) {
                if (oYW == null) {
                    oYW = new b();
                }
            }
        }
        return oYW;
    }

    public void hY(long j) {
        List<ChatSession> list = this.oYX.get(BIMManager.CATEGORY.SINGLEPERSON);
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
