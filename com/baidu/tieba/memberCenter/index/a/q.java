package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipTaskItem;
import tbclient.GetVipInfo.VipTaskList;
/* loaded from: classes8.dex */
public class q implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lpN = BdUniqueId.gen();
    public String cardId;
    public boolean loF = false;
    public boolean loG = true;
    private d loL;
    private List<r> taskList;

    public q(VipTaskList vipTaskList) {
        this.cardId = "";
        if (vipTaskList != null && vipTaskList.item != null) {
            this.cardId = vipTaskList.card_id;
            this.loL = new d();
            this.loL.Ev(3);
            this.loL.setCategoryName(vipTaskList.class_name);
            this.loL.Og(vipTaskList.class_url_name);
            this.loL.Oh(vipTaskList.class_url);
            this.taskList = new ArrayList();
            for (VipTaskItem vipTaskItem : vipTaskList.item) {
                this.taskList.add(new r(vipTaskItem));
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lpN;
    }
}
