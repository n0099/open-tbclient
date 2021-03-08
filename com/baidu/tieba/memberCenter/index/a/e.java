package com.baidu.tieba.memberCenter.index.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetVipInfo.VipSpecialList;
/* loaded from: classes8.dex */
public class e implements com.baidu.adp.widget.ListView.n {
    public static final BdUniqueId loP = BdUniqueId.gen();
    public static int loQ = 3;
    private static boolean loT = false;
    private static String loU;
    public String cardId;
    public boolean loF = false;
    public boolean loG = true;
    private d loL;
    public VipSpecialList loR;
    private List<f> loS;

    public e(VipSpecialList vipSpecialList) {
        String str;
        this.cardId = "";
        if (vipSpecialList != null && vipSpecialList.item != null && vipSpecialList.item.size() > 0) {
            this.cardId = vipSpecialList.card_id;
            this.loR = vipSpecialList;
            this.loL = new d();
            this.loL.Ev(4);
            this.loL.setCategoryName(vipSpecialList.class_name);
            this.loL.Og(vipSpecialList.class_url_name);
            this.loL.Oh(vipSpecialList.class_url);
            if (TbadkCoreApplication.isLogin()) {
                str = TbadkCoreApplication.getCurrentAccount();
            } else {
                str = "temp";
            }
            if (StringUtils.isNull(loU) || !loU.equals(str)) {
                loT = false;
                loU = str;
            }
            this.loS = new ArrayList();
            for (int i = 0; i < vipSpecialList.item.size(); i++) {
                this.loS.add(new f(vipSpecialList.item.get(i)));
                if (loT) {
                    if (i == vipSpecialList.item.size() - 1 && vipSpecialList.item.size() > loQ) {
                        this.loS.add(new f(true, true));
                    }
                } else if (i == loQ - 1 && vipSpecialList.item.size() > loQ) {
                    this.loS.add(new f(true, false));
                    return;
                }
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return loP;
    }
}
