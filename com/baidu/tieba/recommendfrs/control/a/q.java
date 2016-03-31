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
    private static q dWD;
    public BdUniqueId aSu;
    public boolean dWA;
    public int dWy = -1;
    public int dWz = 0;
    public int cxD = -1;
    public boolean dWB = false;
    private CustomMessageListener dWC = new r(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener ahZ = new s(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized q aMe() {
        q qVar;
        synchronized (q.class) {
            if (dWD == null) {
                dWD = new q();
            }
            qVar = dWD;
        }
        return qVar;
    }

    public void onDestory() {
        this.dWz = 0;
        if (this.aSu != null) {
            MessageManager.getInstance().unRegisterListener(this.aSu);
        }
    }

    public void o(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aSu = bdUniqueId;
            this.dWC.setTag(bdUniqueId);
            this.ahZ.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dWC);
            MessageManager.getInstance().registerListener(this.ahZ);
        }
    }

    public void cj(List<TagInfo> list) {
        if (!y.q(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) y.b(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == 3) {
                            this.dWy = i2;
                            return;
                        }
                        this.dWy = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
