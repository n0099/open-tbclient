package com.baidu.tieba.imMessageCenter.im.floatwindow.view;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.chat.CommonPersonalChatActivity;
import com.baidu.tieba.imMessageCenter.RequestNewFriendDataMessage;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class aj {
    private a dbH;
    private final CustomMessageListener dbG = new ak(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private final HashMap<String, Integer> dbF = new HashMap<>();

    /* loaded from: classes.dex */
    public interface a {
        void asJ();
    }

    public void a(a aVar) {
        this.dbH = aVar;
    }

    public void a(CommonPersonalChatActivity<FloatingPersonalChatActivity> commonPersonalChatActivity) {
        commonPersonalChatActivity.registerListener(this.dbG);
    }

    public void bP(List<UserData> list) {
        if (list != null && !list.isEmpty()) {
            for (UserData userData : list) {
                if (userData != null) {
                    if (userData.getIsFriend() == 1) {
                        this.dbF.put(userData.getUserId(), 1);
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
        return lA(userData.getUserId());
    }

    public boolean ly(String str) {
        int lA = lA(str);
        return lA == 1 || lA == 3;
    }

    public int lA(String str) {
        if (!StringUtils.isNull(str) && this.dbF.containsKey(str)) {
            return this.dbF.get(str).intValue();
        }
        return 0;
    }

    public void ap(String str, int i) {
        if (!StringUtils.isNull(str)) {
            this.dbF.put(str, Integer.valueOf(i));
        }
    }

    private void d(UserData userData) {
        MessageManager.getInstance().sendMessage(new RequestNewFriendDataMessage(userData == null ? 0L : userData.getUserIdLong()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(com.baidu.tieba.im.data.b bVar) {
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
            this.dbF.put(String.valueOf(bVar.getId()), Integer.valueOf(r0));
            if (this.dbH != null) {
                this.dbH.asJ();
            }
        }
    }
}
