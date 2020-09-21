package com.baidu.tieba.personCenter;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
public class b {
    private static b lnw;
    private Context context;

    public static b dkd() {
        if (lnw == null) {
            synchronized (b.class) {
                if (lnw == null) {
                    lnw = new b(TbadkCoreApplication.getInst());
                }
            }
        }
        return lnw;
    }

    public b(Context context) {
        this.context = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public void dke() {
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            TbadkCoreApplication.getInst();
            UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
        }
        UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
        UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        this.context.startActivity(UfoSDK.getFeedbackInputIntent(this.context, 0));
    }
}
