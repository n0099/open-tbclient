package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes4.dex */
public class l {
    private static l ouY;
    private TbPageContext otA;

    public static l efa() {
        if (ouY == null) {
            ouY = new l();
        }
        return ouY;
    }

    public l i(TbPageContext tbPageContext) {
        this.otA = tbPageContext;
        return this;
    }

    public void NQ(int i) {
        o.efe().zO(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 3) {
            efb();
            if (!o.efe().eew()) {
                e.eeO().eeP().h(this.otA);
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bk("auth_success_host_2", true);
            o.efe().zQ(true);
            efb();
        } else if (i == 4) {
            efb();
            if (!o.efe().eew()) {
                e.eeO().eeP().h(this.otA);
            }
        }
    }

    private void efb() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.gQ(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
