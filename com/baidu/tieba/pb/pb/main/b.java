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
    private final PbModel eif;
    private final PbActivity eig;
    private final CustomMessageListener crH = new c(this, CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS);
    private final CustomMessageListener eih = new d(this, CmdConfigCustom.CMD_DELETE_GRAFFITI_SUCCESS);

    public b(PbModel pbModel, PbActivity pbActivity) {
        this.eif = pbModel;
        this.eig = pbActivity;
        this.eig.registerListener(this.crH);
        this.eig.registerListener(this.eih);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(long j, List<com.baidu.tbadk.core.data.ae> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.ae aeVar = list.get(i);
            if (aeVar != null && aeVar.getType() == 1 && aeVar.getGid() > 0 && aeVar.getGid() == j) {
                return i;
            }
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(long j, List<com.baidu.tbadk.core.data.ae> list) {
        if (com.baidu.tbadk.core.util.x.q(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.ae aeVar = list.get(i);
            if (aeVar != null && aeVar.getType() == 1 && aeVar.getGid() > 0 && aeVar.getUid() > 0 && aeVar.getUid() == j) {
                return i;
            }
        }
        return -2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 25001 && intent != null) {
            String stringExtra = intent.getStringExtra(GraffitiPaintActivityConfig.GRAFFITO_FILE_NAME);
            int intExtra = intent.getIntExtra("from", -1);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new com.baidu.tieba.graffiti.i(stringExtra, intExtra)));
            if (!TextUtils.isEmpty(stringExtra) && this.eif != null && this.eif.getPbData() != null) {
                if (intExtra == 3 || intExtra == 2) {
                    new GraffitiTabActivityConfig(this.eig.getPageContext().getPageActivity(), this.eif.getPbData().getThreadId(), this.eif.getPbData().getForumId(), stringExtra).start();
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
