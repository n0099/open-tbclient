package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.ala.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity;
/* loaded from: classes10.dex */
public class PersonListActivityStatic {
    public static String Tag = "tag";

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MyForbiddenFansActivityConfig.class, MyForbiddenFansActivity.class);
        bXx();
    }

    public static void bXx() {
        com.baidu.tbadk.ala.b.aOf().a(5, new e() { // from class: com.baidu.tieba.myAttentionAndFans.PersonListActivityStatic.1
            @Override // com.baidu.tbadk.ala.e
            public View createView(Context context) {
                TextView dD = com.baidu.tbadk.ala.c.dD(context);
                if (dD != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    an.setViewTextColor(dD, (int) R.color.cp_link_tip_a);
                    layoutParams.setMargins(l.getDimens(context, R.dimen.ds8), 0, l.getDimens(context, R.dimen.ds8), 0);
                    layoutParams.gravity = 16;
                    dD.setLayoutParams(layoutParams);
                }
                return dD;
            }
        });
    }
}
