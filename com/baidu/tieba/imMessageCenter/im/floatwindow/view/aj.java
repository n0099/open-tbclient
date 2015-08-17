package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.newFriends.RequestNewFriendDataMessage;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class aj {
    private a bIS;
    private final CustomMessageListener bIR = new ak(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private final HashMap<String, Integer> bIQ = new HashMap<>();

    /* loaded from: classes.dex */
    public interface a {
        void Yu();
    }

    public void a(a aVar) {
        this.bIS = aVar;
    }

    public void a(CommonPersonalChatActivity<FloatingPersonalChatActivity> commonPersonalChatActivity) {
        commonPersonalChatActivity.registerListener(this.bIR);
    }

    public void aO(List<UserData> list) {
        if (list != null && !list.isEmpty()) {
            for (UserData userData : list) {
                if (userData != null) {
                    if (userData.getIsFriend() == 1) {
                        this.bIQ.put(userData.getUserId(), 1);
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
        return iu(userData.getUserId());
    }

    public boolean is(String str) {
        int iu = iu(str);
        return iu == 1 || iu == 3;
    }

    public int iu(String str) {
        if (!StringUtils.isNull(str) && this.bIQ.containsKey(str)) {
            return this.bIQ.get(str).intValue();
        }
        return 0;
    }

    public void O(String str, int i) {
        if (!StringUtils.isNull(str)) {
            this.bIQ.put(str, Integer.valueOf(i));
        }
    }

    private void d(UserData userData) {
        MessageManager.getInstance().sendMessage(new RequestNewFriendDataMessage(userData == null ? 0L : userData.getUserIdLong()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.baidu.tieba.im.data.b bVar) {
        if (bVar != null) {
            if (bVar.getStatus() == 0) {
            }
            r0 = bVar.getStatus() == 3 ? 2 : 0;
            if (bVar.getStatus() == 2) {
                r0 = 3;
            }
            if (bVar.getStatus() == 1) {
                r0 = 4;
            }
        }
        if (bVar != null && bVar.getId() != 0) {
            this.bIQ.put(String.valueOf(bVar.getId()), Integer.valueOf(r0));
            if (this.bIS != null) {
                this.bIS.Yu();
            }
        }
    }
}
