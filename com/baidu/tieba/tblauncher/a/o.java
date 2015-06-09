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
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    private static o cwH;
    private TbPageContext<?> LH;
    private a cwI;
    private a cwJ;
    private a cwK;
    private a cwL;
    private a cwM;
    private CustomMessageListener cwN = new p(this, 2001309);

    public static o aqF() {
        if (cwH == null) {
            synchronized (o.class) {
                if (cwH == null) {
                    cwH = new o();
                }
            }
        }
        return cwH;
    }

    private o() {
        this.cwN.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(this.cwN);
    }

    public void l(TbPageContext<?> tbPageContext) {
        this.LH = tbPageContext;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001302, com.baidu.tieba.tbadkCore.i.a.class);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001303, com.baidu.tieba.tbadkCore.j.a.class);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001304, com.baidu.tieba.tbadkCore.k.a.class);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001301, com.baidu.tieba.tbadkCore.g.a.class);
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(2001329, com.baidu.tieba.tbadkCore.b.a.class);
        if (runTask != null && runTask.getData() != null) {
            this.cwI = new a(t.my_mark, ((com.baidu.tieba.tbadkCore.i.a) runTask.getData()).ZI(), 1);
        }
        if (runTask2 != null && runTask2.getData() != null) {
            this.cwJ = new a(t.my_history, ((com.baidu.tieba.tbadkCore.j.a) runTask2.getData()).ZT(), 2);
        }
        if (runTask3 != null && runTask3.getData() != null) {
            this.cwK = new a(t.discover_item_mylive, ((com.baidu.tieba.tbadkCore.k.a) runTask3.getData()).getHomeMyLiveIconResId(), 3);
        }
        if (runTask4 != null && runTask4.getData() != null) {
            this.cwL = new a(t.member_center, ((com.baidu.tieba.tbadkCore.g.a) runTask4.getData()).Zg(), 4);
        }
        if (runTask5 != null && runTask5.getData() != null) {
            this.cwM = new a(t.my_good_friends, ((com.baidu.tieba.tbadkCore.b.a) runTask5.getData()).FL(), 0, 0);
        }
    }

    private void a(com.baidu.tbadk.core.message.b bVar) {
        com.baidu.tbadk.core.message.a aVar = new com.baidu.tbadk.core.message.a();
        aVar.SP = bVar;
        aVar.context = this.LH;
        aVar.list = new ArrayList();
        MessageManager.getInstance().dispatchResponsedMessage(new LeftNaviScanMessage(aVar));
    }

    public void b(com.baidu.tbadk.core.message.b bVar) {
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqG() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqH() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(2015005);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqI() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqJ() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aqK() {
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
