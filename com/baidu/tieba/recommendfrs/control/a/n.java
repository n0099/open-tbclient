package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.x;
import java.util.List;
import tbclient.Personalized.TagInfo;
/* loaded from: classes.dex */
public class n {
    public static int dEA = 3;
    private static n dEG;
    public BdUniqueId aPF;
    public boolean dED;
    public int dEB = -1;
    public int dEC = 0;
    public int cnb = -1;
    public boolean dEE = false;
    private CustomMessageListener dEF = new o(this, CmdConfigCustom.CMD_GOD_FEED_MSG_RECIEVED);
    private CustomMessageListener aPK = new p(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);

    public static synchronized n aFn() {
        n nVar;
        synchronized (n.class) {
            if (dEG == null) {
                dEG = new n();
            }
            nVar = dEG;
        }
        return nVar;
    }

    public void onDestory() {
        this.dEC = 0;
        if (this.aPF != null) {
            MessageManager.getInstance().unRegisterListener(this.aPF);
        }
    }

    public void n(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aPF = bdUniqueId;
            this.dEF.setTag(bdUniqueId);
            this.aPK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.dEF);
            MessageManager.getInstance().registerListener(this.aPK);
        }
    }

    public void bR(List<TagInfo> list) {
        if (!x.p(list)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    TagInfo tagInfo = (TagInfo) x.b(list, i2);
                    if (tagInfo != null) {
                        if (tagInfo.tag_type.intValue() == dEA) {
                            this.dEB = i2;
                            return;
                        }
                        this.dEB = -1;
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
