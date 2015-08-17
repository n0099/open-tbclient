package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddressListActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private static o cNm;
    private a cNn;
    private a cNo;
    private a cNp;
    private a cNq;
    private a cNr;
    private CustomMessageListener cNs = new p(this, CmdConfigCustom.CMD_LEFT_NAVI_SCAN);

    public static o asg() {
        if (cNm == null) {
            synchronized (o.class) {
                if (cNm == null) {
                    cNm = new o();
                }
            }
        }
        return cNm;
    }

    private o() {
        this.cNs.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(this.cNs);
    }

    public void n(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_COLLECTION_RES_TOOL, com.baidu.tieba.tbadkCore.i.a.class);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_HISTORY_RES_TOOL, com.baidu.tieba.tbadkCore.j.a.class);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_LIVE_RES_TOOL, com.baidu.tieba.tbadkCore.k.a.class);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MEMBER_CENTER_RES_TOOL, com.baidu.tieba.tbadkCore.g.a.class);
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADDRESS_LIST_RES_TOOL, com.baidu.tieba.tbadkCore.b.a.class);
        if (runTask != null && runTask.getData() != null) {
            this.cNn = new a(i.C0057i.my_mark, ((com.baidu.tieba.tbadkCore.i.a) runTask.getData()).abY(), 1);
        }
        if (runTask2 != null && runTask2.getData() != null) {
            this.cNo = new a(i.C0057i.my_history, ((com.baidu.tieba.tbadkCore.j.a) runTask2.getData()).ach(), 2);
        }
        if (runTask3 != null && runTask3.getData() != null) {
            this.cNp = new a(i.C0057i.discover_item_mylive, ((com.baidu.tieba.tbadkCore.k.a) runTask3.getData()).getHomeMyLiveIconResId(), 3);
        }
        if (runTask4 != null && runTask4.getData() != null) {
            this.cNq = new a(i.C0057i.member_center, ((com.baidu.tieba.tbadkCore.g.a) runTask4.getData()).aaH(), 4);
        }
        if (runTask5 != null && runTask5.getData() != null) {
            this.cNr = new a(i.C0057i.my_good_friends, ((com.baidu.tieba.tbadkCore.b.a) runTask5.getData()).Gx(), 0, 0);
        }
    }

    private void a(LeftNaviScanMessage.b bVar) {
        LeftNaviScanMessage.a aVar = new LeftNaviScanMessage.a();
        aVar.XJ = bVar;
        aVar.list = new ArrayList();
        MessageManager.getInstance().dispatchResponsedMessage(new LeftNaviScanMessage(aVar));
    }

    public void b(LeftNaviScanMessage.b bVar) {
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ash() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asi() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asj() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ask() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean asl() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }

    private int a(com.baidu.tieba.tbadkCore.f.a aVar, List<com.baidu.tieba.tbadkCore.f.a> list) {
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
    public void b(com.baidu.tieba.tbadkCore.f.a aVar, List<com.baidu.tieba.tbadkCore.f.a> list) {
        if (aVar != null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(a(aVar, list), aVar);
        }
    }
}
