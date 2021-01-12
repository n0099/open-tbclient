package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes8.dex */
public class q implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lfq = BdUniqueId.gen();
    public String cardId;
    public boolean leh = false;
    public boolean lei = true;
    private d leo;
    private List<r> taskList;

    public q(VipTaskList vipTaskList) {
        this.cardId = "";
        if (vipTaskList != null && vipTaskList.item != null) {
            this.cardId = vipTaskList.card_id;
            this.leo = new d();
            this.leo.Ea(3);
            this.leo.setCategoryName(vipTaskList.class_name);
            this.leo.Nk(vipTaskList.class_url_name);
            this.leo.Nl(vipTaskList.class_url);
            this.taskList = new ArrayList();
            for (VipTaskItem vipTaskItem : vipTaskList.item) {
                this.taskList.add(new r(vipTaskItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lfq;
    }
}
