package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.newFriends.RequestNewFriendDataMessage;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class ap {
    private ar bvb;
    private final CustomMessageListener bva = new aq(this, 2001312);
    private final HashMap<String, Integer> buZ = new HashMap<>();

    public void a(ar arVar) {
        this.bvb = arVar;
    }

    public void a(CommonPersonalChatActivity<FloatingPersonalChatActivity> commonPersonalChatActivity) {
        commonPersonalChatActivity.registerListener(this.bva);
    }

    public void aL(List<UserData> list) {
        if (list != null && !list.isEmpty()) {
            for (UserData userData : list) {
                if (userData != null) {
                    if (userData.getIsFriend() == 1) {
                        this.buZ.put(userData.getUserId(), 1);
                    } else {
                        d(userData);
                    }
                }
            }
        }
    }

    public int c(UserData userData) {
        if (userData == null) {
            return 0;
        }
        return hR(userData.getUserId());
    }

    public boolean hP(String str) {
        int hR = hR(str);
        return hR == 1 || hR == 3;
    }

    public int hR(String str) {
        if (!StringUtils.isNull(str) && this.buZ.containsKey(str)) {
            return this.buZ.get(str).intValue();
        }
        return 0;
    }

    public void L(String str, int i) {
        if (!StringUtils.isNull(str)) {
            this.buZ.put(str, Integer.valueOf(i));
        }
    }

    private void d(UserData userData) {
        MessageManager.getInstance().sendMessage(new RequestNewFriendDataMessage(userData == null ? 0L : userData.getUserIdLong()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.im.data.b bVar) {
        if (bVar == null) {
        }
        if (bVar.getStatus() == 0) {
        }
        int i = bVar.getStatus() == 3 ? 2 : 0;
        if (bVar.getStatus() == 2) {
            i = 3;
        }
        if (bVar.getStatus() == 1) {
            i = 4;
        }
        if (bVar != null && bVar.getId() != 0) {
            this.buZ.put(String.valueOf(bVar.getId()), Integer.valueOf(i));
            if (this.bvb != null) {
                this.bvb.WN();
            }
        }
    }
}
