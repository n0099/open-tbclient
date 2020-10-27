package com.baidu.yuyinala.privatemessage.session.b;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends c<a> {
    private static volatile b oxm;
    private ArrayList<ChatSession> oxl = new ArrayList<>();
    private HashMap<BIMManager.CATEGORY, List<ChatSession>> oxn = new HashMap<>();

    private b() {
    }

    public static b eeH() {
        if (oxm == null) {
            synchronized (b.class) {
                if (oxm == null) {
                    oxm = new b();
                }
            }
        }
        return oxm;
    }

    public void ha(long j) {
        List<ChatSession> list = this.oxn.get(BIMManager.CATEGORY.SINGLEPERSON);
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
