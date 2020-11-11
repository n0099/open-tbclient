package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes4.dex */
public class l {
    private static l oes;
    private TbPageContext ocV;

    public static l dZw() {
        if (oes == null) {
            oes = new l();
        }
        return oes;
    }

    public l i(TbPageContext tbPageContext) {
        this.ocV = tbPageContext;
        return this;
    }

    public void Mv(int i) {
        o.dZA().zd(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 3) {
            dZx();
            if (!o.dZA().dYS()) {
                e.dZk().dZl().h(this.ocV);
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_host_2", true);
            o.dZA().zf(true);
            dZx();
        } else if (i == 4) {
            dZx();
            if (!o.dZA().dYS()) {
                e.dZk().dZl().h(this.ocV);
            }
        }
    }

    private void dZx() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.gh(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
