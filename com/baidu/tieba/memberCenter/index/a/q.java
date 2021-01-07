package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes9.dex */
public class q implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId ljV = BdUniqueId.gen();
    public String cardId;
    public boolean liN = false;
    public boolean liO = true;
    private d liT;
    private List<r> taskList;

    public q(VipTaskList vipTaskList) {
        this.cardId = "";
        if (vipTaskList != null && vipTaskList.item != null) {
            this.cardId = vipTaskList.card_id;
            this.liT = new d();
            this.liT.FG(3);
            this.liT.setCategoryName(vipTaskList.class_name);
            this.liT.Os(vipTaskList.class_url_name);
            this.liT.Ot(vipTaskList.class_url);
            this.taskList = new ArrayList();
            for (VipTaskItem vipTaskItem : vipTaskList.item) {
                this.taskList.add(new r(vipTaskItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return ljV;
    }
}
