package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes9.dex */
public class q implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lnt = BdUniqueId.gen();
    public String cardId;
    public boolean lmk = false;
    public boolean lml = true;
    private d lmq;
    private List<r> taskList;

    public q(VipTaskList vipTaskList) {
        this.cardId = "";
        if (vipTaskList != null && vipTaskList.item != null) {
            this.cardId = vipTaskList.card_id;
            this.lmq = new d();
            this.lmq.Es(3);
            this.lmq.setCategoryName(vipTaskList.class_name);
            this.lmq.NZ(vipTaskList.class_url_name);
            this.lmq.Oa(vipTaskList.class_url);
            this.taskList = new ArrayList();
            for (VipTaskItem vipTaskItem : vipTaskList.item) {
                this.taskList.add(new r(vipTaskItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lnt;
    }
}
