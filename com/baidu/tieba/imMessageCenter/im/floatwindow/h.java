package com.baidu.tieba.imMessageCenter.im.floatwindow;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends CustomMessageListener {
    final /* synthetic */ b bts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(b bVar) {
        super(2016004);
        this.bts = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z;
        ArrayList arrayList;
        int i;
        a aVar;
        a aVar2;
        if ((customResponsedMessage instanceof MemoryChangedMessage) && !TbadkCoreApplication.m411getInst().isMIUIRom() && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wx()) {
            z = this.bts.isBackground;
            if (!z && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wj() != 0 && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wo()) {
                ImMessageCenterPojo data = ((MemoryChangedMessage) customResponsedMessage).getData();
                if (2 == data.getCustomGroupType() || -7 == data.getCustomGroupType()) {
                    arrayList = this.bts.bti;
                    if (!arrayList.contains(data.getGid())) {
                        if ((com.baidu.tbadk.coreExtra.messageCenter.c.wg().wk() || data.getIsFriend() != 0) && com.baidu.tieba.im.settingcache.j.UQ().aK(TbadkCoreApplication.getCurrentAccount(), data.getGid())) {
                            if (2 == data.getCustomGroupType()) {
                                aVar2 = this.bts.bth;
                                i = aVar2.u(data);
                            } else if (-7 == data.getCustomGroupType()) {
                                aVar = this.bts.bth;
                                i = aVar.v(data);
                            } else {
                                i = 0;
                            }
                            if (i != 0 && i != 3) {
                                this.bts.dt(true);
                            }
                        }
                    }
                }
            }
        }
    }
}
