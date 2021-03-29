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
import d.b.b.e.p.l;
import d.b.h0.d.b;
import d.b.h0.d.c;
import d.b.h0.d.d;
/* loaded from: classes3.dex */
public class PersonListActivityStatic {

    /* loaded from: classes3.dex */
    public static class a implements d {
        @Override // d.b.h0.d.d
        public View a(Context context) {
            TextView a2 = c.a(context);
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
        b.b().c(5, new a());
    }
}
