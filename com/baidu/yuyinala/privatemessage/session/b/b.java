package com.baidu.yuyinala.privatemessage.session.b;

import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends c<a> {
    private static volatile b oGF;
    private ArrayList<ChatSession> oGE = new ArrayList<>();
    private HashMap<BIMManager.CATEGORY, List<ChatSession>> oGG = new HashMap<>();

    private b() {
    }

    public static b eiw() {
        if (oGF == null) {
            synchronized (b.class) {
                if (oGF == null) {
                    oGF = new b();
                }
            }
        }
        return oGF;
    }

    public void hw(long j) {
        List<ChatSession> list = this.oGG.get(BIMManager.CATEGORY.SINGLEPERSON);
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
