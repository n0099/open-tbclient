package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes9.dex */
public class e implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId liX = BdUniqueId.gen();
    public static int liY = 3;
    private static boolean ljb = false;
    private static String ljc;
    public String cardId;
    public boolean liN = false;
    public boolean liO = true;
    private d liT;
    public VipSpecialList liZ;
    private List<f> lja;

    public e(VipSpecialList vipSpecialList) {
        String str;
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.liZ = vipSpecialList;
            this.liT = new d();
            this.liT.FG(4);
            this.liT.setCategoryName(vipSpecialList.class_name);
            this.liT.Os(vipSpecialList.class_url_name);
            this.liT.Ot(vipSpecialList.class_url);
            if (TbadkCoreApplication.isLogin()) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = "temp";
            }
            if (StringUtils.isNull(ljc) || !ljc.equals(str)) {
                ljb = false;
                ljc = str;
            }
            this.lja = new ArrayList();
            for (int i = 0; i < vipSpecialList.item.size(); i++) {
                this.lja.add(new f(vipSpecialList.item.get(i)));
                if (ljb) {
                    if (i == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > liY) {
                        this.lja.add(new f(true, true));
                    }
                } else if (i == liY - 1 && vipSpecialList.item.size() > liY) {
                    this.lja.add(new f(true, false));
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return liX;
    }
}
