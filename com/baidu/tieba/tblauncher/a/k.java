package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.atomData.MyLiveActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tieba.v;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k {
    private static k ccv;
    private List<a> aTe = yw();
    private a ccw = new a(z.my_mark, v.icon_home_collect, 0);
    private a ccx = new a(z.my_history, v.icon_home_history, 1);
    private a ccy = new a(z.discover_item_mylive, v.icon_home_onlive, 2);
    private a ccz = new a(z.member_center, v.icon_home_center, 3);

    public static k ajq() {
        if (ccv == null) {
            synchronized (k.class) {
                if (ccv == null) {
                    ccv = new k();
                }
            }
        }
        return ccv;
    }

    private k() {
    }

    public List<a> getData() {
        this.aTe = yw();
        return this.aTe;
    }

    private List<a> yw() {
        ArrayList arrayList = new ArrayList();
        if (ajr() && this.ccw != null) {
            arrayList.add(this.ccw);
        }
        if (ajs() && this.ccx != null) {
            arrayList.add(this.ccx);
        }
        if (ajt() && this.ccy != null) {
            arrayList.add(this.ccy);
        }
        if (aju() && this.ccz != null) {
            this.ccz.ij(com.baidu.tbadk.core.sharedPref.b.og().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m255getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
            arrayList.add(this.ccz);
        }
        arrayList.add(new a(z.switch_account, v.icon_home_change, 4));
        arrayList.add(new a(z.app_tieba_exit, v.icon_home_quit, 5));
        return arrayList;
    }

    private boolean ajr() {
        return TbadkCoreApplication.m255getInst().appResponseToCmd(2015005);
    }

    private boolean ajs() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean ajt() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean aju() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }
}
