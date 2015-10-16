package com.baidu.tieba.tblauncher.a;

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
import com.baidu.tieba.i;
import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class p {
    private static p deb;
    private b dec;
    private b ded;
    private b dee;
    private b def;
    private b deg;
    private b deh;
    private CustomMessageListener dei = new q(this, CmdConfigCustom.CMD_LEFT_NAVI_SCAN);

    public static p azb() {
        if (deb == null) {
            synchronized (p.class) {
                if (deb == null) {
                    deb = new p();
                }
            }
        }
        return deb;
    }

    private p() {
        this.dei.setPriority(Integer.MAX_VALUE);
        MessageManager.getInstance().registerListener(this.dei);
    }

    public void n(TbPageContext<?> tbPageContext) {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_COLLECTION_RES_TOOL, com.baidu.tieba.tbadkCore.h.a.class);
        CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_HISTORY_RES_TOOL, com.baidu.tieba.tbadkCore.i.a.class);
        CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MY_LIVE_RES_TOOL, com.baidu.tieba.tbadkCore.j.a.class);
        CustomResponsedMessage runTask4 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_MEMBER_CENTER_RES_TOOL, com.baidu.tieba.tbadkCore.f.a.class);
        CustomResponsedMessage runTask5 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ADDRESS_LIST_RES_TOOL, com.baidu.tieba.tbadkCore.b.a.class);
        CustomResponsedMessage runTask6 = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_THEME_CENTER_RES_TOOL, com.baidu.tieba.tbadkCore.k.a.class);
        if (runTask != null && runTask.getData() != null) {
            this.dec = new b(i.h.my_mark, ((com.baidu.tieba.tbadkCore.h.a) runTask.getData()).ady(), 1);
        }
        if (runTask2 != null && runTask2.getData() != null) {
            this.ded = new b(i.h.my_history, ((com.baidu.tieba.tbadkCore.i.a) runTask2.getData()).adJ(), 2);
        }
        if (runTask3 != null && runTask3.getData() != null) {
            this.dee = new b(i.h.discover_item_mylive, ((com.baidu.tieba.tbadkCore.j.a) runTask3.getData()).getHomeMyLiveIconResId(), 3);
        }
        if (runTask4 != null && runTask4.getData() != null) {
            this.def = new b(i.h.member_center, ((com.baidu.tieba.tbadkCore.f.a) runTask4.getData()).aca(), 4);
        }
        if (runTask5 != null && runTask5.getData() != null) {
            this.deg = new b(i.h.my_good_friends, ((com.baidu.tieba.tbadkCore.b.a) runTask5.getData()).Gf(), 0, 0);
        }
        if (runTask6 != null && runTask6.getData() != null) {
            com.baidu.tieba.tbadkCore.k.a aVar = (com.baidu.tieba.tbadkCore.k.a) runTask6.getData();
            this.deh = new b(aVar.axy(), aVar.axx(), 5);
        }
    }

    private void a(LeftNaviScanMessage.b bVar) {
        LeftNaviScanMessage.a aVar = new LeftNaviScanMessage.a();
        aVar.dcr = bVar;
        aVar.list = new ArrayList();
        MessageManager.getInstance().dispatchResponsedMessage(new LeftNaviScanMessage(aVar));
    }

    public void b(LeftNaviScanMessage.b bVar) {
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azc() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(AddressListActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azd() {
        return TbadkCoreApplication.m411getInst().appResponseToCmd(CmdConfigCustom.START_EDITMARK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean aze() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azf() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azg() {
        return TbadkCoreApplication.m411getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean azh() {
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
