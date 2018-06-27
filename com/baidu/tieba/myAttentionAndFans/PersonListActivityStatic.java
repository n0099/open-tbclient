package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity;
/* loaded from: classes3.dex */
public class PersonListActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MyForbiddenFansActivityConfig.class, MyForbiddenFansActivity.class);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2902120));
        ato();
    }

    public static void ato() {
        com.baidu.tbadk.ala.b.rM().a(5, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivityStatic.1
            @Override // com.baidu.tbadk.ala.d
            public View aA(Context context) {
                TextView az = com.baidu.tbadk.ala.c.az(context);
                if (az != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    am.h(az, d.C0142d.cp_link_tip_a);
                    layoutParams.setMargins(l.e(context, d.e.ds8), 0, l.e(context, d.e.ds8), 0);
                    layoutParams.gravity = 16;
                    az.setLayoutParams(layoutParams);
                }
                return az;
            }
        });
    }
}
