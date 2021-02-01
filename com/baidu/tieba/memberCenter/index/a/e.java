package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes9.dex */
public class e implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmu = BdUniqueId.gen();
    public static int lmv = 3;
    private static boolean lmy = false;
    private static String lmz;
    public String cardId;
    public boolean lmk = false;
    public boolean lml = true;
    private d lmq;
    public VipSpecialList lmw;
    private List<f> lmx;

    public e(VipSpecialList vipSpecialList) {
        String str;
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.lmw = vipSpecialList;
            this.lmq = new d();
            this.lmq.Es(4);
            this.lmq.setCategoryName(vipSpecialList.class_name);
            this.lmq.NZ(vipSpecialList.class_url_name);
            this.lmq.Oa(vipSpecialList.class_url);
            if (TbadkCoreApplication.isLogin()) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = "temp";
            }
            if (StringUtils.isNull(lmz) || !lmz.equals(str)) {
                lmy = false;
                lmz = str;
            }
            this.lmx = new ArrayList();
            for (int i = 0; i < vipSpecialList.item.size(); i++) {
                this.lmx.add(new f(vipSpecialList.item.get(i)));
                if (lmy) {
                    if (i == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > lmv) {
                        this.lmx.add(new f(true, true));
                    }
                } else if (i == lmv - 1 && vipSpecialList.item.size() > lmv) {
                    this.lmx.add(new f(true, false));
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmu;
    }
}
