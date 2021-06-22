package com.baidu.tieba.myAttentionAndFans;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyForbiddenFansActivityConfig;
import com.baidu.tbadk.core.atomData.PersonListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.forbidden.fans.MyForbiddenFansActivity;
import d.a.c.e.p.l;
import d.a.n0.d.c;
import d.a.n0.d.d;
import d.a.n0.d.e;
/* loaded from: classes4.dex */
public class PersonListActivityStatic {

    /* loaded from: classes4.dex */
    public static class a implements e {
        @Override // d.a.n0.d.e
        public View a(Context context) {
            TextView a2 = d.a(context);
            if (a2 != null) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                SkinManager.setViewTextColor(a2, R.color.CAM_X0302);
                layoutParams.setMargins(l.g(context, R.dimen.ds8), 0, l.g(context, R.dimen.ds8), 0);
                layoutParams.gravity = 16;
                a2.setLayoutParams(layoutParams);
            }
            return a2;
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PersonListActivityConfig.class, PersonListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(MyForbiddenFansActivityConfig.class, MyForbiddenFansActivity.class);
        a();
    }

    public static void a() {
        c.b().c(5, new a());
    }
}
