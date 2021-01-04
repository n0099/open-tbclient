package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes11.dex */
public class l {
    private static l oBK;
    private TbPageContext oAf;

    public static l efb() {
        if (oBK == null) {
            oBK = new l();
        }
        return oBK;
    }

    public l i(TbPageContext tbPageContext) {
        this.oAf = tbPageContext;
        return this;
    }

    public void NG(int i) {
        o.eff().zQ(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 3) {
            efc();
            if (!o.eff().eev()) {
                e.eeO().eeQ().eeP();
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_host_2", true);
            o.eff().zS(true);
            efc();
        } else if (i == 4) {
            efc();
            if (!o.eff().eev()) {
                e.eeO().eeQ().eeP();
            }
        }
    }

    private void efc() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.hi(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
