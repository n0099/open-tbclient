package com.baidu.tieba.yuyinala.liveroom.wheat.b;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes4.dex */
public class k {
    private static k nWT;
    private TbPageContext nVE;

    public static k dWx() {
        if (nWT == null) {
            nWT = new k();
        }
        return nWT;
    }

    public k i(TbPageContext tbPageContext) {
        this.nVE = tbPageContext;
        return this;
    }

    public void Me(int i) {
        n.dWB().yW(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 3) {
            dWy();
            if (!n.dWB().dWd()) {
                e.dWm().dWn().h(this.nVE);
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.d.d.bh("auth_success_host_2", true);
            n.dWB().yY(true);
            dWy();
        } else if (i == 4) {
            dWy();
            if (!n.dWB().dWd()) {
                e.dWm().dWn().h(this.nVE);
            }
        }
    }

    private void dWy() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.d.a.gh(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.i.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
