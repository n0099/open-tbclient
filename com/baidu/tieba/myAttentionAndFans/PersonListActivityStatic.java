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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class PersonListActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2902120));
        aoR();
    }

    public static void aoR() {
        com.baidu.tbadk.ala.b.or().a(5, new com.baidu.tbadk.ala.d() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivityStatic.1
            @Override // com.baidu.tbadk.ala.d
            public View aq(Context context) {
                TextView ap = com.baidu.tbadk.ala.c.ap(context);
                if (ap != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    ak.h(ap, d.C0126d.cp_link_tip_a);
                    layoutParams.setMargins(l.e(context, d.e.ds8), 0, l.e(context, d.e.ds8), 0);
                    layoutParams.gravity = 16;
                    ap.setLayoutParams(layoutParams);
                }
                return ap;
            }
        });
    }
}
