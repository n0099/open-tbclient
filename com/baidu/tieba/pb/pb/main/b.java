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
    private final CustomMessageListener aUw = new c(this, CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS);
    private final CustomMessageListener aUx = new d(this, CmdConfigCustom.CMD_DELETE_GRAFFITI_SUCCESS);
    private final dj euf;
    private final PbActivity eug;

    public b(dj djVar, PbActivity pbActivity) {
        this.euf = djVar;
        this.eug = pbActivity;
        this.eug.registerListener(this.aUw);
        this.eug.registerListener(this.aUx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(long j, List<com.baidu.tbadk.core.data.ae> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
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
    public int a(long j, List<com.baidu.tbadk.core.data.ae> list) {
        if (com.baidu.tbadk.core.util.x.t(list)) {
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
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new com.baidu.tieba.graffiti.j(stringExtra, intExtra)));
            if (!TextUtils.isEmpty(stringExtra) && this.euf != null && this.euf.getPbData() != null) {
                if (intExtra == 3 || intExtra == 2) {
                    new GraffitiTabActivityConfig(this.eug.getPageContext().getPageActivity(), this.euf.getPbData().getThreadId(), this.euf.getPbData().getForumId(), stringExtra).start();
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
