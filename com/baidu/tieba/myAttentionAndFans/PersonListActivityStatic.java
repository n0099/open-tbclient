package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ala.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity;
/* loaded from: classes3.dex */
public class PersonListActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MyForbiddenFansActivityConfig.class, MyForbiddenFansActivity.class);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2902120));
        aAm();
    }

    public static void aAm() {
        com.baidu.tbadk.ala.b.vZ().a(5, new e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivityStatic.1
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView bq = com.baidu.tbadk.ala.c.bq(context);
                if (bq != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    al.h(bq, e.d.cp_link_tip_a);
                    layoutParams.setMargins(l.h(context, e.C0210e.ds8), 0, l.h(context, e.C0210e.ds8), 0);
                    layoutParams.gravity = 16;
                    bq.setLayoutParams(layoutParams);
                }
                return bq;
            }
        });
    }
}
