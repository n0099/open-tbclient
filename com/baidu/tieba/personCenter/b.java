package com.baidu.tieba.personCenter;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes2.dex */
public class b {
    private static b mtB;
    private Context context;

    public static b dwD() {
        if (mtB == null) {
            synchronized (b.class) {
                if (mtB == null) {
                    mtB = new b(TbadkCoreApplication.getInst());
                }
            }
        }
        return mtB;
    }

    public b(Context context) {
        this.context = context;
        UfoSDK.init(context);
        UfoSDK.openRobotAnswer();
        UfoSDK.setContactDialogSwitch(false);
    }

    public void dwE() {
        TbadkCoreApplication.getInst();
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            TbadkCoreApplication.getInst();
            UfoSDK.setUserName(TbadkCoreApplication.getCurrentAccountInfo().getAccount());
        }
        UfoSDK.setUserId(TbadkCoreApplication.getCurrentAccount());
        UfoSDK.setBaiduCuid(TbadkCoreApplication.getInst().getCuidGalaxy2());
        Intent feedbackInputIntent = UfoSDK.getFeedbackInputIntent(this.context, 0);
        feedbackInputIntent.addFlags(268435456);
        this.context.startActivity(feedbackInputIntent);
    }
}
