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
    private a bNk;
    private final CustomMessageListener bNj = new ak(this, CmdConfigCustom.CMD_GET_NEW_FRIEND_DATA_BY_ID);
    private final HashMap<String, Integer> bNi = new HashMap<>();

    /* loaded from: classes.dex */
    public interface a {
        void Zv();
    }

    public void a(a aVar) {
        this.bNk = aVar;
    }

    public void a(CommonPersonalChatActivity<FloatingPersonalChatActivity> commonPersonalChatActivity) {
        commonPersonalChatActivity.registerListener(this.bNj);
    }

    public void aV(List<UserData> list) {
        if (list != null && !list.isEmpty()) {
            for (UserData userData : list) {
                if (userData != null) {
                    if (userData.getIsFriend() == 1) {
                        this.bNi.put(userData.getUserId(), 1);
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
        return iJ(userData.getUserId());
    }

    public boolean iH(String str) {
        int iJ = iJ(str);
        return iJ == 1 || iJ == 3;
    }

    public int iJ(String str) {
        if (!StringUtils.isNull(str) && this.bNi.containsKey(str)) {
            return this.bNi.get(str).intValue();
        }
        return 0;
    }

    public void R(String str, int i) {
        if (!StringUtils.isNull(str)) {
            this.bNi.put(str, Integer.valueOf(i));
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
            this.bNi.put(String.valueOf(bVar.getId()), Integer.valueOf(r0));
            if (this.bNk != null) {
                this.bNk.Zv();
            }
        }
    }
}
