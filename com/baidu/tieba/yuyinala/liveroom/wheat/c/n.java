package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes11.dex */
public class n {
    private static n oHg;

    public static n edF() {
        if (oHg == null) {
            oHg = new n();
        }
        return oHg;
    }

    public void Mw(int i) {
        q.edM().Af(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 4) {
            edG();
            if (!q.edM().Yk()) {
                f.edr().edt().eds();
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_host_2", true);
            q.edM().Ah(true);
            edG();
            if (q.edM().ebK()) {
                f.edr().edt().eds();
            }
        } else if (i == 5) {
            edG();
            if (!q.edM().Yk()) {
                f.edr().edt().eds();
            }
        }
    }

    private void edG() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.hj(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
