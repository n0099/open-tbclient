package com.baidu.yuyinala.privatemessage.session.b;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends c<a> {
    private static volatile b pdA;
    private ArrayList<ChatSession> pdz = new ArrayList<>();
    private HashMap<BIMManager.CATEGORY, List<ChatSession>> pdB = new HashMap<>();

    private b() {
    }

    public static b eot() {
        if (pdA == null) {
            synchronized (b.class) {
                if (pdA == null) {
                    pdA = new b();
                }
            }
        }
        return pdA;
    }

    public void hY(long j) {
        List<ChatSession> list = this.pdB.get(BIMManager.CATEGORY.SINGLEPERSON);
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
