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
    private final CustomMessageListener aSv = new c(this, CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS);
    private final CustomMessageListener aSw = new d(this, CmdConfigCustom.CMD_DELETE_GRAFFITI_SUCCESS);
    private final dh eov;
    private final PbActivity eow;

    public b(dh dhVar, PbActivity pbActivity) {
        this.eov = dhVar;
        this.eow = pbActivity;
        this.eow.registerListener(this.aSv);
        this.eow.registerListener(this.aSw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(long j, List<com.baidu.tbadk.core.data.ac> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.ac acVar = list.get(i);
            if (acVar != null && acVar.getType() == 1 && acVar.getGid() > 0 && acVar.getGid() == j) {
                return i;
            }
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(long j, List<com.baidu.tbadk.core.data.ac> list) {
        if (com.baidu.tbadk.core.util.y.t(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.ac acVar = list.get(i);
            if (acVar != null && acVar.getType() == 1 && acVar.getGid() > 0 && acVar.getUid() > 0 && acVar.getUid() == j) {
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
            if (!TextUtils.isEmpty(stringExtra) && this.eov != null && this.eov.getPbData() != null) {
                if (intExtra == 3 || intExtra == 2) {
                    new GraffitiTabActivityConfig(this.eow.getPageContext().getPageActivity(), this.eov.getPbData().getThreadId(), this.eov.getPbData().getForumId(), stringExtra).start();
                }
            }
        }
    }

    public void destroy() {
        com.baidu.tieba.tbadkCore.util.p pVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.p.class);
        if (runTask != null && (pVar = (com.baidu.tieba.tbadkCore.util.p) runTask.getData()) != null) {
            pVar.destroy();
        }
    }
}
