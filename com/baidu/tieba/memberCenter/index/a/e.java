package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes9.dex */
public class e implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId lmI = BdUniqueId.gen();
    public static int lmJ = 3;
    private static boolean lmM = false;
    private static String lmN;
    public String cardId;
    private d lmE;
    public VipSpecialList lmK;
    private List<f> lmL;
    public boolean lmy = false;
    public boolean lmz = true;

    public e(VipSpecialList vipSpecialList) {
        String str;
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.lmK = vipSpecialList;
            this.lmE = new d();
            this.lmE.Es(4);
            this.lmE.setCategoryName(vipSpecialList.class_name);
            this.lmE.Oa(vipSpecialList.class_url_name);
            this.lmE.Ob(vipSpecialList.class_url);
            if (TbadkCoreApplication.isLogin()) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = "temp";
            }
            if (StringUtils.isNull(lmN) || !lmN.equals(str)) {
                lmM = false;
                lmN = str;
            }
            this.lmL = new ArrayList();
            for (int i = 0; i < vipSpecialList.item.size(); i++) {
                this.lmL.add(new f(vipSpecialList.item.get(i)));
                if (lmM) {
                    if (i == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > lmJ) {
                        this.lmL.add(new f(true, true));
                    }
                } else if (i == lmJ - 1 && vipSpecialList.item.size() > lmJ) {
                    this.lmL.add(new f(true, false));
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return lmI;
    }
}
