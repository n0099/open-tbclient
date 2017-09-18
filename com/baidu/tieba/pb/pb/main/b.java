package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.atomData.GraffitiPaintActivityConfig;
import com.baidu.tbadk.core.atomData.GraffitiTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private final PbModel eHJ;
    private final PbActivity eHK;
    private final CustomMessageListener cWR = new CustomMessageListener(CmdConfigCustom.CMD_GRAFFITI_SEND_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.data.ae graffitiInfo;
            if (b.this.eHJ != null && b.this.eHJ.aRZ() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.e)) {
                com.baidu.tieba.graffiti.e eVar = (com.baidu.tieba.graffiti.e) customResponsedMessage.getData();
                String threadId = eVar.getThreadId();
                if (!TextUtils.isEmpty(threadId) && threadId.equals(b.this.eHJ.getThreadID()) && (graffitiInfo = eVar.getGraffitiInfo()) != null && graffitiInfo.qb()) {
                    com.baidu.tbadk.core.data.af aRw = b.this.eHJ.aRZ().aRw();
                    if (aRw != null) {
                        List<com.baidu.tbadk.core.data.ae> items = aRw.getItems();
                        if (items == null) {
                            items = new ArrayList<>();
                        }
                        int f = b.this.f(graffitiInfo.getUid(), items);
                        if (f >= 0) {
                            com.baidu.tbadk.core.util.v.d(items, f);
                        }
                        items.add(0, graffitiInfo);
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aRw));
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                }
            }
        }
    };
    private final CustomMessageListener eHL = new CustomMessageListener(CmdConfigCustom.CMD_DELETE_GRAFFITI_SUCCESS) { // from class: com.baidu.tieba.pb.pb.main.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tbadk.core.data.af aRw;
            if (b.this.eHJ != null && b.this.eHJ.aRZ() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.graffiti.a)) {
                com.baidu.tieba.graffiti.a aVar = (com.baidu.tieba.graffiti.a) customResponsedMessage.getData();
                String threadId = aVar.getThreadId();
                com.baidu.tbadk.core.data.ae aor = aVar.aor();
                if (aor != null && !TextUtils.isEmpty(threadId) && threadId.equals(b.this.eHJ.getThreadID()) && (aRw = b.this.eHJ.aRZ().aRw()) != null) {
                    List<com.baidu.tbadk.core.data.ae> items = aRw.getItems();
                    if (items == null) {
                        items = new ArrayList<>();
                    }
                    int e = b.this.e(aor.getGid(), items);
                    if (e >= 0 && com.baidu.tbadk.core.util.v.d(items, e) != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_LIST_CHANGED, aRw));
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_RECORDER_RESET_CMD));
                    }
                }
            }
        }
    };

    public b(PbModel pbModel, PbActivity pbActivity) {
        this.eHJ = pbModel;
        this.eHK = pbActivity;
        this.eHK.registerListener(this.cWR);
        this.eHK.registerListener(this.eHL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e(long j, List<com.baidu.tbadk.core.data.ae> list) {
        if (com.baidu.tbadk.core.util.v.v(list)) {
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
        if (com.baidu.tbadk.core.util.v.v(list)) {
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
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GRAFFITI_SAVE_SUCCESS, new com.baidu.tieba.graffiti.d(stringExtra, intExtra)));
            if (TextUtils.isEmpty(stringExtra) || this.eHJ == null || this.eHJ.getPbData() == null) {
                return;
            }
            if (intExtra == 3 || intExtra == 2) {
                new GraffitiTabActivityConfig(this.eHK.getPageContext().getPageActivity(), this.eHJ.getPbData().getThreadId(), this.eHJ.getPbData().getForumId(), stringExtra).start();
            }
        }
    }

    public void destroy() {
        com.baidu.tieba.tbadkCore.util.d dVar;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_GRAFFITI_COMMON_MANAGER, com.baidu.tieba.tbadkCore.util.d.class);
        if (runTask != null && (dVar = (com.baidu.tieba.tbadkCore.util.d) runTask.getData()) != null) {
            dVar.destroy();
        }
    }
}
