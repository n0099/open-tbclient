package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes8.dex */
public class e implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId les = BdUniqueId.gen();
    public static int let = 3;
    private static boolean lew = false;
    private static String lex;
    public String cardId;
    public boolean leh = false;
    public boolean lei = true;
    private d leo;
    public VipSpecialList leu;
    private List<f> lev;

    public e(VipSpecialList vipSpecialList) {
        String str;
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.leu = vipSpecialList;
            this.leo = new d();
            this.leo.Ea(4);
            this.leo.setCategoryName(vipSpecialList.class_name);
            this.leo.Nk(vipSpecialList.class_url_name);
            this.leo.Nl(vipSpecialList.class_url);
            if (TbadkCoreApplication.isLogin()) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = "temp";
            }
            if (StringUtils.isNull(lex) || !lex.equals(str)) {
                lew = false;
                lex = str;
            }
            this.lev = new ArrayList();
            for (int i = 0; i < vipSpecialList.item.size(); i++) {
                this.lev.add(new f(vipSpecialList.item.get(i)));
                if (lew) {
                    if (i == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > let) {
                        this.lev.add(new f(true, true));
                    }
                } else if (i == let - 1 && vipSpecialList.item.size() > let) {
                    this.lev.add(new f(true, false));
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return les;
    }
}
