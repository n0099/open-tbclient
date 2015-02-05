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
    private static k cdN;
    private List<a> aUt = yG();
    private a cdO = new a(z.my_mark, v.icon_home_collect, 0);
    private a cdP = new a(z.my_history, v.icon_home_history, 1);
    private a cdQ = new a(z.discover_item_mylive, v.icon_home_onlive, 2);
    private a cdR = new a(z.member_center, v.icon_home_center, 3);

    public static k ajH() {
        if (cdN == null) {
            synchronized (k.class) {
                if (cdN == null) {
                    cdN = new k();
                }
            }
        }
        return cdN;
    }

    private k() {
    }

    public List<a> getData() {
        this.aUt = yG();
        return this.aUt;
    }

    private List<a> yG() {
        ArrayList arrayList = new ArrayList();
        if (ajI() && this.cdO != null) {
            arrayList.add(this.cdO);
        }
        if (ajJ() && this.cdP != null) {
            arrayList.add(this.cdP);
        }
        if (ajK() && this.cdQ != null) {
            arrayList.add(this.cdQ);
        }
        if (ajL() && this.cdR != null) {
            this.cdR.io(com.baidu.tbadk.core.sharedPref.b.oc().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m255getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
            arrayList.add(this.cdR);
        }
        arrayList.add(new a(z.switch_account, v.icon_home_change, 4));
        arrayList.add(new a(z.app_tieba_exit, v.icon_home_quit, 5));
        return arrayList;
    }

    private boolean ajI() {
        return TbadkCoreApplication.m255getInst().appResponseToCmd(2015005);
    }

    private boolean ajJ() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean ajK() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean ajL() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }
}
