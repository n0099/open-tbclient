package com.baidu.tieba.tblauncher.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import com.baidu.tieba.u;
import com.baidu.tieba.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private static p csw;
    private TbPageContext<?> LP;
    private a csA;
    private a csB;
    private CustomMessageListener csC = new q(this, 2001309);
    private a csx;
    private a csy;
    private a csz;

    public static p aoQ() {
        if (csw == null) {
            synchronized (p.class) {
                if (csw == null) {
                    csw = new p();
                }
            }
        }
        return csw;
    }

    private p() {
        this.csC.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(this.csC);
    }

    public void l(TbPageContext<?> tbPageContext) {
        this.LP = tbPageContext;
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2001302, com.baidu.tieba.tbadkCore.i.a.class);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(2001303, com.baidu.tieba.tbadkCore.j.a.class);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(2001304, com.baidu.tieba.tbadkCore.k.a.class);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(2001301, com.baidu.tieba.tbadkCore.g.a.class);
        if (runTask != null && runTask.getData() != null) {
            this.csx = new a(y.my_mark, ((com.baidu.tieba.tbadkCore.i.a) runTask.getData()).Yh(), 1);
        }
        if (runTask2 != null && runTask2.getData() != null) {
            this.csy = new a(y.my_history, ((com.baidu.tieba.tbadkCore.j.a) runTask2.getData()).Ys(), 2);
        }
        if (runTask3 != null && runTask3.getData() != null) {
            this.csz = new a(y.discover_item_mylive, ((com.baidu.tieba.tbadkCore.k.a) runTask3.getData()).getHomeMyLiveIconResId(), 3);
        }
        if (runTask4 != null && runTask4.getData() != null) {
            this.csA = new a(y.member_center, ((com.baidu.tieba.tbadkCore.g.a) runTask4.getData()).XG(), 4);
        }
        this.csB = new a(y.my_good_friends, u.icon_home_friends, 0, 0);
    }

    private void a(com.baidu.tbadk.core.message.b bVar) {
        com.baidu.tbadk.core.message.a aVar = new com.baidu.tbadk.core.message.a();
        aVar.Sg = bVar;
        aVar.context = this.LP;
        aVar.list = new ArrayList();
        MessageManager.getInstance().dispatchResponsedMessage(new LeftNaviScanMessage(aVar));
    }

    public void b(com.baidu.tbadk.core.message.b bVar) {
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoR() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(2015005);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoS() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoT() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aoU() {
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
