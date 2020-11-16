package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes4.dex */
public class l {
    private static l ofW;
    private TbPageContext oey;

    public static l dZv() {
        if (ofW == null) {
            ofW = new l();
        }
        return ofW;
    }

    public l i(TbPageContext tbPageContext) {
        this.oey = tbPageContext;
        return this;
    }

    public void MY(int i) {
        o.dZz().zk(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 3) {
            dZw();
            if (!o.dZz().dYR()) {
                e.dZj().dZk().h(this.oey);
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_host_2", true);
            o.dZz().zm(true);
            dZw();
        } else if (i == 4) {
            dZw();
            if (!o.dZz().dYR()) {
                e.dZj().dZk().h(this.oey);
            }
        }
    }

    private void dZw() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.gg(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
