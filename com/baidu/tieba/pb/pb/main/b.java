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
    private final PbModel eue;
    private final PbActivity euf;
    private final CustomMessageListener cFe = new c(this, CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS);
    private final CustomMessageListener eug = new d(this, CmdConfigCustom.CMD_DELETE_GRAFFITI_SUCCESS);

    public b(PbModel pbModel, PbActivity pbActivity) {
        this.eue = pbModel;
        this.euf = pbActivity;
        this.euf.registerListener(this.cFe);
        this.euf.registerListener(this.eug);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(long j, List<com.baidu.tbadk.core.data.af> list) {
        if (com.baidu.tbadk.core.util.z.t(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.af afVar = list.get(i);
            if (afVar != null && afVar.getType() == 1 && afVar.getGid() > 0 && afVar.getGid() == j) {
                return i;
            }
        }
        return -2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f(long j, List<com.baidu.tbadk.core.data.af> list) {
        if (com.baidu.tbadk.core.util.z.t(list)) {
            return -1;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            com.baidu.tbadk.core.data.af afVar = list.get(i);
            if (afVar != null && afVar.getType() == 1 && afVar.getGid() > 0 && afVar.getUid() > 0 && afVar.getUid() == j) {
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
            if (!TextUtils.isEmpty(stringExtra) && this.eue != null && this.eue.getPbData() != null) {
                if (intExtra == 3 || intExtra == 2) {
                    new GraffitiTabActivityConfig(this.euf.getPageContext().getPageActivity(), this.eue.getPbData().getThreadId(), this.eue.getPbData().getForumId(), stringExtra).start();
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
