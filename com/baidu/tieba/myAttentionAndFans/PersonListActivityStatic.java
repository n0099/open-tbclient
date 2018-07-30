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
        atS();
    }

    public static void atS() {
        com.baidu.tbadk.ala.b.rx().a(5, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivityStatic.1
            @Override // com.baidu.tbadk.ala.d
            public View aB(Context context) {
                TextView aA = com.baidu.tbadk.ala.c.aA(context);
                if (aA != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    am.h(aA, d.C0140d.cp_link_tip_a);
                    layoutParams.setMargins(l.f(context, d.e.ds8), 0, l.f(context, d.e.ds8), 0);
                    layoutParams.gravity = 16;
                    aA.setLayoutParams(layoutParams);
                }
                return aA;
            }
        });
    }
}
