package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes10.dex */
public class n {
    private static n oJl;

    public static n edN() {
        if (oJl == null) {
            oJl = new n();
        }
        return oJl;
    }

    public void MA(int i) {
        q.edU().Ae(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 4) {
            edO();
            if (!q.edU().Yn()) {
                f.edz().edB().edA();
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_host_2", true);
            q.edU().Ag(true);
            edO();
            if (q.edU().ebS()) {
                f.edz().edB().edA();
            }
        } else if (i == 5) {
            edO();
            if (!q.edU().Yn()) {
                f.edz().edB().edA();
            }
        }
    }

    private void edO() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.hi(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
