package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonListActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2902120));
        asX();
    }

    public static void asX() {
        com.baidu.tbadk.ala.b.rM().a(5, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivityStatic.1
            @Override // com.baidu.tbadk.ala.d
            public View aA(Context context) {
                TextView az = com.baidu.tbadk.ala.c.az(context);
                if (az != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    al.h(az, d.C0141d.cp_link_tip_a);
                    layoutParams.setMargins(l.e(context, d.e.ds8), 0, l.e(context, d.e.ds8), 0);
                    layoutParams.gravity = 16;
                    az.setLayoutParams(layoutParams);
                }
                return az;
            }
        });
    }
}
