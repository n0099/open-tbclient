package com.baidu.yuyinala.privatemessage.session.b;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes11.dex */
public class b extends c<a> {
    private static volatile b pjm;
    private ArrayList<ChatSession> pjl = new ArrayList<>();
    private HashMap<BIMManager.CATEGORY, List<ChatSession>> pjn = new HashMap<>();

    private b() {
    }

    public static b emQ() {
        if (pjm == null) {
            synchronized (b.class) {
                if (pjm == null) {
                    pjm = new b();
                }
            }
        }
        return pjm;
    }

    public void ib(long j) {
        List<ChatSession> list = this.pjn.get(BIMManager.CATEGORY.SINGLEPERSON);
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
