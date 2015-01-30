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
    private static k cdO;
    private List<a> aUu = yM();
    private a cdP = new a(z.my_mark, v.icon_home_collect, 0);
    private a cdQ = new a(z.my_history, v.icon_home_history, 1);
    private a cdR = new a(z.discover_item_mylive, v.icon_home_onlive, 2);
    private a cdS = new a(z.member_center, v.icon_home_center, 3);

    public static k ajM() {
        if (cdO == null) {
            synchronized (k.class) {
                if (cdO == null) {
                    cdO = new k();
                }
            }
        }
        return cdO;
    }

    private k() {
    }

    public List<a> getData() {
        this.aUu = yM();
        return this.aUu;
    }

    private List<a> yM() {
        ArrayList arrayList = new ArrayList();
        if (ajN() && this.cdP != null) {
            arrayList.add(this.cdP);
        }
        if (ajO() && this.cdQ != null) {
            arrayList.add(this.cdQ);
        }
        if (ajP() && this.cdR != null) {
            arrayList.add(this.cdR);
        }
        if (ajQ() && this.cdS != null) {
            this.cdS.io(com.baidu.tbadk.core.sharedPref.b.oj().getBoolean(new StringBuilder("show_member_new_icon_").append(TbadkCoreApplication.m255getInst().getVersionCode()).append(TbadkCoreApplication.getCurrentAccount()).toString(), true) ? 1 : 0);
            arrayList.add(this.cdS);
        }
        arrayList.add(new a(z.switch_account, v.icon_home_change, 4));
        arrayList.add(new a(z.app_tieba_exit, v.icon_home_quit, 5));
        return arrayList;
    }

    private boolean ajN() {
        return TbadkCoreApplication.m255getInst().appResponseToCmd(2015005);
    }

    private boolean ajO() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(PbHistoryActivityConfig.class);
    }

    private boolean ajP() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(MyLiveActivityConfig.class);
    }

    private boolean ajQ() {
        return TbadkCoreApplication.m255getInst().appResponseToIntentClass(MemberPrivilegeActivityConfig.class);
    }
}
