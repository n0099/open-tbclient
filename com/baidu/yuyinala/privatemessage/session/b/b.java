package com.baidu.yuyinala.privatemessage.session.b;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes10.dex */
public class b extends c<a> {
    private static volatile b plS;
    private ArrayList<ChatSession> plR = new ArrayList<>();
    private HashMap<BIMManager.CATEGORY, List<ChatSession>> plT = new HashMap<>();

    private b() {
    }

    public static b enj() {
        if (plS == null) {
            synchronized (b.class) {
                if (plS == null) {
                    plS = new b();
                }
            }
        }
        return plS;
    }

    public void ib(long j) {
        List<ChatSession> list = this.plT.get(BIMManager.CATEGORY.SINGLEPERSON);
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
