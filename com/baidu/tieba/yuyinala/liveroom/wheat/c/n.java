package com.baidu.tieba.yuyinala.liveroom.wheat.c;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdToast;
/* loaded from: classes11.dex */
public class n {
    private static n oGG;

    public static n edx() {
        if (oGG == null) {
            oGG = new n();
        }
        return oGG;
    }

    public void Mv(int i) {
        q.edE().Af(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501009));
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2501036, true));
        if (i == 4) {
            edy();
            if (!q.edE().Yk()) {
                f.edj().edl().edk();
            }
        } else if (i == 2) {
            com.baidu.tieba.yuyinala.liveroom.wheat.e.d.bj("auth_success_host_2", true);
            q.edE().Ah(true);
            edy();
            if (q.edE().ebC()) {
                f.edj().edl().edk();
            }
        } else if (i == 5) {
            edy();
            if (!q.edE().Yk()) {
                f.edj().edl().edk();
            }
        }
    }

    private void edy() {
        if (com.baidu.tieba.yuyinala.liveroom.wheat.e.a.hj(TbadkCoreApplication.getInst())) {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_1_text)).show();
        } else {
            BdToast.makeText(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(a.h.yuyin_ala_connection_wheat_apply_succ_2_text)).show();
        }
    }
}
