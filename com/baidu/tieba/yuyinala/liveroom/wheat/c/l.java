package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes10.dex */
public class l {
    private static l oxf;
    private TbPageContext ovA;

    public static l ebk() {
        if (oxf == null) {
            oxf = new l();
        }
        return oxf;
    }

    public l i(TbPageContext tbPageContext) {
        this.ovA = tbPageContext;
        return this;
    }

    public void LZ(int i) {
        o.ebo().zM(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 3) {
            ebl();
            if (!o.ebo().eaE()) {
                e.eaX().eaZ().eaY();
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_host_2", true);
            o.ebo().zO(true);
            ebl();
        } else if (i == 4) {
            ebl();
            if (!o.ebo().eaE()) {
                e.eaX().eaZ().eaY();
            }
        }
    }

    private void ebl() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.hg(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
