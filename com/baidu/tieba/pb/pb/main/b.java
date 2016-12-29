package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.GraffitiPaintActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private final CustomMessageListener aTN = new c(this, CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS);
    private final CustomMessageListener aTO = new d(this, CmdConfigCustom.CMD_DELETE_GRAFFITI_SUCCESS);
    private final dc dYA;
    private final PbActivity dYB;

    public b(dc dcVar, PbActivity pbActivity) {
        this.dYA = dcVar;
        this.dYB = pbActivity;
        this.dYB.registerListener(this.aTN);
        this.dYB.registerListener(this.aTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(long j, List<com.baidu.tbadk.core.data.ad> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.ad adVar = list.get(i);
            if (adVar != null && adVar.getType() == 1 && adVar.getGid() > 0 && adVar.getGid() == j) {
                return i;
            }
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(long j, List<com.baidu.tbadk.core.data.ad> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.ad adVar = list.get(i);
            if (adVar != null && adVar.getType() == 1 && adVar.getGid() > 0 && adVar.getUid() > 0 && adVar.getUid() == j) {
                return i;
            }
        }
        return -2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25001 && intent != null) {
            String stringExtra = intent.getStringExtra(GraffitiPaintActivityConfig.GRAFFITO_FILE_NAME);
            int intExtra = intent.getIntExtra("from", -1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new com.baidu.tieba.graffiti.j(stringExtra, intExtra)));
            if (!TextUtils.isEmpty(stringExtra) && this.dYA != null && this.dYA.getPbData() != null) {
                if (intExtra == 3 || intExtra == 2) {
                    new GraffitiTabActivityConfig(this.dYB.getPageContext().getPageActivity(), this.dYA.getPbData().getThreadId(), this.dYA.getPbData().getForumId(), stringExtra).start();
                }
            }
        }
    }

    public void destroy() {
        com.baidu.tieba.tbadkCore.util.o oVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.o.class);
        if (runTask != null && (oVar = (com.baidu.tieba.tbadkCore.util.o) runTask.getData()) != null) {
            oVar.destroy();
        }
    }
}
