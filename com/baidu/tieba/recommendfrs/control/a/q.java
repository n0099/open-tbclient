package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.y;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class q {
    private static q dZN;
    public BdUniqueId aOT;
    public boolean dZK;
    public int dZI = -1;
    public int dZJ = 0;
    public int cyC = -1;
    public boolean dZL = false;
    private CustomMessageListener dZM = new r(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener adW = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized q aMp() {
        q qVar;
        synchronized (q.class) {
            if (dZN == null) {
                dZN = new q();
            }
            qVar = dZN;
        }
        return qVar;
    }

    public void onDestory() {
        this.dZJ = 0;
        if (this.aOT != null) {
            MessageManager.getInstance().unRegisterListener(this.aOT);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aOT = bdUniqueId;
            this.dZM.setTag(bdUniqueId);
            this.adW.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dZM);
            MessageManager.getInstance().registerListener(this.adW);
        }
    }

    public void cl(List<TagInfo> list) {
        if (!y.s(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) y.c(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.dZI = i2;
                            return;
                        }
                        this.dZI = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
