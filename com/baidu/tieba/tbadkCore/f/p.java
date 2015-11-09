package com.baidu.tieba.tbadkCore.f;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.DressupCenterActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private static p dcO;
    private b dcP;
    private b dcQ;
    private b dcR;
    private b dcS;
    private b dcT;
    private b dcU;
    private CustomMessageListener dcV = new q(this, CmdConfigCustom.CMD_LEFT_NAVI_SCAN);

    public static p ayg() {
        if (dcO == null) {
            synchronized (p.class) {
                if (dcO == null) {
                    dcO = new p();
                }
            }
        }
        return dcO;
    }

    private p() {
        this.dcV.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(this.dcV);
    }

    public void n(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_COLLECTION_RES_TOOL, com.baidu.tieba.tbadkCore.i.a.class);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_HISTORY_RES_TOOL, com.baidu.tieba.tbadkCore.j.a.class);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_LIVE_RES_TOOL, com.baidu.tieba.tbadkCore.k.a.class);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MEMBER_CENTER_RES_TOOL, com.baidu.tieba.tbadkCore.g.a.class);
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADDRESS_LIST_RES_TOOL, com.baidu.tieba.tbadkCore.b.a.class);
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_THEME_CENTER_RES_TOOL, com.baidu.tieba.tbadkCore.l.a.class);
        if (runTask != null && runTask.getData() != null) {
            this.dcP = new b(i.h.my_mark, ((com.baidu.tieba.tbadkCore.i.a) runTask.getData()).adP(), 1);
        }
        if (runTask2 != null && runTask2.getData() != null) {
            this.dcQ = new b(i.h.my_history, ((com.baidu.tieba.tbadkCore.j.a) runTask2.getData()).aea(), 2);
        }
        if (runTask3 != null && runTask3.getData() != null) {
            this.dcR = new b(i.h.discover_item_mylive, ((com.baidu.tieba.tbadkCore.k.a) runTask3.getData()).getHomeMyLiveIconResId(), 3);
        }
        if (runTask4 != null && runTask4.getData() != null) {
            this.dcS = new b(i.h.member_center, ((com.baidu.tieba.tbadkCore.g.a) runTask4.getData()).acr(), 4);
        }
        if (runTask5 != null && runTask5.getData() != null) {
            this.dcT = new b(i.h.my_good_friends, ((com.baidu.tieba.tbadkCore.b.a) runTask5.getData()).FY(), 0, 0);
        }
        if (runTask6 != null && runTask6.getData() != null) {
            com.baidu.tieba.tbadkCore.l.a aVar = (com.baidu.tieba.tbadkCore.l.a) runTask6.getData();
            this.dcU = new b(aVar.ayD(), aVar.ayC(), 5);
        }
    }

    private void a(LeftNaviScanMessage.b bVar) {
        LeftNaviScanMessage.a aVar = new LeftNaviScanMessage.a();
        aVar.XP = bVar;
        aVar.list = new ArrayList();
        MessageManager.getInstance().dispatchResponsedMessage(new LeftNaviScanMessage(aVar));
    }

    public void b(LeftNaviScanMessage.b bVar) {
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayh() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayi() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayj() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayk() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ayl() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aym() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(DressupCenterActivityConfig.class);
    }

    private int a(a aVar, List<a> list) {
        if (aVar == null || list == null) {
            return -1;
        }
        if (list.size() != 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (aVar.getType() < list.get(i).getType()) {
                    return i;
                }
            }
            return size;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar, List<a> list) {
        if (aVar != null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(a(aVar, list), aVar);
        }
    }
}
