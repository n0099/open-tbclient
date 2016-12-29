package com.baidu.tieba.personCenter.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.personCenter.g.e;
import com.baidu.tieba.personCenter.g.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c {
    private com.baidu.tieba.personCenter.g.c epl;
    private f epm;
    private e epn;

    public void a(Context context, LinearLayout linearLayout, Bundle bundle) {
        if (context != null && linearLayout != null && bundle != null) {
            linearLayout.setOrientation(0);
            ArrayList arrayList = (ArrayList) bundle.getSerializable("person_center_item_pic");
            if (!x.t(arrayList) && this.epl == null) {
                this.epl = new com.baidu.tieba.personCenter.g.c(context, linearLayout);
            }
            if (this.epl != null) {
                this.epl.cw(arrayList);
            }
            String string = bundle.getString("person_center_item_txt");
            if (!StringUtils.isNull(string) && this.epm == null) {
                this.epm = new f(context, linearLayout);
            }
            if (this.epm != null) {
                this.epm.ow(string);
            }
            if (bundle.getBoolean("person_center_item_red_tip", false) && this.epn == null) {
                this.epn = new e(context, linearLayout);
            }
            boolean z = bundle.getBoolean("person_center_item_red_tip_show", false);
            if (this.epn != null) {
                this.epn.oi(z ? 0 : 8);
            }
        }
    }

    public void onChangeSkinType(int i) {
        if (this.epl != null) {
            this.epl.onChangeSkinType(i);
        }
        if (this.epm != null) {
            this.epm.onChangeSkinType(i);
        }
        if (this.epn != null) {
            this.epn.onChangeSkinType(i);
        }
    }
}
