package com.baidu.tieba.personCenter.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.personCenter.g.e;
import com.baidu.tieba.personCenter.g.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.personCenter.g.c eFq;
    private f eFr;
    private e eFs;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!y.t(arrayList) && this.eFq == null) {
                this.eFq = new com.baidu.tieba.personCenter.g.c(context, linearLayout);
            }
            if (this.eFq != null) {
                this.eFq.cE(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.eFr == null) {
                this.eFr = new f(context, linearLayout);
            }
            if (this.eFr != null) {
                this.eFr.pH(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.eFs == null) {
                this.eFs = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.eFs != null) {
                this.eFs.oV(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.eFq != null) {
            this.eFq.onChangeSkinType(i);
        }
        if (this.eFr != null) {
            this.eFr.onChangeSkinType(i);
        }
        if (this.eFs != null) {
            this.eFs.onChangeSkinType(i);
        }
    }
}
