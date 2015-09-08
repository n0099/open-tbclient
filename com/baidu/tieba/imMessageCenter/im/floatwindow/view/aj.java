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
    private a bJz;
    private final CustomMessageListener bJy = new ak(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private final HashMap<String, Integer> bJx = new HashMap<>();

    /* loaded from: classes.dex */
    public interface a {
        void Yw();
    }

    public void a(a aVar) {
        this.bJz = aVar;
    }

    public void a(CommonPersonalChatActivity<FloatingPersonalChatActivity> commonPersonalChatActivity) {
        commonPersonalChatActivity.registerListener(this.bJy);
    }

    public void aO(List<UserData> list) {
        if (list != null && !list.isEmpty()) {
            for (UserData userData : list) {
                if (userData != null) {
                    if (userData.getIsFriend() == 1) {
                        this.bJx.put(userData.getUserId(), 1);
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
        return iD(userData.getUserId());
    }

    public boolean iB(String str) {
        int iD = iD(str);
        return iD == 1 || iD == 3;
    }

    public int iD(String str) {
        if (!StringUtils.isNull(str) && this.bJx.containsKey(str)) {
            return this.bJx.get(str).intValue();
        }
        return 0;
    }

    public void P(String str, int i) {
        if (!StringUtils.isNull(str)) {
            this.bJx.put(str, Integer.valueOf(i));
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
            this.bJx.put(String.valueOf(bVar.getId()), Integer.valueOf(r0));
            if (this.bJz != null) {
                this.bJz.Yw();
            }
        }
    }
}
